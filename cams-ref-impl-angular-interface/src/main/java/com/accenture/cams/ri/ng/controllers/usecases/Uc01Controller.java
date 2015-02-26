package com.accenture.cams.ri.ng.controllers.usecases;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.cams.ri.ng.common.ApplicationMessage;
import com.accenture.cams.ri.ng.common.RequestResult;
import com.accenture.cams.ri.ng.domain.entity.Team;
import com.accenture.cams.ri.ng.services.team.TeamService;

@RestController
@RequestMapping("/Uc01")
public class Uc01Controller {

    @Autowired
    TeamService teamService;

    @RequestMapping(value = "/getTeamWithPlayers", method = RequestMethod.GET)
    public RequestResult<List<Team>> getTeamWithPlayers() {
	List<Team> teams = teamService.getTeamWithPlayers();
	return new RequestResult<List<Team>>(teams, new ArrayList<ApplicationMessage>());
    }
}
