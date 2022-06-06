package projetomecanica.entidades.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import projetomecanica.entidades.Peca;

public class PecaDAO implements IDaoGenerico<Peca>{
    
    private String nomeDoArquivoNoDisco = "banco\\Pecas.txt";

    @Override
    public void incluir(Peca objeto) throws Exception {
        
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
    public void alterar(Peca objeto) throws Exception {
        
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
    public Peca consultarPorId(int id) throws Exception {
        
        try {
            
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            
            BufferedReader br = new BufferedReader(fr);
            
            String linha = "";
            
            while ((linha=br.readLine()) != null) {
                
                Peca objetoPeca = new Peca();
                
                String vetorString[] = linha.split(";");
                
                if (vetorString.length != 8) throw new Exception("Faltam dados na String");
                
                objetoPeca.setId(Integer.parseInt(vetorString[0]));
                
                if (objetoPeca.getId() == id) {
                    
                    objetoPeca.setCodigo(Integer.parseInt(vetorString[1]));
                    objetoPeca.setDescricao(vetorString[2]);
                    objetoPeca.setQtdEstoque(Integer.parseInt(vetorString[3]));
                    objetoPeca.setQtdMinEstoque(Integer.parseInt(vetorString[4]));
                    objetoPeca.setReservadas(Integer.parseInt(vetorString[5]));
                    objetoPeca.setValorUnitario(Float.parseFloat(vetorString[6]));
                    objetoPeca.setVidaUtilEmDias(Integer.parseInt(vetorString[7]));
                
                    br.close();
                    
                    return objetoPeca;
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
            
            ArrayList<Peca> listaDePecas = obterTodasEntidades();
            
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < listaDePecas.size(); i++) {
                if (listaDePecas.get(i).getId() == id) {
                    //listaDePecas.get(i).setStatus(StatusPeca.INATIVO);
                }
                bw.write(listaDePecas.get(i).toString()+"\n");
            }
            
            bw.close();
            
        } catch (Exception erro) {
            throw erro;
        }
        
    }

    @Override
    public ArrayList<Peca> obterTodasEntidades() throws Exception {
        
        try {
            
            ArrayList<Peca> listaDePecas = new ArrayList();
            
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            
            BufferedReader br = new BufferedReader(fr);
            
            String linha = "";
            
            while ((linha = br.readLine()) != null) {
                
                Peca objetoPeca = new Peca();
                
                String vetorString[] = linha.split(";");
                
                if (vetorString.length != 8) throw new Exception("Faltam dados na String");
                
                objetoPeca.setId(Integer.parseInt(vetorString[0]));
                objetoPeca.setCodigo(Integer.parseInt(vetorString[1]));
                objetoPeca.setDescricao(vetorString[2]);
                objetoPeca.setQtdEstoque(Integer.parseInt(vetorString[3]));
                objetoPeca.setQtdMinEstoque(Integer.parseInt(vetorString[4]));
                objetoPeca.setReservadas(Integer.parseInt(vetorString[5]));
                objetoPeca.setValorUnitario(Float.parseFloat(vetorString[6]));
                objetoPeca.setVidaUtilEmDias(Integer.parseInt(vetorString[7]));
                        
                listaDePecas.add(objetoPeca);
            }
            
            br.close();
            
            return listaDePecas;
            
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    @Override
    public List<Peca> obterEntidadesAtivos() throws Exception {
        
        try {
            
            ArrayList<Peca> listaDePecas = obterTodasEntidades();
            
            List<Peca> listaDePecasAtivos = listaDePecas.stream()
                    //.filter(i -> i.getStatus().equals(StatusPeca.EM_ESPERA) && i.getStatus().equals(StatusPeca.EM_MANUTENCAO))
                    .collect(Collectors.toList());
            
            return listaDePecasAtivos;
            
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    public void excluir(int id) throws Exception {
        
        try {
            
            ArrayList<Peca> listaDePecas = this.obterTodasEntidades();
            
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < listaDePecas.size(); i++) {
                if (listaDePecas.get(i).getId() != id) bw.write(listaDePecas.get(i).toString()+"\n");
            }
            
            bw.close();
            
        } catch (Exception erro) {
            throw erro;
        }
        
    }
    
}
