package com.lucasdev.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasdev.domain.Cidade;
import com.lucasdev.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repo;
	
	public List<Cidade> findCidades(Integer id) {
		return repo.findCidades(id);
	}
	
}
