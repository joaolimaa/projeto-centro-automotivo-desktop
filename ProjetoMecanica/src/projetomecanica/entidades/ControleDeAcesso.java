package projetomecanica.entidades;

public class ControleDeAcesso {
    
    private int id = 0;
    private String descricao = "";
    private boolean acessoCliente = false;
    private boolean acessoColaborador = false;
    private boolean acessoPeca = false;
    private boolean acessoServico = false;
    private boolean acessoVeiculo = false;
    private boolean acessoOrcamento = false;
    private boolean acessoNotaFiscal = false;
    private boolean acessoOrdemDeServico = false;
    private boolean acessoConfiguracao = false;

    public ControleDeAcesso() {
    }

    public ControleDeAcesso(String descricao, boolean acessoCliente, boolean acessoColaborador, boolean acessoPeca, boolean acessoServico, boolean acessoVeiculo, boolean acessoOrcamento, boolean acessoNotaFiscal, boolean acessoOrdemDeServico, boolean acessoConfiguracao) {
        this.descricao = descricao;
        this.acessoCliente = acessoCliente;
        this.acessoColaborador = acessoColaborador;
        this.acessoPeca = acessoPeca;
        this.acessoServico = acessoServico;
        this.acessoVeiculo = acessoVeiculo;
        this.acessoOrcamento = acessoOrcamento;
        this.acessoOrdemDeServico = acessoOrdemDeServico;
        this.acessoConfiguracao = acessoConfiguracao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAcessoCliente() {
        return acessoCliente;
    }

    public void setAcessoCliente(boolean acessoCliente) {
        this.acessoCliente = acessoCliente;
    }

    public boolean isAcessoColaborador() {
        return acessoColaborador;
    }

    public void setAcessoColaborador(boolean acessoColaborador) {
        this.acessoColaborador = acessoColaborador;
    }

    public boolean isAcessoPeca() {
        return acessoPeca;
    }

    public void setAcessoPeca(boolean acessoPeca) {
        this.acessoPeca = acessoPeca;
    }

    public boolean isAcessoServico() {
        return acessoServico;
    }

    public void setAcessoServico(boolean acessoServico) {
        this.acessoServico = acessoServico;
    }

    public boolean isAcessoVeiculo() {
        return acessoVeiculo;
    }

    public void setAcessoVeiculo(boolean acessoVeiculo) {
        this.acessoVeiculo = acessoVeiculo;
    }

    public boolean isAcessoOrcamento() {
        return acessoOrcamento;
    }

    public void setAcessoOrcamento(boolean acessoOrcamento) {
        this.acessoOrcamento = acessoOrcamento;
    }

    public boolean isAcessoOrdemDeServico() {
        return acessoOrdemDeServico;
    }

    public void setAcessoOrdemDeServico(boolean acessoOrdemDeServico) {
        this.acessoOrdemDeServico = acessoOrdemDeServico;
    }

    public boolean isAcessoConfiguracao() {
        return acessoConfiguracao;
    }

    public void setAcessoConfiguracao(boolean acessoConfiguracao) {
        this.acessoConfiguracao = acessoConfiguracao;
    }

    public boolean isAcessoNotaFiscal() {
        return acessoNotaFiscal;
    }

    public void setAcessoNotaFiscal(boolean acessoNotaFiscal) {
        this.acessoNotaFiscal = acessoNotaFiscal;
    }
    
    public Object[] listaValoresTela() throws Exception {
        return new Object[] { descricao };
    }

    @Override
    public String toString() {
        return id + ";" + descricao + ";" + acessoCliente + ";" + acessoColaborador + ";" + acessoPeca + ";" + acessoServico + ";" + acessoVeiculo + ";" + acessoOrcamento + ";" + acessoNotaFiscal + ";" + acessoOrdemDeServico + ";" + acessoConfiguracao;
    }
    
}
