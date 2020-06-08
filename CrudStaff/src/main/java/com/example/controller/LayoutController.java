package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/layout")
public class LayoutController {

	@GetMapping("/")
	public String show() {
		return "layout/index";
	}
	@GetMapping("/home")
	public String showHome() {
		return "layout/home";
	}
	@GetMapping("/product")
	public String showProduct() {
		return "layout/product";
	}
	@GetMapping("/contact")
	public String showContact() {
		return "layout/contact";
	}
}
