package com.example.employeeservice.controller;

import com.example.employeeservice.dto.EmployeeResponse;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.repo.EmpoRepo;
import com.example.employeeservice.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/employee/{empId}")
    ResponseEntity<EmployeeResponse> getEmployee(@PathVariable Integer empId){
        EmployeeResponse employeeById = empService.getEmployeeById(empId);
        return ResponseEntity.status(HttpStatus.OK).body(employeeById) ;
       }
}
