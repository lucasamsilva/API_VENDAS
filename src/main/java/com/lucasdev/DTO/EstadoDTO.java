package com.lucasdev.DTO;

import java.io.Serializable;

import com.lucasdev.domain.Estado;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EstadoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	
	public EstadoDTO(Estado obj) {
		super();
		id = obj.getId();
		nome = obj.getNome();
	}

}
