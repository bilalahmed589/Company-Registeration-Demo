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

import com.demo.company.model.Company;
import com.demo.company.service.CompanyService;
import com.demo.company.vo.CompanyVo;
 
@RestController
public class CompanyRestController {
 
    @Autowired
    CompanyService companyService; 
 
    
    //-------------------Retrieve All Company--------------------------------------------------------
     
    @RequestMapping(value = "/company/", method = RequestMethod.GET)
    public ResponseEntity<List<Company>> listAllCustomers() {
        List<Company> customers = companyService.findAllCustomers();
        if(customers.isEmpty()){
            return new ResponseEntity<List<Company>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Company>>(customers, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single Company--------------------------------------------------------
     
    @RequestMapping(value = "/company/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Company> getCustomer(@PathVariable("id") long id) {
        System.out.println("Fetching customer with id " + id);
        Company customers = companyService.findById(id);
        if (customers == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Company>(customers, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a Company--------------------------------------------------------
     
    @RequestMapping(value = "/company/", method = RequestMethod.POST)
    public ResponseEntity<Void> createCustomer(@Validated @RequestBody CompanyVo customer,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Customer " + customer.getUsername());
        
        if(customer.getOwners() == null || customer.getOwners().size() ==0){
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        
        companyService.saveCustomer(customer);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/customer/{id}").buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    //-------------------Create a Company beneficial owners--------------------------------------------------------
    
    @RequestMapping(value = "/company/{id}/beneficialOwner", method = RequestMethod.POST)
    public ResponseEntity<Company> createCustomerOwner(@Validated @RequestBody CompanyVo customerVO,    UriComponentsBuilder ucBuilder) {
        Company customer = companyService.addCompanyBeneficialOwner(customerVO);
 
        return new ResponseEntity<Company>(customer, HttpStatus.CREATED);
    }    
 
    
     
    //------------------- Update a Company --------------------------------------------------------
     
    @RequestMapping(value = "/company/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Company> updateCustomer(@PathVariable("id") long id, @Validated @RequestBody CompanyVo customer) {
        System.out.println("Updating customer " + id);
         
        Company currentCustomer = companyService.findById(id);
         
        if (currentCustomer==null) {
            System.out.println("Company with id " + id + " not found");
            return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
        }
 
        return new ResponseEntity<Company>(companyService.updateCustomer(customer), HttpStatus.OK);
    }
  
}