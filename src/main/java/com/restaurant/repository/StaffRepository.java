package com.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.model.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
	List<Staff> findByNameContainingIgnoreCase(String name);
}
