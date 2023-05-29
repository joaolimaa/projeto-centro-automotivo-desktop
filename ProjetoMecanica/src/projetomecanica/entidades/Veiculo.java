package projetomecanica.entidades;

import projetomecanica.entidades.dao.ClienteDAO;
import projetomecanica.entidades.enums.StatusVeiculo;
import projetomecanica.entidades.enums.TipoDeVeiculo;
import projetomecanica.servicos.Utils;

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
    private int quilometragem = 0;
    
    public Veiculo() {}

    public Veiculo(String placa, Modelo modelo, String renavam, int anoModelo, int anoFabricacao, TipoDeVeiculo tipo, StatusVeiculo status, int idCliente, int quilometragem) throws Exception {
        if (!Utils.validaNumero(anoModelo)) throw new Exception("Ano de modelo inválido");
        if (!Utils.validaNumero(anoFabricacao)) throw new Exception("Ano de fabricação inválido");
        if (!Utils.validaNumero(quilometragem)) throw new Exception("Quilometragem inválida");
        if (!Utils.validaRenavam(renavam)) throw new Exception("Renavam inválido");
        if (!Utils.validaPlaca(placa)) throw new Exception("Placa inválida");
        this.placa = placa;
        this.modelo = modelo;
        this.renavam = renavam;
        this.anoModelo = anoModelo;
        this.anoFabricacao = anoFabricacao;
        this.tipo = tipo;
        this.status = status;
        this.idCliente = idCliente;
        this.quilometragem = quilometragem;
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

    public void setPlaca(String placa) throws Exception {
        if (!Utils.validaPlaca(placa)) throw new Exception("Placa inválida");
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

    public void setRenavam(String renavam) throws Exception {
        if (!Utils.validaRenavam(renavam)) throw new Exception("Renavam inválido");
        this.renavam = renavam;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) throws Exception {
        if (!Utils.validaNumero(anoModelo)) throw new Exception("Ano de modelo inválido");
        this.anoModelo = anoModelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) throws Exception {
        if (!Utils.validaNumero(anoFabricacao)) throw new Exception("Ano de fabricação inválido");
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

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) throws Exception {
        if (!Utils.validaNumero(quilometragem)) throw new Exception("Quilometragem inválida");
        this.quilometragem = quilometragem;
    }
    
    public Object[] listaValoresTabela() throws Exception {
        ClienteDAO clienteDAO = new ClienteDAO();
        return new Object[] {modelo.getMarca().getDescricao(), modelo.getDescricao(), placa, clienteDAO.consultarPorId(idCliente).getNomeCompleto(), status};
    }
    
    public Object[] listaValoresTabelaOS() throws Exception {
        return new Object[] {modelo.getDescricao(), placa};
    }

    @Override
    public String toString() {
        return this.id + ";" + this.placa + ";" + this.modelo.toString() + ";" + this.renavam + ";" + this.anoModelo + ";" + this.anoFabricacao + ";" + this.tipo + ";" + this.status + ";" + this.idCliente + ";" + this.quilometragem;
    }
    
}
