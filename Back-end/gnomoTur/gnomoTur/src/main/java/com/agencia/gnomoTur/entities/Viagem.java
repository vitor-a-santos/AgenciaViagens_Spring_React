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
public class Viagem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_viagem;
	private String dataIda;
	private String dataVolta;
	
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "viagens")
	private List<Pax> paxs = new ArrayList<Pax>();

	public Viagem() {
		super();
}

	public Viagem(Long id_viagem, String dataIda, String dataVolta) {
		super();
		this.Id_viagem = id_viagem;
		this.dataIda = dataIda;
		this.dataVolta = dataVolta;
		
	}

	public Long getId_viagem() {
		return Id_viagem;
	}

	public void setId_viagem(Long id_viagem) {
		Id_viagem = id_viagem;
	}

	public String getDataIda() {
		return dataIda;
	}

	public void setDataIda(String dataIda) {
		this.dataIda = dataIda;
	}

	public String getDataVolta() {
		return dataVolta;
	}

	public void setDataVolta(String dataVolta) {
		this.dataVolta = dataVolta;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(Id_viagem, dataIda, dataVolta);
	}
	
	
	
	
	public List<Pax> getPaxs() {
		return paxs;
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Viagem other = (Viagem) obj;
		return Objects.equals(Id_viagem, other.Id_viagem) && Objects.equals(dataIda, other.dataIda)
				&& Objects.equals(dataVolta, other.dataVolta);
	}

	
		
}	