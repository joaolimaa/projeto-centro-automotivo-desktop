package projetomecanica.entidades.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import projetomecanica.entidades.Marca;
import projetomecanica.entidades.Modelo;
import projetomecanica.entidades.Veiculo;
import projetomecanica.entidades.enums.*;

public class VeiculoDAO implements IDaoGenerico<Veiculo>{
    
    private String nomeDoArquivoNoDisco = "banco\\Veiculos.txt";

    @Override
    public void incluir(Veiculo objeto) throws Exception {
        
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
    public void alterar(Veiculo objeto) throws Exception {
        
        int id = objeto.getId();
        
        System.out.println(id);
        
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
    public Veiculo consultarPorId(int id) throws Exception {
        
        try {
            
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            
            BufferedReader br = new BufferedReader(fr);
            
            String linha = "";
            
            while ((linha=br.readLine()) != null) {
                
                Veiculo objetoVeiculo = new Veiculo();
                
                String vetorString[] = linha.split(";");
                
                if (vetorString.length != 14) throw new Exception("Faltam dados na String");
                
                objetoVeiculo.setId(Integer.parseInt(vetorString[0]));
                
                if (objetoVeiculo.getId() == id) {
                    
                    objetoVeiculo.setPlaca(vetorString[1]);

                    Marca marca = new Marca();
                    Modelo modelo = new Modelo();
                    modelo.setId(Integer.parseInt(vetorString[2]));
                    modelo.setDescricao(vetorString[3]);
                    marca.setId(Integer.parseInt(vetorString[4]));
                    marca.setDescricao(vetorString[5]);
                    marca.setLogo(vetorString[6]);
                    modelo.setMarca(marca);

                    objetoVeiculo.setModelo(modelo);
                    objetoVeiculo.setRenavam(vetorString[7]);
                    objetoVeiculo.setAnoModelo(Integer.parseInt(vetorString[8]));
                    objetoVeiculo.setAnoFabricacao(Integer.parseInt(vetorString[9]));
                    TipoDeVeiculo tipo = TipoDeVeiculo.valueOf(vetorString[10]);
                    objetoVeiculo.setTipo(tipo);
                    StatusVeiculo status = StatusVeiculo.valueOf(vetorString[11]);
                    objetoVeiculo.setStatus(status);
                    objetoVeiculo.setIdCliente(Integer.parseInt(vetorString[12]));
                    objetoVeiculo.setQuilometragem(Integer.parseInt(vetorString[13]));
                
                    br.close();
                    
                    return objetoVeiculo;
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
            
            ArrayList<Veiculo> listaDeVeiculos = obterTodasEntidades();
            
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < listaDeVeiculos.size(); i++) {
                if (listaDeVeiculos.get(i).getId() == id) {
                    listaDeVeiculos.get(i).setStatus(StatusVeiculo.INATIVO);
                }
                bw.write(listaDeVeiculos.get(i).toString()+"\n");
            }
            
            bw.close();
            
        } catch (Exception erro) {
            throw erro;
        }
        
    }

    @Override
    public ArrayList<Veiculo> obterTodasEntidades() throws Exception {
        
        try {
            
            ArrayList<Veiculo> listaDeVeiculos = new ArrayList();
            
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            
            BufferedReader br = new BufferedReader(fr);
            
            String linha = "";
            
            while ((linha = br.readLine()) != null) {
                
                Veiculo objetoVeiculo = new Veiculo();
                
                String vetorString[] = linha.split(";");
                
                if (vetorString.length != 14) throw new Exception("Faltam dados na String");
                
                objetoVeiculo.setId(Integer.parseInt(vetorString[0]));
                objetoVeiculo.setPlaca(vetorString[1]);
                
                Marca marca = new Marca();
                Modelo modelo = new Modelo();
                modelo.setId(Integer.parseInt(vetorString[2]));
                modelo.setDescricao(vetorString[3]);
                marca.setId(Integer.parseInt(vetorString[4]));
                marca.setDescricao(vetorString[5]);
                marca.setLogo(vetorString[6]);
                modelo.setMarca(marca);
                
                objetoVeiculo.setModelo(modelo);
                objetoVeiculo.setRenavam(vetorString[7]);
                objetoVeiculo.setAnoModelo(Integer.parseInt(vetorString[8]));
                objetoVeiculo.setAnoFabricacao(Integer.parseInt(vetorString[9]));
                TipoDeVeiculo tipo = TipoDeVeiculo.valueOf(vetorString[10]);
                objetoVeiculo.setTipo(tipo);
                StatusVeiculo status = StatusVeiculo.valueOf(vetorString[11]);
                objetoVeiculo.setStatus(status);
                objetoVeiculo.setIdCliente(Integer.parseInt(vetorString[12]));
                objetoVeiculo.setQuilometragem(Integer.parseInt(vetorString[13]));
                        
                listaDeVeiculos.add(objetoVeiculo);
            }
            
            br.close();
            
            return listaDeVeiculos;
            
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    @Override
    public List<Veiculo> obterEntidadesAtivos() throws Exception {
        
        try {
            
            ArrayList<Veiculo> listaDeVeiculos = obterTodasEntidades();
            
            List<Veiculo> listaDeVeiculosAtivos = listaDeVeiculos.stream()
                    .filter(i -> i.getStatus().equals(StatusVeiculo.EM_ESPERA) && i.getStatus().equals(StatusVeiculo.EM_MANUTENCAO))
                    .collect(Collectors.toList());
            
            return listaDeVeiculosAtivos;
            
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    public void excluir(int id) throws Exception {
        
        try {
            
            ArrayList<Veiculo> listaDeVeiculos = this.obterTodasEntidades();
            
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < listaDeVeiculos.size(); i++) {
                if (listaDeVeiculos.get(i).getId() != id) bw.write(listaDeVeiculos.get(i).toString()+"\n");
            }
            
            bw.close();
            
        } catch (Exception erro) {
            throw erro;
        }
        
    }
    
    public List<Veiculo> listarTodosPorCliente(int idCliente) throws Exception {
        
        try {
            
            ArrayList<Veiculo> listaDeVeiculos = obterTodasEntidades();
            
            List<Veiculo> listaDeVeiculosAtivos = listaDeVeiculos.stream()
                    .filter(i -> i.getIdCliente() == idCliente)
                    .collect(Collectors.toList());
            
            return listaDeVeiculosAtivos;
            
        } catch (Exception erro) {
            throw erro;
        }
    }
    
}
