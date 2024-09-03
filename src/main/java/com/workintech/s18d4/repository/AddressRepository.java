package com.workintech.s18d4.repository;

import com.workintech.s18d4.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    @Override
    List<Address> findAll();

    @Override
    Optional<Address> findById(Long id);

    Address saveAddress(Address address);

    @Override
    void deleteById(Long id);

    List<Address> findByCity(String city);

    List<Address> findByCountry(String country);


}
