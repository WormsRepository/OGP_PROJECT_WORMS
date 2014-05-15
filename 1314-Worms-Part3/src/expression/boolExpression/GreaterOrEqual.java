package expression.boolExpression;

import expression.BoolExpression;
import expression.DoubleExpression;
import expression.E;


public class GreaterOrEqual extends BoolExpression {

	public GreaterOrEqual(int line, int column, E e1, E e2) {
		super(line, column);
		setValue(((DoubleExpression) e1).getValue().compareTo(
						((DoubleExpression) e2).getValue()) >= 0);
	}
}
