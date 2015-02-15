package com.accenture.cams.ri.ng.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.cams.ri.ng.domain.entity.Team;

public interface TeamRepository extends JpaRepository<Team, String> {
}
