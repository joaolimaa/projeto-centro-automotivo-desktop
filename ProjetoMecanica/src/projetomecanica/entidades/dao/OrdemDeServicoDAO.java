package projetomecanica.entidades.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import projetomecanica.entidades.Orcamento;
import projetomecanica.entidades.OrdemDeServico;
import projetomecanica.entidades.Peca;
import projetomecanica.entidades.Servico;
import projetomecanica.entidades.enums.*;

public class OrdemDeServicoDAO implements IDaoGenerico<OrdemDeServico>{
    
    private String nomeDoArquivoNoDisco = "banco\\OrdemsDeServico.txt";

    @Override
    public void incluir(OrdemDeServico objeto) throws Exception {
        
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
    public void alterar(OrdemDeServico objeto) throws Exception {
        
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
    public OrdemDeServico consultarPorId(int id) throws Exception {
        
        try {
            
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            
            BufferedReader br = new BufferedReader(fr);
            
            String linha = "";
            
            while ((linha=br.readLine()) != null) {
                
                OrdemDeServico objetoOrdemDeServico = new OrdemDeServico();
                
                String vetorString[] = linha.split(";");
                
                objetoOrdemDeServico.setQtdPecas(Integer.parseInt(vetorString[5]));
                objetoOrdemDeServico.setQtdServicos(Integer.parseInt(vetorString[6]));
                
                int total = 10 + ((objetoOrdemDeServico.getQtdPecas()*8) + (objetoOrdemDeServico.getQtdServicos()*3));
                
                int ultimo = 5;
                
                if (vetorString.length != total) throw new Exception("Faltam dados na String");
                
                objetoOrdemDeServico.setId(Integer.parseInt(vetorString[0]));
                
                if (objetoOrdemDeServico.getId() == id) {
                    
                    objetoOrdemDeServico.setIdOrcamento(Integer.parseInt(vetorString[1]));
                    objetoOrdemDeServico.setIdCliente(Integer.parseInt(vetorString[2]));
                    objetoOrdemDeServico.setIdColaborador(Integer.parseInt(vetorString[3]));
                    objetoOrdemDeServico.setIdVeiculo(Integer.parseInt(vetorString[4]));
                    
                    ArrayList<Peca> listaDePecas = new ArrayList<>();
                    
                    for (int i = 0; i < objetoOrdemDeServico.getQtdPecas(); i++) {
                        listaDePecas.get(i).setId(Integer.parseInt(vetorString[ultimo]));
                        ultimo++;
                        listaDePecas.get(i).setCodigo(Integer.parseInt(vetorString[ultimo]));
                        ultimo++;
                        listaDePecas.get(i).setDescricao(vetorString[ultimo]);
                        ultimo++;
                        listaDePecas.get(i).setQtdEstoque(Integer.parseInt(vetorString[ultimo]));
                        ultimo++;
                        listaDePecas.get(i).setQtdMinEstoque(Integer.parseInt(vetorString[ultimo]));
                        ultimo++;
                        listaDePecas.get(i).setReservadas(Integer.parseInt(vetorString[ultimo]));
                        ultimo++;
                        listaDePecas.get(i).setValorUnitario(Float.parseFloat(vetorString[ultimo]));
                        ultimo++;
                        listaDePecas.get(i).setVidaUtilEmDias(Integer.parseInt(vetorString[ultimo]));
                        ultimo++;
                    }
                    objetoOrdemDeServico.setPecas(listaDePecas);
                    
                    ArrayList<Servico> listaDeServicos = new ArrayList();
                    
                    for (int i = 0; i < objetoOrdemDeServico.getQtdServicos(); i++) {
                        listaDeServicos.get(i).setId(Integer.parseInt(vetorString[ultimo]));
                        ultimo++;
                        listaDeServicos.get(i).setValor(Float.parseFloat(vetorString[ultimo]));
                        ultimo++;
                        listaDeServicos.get(i).setDescricao(vetorString[ultimo]);
                        ultimo++;
                    }
                    objetoOrdemDeServico.setServicos(listaDeServicos);
                    
                    objetoOrdemDeServico.setDataOrdemDeServicoGerada(vetorString[ultimo]);
                    ultimo++;
                    objetoOrdemDeServico.setDataOrdemDeServicoFinalizada(vetorString[ultimo]);
                    ultimo++;
                    objetoOrdemDeServico.setCodigo(Integer.parseInt(vetorString[ultimo]));
                    ultimo++;
                    FasesDocumento fase = FasesDocumento.valueOf(vetorString[ultimo]);
                    objetoOrdemDeServico.setFase(fase);
                    objetoOrdemDeServico.setDescricao(vetorString[ultimo]);
                    ultimo++;
                
                    br.close();
                    
                    return objetoOrdemDeServico;
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
            
            ArrayList<OrdemDeServico> listaDeOrdemDeServicos = obterTodasEntidades();
            
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < listaDeOrdemDeServicos.size(); i++) {
                if (listaDeOrdemDeServicos.get(i).getId() == id) {
                    listaDeOrdemDeServicos.get(i).setFase(FasesDocumento.INATIVO);
                }
                bw.write(listaDeOrdemDeServicos.get(i).toString()+"\n");
            }
            
            bw.close();
            
        } catch (Exception erro) {
            throw erro;
        }
        
    }

    @Override
    public ArrayList<OrdemDeServico> obterTodasEntidades() throws Exception {
        
        try {
            
            ArrayList<OrdemDeServico> listaDeOrdemDeServicos = new ArrayList();
            
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            
            BufferedReader br = new BufferedReader(fr);
            
            String linha = "";
            
            while ((linha = br.readLine()) != null) {
                
                OrdemDeServico objetoOrdemDeServico = new OrdemDeServico();
                
                String vetorString[] = linha.split(";");
                
                objetoOrdemDeServico.setQtdPecas(Integer.parseInt(vetorString[5]));
                objetoOrdemDeServico.setQtdServicos(Integer.parseInt(vetorString[6]));
                
                int total = 10 + ((objetoOrdemDeServico.getQtdPecas()*8) + (objetoOrdemDeServico.getQtdServicos()*3));
                
                int ultimo = 5;
                
                if (vetorString.length != total) throw new Exception("Faltam dados na String");
                
                objetoOrdemDeServico.setId(Integer.parseInt(vetorString[0]));
                    
                objetoOrdemDeServico.setIdOrcamento(Integer.parseInt(vetorString[1]));
                objetoOrdemDeServico.setIdCliente(Integer.parseInt(vetorString[2]));
                objetoOrdemDeServico.setIdColaborador(Integer.parseInt(vetorString[3]));
                objetoOrdemDeServico.setIdVeiculo(Integer.parseInt(vetorString[4]));

                ArrayList<Peca> listaDePecas = new ArrayList<>();

                for (int i = 0; i < objetoOrdemDeServico.getQtdPecas(); i++) {
                    listaDePecas.get(i).setId(Integer.parseInt(vetorString[ultimo]));
                    ultimo++;
                    listaDePecas.get(i).setCodigo(Integer.parseInt(vetorString[ultimo]));
                    ultimo++;
                    listaDePecas.get(i).setDescricao(vetorString[ultimo]);
                    ultimo++;
                    listaDePecas.get(i).setQtdEstoque(Integer.parseInt(vetorString[ultimo]));
                    ultimo++;
                    listaDePecas.get(i).setQtdMinEstoque(Integer.parseInt(vetorString[ultimo]));
                    ultimo++;
                    listaDePecas.get(i).setReservadas(Integer.parseInt(vetorString[ultimo]));
                    ultimo++;
                    listaDePecas.get(i).setValorUnitario(Float.parseFloat(vetorString[ultimo]));
                    ultimo++;
                    listaDePecas.get(i).setVidaUtilEmDias(Integer.parseInt(vetorString[ultimo]));
                    ultimo++;
                }
                objetoOrdemDeServico.setPecas(listaDePecas);

                ArrayList<Servico> listaDeServicos = new ArrayList();

                for (int i = 0; i < objetoOrdemDeServico.getQtdServicos(); i++) {
                    listaDeServicos.get(i).setId(Integer.parseInt(vetorString[ultimo]));
                    ultimo++;
                    listaDeServicos.get(i).setValor(Float.parseFloat(vetorString[ultimo]));
                    ultimo++;
                    listaDeServicos.get(i).setDescricao(vetorString[ultimo]);
                    ultimo++;
                }
                objetoOrdemDeServico.setServicos(listaDeServicos);

                objetoOrdemDeServico.setDataOrdemDeServicoGerada(vetorString[ultimo]);
                ultimo++;
                objetoOrdemDeServico.setDataOrdemDeServicoFinalizada(vetorString[ultimo]);
                ultimo++;
                objetoOrdemDeServico.setCodigo(Integer.parseInt(vetorString[ultimo]));
                ultimo++;
                FasesDocumento fase = FasesDocumento.valueOf(vetorString[ultimo]);
                objetoOrdemDeServico.setFase(fase);
                objetoOrdemDeServico.setDescricao(vetorString[ultimo]);
                ultimo++;
                
                listaDeOrdemDeServicos.add(objetoOrdemDeServico);
            }
            
            br.close();
            
            return listaDeOrdemDeServicos;
            
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    @Override
    public List<OrdemDeServico> obterEntidadesAtivos() throws Exception {
        
        try {
            
            ArrayList<OrdemDeServico> listaDeOrdemDeServicos = obterTodasEntidades();
            
            List<OrdemDeServico> listaDeOrdemDeServicosAtivos = listaDeOrdemDeServicos.stream()
                    .filter(i -> i.getFase().equals(FasesDocumento.ATIVO))
                    .collect(Collectors.toList());
            
            return listaDeOrdemDeServicosAtivos;
            
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    public List<OrdemDeServico> obterEntidadesPorFase(FasesDocumento fase) throws Exception {
        
        try {
            
            ArrayList<OrdemDeServico> listaDeOrdemDeServicos = obterTodasEntidades();
            
            List<OrdemDeServico> listaDeOrdemDeServicosPorFase = listaDeOrdemDeServicos.stream()
                    .filter(i -> i.getFase().equals(fase))
                    .collect(Collectors.toList());
            
            return listaDeOrdemDeServicosPorFase;
            
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    public void excluir(int id) throws Exception {
        
        try {
            
            ArrayList<OrdemDeServico> listaDeOrdemDeServicos = this.obterTodasEntidades();
            
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < listaDeOrdemDeServicos.size(); i++) {
                if (listaDeOrdemDeServicos.get(i).getId() != id) bw.write(listaDeOrdemDeServicos.get(i).toString()+"\n");
            }
            
            bw.close();
            
        } catch (Exception erro) {
            throw erro;
        }
        
    }
    
    public void gerarOS(int idOrcamento) throws Exception {
        
        try {
            
            OrcamentoDAO orcamentoDao = new OrcamentoDAO();
            Orcamento orcamento = orcamentoDao.consultarPorId(idOrcamento);
            
            OrdemDeServico objetoOrdemDeServico = new OrdemDeServico();
            
            objetoOrdemDeServico.setIdCliente(orcamento.getIdCliente());
            objetoOrdemDeServico.setIdColaborador(orcamento.getIdColaborador());
            objetoOrdemDeServico.setIdOrcamento(orcamento.getId());
            objetoOrdemDeServico.setDescricao(orcamento.getDescricao());
            
        } catch (Exception erro) {
            throw erro;
        }
        
    }
    
}
