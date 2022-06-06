package projetomecanica.entidades.enums;

public enum StatusVeiculo {
    
    EM_MANUTENCAO("Em manutenção"),
    EM_ESPERA("Em espera"),
    INATIVO("Inativo");
    
    private String descricao;
    
    StatusVeiculo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
