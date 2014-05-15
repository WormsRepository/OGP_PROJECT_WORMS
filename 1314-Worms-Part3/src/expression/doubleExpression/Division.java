package expression.doubleExpression;

import expression.DoubleExpression;
import expression.E;

public class Division extends DoubleExpression{

	public Division(int line, int column, E e1, E e2) {
		super(line, column);
		setValue(((DoubleExpression) e1).getValue().getDouble() / 
					((DoubleExpression) e2).getValue().getDouble());
	}
}
