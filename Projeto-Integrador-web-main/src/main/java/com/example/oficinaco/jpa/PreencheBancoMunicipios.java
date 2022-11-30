package com.example.oficinaco.jpa;

import java.beans.Statement;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.oficinaco.jpa.dao.MunicipioDao;
import com.example.oficinaco.jpa.entidade.EnumUf;
import com.example.oficinaco.jpa.entidade.Municipio;
import com.example.oficinaco.jpa.jsf.MunicipioControl;

public class PreencheBancoMunicipios {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {

		try (BufferedReader br = new BufferedReader(
				new FileReader("src\\main\\java\\com\\example\\oficinaco\\jpa\\municipios.txt"))) {

			String linha = br.readLine();
			String[] dados = new String[1];
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
					"123456");

			// Nome Municipio
			// código IBGE
			// código IBGE 2?
			// Sigla Estado
			linha = br.readLine();
			int cont = 0;
			while (linha != null) {
				java.sql.PreparedStatement st = con.prepareStatement(
						"INSERT INTO municipio (id, codigo_ibge, nome, uf) VALUES (?,?,?,?)");
				dados = linha.split(";");
				Municipio m = new Municipio();
				m.setNome(dados[0].substring(2));
				m.setCodigoIbge(Integer.parseInt(dados[1]));
				m.setUf(Enum.valueOf(EnumUf.class, dados[3]));
				
				st.setInt(1, cont);
				st.setInt(2, m.getCodigoIbge());
				st.setString(3, m.getNome());
				st.setString(4, m.getUf().getDescricao());
				st.execute();
				
				linha = br.readLine();
				cont++;
			}

		}
	}
}
