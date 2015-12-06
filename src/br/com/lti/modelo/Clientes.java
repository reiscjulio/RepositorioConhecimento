package br.com.lti.modelo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Clientes {
	
	@Id
	@GeneratedValue	
	private int id;

	@ManyToMany
	private Set<Projetos> projetos;
	
	@ManyToMany
	private Set<Atividade> atividades;	
	
	private String nome;
	private String area;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
}
