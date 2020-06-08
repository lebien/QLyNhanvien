package com.example.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "depart")
public class Depart {
	@Id
	@Column(length = 10)
	private String id;
	
	@Column(length = 50)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "depart")
	private Set<Staff> staff;

	
	public Set<Staff> getStaff() {
		return staff;
	}

	public void setStaff(Set<Staff> staff) {
		this.staff = staff;
	}

	public Depart(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Depart() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
