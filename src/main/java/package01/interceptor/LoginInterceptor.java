package package01.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        boolean check = false;
        HttpSession session = request.getSession();
        String loginSession = (String) session.getAttribute("loginSession");
        String url = request.getRequestURI();
        if ("/login".equals(url)) {
            if (loginSession != null) {
                response.sendRedirect(request.getContextPath() + "/list");
            }
            check = true;
        } else {
            if (loginSession != null) {
                check = true;
            } else {
                response.sendRedirect(request.getContextPath() + "/login");
            }
        }
        return check;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {}

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {}
}
