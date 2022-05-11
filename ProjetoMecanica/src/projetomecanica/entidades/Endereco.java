package projetomecanica.entidades;

import projetomecanica.entidades.enums.TipoDeLogradouro;

public class Endereco {
    
    private TipoDeLogradouro tipoLogradouro;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;
    private String estado;
    private int numero;

    public Endereco(TipoDeLogradouro tipoLogradouro, String logradouro, String complemento, String bairro, String cidade, String cep, String estado, int numero) {
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
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

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return tipoLogradouro + ";" + logradouro + ";" + complemento + ";" + bairro + ";" + cidade + ";" + cep + ";" + estado + ";" + numero;
    }
    
}
