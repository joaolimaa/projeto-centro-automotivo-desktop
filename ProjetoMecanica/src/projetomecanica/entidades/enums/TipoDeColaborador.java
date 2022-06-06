package projetomecanica.entidades.enums;

public enum TipoDeColaborador {
    
    ATENDENTE("Atendente"),
    MECANICO("Mecânico"),
    ESTOQUISTA("Estoquista"),
    CONSULTOR_TECNICO("Consultor Técnico");
    
    private String descricao;
    
    TipoDeColaborador(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
