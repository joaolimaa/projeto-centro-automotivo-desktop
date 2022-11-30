package com.example.oficinaco.jpa.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.oficinaco.jpa.dao.ServicoDao;
import com.example.oficinaco.jpa.entidade.Servico;

@Component
@SessionScoped
public class ServicoControl {

	@Autowired
	private ServicoDao servicoDao;
	private Servico servico = new Servico();
	private List<Servico> servicos = new ArrayList<>();

	@PostConstruct
	public void init() {
		listar();
	}

	public void salvar() {
		servicoDao.save(servico);
		servico = new Servico();
		listar();
	}

	public void listar() {
		servicos = servicoDao.findAll();
	}

	public void excluir(Integer id) {
		servicoDao.deleteById(id);
		listar();
	}

	public ServicoDao getServicoDao() {
		return servicoDao;
	}

	public void setServicoDao(ServicoDao servicoDao) {
		this.servicoDao = servicoDao;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

}
