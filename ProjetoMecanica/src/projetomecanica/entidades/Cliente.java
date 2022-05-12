package projetomecanica.entidades;

import java.time.LocalDate;
import projetomecanica.entidades.enums.Status;
import projetomecanica.entidades.enums.TipoDeCliente;

public class Cliente {
    
    private int id = 0;
    private String nomeCompleto = "";
    private Telefone telefone1;
    private Telefone telefone2;
    private Telefone telefone3;
    private String email = "";
    private Endereco endereco;
    private TipoDeCliente tipo = TipoDeCliente.PESSOA_FISICA;
    private String cpf_cnpj = "";
    private String razaoSocial = "";
    private LocalDate dataNascimento;
    private Status status = Status.ATIVO;

    public Cliente() {}

    public Cliente(String nomeCompleto, Telefone telefone1, Telefone telefone2, Telefone telefone3, String email, Endereco endereco, TipoDeCliente tipo, String cpf_cnpj, String razaoSocial, LocalDate dataNascimento, Status status) {
        this.nomeCompleto = nomeCompleto;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.telefone3 = telefone3;
        this.email = email;
        this.endereco = endereco;
        this.tipo = tipo;
        this.cpf_cnpj = cpf_cnpj;
        this.razaoSocial = razaoSocial;
        this.dataNascimento = dataNascimento;
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

    public TipoDeCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeCliente tipo) {
        this.tipo = tipo;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return id + ";" + nomeCompleto + ";" + telefone1 + ";" + telefone2 + ";" + telefone3 + ";" + email + ";" + endereco + ";" + tipo + ";" + cpf_cnpj + ";" + razaoSocial + ";" + dataNascimento + ";" + status;
    }
    
}
