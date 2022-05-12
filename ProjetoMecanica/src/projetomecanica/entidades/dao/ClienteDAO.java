/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetomecanica.entidades.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import projetomecanica.entidades.Cliente;

/**
 *
 * @author leona
 */
public class ClienteDAO implements IDaoGenerico<Cliente>{
    
    private String nomeDoArquivoNoDisco = "Cliente.txt";

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
        
        this.excluir(objeto.getId());
        
        try {
            
            objeto.setId(objeto.getId());
            
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco, true);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(objeto.toString()+"\n");
            
            bw.close();
            
        } catch (Exception erro) {
            throw erro;
        }
        
    }

    @Override
    public Cliente consultar(int id) throws Exception {
        
        try {
            
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            
            BufferedReader br = new BufferedReader(fr);
            
            String linha = "";
            
            while ((linha=br.readLine()) != null) {
                
                Cliente objetoCliente = new Cliente();
                
                String vetorString[] = linha.split(";");
                
                if (vetorString.length != 5) throw new Exception("Faltam dados na String");
                
                objetoCliente.setId(Integer.parseInt(vetorString[0]));
                
                objetoCliente.setNomeCompleto(vetorString[1]);
                
                objetoCliente.setTelefone(Integer.parseInt(vetorString[2]));
                
                objetoCliente.setEmail(vetorString[3]);
                
                objetoCliente.setEndereco(vetorString[4]);
                
                if (objetoCliente.getId() == id) {
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
    public void excluir(int id) throws Exception {
        
        try {
            
            ArrayList<Cliente> listaDeClientes = obterEntidades();
            
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

    @Override
    public ArrayList<Cliente> obterEntidades() throws Exception {
        
        try {
            
            ArrayList<Cliente> listaDeClientes = new ArrayList<Cliente>();
            
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            
            BufferedReader br = new BufferedReader(fr);
            
            String linha = "";
            
            while ((linha=br.readLine()) != null) {
                
                Cliente objetoCliente = new Cliente();
                
                String vetorString[] = linha.split(";");
                
                if (vetorString.length != 5) throw new Exception("Faltam dados na String");
                
                objetoCliente.setId(Integer.parseInt(vetorString[0]));
                
                objetoCliente.setNomeCompleto(vetorString[1]);
                
                objetoCliente.setTelefone(Integer.parseInt(vetorString[2]));
                
                objetoCliente.setEmail(vetorString[3]);
                
                objetoCliente.setEndereco(vetorString[4]);
                
                listaDeClientes.add(objetoCliente);
            }
            
            br.close();
            
            return listaDeClientes;
            
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    
    
}
