package com.lucasdev.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;
	private String nome;
	private Double preco;
	
	@ManyToMany
	@JoinTable(name = "produto_categoria",
	joinColumns = @JoinColumn(name = "produto_id"),
	inverseJoinColumns = @JoinColumn(name = "categoria_id")
			)
	@JsonIgnore
	private List<Categoria> categorias = new ArrayList<Categoria>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.produto")
	private Set<ItemPedido> itens = new HashSet<ItemPedido>();
	
	public Produto(Integer id, String nome, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
	
	@JsonIgnore
	public List<Pedido> getPedidos() {
		List<Pedido> lista = new ArrayList<Pedido>();
		for(ItemPedido x: itens) {
			lista.add(x.getPedido());
		}
		return lista;
	}
	
}
