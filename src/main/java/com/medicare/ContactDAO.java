package com.medicare;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ContactDAO {
	@Autowired
	ContactRepo repo;
	//insert a single object
	public Contact insert(Contact s) {
		return repo.save(s);
	}

	//retrieve all the objects
	public List<Contact> getall(){
		return repo.findAll();
	}

	}
