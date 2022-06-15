package projetomecanica.entidades;

import java.util.ArrayList;
import java.util.stream.Collectors;
import projetomecanica.entidades.enums.FasesDocumento;
import projetomecanica.servicos.Utils;

public class NotaFiscal {
    
    private int id = 0;
    private int idCliente = 0;
    private int idColaborador = 0;
    private int idVeiculo = 0;
    private int idOrcamento = 0;
    private int idOrdemDeServico = 0;
    private ArrayList<Peca> pecas = new ArrayList<>();
    private float totalPecas = 0;
    private int qtdPecas = pecas.size();
    private ArrayList<Servico> servicos = new ArrayList<>();
    private float totalServicos = 0;
    private int qtdServicos = servicos.size();
    private float total = 0;
    private int numeroNF = 0;
    private int serieNF = 0;
    private String dataGerado = "";
    private String dataValidade = "";
    private String dataPagamento = "";
    private float desconto = 0;
    private FasesDocumento fase = FasesDocumento.ATIVO;
    
    public NotaFiscal() {}

    public NotaFiscal(int idCliente, int idColaborador, int idVeiculo, int idOrcamento, int idOrdemDeServico, ArrayList<Peca> pecas, float totalPecas, int qtdPecas, ArrayList<Servico> servicos, float totalServicos, int qtdServicos, float total, int numeroNF, int serieNF, String dataGerado, String dataValidade, String dataPagamento, float desconto, FasesDocumento fase) throws Exception {
        if (!Utils.dataIsValida(dataGerado)) throw new Exception("Data para gerar nota fiscal inválida");
        if (!Utils.dataIsValida(dataValidade)) throw new Exception("Data de validade inválida");
        if (!Utils.dataIsValida(dataPagamento)) throw new Exception("Data de pagamento inválida");
        if (!Utils.validaNumero(idCliente)) throw new Exception("cliente inválido");
        if (!Utils.validaNumero(idColaborador)) throw new Exception("colaborador inválido");
        if (!Utils.validaNumero(idVeiculo)) throw new Exception("veiculo inválido");
        if (!Utils.validaNumero(idOrcamento)) throw new Exception("orçamento inválido");
        if (!Utils.validaNumero(idOrdemDeServico)) throw new Exception("ordem de serviço inválido");
        if (!Utils.validaNumero(pecas.size())) throw new Exception("Quantidade de peças inválida");
        if (!Utils.validaNumero(servicos.size())) throw new Exception("Quantidade de serviços inválido");
        if (!Utils.validaNumero(totalPecas)) throw new Exception("total das peças inválido");
        if (!Utils.validaNumero(totalServicos)) throw new Exception("total dos serviços inválido");
        if (!Utils.validaNumero(total)) throw new Exception("total inválido");
        if (!Utils.validaNumero(desconto)) throw new Exception("desconto inválido");
        if (!Utils.validaNumero(numeroNF)) throw new Exception("numero da NF inválido");
        if (!Utils.validaNumero(serieNF)) throw new Exception("serie da NF inválido");
        this.idCliente = idCliente;
        this.idColaborador = idColaborador;
        this.idVeiculo = idVeiculo;
        this.idOrcamento = idOrcamento;
        this.idOrdemDeServico = idOrdemDeServico;
        this.pecas = pecas;
        this.totalPecas = totalPecas;
        this.qtdPecas = pecas.size();
        this.servicos = servicos;
        this.totalServicos = totalServicos;
        this.qtdServicos = servicos.size();
        this.total = total;
        this.numeroNF = numeroNF;
        this.serieNF = serieNF;
        this.dataGerado = dataGerado;
        this.dataValidade = dataValidade;
        this.dataPagamento = dataPagamento;
        this.desconto = desconto;
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

    public int getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(int idOrcamento) throws Exception {
        if (!Utils.validaNumero(idOrcamento)) throw new Exception("orçamento inválido");
        this.idOrcamento = idOrcamento;
    }

    public int getIdOrdemDeServico() {
        return idOrdemDeServico;
    }

    public void setIdOrdemDeServico(int idOrdemDeServico) throws Exception {
        if (!Utils.validaNumero(idOrdemDeServico)) throw new Exception("ordem de serviço inválido");
        this.idOrdemDeServico = idOrdemDeServico;
    }

    public ArrayList<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(ArrayList<Peca> pecas) {
        this.pecas = pecas;
    }

    public float getTotalPecas() {
        return totalPecas;
    }

    public void setTotalPecas(float totalPecas) throws Exception {
        if (!Utils.validaNumero(totalPecas)) throw new Exception("total das peças inválido");
        this.totalPecas = totalPecas;
    }

    public int getQtdPecas() {
        return qtdPecas;
    }

    public void setQtdPecas(int qtdPecas) {
        this.qtdPecas = pecas.size();
    }

    public ArrayList<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(ArrayList<Servico> servicos) {
        this.servicos = servicos;
    }

    public float getTotalServicos() {
        return totalServicos;
    }

    public void setTotalServicos(float totalServicos) throws Exception {
        if (!Utils.validaNumero(totalServicos)) throw new Exception("total dos serviços inválido");
        this.totalServicos = totalServicos;
    }

    public int getQtdServicos() {
        return qtdServicos;
    }

    public void setQtdServicos() {
        this.qtdServicos = servicos.size();
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) throws Exception {
        if (!Utils.validaNumero(total)) throw new Exception("total inválido");
        this.total = total;
    }

    public int getNumeroNF() {
        return numeroNF;
    }

    public void setNumeroNF(int numeroNF) throws Exception {
        if (!Utils.validaNumero(numeroNF)) throw new Exception("numero da NF inválido");
        this.numeroNF = numeroNF;
    }

    public int getSerieNF() {
        return serieNF;
    }

    public void setSerieNF(int serieNF) throws Exception {
        if (!Utils.validaNumero(serieNF)) throw new Exception("serie da NF inválido");
        this.serieNF = serieNF;
    }

    public String getDataGerado() {
        return dataGerado;
    }

    public void setDataGerado(String dataGerado) throws Exception {
        if (!Utils.dataIsValida(dataGerado)) throw new Exception("Data para gerar nota fiscal inválida");
        this.dataGerado = dataGerado;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) throws Exception {
        if (!Utils.dataIsValida(dataValidade)) throw new Exception("Data de validade inválida");
        this.dataValidade = dataValidade;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) throws Exception {
        if (!Utils.dataIsValida(dataPagamento)) throw new Exception("Data de pagamento inválida");
        this.dataPagamento = dataPagamento;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) throws Exception {
        if (!Utils.validaNumero(desconto)) throw new Exception("desconto inválido");
        this.desconto = desconto;
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

    @Override
    public String toString() {
        return id + ";" + idCliente + ";" + idColaborador + ";" + idVeiculo + ";" + idOrcamento + ";" + idOrdemDeServico + ";" + pecas + ";" + totalPecas + ";" + qtdPecas + ";" + servicos + ";" + totalServicos + ";" + qtdServicos + ";" + total + ";" + numeroNF + ";" + serieNF + ";" + dataGerado + ";" + dataValidade + ";" + dataPagamento + ";" + desconto + ";" + fase + '}';
    }
    
}
