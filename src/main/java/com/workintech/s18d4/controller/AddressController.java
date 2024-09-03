package com.workintech.s18d4.controller;

import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {
    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

        @GetMapping
        public List<Address> getAllAddresses(){
        return addressService.getAllAddresses();
        }

        @GetMapping("/{id}")
        public Optional<Address> getAddressById(@PathVariable  Long id){
        return addressService.getAddressById(id);
        }

        @PostMapping
        public Address save(@RequestBody Address address){
        return addressService.createAddress(address);
        }

        @PutMapping("/{id}")
        public Address update(@PathVariable Long id,  @RequestBody Address address){
        return addressService.updateAddress(id, address);
        }

        @DeleteMapping("/{id}")
        public void deleteAddress(@PathVariable Long id){
        addressService.deleteAddress(id);
        }




}
