package com.accenture.cams.ri.ng.services.team.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.cams.ri.ng.domain.entity.Player;
import com.accenture.cams.ri.ng.domain.entity.Team;
import com.accenture.cams.ri.ng.domain.repository.PlayerRepository;
import com.accenture.cams.ri.ng.domain.repository.TeamRepository;
import com.accenture.cams.ri.ng.services.team.TeamService;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    public TeamServiceImpl() {
	super();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Team> getTeamWithPlayers() {
	List<Team> list = new ArrayList<Team>();
	teamRepository.findAll().forEach(list::add);
	return list;
    }

    @Override
    @Transactional
    public void updatePlayerEF(Player player) {
	playerRepository.save(player);
    }

}
