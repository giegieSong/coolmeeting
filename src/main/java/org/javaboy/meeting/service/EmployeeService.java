package org.javaboy.meeting.service;

import org.javaboy.meeting.mapper.EmployeeMapper;
import org.javaboy.meeting.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;


    public Employee doLogin(String username, String password) {

        Employee employee = employeeMapper.loadEmpByUsername(username);

        if (employee == null || !employee.getPassword().equals(password)) {
            return null;
        }

        return employee;
    }

    public Integer doReg(Employee employee) {
        Employee emp = employeeMapper.loadEmpByUsername(employee.getUsername());
        if (emp != null) {
            return -1;
        }
        employee.setRole(1);
        employee.setStatus(0);
        return employeeMapper.doReg(employee);
    }

    public List<Employee> getAllEmpsByStatus(Integer status) {
        return employeeMapper.getAllEmpsByStatus(status);
    }

    public Integer updatestatus(Integer employeeid, Integer status) {
        return employeeMapper.approveaccount(employeeid, status);
    }

    public List<Employee> getAllEmployees(Employee employee, Integer page, Integer pageSize) {
        page = (page - 1) * pageSize;
        return employeeMapper.getAllEmployees(employee, page, pageSize);
    }

    public Long getTotal(Employee employee) {
        return employeeMapper.getTotal(employee);
    }

    public List<Employee> getEmpByDepId(Integer depId) {
        return employeeMapper.getEmpByDepId(depId);
    }
}
