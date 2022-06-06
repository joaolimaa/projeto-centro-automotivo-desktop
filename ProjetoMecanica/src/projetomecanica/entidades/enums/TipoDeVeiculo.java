package projetomecanica.entidades.enums;

public enum TipoDeVeiculo {
    
    UTILITARIO("Utilitário"),
    ESPORTIVO("Esportivo"),
    PASSEIO("Passeio");
    
    private String descricao;
    
    TipoDeVeiculo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
