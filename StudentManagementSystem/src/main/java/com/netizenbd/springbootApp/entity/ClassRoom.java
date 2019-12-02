package com.netizenbd.springbootApp.entity;

import javax.persistence.Entity;
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
	@NonNull
	private String code;
	@NonNull
	private String title;
	@NonNull
	private String description;
}
