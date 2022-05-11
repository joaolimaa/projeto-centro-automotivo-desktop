package projetomecanica.entidades;

import projetomecanica.entidades.enums.TipoVeiculo;

public class Veiculo {
    
    private int id;
    private String placa;
    private Modelo modelo;
    private String renavam;
    private int anoModelo;
    private int anoFabricacao;
    private TipoVeiculo tipo;

    public Veiculo( String placa, Modelo modelo, String renavam, int anoModelo, int anoFabricacao, TipoVeiculo tipo) {
        this.placa = placa;
        this.modelo = modelo;
        this.renavam = renavam;
        this.anoModelo = anoModelo;
        this.anoFabricacao = anoFabricacao;
        this.tipo = tipo;
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
    
}
