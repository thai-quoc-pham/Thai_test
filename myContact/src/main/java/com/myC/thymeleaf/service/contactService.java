package com.myC.thymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myC.thymeleaf.entity.contact;
import com.myC.thymeleaf.repository.myRepository;

@Service
public class contactService implements myService {
	
	  @Autowired
	    private myRepository contactRepository;
 @Override
 public Iterable<contact> findAll() {
     return contactRepository.findAll();
 }


@Override
public void save(contact contact) {
	contactRepository.save(contact);
	
}

@Override
public void delete(contact name) {
	 contactRepository.delete(name);
	
}


@Override
public contact findById(contact name) {
	
	return contactRepository.findAllById(name);
}






}
