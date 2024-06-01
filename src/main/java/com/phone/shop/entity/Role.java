package com.phone.shop.entity;

import jakarta.persistence.*;


@Entity(name="role")
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 60)
    private String name;

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

	public Role(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Role() {
		super();
	}
    
}