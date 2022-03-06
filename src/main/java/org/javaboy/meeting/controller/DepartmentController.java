package org.javaboy.meeting.controller;

import org.javaboy.meeting.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // @GetMapping("/dep")
    // public void getDepById(Integer id) {
    //     Department dep = departmentService.getDepById(id);
    //     System.out.println("dep = " + dep);
    // }

    @RequestMapping("/departments")
    public String departments(Model model) {
        model.addAttribute("deps", departmentService.getAllDep());
        return "departments";
    }

    @PostMapping("/addDepartment")
    public String addDepartment(String departmentname) {
       departmentService.addDepartment(departmentname);
        return "redirect:/admin/departments";
    }

    @PostMapping("/updateDepartment")
    @ResponseBody
    public String updateDepartment(Integer departmentid, String departmentname) {
        Integer result = departmentService.updateDepartment(departmentid, departmentname);
        if (result == 1) {
            return "success";
        }
        return "error";
    }

    @GetMapping("/delDepartment")
    public String delDepartment(Integer departmentid) {
        Integer result = departmentService.delDepartment(departmentid);
        return "redirect:/admin/departments";
    }
}
