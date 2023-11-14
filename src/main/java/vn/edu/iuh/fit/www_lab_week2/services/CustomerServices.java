package vn.edu.iuh.fit.www_lab_week2.services;

import vn.edu.iuh.fit.www_lab_week2.models.Customer;
import vn.edu.iuh.fit.www_lab_week2.repositories.CustomerRepository;

import java.util.List;

public class CustomerServices {
    private CustomerRepository customerRepository;

    public CustomerServices() {
        customerRepository = new CustomerRepository();
    }
    public void insertCustomer(Customer customer){
        customerRepository.insertCustomer(customer);
    }
    public void updateCustomer(Customer customer){
        customerRepository.updateCustomer(customer);
    }
    public Customer findById(Long id){
        return customerRepository.findById(id);
    }
    public List<Customer> findAllCustomer(){
        return customerRepository.findAllCustomer();
    }
    public boolean deleteCustomer(Long id){
        Customer customer = customerRepository.findById(id);
        return customerRepository.deteleCustomer(customer);
    }

}
