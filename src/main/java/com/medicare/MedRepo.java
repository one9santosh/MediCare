package com.medicare;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MedRepo extends JpaRepository<Medicine,Integer> {

	//search
	public List<Medicine> findByNameContaining(String name);
}
