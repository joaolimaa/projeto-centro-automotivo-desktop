package projetomecanica.entidades.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import projetomecanica.entidades.NotaFiscal;
import projetomecanica.entidades.NotaFiscal;
import projetomecanica.entidades.NotaFiscal;
import projetomecanica.entidades.Peca;
import projetomecanica.entidades.Servico;
import projetomecanica.entidades.enums.*;

public class NotaFiscalDAO implements IDaoGenerico<NotaFiscal>{
    
    private String nomeDoArquivoNoDisco = "banco\\NotasFiscais.txt";

    @Override
    public void incluir(NotaFiscal objeto) throws Exception {
        
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
    public void alterar(NotaFiscal objeto) throws Exception {
        
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
    public NotaFiscal consultarPorId(int id) throws Exception {
        
        try {
            
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            
            BufferedReader br = new BufferedReader(fr);
            
            String linha = "";
            
            while ((linha=br.readLine()) != null) {
                
                NotaFiscal objetoNotaFiscal = new NotaFiscal();
                
                String vetorString[] = linha.split(";");
                
                objetoNotaFiscal.setQtdPecas(Integer.parseInt(vetorString[6]));
                objetoNotaFiscal.setQtdServicos(Integer.parseInt(vetorString[7]));
                
                int ultimo = 8;
                
                objetoNotaFiscal.setId(Integer.parseInt(vetorString[0]));
                
                if (objetoNotaFiscal.getId() == id) {
                    
                    objetoNotaFiscal.setIdCliente(Integer.parseInt(vetorString[1]));
                    objetoNotaFiscal.setIdColaborador(Integer.parseInt(vetorString[2]));
                    objetoNotaFiscal.setIdVeiculo(Integer.parseInt(vetorString[3]));
                    objetoNotaFiscal.setIdOrcamento(Integer.parseInt(vetorString[4]));
                    objetoNotaFiscal.setIdOrdemDeServico(Integer.parseInt(vetorString[5]));

                    ArrayList<Peca> listaDePecas = new ArrayList<>();
                    Peca peca = new Peca();

                    for (int i = 0; i < objetoNotaFiscal.getQtdPecas(); i++) {
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
                    objetoNotaFiscal.setPecas(listaDePecas);
                    objetoNotaFiscal.setTotalPecas(Float.parseFloat(vetorString[ultimo]));
                    ultimo++;

                    ArrayList<Servico> listaDeServicos = new ArrayList();
                    Servico servico = new Servico();

                    for (int i = 0; i < objetoNotaFiscal.getQtdServicos(); i++) {
                        servico.setId(Integer.parseInt(vetorString[ultimo]));
                        ultimo++;
                        servico.setDescricao(vetorString[ultimo]);
                        ultimo++;
                        servico.setValor(Float.parseFloat(vetorString[ultimo]));
                        ultimo++;
                        listaDeServicos.add(servico);
                    }
                    objetoNotaFiscal.setServicos(listaDeServicos);
                    objetoNotaFiscal.setTotalServicos(Float.parseFloat(vetorString[ultimo]));
                    ultimo++;
                    objetoNotaFiscal.setTotal(Float.parseFloat(vetorString[ultimo]));
                    ultimo++;
                    objetoNotaFiscal.setNumeroNF(Integer.parseInt(vetorString[ultimo]));
                    ultimo++;
                    objetoNotaFiscal.setSerieNF(Integer.parseInt(vetorString[ultimo]));
                    ultimo++;
                    objetoNotaFiscal.setDataGerado(vetorString[ultimo]);
                    ultimo++;
                    objetoNotaFiscal.setDataValidade(vetorString[ultimo]);
                    ultimo++;
                    objetoNotaFiscal.setDataPagamento(vetorString[ultimo]);
                    ultimo++;
                    objetoNotaFiscal.setDesconto(Float.parseFloat(vetorString[ultimo]));
                    ultimo++;
                    FasesDocumento fase = FasesDocumento.valueOf(vetorString[ultimo]);
                    objetoNotaFiscal.setFase(fase);
                
                    br.close();
                    
                    return objetoNotaFiscal;
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
            
            ArrayList<NotaFiscal> listaDeNotaFiscais = obterTodasEntidades();
            
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < listaDeNotaFiscais.size(); i++) {
                if (listaDeNotaFiscais.get(i).getId() == id) {
                    listaDeNotaFiscais.get(i).setFase(FasesDocumento.INATIVO);
                }
                bw.write(listaDeNotaFiscais.get(i).toString()+"\n");
            }
            
            bw.close();
            
        } catch (Exception erro) {
            throw erro;
        }
        
    }

    @Override
    public ArrayList<NotaFiscal> obterTodasEntidades() throws Exception {
        
        try {
            
            ArrayList<NotaFiscal> listaDeNotaFiscais = new ArrayList();
            
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            
            BufferedReader br = new BufferedReader(fr);
            
            String linha = "";
            
            while ((linha = br.readLine()) != null) {
                
                NotaFiscal objetoNotaFiscal = new NotaFiscal();
                
                String vetorString[] = linha.split(";");
                
                objetoNotaFiscal.setQtdPecas(Integer.parseInt(vetorString[6]));
                objetoNotaFiscal.setQtdServicos(Integer.parseInt(vetorString[7]));
                
                int ultimo = 8;
                
                objetoNotaFiscal.setId(Integer.parseInt(vetorString[0]));
                    
                objetoNotaFiscal.setIdCliente(Integer.parseInt(vetorString[1]));
                objetoNotaFiscal.setIdColaborador(Integer.parseInt(vetorString[2]));
                objetoNotaFiscal.setIdVeiculo(Integer.parseInt(vetorString[3]));
                objetoNotaFiscal.setIdOrcamento(Integer.parseInt(vetorString[4]));
                objetoNotaFiscal.setIdOrdemDeServico(Integer.parseInt(vetorString[5]));

                ArrayList<Peca> listaDePecas = new ArrayList<>();
                Peca peca = new Peca();

                for (int i = 0; i < objetoNotaFiscal.getQtdPecas(); i++) {
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
                objetoNotaFiscal.setPecas(listaDePecas);
                objetoNotaFiscal.setTotalPecas(Float.parseFloat(vetorString[ultimo]));
                ultimo++;

                ArrayList<Servico> listaDeServicos = new ArrayList();
                Servico servico = new Servico();

                for (int i = 0; i < objetoNotaFiscal.getQtdServicos(); i++) {
                    servico.setId(Integer.parseInt(vetorString[ultimo]));
                    ultimo++;
                    servico.setDescricao(vetorString[ultimo]);
                    ultimo++;
                    servico.setValor(Float.parseFloat(vetorString[ultimo]));
                    ultimo++;
                    listaDeServicos.add(servico);
                }
                objetoNotaFiscal.setServicos(listaDeServicos);
                objetoNotaFiscal.setTotalServicos(Float.parseFloat(vetorString[ultimo]));
                ultimo++;
                objetoNotaFiscal.setTotal(Float.parseFloat(vetorString[ultimo]));
                ultimo++;
                objetoNotaFiscal.setNumeroNF(Integer.parseInt(vetorString[ultimo]));
                ultimo++;
                objetoNotaFiscal.setSerieNF(Integer.parseInt(vetorString[ultimo]));
                ultimo++;
                objetoNotaFiscal.setDataGerado(vetorString[ultimo]);
                ultimo++;
                objetoNotaFiscal.setDataValidade(vetorString[ultimo]);
                ultimo++;
                objetoNotaFiscal.setDataPagamento(vetorString[ultimo]);
                ultimo++;
                objetoNotaFiscal.setDesconto(Float.parseFloat(vetorString[ultimo]));
                ultimo++;
                FasesDocumento fase = FasesDocumento.valueOf(vetorString[ultimo]);
                objetoNotaFiscal.setFase(fase);

                listaDeNotaFiscais.add(objetoNotaFiscal);
                
            }
            
            br.close();
            
            return listaDeNotaFiscais;
            
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    @Override
    public List<NotaFiscal> obterEntidadesAtivos() throws Exception {
        
        try {
            
            ArrayList<NotaFiscal> listaDeNotaFiscais = obterTodasEntidades();
            
            List<NotaFiscal> listaDeNotaFiscaisAtivos = listaDeNotaFiscais.stream()
                    .filter(i -> i.getFase().equals(FasesDocumento.ATIVO))
                    .collect(Collectors.toList());
            
            return listaDeNotaFiscaisAtivos;
            
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    public List<NotaFiscal> obterEntidadesPorFase(FasesDocumento fase) throws Exception {
        
        try {
            
            ArrayList<NotaFiscal> listaDeNotaFiscais = obterTodasEntidades();
            
            List<NotaFiscal> listaDeNotaFiscaisPorFase = listaDeNotaFiscais.stream()
                    .filter(i -> i.getFase().equals(fase))
                    .collect(Collectors.toList());
            
            return listaDeNotaFiscaisPorFase;
            
        } catch (Exception erro) {
            throw erro;
        }
    }
    
    public void excluir(int id) throws Exception {
        
        try {
            
            ArrayList<NotaFiscal> listaDeNotaFiscais = this.obterTodasEntidades();
            
            FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
            
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < listaDeNotaFiscais.size(); i++) {
                if (listaDeNotaFiscais.get(i).getId() != id) bw.write(listaDeNotaFiscais.get(i).toString()+"\n");
            }
            
            bw.close();
            
        } catch (Exception erro) {
            throw erro;
        }
        
    }
    
}
