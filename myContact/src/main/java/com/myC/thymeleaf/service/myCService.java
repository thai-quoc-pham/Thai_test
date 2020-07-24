package com.myC.thymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myC.thymeleaf.entity.contact;
import com.myC.thymeleaf.repository.myRepository;

@Service
public class myCService {
	@Autowired
	private myRepository myRepository;

	public List<contact> findAll() {
		return myRepository.findAll();
	}

	public contact findById(int id) {
		return myRepository.findById(id).get();
	}

	public void save(contact contact) {
		myRepository.save(contact);
	}

	public void delete(int id) {
		myRepository.deleteById(id);
	}

}
