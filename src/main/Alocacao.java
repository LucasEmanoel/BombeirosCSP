package main;

import java.util.Objects;

public class Alocacao {
	private String dia;
	private String local;
	private Integer turno; // 1 ou 2
	
	public Alocacao() {}
	
	public Alocacao(String dia, String local, Integer turno) {
		super();
		this.dia = dia;
		this.local = local;
		this.turno = turno;
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

	public Integer getTurno() {
		return turno;
	}

	public void setTurno(Integer horario) {
		this.turno = horario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dia, turno, local);
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
		return Objects.equals(dia, other.dia) && Objects.equals(turno, other.turno)
				&& Objects.equals(local, other.local);
	}

	@Override
	public String toString() {
		return "Alocacao [dia=" + dia + ", local=" + local + ", horario=" + turno + "]";
	}
	
}
