 package projetomecanica.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import projetomecanica.entidades.enums.TipoDeCliente;

public class Cliente {
    
    private int id = 0;
    private String nomeCompleto;
    private ArrayList<Telefone> telefones;
    private String email;
    private Endereco endereco;
    private TipoDeCliente tipo;
    private String cpf_cnpj;
    private String razaoSocial;
    private LocalDate dataNascimento;
    private Veiculo veiculo;

    public Cliente() {}

    public Cliente(String nomeCompleto, ArrayList<Telefone> telefones, String email, Endereco endereco, TipoDeCliente tipo, String cpf_cnpj, String razaoSocial, LocalDate dataNascimento, Veiculo veiculo) {
        this.nomeCompleto = nomeCompleto;
        this.telefones = telefones;
        this.email = email;
        this.endereco = endereco;
        this.tipo = tipo;
        this.cpf_cnpj = cpf_cnpj;
        this.razaoSocial = razaoSocial;
        this.dataNascimento = dataNascimento;
        this.veiculo = veiculo;
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

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public String toString() {
        return id + ";" + nomeCompleto + ";" + telefones + ";" + email + ";" + endereco + ";" + tipo + ";" + cpf_cnpj + ";" + razaoSocial + ";" + dataNascimento + ";" + veiculo;
    }
    
}
