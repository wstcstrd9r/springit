package com.vega.springit.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.vega.springit.domain.Link;
import com.vega.springit.repository.LinkRepository;
import com.vega.springit.repository.UserRepository;

@Service
public class LinkService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    //private final RoleService roleService;
    private final LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        
        this.linkRepository = linkRepository;
    }
    
    public List<Link> findAll(){
    	return linkRepository.findAll();
    }
    
    public Optional<Link> findById(Long id){
    	return linkRepository.findById(id);
    }
    
    public Link save(Link link){
    	return linkRepository.save(link);
    }
    

}