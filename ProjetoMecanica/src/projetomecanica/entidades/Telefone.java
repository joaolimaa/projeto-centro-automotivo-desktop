package projetomecanica.entidades;

import projetomecanica.entidades.enums.TipoDeTelefone;

public class Telefone {
    
    private int ddi;
    private int ddd;
    private int numero;
    private TipoDeTelefone tipo;

    public Telefone(int ddi, int ddd, int numero, TipoDeTelefone tipo) {
        this.ddi = ddi;
        this.ddd = ddd;
        this.numero = numero;
        this.tipo = tipo;
    }

    public int getDdi() {
        return ddi;
    }

    public void setDdi(int ddi) {
        this.ddi = ddi;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TipoDeTelefone getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeTelefone tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return ddi + ";" + ddd + ";" + numero + ";" + tipo;
    }
    
}
