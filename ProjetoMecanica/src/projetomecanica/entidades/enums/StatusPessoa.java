package projetomecanica.entidades.enums;

public enum StatusPessoa {
    
    ATIVO("Ativo"),
    INATIVO("Inativo");
    
    private String descricao;
    
    StatusPessoa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
