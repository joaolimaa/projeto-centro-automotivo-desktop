package projetomecanica.entidades.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import projetomecanica.entidades.Marca;

public class MarcaDAO implements IDaoGenerico<Marca>{
    
    private String nomeDoArquivoNoDisco = "banco\\Marcas.txt";

    @Override
    public void incluir(Marca objeto) throws Exception {
        
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
    public void alterar(Marca objeto) throws Exception {
        
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
    public Marca consultarPorId(int id) throws Exception {
        
        try {
            
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            
            BufferedReader br = new BufferedReader(fr);
            
            String linha = "";
            
            while ((linha=br.readLine()) != null) {
                
                Marca objetoMarca = new Marca();
                
                String vetorString[] = linha.split(";");
                
                if (vetorString.length != 3) throw new Exception("Faltam dados na String");
                
                objetoMarca.setId(Integer.parseInt(vetorString[0]));
                
                if (objetoMarca.getId() == id) {
                    
                    objetoMarca.setDescricao(vetorString[1]);
                    objetoMarca.setLogo(vetorString[2]);
                
                    br.close();
                    
                    return objetoMarca;
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
            
            ArrayList<Marca> listaDeMarcas = obterTodasEntidades();
            
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < listaDeMarcas.size(); i++) {
                if (listaDeMarcas.get(i).getId() == id) {
                    //listaDePecas.get(i).setStatus(StatusPeca.INATIVO);
                }
                bw.write(listaDeMarcas.get(i).toString()+"\n");
            }
            
            bw.close();
            
        } catch (Exception erro) {
            throw erro;
        }
        
    }

    @Override
    public ArrayList<Marca> obterTodasEntidades() throws Exception {
        
        try {
            
            ArrayList<Marca> listaDeMarcas = new ArrayList();
            
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            
            BufferedReader br = new BufferedReader(fr);
            
            String linha = "";
            
            while ((linha = br.readLine()) != null) {
                
                Marca objetoMarca = new Marca();
                
                String vetorString[] = linha.split(";");
                
                if (vetorString.length != 3) throw new Exception("Faltam dados na String");
                
                objetoMarca.setId(Integer.parseInt(vetorString[0]));
                objetoMarca.setDescricao(vetorString[1]);
                objetoMarca.setLogo(vetorString[2]);
                        
                listaDeMarcas.add(objetoMarca);
            }
            
            br.close();
            
            return listaDeMarcas;
            
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    @Override
    public List<Marca> obterEntidadesAtivos() throws Exception {
        
        try {
            
            ArrayList<Marca> listaDeMarcas = obterTodasEntidades();
            
            List<Marca> listaDeMarcasAtivos = listaDeMarcas.stream()
                    //.filter(i -> i.getStatus().equals(StatusPeca.EM_ESPERA) && i.getStatus().equals(StatusPeca.EM_MANUTENCAO))
                    .collect(Collectors.toList());
            
            return listaDeMarcasAtivos;
            
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    public void excluir(int id) throws Exception {
        
        try {
            
            ArrayList<Marca> listaDePecas = this.obterTodasEntidades();
            
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
