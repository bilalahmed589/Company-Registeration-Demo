package com.demo.company.service;

import java.util.List;

import com.demo.company.model.Customer;
import com.demo.company.vo.CustomerVo;



public interface CustomerService {
	
	Customer findById(long id);
	
	void saveCustomer(CustomerVo user);
	
	void updateCustomer(CustomerVo user);
	
	void updateCustomer(Long id,CustomerVo user);
	
	List<Customer> findAllCustomers();
	
	Customer addCompanyBeneficialOwner(CustomerVo customer);
	
}
