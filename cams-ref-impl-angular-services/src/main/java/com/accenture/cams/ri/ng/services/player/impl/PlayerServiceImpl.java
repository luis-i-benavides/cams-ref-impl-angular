package com.accenture.cams.ri.ng.services.player.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.cams.ri.ng.domain.entity.Player;
import com.accenture.cams.ri.ng.domain.repository.PlayerRepository;
import com.accenture.cams.ri.ng.services.player.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public PlayerServiceImpl() {
	super();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Player> findAll(Pageable pageable) {
	return playerRepository.findAll(pageable);
    }

}
