package com.mtech.timetable.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Accessors(chain = true)
@RequiredArgsConstructor
public class GeneralInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long infoId;
	@NonNull
	private String infoName;
	@NonNull
	private String defaultId;

	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(referencedColumnName = "defaultId")
	 */
	// @Cascade(CascadeType.DELETE)
	@NonNull
	private String typeDefaultId;


}
