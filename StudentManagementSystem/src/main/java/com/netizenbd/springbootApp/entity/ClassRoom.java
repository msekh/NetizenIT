package com.netizenbd.springbootApp.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class ClassRoom {
	@Id
	@GeneratedValue
	private Integer roomId;
	@NonNull
	private String roomNo;
	@NonNull
	private Integer capasity;
	@NonNull
	private String description;
	
}
