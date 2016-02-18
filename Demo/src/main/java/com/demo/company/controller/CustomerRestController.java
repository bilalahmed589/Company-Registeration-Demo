package com.demo.company.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.demo.company.model.Customer;
import com.demo.company.service.CustomerService;
import com.demo.company.vo.CustomerVo;
 
@RestController
public class CustomerRestController {
 
    @Autowired
    CustomerService customerService; 
 
    
    //-------------------Retrieve All Customers--------------------------------------------------------
     
    @RequestMapping(value = "/customer/", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> listAllCustomers() {
        List<Customer> customers = customerService.findAllCustomers();
        if(customers.isEmpty()){
            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single Customer--------------------------------------------------------
     
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id) {
        System.out.println("Fetching customer with id " + id);
        Customer customers = customerService.findById(id);
        if (customers == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(customers, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a Customer--------------------------------------------------------
     
    @RequestMapping(value = "/customer/", method = RequestMethod.POST)
    public ResponseEntity<Void> createCustomer(@Validated @RequestBody CustomerVo customer,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Customer " + customer.getUsername());
        
        if(customer.getOwners() == null || customer.getOwners().size() ==0){
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        
        customerService.saveCustomer(customer);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/customer/{id}").buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    //-------------------Create a Company beneficial owners--------------------------------------------------------
    
    @RequestMapping(value = "/customer/{id}/beneficialOwner", method = RequestMethod.POST)
    public ResponseEntity<Customer> createCustomerOwner(@Validated @RequestBody CustomerVo customerVO,    UriComponentsBuilder ucBuilder) {
        Customer customer = customerService.addCompanyBeneficialOwner(customerVO);
 
        return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
    }    
 
    
     
    //------------------- Update a Customer --------------------------------------------------------
     
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @Validated @RequestBody CustomerVo customer) {
        System.out.println("Updating customer " + id);
         
        Customer currentCustomer = customerService.findById(id);
         
        if (currentCustomer==null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
 
        currentCustomer.setUsername(customer.getUsername());
        currentCustomer.setAddress(customer.getAddress());
        currentCustomer.setEmail(customer.getEmail());
        currentCustomer.setCity(customer.getCity());
         
        customerService.updateCustomer(customer);
        return new ResponseEntity<Customer>(currentCustomer, HttpStatus.OK);
    }
  
}