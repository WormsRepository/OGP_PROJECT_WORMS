package expression.boolExpression;

import expression.BoolExpression;
import expression.E;


public class Conjunction extends BoolExpression {

	public Conjunction(int line, int column, E e1, E e2) {
		
		super(line, column);
		setValue(((BoolExpression) e1).getValue().getBoolean() && 
				((BoolExpression) e2).getValue().getBoolean());
	}

}
