package com.example.addressservice.repo;

import com.example.addressservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address,Integer> {
    @Query( nativeQuery = true,value = "SELECT ea.id,ea.city,ea.zip FROM `microservices-first`.address ea join `microservices-first`.emp e on e.id=ea.id where ea.emp_id=:empId")
    public Address findAddressById(@Param("empId") int empId);
}
