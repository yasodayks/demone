package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Demo;

@Repository
public interface DemoRepository extends JpaRepository<Demo, Integer>{

	
	@Query("update Demo u set u.demodesc = ?1, u.demoname = ?2 where u.id = ?3")
	@Modifying
	@Transactional
	int setDemo(String demodesc, String demoname, int id);	
	
}
