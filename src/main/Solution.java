package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	/*PSR = conjunto de variaveis, dominio e restrições*/
	/* Entrada deve ser convertida em uma estrutura de dados */
	/* Retornar todas alocações */
	public static void main(String[] args) {
		ArrayList<Pessoa> funcionarios = lerEntrada();
		
		PSR psr = new PSR(funcionarios);
		Map<Alocacao, Pessoa> solucao = pesquisaComRetrocesso(psr);
	}
	
	public static Map<Alocacao, Pessoa> pesquisaComRetrocesso(PSR psr) {
		Map<Alocacao, Pessoa> solution = new HashMap<>(); 
		return retrocessoRecursivo(solution, psr);
	}
	
	public static Map<Alocacao, Pessoa> retrocessoRecursivo(Map<Alocacao, Pessoa> solution, PSR psr) {
		if (psr.solucaoCompleta(solution)) { // criar uma funcao para verificar se esta completa
			return solution;
		}
		
		Pessoa valorNaoAtribuido = selecionarVariavelNaoAtribuida(psr);
		List<Alocacao> valoresOrdem = valoresDeOrdemNoDominio(psr, solution, valorNaoAtribuido);
		
		for (Alocacao a : valoresOrdem ) {
			if(psr.valorEhConsistente(valorNaoAtribuido, a)) { // acredito que devemos verificar se o valor não colide com as restrições
				
				solution.put(a, valorNaoAtribuido);
				boolean inferencia = inferencia(psr, solution, valorNaoAtribuido);
				
				if(inferencia) {
					
					Map<Alocacao, Pessoa> resultado = retrocessoRecursivo(solution, psr);
					if(resultado != null) {
						return resultado;
					}
				}
				
			}
			solution.remove(a);
		}
		return null;
		
	}
	
	
	


	private static boolean inferencia(PSR psr, Map<Alocacao, Pessoa> solution, Pessoa valorNaoAtribuido) {
		// TODO Auto-generated method stub
		return false;
	}

	private static List<Alocacao> valoresDeOrdemNoDominio(PSR psr, Map<Alocacao, Pessoa> solution, Pessoa valorNaoAtribuido) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Pessoa selecionarVariavelNaoAtribuida(PSR psr) {
		
		return null;
	}

	
	public static ArrayList<Pessoa> lerEntrada() {
		
		File file = new File("/home/lucasemanoel/projects/workspace-spring-tool-suite-4-4.18.0.RELEASE/BombeirosCSP/src/main/entrada_1.txt");
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		String l = "";
		
		try(FileReader fileReader = new FileReader(file);
			BufferedReader bf = new BufferedReader(fileReader);) {
			
			
			while( (l = bf.readLine()) != null) {
				
				String[] partes = l.split(",");
				Pessoa aux = new Pessoa(partes[0], partes[1]);
				pessoas.add(aux);
			}
			
			return pessoas;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
