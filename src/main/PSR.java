package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PSR {
	private List<Pessoa> variaveis; // cada pessoa
	private Map<Pessoa, List<Alocacao>> dominios; // Cada pessoa tem locais para ser alocado
	private Map<Pessoa, List<Alocacao>> restricoes; // uma pessoa nao pode estar em dois departamentos no mesmo dia e horario
	
	public PSR(
			ArrayList<Pessoa> funcionarios,
			Map<Pessoa, List<Alocacao>> dominios,
			Map<Pessoa, List<Alocacao>> restricoes
			) {
		this.variaveis = funcionarios;
		this.dominios = dominios;
		this.restricoes = restricoes;
	}
	
	public List<Pessoa> getVariaveis() {
		return variaveis;
	}
	
	public boolean valorEhConsistente(Pessoa func, Alocacao alocacao) {
		for (Map.Entry<Pessoa, List<Alocacao>> val : dominios.entrySet()) {
			for(Alocacao a : val.getValue()) {
				if(a.getDia().equals(alocacao.getDia()) && val.getKey().equals(func)) { // se a alocação existir no conjunto de restrições não entra
					return false;
				}
			}
		}
		return true;
	}

	// só uma hipotese: como cada dia é uma alocação imagino que o tamanho da solução seja igual(pode estar errado)
	public boolean solucaoCompleta(Map<Alocacao, Pessoa> solution) { 
		int count = 0;
		for (Pessoa pessoa : variaveis) {
			if(Integer.parseInt(pessoa.getDias()) > 0) {
				count += Integer.parseInt(pessoa.getDias());
			}
		}
		
		return solution.size() == count;
	}
}
