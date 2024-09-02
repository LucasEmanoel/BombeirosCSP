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
		Map<Pessoa, List<Alocacao>> dominios = new HashMap<>();
		
		//dias
		String[] dias = {"DOM______", "SEG______", "TER______", "QUA______", "QUI______", "SEX______", "SAB______"};
		String[] locais = {"Incendio", "Socorro", "Telefone"};
		Integer[] turnos = {1, 2};
		
		List<Alocacao> possiveisAlocacoes = new ArrayList<>();
		
 		for (int i = 0; i < dias.length; i++) {
 			for (int j = 0; j < locais.length; j++) {
 				for (int k = 0; k < turnos.length; k++) {
 					Alocacao a = new Alocacao(dias[i], locais[j], turnos[k]);
 					possiveisAlocacoes.add(a);
 				}
 			}
		}
		//cada variavel inicia com todas alocacoes possiveis, ou seja, no primeiro momento um funcionario pode ser alocado em qualquer lugar, a qualquer dia da semana e turno
 		for (Pessoa f : funcionarios) {
			dominios.put(f, possiveisAlocacoes);
		}
		
		
		PSR psr = new PSR(funcionarios, null, null);
		Map<Alocacao, Pessoa> solucao = pesquisaComRetrocesso(psr);
	}
	
	public static Map<Alocacao, Pessoa> pesquisaComRetrocesso(PSR psr) {
		Map<Alocacao, Pessoa> solution = new HashMap<>(); 
		return retrocessoRecursivo(solution, psr);
	}
	
	public static Map<Alocacao, Pessoa> retrocessoRecursivo(Map<Alocacao, Pessoa> atribuicao, PSR psr) {
		if (psr.solucaoCompleta(atribuicao)) { // criar uma funcao para verificar se esta completa
			return atribuicao;
		}
		
		Pessoa valorNaoAtribuido = selecionarVariavelNaoAtribuida(psr, atribuicao);
		//List<Alocacao> valoresOrdem = valoresDeOrdemNoDominio(psr, atribuicao, valorNaoAtribuido)
		
		for (Alocacao a : valoresDeOrdemNoDominio(psr, atribuicao, valorNaoAtribuido)) {
			if(psr.valorEhConsistente(valorNaoAtribuido, a)) { // acredito que devemos verificar se o valor não colide com as restrições
				
				atribuicao.put(a, valorNaoAtribuido);
				boolean inferencia = inferencia(psr, atribuicao, valorNaoAtribuido);
				
				if(inferencia) {
					// oque seria adicionar inferencia para a atribuição
					Map<Alocacao, Pessoa> resultado = retrocessoRecursivo(atribuicao, psr);
					if(resultado != null) {
						return resultado;
					}
				}
				
			}
			atribuicao.remove(a);
		}
		return null;
		
	}

	private static boolean inferencia(PSR psr, Map<Alocacao, Pessoa> solution, Pessoa valorNaoAtribuido) { //nao faço a minima ideia
		// TODO Auto-generated method stub
		return false;
	}
	
	private static List<Alocacao> valoresDeOrdemNoDominio(PSR psr, Map<Alocacao, Pessoa> atribuicao, Pessoa valorNaoAtribuido) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Pessoa selecionarVariavelNaoAtribuida(PSR psr, Map<Alocacao, Pessoa> atribuicao) {
		Pessoa varPessoa = new Pessoa();
		//paliativa, acho que deve verificar os dias que a pessoa atua, pq ai da pra conseguir verificar se a pessoa tem alocacao e se pode alocar dnv
		for (Pessoa a : psr.getVariaveis()) {
			if(!atribuicao.containsValue(a)) {
				return varPessoa;
			}
		}
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
