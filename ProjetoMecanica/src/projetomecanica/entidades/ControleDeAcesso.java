package projetomecanica.entidades;

public class ControleDeAcesso {
    
    private int id = 0;
    private String descricao;
    private boolean acessoCliente;
    private boolean acessoColaborador;
    private boolean acessoPeca;
    private boolean acessoServico;
    private boolean acessoVeiculo;
    private boolean acessoDocumento;
    private boolean acessoOrdemDeServico;
    private boolean acessoConfiguracao;

    public ControleDeAcesso() {
    }

    public ControleDeAcesso(String descricao, boolean acessoCliente, boolean acessoColaborador, boolean acessoPeca, boolean acessoServico, boolean acessoVeiculo, boolean acessoDocumento, boolean acessoOrdemDeServico, boolean acessoConfiguracao) {
        this.descricao = descricao;
        this.acessoCliente = acessoCliente;
        this.acessoColaborador = acessoColaborador;
        this.acessoPeca = acessoPeca;
        this.acessoServico = acessoServico;
        this.acessoVeiculo = acessoVeiculo;
        this.acessoDocumento = acessoDocumento;
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

    public boolean isAcessoDocumento() {
        return acessoDocumento;
    }

    public void setAcessoDocumento(boolean acessoDocumento) {
        this.acessoDocumento = acessoDocumento;
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

    @Override
    public String toString() {
        return id + ";" + descricao + ";" + acessoCliente + ";" + acessoColaborador + ";" + acessoPeca + ";" + acessoServico + ";" + acessoVeiculo + ";" + acessoDocumento + ";" + acessoOrdemDeServico + ";" + acessoConfiguracao;
    }
    
}
