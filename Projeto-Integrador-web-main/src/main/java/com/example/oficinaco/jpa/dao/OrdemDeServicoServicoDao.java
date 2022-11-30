package com.example.oficinaco.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.oficinaco.jpa.entidade.Municipio;

@Repository
public interface OrdemDeServicoServicoDao extends JpaRepository<Municipio, Integer> {

}
