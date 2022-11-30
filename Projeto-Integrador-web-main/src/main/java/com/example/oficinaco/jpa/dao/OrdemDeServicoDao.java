package com.example.oficinaco.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.oficinaco.jpa.entidade.Municipio;
import com.example.oficinaco.jpa.entidade.OrdemDeServico;

@Repository
public interface OrdemDeServicoDao extends JpaRepository<OrdemDeServico, Integer> {

}
