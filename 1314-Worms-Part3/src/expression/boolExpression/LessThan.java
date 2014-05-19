package expression.boolExpression;

import type.Boolean;
import expression.BoolExpression;
import expression.DoubleExpression;
import expression.E;


public class LessThan extends BoolExpression {

	public LessThan(int line, int column, E e1, E e2) {
		super(line, column, e1, e2);
	}

	@Override
	public Boolean getValue(){
		setValue(((DoubleExpression) getE1()).getValue().compareTo(
				((DoubleExpression) getE2()).getValue()) < 0);
		return super.getValue();
	}
}
