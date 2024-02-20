package com.project.main.service;

import com.project.main.entity.Address;

public interface AddressService {
    void saveAddress(Address address);
    Address getAddressById(int id);
    void deleteAddressById(int id);
    void updateAddress(Address address);
    
}
