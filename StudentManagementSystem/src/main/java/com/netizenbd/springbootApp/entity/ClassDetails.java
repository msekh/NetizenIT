package com.netizenbd.springbootApp.entity;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "s_class_id")
	@SequenceGenerator(name = "s_class_id", sequenceName = "SEQ_CLASS", initialValue = 1001, allocationSize = 50)
	private Integer classId;
	@NonNull
	private String className;
	@NonNull
	private Integer stuTotal;
	@OneToMany
	private Set<Course> course;
 

}
