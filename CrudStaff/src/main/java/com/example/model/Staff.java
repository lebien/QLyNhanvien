package com.example.model;

import java.util.Date;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "staff")
public class Staff {
	@Id
	@Column(length = 10)
	private String id;
	
	@Column(length = 50)
	private String name;
	
	private String gender;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date birthday;
	
	@Column(length = 500)
	private String photo;
	
	@Column(length = 100)
	private String email;
	
	@Column(length = 12)
	private String phone;
	
	@Column(length = 500)
	private String note;
	
	private Float salary;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "departId")
	private Depart depart;
	
	public Set<Record> getRecords() {
		return record;
	}

	public void setRecords(Set<Record> records) {
		this.record = records;
	}

	@OneToMany(fetch = FetchType.LAZY , mappedBy = "staff")
	private Set<Record> record;

	public Staff(String id, String name, String gender, Date birthday, String photo, String email, String phone,
			String note, Float salary, Depart depart) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.photo = photo;
		this.email = email;
		this.phone = phone;
		this.note = note;
		this.salary = salary;
		this.depart = depart;
	}

	public Staff() {
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public Depart getDepart() {
		return depart;
	}

	public void setDepart(Depart depart) {
		this.depart = depart;
	}

	public Set<Record> getRecord() {
		return record;
	}

	public void setRecord(Set<Record> record) {
		this.record = record;
	}
	
	

}
