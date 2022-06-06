package projetomecanica.entidades;

import projetomecanica.entidades.enums.StatusVeiculo;
import projetomecanica.entidades.enums.TipoDeVeiculo;

public class Veiculo {
    
    private int id;
    private String placa = "";
    private Modelo modelo = new Modelo();
    private String renavam = "";
    private int anoModelo = 0;
    private int anoFabricacao = 0;
    private StatusVeiculo status = StatusVeiculo.EM_ESPERA;
    private TipoDeVeiculo tipo = TipoDeVeiculo.ESPORTIVO;
    private int idCliente = 0;
    
    public Veiculo() {}

    public Veiculo(String placa, Modelo modelo, String renavam, int anoModelo, int anoFabricacao, TipoDeVeiculo tipo, StatusVeiculo status, int idCliente) {
        this.placa = placa;
        this.modelo = modelo;
        this.renavam = renavam;
        this.anoModelo = anoModelo;
        this.anoFabricacao = anoFabricacao;
        this.tipo = tipo;
        this.status = status;
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

    public TipoDeVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeVeiculo tipo) {
        this.tipo = tipo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public StatusVeiculo getStatus() {
        return status;
    }

    public void setStatus(StatusVeiculo status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.id + ";" + this.placa + ";" + this.modelo.toString() + ";" + this.renavam + ";" + this.anoModelo + ";" + this.anoFabricacao + ";" + this.tipo + ";" + this.status + ";" + this.idCliente;
    }
    
}
