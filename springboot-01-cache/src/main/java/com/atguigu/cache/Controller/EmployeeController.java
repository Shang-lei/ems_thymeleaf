package com.atguigu.cache.Controller;

import com.atguigu.cache.Employee;
import com.atguigu.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    //查询员工信息
    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id")Integer id){
        Employee employee = employeeService.getEmp(id);
        return employee;
    }

    //修改员工信息
    @GetMapping("/upemp")
    public Employee updateEmp(Employee employee){
        Employee emp = employeeService.updateEmp(employee);
        return emp;
    }

    //删除员工信息
    @GetMapping("/delemp/{id}")
    public void deleteEmp(@PathVariable("id")Integer id){
        employeeService.deleteEmpById(id);
    }

    //根据员工姓名查询员工
    @GetMapping("/emp/lastname/{lastName}")
    public Employee getEmpByLastName(@PathVariable("lastName") String lastName){
        Employee emplastName=employeeService.getEmpByLastName(lastName);
        return emplastName;
    }

}
