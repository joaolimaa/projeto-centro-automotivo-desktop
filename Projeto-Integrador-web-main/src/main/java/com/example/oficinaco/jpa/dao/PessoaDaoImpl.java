package com.example.oficinaco.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.oficinaco.jpa.entidade.Pessoa;

@Repository
public class PessoaDaoImpl {

	/*
	 * Precisa dessa implementação unicamente para tratar os casos onde se deve
	 * fazer uma querry que envolva o atributo funcionário e outra que não o envolva
	 * 
	 */
	@Autowired
	private EntityManager em;

	public List<Pessoa> listarPorNome(String nome, Boolean funcionario) {
		String sql = "select * from pessoa p where lower(p.nome) like lower(:nome)";

		if (funcionario != null) {
			sql += " and p.funcionario";
		}

		Query query = em.createNativeQuery(sql, Pessoa.class);
		query.setParameter("nome", nome);
		return query.getResultList();
	}

}
