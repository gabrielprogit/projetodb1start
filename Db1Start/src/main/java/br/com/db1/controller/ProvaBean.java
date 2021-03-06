package br.com.db1.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.db1.dao.impl.ProvaDao;
import br.com.db1.model.Prova;

@ApplicationScoped
@Named
public class ProvaBean {

	@Inject
	private ProvaDao dao;

	private List<Prova> list;

	private String nomeProvaFiltrado;

	private Prova prova;

	@PostConstruct
	public void init() {
		zerarLista();
	}

	private void zerarLista() {
		list = new ArrayList<Prova>();
	}

	public String getNomeCidadeFiltrada() {
		return nomeProvaFiltrado;
	}

	public void setNomeCidadeFiltrada(String nomeCidadeFiltrada) {
		this.nomeProvaFiltrado = nomeCidadeFiltrada;
	}

	public ProvaDao getDao() {
		return dao;
	}

	public void setDao(ProvaDao dao) {
		this.dao = dao;
	}

	public List<Prova> getList() {
		return list;
	}

	public void setList(List<Prova> list) {
		this.list = list;
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public String novo() {
		this.prova = new Prova();
		return "cadastrarProva";
	}

	public String salvar() {
		if (!dao.save(this.prova)) {
			adicionarMensagem("Erro ao cadastrar o prova.", FacesMessage.SEVERITY_ERROR);
		} else {
			adicionarMensagem("Prova salvo com sucesso.", FacesMessage.SEVERITY_INFO);
			nomeProvaFiltrado = this.prova.getNome();
			listarProva();
		}
		return "prova";
	}

	public String editar(Prova prova) {
		this.prova = dao.findById(prova.getId());
		return "cadastrarCidade";
	}

	public String remover(Prova prova) {
		if (!dao.delete(prova.getId())) {
			adicionarMensagem("Erro ao remover o prova.", FacesMessage.SEVERITY_ERROR);
		} else {
			adicionarMensagem("Prova removido com sucesso.", FacesMessage.SEVERITY_INFO);
			listarProva();
		}
		return "prova";
	}

	public void listarProva() {
		zerarLista();
		if (!nomeProvaFiltrado.isEmpty()) {
			list.addAll(dao.findByName(nomeProvaFiltrado));
		} else {
			list.addAll(dao.findAll());
		}
	}

	public void adicionarMensagem(String mensagem, Severity tipoMensagem) {
		FacesContext fc = FacesContext.getCurrentInstance();
		FacesMessage fm = new FacesMessage(mensagem);
		fm.setSeverity(tipoMensagem);
		fc.addMessage(null, fm);

	}

}
