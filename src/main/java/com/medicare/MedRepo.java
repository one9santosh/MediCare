package com.medicare;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MedRepo extends JpaRepository<Medicine,Integer> {

}
