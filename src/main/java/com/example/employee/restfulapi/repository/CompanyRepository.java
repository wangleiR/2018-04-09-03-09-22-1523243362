package com.example.employee.restfulapi.repository;

import com.example.employee.restfulapi.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    //获取company列表
    List<Company> findAll();

    //获取某个具体company
    Company findById(Long id);

    //获取某个具体company下所有employee列表

    //分页查询，page等于1，pageSize等于5
    Page<Company> findAll(Pageable pageable);

    //增加一个company
    Company save(Company company);


}
