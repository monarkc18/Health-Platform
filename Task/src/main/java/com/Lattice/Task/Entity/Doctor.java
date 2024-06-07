package com.Lattice.Task.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor
{
	@Id
	@GeneratedValue
	private int  docid;
	
	@NotEmpty
	@Size(min=3,message = "Please provide name having atleast 3 character")
	private String name;

	 @NotEmpty
	@Email(message = "Please provide a valid email address")
	private String email;
	
	 @NotEmpty
	 @Size(min = 10,message = "please enter number having 10 digits")
	 @Pattern(regexp="(^$|[0-9]{10})")
	 private String phone_number;

	 @Enumerated(EnumType.STRING)
		private City city;

	 @Enumerated(EnumType.STRING)
	 private Speciality speciality;

}
