package projetomecanica.entidades.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import projetomecanica.entidades.Colaborador;
import projetomecanica.entidades.ControleDeAcesso;
import projetomecanica.entidades.Endereco;
import projetomecanica.entidades.Telefone;
import projetomecanica.entidades.enums.*;

public class ColaboradorDAO implements IDaoGenerico<Colaborador>{
    
    private String nomeDoArquivoNoDisco = "banco\\Colaboradores.txt";

    @Override
    public void incluir(Colaborador objeto) throws Exception {
        
        try {
            
            int id = GeradorIdentificador.getID();
            
            objeto.setId(id);
            
            //cria o arquivo (false) / modifica o arquivo (true)
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);
            
            //Criar o buffer do arquivo
            BufferedWriter bw = new BufferedWriter(fw);
            
            //escreve no arquivo
            bw.write(objeto.toString()+"\n");
            
            //fecha o arquivo
            bw.close();
            
        } catch (Exception erro) {
            throw erro;
        }
    }

    @Override
    public void alterar(Colaborador objeto) throws Exception {
        
        int id = objeto.getId();
        
        this.excluir(id);
        
        try {
            
            objeto.setId(id);
            
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(objeto.toString()+"\n");
            
            bw.close();
            
        } catch (Exception erro) {
            throw erro;
        }
        
    }

    @Override
    public Colaborador consultarPorId(int id) throws Exception {
        
        try {
            
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            
            BufferedReader br = new BufferedReader(fr);
            
            String linha = "";
            
            while ((linha=br.readLine()) != null) {
                
                Colaborador objetoColaborador = new Colaborador();
                
                String vetorString[] = linha.split(";");
                
                if (vetorString.length != 27) throw new Exception("Faltam dados na String");
                
                objetoColaborador.setId(Integer.parseInt(vetorString[0]));
                
                if (objetoColaborador.getId() == id) {

                    objetoColaborador.setNomeCompleto(vetorString[1]);

                    Telefone objetoTelefone1 = new Telefone();
                    objetoTelefone1.setNumero(Integer.parseInt(vetorString[2]), Integer.parseInt(vetorString[3]));
                    TipoDeTelefone tipo1 = TipoDeTelefone.valueOf(vetorString[4]);
                    objetoTelefone1.setTipo(tipo1);

                    objetoColaborador.setTelefone1(objetoTelefone1);

                    Telefone objetoTelefone2 = new Telefone();
                    objetoTelefone2.setNumero(Integer.parseInt(vetorString[5]), Integer.parseInt(vetorString[6]));
                    TipoDeTelefone tipo2 = TipoDeTelefone.valueOf(vetorString[7]);
                    objetoTelefone2.setTipo(tipo2);

                    objetoColaborador.setTelefone2(objetoTelefone2);

                    Telefone objetoTelefone3 = new Telefone();
                    objetoTelefone3.setNumero(Integer.parseInt(vetorString[8]), Integer.parseInt(vetorString[9]));
                    TipoDeTelefone tipo3 = TipoDeTelefone.valueOf(vetorString[10]);
                    objetoTelefone3.setTipo(tipo3);

                    objetoColaborador.setTelefone3(objetoTelefone3);

                    objetoColaborador.setEmail(vetorString[11]);

                    Endereco endereco = new Endereco();
                    TipoDeLogradouro tipoLog = TipoDeLogradouro.valueOf(vetorString[12]);
                    endereco.setTipoLogradouro(tipoLog);
                    endereco.setLogradouro(vetorString[13]);
                    endereco.setComplemento(vetorString[14]);
                    endereco.setBairro(vetorString[15]);
                    endereco.setCidade(vetorString[16]);
                    endereco.setCep(Integer.parseInt(vetorString[17]));
                    endereco.setEstado(vetorString[18]);
                    endereco.setNumero(Integer.parseInt(vetorString[19]));
                    objetoColaborador.setEndereco(endereco);

                    objetoColaborador.setDataNascimento(vetorString[20]);
                    objetoColaborador.setSalarioBase(Float.parseFloat(vetorString[21]));
                    objetoColaborador.setValorHora(Float.parseFloat(vetorString[22]));
                    TipoDeColaborador tipoColaborador = TipoDeColaborador.valueOf(vetorString[23]);
                    objetoColaborador.setTipo(tipoColaborador);
                    StatusPessoa status = StatusPessoa.valueOf(vetorString[24]);
                    objetoColaborador.setStatus(status);
                    objetoColaborador.setSenha(vetorString[25]);
                    objetoColaborador.setIdControleDeAcesso(Integer.parseInt(vetorString[26]));
                
                    br.close();
                    
                    return objetoColaborador;
                }
            }
            
            br.close();
            
            throw new Exception("ID NÃO EXISTE");
            
        } catch (Exception erro) {
            throw erro;
        }
        
    }

    @Override
    public void inativarPorId(int id) throws Exception {
        
        try {
            
            ArrayList<Colaborador> listaDeColaboradores = obterTodasEntidades();
            
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < listaDeColaboradores.size(); i++) {
                if (listaDeColaboradores.get(i).getId() == id) {
                    listaDeColaboradores.get(i).setStatus(StatusPessoa.INATIVO);
                }
                bw.write(listaDeColaboradores.get(i).toString()+"\n");
            }
            
            bw.close();
            
        } catch (Exception erro) {
            throw erro;
        }
        
    }

    @Override
    public ArrayList<Colaborador> obterTodasEntidades() throws Exception {
        
        try {
            
            ArrayList<Colaborador> listaDeColaboradores = new ArrayList();
            
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            
            BufferedReader br = new BufferedReader(fr);
            
            String linha = "";
            
            while ((linha = br.readLine()) != null) {
                
                Colaborador objetoColaborador = new Colaborador();
                
                String vetorString[] = linha.split(";");
                
                if (vetorString.length != 27) throw new Exception("Faltam dados na String");
                
                objetoColaborador.setId(Integer.parseInt(vetorString[0]));
                objetoColaborador.setNomeCompleto(vetorString[1]);

                Telefone objetoTelefone1 = new Telefone();
                objetoTelefone1.setNumero(Integer.parseInt(vetorString[2]), Integer.parseInt(vetorString[3]));
                TipoDeTelefone tipo1 = TipoDeTelefone.valueOf(vetorString[4]);
                objetoTelefone1.setTipo(tipo1);

                objetoColaborador.setTelefone1(objetoTelefone1);

                Telefone objetoTelefone2 = new Telefone();
                objetoTelefone2.setNumero(Integer.parseInt(vetorString[5]), Integer.parseInt(vetorString[6]));
                TipoDeTelefone tipo2 = TipoDeTelefone.valueOf(vetorString[7]);
                objetoTelefone2.setTipo(tipo2);

                objetoColaborador.setTelefone2(objetoTelefone2);

                Telefone objetoTelefone3 = new Telefone();
                objetoTelefone3.setNumero(Integer.parseInt(vetorString[8]), Integer.parseInt(vetorString[9]));
                TipoDeTelefone tipo3 = TipoDeTelefone.valueOf(vetorString[10]);
                objetoTelefone3.setTipo(tipo3);

                objetoColaborador.setTelefone3(objetoTelefone3);

                objetoColaborador.setEmail(vetorString[11]);

                Endereco endereco = new Endereco();
                TipoDeLogradouro tipoLog = TipoDeLogradouro.valueOf(vetorString[12]);
                endereco.setTipoLogradouro(tipoLog);
                endereco.setLogradouro(vetorString[13]);
                endereco.setComplemento(vetorString[14]);
                endereco.setBairro(vetorString[15]);
                endereco.setCidade(vetorString[16]);
                endereco.setCep(Integer.parseInt(vetorString[17]));
                endereco.setEstado(vetorString[18]);
                endereco.setNumero(Integer.parseInt(vetorString[19]));
                objetoColaborador.setEndereco(endereco);

                objetoColaborador.setDataNascimento(vetorString[20]);
                objetoColaborador.setSalarioBase(Float.parseFloat(vetorString[21]));
                objetoColaborador.setValorHora(Float.parseFloat(vetorString[22]));
                TipoDeColaborador tipoColaborador = TipoDeColaborador.valueOf(vetorString[23]);
                objetoColaborador.setTipo(tipoColaborador);
                StatusPessoa status = StatusPessoa.valueOf(vetorString[24]);
                objetoColaborador.setStatus(status);
                objetoColaborador.setSenha(vetorString[25]);
                objetoColaborador.setIdControleDeAcesso(Integer.parseInt(vetorString[26]));
                
                listaDeColaboradores.add(objetoColaborador);
            }
            
            br.close();
            
            return listaDeColaboradores;
            
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    @Override
    public List<Colaborador> obterEntidadesAtivos() throws Exception {
        
        try {
            
            ArrayList<Colaborador> listaDeColaboradores = obterTodasEntidades();
            
            List<Colaborador> listaDeColaboradoresAtivos = listaDeColaboradores.stream()
                    .filter(i -> i.getStatus().equals(StatusPessoa.ATIVO))
                    .collect(Collectors.toList());
            
            return listaDeColaboradoresAtivos;
            
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    public void excluir(int id) throws Exception {
        
        try {
            
            ArrayList<Colaborador> listaDeColaboradores = this.obterTodasEntidades();
            
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < listaDeColaboradores.size(); i++) {
                if (listaDeColaboradores.get(i).getId() != id) bw.write(listaDeColaboradores.get(i).toString()+"\n");
            }
            
            bw.close();
            
        } catch (Exception erro) {
            throw erro;
        }
        
    }
    
    public boolean isAcessoLiberado(int idControleDeAcesso, TelasAcessadas tela) throws Exception {
        
        try {
            
            ControleDeAcessoDAO controleDeAcessoDAO = new ControleDeAcessoDAO();
            
            ControleDeAcesso controleDeAcesso = controleDeAcessoDAO.consultarPorId(idControleDeAcesso);
            
            if (tela.equals(TelasAcessadas.CONFIGURACOES) && controleDeAcesso.isAcessoConfiguracao()) return true;
            if (tela.equals(TelasAcessadas.CADASTRO_CLIENTE) && controleDeAcesso.isAcessoCliente()) return true;
            if (tela.equals(TelasAcessadas.CADASTRO_COLABORADOR) && controleDeAcesso.isAcessoColaborador()) return true;
            if (tela.equals(TelasAcessadas.CADASTRO_NF) && controleDeAcesso.isAcessoNotaFiscal()) return true;
            if (tela.equals(TelasAcessadas.CADASTRO_ORCAMENTO) && controleDeAcesso.isAcessoOrcamento()) return true;
            if (tela.equals(TelasAcessadas.CADASTRO_PECA) && controleDeAcesso.isAcessoPeca()) return true;
            if (tela.equals(TelasAcessadas.CADASTRO_VEICULO) && controleDeAcesso.isAcessoVeiculo()) return true;
            if (tela.equals(TelasAcessadas.CADASTRO_OS) && controleDeAcesso.isAcessoOrdemDeServico()) return true;
            if (tela.equals(TelasAcessadas.LISTAGEM_CLIENTE) && controleDeAcesso.isAcessoCliente()) return true;
            if (tela.equals(TelasAcessadas.LISTAGEM_COLABORADOR) && controleDeAcesso.isAcessoColaborador()) return true;
            if (tela.equals(TelasAcessadas.LISTAGEM_NF) && controleDeAcesso.isAcessoNotaFiscal()) return true;
            if (tela.equals(TelasAcessadas.LISTAGEM_ORCAMENTO) && controleDeAcesso.isAcessoOrcamento()) return true;
            if (tela.equals(TelasAcessadas.LISTAGEM_OS) && controleDeAcesso.isAcessoOrdemDeServico()) return true;
            if (tela.equals(TelasAcessadas.LISTAGEM_PECA) && controleDeAcesso.isAcessoPeca()) return true;
            if (tela.equals(TelasAcessadas.LISTAGEM_VEICULO) && controleDeAcesso.isAcessoVeiculo()) return true;
            
            return false;
            
        } catch (Exception erro) {
            throw erro;
        }
        
    }
    
    public void login(String email, String senha) throws Exception {
        
        try {
            
            ArrayList<Colaborador> listaDeColaboradores = this.obterTodasEntidades();
            Colaborador colaborador = new Colaborador();
            
            for (int i = 0; i < listaDeColaboradores.size(); i++) {
                if (listaDeColaboradores.get(i).getEmail().equals(email)) {
                    colaborador = listaDeColaboradores.get(i);
                    break;
                }
                if (i == listaDeColaboradores.size()-1) throw new Exception("Email incorreto!");
            }
            if (!colaborador.getSenha().equals(senha)) throw new Exception("Senha incorreta!");
            
            
        } catch (Exception erro) {
            throw erro;
        }
        
    }
    
}
