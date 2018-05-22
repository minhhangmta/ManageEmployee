package package01.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import package01.common.Common;
import package01.validate.LoginValidate;

@Controller
public class LoginController {

    @Autowired
    private LoginValidate loginValidate;

    @RequestMapping(value = {"/", "/login"})
    public String mh01() {
        return "MH01";
    }

    @PostMapping(value = {"/login"})
    public String login(Model model, HttpServletRequest request) {

        String loginname = Common.convertStringNull(request.getParameter("loginname"));
        String password = Common.convertStringNull(request.getParameter("password"));
        String tagret;

        List<String> listErr = loginValidate.checkLogin(loginname, password);
        if (listErr.isEmpty()) {
            HttpSession session = request.getSession();
            session.setAttribute("loginSession", loginname);
            tagret = "redirect:/list";
        } else {
            model.addAttribute("loginname", loginname);
            model.addAttribute("listErr", listErr);
            tagret = "MH01";
        }

        return tagret;
    }
}
