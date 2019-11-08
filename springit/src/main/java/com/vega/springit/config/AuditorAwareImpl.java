package com.vega.springit.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import com.vega.springit.domain.User;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
    	if(SecurityContextHolder.getContext().getAuthentication() == null ||
    			SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")){
    		return Optional.of("master@gmail.com");
    	}
        return Optional.of(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmail());
    }
}
