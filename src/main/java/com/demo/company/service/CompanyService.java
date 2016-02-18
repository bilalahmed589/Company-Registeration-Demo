package com.demo.company.service;

import java.util.List;

import com.demo.company.model.Company;
import com.demo.company.vo.CompanyVo;



public interface CompanyService {
	
	Company findById(long id);
	
	void saveCustomer(CompanyVo company);
	
	Company updateCustomer(CompanyVo company);
	
	void updateCustomer(Long id,CompanyVo company);
	
	List<Company> findAllCustomers();
	
	Company addCompanyBeneficialOwner(CompanyVo company);
	
}
