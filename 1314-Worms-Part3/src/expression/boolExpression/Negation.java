package expression.boolExpression;

import expression.BoolExpression;
import expression.E;


public class Negation extends BoolExpression{

	public Negation(int line, int column, E e) {
		super(line, column);
		setValue(!((BoolExpression) e).getValue().getBoolean());
	}
}
