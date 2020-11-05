package com.nayan.cms.service;

import com.nayan.cms.dao.CustomerDAO;
import com.nayan.cms.exception.CustomerNotFoundException;
import com.nayan.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public Customer addCustomer(Customer customer){
       return customerDAO.save(customer);
    }

    public List<Customer> getCustomers(){
        return customerDAO.findAll();
    }

    public Customer getCustomerbyID(int customerID){
        Optional<Customer> optionalCustomer = customerDAO.findById(customerID);
        if(!optionalCustomer.isPresent())
        {
                throw new CustomerNotFoundException("Customer Records Not Available...");
        }
        return optionalCustomer.get();
    }

    public Customer updateCustomer(int customerId, Customer customer){
        customer.setCustomerId(customerId);
        return customerDAO.save(customer);
  }

    public void deleteCustomer(int customerId){
        customerDAO.deleteById(customerId);
    }
}
