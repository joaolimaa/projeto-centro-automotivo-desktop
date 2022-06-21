package projetomecanica.entidades;

public class Marca {
    
    private int id;
    private String descricao = "";
    private String logo = "n/a";

    public Marca(String descricao, String logo) {
        this.descricao = descricao;
        this.logo = logo;
    }
    
    public Marca() {
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
    
    public Object[] listaValoresTabela() {
        return new Object[] {id, descricao};
    }

    @Override
    public String toString() {
        return id + ";" + descricao + ";" + logo;
    }
    
}
