package com.example.oficinaco.jpa.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.oficinaco.jpa.dao.OrdemDeServicoDao;
import com.example.oficinaco.jpa.dao.PessoaDao;
import com.example.oficinaco.jpa.dao.PessoaDaoImpl;
import com.example.oficinaco.jpa.dao.ServicoDao;
import com.example.oficinaco.jpa.dao.VeiculoDao;
import com.example.oficinaco.jpa.entidade.OrdemDeServico;
import com.example.oficinaco.jpa.entidade.OrdemDeServicoProduto;
import com.example.oficinaco.jpa.entidade.OrdemDeServicoServico;
import com.example.oficinaco.jpa.entidade.Pessoa;
import com.example.oficinaco.jpa.entidade.Servico;
import com.example.oficinaco.jpa.entidade.Veiculo;

@Component
@SessionScoped
public class OrdemServicoControl {

	private Integer pessoaId;
	private Integer servicoId;
	private Integer funcionarioId;

	@Autowired
	private PessoaDao pessoaDao;

	@Autowired
	private PessoaDaoImpl pessoaDaoImpl;

	@Autowired
	private VeiculoDao veiculoDao;

	@Autowired
	private OrdemDeServicoDao ordemDeServicoDao;

	@Autowired
	private ServicoDao servicoDao;
	private String placa;
	private OrdemDeServico ordemDeServico = new OrdemDeServico();
	private OrdemDeServicoProduto ordemDeServicoProduto = new OrdemDeServicoProduto();
	private OrdemDeServicoServico ordemDeServicoServico = new OrdemDeServicoServico();
	List<OrdemDeServico> ordensDeServicos = new ArrayList<>();

	@PostConstruct
	public void init() {
		listar();
	}

	public void listar() {
		ordensDeServicos = ordemDeServicoDao.findAll();
	}

	public void salvar() {
		ordemDeServicoDao.save(ordemDeServico);
		ordemDeServico = new OrdemDeServico();
		listar();

	}

	public void setVeiculo() {
		Veiculo veiculo = veiculoDao.consultarPorPlaca(placa);
		ordemDeServico.setVeiculo(veiculo);
	}

	public void setServico() {
		Servico servico = servicoDao.findById(servicoId).get();
		ordemDeServicoServico.setServico(servico);
		ordemDeServicoServico.setPreco(servico.getPreco());
	}

	public void addServico() {
		ordemDeServico.getServicos().add(ordemDeServicoServico);
		servicoId = null;
		ordemDeServicoServico = new OrdemDeServicoServico();
	}

	public void removeServico() {
		ordemDeServico.getServicos().remove(ordemDeServicoServico);
		servicoId = null;
		ordemDeServicoServico = new OrdemDeServicoServico();
	}

	public List<Pessoa> completePessoa(String query) {
		return pessoaDaoImpl.listarPorNome("%" + query + "%", null);
	}

	public List<Servico> completeServico(String query) {
		return servicoDao.listarPorNome("%" + query + "%");
	}

	public List<Pessoa> completeFuncionario(String query) {
		return pessoaDaoImpl.listarPorNome("%" + query + "%", true);
	}

	public Integer getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Integer pessoaId) {
		this.pessoaId = pessoaId;
	}

	public Integer getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Integer funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public OrdemDeServico getOrdemServico() {
		return ordemDeServico;
	}

	public void setOrdemServico(OrdemDeServico ordemServico) {
		this.ordemDeServico = ordemServico;
	}

	public Integer getServicoId() {
		return servicoId;
	}

	public void setServicoId(Integer servicoId) {
		this.servicoId = servicoId;
	}

	public OrdemDeServicoServico getOrdemServicoServico() {
		return ordemDeServicoServico;
	}

	public void setOrdemServicoServico(OrdemDeServicoServico ordemServicoServico) {
		this.ordemDeServicoServico = ordemServicoServico;
	}

	public OrdemDeServico getOrdemDeServico() {
		return ordemDeServico;
	}

	public void setOrdemDeServico(OrdemDeServico ordemDeServico) {
		this.ordemDeServico = ordemDeServico;
	}

	public OrdemDeServicoProduto getOrdemDeServicoProduto() {
		return ordemDeServicoProduto;
	}

	public void setOrdemDeServicoProduto(OrdemDeServicoProduto ordemDeServicoProduto) {
		this.ordemDeServicoProduto = ordemDeServicoProduto;
	}

	public OrdemDeServicoServico getOrdemDeServicoServico() {
		return ordemDeServicoServico;
	}

	public void setOrdemDeServicoServico(OrdemDeServicoServico ordemDeServicoServico) {
		this.ordemDeServicoServico = ordemDeServicoServico;
	}

}
