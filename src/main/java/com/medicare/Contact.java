package com.medicare;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Contact {
	@Id
private String name;
private String mobileNum;
private String email;
private String subject;
private String message;
}
