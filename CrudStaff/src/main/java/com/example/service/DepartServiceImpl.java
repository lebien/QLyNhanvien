package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Depart;
import com.example.repository.DepartRepository;

@Service
public class DepartServiceImpl implements DepartService {
	@Autowired
	private DepartRepository dpr;

	@Override
	public Depart findOneById(String id) {	
		return dpr.findOneById(id);
	}

	@Override
	public List<Depart> listDepart() {
		
		return dpr.findAll();
	}

}
