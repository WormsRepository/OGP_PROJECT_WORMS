package expression.boolExpression;

import type.Boolean;
import expression.BoolExpression;
import expression.E;

public class Negation extends BoolExpression{

	public Negation(int line, int column, E e) {
		super(line, column, e);
	}
	
	@Override
	public Boolean getValue(){
		setValue(!((BoolExpression) getE1()).getValue().getBoolean());
		return super.getValue();
	}
}
