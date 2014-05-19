package expression.boolExpression;

import type.Boolean;
import expression.BoolExpression;
import expression.E;


public class Disjunction extends BoolExpression {

	public Disjunction(int line, int column, E e1, E e2) {
		super(line, column, e1, e2);
	}

	@Override
	public Boolean getValue(){
		setValue(((BoolExpression) getE1()).getValue().getBoolean() ||
				((BoolExpression) getE2()).getValue().getBoolean());
		return super.getValue();
	}
}
