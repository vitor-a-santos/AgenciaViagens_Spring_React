package com.agencia.gnomoTur.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pax implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_pax;
	private String nome;
	private String idade;
	private String cpf;
	private String pagamento;
	
	public Pax() {
		super();
			
}
	
	@ManyToOne
	@JoinColumn(name = "Destino_id")
	private Destino destinos;
	
	@ManyToOne
	@JoinColumn(name = "Viagem_id")
	private Viagem viagens;

	public Pax(Long id_pax, String nome, String idade, String cpf, String pagamento, Destino destino, Viagem viagem) {
		super();
		Id_pax = id_pax;
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.pagamento = pagamento;
		this.destinos = destino;
		this.viagens = viagem;
	}

	public Long getId_pax() {
		return Id_pax;
	}

	public void setId_pax(Long id_pax) {
		Id_pax = id_pax;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}

	public Destino getDestino() {
		return destinos;
	}

	public void setDestino(Destino destino) {
		this.destinos = destino;
	}

	public Viagem getViagem() {
		return viagens;
	}

	public void setViagem(Viagem viagem) {
		this.viagens = viagem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id_pax);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pax other = (Pax) obj;
		return Objects.equals(Id_pax, other.Id_pax);
	}
	
	
	
}


