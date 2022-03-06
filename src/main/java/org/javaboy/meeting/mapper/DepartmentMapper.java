package org.javaboy.meeting.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.javaboy.meeting.model.Department;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    Department getDepById(Integer id);

    List<Department> getAllDep();

    Integer addDepartment(String departmentname);

    Integer updeteDepartment(@Param("departmentid") Integer departmentid, @Param("departmentname") String departmentname);

    Integer delDepartment(Integer departmentid);

    Department getDepartmentByName(String departmentname);

}
