package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Depart;

public interface DepartRepository extends JpaRepository<Depart, String>{
	Depart findOneById(String id);
	List<Depart> findAll();
}
