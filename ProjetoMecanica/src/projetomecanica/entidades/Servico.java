package projetomecanica.entidades;

import projetomecanica.servicos.Utils;

public class Servico {
    
    private int id = 0;
    private String descricao;
    private float valor;
    
    public Servico() {}

    public Servico(String descricao, float valor, int estimativaHora) throws Exception {
        if (!Utils.validaNumero(valor)) throw new Exception("valor inválido");
        this.descricao = descricao;
        this.valor = valor;
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) throws Exception {
        if (!Utils.validaNumero(valor)) throw new Exception("valor inválido");
        this.valor = valor;
    }
    
    public Object[] listaValoresTabela() {
        return new Object[] {descricao, valor};
    }

    @Override
    public String toString() {
        return id + ";" + descricao + ";" + valor;
    }
    
}
