package com.myC.thymeleaf.service;


import com.myC.thymeleaf.entity.contact;

public interface myService {
	Iterable<contact> findAll();

	void save(contact contact);

	void delete(contact name);


	contact findById(contact name);

	

}
