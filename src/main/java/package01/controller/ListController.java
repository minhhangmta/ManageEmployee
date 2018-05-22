package package01.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import package01.logic.TblUserLogic;
import package01.model.EmployeeInfo;

@Controller
public class ListController {

    @Autowired
    TblUserLogic tblUserLogic;

    @RequestMapping("/list")
    public String list(Model model, HttpServletRequest request) {
        List<EmployeeInfo> employeeInfoList = tblUserLogic.getListUserFormated();
        model.addAttribute("employeeInfoList", employeeInfoList);
        return "MH02";
    }

}
