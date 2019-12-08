package com.netizenbd.springbootApp.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class ClassDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "s_class_id")
	@SequenceGenerator(name = "s_class_id", sequenceName = "SEQ_CLASS", initialValue = 1001, allocationSize = 50)
	private Integer classId;
	@NonNull
	private String className;
	@NonNull
	private Integer stuTotal;
 

}
