package main;

import java.util.Objects;

public class Pessoa {
	private String funcionario;
	private String dias;
	
	public Pessoa() {}
	
	public Pessoa(String funcionario, String horario) {
		super();
		this.funcionario = funcionario;
		this.dias = horario;
	}
	public String getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}
	public String getDias() {
		return dias;
	}
	public void setDias(String dias) {
		this.dias = dias;
	}

	@Override
	public int hashCode() {
		return Objects.hash(funcionario, dias);
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
		return Objects.equals(funcionario, other.funcionario) && Objects.equals(dias, other.dias);
	}

	
	
}
