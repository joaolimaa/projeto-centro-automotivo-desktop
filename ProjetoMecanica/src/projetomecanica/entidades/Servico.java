package projetomecanica.entidades;

public class Servico {
    
    private int id = 0;
    private int codigo;
    private String descricao;
    private float valor;
    private int estimativaHora;
    
    public Servico() {}

    public Servico(int codigo, String descricao, float valor, int estimativaHora) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
        this.estimativaHora = estimativaHora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getEstimativaHora() {
        return estimativaHora;
    }

    public void setEstimativaHora(int estimativaHora) {
        this.estimativaHora = estimativaHora;
    }

    @Override
    public String toString() {
        return id + ";" + codigo + ";" + descricao + ";" + valor + ";" + estimativaHora;
    }
    
}
