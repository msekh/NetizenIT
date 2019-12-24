package com.mtech.timetable.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mtech.timetable.dto.GeneralInfoDTO;
import com.mtech.timetable.dto_convert.DtoCoverter;
import com.mtech.timetable.repository.GeneralInfoRepository;
import com.mtech.timetable.service.GeneralInfoServiceImpl;

@RestController
public class GeneralInfoController {
	@Autowired
	private GeneralInfoServiceImpl generalInfoServiceImpl;
	@Autowired
	private GeneralInfoRepository generalRepo;

	@PostMapping("/create_general_info")
	public ResponseEntity<GeneralInfoDTO> createGeneralInfo(@RequestBody GeneralInfoDTO dto) {
		return ResponseEntity.ok().body(generalInfoServiceImpl.createGeneralInfo(dto));
	}

	@GetMapping("/all_general_Info")
	public ResponseEntity<List<GeneralInfoDTO>> getAllGeneralInfo() {
		List<GeneralInfoDTO> generalInfoDTOs = generalInfoServiceImpl.getAllGeneralInfo().stream()
				.map(DtoCoverter::toConvertGeneralInfoDTOFromGeneralInfo).collect(Collectors.toList());
		return ResponseEntity.ok().body(generalInfoDTOs);
	}
}
