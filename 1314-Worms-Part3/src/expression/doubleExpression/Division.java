package expression.doubleExpression;

import type.Double;
import expression.DoubleExpression;
import expression.E;

public class Division extends DoubleExpression{

	public Division(int line, int column, E e1, E e2) {
		super(line, column, e1, e2);
	}
	
	@Override
	public Double getValue(){
		setValue(((DoubleExpression) getE1()).getValue().getDouble() / 
				((DoubleExpression) getE2()).getValue().getDouble());
		return super.getValue();
	}
}
