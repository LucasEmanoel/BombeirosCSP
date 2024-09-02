package aima_based;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Dominio<VAL> implements Iterable<VAL> {

	private final Object[] funcionarios;
	
	public Dominio(Pessoa[] funcionarios) {
		super();
		this.funcionarios = funcionarios;
	}

	public Object[] getFuncionarios() {
		return funcionarios;
	}
	
	public int size() {
		return funcionarios.length;
	}
	
	public VAL get(int index) {
		return (VAL) funcionarios[index];
	}
	
	public boolean isEmpty() {
		return funcionarios.length == 0;
	}
	
	public boolean contains(VAL value) {
		for (Object object : funcionarios) {
			if(value.equals(object)) return true;	
		}
		return false;
	}
	
	public List<VAL> asList() {
		return Arrays.asList((VAL[]) funcionarios);
	}
	
	@Override
	public Iterator<VAL> iterator() {
		// TODO Auto-generated method stub
		return new ArrayIterator<>((VAL[]) funcionarios); //fix
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(funcionarios);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dominio other = (Dominio) obj;
		return Arrays.deepEquals(funcionarios, other.funcionarios);
	}

	@Override
	public String toString() {
		return "Dominio [funcionarios=" + Arrays.toString(funcionarios) + "]";
	}

	
}
