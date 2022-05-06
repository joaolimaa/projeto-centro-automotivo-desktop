/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetomecanica.modelos.dao;

import java.util.ArrayList;
import projetomecanica.modelos.Cliente;

/**
 *
 * @author leona
 */
public interface IClienteDAO {
    
    void incluir (Cliente objeto) throws Exception;
    
    void alterar (Cliente objeto) throws Exception;
    
    Cliente consultar (int id) throws Exception;
    
    void excluir (int id) throws Exception;
    
    ArrayList<Cliente> obterClientes () throws Exception;
    
}
