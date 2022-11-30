package com.example.oficinaco.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.oficinaco.jpa.entidade.Modelo;

@Repository
public interface ModeloDao extends JpaRepository<Modelo, Integer>{

}
