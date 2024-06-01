package com.phone.shop.entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity(name = "phone")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Phone {
 	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    @Basic(optional = false)
    private String name;

    private Double prepaidPrice;
    
    @OneToMany(mappedBy = "phone")
    @JsonBackReference
    private List<PhoneContract> PhoneContractList;

    public Phone(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.prepaidPrice = price;
    }

    public List<PhoneContract> getPhoneContractList() {
		return PhoneContractList;
	}

	public void setPhoneContractList(List<PhoneContract> phoneContractList) {
		PhoneContractList = phoneContractList;
	}

	public Phone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Double getPrepaidPrice() {
		return prepaidPrice;
	}

	public void setPrepaidPrice(Double prepaidPrice) {
		this.prepaidPrice = prepaidPrice;
	}
}
