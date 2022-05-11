package projetomecanica.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import projetomecanica.entidades.enums.TipoColaborador;

class Colaborador {
    
    private int id = 0;
    private String nomeCompleto;
    private ArrayList<Telefone> telefones;
    private String email;
    private Endereco endereco;
    private LocalDate dataNascimento;
    private float salarioBase;
    private float valorHora;
    private TipoColaborador tipo;
    
    public Colaborador() {}

    public Colaborador(String nomeCompleto, ArrayList<Telefone> telefones, String email, Endereco endereco, LocalDate dataNascimento, float salarioBase, float valorHora, TipoColaborador tipo) {
        this.nomeCompleto = nomeCompleto;
        this.telefones = telefones;
        this.email = email;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.salarioBase = salarioBase;
        this.valorHora = valorHora;
        this.tipo = tipo;
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

    public ArrayList<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(ArrayList<Telefone> telefones) {
        this.telefones = telefones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public float getValorHora() {
        return valorHora;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }

    public TipoColaborador getTipo() {
        return tipo;
    }

    public void setTipo(TipoColaborador tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return id + ";" + nomeCompleto + ";" + telefones + ";" + email + ";" + endereco + ";" + dataNascimento + ";" + salarioBase + ";" + valorHora + ";" + tipo;
    }
    
}
