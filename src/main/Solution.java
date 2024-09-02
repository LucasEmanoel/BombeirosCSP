package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Solution {
	/*PSR = */
	/* Entrada deve ser convertida em uma estrutura de dados */
	/* Retornar uma matriz*/
	public static void main(String[] args) {
		ArrayList<Alocacao> alocacoes = new ArrayList<Alocacao>();
		alocacoes = lerEntrada();
		
		for (Alocacao alocacao : alocacoes) {
			System.out.println(alocacao.toString());
		}
		
		Psr psr = new Psr(alocacoes);
		ArrayList<String> solucao = pesquisaComRetrocesso(psr);
	}
	
	public static ArrayList<String> pesquisaComRetrocesso(Psr psr) {
		ArrayList<String> solution = new ArrayList<>(); 
		return retrocessoRecursivo(solution, psr);
	}
	public static ArrayList<String> retrocessoRecursivo(ArrayList<String> solution, Psr psr) {
		if (solucaoCompleta(solution, psr)) { // criar uma funcao para verificar se esta completa
			return solution;
		}
		
		String valorNaoAtribuido = selecionarVariavelNaoAtribuida(psr);
		String[] valoresOrdem = valoresDeOrdemNoDominio(psr, solution, valorNaoAtribuido);
		
		for (int i = 0; i < valoresOrdem.length; i++) {
			if(valorEhConsistente(valoresOrdem[i], solution, psr)) {
				
				valorNaoAtribuido = valoresOrdem[i];
				boolean inferencia = inferencia(psr, solution, valorNaoAtribuido);
				
				if(inferencia) {
					
					ArrayList<String> resultado = retrocessoRecursivo(solution, psr);
					if(resultado != null) {
						return resultado;
					}
				}
				
			}
			solution.remove(valorNaoAtribuido);
		}
		return null;
		
	}
	
	
	private static boolean solucaoCompleta(ArrayList<String> solution, Psr psr) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean valorEhConsistente(String string, ArrayList<String> solution, Psr psr) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean inferencia(Psr psr, ArrayList<String> solution, String valorNaoAtribuido) {
		// TODO Auto-generated method stub
		return false;
	}

	private static String[] valoresDeOrdemNoDominio(Psr psr, ArrayList<String> solution, String valorNaoAtribuido) {
		// TODO Auto-generated method stub
		return null;
	}

	private static String selecionarVariavelNaoAtribuida(Psr psr) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	public static ArrayList<Alocacao> lerEntrada() {
		
		File file = new File("/home/lucasemanoel/projects/workspace-spring-tool-suite-4-4.18.0.RELEASE/BombeirosCSP/src/main/entrada_1.txt");
		ArrayList<Alocacao> alocacoes = new ArrayList<Alocacao>();
		String l = "";
		
		try(FileReader fileReader = new FileReader(file);
			BufferedReader bf = new BufferedReader(fileReader);) {
			
			
			while( (l = bf.readLine()) != null) {
				
				String[] partes = l.split(",");
				Alocacao aux = new Alocacao(partes[0], partes[1]);
				alocacoes.add(aux);
			}
			
			return alocacoes;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
