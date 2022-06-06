package projetomecanica.entidades;

import java.util.ArrayList;
import projetomecanica.entidades.enums.TipoDeDocumento;

public class Documento {
    
    private int id = 0;
    private int idCliente = 0;
    private int idColaborador = 0;
    private int idVeiculo = 0;
    private ArrayList<Peca> pecas = new ArrayList<>();
    private float totalPecas = 0;
    private ArrayList<Servico> servicos = new ArrayList<>();
    private float totalServicos = 0;
    private float total = 0;
    private int numeroNF = 0;
    private int serieNF = 0;
    private String dataOrcamentoGerado = "";
    private String dataValidadeOrcamento = "";
    private String dataOrcamentoAprovado = "";
    private float desconto = 0;
    private int numeroOS = 0;
    private TipoDeDocumento fase = TipoDeDocumento.ORCAMENTO;
    
    public Documento() {}

    public Documento(int idCliente, int idColaborador, int idVeiculo, ArrayList<Peca> pecas, float totalPecas, ArrayList<Servico> servicos, float totalServicos, float total, int numeroNF, int serieNF, String dataOrcamentoGerado, String dataValidadeOrcamento, String dataOrcamentoAprovado, float desconto, int numeroOS, TipoDeDocumento fase) {
        this.idCliente = idCliente;
        this.idColaborador = idColaborador;
        this.idVeiculo = idVeiculo;
        this.pecas = pecas;
        this.totalPecas = totalPecas;
        this.servicos = servicos;
        this.totalServicos = totalServicos;
        this.total = total;
        this.numeroNF = numeroNF;
        this.serieNF = serieNF;
        this.dataOrcamentoGerado = dataOrcamentoGerado;
        this.dataValidadeOrcamento = dataValidadeOrcamento;
        this.dataOrcamentoAprovado = dataOrcamentoAprovado;
        this.desconto = desconto;
        this.numeroOS = numeroOS;
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

    public int getNumeroNF() {
        return numeroNF;
    }

    public void setNumeroNF(int numeroNF) {
        this.numeroNF = numeroNF;
    }

    public int getSerieNF() {
        return serieNF;
    }

    public void setSerieNF(int serieNF) {
        this.serieNF = serieNF;
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

    public TipoDeDocumento getFase() {
        return fase;
    }

    public void setFase(TipoDeDocumento fase) {
        this.fase = fase;
    }

    public int getNumeroOS() {
        return numeroOS;
    }

    public void setNumeroOS(int numeroOS) {
        this.numeroOS = numeroOS;
    }

    @Override
    public String toString() {
        return id + ";" + idCliente + ";" + idColaborador + ";" + idVeiculo + ";" + pecas + ";" + totalPecas + ";" + servicos + ";" + totalServicos + ";" + total + ";" + numeroOS + ";" + numeroNF + ";" + serieNF + ";" + dataOrcamentoGerado + ";" + dataValidadeOrcamento + ";" + dataOrcamentoAprovado + ";" + desconto + ";" + fase.getDescricao();
    }
    
}
