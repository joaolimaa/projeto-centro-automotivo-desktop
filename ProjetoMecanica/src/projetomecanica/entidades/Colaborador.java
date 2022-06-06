package projetomecanica.entidades;

import projetomecanica.entidades.enums.StatusPessoa;
import projetomecanica.entidades.enums.TipoDeColaborador;

public class Colaborador {
    
    private int id = 0;
    private String nomeCompleto = "";
    private Telefone telefone1 = new Telefone();
    private Telefone telefone2 = new Telefone();
    private Telefone telefone3 = new Telefone();
    private String email = "";
    private Endereco endereco = new Endereco();
    private String dataNascimento = "";
    private float salarioBase = 0;
    private float valorHora = 0;
    private TipoDeColaborador tipo = TipoDeColaborador.ATENDENTE;
    private StatusPessoa status = StatusPessoa.ATIVO;
    
    public Colaborador() {}

    public Colaborador(String nomeCompleto, Telefone telefone1, Telefone telefone2, Telefone telefone3, String email, Endereco endereco, String dataNascimento, float salarioBase, float valorHora, TipoDeColaborador tipo, StatusPessoa status) {
        this.nomeCompleto = nomeCompleto;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.telefone3 = telefone3;
        this.email = email;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.salarioBase = salarioBase;
        this.valorHora = valorHora;
        this.tipo = tipo;
        this.status = status;
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

    public Telefone getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(Telefone telefone1) {
        this.telefone1 = telefone1;
    }

    public Telefone getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(Telefone telefone2) {
        this.telefone2 = telefone2;
    }

    public Telefone getTelefone3() {
        return telefone3;
    }

    public void setTelefone3(Telefone telefone3) {
        this.telefone3 = telefone3;
    }

    public StatusPessoa getStatus() {
        return status;
    }

    public void setStatus(StatusPessoa status) {
        this.status = status;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
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

    public TipoDeColaborador getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeColaborador tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return id + ";" + nomeCompleto + ";" + telefone1 + ";" + telefone2 + ";" + telefone3 + ";" + email + ";" + endereco + ";" + dataNascimento + ";" + salarioBase + ";" + valorHora + ";" + tipo.getDescricao() + ";" + status.getDescricao();
    }
    
}
