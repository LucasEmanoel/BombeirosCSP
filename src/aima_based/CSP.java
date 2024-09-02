package aima_based;

import java.util.List;

public class CSP<VAR extends Pessoa, VAL> implements Cloneable {

	private final List<VAR> variables;
	private List<Dominio<VAL>> dominios;
	private final List<Constraint<VAR, VAL>> restricoes;
}
