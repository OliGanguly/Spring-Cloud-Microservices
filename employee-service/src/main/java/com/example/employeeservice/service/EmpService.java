package com.example.employeeservice.service;

import com.example.employeeservice.FeignClient.AddressFeignClient;
import com.example.employeeservice.dto.EmployeeResponse;
import com.example.employeeservice.dto.ResponseAddress;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.repo.EmpoRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class EmpService {
    @Autowired
    private EmpoRepo empoRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AddressFeignClient addressFeignClient;
//    @Autowired
//    private WebClient webClient;
//    private RestTemplate restTemplate;


//    public EmpService( @Value("${addressservice.base.url}") String baseUrl , RestTemplateBuilder builder) {
//        this.restTemplate=
//                         builder
//                        .rootUri(baseUrl)
//                        .build();
//    }


  public EmployeeResponse getEmployeeById(int id){
      //set data by making rest api call
//      ResponseAddress responseAddress = new ResponseAddress();

      //block the code flow until get resp RESTTEMPLATE
     //ResponseAddress responseAddress = callByRestTemplate(id);

      //using webClient WEBCLIENT
      ResponseAddress responseAddress = addressFeignClient.getAddressByEmpId(id);
//              webClient
//              .get()
//              .uri("/address/" + id)
//              .retrieve()
//              .bodyToMono(ResponseAddress.class).block();

      //block the code flow until get resp
      Employee employee = empoRepo.findById(id).get();
      EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
      employeeResponse.setResponseAddress(responseAddress);
      return employeeResponse;
  }
//    private ResponseAddress callByRestTemplate(int id){
//        return restTemplate.getForObject("/address/{id}", ResponseAddress.class, id);
//    }
}

