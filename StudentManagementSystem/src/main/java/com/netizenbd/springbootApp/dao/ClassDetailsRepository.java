package com.netizenbd.springbootApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netizenbd.springbootApp.entity.ClassDetails;

@Repository
public interface ClassDetailsRepository extends JpaRepository<ClassDetails, Integer> {
	List<ClassDetails> findByClassName(String className);
}
