package com.accenture.cams.ri.ng.services.player;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.accenture.cams.ri.ng.domain.entity.Player;

public interface PlayerService {
    Page<Player> findAll(Pageable pageable);
}
