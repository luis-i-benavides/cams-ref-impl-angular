package com.accenture.cams.ri.ng.controllers.usecases;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.cams.ri.ng.common.ApplicationMessage;
import com.accenture.cams.ri.ng.common.RequestResult;
import com.accenture.cams.ri.ng.domain.entity.Contract;
import com.accenture.cams.ri.ng.domain.entity.Player;
import com.accenture.cams.ri.ng.services.team.TeamService;
import com.accenture.cams.ri.ng.vos.ContractVO;
import com.accenture.cams.ri.ng.vos.PlayerVO;
import com.accenture.cams.ri.ng.vos.TeamVO;

@RestController
@RequestMapping("/Uc05")
public class Uc05Controller {

    private static final Log log = LogFactory.getLog(Uc05Controller.class);

    @Autowired
    Mapper mapper;

    @Autowired
    TeamService teamService;

    @RequestMapping(value = "/getTeamWithPlayers", method = RequestMethod.GET)
    public RequestResult<List<TeamVO>> getTeamWithPlayers() {

	List<TeamVO> teamsVo = teamService.getTeamWithPlayers().stream().map(s -> mapper.map(s, TeamVO.class))
		.collect(Collectors.<TeamVO> toList());

	return new RequestResult<List<TeamVO>>(teamsVo, new ArrayList<ApplicationMessage>());
    }

    @RequestMapping(value = "/updateContract", method = RequestMethod.POST)
    public RequestResult<Void> updateContract(@RequestBody ContractVO contractVo) {
	Contract contract = mapper.map(contractVo, Contract.class);
	log.info("Updating contract " + contract.getId());
	return new RequestResult<Void>(null, new ArrayList<ApplicationMessage>());
    }

    @RequestMapping(value = "/updatePlayerEF", method = RequestMethod.POST)
    public RequestResult<Void> updateContractEF(@RequestBody PlayerVO playerVo) {
	log.info("UpdatePlayerEF. Player: " + playerVo);
	Player player = mapper.map(playerVo, Player.class);
	teamService.updatePlayerEF(player);
	return new RequestResult<Void>(null, new ArrayList<ApplicationMessage>());
    }

}
