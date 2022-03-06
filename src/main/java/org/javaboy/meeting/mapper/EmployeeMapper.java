package org.javaboy.meeting.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.javaboy.meeting.model.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    Employee loadEmpByUsername(String username);

    Integer doReg(Employee employee);

    List<Employee> getAllEmpsByStatus(Integer status);

    Integer approveaccount(@Param("employeeid") Integer employeeid, @Param("status") Integer status);

    List<Employee> getAllEmployees(@Param("emp") Employee employee,@Param("page") Integer page,@Param("pageSize") Integer pageSize);

    Long getTotal(Employee employee);

    List<Employee> getEmpByDepId(Integer depId);
}
