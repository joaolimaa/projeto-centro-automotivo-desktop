package projetomecanica.entidades;

public class Peca {
    
    private int id = 0;
    private int codigo;
    private String descricao;
    
    public Peca() {}

    public Peca(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
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

    @Override
    public String toString() {
        return id + ";" + codigo + ";" + descricao;
    }
    
}
