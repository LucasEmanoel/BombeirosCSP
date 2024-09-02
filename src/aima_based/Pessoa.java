package aima_based;

import java.util.Objects;

public class Pessoa {
	private final String nome;
	private final String dias;
	
	public Pessoa(String nome, String dias) {
		super();
		this.nome = nome;
		this.dias = dias;
	}
	
	
	public String getNome() {
		return nome;
	}
	public String getDias() {
		return dias;
	}


	@Override
	public int hashCode() {
		return Objects.hash(dias, nome);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(dias, other.dias) && Objects.equals(nome, other.nome);
	}
}
