package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.saveCustomer(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        if(!customerRepository.existsById(id)){
            throw new RuntimeException("Customer not found");
        }
        customer.setId(id);
        customer.setAccounts(customer.getAccounts());
        customer.setAddress(customer.getAddress());
        customer.setEmail(customer.getEmail());
        customer.setSalary(customer.getSalary());
        customer.setFirstName(customer.getFirstName());
        customer.setLastName(customer.getLastName());
        return customerRepository.saveCustomer(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
