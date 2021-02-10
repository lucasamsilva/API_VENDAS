package com.lucasdev.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.lucasdev.DTO.ClienteDTO;
import com.lucasdev.domain.Cliente;
import com.lucasdev.repositories.ClienteRepository;
import com.lucasdev.resources.exception.FieldMessage;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {
	
	@Autowired
	private ClienteRepository cliRepo;
	
	@Autowired
	private HttpServletRequest request;
	
	@Override
	public void initialize(ClienteUpdate ann) {
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {
		
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		
		Integer uriId =  Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();

		Cliente aux = cliRepo.findByEmail(objDto.getEmail());
		if(aux != null && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("email", "E-mail já cadastrado"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}