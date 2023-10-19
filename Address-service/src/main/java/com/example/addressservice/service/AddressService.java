package com.example.addressservice.service;

import com.example.addressservice.dto.ResponseAddress;
import com.example.addressservice.entity.Address;
import com.example.addressservice.repo.AddressRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private ModelMapper modelMapper;
    public ResponseAddress getAddressById(int id){
//        System.out.println(addressRepo.findById(id).get());
        Address address = addressRepo.findAddressById(id);
        ResponseAddress data = modelMapper.map(address, ResponseAddress.class);
        return data;
    }


}
