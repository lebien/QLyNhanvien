package com.example.service;

import java.util.List;

import com.example.model.Depart;
import com.example.model.Staff;

public interface StaffService {
	Staff save(Staff staff) ;
	List<Staff> findAll();
	List<Depart> findAllDepart();
	Depart findOneById(String id);
	Staff finOneById(String id);
	void delete(String id);

}
