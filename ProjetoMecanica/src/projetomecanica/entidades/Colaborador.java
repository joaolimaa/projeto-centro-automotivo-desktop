package projetomecanica.entidades;

import projetomecanica.entidades.dao.ControleDeAcessoDAO;
import projetomecanica.entidades.enums.StatusPessoa;
import projetomecanica.entidades.enums.TipoDeColaborador;
import projetomecanica.servicos.Utils;

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
    private String senha = "12345";
    private int idControleDeAcesso = 0;
    private String cpf = "";
    private String matricula = "";
    
    public Colaborador() {}

    public Colaborador(String nomeCompleto, Telefone telefone1, Telefone telefone2, Telefone telefone3, String email, Endereco endereco, String dataNascimento, float salarioBase, float valorHora, TipoDeColaborador tipo, StatusPessoa status, String senha, int idControleDeAcesso, String cpf, String matricula ) throws Exception {
        if (!Utils.validaEmail(email)) throw new Exception("Email inválido");
        if (!Utils.validaNumero(salarioBase)) throw new Exception("Salario inválido");
        if (!Utils.validaNumero(valorHora)) throw new Exception("Valor hora inválido");
        if (!Utils.dataIsValida(dataNascimento)) throw new Exception("Data de nascimento inválida");
        if (!Utils.validaSenha(senha)) throw new Exception("Senha inválida, deve ser 8 caracteres");
        if (!Utils.isCPF(cpf)) throw new Exception("CPF inválido");
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
        this.senha = senha;
        this.idControleDeAcesso = idControleDeAcesso;
        this.cpf = cpf;
        this.matricula = matricula;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) throws Exception {
        if (!Utils.dataIsValida(dataNascimento)) throw new Exception("Data de nascimento inválida");
        this.dataNascimento = dataNascimento;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) throws Exception {
        if (!Utils.validaNumero(salarioBase)) throw new Exception("Salario inválido");
        this.salarioBase = salarioBase;
    }

    public float getValorHora() {
        return valorHora;
    }

    public void setValorHora(float valorHora) throws Exception {
        if (!Utils.validaNumero(valorHora)) throw new Exception("Valor hora inválido");
        this.valorHora = valorHora;
    }

    public TipoDeColaborador getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeColaborador tipo) {
        this.tipo = tipo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdControleDeAcesso() {
        return idControleDeAcesso;
    }

    public void setIdControleDeAcesso(int idControleDeAcesso) {
        this.idControleDeAcesso = idControleDeAcesso;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws Exception {
        if (!Utils.isCPF(cpf)) throw new Exception("CPF inválido");
        this.cpf = cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public Object[] listaValoresTabela() throws Exception {
        return new Object[] {nomeCompleto, cpf, tipo, status};
    }
    
    public Object[] listaValoresTabelaOrcamentoFinal() throws Exception {
        return new Object[] {nomeCompleto, 0};
    }
    
    public Object[] listaValoresTabelaOrcamento() throws Exception {
        return new Object[] {nomeCompleto, cpf};
    }
    
    public Object[] listaValoresTabelaAcesso() throws Exception {
        ControleDeAcessoDAO controleDeAcessoDAO = new ControleDeAcessoDAO();
        return new Object[] {nomeCompleto, cpf, controleDeAcessoDAO.consultarPorId(idControleDeAcesso).getDescricao()};
    }

    @Override
    public String toString() {
        return id + ";" + nomeCompleto + ";" + telefone1.toString() + ";" + telefone2.toString() + ";" + telefone3.toString() + ";" + email + ";" + endereco.toString() + ";" + dataNascimento + ";" + salarioBase + ";" + valorHora + ";" + tipo + ";" + status + ";" + senha + ";" + idControleDeAcesso + ";" + cpf + ";" + matricula;
    }
    
}
