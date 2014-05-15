package expression.boolExpression;

import expression.BoolExpression;


public class BoolLiteral extends BoolExpression {

	public BoolLiteral(int line, int column, boolean b) {
		super(line, column);
		setValue(b);
	}
	
}
