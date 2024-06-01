package com.phone.shop.dto;

import com.phone.shop.entity.PhoneContract;

public class PhoneContractDto {

	public long id;
	public String name;
	public double price;
	public String phoneName;
	
	public PhoneContractDto(PhoneContract phoneContract) {
		id = phoneContract.getId();
		name = phoneContract.getName();
		price = phoneContract.getPrice();
		phoneName = phoneContract.getPhone().getName();
	}
	
	public PhoneContractDto() {
		super();
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPhoneName() {
		return phoneName;
	}

	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}
}
