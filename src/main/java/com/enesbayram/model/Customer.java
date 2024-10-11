package com.enesbayram.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity{

	@Column(name = "first_name" , length = 50)
	private String firstName;
	
	@Column(name = "last_name" , length = 60)
	private String lastName;
	
	@Column(name = "tckn" , length = 11)
	private String tckn;
	
	@Column(name = "birth_of_date")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date birthOfDate;
	
	@OneToOne
	private Address address;
	
	@OneToOne
	private Account account;
	
	
}
