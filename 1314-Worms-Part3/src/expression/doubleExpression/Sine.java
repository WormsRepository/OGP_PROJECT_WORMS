package expression.doubleExpression;

import expression.DoubleExpression;
import expression.E;

public class Sine extends DoubleExpression{

	public Sine(int line, int column, E e) {
		super(line, column);
		setValue(Math.sin(((DoubleExpression) e).getValue().getDouble()));
	}
}
