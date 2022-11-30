package com.example.oficinaco.jpa.entidade;

public enum EnumUf {

	/**
11-Rondônia
12-Acre
13-Amazonas
14-Roraima
15-Pará
16-Amapá
17-Tocantins

21-Maranhão
22-Piauí
23-Ceará
24-Rio Grande do Norte
25-Paraíba
26-Pernambuco
27-Alagoas
28-Sergipe
29-Bahia


31-Minas Gerais
32-Espírito Santo
33-Rio de Janeiro
35-São Paulo

41-Paraná
42-Santa Catarina
43-Rio Grande do Sul

50-Mato Grosso do Sul
51-Mato Grosso
52-Goiás
53-Distrito Federal

9999999 - Exterior

	 */

	AC("Acre", 12),
	AL("Alagoas", 27),
	AP("Amapá", 16),
	AM("Amazonas", 13),
	BA("Bahia", 29),
	CE("Ceará", 23),
	DF("Distrito Federal", 53),
	ES("Espírito Santo", 32),
	GO("Goiás", 52),
	MA("Maranhão", 21),
	MT("Mato Grosso", 51),
	MS("Mato Grosso do Sul", 50),
	MG("Minas Gerais", 31),
	PA("Pará", 15),
	PB("Paraíba", 25),
	PE("Pernambuco", 26),
	PR("Paraná", 41),
	PI("Piauí", 22),
	RJ("Rio De Janeiro", 33),
	RN("Rio Grande do Norte", 24),
	RS("Rio Grande do Sul", 43),
	RO("Rondônia", 11),
	RR("Roraima", 14),
	SC("Santa Catarina", 42),
	SE("Sergipe", 28),
	SP("São Paulo", 35),
	TO("Tocantins", 17),
	EX("Exterior", 9999999);

	private final String descricao;

	private final int codigoIbge;

	private EnumUf(String descricao, int codigoIbge) {
		this.descricao = descricao;
		this.codigoIbge = codigoIbge;
	}

	public static EnumUf getEnumUf(int codigoIbge){
		for(EnumUf uf : values()){
			if(uf.getCodigoIbge() == codigoIbge){
				return uf;
			}
		}
		return null;
	}
//teste
	public String getDescricao() {
		return descricao;
	}

	public int getCodigoIbge() {
		return codigoIbge;
	}

}