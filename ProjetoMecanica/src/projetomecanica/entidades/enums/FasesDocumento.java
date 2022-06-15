package projetomecanica.entidades.enums;

public enum FasesDocumento {
    
    ATIVO("Ativo"),
    APROVADO("Aprovado"),
    FINALIZADO("Finalizado"),
    INATIVO("Inativo");
    
    private String descricao;
    
    FasesDocumento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
