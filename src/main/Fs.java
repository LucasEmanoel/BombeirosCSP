package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Fs {
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
