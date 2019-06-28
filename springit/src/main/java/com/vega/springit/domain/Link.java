package com.vega.springit.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Link  extends Auditable {
	
	@Id
	@GeneratedValue
	private Long id;
	@NonNull
	private String title;
	@NonNull
	private String url;
	
	@OneToMany(mappedBy="link")
	private List<Comment> comments = new ArrayList<Comment>();
	
	/*public Link(String title, String url){
		this.title = title;
		this.url = url;
	} */
	
	public void addCommment(Comment comment){
		comments.add(comment);	
		
	}
/*
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	*/
	

}
