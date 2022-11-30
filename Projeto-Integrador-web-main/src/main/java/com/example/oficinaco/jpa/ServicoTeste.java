package com.example.oficinaco.jpa;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oficinaco.jpa.dao.ServicoDao;
import com.example.oficinaco.jpa.entidade.Servico;

//@Service
public class ServicoTeste {
	
	@Autowired
	private ServicoDao servicoDao;
	
	@PostConstruct
	public void executar() {
		
		List<Servico> servicos = servicoDao.findAll();
		
		System.out.println("Listagem de servicos");
		for(Servico s : servicos) {
			System.out.println(s.getNome());
		}
		
		servicos.forEach(s -> {
			System.out.println(s.getNome());
			System.out.println(s.getId());
			});
		
		servicos.forEach(System.out::println);
		
		System.out.println("Fim da listagem\n\n");
		
		System.out.println("Teste insercao...");
		Servico servico = new Servico();
		servico.setNome("Teste insercao");
		servico.setPreco(BigDecimal.valueOf(10));
		servicoDao.save(servico);

		servicos = servicoDao.findAll();
		
		System.out.println("Conferindo se o servico foi incluido");
		for(Servico s : servicos) {
			System.out.printf("%10d %s\n", s.getId(), s.getNome());
		}
		
		System.out.println("Teste alterar...n");
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o id para alterar: ");
		Integer id = scan.nextInt();
		scan.nextLine();
		System.out.println("Digite o novo nome do produto");
		String nome = scan.nextLine();
		System.out.println("Digite o novo preço do produto");
		double preco = scan.nextDouble();
		scan.nextLine();
		
		Servico srvAlt = new Servico();
		srvAlt.setId(id);
		srvAlt.setNome(nome);
		srvAlt.setPreco(BigDecimal.valueOf(preco));
		servicoDao.save(srvAlt);

		System.out.println("Conferindo se o servico foi alterado");
		servicos = servicoDao.findAll();
		for(Servico s : servicos) {
			System.out.printf("%10d %s\n", s.getId(), s.getNome());
		}
		
		System.out.println("\n\nTeste exclusao");
		System.out.println("Digite o id para excluir: ");
		id = scan.nextInt();
		scan.nextLine();
		servicoDao.deleteById(id);
		System.out.println("Conferindo se o servico foi excluido");
		servicos = servicoDao.findAll();
		for(Servico s : servicos) {
			System.out.printf("%10d %s\n", s.getId(), s.getNome());
		}
		
	}

}
