package projetomecanica.entidades.dao;

import java.util.ArrayList;
import java.util.List;

public interface IDaoGenerico<Tipo> {
    
    void incluir (Tipo objeto) throws Exception;
    
    void alterar (Tipo objeto) throws Exception;
    
    Tipo consultarPorId (int id) throws Exception;
    
    void inativarPorId (int id) throws Exception;
    
    ArrayList<Tipo> obterTodasEntidades () throws Exception;
    
    List<Tipo> obterEntidadesAtivos() throws Exception;
    
}
