package com.mtech.timetable.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class GeneralInfoDTO {
	
	private Long infoId;
	@NonNull
	private String infoName;
	@NonNull
	private String defaultId;
	@NonNull
	private String typeDefaultId;
}
