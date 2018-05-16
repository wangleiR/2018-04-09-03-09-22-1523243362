package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    //在此处完成Company API
    @Autowired
    private CompanyRepository companyRepository;

    //获取company列表
    @GetMapping
    public List<Company> getAll(){
        return companyRepository.findAll();
    }

    //获取某个具体company
    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable("id") Long id){
        return companyRepository.findById(id);
    }

    //获取某个具体company下所有employee列表
    @GetMapping("/{id}/employees")
    public List<Employee> getCompanyEmployees(@PathVariable("id") Long id){
        return companyRepository.findById(id).getEmployeeList();
    }

    //分页查询，page等于1，pageSize等于5
    @GetMapping("/page/{page}/pageSize/{pageSize}")
    public List<Company> getCompanyPage(@PathVariable("page") int page, @PathVariable("pageSize") int pageSize){
        return companyRepository.findAll(new PageRequest(page-1,pageSize)).getContent();
    }

    //增加一个company
    @PostMapping
    public Company addCompanyInfo(@RequestBody Company company){
        return companyRepository.save(company);
    }

    //更新某个company
    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable("id") long id, @RequestBody Company company) {
       return companyRepository.exists(id)? companyRepository.save(company): null;
    }

    //删除某个company以及名下所有employees
    @DeleteMapping("/{id}")
    public void deleteCompanyEmployees(@PathVariable("id") Long id){
        companyRepository.delete(id);
    }
}

























