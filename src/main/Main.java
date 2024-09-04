package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		ArrayList<Pessoa> funcionarios = Fs.lerEntrada();
		List<Alocacao> possiveisAlocacoes = new ArrayList<>();
		
		ArrayList<String> dias = new ArrayList<>(List.of("DOM______", "SEG______", "TER______", "QUA______", "QUI______", "SEX______", "SAB______"));
		ArrayList<String> locais = new ArrayList<>(List.of("Incendio", "Socorro", "Telefone" ));
		ArrayList<Integer> turnos = new ArrayList<>(List.of(1, 2));

			
		for (String d : dias) {
			for (String l : locais) {
				for (Integer t : turnos) {
					Alocacao a = new Alocacao(l, t, d);
 					possiveisAlocacoes.add(a);
				}
			}
		}
		
		CSP psr = new CSP();
		
		for (Alocacao a : possiveisAlocacoes) {
			psr.addVar(a);
			psr.addDom(a, funcionarios);
			psr.addRes(a, new ArrayList<>());
		}
			
		HashMap<Alocacao,Pessoa> calendar= psr.search();
		
		for (String l : locais) {
	        System.out.println(l);
	        for (String d : dias) {
	            System.out.print(d);
	        }
	        System.out.println();


	        for (int turno = 1; turno < 3; turno++) {
	            for (String dia : dias) {
	            	Alocacao chaveBusca = new Alocacao(l, turno, dia);
	            	
	            	Pessoa pessoaEncontrada = calendar.get(chaveBusca);
	            	if(pessoaEncontrada != null) System.out.print(pessoaEncontrada.getName());

	            }
	            System.out.println();
	        }
	        
		}
	}

}
