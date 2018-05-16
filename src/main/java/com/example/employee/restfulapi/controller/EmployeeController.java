package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    //在此处完成Employee API

    @Autowired
    private EmployeeRepository employeeRepository;

    //获取employee列表
    @GetMapping
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    //获取某个具体employee
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id){
        return employeeRepository.findOne(id);
    }


    //筛选出所有男性Employee
    @GetMapping("/male")
    public List<Employee> getMaleEmployee(){
        return employeeRepository.findByGender("male");
    }

    //分页查询，page等于1，pageSize等于5
    @GetMapping("/page/{page}/pageSize/{pageSize}")
    public List<Employee> getEmployeePage(@PathVariable("page") int page, @PathVariable("pageSize") int pageSize){
        return employeeRepository.findAll(new PageRequest(page-1,pageSize)).getContent();
    }

    //增加一个employee
    @PostMapping
    public Employee addEmployeeInfo(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    //更新某个employee
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
        return employeeRepository.exists(id)? employeeRepository.save(employee): null;
    }

    //删除某个employee
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") Long id){
        employeeRepository.delete(id);
    }






}
