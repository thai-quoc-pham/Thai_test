package com.myC.thymeleaf.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.myC.thymeleaf.entity.contact;

public interface myRepository extends CrudRepository<contact, String>{
	List<contact> findByNameContaining(String term);
}
