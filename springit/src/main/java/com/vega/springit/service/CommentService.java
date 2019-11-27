package com.vega.springit.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.vega.springit.domain.Comment;
import com.vega.springit.domain.Link;
import com.vega.springit.repository.CommentRepository;
import com.vega.springit.repository.LinkRepository;
import com.vega.springit.repository.UserRepository;

@Service
public class CommentService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    //private final RoleService roleService;
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        
        this.commentRepository = commentRepository;
    }
    
    public List<Comment> findAll(){
    	return commentRepository.findAll();
    }
    
    public Optional<Comment> findById(Long id){
    	return commentRepository.findById(id);
    }
    
    public Comment save(Comment comment){
    	return commentRepository.save(comment);
    }
    

}