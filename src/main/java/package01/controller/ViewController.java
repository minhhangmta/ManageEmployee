package package01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import package01.common.Common;
import package01.logic.TblUserLogic;

@Controller
public class ViewController {
    @Autowired
    TblUserLogic tblUserLogic;

    @RequestMapping("/view")
    public String view(Model model, HttpServletRequest request) {

        int id = Common.stringToInt(request.getParameter("id"), 1);

        model.addAttribute("id", id);
        return "MH03";
    }

}
