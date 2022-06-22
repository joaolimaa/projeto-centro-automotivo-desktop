package projetomecanica.entidades;

import projetomecanica.servicos.Utils;

public class Peca {
    
    private int id = 0;
    private int codigo = 0;
    private String descricao = "";
    private int qtdEstoque = 0;
    private int qtdMinEstoque = 0;
    private int reservadas = 0;
    private float valorUnitario = 0;
    private int vidaUtilEmDias = 0;
    
    public Peca() {}

    public Peca(int codigo, String descricao, int qtdEstoque, int qtdMinEstoque, int reservadas, float valorUnitario, int vidaUtilEmDias) throws Exception {
        if (!Utils.validaNumero(codigo)) throw new Exception("Código inválido");
        if (!Utils.validaNumero(qtdEstoque)) throw new Exception("QDT no estoque inválido");
        if (!Utils.validaNumero(qtdMinEstoque)) throw new Exception("QDT mínima inválido");
        if (!Utils.validaNumero(reservadas)) throw new Exception("reservadas inválido");
        if (!Utils.validaNumero(valorUnitario)) throw new Exception("valor unitário inválido");
        if (!Utils.validaNumero(vidaUtilEmDias)) throw new Exception("vida útil inválido");
        this.codigo = codigo;
        this.descricao = descricao;
        this.qtdEstoque = qtdEstoque;
        this.qtdMinEstoque = qtdMinEstoque;
        this.reservadas = reservadas;
        this.valorUnitario = valorUnitario;
        this.vidaUtilEmDias = vidaUtilEmDias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws Exception {
        if (!Utils.validaNumero(codigo)) throw new Exception("Código inválido");
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) throws Exception {
        if (!Utils.validaNumero(qtdEstoque)) throw new Exception("QDT no estoque inválido");
        this.qtdEstoque = qtdEstoque;
    }

    public int getQtdMinEstoque() {
        return qtdMinEstoque;
    }

    public void setQtdMinEstoque(int qtdMinEstoque) throws Exception {
        if (!Utils.validaNumero(qtdMinEstoque)) throw new Exception("QDT mínima inválido");
        this.qtdMinEstoque = qtdMinEstoque;
    }

    public int getReservadas() {
        return reservadas;
    }

    public void setReservadas(int reservadas) throws Exception {
        if (!Utils.validaNumero(reservadas)) throw new Exception("reservadas inválido");
        this.reservadas = reservadas;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) throws Exception {
        if (!Utils.validaNumero(valorUnitario)) throw new Exception("valor unitário inválido");
        this.valorUnitario = valorUnitario;
    }

    public int getVidaUtilEmDias() {
        return vidaUtilEmDias;
    }

    public void setVidaUtilEmDias(int vidaUtilEmDias) throws Exception {
        if (!Utils.validaNumero(vidaUtilEmDias)) throw new Exception("vida útil inválido");
        this.vidaUtilEmDias = vidaUtilEmDias;
    }
    
    public Object[] listaValoresTabela() {
        return new Object[] {codigo, descricao, valorUnitario, qtdEstoque};
    }
    
    public Object[] listaValoresTabelaOS() {
        return new Object[] {codigo, descricao};
    }
    
    public Object[] listaValoresTabelaOrcamento() {
        return new Object[] {descricao, valorUnitario};
    }

    @Override
    public String toString() {
        return id + ";" + codigo + ";" + descricao + ";" + qtdEstoque + ";" + qtdMinEstoque + ";" + reservadas + ";" + valorUnitario + ";" + vidaUtilEmDias;
    }
    
}
