package expression.doubleExpression;

import type.Double;
import expression.DoubleExpression;
import expression.E;

public class Subtraction extends DoubleExpression{

	public Subtraction(int line, int column, E e1, E e2) {
		super(line, column);
		setValue( ((Double) e1.getValue()).getDouble() - 
					((Double) e2.getValue()).getDouble());
	}
}
