package expression.boolExpression;

import expression.BoolExpression;
import expression.E;


public class Disjunction extends BoolExpression {

	public Disjunction(int line, int column, E e1, E e2) {
		super(line, column);
		setValue(((BoolExpression) e1).getValue().getBoolean() ||
				((BoolExpression) e2).getValue().getBoolean());
	}

}
