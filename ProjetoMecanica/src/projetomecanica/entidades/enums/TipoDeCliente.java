package projetomecanica.entidades.enums;

public enum TipoDeCliente {
    
    PESSOA_FISICA("Pessoa Física"),
    PESSOA_JURIDICA("Pessoa Jurídica");
    
    private String descricao;
    
    TipoDeCliente(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
