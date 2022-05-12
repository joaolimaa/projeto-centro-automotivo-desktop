package projetomecanica.entidades;

import projetomecanica.entidades.enums.TipoVeiculo;

public class Veiculo {
    
    private int id;
    private String placa = "";
    private Modelo modelo;
    private String renavam = "";
    private int anoModelo = 0;
    private int anoFabricacao = 0;
    private TipoVeiculo tipo;
    private int idCliente;
    
    public Veiculo() {}

    public Veiculo(String placa, Modelo modelo, String renavam, int anoModelo, int anoFabricacao, TipoVeiculo tipo, int idCliente) {
        this.placa = placa;
        this.modelo = modelo;
        this.renavam = renavam;
        this.anoModelo = anoModelo;
        this.anoFabricacao = anoFabricacao;
        this.tipo = tipo;
        this.idCliente = idCliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    
    
}
