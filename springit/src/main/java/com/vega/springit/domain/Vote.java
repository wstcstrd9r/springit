package com.vega.springit.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Vote {
	
	@Id
	@GeneratedValue
	private Long id;
	@NonNull
	private int vote;
	

}
