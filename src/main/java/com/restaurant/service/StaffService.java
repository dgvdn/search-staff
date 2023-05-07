package com.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.model.Staff;
import com.restaurant.repository.StaffRepository;

@Service
public class StaffService {

	@Autowired
	private StaffRepository staffRepository;

	public List<Staff> searchByName(String name) {
		return staffRepository.findByNameContainingIgnoreCase(name);
	}

}
