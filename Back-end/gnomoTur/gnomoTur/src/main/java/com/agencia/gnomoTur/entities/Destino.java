package com.agencia.gnomoTur.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Destino implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_destino;
	private String cidade;
	private String estado;
	private String preco;
	

	
	
	@JsonIgnore
	@OneToMany(mappedBy = "destinos")
	private List<Pax> paxs = new ArrayList<Pax>();
	

	public Destino() {
		super();
}

	public Destino(Long id_destino, String cidade, String estado, String preco) {
		super();
		this.Id_destino = id_destino;
		this.cidade = cidade;
		this.estado = estado;
		this.preco = preco;
	}

	public Long getId_destino() {
		return Id_destino;
	}

	public void setId_destino(Long id_destino) {
		Id_destino = id_destino;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}
	
	public List<Pax> getPaxs() {
		return paxs;
		
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(Id_destino);
	}
	
	
	
	
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Destino other = (Destino) obj;
		return Objects.equals(Id_destino, other.Id_destino);
	}

	
	
	
}	
