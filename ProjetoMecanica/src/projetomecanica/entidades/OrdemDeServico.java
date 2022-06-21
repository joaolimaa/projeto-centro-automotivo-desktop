package projetomecanica.entidades;

import java.util.ArrayList;
import java.util.stream.Collectors;
import projetomecanica.entidades.dao.ClienteDAO;
import projetomecanica.entidades.dao.ColaboradorDAO;
import projetomecanica.entidades.dao.VeiculoDAO;
import projetomecanica.entidades.enums.FasesDocumento;

public class OrdemDeServico {
    
    private int id = 0;
    private int idOrcamento = 0;
    private int idCliente = 0;
    private int idColaborador = 0;
    private int idVeiculo = 0;
    private ArrayList<Peca> pecas = new ArrayList<>();
    private int qtdPecas = pecas.size();
    private ArrayList<Servico> servicos = new ArrayList<>();
    private int qtdServicos = servicos.size();
    private String dataOrdemDeServicoGerada = "";
    private String dataOrdemDeServicoFinalizada = "";
    private int codigo = 0;
    private FasesDocumento fase = FasesDocumento.ATIVO;
    
    public OrdemDeServico() {}

    public OrdemDeServico(int idOrcamento, int idCliente, int idColaborador, int idVeiculo, ArrayList<Peca> pecas, ArrayList<Servico> servicos, String dataOrdemDeServicoGerada, String dataOrdemDeServicoFinalizada, int codigo, FasesDocumento fase ,int qtdPecas, int qtdServicos) {
        this.idOrcamento = idOrcamento;
        this.idCliente = idCliente;
        this.idColaborador = idColaborador;
        this.idVeiculo = idVeiculo;
        this.pecas = pecas;
        this.servicos = servicos;
        this.dataOrdemDeServicoGerada = dataOrdemDeServicoGerada;
        this.dataOrdemDeServicoFinalizada = dataOrdemDeServicoFinalizada;
        this.codigo = codigo;
        this.fase = fase;
        this.qtdPecas = pecas.size();
        this.qtdServicos = servicos.size();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(int idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(int idColaborador) {
        this.idColaborador = idColaborador;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public ArrayList<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(ArrayList<Peca> pecas) {
        this.pecas = pecas;
    }

    public ArrayList<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<Servico> servicos) {
        this.servicos = servicos;
    }

    public String getDataOrdemDeServicoGerada() {
        return dataOrdemDeServicoGerada;
    }

    public void setDataOrdemDeServicoGerada(String dataOrdemDeServicoGerada) {
        this.dataOrdemDeServicoGerada = dataOrdemDeServicoGerada;
    }

    public String getDataOrdemDeServicoFinalizada() {
        return dataOrdemDeServicoFinalizada;
    }

    public void setDataOrdemDeServicoFinalizada(String dataOrdemDeServicoFinalizada) {
        this.dataOrdemDeServicoFinalizada = dataOrdemDeServicoFinalizada;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public FasesDocumento getFase() {
        return fase;
    }

    public void setFase(FasesDocumento fase) {
        this.fase = fase;
    }

    public int getQtdPecas() {
        return qtdPecas;
    }

    public void setQtdPecas(int qtdPecas) {
        this.qtdPecas = qtdPecas;
    }

    public int getQtdServicos() {
        return qtdServicos;
    }

    public void setQtdServicos(int qtdServicos) {
        this.qtdServicos = qtdServicos;
    }
    
    protected String listarPecas(ArrayList<Peca> pecas) {
        return pecas.stream().map(String::valueOf).collect(Collectors.joining(";"));
    }
    
    protected String listarServicos(ArrayList<Servico> servicos) {
        return servicos.stream().map(String::valueOf).collect(Collectors.joining(";"));
    }
    
    public Object[] listaValoresTela() throws Exception {
        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        String nomeCliente = "";
        if(clienteDAO.consultarPorId(idCliente).getCpf_cnpj().length() > 14) nomeCliente = clienteDAO.consultarPorId(idCliente).getRazaoSocial();
        else nomeCliente = clienteDAO.consultarPorId(idCliente).getNomeCompleto();
        return new Object[] {codigo, colaboradorDAO.consultarPorId(idColaborador).getNomeCompleto(), veiculoDAO.consultarPorId(idVeiculo).getModelo().getDescricao(), nomeCliente,qtdPecas, qtdServicos, fase};
    }

    @Override
    public String toString() {
        return id + ";" + idOrcamento + ";" + idCliente + ";" + idColaborador + ";" + idVeiculo + ";" + qtdPecas + ";" + qtdServicos + ";" + this.listarPecas(pecas) + ";" + this.listarServicos(servicos) + ";" + dataOrdemDeServicoGerada + ";" + dataOrdemDeServicoFinalizada + ";" + codigo + ";" + fase;
    }
    
}
