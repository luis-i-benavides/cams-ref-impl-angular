package com.accenture.cams.ri.ng.services.howToSystemUC.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.cams.ri.ng.domain.entity.HowToSystemUseCase;
import com.accenture.cams.ri.ng.domain.repository.SystemUseCaseRepository;
import com.accenture.cams.ri.ng.services.howToSystemUC.HowToSystemUCService;

@Service
public class HowToSystemUCServiceImpl implements HowToSystemUCService {

	@Autowired
	private SystemUseCaseRepository systemUseCaseRepository;

	public HowToSystemUCServiceImpl() {
		super();
	}

	@Override
	@Transactional(readOnly = true)
	public List<HowToSystemUseCase> howToSystemUCFindAll() {
		List<HowToSystemUseCase> list = new ArrayList<HowToSystemUseCase>();
		systemUseCaseRepository.findAll().forEach(list::add);
		return list;
	}

}
