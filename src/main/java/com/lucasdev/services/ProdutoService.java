package com.lucasdev.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.lucasdev.domain.Categoria;
import com.lucasdev.domain.Produto;
import com.lucasdev.repositories.CategoriaRepository;
import com.lucasdev.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository repo;
	@Autowired
	CategoriaRepository catRepo;
	
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new com.lucasdev.services.exception.ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo:" + Produto.class.getName()));
	}

	public Page<Produto> search(String nome, List<Integer> ids, Integer page, 
			Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = catRepo.findAllById(ids);
		return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
	}
}
