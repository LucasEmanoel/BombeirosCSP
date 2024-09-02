package main;

import java.util.Objects;

public class Alocacao {
	private String funcionario;
	private String horario;
	
	public Alocacao() {

	}
	
	public Alocacao(String funcionario, String horario) {
		super();
		this.funcionario = funcionario;
		this.horario = horario;
	}
	public String getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(funcionario, horario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alocacao other = (Alocacao) obj;
		return Objects.equals(funcionario, other.funcionario) && Objects.equals(horario, other.horario);
	}
	
}
