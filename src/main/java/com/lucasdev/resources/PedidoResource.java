package com.lucasdev.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucasdev.domain.Categoria;
import com.lucasdev.domain.ItemPedido;
import com.lucasdev.domain.Pedido;
import com.lucasdev.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> find(@PathVariable Integer id) {
		Pedido obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(value = "")
	public ResponseEntity<Categoria> insert(@Valid @RequestBody Pedido obj) {
		for(ItemPedido ip: obj.getItens()) {
			System.out.println(ip.getProduto().getId());
		}
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value = "")
	public ResponseEntity<Page<Pedido>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page
			, @RequestParam(value = "linesPerPage", defaultValue = "5") Integer linesPerPage
			, @RequestParam(value = "orderBy", defaultValue = "instante") String orderBy
			, @RequestParam(value = "direction", defaultValue = "DESC") String direction) {
		Page<Pedido> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
	
}
