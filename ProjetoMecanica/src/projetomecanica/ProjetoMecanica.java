package projetomecanica;

import java.util.ArrayList;
import projetomecanica.entidades.Orcamento;
import projetomecanica.entidades.Peca;
import projetomecanica.entidades.Servico;
import projetomecanica.entidades.Telefone;
import projetomecanica.entidades.Veiculo;
import projetomecanica.entidades.dao.OrcamentoDAO;
import projetomecanica.entidades.enums.FasesDocumento;
import projetomecanica.entidades.enums.TipoDeTelefone;
import projetomecanica.servicos.Utils;

public class ProjetoMecanica {
    
    public static void main(String[] args) throws Exception {
        
        Veiculo veiculo = new Veiculo();
        
        Peca peca = new Peca(541, "Correia Dentada", 15, 5, 2, 45, 1500);
        ArrayList<Peca> pecas = new ArrayList<>();
        pecas.add(peca);
        
        Servico servico = new Servico("Troca da Correia Dentada", 65, 2);
        ArrayList<Servico> servicos = new ArrayList<>();
        servicos.add(servico);
        
        Orcamento orcamento = new Orcamento(19, 12, 35, pecas, 1, 45, servicos, 1, 65, 110, "20/06/2022", "22/06/2022", "21/06/2022", 10, 5501, FasesDocumento.ATIVO);
        OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
        
        //orcamentoDAO.incluir(orcamento);
        
        System.out.println(orcamentoDAO.consultarPorId(37));
    }
    
}
