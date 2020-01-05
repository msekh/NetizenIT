package com.mtech.timetable.entity;

import java.time.DayOfWeek;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Builder(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Routine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long routineId;
	@NonNull
	@ManyToOne(optional = false)
	//@JoinColumn (name = "routineId",insertable=false, updatable=false) 
	private GeneralInfo period;
	@NonNull
	@ManyToOne(optional = false)
	private GeneralInfo teacher;
	@NonNull
	@ManyToOne(optional = false)
	private GeneralInfo clazz;
	@NonNull
	@ManyToOne(optional = false)
	private GeneralInfo subject;
	@NonNull
	@Enumerated(EnumType.STRING)
	private DayOfWeek day;

}
