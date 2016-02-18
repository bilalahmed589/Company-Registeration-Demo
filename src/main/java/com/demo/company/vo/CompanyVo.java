package com.demo.company.vo;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.demo.company.model.BeneficialOwners;


public class CompanyVo {

	private long id;
	@NotNull(message = "error.name.notnull")
	private String name;
	@NotNull(message = "error.address.notnull")
	private String address;
	@NotNull(message = "error.city.notnull")
	private String city;
	@NotNull(message = "error.country.notnull")
	private String country;
	private String email;
	private String phone;
	private String beneficalOwner;
	private List<BeneficialOwners> owners = new ArrayList<BeneficialOwners>();
	
	public List<BeneficialOwners> getOwners() {
		return owners;
	}

	public void setOwners(List<BeneficialOwners> owners) {
		this.owners = owners;
	}

	public CompanyVo(){
		id=0;
	}
	
	public CompanyVo(long id, String name, String address, String email){
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getUsername() {
		return name;
	}

	public void setUsername(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getBeneficalOwner() {
		return beneficalOwner;
	}

	public void setBeneficalOwner(String beneficalOwner) {
		this.beneficalOwner = beneficalOwner;
	}
}
