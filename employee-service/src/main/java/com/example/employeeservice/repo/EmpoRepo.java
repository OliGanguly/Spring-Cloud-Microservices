package com.example.employeeservice.repo;

import com.example.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpoRepo extends JpaRepository<Employee,Integer> {
}
