package projetomecanica.entidades;

import projetomecanica.entidades.enums.TipoDeTelefone;
import projetomecanica.servicos.Utils;

public class Telefone {
    
    private int ddd = 0;
    private int numero = 900000000;
    private TipoDeTelefone tipo = TipoDeTelefone.CELULAR;
    
    public Telefone() {}

    public Telefone(int ddd, int numero, TipoDeTelefone tipo) throws Exception {
        if (!Utils.validaNumero(ddd)) throw new Exception("DDD não pode ser negativo");
        if (!Utils.validaNumero(numero)) throw new Exception("Número não pode ser negativo");
        if (!Utils.validaTelefone(ddd, numero)) throw new Exception("Telefone inválido");
        this.ddd = ddd;
        this.numero = numero;
        this.tipo = tipo;
    }

    public int getDdd() {
        return ddd;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int ddd, int numero) throws Exception {
        if (!Utils.validaNumero(ddd)) throw new Exception("DDD não pode ser negativo");
        if (!Utils.validaNumero(numero)) throw new Exception("Número não pode ser negativo");
        if (!Utils.validaTelefone(ddd, numero)) throw new Exception("Telefone inválido");
        this.ddd = ddd;
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
        return this.ddd + ";" + this.numero + ";" + this.tipo;
    }
    
}
