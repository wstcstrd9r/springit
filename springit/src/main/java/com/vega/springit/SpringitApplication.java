package com.vega.springit;

import java.util.ArrayList;

import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

import com.vega.springit.config.SpringitProperties;
import com.vega.springit.domain.Comment;
import com.vega.springit.domain.Link;
import com.vega.springit.repository.CommentRepository;
import com.vega.springit.repository.LinkRepository;

@SpringBootApplication
@EnableConfigurationProperties(SpringitProperties.class)
//@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,WebMvcAutoConfiguration.class })
//@EnableJpaAuditing
@EnableTransactionManagement
public class SpringitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringitApplication.class, args);
		System.out.println("Welcome to Springit!1112");
	}
	
	@Bean
	PrettyTime prettyTime(){
		return new PrettyTime();
	}
	
	// TODO * Configuring this bean should not be needed once Spring Boot's Thymeleaf starter includes configuration
	// TODO   for thymeleaf-extras-springsecurity5 (instead of thymeleaf-extras-springsecurity4)
	@Bean
	public SpringSecurityDialect securityDialect() {
	    return new SpringSecurityDialect();
	}
	
	
	
	
	
	
	
	

	/*@Bean
	@Profile("dev")
	CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository){
		return args -> {
			System.out.println("This is something that we only do it dev." );
			Link link = new Link("Getting Started with Spring Boot2", "https://therealdanvega.com/spring-boot-2");
			linkRepository.save(link);
			
			Comment comment = new Comment("This Spring Boot 2 Link is awesome2", link);
			commentRepository.save(comment);
			link.addCommment(comment);
			
			System.out.println("We just inserted a Link and a comment");
			System.out.println("========================================================");
		
 
			System.out.println(link.getTitle() + " 888888");
			Link firstLink = linkRepository.findByTitle("Getting Started with Spring Boot2");
			System.out.println(firstLink.getTitle() + " firstLink");
			ArrayList<Link> firstLinkLike = new ArrayList<Link>();
			firstLinkLike.addAll(linkRepository.findByTitleLike("%Started%"));
			Link link1 = firstLinkLike.get(0);
			System.out.println(link1.getTitle() + "test"); 

		};
	} */
	

}
