package br.com.db1.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prova", schema = "public")
public class Prova {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nome;
	@Column
	private String tipo;
	@Column
	private String pontosFortes;
	@Column
	private String pontosFracos;
	@Column
	private String parecer;
	@Column
	private Byte avaliacao;
	@Column
	private Date dataAvaliacao;
	@Column
	private Date dataCorrecao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "candidato_id", nullable = false)
	private Candidato candidato;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "avaliador_id", nullable = false)
	private Avaliador avaliador;

	@OneToOne
	private TipoAvaliacao tipoAvaliacao;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "prova")
	private List<ResultadoCriterio> resultadoCriterio;

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPontosFortes() {
		return pontosFortes;
	}

	public void setPontosFortes(String pontosFortes) {
		this.pontosFortes = pontosFortes;
	}

	public String getPontosFracos() {
		return pontosFracos;
	}

	public void setPontosFracos(String pontosFracos) {
		this.pontosFracos = pontosFracos;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	public Byte getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Byte avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public Date getDataCorrecao() {
		return dataCorrecao;
	}

	public void setDataCorrecao(Date dataCorrecao) {
		this.dataCorrecao = dataCorrecao;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Avaliador getAvaliador() {
		return avaliador;
	}

	public void setAvaliador(Avaliador avaliador) {
		this.avaliador = avaliador;
	}

	public TipoAvaliacao getTipoAvaliacao() {
		return tipoAvaliacao;
	}

	public void setTipoAvaliacao(TipoAvaliacao tipoAvaliacao) {
		this.tipoAvaliacao = tipoAvaliacao;
	}

	public List<ResultadoCriterio> getResultadoCriterio() {
		return resultadoCriterio;
	}

	public void setResultadoCriterio(List<ResultadoCriterio> resultadoCriterio) {
		this.resultadoCriterio = resultadoCriterio;
	}

}
