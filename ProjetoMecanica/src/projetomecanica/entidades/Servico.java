package projetomecanica.entidades;

public class Servico {
    
    private int id = 0;
    private String descricao;
    private float valor;
    
    public Servico() {}

    public Servico(int codigo, String descricao, float valor, int estimativaHora) {
        this.descricao = descricao;
        this.valor = valor;
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return id + ";" + descricao + ";" + valor;
    }
    
}