package com.restaurant.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.restaurant.model.Staff;
import com.restaurant.repository.StaffRepository;
import com.restaurant.service.StaffService;

@Controller
public class SearchController {

	@Autowired
	private StaffService service;

	@Autowired
	private StaffRepository repository;

	@GetMapping("")
	public String index() {
		return "index";
	}

	@GetMapping("/search")
	public String searchStaffByNamePage(Model model) {
		List<Staff> staffList = repository.findAll();

		model.addAttribute("staffList", staffList);
		return "staff-search"; // the name of the view file
	}

	@PostMapping("/search")
	public String searchStaffByName(@RequestParam String name, Model model) {
		List<Staff> staffList = new ArrayList<>();
		if (name == null || name.isBlank()) {
			staffList = repository.findAll();
		} else {
			staffList = service.searchByName(name);
		}

		model.addAttribute("staffList", staffList);
		return "staff-search"; // the name of the view file
	}

	@GetMapping("/details/{id}")
	public String viewStaffDetails(@PathVariable("id") Long id, Model model) {
		Staff staff = repository.findById(id).get();
		model.addAttribute("staff", staff);
		return "staff-details";
	}
}
