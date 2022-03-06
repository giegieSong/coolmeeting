package org.javaboy.meeting.controller;

import org.apache.ibatis.annotations.Param;
import org.javaboy.meeting.model.Employee;
import org.javaboy.meeting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class EmployeeController {

    public static final Integer PAGE_SIZE = 10;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/searchemployees")
    public String getAllEmployees(Employee employee, @RequestParam(defaultValue = "1") Integer page, Model model) {
        List<Employee> emps = employeeService.getAllEmployees(employee, page, PAGE_SIZE);
        model.addAttribute("emps", emps);

        // 分页
        Long total = employeeService.getTotal(employee);
        model.addAttribute("total", total); // 总页数
        model.addAttribute("page", page); // 当前第几页
        model.addAttribute("pageNum", total % PAGE_SIZE == 0 ? total / PAGE_SIZE : total / PAGE_SIZE + 1); // 分为多少页
        return "searchemployees";
    }

    // 关闭账号
    @RequestMapping("/updateEmp")
    public String updateEmp(@Param("employeeid") Integer id) {
        employeeService.updatestatus(id, 2);
        return "redirect:/admin/searchemployees?status=1";
    }
}
