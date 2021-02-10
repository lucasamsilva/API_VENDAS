package com.lucasdev.DTO;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.lucasdev.domain.Cliente;
import com.lucasdev.services.validation.ClienteUpdate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ClienteUpdate
public class ClienteDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Email(message = "Insira um endereço de e-mail válido")
	private String email;
	
	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
	}
	

}
