package com.vega.springit.domain;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.URL;
import org.ocpsoft.prettytime.PrettyTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vega.springit.service.BeanUtil;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Link  extends Auditable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NonNull
	@NotEmpty(message = "Please enter a title.")
	private String title;
	
	@NonNull
	@NotEmpty(message = "Please enter a url.")
	@URL(message = "Please enter a valid url.")
	private String url;
	
	//@JsonIgnore
	@OneToMany(mappedBy="link")
	private List<Comment> comments = new ArrayList<Comment>();
	
	@OneToMany(mappedBy = "link")
	private List<Vote> votes = new ArrayList<>();

	private int voteCount = 0;
	
	/*public Link(String title, String url){
		this.title = title;
		this.url = url;
	} */
	
	public void addCommment(Comment comment){
		comments.add(comment);	
		
	}
	
	public String getDomainName() throws URISyntaxException {
	    URI uri = new URI(this.url);
	    String domain = uri.getHost();
	    return domain.startsWith("www.") ? domain.substring(4) : domain;
	}

	public String getPrettyTime() {
	    PrettyTime pt = BeanUtil.getBean(PrettyTime.class);
	    return pt.format(convertToDateViaInstant(getCreationDate()));
	}

	private Date convertToDateViaInstant(LocalDateTime dateToConvert) {
	    return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
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
