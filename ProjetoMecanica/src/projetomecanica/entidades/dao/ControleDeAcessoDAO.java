package projetomecanica.entidades.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import projetomecanica.entidades.ControleDeAcesso;

public class ControleDeAcessoDAO implements IDaoGenerico<ControleDeAcesso>{
    
    private String nomeDoArquivoNoDisco = "banco\\ControleDeAcessos.txt";

    @Override
    public void incluir(ControleDeAcesso objeto) throws Exception {
        
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
    public void alterar(ControleDeAcesso objeto) throws Exception {
        
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
    public ControleDeAcesso consultarPorId(int id) throws Exception {
        
        try {
            
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            
            BufferedReader br = new BufferedReader(fr);
            
            String linha = "";
            
            while ((linha=br.readLine()) != null) {
                
                ControleDeAcesso objetoControleDeAcesso = new ControleDeAcesso();
                
                String vetorString[] = linha.split(";");
                
                if (vetorString.length != 11) throw new Exception("Faltam dados na String");
                
                objetoControleDeAcesso.setId(Integer.parseInt(vetorString[0]));
                
                if (objetoControleDeAcesso.getId() == id) {
                    
                    objetoControleDeAcesso.setDescricao(vetorString[1]);
                    objetoControleDeAcesso.setAcessoCliente(Boolean.getBoolean(vetorString[2]));
                    objetoControleDeAcesso.setAcessoColaborador(Boolean.getBoolean(vetorString[3]));
                    objetoControleDeAcesso.setAcessoPeca(Boolean.getBoolean(vetorString[4]));
                    objetoControleDeAcesso.setAcessoServico(Boolean.getBoolean(vetorString[5]));
                    objetoControleDeAcesso.setAcessoVeiculo(Boolean.getBoolean(vetorString[6]));
                    objetoControleDeAcesso.setAcessoOrcamento(Boolean.getBoolean(vetorString[7]));
                    objetoControleDeAcesso.setAcessoNotaFiscal(Boolean.getBoolean(vetorString[8]));
                    objetoControleDeAcesso.setAcessoOrdemDeServico(Boolean.getBoolean(vetorString[9]));
                    objetoControleDeAcesso.setAcessoConfiguracao(Boolean.getBoolean(vetorString[10]));
                
                    br.close();
                    
                    return objetoControleDeAcesso;
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
            
            ArrayList<ControleDeAcesso> listaDeControleDeAcessos = obterTodasEntidades();
            
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < listaDeControleDeAcessos.size(); i++) {
                if (listaDeControleDeAcessos.get(i).getId() == id) {
                    //listaDePecas.get(i).setStatus(StatusPeca.INATIVO);
                }
                bw.write(listaDeControleDeAcessos.get(i).toString()+"\n");
            }
            
            bw.close();
            
        } catch (Exception erro) {
            throw erro;
        }
        
    }

    @Override
    public ArrayList<ControleDeAcesso> obterTodasEntidades() throws Exception {
        
        try {
            
            ArrayList<ControleDeAcesso> listaDeControleDeAcessos = new ArrayList();
            
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            
            BufferedReader br = new BufferedReader(fr);
            
            String linha = "";
            
            while ((linha = br.readLine()) != null) {
                
                ControleDeAcesso objetoControleDeAcesso = new ControleDeAcesso();
                
                String vetorString[] = linha.split(";");
                
                if (vetorString.length != 11) throw new Exception("Faltam dados na String");
                
                objetoControleDeAcesso.setId(Integer.parseInt(vetorString[0]));
                objetoControleDeAcesso.setDescricao(vetorString[1]);
                objetoControleDeAcesso.setAcessoCliente(Boolean.getBoolean(vetorString[2]));
                objetoControleDeAcesso.setAcessoColaborador(Boolean.getBoolean(vetorString[3]));
                objetoControleDeAcesso.setAcessoPeca(Boolean.getBoolean(vetorString[4]));
                objetoControleDeAcesso.setAcessoServico(Boolean.getBoolean(vetorString[5]));
                objetoControleDeAcesso.setAcessoVeiculo(Boolean.getBoolean(vetorString[6]));
                objetoControleDeAcesso.setAcessoOrcamento(Boolean.getBoolean(vetorString[7]));
                objetoControleDeAcesso.setAcessoNotaFiscal(Boolean.getBoolean(vetorString[8]));
                objetoControleDeAcesso.setAcessoOrdemDeServico(Boolean.getBoolean(vetorString[9]));
                objetoControleDeAcesso.setAcessoConfiguracao(Boolean.getBoolean(vetorString[10]));
                        
                listaDeControleDeAcessos.add(objetoControleDeAcesso);
            }
            
            br.close();
            
            return listaDeControleDeAcessos;
            
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    @Override
    public List<ControleDeAcesso> obterEntidadesAtivos() throws Exception {
        
        try {
            
            ArrayList<ControleDeAcesso> listaDeControleDeAcessos = obterTodasEntidades();
            
            List<ControleDeAcesso> listaDeControleDeAcessosAtivos = listaDeControleDeAcessos.stream().collect(Collectors.toList());
            
            return listaDeControleDeAcessosAtivos;
            
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    public void excluir(int id) throws Exception {
        
        try {
            
            ArrayList<ControleDeAcesso> listaDeAcessos = this.obterTodasEntidades();
            
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < listaDeAcessos.size(); i++) {
                if (listaDeAcessos.get(i).getId() != id) bw.write(listaDeAcessos.get(i).toString()+"\n");
            }
            
            bw.close();
            
        } catch (Exception erro) {
            throw erro;
        }
        
    }
    
    public int consultaByDescricao(String descricao) throws Exception {
        
        try {
            
            ArrayList<ControleDeAcesso> listaDeControleDeAcessos = obterTodasEntidades();
            
            for (int i = 0; i < listaDeControleDeAcessos.size(); i++) {
                if(listaDeControleDeAcessos.get(i).getDescricao().equals(descricao)) return listaDeControleDeAcessos.get(i).getId();
            }
            
            throw new Exception("Controle de Acesso não identificado");
            
        } catch (Exception erro) {
            throw erro;
        }
        
    }
    
}
