package com.example.converter;

import org.springframework.stereotype.Component;

import com.example.dto.StaffDTO;
import com.example.model.Staff;

@Component
public class StaffConverter {
	public Staff toEntity(StaffDTO staffDTO) {
		Staff staff = new Staff();
		staff.setId(staffDTO.getId());
		staff.setName(staffDTO.getName());
		staff.setGender(staffDTO.getGender());
		staff.setBirthday(staffDTO.getBirthday());
		staff.setEmail(staffDTO.getEmail());
		staff.setPhone(staffDTO.getPhone());
		staff.setNote(staffDTO.getNote());
		staff.setSalary(staffDTO.getSalary());
		return staff;
	}
	
	public StaffDTO toDTO(Staff staff) {
		StaffDTO staffDTO = new StaffDTO();
		staffDTO.setId(staff.getId());
		staffDTO.setName(staff.getName());
		staffDTO.setGender(staff.getGender());
		staffDTO.setBirthday(staff.getBirthday());
		staffDTO.setEmail(staff.getEmail());
		staffDTO.setPhone(staff.getPhone());
		staffDTO.setNote(staff.getNote());
		staffDTO.setSalary(staff.getSalary());
		return staffDTO;
	}
	
	public Staff toUpdate(Staff staff, StaffDTO staffDTO) {
		staff.setId(staffDTO.getId());
		staff.setName(staffDTO.getName());
		staff.setGender(staffDTO.getGender());
		staff.setBirthday(staffDTO.getBirthday());
		staff.setEmail(staffDTO.getEmail());
		staff.setPhone(staffDTO.getPhone());
		staff.setNote(staffDTO.getNote());
		staff.setSalary(staffDTO.getSalary());
		return staff;
	}
}
