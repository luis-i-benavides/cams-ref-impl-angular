package com.accenture.cams.ri.ng.controllers.main;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.cams.ri.ng.common.ApplicationMessage;
import com.accenture.cams.ri.ng.common.RequestResult;
import com.accenture.cams.ri.ng.security.ApplicationUser;

@RestController
@RequestMapping("/LoginComp")
public class LoginCompController {

	@RequestMapping(value = "/LoadLogin", method = RequestMethod.GET)
	public RequestResult<ApplicationUser> getLoadLogin() {
		ApplicationUser applicationUser = new ApplicationUser();
		applicationUser.setIsNotLogged(true);
		applicationUser.setId("c5b4136d-c4cf-454d-8c81-c841234a423d");
		return new RequestResult<ApplicationUser>(applicationUser,
				new ArrayList<ApplicationMessage>());
	}
}