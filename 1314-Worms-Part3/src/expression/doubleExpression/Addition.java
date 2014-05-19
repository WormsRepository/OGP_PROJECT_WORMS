package expression.doubleExpression;

import expression.DoubleExpression;
import expression.E;
import type.Double;

public class Addition extends DoubleExpression{

	public Addition(int line, int column, E e1, E e2) {
		super(line, column, e1, e2);
	}
	
	@Override
	public Double getValue(){
		setValue(((DoubleExpression) getE1()).getValue().getDouble() + 
				((DoubleExpression) getE2()).getValue().getDouble());
		return super.getValue();
	}
}
