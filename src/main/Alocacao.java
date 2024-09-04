package main;

import java.util.Objects;

public class Alocacao {
	private String area;
	private int horario;
	private String dia;
	
	public Alocacao(String area, int horario, String dia) {
		this.area = area;
		this.horario = horario;
		this.dia = dia;
	}
	

	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getHorario() {
		return horario;
	}
	public void setHorario(int horario) {
		this.horario = horario;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}


	@Override
	public int hashCode() {
		return Objects.hash(area, dia, horario);
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
		return Objects.equals(area, other.area) && Objects.equals(dia, other.dia) && horario == other.horario;
	}
	
	
	

}
