package com.myC.thymeleaf.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myC.thymeleaf.entity.contact;

@Repository
public interface myRepository extends JpaRepository<contact, Integer>{

}
