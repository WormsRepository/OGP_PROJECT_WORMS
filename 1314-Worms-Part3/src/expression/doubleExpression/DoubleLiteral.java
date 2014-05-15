package expression.doubleExpression;

import expression.DoubleExpression;

public class DoubleLiteral extends DoubleExpression{

	public DoubleLiteral(int line, int column, double d) {
		super(line, column);
		setValue(d);
	}
}
