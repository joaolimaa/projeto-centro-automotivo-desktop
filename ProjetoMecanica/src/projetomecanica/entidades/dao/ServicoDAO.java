package projetomecanica.entidades.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import projetomecanica.entidades.Servico;

public class ServicoDAO implements IDaoGenerico<Servico>{
    
    private String nomeDoArquivoNoDisco = "banco\\Servicos.txt";

    @Override
    public void incluir(Servico objeto) throws Exception {
        
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
    public void alterar(Servico objeto) throws Exception {
        
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
    public Servico consultarPorId(int id) throws Exception {
        
        try {
            
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            
            BufferedReader br = new BufferedReader(fr);
            
            String linha = "";
            
            while ((linha=br.readLine()) != null) {
                
                Servico objetoServico = new Servico();
                
                String vetorString[] = linha.split(";");
                
                if (vetorString.length != 3) throw new Exception("Faltam dados na String");
                
                objetoServico.setId(Integer.parseInt(vetorString[0]));
                
                
                if (objetoServico.getId() == id) {
                    
                    objetoServico.setDescricao(vetorString[1]);
                    objetoServico.setValor(Float.parseFloat(vetorString[2]));
                
                    br.close();
                    
                    return objetoServico;
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
            
            ArrayList<Servico> listaDeServicos = obterTodasEntidades();
            
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < listaDeServicos.size(); i++) {
                if (listaDeServicos.get(i).getId() == id) {
                    //listaDeServicos.get(i).setStatus(StatusServico.INATIVO);
                }
                bw.write(listaDeServicos.get(i).toString()+"\n");
            }
            
            bw.close();
            
        } catch (Exception erro) {
            throw erro;
        }
        
    }

    @Override
    public ArrayList<Servico> obterTodasEntidades() throws Exception {
        
        try {
            
            ArrayList<Servico> listaDeServicos = new ArrayList();
            
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            
            BufferedReader br = new BufferedReader(fr);
            
            String linha = "";
            
            while ((linha = br.readLine()) != null) {
                
                Servico objetoServico = new Servico();
                
                String vetorString[] = linha.split(";");
                
                if (vetorString.length != 3) throw new Exception("Faltam dados na String");
                
                objetoServico.setId(Integer.parseInt(vetorString[0]));
                objetoServico.setDescricao(vetorString[1]);
                objetoServico.setValor(Float.parseFloat(vetorString[2]));
                        
                listaDeServicos.add(objetoServico);
            }
            
            br.close();
            
            return listaDeServicos;
            
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    @Override
    public List<Servico> obterEntidadesAtivos() throws Exception {
        
        try {
            
            ArrayList<Servico> listaDeServicos = new ArrayList<>();
            
            return listaDeServicos;
            
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    public void excluir(int id) throws Exception {
        
        try {
            
            ArrayList<Servico> listaDeServicos = this.obterTodasEntidades();
            
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < listaDeServicos.size(); i++) {
                if (listaDeServicos.get(i).getId() != id) bw.write(listaDeServicos.get(i).toString()+"\n");
            }
            
            bw.close();
            
        } catch (Exception erro) {
            throw erro;
        }
        
    }
    
}
