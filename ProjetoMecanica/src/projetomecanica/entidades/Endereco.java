package projetomecanica.entidades;

import projetomecanica.entidades.enums.TipoDeLogradouro;
import projetomecanica.servicos.Utils;

public class Endereco {
    
    private TipoDeLogradouro tipoLogradouro = TipoDeLogradouro.AVENIDA;
    private String logradouro = "";
    private String complemento = "";
    private String bairro = "";
    private String cidade = "";
    private int cep = 0;
    private String estado = "";
    private int numero = 0;

    public Endereco() {}

    public Endereco(TipoDeLogradouro tipoLogradouro, String logradouro, String complemento, String bairro, String cidade, int cep, String estado, int numero) throws Exception {
        if (!Utils.validaNumero(cep)) throw new Exception("Cep não pode ser negativo");
        if (!Utils.validaCep(cep)) throw new Exception("CEP inválido");
        if (!Utils.validaNumero(numero)) throw new Exception("Número não pode ser negativo");
        this.tipoLogradouro = tipoLogradouro;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.estado = estado;
        this.numero = numero;
    }

    public TipoDeLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoDeLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) throws Exception {
        if (!Utils.validaNumero(cep)) throw new Exception("CEP não pode ser negativo");
        if (!Utils.validaCep(cep)) throw new Exception("CEP inválido");
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) throws Exception {
        if (!Utils.validaNumero(numero)) throw new Exception("Número não pode ser negativo");
        this.numero = numero;
    }

    @Override
    public String toString() {
        return this.tipoLogradouro.getDescricao() + ";" + this.logradouro + ";" + this.complemento + ";" + this.bairro + ";" + this.cidade + ";" + this.cep + ";" + this.estado + ";" + this.numero;
    }
    
}
