package projetomecanica;

import java.util.List;
import projetomecanica.modelos.Cliente;
import projetomecanica.modelos.dao.ClienteDAO;
import projetomecanica.modelos.dao.IClienteDAO;

public class ProjetoMecanica {
    
    public static void main(String[] args) throws Exception {
            
        Cliente cliente = new Cliente("Eduardo", 999689312, "eduardo@.com", "rua R17");
        
        IClienteDAO dao = new ClienteDAO();
        
        //dao.incluir(cliente);
        
//        System.out.println("\n Listar \n");
//
//        List<Cliente> lista = dao.obterClientes();
//
//        lista.forEach(item -> System.out.println(item));
//
//        System.out.println("\n Consultar \n");
//
//        System.out.println(dao.consultar(5));
//
//        System.out.println("\n excluir \n");
//
//        dao.excluir(10);
//
//        lista = dao.obterClientes();
//
//        lista.forEach(item -> System.out.println(item));

        Cliente cliente2 = new Cliente("Larissa", 651654684, "larissa@.com", "rua S10");
        
        //dao.incluir(cliente2);

        dao.alterar(cliente2);
        
    }
    
}
