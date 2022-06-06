package projetomecanica.entidades.enums;

public enum TipoDeLogradouro {
    
    RUA("Rua"),
    AVENIDA("Avenida");
    
    private String descricao;
    
    TipoDeLogradouro(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
