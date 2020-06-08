package com.example.service;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.converter.StaffConverter;
import com.example.dto.StaffDTO;
import com.example.model.Depart;
import com.example.model.Staff;
import com.example.repository.DepartRepository;
import com.example.repository.StaffRepository;

@Service
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffRepository str;
	@Autowired
	private DepartRepository dpr;
	@Autowired StaffConverter staffConverter;

	/*
	 * @Override public StaffDTO save(StaffDTO staffDTO) {
	 * 
	 * Staff newStaff = new Staff(); String image = "Logo.png"; Path path =
	 * Paths.get("upload"); if (staffDTO.getId() != null) { //Staff oldStaff =
	 * str.findOneById(staffDTO.getId()); //newStaff =
	 * staffConverter.toUpdate(oldStaff, staffDTO); }else {
	 * if(!staffDTO.getPhoto().isEmpty()) { try { InputStream inputStream =
	 * staffDTO.getPhoto().getInputStream(); Files.copy(inputStream,
	 * path.resolve(staffDTO.getPhoto().getOriginalFilename()),
	 * StandardCopyOption.REPLACE_EXISTING); image =
	 * staffDTO.getPhoto().getOriginalFilename().toString(); }catch (Exception e) {
	 * e.printStackTrace(); } } newStaff = staffConverter.toEntity(staffDTO); }
	 * Depart depart = dpr.findOneById(staffDTO.getDepartId());
	 * newStaff.setDepart(depart); newStaff.setPhoto(image); str.save(newStaff);
	 * return staffConverter.toDTO(newStaff); }
	 */
	

	@Override
	public List<Staff> findAll() {
		return str.findAll();
	}
	
	@Override
	public List<Depart> findAllDepart(){
		return dpr.findAll();
	}
	
	@Override
	public void delete(String id) {
		str.deleteById(id);
	}

	@Override
	public Staff save(Staff staff) {	
		return str.save(staff);
	}

	@Override
	public Depart findOneById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Staff finOneById(String id) {
		
		return str.findOneById(id);
	}
}
