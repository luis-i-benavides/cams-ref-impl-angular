package com.accenture.cams.ri.ng.controllers.usecases;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.cams.ri.ng.common.ApplicationMessage;
import com.accenture.cams.ri.ng.common.RequestResult;
import com.accenture.cams.ri.ng.services.team.TeamService;
import com.accenture.cams.ri.ng.vos.TeamVO;

@RestController
@RequestMapping("/Uc01")
public class Uc01Controller {
    
    @Autowired
    Mapper mapper;

    @Autowired
    TeamService teamService;

    @RequestMapping(value = "/getTeamWithPlayers", method = RequestMethod.GET)
    public RequestResult<List<TeamVO>> getTeamWithPlayers() {
	List<TeamVO> teamsVo = new ArrayList<TeamVO>();
	mapper.map(teamService.getTeamWithPlayers(), teamsVo);
	return new RequestResult<List<TeamVO>>(teamsVo, new ArrayList<ApplicationMessage>());
    }
}
