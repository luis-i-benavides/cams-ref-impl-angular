package com.accenture.cams.ri.ng.security;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @RequestMapping("/user")
    public Principal user(Principal user) {
	return user;
    }
}
