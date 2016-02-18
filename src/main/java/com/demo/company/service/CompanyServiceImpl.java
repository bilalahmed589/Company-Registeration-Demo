package com.demo.company.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.company.model.BeneficialOwners;
import com.demo.company.model.Company;
import com.demo.company.vo.CompanyVo;

@Service("customerService")
@Transactional
public class CompanyServiceImpl implements CompanyService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Company> companies=new ArrayList<Company>();
	
	public List<Company> findAllCustomers() {
		return companies;
	}
	
	public Company findById(long id) {
		for(Company company : companies){
			if(company.getId() == id){
				return company;
			}
		}
		return null;
	}
	
	public void saveCustomer(CompanyVo companyVo) {
		companyVo.setId(counter.incrementAndGet());
		//User builder ideally we should use builder patter here .For now keep thing simple creating object here directly 
		Company company = new Company(companyVo.getId(), companyVo.getName(), companyVo.getAddress(),companyVo.getCity(),companyVo.getCountry(),companyVo.getEmail(),companyVo.getPhone());
		
		for (BeneficialOwners owner : companyVo.getOwners()) {
			BeneficialOwners beneficialOwners = new BeneficialOwners();
			beneficialOwners.setOwnerName(owner.getOwnerName());
			company.getOwners().add(beneficialOwners);
		}
		companies.add(company);
	}
	
	public void updateCustomer(Long id, CompanyVo companyVo) {
		Company company = new Company(companyVo.getId(), companyVo.getName(), companyVo.getAddress(),companyVo.getCity(),companyVo.getCountry(),companyVo.getEmail(),companyVo.getPhone());
		for (BeneficialOwners owner : companyVo.getOwners()) {
			BeneficialOwners beneficialOwners = new BeneficialOwners();
			beneficialOwners.setOwnerName(owner.getOwnerName());
			company.getOwners().add(beneficialOwners);
		}
		int index = companies.indexOf(company);
		companies.set(index, company);
	}
	
	public Company updateCustomer(CompanyVo companyVo) {
		Company company = new Company(companyVo.getId(), companyVo.getName(), companyVo.getAddress(),companyVo.getCity(),companyVo.getCountry(),companyVo.getEmail(),companyVo.getPhone());
		for (BeneficialOwners owner : company.getOwners()) {
			BeneficialOwners beneficialOwners = new BeneficialOwners();
			beneficialOwners.setOwnerName(owner.getOwnerName());
			company.getOwners().add(beneficialOwners);
		}
		int index = companies.indexOf(company);
		companies.set(index, company);
		return company;
	}

	public Company addCompanyBeneficialOwner(CompanyVo customer) {
		
		Company customerObj = findById(customer.getId());
		BeneficialOwners beneficialOwners = new BeneficialOwners();
		beneficialOwners.setOwnerName(customer.getBeneficalOwner());
		customerObj.getOwners().add(beneficialOwners);
		return customerObj; 
	}


}
