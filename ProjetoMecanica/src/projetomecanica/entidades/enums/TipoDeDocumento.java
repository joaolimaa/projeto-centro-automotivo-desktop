package projetomecanica.entidades.enums;

public enum TipoDeDocumento {
    
    ORCAMENTO("Orçamento"),
    ORDEM_DE_SERVICO("Ordem de Serviço"),
    NOTA_FISCAL("Nota Fiscal");
    
    private String descricao;
    
    TipoDeDocumento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
