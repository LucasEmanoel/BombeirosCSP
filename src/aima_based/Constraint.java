package aima_based;

import java.util.List;

public interface Constraint<VAR extends Pessoa, VAL> {
	List<VAR> getScope();


	boolean isSatisfiedWith(Assignment<VAR, VAL> assignment);
}
