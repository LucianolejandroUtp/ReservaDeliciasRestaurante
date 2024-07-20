package com.delicias.reserva.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delicias.reserva.servicios.MyUserDetailService;

@RestController
public class LogedUserDetailsController {
    @Autowired
    private MyUserDetailService myUserDetailService;

    @GetMapping("/api/user")
    public UserDetails getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof UserDetails) {

            // String 
            

            return myUserDetailService.loadUserByUsername(((UserDetails) authentication.getPrincipal()).getUsername());


            // return (UserDetails) authentication.getPrincipal();
        }
        return null;
    }

}
