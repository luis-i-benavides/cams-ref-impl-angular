package com.accenture.cams.ri.ng.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.cams.ri.ng.domain.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, String> {
	Page<Player> findAll(Pageable pageable);
}
