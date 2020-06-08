package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, String> {
	List<Staff> findAll();
	Staff findOneById(String id);
}
