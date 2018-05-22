package package01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddController {
    @RequestMapping(value = {"/add"})
    public String logout(HttpServletRequest request) {
        return "MH04";
    }
}
