package com.mtech.timetable.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.mtech.timetable.entity.GeneralInfo;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
@AutoConfigureTestDatabase(replace = Replace.NONE)
@EnableJpaRepositories(basePackages = "com.mtech.timetable")
@Slf4j
public class GeneralInfoRepositoryTest {
	/*
	 * @Autowired private TestEntityManager testEn;
	 */

	@Autowired
	private GeneralInfoRepository generalRepo;
	
	
	@Test
	public void testSave() {
//		GeneralInfo info = new GeneralInfo("Sekh Mahadi","C107","T102");
//		//testEn.persist(info);
//		this.generalRepo.save(info);
		log.info("All info -> {}", generalRepo.findAll());
		//log.info("All info -> {}", testEn.find(GeneralInfo.class, 1l));
		
		/*
		 * GeneralInfo infoName = generalRepo.findByInfoName("Sekh Mahadi").get();
		 * assertThat(infoName).isEqualTo("Sekh Mahadi");
		 */
	}
	@Test
	public void testFindByTypeDefaultId() {
		List<GeneralInfo> info = generalRepo.findByTypeDefaultId("T102");

		// assertThat(info).hasSize(3);
		assertThat(info).isNotEmpty();
	}

	

	@Test
	public void findByName() {
		List<GeneralInfo> generalInfos = generalRepo.findAll();
		assertEquals(1, generalInfos.size());
		/*
		 * GeneralInfo infoName = generalRepo.findByInfoId(1l).get();
		 * assertThat(infoName.getInfoName()).isEqualTo("Sekh Mahadi");
		 */
	}

}
