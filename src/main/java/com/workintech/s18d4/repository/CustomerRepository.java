package com.workintech.s18d4.repository;

import com.workintech.s18d4.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Override
    List<Customer> findAll();

    @Override
    Optional<Customer> findById(Long id);

    Customer saveCustomer(Customer customer);

    @Override
    void deleteById(Long id);

    Customer findByEmail(String email);

    List<Customer> findByLastName(String lastName);
}
