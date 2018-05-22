package package01.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import package01.interceptor.LoginInterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // Khi nhập url = /login hoặc / trên trình duyệt thì bức tường LoginInterceptor được gọi
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/login").addPathPatterns("/list")
                .addPathPatterns("/view");
    }

}
