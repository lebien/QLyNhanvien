package com.example.service;

import java.util.List;

import com.example.model.Depart;

public interface DepartService {
	Depart findOneById(String id);
	List<Depart> listDepart();

}
