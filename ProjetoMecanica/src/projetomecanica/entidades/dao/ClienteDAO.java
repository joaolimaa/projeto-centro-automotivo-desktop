package projetomecanica.entidades.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import projetomecanica.entidades.Cliente;
import projetomecanica.entidades.Endereco;
import projetomecanica.entidades.Telefone;
import projetomecanica.entidades.enums.*;

public class ClienteDAO implements IDaoGenerico<Cliente>{
    
    private String nomeDoArquivoNoDisco = "banco\\Clientes.txt";

    @Override
    public void incluir(Cliente objeto) throws Exception {
        
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
    public void alterar(Cliente objeto) throws Exception {
        
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
    public Cliente consultarPorId(int id) throws Exception {
        
        try {
            
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            
            BufferedReader br = new BufferedReader(fr);
            
            String linha = "";
            
            while ((linha=br.readLine()) != null) {
                
                Cliente objetoCliente = new Cliente();
                
                String vetorString[] = linha.split(";");
                
                if (vetorString.length != 25) throw new Exception("Faltam dados na String");
                
                objetoCliente.setId(Integer.parseInt(vetorString[0]));
                
                if (objetoCliente.getId() == id) {
                    
                    objetoCliente.setNomeCompleto(vetorString[1]);
                
                    Telefone objetoTelefone1 = new Telefone();
                    objetoTelefone1.setNumero(Integer.parseInt(vetorString[2]), Integer.parseInt(vetorString[3]));
                    TipoDeTelefone tipo1 = TipoDeTelefone.valueOf(vetorString[4]);
                    objetoTelefone1.setTipo(tipo1);
                    
                    objetoCliente.setTelefone1(objetoTelefone1);

                    Telefone objetoTelefone2 = new Telefone();
                    objetoTelefone2.setDdd(Integer.parseInt(vetorString[5]));
                    objetoTelefone2.setNumero(Integer.parseInt(vetorString[6]));
                    TipoDeTelefone tipo2 = TipoDeTelefone.valueOf(vetorString[7]);
                    objetoTelefone2.setTipo(tipo2);
                    
                    objetoCliente.setTelefone2(objetoTelefone2);

                    Telefone objetoTelefone3 = new Telefone();
                    objetoTelefone3.setDdd(Integer.parseInt(vetorString[8]));
                    objetoTelefone3.setNumero(Integer.parseInt(vetorString[9]));
                    TipoDeTelefone tipo3 = TipoDeTelefone.valueOf(vetorString[10]);
                    objetoTelefone3.setTipo(tipo3);
                    
                    objetoCliente.setTelefone3(objetoTelefone3);

                    objetoCliente.setEmail(vetorString[11]);

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
                    
                    objetoCliente.setEndereco(endereco);

                    TipoDeCliente tipoCliente = TipoDeCliente.valueOf(vetorString[20]);
                    objetoCliente.setTipo(tipoCliente);
                    objetoCliente.setCpf_cnpj(vetorString[21]);
                    objetoCliente.setRazaoSocial(vetorString[22]);
                    objetoCliente.setDataNascimento(vetorString[23]);
                    StatusPessoa status = StatusPessoa.valueOf(vetorString[24]);
                    objetoCliente.setStatus(status);
                
                    br.close();
                    
                    return objetoCliente;
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
            
            ArrayList<Cliente> listaDeClientes = obterTodasEntidades();
            
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < listaDeClientes.size(); i++) {
                if (listaDeClientes.get(i).getId() == id) {
                    listaDeClientes.get(i).setStatus(StatusPessoa.INATIVO);
                }
                bw.write(listaDeClientes.get(i).toString()+"\n");
            }
            
            bw.close();
            
        } catch (Exception erro) {
            throw erro;
        }
        
    }

    @Override
    public ArrayList<Cliente> obterTodasEntidades() throws Exception {
        
        try {
            
            ArrayList<Cliente> listaDeClientes = new ArrayList();
            
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            
            BufferedReader br = new BufferedReader(fr);
            
            String linha = "";
            
            while ((linha = br.readLine()) != null) {
                
                Cliente objetoCliente = new Cliente();
                
                String vetorString[] = linha.split(";");
                
                if (vetorString.length != 28) throw new Exception("Faltam dados na String");
                
                objetoCliente.setId(Integer.parseInt(vetorString[0]));
                objetoCliente.setNomeCompleto(vetorString[1]);
                
                Telefone objetoTelefone1 = new Telefone();
                objetoTelefone1.setDdd(Integer.parseInt(vetorString[2]));
                objetoTelefone1.setNumero(Integer.parseInt(vetorString[3]));
                TipoDeTelefone tipo1 = TipoDeTelefone.valueOf(vetorString[4]);
                objetoTelefone1.setTipo(tipo1);

                objetoCliente.setTelefone1(objetoTelefone1);

                Telefone objetoTelefone2 = new Telefone();
                objetoTelefone2.setDdd(Integer.parseInt(vetorString[5]));
                objetoTelefone2.setNumero(Integer.parseInt(vetorString[6]));
                TipoDeTelefone tipo2 = TipoDeTelefone.valueOf(vetorString[7]);
                objetoTelefone2.setTipo(tipo2);

                objetoCliente.setTelefone2(objetoTelefone2);

                Telefone objetoTelefone3 = new Telefone();
                objetoTelefone3.setDdd(Integer.parseInt(vetorString[8]));
                objetoTelefone3.setNumero(Integer.parseInt(vetorString[9]));
                TipoDeTelefone tipo3 = TipoDeTelefone.valueOf(vetorString[10]);
                objetoTelefone3.setTipo(tipo3);

                objetoCliente.setTelefone3(objetoTelefone3);

                objetoCliente.setEmail(vetorString[11]);

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

                objetoCliente.setEndereco(endereco);

                TipoDeCliente tipoCliente = TipoDeCliente.valueOf(vetorString[20]);
                objetoCliente.setTipo(tipoCliente);
                objetoCliente.setCpf_cnpj(vetorString[21]);
                objetoCliente.setRazaoSocial(vetorString[22]);
                objetoCliente.setDataNascimento(vetorString[23]);
                StatusPessoa status = StatusPessoa.valueOf(vetorString[24]);
                objetoCliente.setStatus(status);
                
                listaDeClientes.add(objetoCliente);
            }
            
            br.close();
            
            return listaDeClientes;
            
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    @Override
    public List<Cliente> obterEntidadesAtivos() throws Exception {
        
        try {
            
            ArrayList<Cliente> listaDeClientes = obterTodasEntidades();
            
            List<Cliente> listaDeClientesAtivos = listaDeClientes.stream()
                    .filter(i -> i.getStatus().equals(StatusPessoa.ATIVO))
                    .collect(Collectors.toList());
            
            return listaDeClientesAtivos;
            
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    public void excluir(int id) throws Exception {
        
        try {
            
            ArrayList<Cliente> listaDeClientes = this.obterTodasEntidades();
            
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < listaDeClientes.size(); i++) {
                if (listaDeClientes.get(i).getId() != id) bw.write(listaDeClientes.get(i).toString()+"\n");
            }
            
            bw.close();
            
        } catch (Exception erro) {
            throw erro;
        }
        
    }
    
}
