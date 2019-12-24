package com.mtech.timetable.repository;

import java.util.List;
import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


import com.mtech.timetable.entity.GeneralInfo;

@Component
public interface GeneralInfoRepository extends JpaRepository<GeneralInfo, Long> {

Optional<GeneralInfo> findByInfoName(String infoName);
Optional<GeneralInfo> findByInfoId(Long infoId);
List<GeneralInfo> findByTypeDefaultId(String typeDefaultId);

}
