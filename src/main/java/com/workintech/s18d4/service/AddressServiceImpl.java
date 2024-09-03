package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AddressServiceImpl implements AddressService{


    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address createAddress(Address address) {
        return addressRepository.saveAddress(address);
    }

    @Override
    public Address updateAddress(Long id, Address address) {
        if (!addressRepository.existsById(id)) {
            throw new RuntimeException("Address not found");
        }
        address.setId(id);
        address.setStreet(address.getStreet());
        address.setNo(address.getNo());
        address.setCity(address.getCity());
        address.setCountry(address.getCountry());
        address.setCustomer(address.getCustomer());
        address.setDescription(address.getDescription());
        return addressRepository.saveAddress(address);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
