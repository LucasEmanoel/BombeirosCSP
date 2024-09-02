package main;

import java.util.Objects;

public class Alocacao {
	private String dia;
	private String local;
	private Integer horario; // 1 ou 2
	
	public Alocacao() {}
	
	public Alocacao(String dia, String local, Integer horario) {
		super();
		this.dia = dia;
		this.local = local;
		this.horario = horario;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Integer getHorario() {
		return horario;
	}

	public void setHorario(Integer horario) {
		this.horario = horario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dia, horario, local);
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
		return Objects.equals(dia, other.dia) && Objects.equals(horario, other.horario)
				&& Objects.equals(local, other.local);
	}

	@Override
	public String toString() {
		return "Alocacao [dia=" + dia + ", local=" + local + ", horario=" + horario + "]";
	}
	
}
