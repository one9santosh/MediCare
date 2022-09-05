package com.medicare;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MedDAO {
	@Autowired
	MedRepo repo;
	//insert a single object
	public Medicine insert(Medicine s) {
		return repo.save(s);
	}
	
	public Medicine findbyid(Integer id) {
		Medicine rs = repo.findById(id).orElse(null);
		return rs;
	}
	
	//retrieve all the objects
	public List<Medicine> getall(){
		return repo.findAll();
	}
	
	
	//delete
	public String deleteByid(int id) {
		repo.deleteById(id);
		return "deleted the id value:"+id; 
	}
	
	//Update
	public Medicine update(Medicine s) {
		Medicine ss=repo.findById(s.getId()).orElse(null);
		ss.setName(s.getName());
		ss.setPrice(s.getPrice());
		return repo.save(ss);
	}
	
}
