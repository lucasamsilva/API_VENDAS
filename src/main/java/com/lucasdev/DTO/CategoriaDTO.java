package com.lucasdev.DTO;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.lucasdev.domain.Categoria;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	
	@NotEmpty(message = "Nome não pode estar vazio")
	@Length(min = 5, max=80)
	private String nome;
	
	public CategoriaDTO(Categoria obj) {
		id = obj.getId();
		nome = obj.getNome();
	}
	
}
