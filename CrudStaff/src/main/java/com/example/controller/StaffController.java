package com.example.controller;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.dto.StaffDTO;
import com.example.model.Depart;
import com.example.model.Staff;
import com.example.service.DepartService;
import com.example.service.StaffService;

@Controller
@RequestMapping("/staff")
public class StaffController {
	@Autowired
	private StaffService staffService;
	@Autowired
	private DepartService departService;
	
	@RequestMapping("/list")
	public String listStaff(ModelMap model) {
		model.addAttribute("list", staffService.findAll());
		return "staff/view";
	}
	
	@GetMapping("/add")
	public String add(ModelMap model) {
		StaffDTO staffDTO = new StaffDTO();
		model.addAttribute("StaffDTO", staffDTO);
		return "staff/addOrEdit";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("StaffDTO") StaffDTO staffDTO,ModelMap model) {
		Staff oldStaff = staffService.finOneById(staffDTO.getId());
		Staff newStaff = null;
		String image = "Logo.png";
		Path path = Paths.get("upload");
		if(oldStaff != null) {
			if(staffDTO.getPhoto().isEmpty()) {
				image = oldStaff.getPhoto();
			}else {
				try { 
					InputStream inputStream = staffDTO.getPhoto().getInputStream(); 
					Files.copy(inputStream, path.resolve(staffDTO.getPhoto().getOriginalFilename()),
					 StandardCopyOption.REPLACE_EXISTING); 
					image = staffDTO.getPhoto().getOriginalFilename().toString(); 
					}catch (Exception e) {
					  e.printStackTrace(); 
					}
			}
			
		}else {
			if(!staffDTO.getPhoto().isEmpty()) {
				try { 
					InputStream inputStream = staffDTO.getPhoto().getInputStream(); 
					Files.copy(inputStream, path.resolve(staffDTO.getPhoto().getOriginalFilename()),
					 StandardCopyOption.REPLACE_EXISTING); 
					image = staffDTO.getPhoto().getOriginalFilename().toString(); 
					}catch (Exception e) {
					  e.printStackTrace(); 
					}
				}
		}
		newStaff = new Staff(staffDTO.getId(),staffDTO.getName(),staffDTO.getGender(),staffDTO.getBirthday(),
				image,staffDTO.getEmail(),staffDTO.getPhone(),staffDTO.getNote(),staffDTO.getSalary(),new Depart(staffDTO.getDepartId(),""));
		staffService.save(newStaff);
		return "staff/addOrEdit";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(ModelMap model, @PathVariable(name = "id") String id) {
		Staff st = staffService.finOneById(id);
		StaffDTO dto = null;
		if(st != null) {
			File file = new File("upload/" + st.getPhoto());
			FileInputStream input;
			try {
				input = new FileInputStream(file);
				MultipartFile multiphoto = 
				new MockMultipartFile("file", file.getName(),"text/plain",
						IOUtils.toByteArray(input));
				dto = new StaffDTO(st.getId(),st.getName(),st.getGender(),st.getBirthday(),
						multiphoto,st.getEmail(),st.getPhone(),st.getNote(),
						st.getSalary(),st.getDepart().getId());
				model.addAttribute("StaffDTO", dto);
				
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return "staff/addOrEdit";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(ModelMap model, @PathVariable(name="id") String id) {
		staffService.delete(id);
		model.addAttribute("list", staffService.findAll());
		return "redirect:/staff/list";
	}
	
	
	@ModelAttribute(name = "listDepart")
	public List<Depart> getDepart(){
		return staffService.findAllDepart();
	}
}
