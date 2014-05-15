package expression.doubleExpression;

import expression.DoubleExpression;
import expression.E;

public class SquareRoot extends DoubleExpression{

	public SquareRoot(int line, int column, E e) {
		super(line, column);
		setValue(Math.sqrt(((DoubleExpression) e).getValue().getDouble()));
	}
}
