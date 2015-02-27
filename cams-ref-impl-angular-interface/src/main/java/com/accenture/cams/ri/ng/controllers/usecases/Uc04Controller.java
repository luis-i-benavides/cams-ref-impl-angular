package com.accenture.cams.ri.ng.controllers.usecases;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.cams.ri.ng.common.ApplicationMessage;
import com.accenture.cams.ri.ng.common.PageRequested;
import com.accenture.cams.ri.ng.common.PagedCollection;
import com.accenture.cams.ri.ng.common.RequestResult;
import com.accenture.cams.ri.ng.domain.entity.Player;
import com.accenture.cams.ri.ng.services.player.PlayerService;
import com.accenture.cams.ri.ng.vos.PlayerVO;

@RestController
@RequestMapping("/Uc04")
public class Uc04Controller {

    @Autowired
    private Mapper mapper;

    @Autowired
    PlayerService playerService;

    @RequestMapping(value = "/getPlayersPaged", method = RequestMethod.POST)
    public RequestResult<PagedCollection<PlayerVO>> getTeamWithPlayers(@RequestBody PageRequested pageRequested) {

	Sort sort = pageRequested.getOrderBy() == null ? null : new Sort(
		pageRequested.isOrderByDirection() ? Sort.Direction.DESC : Sort.Direction.ASC,
		pageRequested.getOrderBy());
	Pageable pageable = new PageRequest(pageRequested.getPage() - 1, pageRequested.getPageSize(), sort);

	Page<Player> playerPage = playerService.findAll(pageable);

	List<PlayerVO> playersVo = new ArrayList<PlayerVO>();
	mapper.map(playerPage.getContent(), playersVo);

	PagedCollection<PlayerVO> pagedPlayers = new PagedCollection<PlayerVO>(
		pageRequested.getPage(),
		pageRequested.getPageSize(), 
		playerPage.getTotalElements(), 
		playersVo, 
		pageRequested.getOrderBy(),
		pageRequested.isOrderByDirection());

	return new RequestResult<PagedCollection<PlayerVO>>(pagedPlayers, new ArrayList<ApplicationMessage>());
    }
}
