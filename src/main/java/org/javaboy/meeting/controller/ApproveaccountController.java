package org.javaboy.meeting.controller;

import org.javaboy.meeting.model.Employee;
import org.javaboy.meeting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ApproveaccountController {

    // 待审批
    public static final Integer PENDING_APPROVE = 0;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/approveaccount")
    public String approveaccount(Model model) {
        List<Employee> employee = employeeService.getAllEmpsByStatus(PENDING_APPROVE);
        model.addAttribute("emps", employee);
        return "approveaccount";
    }

    @RequestMapping("/updatestatus")
    public String updatestatus(Integer employeeid, Integer status) {
        Integer result = employeeService.updatestatus(employeeid, status);
        return "redirect:/admin/approveaccount";
    }


}
