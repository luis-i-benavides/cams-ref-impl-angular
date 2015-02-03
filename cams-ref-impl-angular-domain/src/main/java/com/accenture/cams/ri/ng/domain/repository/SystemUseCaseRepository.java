package com.accenture.cams.ri.ng.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.accenture.cams.ri.ng.domain.entity.HowToSystemUseCase;

public interface SystemUseCaseRepository extends
		CrudRepository<HowToSystemUseCase, String> {

}
