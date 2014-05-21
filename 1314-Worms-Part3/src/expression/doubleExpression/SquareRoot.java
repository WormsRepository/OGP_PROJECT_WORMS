package expression.doubleExpression;

import type.Double;
import expression.DoubleExpression;
import expression.E;

public class SquareRoot extends DoubleExpression{

	public SquareRoot(int line, int column, E e) {
		super(line, column, e);
	}
	
	@Override
	public Double getValue(){
		setValue(Math.sqrt(((DoubleExpression) getE1()).getValue().getDouble()));
		return super.getValue();
	}
}
