package com.medicare;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Data
@Entity
public class Medicine {
	@Id
	private int id;
	private String name;
	private String price;
	@Lob
    private byte[] data;
}
