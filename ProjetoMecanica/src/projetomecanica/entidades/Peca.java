package projetomecanica.entidades;

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

    public Peca(int codigo, String descricao, int qtdEstoque, int qtdMinEstoque, int reservadas, float valorUnitario, int vidaUtilEmDias) {
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

    public void setCodigo(int codigo) {
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

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public int getQtdMinEstoque() {
        return qtdMinEstoque;
    }

    public void setQtdMinEstoque(int qtdMinEstoque) {
        this.qtdMinEstoque = qtdMinEstoque;
    }

    public int getReservadas() {
        return reservadas;
    }

    public void setReservadas(int reservadas) {
        this.reservadas = reservadas;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getVidaUtilEmDias() {
        return vidaUtilEmDias;
    }

    public void setVidaUtilEmDias(int vidaUtilEmDias) {
        this.vidaUtilEmDias = vidaUtilEmDias;
    }

    @Override
    public String toString() {
        return id + ";" + codigo + ";" + descricao + ";" + qtdEstoque + ";" + qtdMinEstoque + ";" + reservadas + ";" + valorUnitario + ";" + vidaUtilEmDias;
    }
    
}
