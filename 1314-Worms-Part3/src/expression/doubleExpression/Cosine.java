package expression.doubleExpression;

import expression.DoubleExpression;
import expression.E;
import type.Double;

public class Cosine extends DoubleExpression{

	public Cosine(int line, int column, E e) {
		super(line, column, e);
	}
	
	@Override
	public Double getValue(){
		setValue(Math.cos(((DoubleExpression) getE1()).getValue().getDouble()));
		return super.getValue();
	}
}
