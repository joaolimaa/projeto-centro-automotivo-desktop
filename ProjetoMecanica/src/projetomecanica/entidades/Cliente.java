 package projetomecanica.entidades;

import projetomecanica.entidades.dao.VeiculoDAO;
import projetomecanica.entidades.enums.StatusPessoa;
import projetomecanica.entidades.enums.TipoDeCliente;
import projetomecanica.servicos.Utils;

public class Cliente {
    
    private int id = 0;
    private String nomeCompleto = "";
    private Telefone telefone1 = new Telefone();
    private Telefone telefone2 = new Telefone();
    private Telefone telefone3 = new Telefone();
    private String email = "";
    private Endereco endereco = new Endereco();
    private TipoDeCliente tipo = TipoDeCliente.PESSOA_FISICA;
    private String cpf_cnpj = "";
    private String razaoSocial = "";
    private String nomeFantasia = "";
    private String dataNascimento = "";
    private StatusPessoa status = StatusPessoa.ATIVO;

    public Cliente() {}

    public Cliente(String nomeCompleto, Telefone telefone1, Telefone telefone2, Telefone telefone3, String email, Endereco endereco, TipoDeCliente tipo, String cpf_cnpj, String razaoSocial, String dataNascimento, StatusPessoa status, String nomeFantasia) throws Exception {
        if (!Utils.validaEmail(email)) throw new Exception("Email inválido");
        if (cpf_cnpj.length() > 11) if (!Utils.isCNPJ(cpf_cnpj)) throw new Exception("CNPJ inválido");
        else if (!Utils.isCPF(cpf_cnpj)) throw new Exception("CPF inválido");
        if (!Utils.dataIsValida(dataNascimento)) throw new Exception("Data de nascimento inválida");
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
        this.nomeFantasia = nomeFantasia;
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

    public void setEmail(String email) throws Exception {
        if (!Utils.validaEmail(email)) throw new Exception("Email inválido");
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

    public void setCpf_cnpj(String cpf_cnpj) throws Exception {
        if (cpf_cnpj.length() > 11) if (!Utils.isCNPJ(cpf_cnpj)) throw new Exception("CNPJ inválido");
        else if (!Utils.isCPF(cpf_cnpj)) throw new Exception("CPF inválido");
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) throws Exception {
        if (!Utils.dataIsValida(dataNascimento)) throw new Exception("Data de nascimento inválida");
        this.dataNascimento = dataNascimento;
    }

    public StatusPessoa getStatus() {
        return status;
    }

    public void setStatus(StatusPessoa status) {
        this.status = status;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    
    public Object[] listaValoresTabela(int id) throws Exception {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        int qtdVeiculos = veiculoDAO.listarTodosPorCliente(id).size();
        if (tipo.equals(TipoDeCliente.PESSOA_FISICA)) return new Object[] {razaoSocial, cpf_cnpj, qtdVeiculos, status};
        return new Object[] {razaoSocial, cpf_cnpj, qtdVeiculos, status};
    }

    @Override
    public String toString() {
        return id + ";" + nomeCompleto + ";" + telefone1.toString() + ";" + telefone2.toString() + ";" + telefone3.toString() + ";" + email + ";" + endereco.toString() + ";" + tipo.getDescricao() + ";" + cpf_cnpj + ";" + razaoSocial + ";" + dataNascimento + ";" + status.getDescricao() + ";" + nomeFantasia;
    }
    
}
