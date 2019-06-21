package com.vega.springit.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Comment {

	@Id
	@GeneratedValue
	private Long id;
	@NonNull
	private String body;
	
	@ManyToOne
	private Link link;
	
	
	
}
