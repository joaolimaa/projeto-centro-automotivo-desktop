package projetomecanica.entidades.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import projetomecanica.entidades.Orcamento;
import projetomecanica.entidades.Orcamento;
import projetomecanica.entidades.Peca;
import projetomecanica.entidades.Servico;
import projetomecanica.entidades.enums.*;

public class OrcamentoDAO implements IDaoGenerico<Orcamento>{
    
    private String nomeDoArquivoNoDisco = "banco\\Orcamentos.txt";

    @Override
    public void incluir(Orcamento objeto) throws Exception {
        
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
    public void alterar(Orcamento objeto) throws Exception {
        
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
    public Orcamento consultarPorId(int id) throws Exception {
        
        try {
            
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            
            BufferedReader br = new BufferedReader(fr);
            
            String linha = "";
            
            while ((linha=br.readLine()) != null) {
                
                Orcamento objetoOrcamento = new Orcamento();
                
                String vetorString[] = linha.split(";");
                
                objetoOrcamento.setQtdPecas(Integer.parseInt(vetorString[4]));
                objetoOrcamento.setQtdServicos(Integer.parseInt(vetorString[5]));
                System.out.println(objetoOrcamento.getQtdPecas());
                System.out.println(objetoOrcamento.getQtdServicos());
                
                int total = 15 + ((objetoOrcamento.getQtdPecas()*8) + (objetoOrcamento.getQtdServicos()*3));
                
                int ultimo = 6;
                
                objetoOrcamento.setId(Integer.parseInt(vetorString[0]));
                
                if (objetoOrcamento.getId() == id) {
                    System.out.println(objetoOrcamento.getId());
                    
                    objetoOrcamento.setIdCliente(Integer.parseInt(vetorString[1]));
                    objetoOrcamento.setIdColaborador(Integer.parseInt(vetorString[2]));
                    objetoOrcamento.setIdVeiculo(Integer.parseInt(vetorString[3]));
                    
                    ArrayList<Peca> listaDePecas = new ArrayList<>();
                    Peca peca = new Peca();

                    for (int i = 0; i < objetoOrcamento.getQtdPecas(); i++) {
                        peca.setId(Integer.parseInt(vetorString[ultimo]));
                        ultimo++;
                        peca.setCodigo(Integer.parseInt(vetorString[ultimo]));
                        ultimo++;
                        peca.setDescricao(vetorString[ultimo]);
                        ultimo++;
                        peca.setQtdEstoque(Integer.parseInt(vetorString[ultimo]));
                        ultimo++;
                        peca.setQtdMinEstoque(Integer.parseInt(vetorString[ultimo]));
                        ultimo++;
                        peca.setReservadas(Integer.parseInt(vetorString[ultimo]));
                        ultimo++;
                        peca.setValorUnitario(Float.parseFloat(vetorString[ultimo]));
                        ultimo++;
                        peca.setVidaUtilEmDias(Integer.parseInt(vetorString[ultimo]));
                        ultimo++;
                        listaDePecas.add(peca);
                    }
                    objetoOrcamento.setPecas(listaDePecas);

                    ArrayList<Servico> listaDeServicos = new ArrayList();
                    Servico servico = new Servico();

                    for (int i = 0; i < objetoOrcamento.getQtdServicos(); i++) {
                        servico.setId(Integer.parseInt(vetorString[ultimo]));
                        ultimo++;
                        servico.setDescricao(vetorString[ultimo]);
                        ultimo++;
                        servico.setValor(Float.parseFloat(vetorString[ultimo]));
                        ultimo++;
                        listaDeServicos.add(servico);
                    }
                    objetoOrcamento.setServicos(listaDeServicos);
                    
                    objetoOrcamento.setTotalPecas(Float.parseFloat(vetorString[ultimo]));
                    ultimo++;
                    objetoOrcamento.setTotalServicos(Float.parseFloat(vetorString[ultimo]));
                    ultimo++;
                    objetoOrcamento.setTotal(Float.parseFloat(vetorString[ultimo]));
                    ultimo++;
                    objetoOrcamento.setDataOrcamentoGerado(vetorString[ultimo]);
                    ultimo++;
                    objetoOrcamento.setDataValidadeOrcamento(vetorString[ultimo]);
                    ultimo++;
                    objetoOrcamento.setDataOrcamentoAprovado(vetorString[ultimo]);
                    ultimo++;
                    objetoOrcamento.setDesconto(Float.parseFloat(vetorString[ultimo]));
                    ultimo++;
                    objetoOrcamento.setCodigo(Integer.parseInt(vetorString[ultimo]));
                    ultimo++;
                    FasesDocumento fase = FasesDocumento.valueOf(vetorString[ultimo]);
                    objetoOrcamento.setFase(fase);
                
                    br.close();
                    
                    return objetoOrcamento;
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
            
            ArrayList<Orcamento> listaDeOrcamentos = obterTodasEntidades();
            
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < listaDeOrcamentos.size(); i++) {
                if (listaDeOrcamentos.get(i).getId() == id) {
                    listaDeOrcamentos.get(i).setFase(FasesDocumento.INATIVO);
                }
                bw.write(listaDeOrcamentos.get(i).toString()+"\n");
            }
            
            bw.close();
            
        } catch (Exception erro) {
            throw erro;
        }
        
    }

    @Override
    public ArrayList<Orcamento> obterTodasEntidades() throws Exception {
        
        try {
            
            ArrayList<Orcamento> listaDeOrcamentos = new ArrayList();
            
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            
            BufferedReader br = new BufferedReader(fr);
            
            String linha = "";
            
            while ((linha = br.readLine()) != null) {
                
                Orcamento objetoOrcamento = new Orcamento();
                
                String vetorString[] = linha.split(";");
                
                objetoOrcamento.setQtdPecas(Integer.parseInt(vetorString[4]));
                objetoOrcamento.setQtdServicos(Integer.parseInt(vetorString[5]));
                
                int total = 15 + ((objetoOrcamento.getQtdPecas()*8) + (objetoOrcamento.getQtdServicos()*3));
                
                int ultimo = 6;
                
                objetoOrcamento.setId(Integer.parseInt(vetorString[0]));
                    
                objetoOrcamento.setIdCliente(Integer.parseInt(vetorString[1]));
                objetoOrcamento.setIdColaborador(Integer.parseInt(vetorString[2]));
                objetoOrcamento.setIdVeiculo(Integer.parseInt(vetorString[3]));

                ArrayList<Peca> listaDePecas = new ArrayList<>();
                Peca peca = new Peca();

                for (int i = 0; i < objetoOrcamento.getQtdPecas(); i++) {
                    peca.setId(Integer.parseInt(vetorString[ultimo]));
                    ultimo++;
                    peca.setCodigo(Integer.parseInt(vetorString[ultimo]));
                    ultimo++;
                    peca.setDescricao(vetorString[ultimo]);
                    ultimo++;
                    peca.setQtdEstoque(Integer.parseInt(vetorString[ultimo]));
                    ultimo++;
                    peca.setQtdMinEstoque(Integer.parseInt(vetorString[ultimo]));
                    ultimo++;
                    peca.setReservadas(Integer.parseInt(vetorString[ultimo]));
                    ultimo++;
                    peca.setValorUnitario(Float.parseFloat(vetorString[ultimo]));
                    ultimo++;
                    peca.setVidaUtilEmDias(Integer.parseInt(vetorString[ultimo]));
                    ultimo++;
                    listaDePecas.add(peca);
                }
                objetoOrcamento.setPecas(listaDePecas);

                ArrayList<Servico> listaDeServicos = new ArrayList();
                Servico servico = new Servico();

                for (int i = 0; i < objetoOrcamento.getQtdServicos(); i++) {
                    servico.setId(Integer.parseInt(vetorString[ultimo]));
                    ultimo++;
                    servico.setDescricao(vetorString[ultimo]);
                    ultimo++;
                    servico.setValor(Float.parseFloat(vetorString[ultimo]));
                    ultimo++;
                    listaDeServicos.add(servico);
                }
                objetoOrcamento.setServicos(listaDeServicos);

                objetoOrcamento.setTotalPecas(Float.parseFloat(vetorString[ultimo]));
                ultimo++;
                objetoOrcamento.setTotalServicos(Float.parseFloat(vetorString[ultimo]));
                ultimo++;
                objetoOrcamento.setTotal(Float.parseFloat(vetorString[ultimo]));
                ultimo++;
                objetoOrcamento.setDataOrcamentoGerado(vetorString[ultimo]);
                ultimo++;
                objetoOrcamento.setDataValidadeOrcamento(vetorString[ultimo]);
                ultimo++;
                objetoOrcamento.setDataOrcamentoAprovado(vetorString[ultimo]);
                ultimo++;
                objetoOrcamento.setDesconto(Float.parseFloat(vetorString[ultimo]));
                ultimo++;
                objetoOrcamento.setCodigo(Integer.parseInt(vetorString[ultimo]));
                ultimo++;
                FasesDocumento fase = FasesDocumento.valueOf(vetorString[ultimo]);
                objetoOrcamento.setFase(fase);

                listaDeOrcamentos.add(objetoOrcamento);
                
            }
            
            br.close();
            
            return listaDeOrcamentos;
            
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    @Override
    public List<Orcamento> obterEntidadesAtivos() throws Exception {
        
        try {
            
            ArrayList<Orcamento> listaDeOrcamentos = obterTodasEntidades();
            
            List<Orcamento> listaDeOrcamentosAtivos = listaDeOrcamentos.stream()
                    .filter(i -> i.getFase().equals(FasesDocumento.ATIVO))
                    .collect(Collectors.toList());
            
            return listaDeOrcamentosAtivos;
            
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    public List<Orcamento> obterEntidadesPorFase(FasesDocumento fase) throws Exception {
        
        try {
            
            ArrayList<Orcamento> listaDeOrcamentos = obterTodasEntidades();
            
            List<Orcamento> listaDeOrcamentosPorFase = listaDeOrcamentos.stream()
                    .filter(i -> i.getFase().equals(fase))
                    .collect(Collectors.toList());
            
            return listaDeOrcamentosPorFase;
            
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    public void excluir(int id) throws Exception {
        
        try {
            
            ArrayList<Orcamento> listaDeOrcamentos = this.obterTodasEntidades();
            
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < listaDeOrcamentos.size(); i++) {
                if (listaDeOrcamentos.get(i).getId() != id) bw.write(listaDeOrcamentos.get(i).toString()+"\n");
            }
            
            bw.close();
            
        } catch (Exception erro) {
            throw erro;
        }
        
    }
    
}
