package com.example.employeeservice.FeignClient;

import com.example.employeeservice.dto.ResponseAddress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//http://localhost:8081/address/api/address/1
//servername           //contextpat/endpoint
@FeignClient(name = "jj")
public interface AddressFeignClient {
    @GetMapping("/address/{id}")
    ResponseAddress getAddressByEmpId(@PathVariable("id") int id);
}
