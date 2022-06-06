package projetomecanica.entidades.enums;

public enum TipoDeTelefone {
    
    RESIDENCIAL("Residencial"),
    TRABALHO("Trabalho"),
    CELULAR("Celular");
    
    private String descricao;
    
    TipoDeTelefone(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
