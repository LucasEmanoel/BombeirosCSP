package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Psr {
	private List<Alocacao> variaveis; // cada pessoa
	private Map<String, List<String>> dominios; // para cada horario deve ser estabelecido valores possiveis!
	private Map<String, List<String>> restricoes; // para cada horario deve ser estabelecido valores que nao podem usar!
	
	public Psr(ArrayList<Alocacao> alocacoes) {
		this.variaveis = alocacoes;
	}
	
	public List<Alocacao> getVariaveis() {
		return variaveis;
	}
	
	
}
