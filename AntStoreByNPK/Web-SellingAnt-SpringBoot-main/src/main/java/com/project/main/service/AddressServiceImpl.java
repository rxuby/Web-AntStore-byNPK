package com.project.main.service;

import org.springframework.stereotype.Service;

import com.project.main.entity.Address;
import com.project.main.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class AddressServiceImpl implements AddressService{



    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void saveAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public Address getAddressById(int id) {
        return addressRepository.findById(id).get();
    }

    @Override
    public void deleteAddressById(int id) {
        addressRepository.deleteById(id);
    }

    @Override
    public void updateAddress(Address address) {
         addressRepository.save(address);
    }



}

