package projetomecanica.entidades;

import projetomecanica.entidades.*;
import java.util.ArrayList;
import java.util.stream.Collectors;
import projetomecanica.entidades.dao.ClienteDAO;
import projetomecanica.entidades.dao.VeiculoDAO;
import projetomecanica.entidades.enums.FasesDocumento;
import projetomecanica.servicos.Utils;

public class Orcamento {
    
    private int id = 0;
    private int idCliente = 0;
    private int idColaborador = 0;
    private int idVeiculo = 0;
    private ArrayList<Peca> pecas = new ArrayList<>();
    private int qtdPecas = pecas.size();
    private float totalPecas = 0;
    private ArrayList<Servico> servicos = new ArrayList<>();
    private int qtdServicos = servicos.size();
    private float totalServicos = 0;
    private float total = 0;
    private String dataOrcamentoGerado = "";
    private String dataValidadeOrcamento = "";
    private String dataOrcamentoAprovado = "";
    private float desconto = 0;
    private int codigo = 0;
    private FasesDocumento fase = FasesDocumento.ATIVO;
    
    public Orcamento() {}

    public Orcamento(int idCliente, int idColaborador, int idVeiculo, ArrayList<Peca> pecas, int qtdPecas, float totalPecas, ArrayList<Servico> servicos, int qtdServicos, float totalServicos, float total, String dataOrcamentoGerado, String dataValidadeOrcamento, String dataOrcamentoAprovado, float desconto, int codigo, FasesDocumento fase) throws Exception {
        if (!Utils.dataIsValida(dataOrcamentoGerado)) throw new Exception("Data para gerar orçamento inválida");
        if (!Utils.dataIsValida(dataValidadeOrcamento)) throw new Exception("Data de validade do orçamento inválida");
        if (!Utils.dataIsValida(dataOrcamentoAprovado)) throw new Exception("Data de aprovação do orçamento inválida");
        if (!Utils.validaNumero(idCliente)) throw new Exception("cliente inválido");
        if (!Utils.validaNumero(idColaborador)) throw new Exception("colaborador inválido");
        if (!Utils.validaNumero(idVeiculo)) throw new Exception("veiculo inválido");
        if (!Utils.validaNumero(pecas.size())) throw new Exception("Quantidade de peças inválida");
        if (!Utils.validaNumero(servicos.size())) throw new Exception("Quantidade de serviços inválido");
        if (!Utils.validaNumero(totalPecas)) throw new Exception("total das peças inválido");
        if (!Utils.validaNumero(totalServicos)) throw new Exception("total dos serviços inválido");
        if (!Utils.validaNumero(total)) throw new Exception("total inválido");
        if (!Utils.validaNumero(desconto)) throw new Exception("desconto inválido");
        if (!Utils.validaNumero(codigo)) throw new Exception("codigo inválido");
        this.idCliente = idCliente;
        this.idColaborador = idColaborador;
        this.idVeiculo = idVeiculo;
        this.pecas = pecas;
        this.qtdPecas = pecas.size();
        this.totalPecas = totalPecas;
        this.servicos = servicos;
        this.qtdServicos = servicos.size();
        this.totalServicos = totalServicos;
        this.total = total;
        this.dataOrcamentoGerado = dataOrcamentoGerado;
        this.dataValidadeOrcamento = dataValidadeOrcamento;
        this.dataOrcamentoAprovado = dataOrcamentoAprovado;
        this.desconto = desconto;
        this.codigo = codigo;
        this.fase = fase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) throws Exception {
        if (!Utils.validaNumero(idCliente)) throw new Exception("cliente inválido");
        this.idCliente = idCliente;
    }

    public int getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(int idColaborador) throws Exception {
        if (!Utils.validaNumero(idColaborador)) throw new Exception("colaborador inválido");
        this.idColaborador = idColaborador;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) throws Exception {
        if (!Utils.validaNumero(idVeiculo)) throw new Exception("veiculo inválido");
        this.idVeiculo = idVeiculo;
    }

    public ArrayList<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(ArrayList<Peca> pecas) {
        this.pecas = pecas;
    }

    public int getQtdPecas() {
        return qtdPecas;
    }

    public void setQtdPecas(int qtdPecas) {
        this.qtdPecas = qtdPecas;
    }

    public float getTotalPecas() {
        return totalPecas;
    }

    public void setTotalPecas(float totalPecas) {
        this.totalPecas = totalPecas;
    }

    public ArrayList<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<Servico> servicos) {
        this.servicos = servicos;
    }

    public int getQtdServicos() {
        return qtdServicos;
    }

    public void setQtdServicos(int qtdServicos) {
        this.qtdServicos = qtdServicos;
    }

    public float getTotalServicos() {
        return totalServicos;
    }

    public void setTotalServicos(float totalServicos) {
        this.totalServicos = totalServicos;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getDataOrcamentoGerado() {
        return dataOrcamentoGerado;
    }

    public void setDataOrcamentoGerado(String dataOrcamentoGerado) {
        this.dataOrcamentoGerado = dataOrcamentoGerado;
    }

    public String getDataValidadeOrcamento() {
        return dataValidadeOrcamento;
    }

    public void setDataValidadeOrcamento(String dataValidadeOrcamento) {
        this.dataValidadeOrcamento = dataValidadeOrcamento;
    }

    public String getDataOrcamentoAprovado() {
        return dataOrcamentoAprovado;
    }

    public void setDataOrcamentoAprovado(String dataOrcamentoAprovado) {
        this.dataOrcamentoAprovado = dataOrcamentoAprovado;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
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
    
    protected String listarPecas(ArrayList<Peca> pecas) {
        return pecas.stream().map(String::valueOf).collect(Collectors.joining(";"));
    }
    
    protected String listarServicos(ArrayList<Servico> servicos) {
        return servicos.stream().map(String::valueOf).collect(Collectors.joining(";"));
    }
    
    public Object[] listaValoresTabelaExibir() throws Exception {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        String nomeCliente = "";
        if (clienteDAO.consultarPorId(idCliente).getCpf_cnpj().length() > 14) nomeCliente = clienteDAO.consultarPorId(idCliente).getRazaoSocial();
        else nomeCliente = clienteDAO.consultarPorId(idCliente).getNomeCompleto();
        return new Object[] {codigo, veiculoDAO.consultarPorId(idVeiculo).getModelo().getDescricao(), nomeCliente, qtdPecas, qtdServicos, fase};
    }
    
    public Object[] listaValoresTelaOS() throws Exception {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        return new Object[] {codigo, veiculoDAO.consultarPorId(idVeiculo).getModelo().getDescricao()};
    }

    @Override
    public String toString() {
        return id + ";" + idCliente + ";" + idColaborador + ";" + idVeiculo + ";" + qtdPecas + ";" + qtdServicos + ";" + this.listarPecas(pecas) + ";" + this.listarServicos(servicos) + ";" + totalPecas + ";" + totalServicos + ";" + total + ";" + dataOrcamentoGerado + ";" + dataValidadeOrcamento + ";" + dataOrcamentoAprovado + ";" + desconto + ";" + codigo + ";" + fase;
    }
    
}
