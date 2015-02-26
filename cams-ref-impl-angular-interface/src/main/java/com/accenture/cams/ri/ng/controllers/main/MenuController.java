package com.accenture.cams.ri.ng.controllers.main;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.cams.ri.ng.common.ApplicationMessage;
import com.accenture.cams.ri.ng.common.RequestResult;
import com.accenture.cams.ri.ng.services.howToSystemUC.HowToSystemUCService;
import com.accenture.cams.ri.ng.vos.HowToSystemUseCaseVO;

@RestController
@RequestMapping("/Menu")
public class MenuController {

    @Autowired
    Mapper mapper;

    @Autowired
    HowToSystemUCService howToSystemUCService;

    @RequestMapping(value = "/howToSystemUCFindAll", method = RequestMethod.GET)
    public RequestResult<List<HowToSystemUseCaseVO>> howToSystemUCFindAll() {
	List<HowToSystemUseCaseVO> howToSystemUCFindAllVO = new ArrayList<HowToSystemUseCaseVO>();
	mapper.map(howToSystemUCService.howToSystemUCFindAll(), howToSystemUCFindAllVO);
	return new RequestResult<List<HowToSystemUseCaseVO>>(howToSystemUCFindAllVO,
		new ArrayList<ApplicationMessage>());
    }
}
