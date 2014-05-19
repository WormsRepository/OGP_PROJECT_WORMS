package expression.doubleExpression;

import type.Double;
import expression.DoubleExpression;
import expression.E;

public class Sine extends DoubleExpression{

	public Sine(int line, int column, E e) {
		super(line, column, e);
	}
	
	@Override
	public Double getValue(){
		setValue(Math.sin(((DoubleExpression) getE1()).getValue().getDouble()));
		return super.getValue();
	}
}
