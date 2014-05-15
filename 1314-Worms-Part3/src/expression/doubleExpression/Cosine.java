package expression.doubleExpression;

import expression.DoubleExpression;
import expression.E;

public class Cosine extends DoubleExpression{

	public Cosine(int line, int column, E e) {
		super(line, column);
		setValue(Math.cos(((DoubleExpression) e).getValue().getDouble()));
	}
}
