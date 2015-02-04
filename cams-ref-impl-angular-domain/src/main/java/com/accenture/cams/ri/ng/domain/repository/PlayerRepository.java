package com.accenture.cams.ri.ng.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.accenture.cams.ri.ng.domain.entity.Player;

public interface PlayerRepository extends CrudRepository<Player, String> {
}
