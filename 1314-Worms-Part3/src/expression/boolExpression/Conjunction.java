package expression.boolExpression;

import expression.BoolExpression;
import expression.E;
import type.Boolean;


public class Conjunction extends BoolExpression {

	public Conjunction(int line, int column, E e1, E e2) {
		super(line, column, e1, e2);
	}
	
	@Override
	public Boolean getValue(){
		setValue(((BoolExpression) getE1()).getValue().getBoolean() && 
				((BoolExpression) getE2()).getValue().getBoolean());
		return super.getValue();
	}
}
