package com.demo.company.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;


public class Customer {

	private long id;
	@NotNull
	private String name;
	@NotNull
	private String address;
	@NotNull
	private String city;
	@NotNull(message = "error.title.notnull")
	private String country;
	private String email;
	private String phone;
	private List<BeneficialOwners> owners = new ArrayList<BeneficialOwners>();

	public Customer(long id, String name, String address,String city,String country,String email,String phone){
		this.id = id;
		this.name = name;
		this.address = address;
		this.city=city;
		this.country=country;
		this.email = email;
		this.phone = phone;
	}
	
	
	public List<BeneficialOwners> getOwners() {
		return owners;
	}

	public void setOwners(List<BeneficialOwners> owners) {
		this.owners = owners;
	}

	public Customer(){
		id=0;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Customer))
			return false;
		Customer other = (Customer) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
