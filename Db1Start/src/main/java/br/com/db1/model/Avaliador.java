package br.com.db1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "avaliador", schema = "public")
public class Avaliador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nome;
	@Column
	private String email;

	@Column
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoAvaliacao")
	private Prova avaliador;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Prova getAvaliador() {
		return avaliador;
	}

	public void setAvaliador(Prova avaliador) {
		this.avaliador = avaliador;
	}

}
