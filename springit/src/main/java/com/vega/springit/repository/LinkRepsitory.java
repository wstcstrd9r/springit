package com.vega.springit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vega.springit.domain.Link;

public interface LinkRepsitory extends JpaRepository<Link, Long> {
	
	Link findByTitle(String title);
    
}
