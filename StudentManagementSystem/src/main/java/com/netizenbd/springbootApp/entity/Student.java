package com.netizenbd.springbootApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "s_id_Sequence")
	@SequenceGenerator(name = "s_id_Sequence", sequenceName = "ID_SEQ", initialValue = 1000, allocationSize = 100)
	private Long id;
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	@NonNull
	private Long rollId;
	
	@NonNull
	@ManyToOne
	@JoinColumn(name = "t_id", nullable = false)
	private Teacher teacher;

}
