package com.mtech.timetable.entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "types_info",uniqueConstraints = {@UniqueConstraint(columnNames = {"typeId", "defaultId"})})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long typeId;
	@NonNull
	private String typeName;
	@NonNull
	private String defaultId;
	
}
