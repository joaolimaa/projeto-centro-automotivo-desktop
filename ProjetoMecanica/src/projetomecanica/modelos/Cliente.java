/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetomecanica.modelos;

/**
 *
 * @author leona
 */
public class Cliente {
    
    private int id = 0;
    private String nomeCompleto = "";
    private int telefone = 0;
    private String email = "";
    private String endereco = "";

    public Cliente() {}
    
    public Cliente(String nomeCompleto, int telefone, String email, String endereco) {
        this.nomeCompleto = nomeCompleto;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return id + ";" + nomeCompleto + ";" + telefone + ";" + email + ";" + endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
    
}
