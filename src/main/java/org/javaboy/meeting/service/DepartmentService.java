package org.javaboy.meeting.service;

import org.javaboy.meeting.mapper.DepartmentMapper;
import org.javaboy.meeting.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public Department getDepById(Integer id) {
        return departmentMapper.getDepById(id);
    }

    public List<Department> getAllDep() {
        return departmentMapper.getAllDep();
    }

    public Integer addDepartment(String departmentname) {
        Department dep = departmentMapper.getDepartmentByName(departmentname);
        if (dep != null) {
            return -1;
        }
        return departmentMapper.addDepartment(departmentname);
    }

    public Integer updateDepartment(Integer departmentid, String departmentname) {
        return departmentMapper.updeteDepartment(departmentid, departmentname);
    }

    public Integer delDepartment(Integer departmentid) {
        return departmentMapper.delDepartment(departmentid);
    }

}
