package com.lucasdev.DTO;

import java.io.Serializable;

import com.lucasdev.domain.Cidade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CidadeDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public CidadeDTO(Cidade obj) {
		super();
		id = obj.getId();
		nome = obj.getNome();
	}
	

}
