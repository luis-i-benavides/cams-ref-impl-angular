package com.accenture.cams.ri.ng.controllers.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.cams.ri.ng.common.ApplicationMessage;
import com.accenture.cams.ri.ng.common.RequestResult;
import com.accenture.cams.ri.ng.domain.entity.HowToSystemUseCase;
import com.accenture.cams.ri.ng.services.howToSystemUC.HowToSystemUCService;

@RestController
@RequestMapping("/Menu")
public class MenuController {

	@Autowired
	HowToSystemUCService howToSystemUCService;

	@RequestMapping(value = "/howToSystemUCFindAll", method = RequestMethod.GET)
	public RequestResult<List<HowToSystemUseCase>> howToSystemUCFindAll() {
		List<HowToSystemUseCase> howToSystemUCFindAll = howToSystemUCService
				.howToSystemUCFindAll();
		return new RequestResult<List<HowToSystemUseCase>>(
				howToSystemUCFindAll, new ArrayList<ApplicationMessage>());
	}

}
