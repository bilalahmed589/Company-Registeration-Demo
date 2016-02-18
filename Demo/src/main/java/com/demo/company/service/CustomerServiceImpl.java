package com.demo.company.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.company.model.BeneficialOwners;
import com.demo.company.model.Customer;
import com.demo.company.vo.CustomerVo;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Customer> users=new ArrayList<Customer>();
	
	public List<Customer> findAllCustomers() {
		return users;
	}
	
	public Customer findById(long id) {
		for(Customer user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public void saveCustomer(CustomerVo user) {
		user.setId(counter.incrementAndGet());
		//User builder ideally we should use builder patter here .For now keep thing simple creating object here directly 
		Customer company = new Customer(user.getId(), user.getName(), user.getAddress(),user.getCity(),user.getCountry(),user.getEmail(),user.getPhone());
		
		for (BeneficialOwners owner : user.getOwners()) {
			BeneficialOwners beneficialOwners = new BeneficialOwners();
			beneficialOwners.setOwnerName(owner.getOwnerName());
			company.getOwners().add(beneficialOwners);
		}
		users.add(company);
	}
	
	public void updateCustomer(Long id, CustomerVo user) {
		Customer company = new Customer(user.getId(), user.getName(), user.getAddress(),user.getCity(),user.getCountry(),user.getEmail(),user.getPhone());
		for (BeneficialOwners owner : user.getOwners()) {
			BeneficialOwners beneficialOwners = new BeneficialOwners();
			beneficialOwners.setOwnerName(owner.getOwnerName());
			company.getOwners().add(beneficialOwners);
		}
		int index = users.indexOf(company);
		users.set(index, company);
	}
	
	public void updateCustomer(CustomerVo user) {
		Customer company = new Customer(user.getId(), user.getName(), user.getAddress(),user.getCity(),user.getCountry(),user.getEmail(),user.getPhone());
		for (BeneficialOwners owner : user.getOwners()) {
			BeneficialOwners beneficialOwners = new BeneficialOwners();
			beneficialOwners.setOwnerName(owner.getOwnerName());
			company.getOwners().add(beneficialOwners);
		}
		int index = users.indexOf(company);
		users.set(index, company);
	}

	public Customer addCompanyBeneficialOwner(CustomerVo customer) {
		
		Customer customerObj = findById(customer.getId());
		BeneficialOwners beneficialOwners = new BeneficialOwners();
		beneficialOwners.setOwnerName(customer.getBeneficalOwner());
		customerObj.getOwners().add(beneficialOwners);
		return customerObj; 
	}


}
