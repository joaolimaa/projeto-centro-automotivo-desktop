package projetomecanica.entidades;

public class OrdemDeServico {
    
    private int id = 0;
    private Cliente cliente;
    private Colaborador colaborador;
    private Veiculo veiculo;
    private int pecas;
    private ItensPecas itensPecas;
    private ItensServicos servicos;
    private int fase;
    
    public OrdemDeServico() {}

    public OrdemDeServico(Cliente cliente, Colaborador colaborador, Veiculo veiculo, int pecas, ItensPecas itensPecas, ItensServicos servicos, int fase) {
        this.cliente = cliente;
        this.colaborador = colaborador;
        this.veiculo = veiculo;
        this.pecas = pecas;
        this.itensPecas = itensPecas;
        this.servicos = servicos;
        this.fase = fase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public int getPecas() {
        return pecas;
    }

    public void setPecas(int pecas) {
        this.pecas = pecas;
    }

    public ItensPecas getItensPecas() {
        return itensPecas;
    }

    public void setItensPecas(ItensPecas itensPecas) {
        this.itensPecas = itensPecas;
    }

    public ItensServicos getServicos() {
        return servicos;
    }

    public void setServicos(ItensServicos servicos) {
        this.servicos = servicos;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    @Override
    public String toString() {
        return id + ";" + cliente + ";" + colaborador + ";" + veiculo + ";" + pecas + ";" + itensPecas + ";" + servicos + ";" + fase;
    }
    
}
