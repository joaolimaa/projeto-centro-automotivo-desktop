package projetomecanica.entidades.dao;

import java.util.ArrayList;

public interface DaoGenerico<Tipo> {
    
    void incluir (Tipo objeto) throws Exception;
    
    void alterar (Tipo objeto) throws Exception;
    
    Tipo consultar (int id) throws Exception;
    
    void excluir (int id) throws Exception;
    
    ArrayList<Tipo> obterEntidades () throws Exception;
    
}
