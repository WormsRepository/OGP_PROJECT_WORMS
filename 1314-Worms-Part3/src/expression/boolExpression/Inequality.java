package expression.boolExpression;

import type.Boolean;
import expression.BoolExpression;
import expression.DoubleExpression;
import expression.E;


public class Inequality extends BoolExpression{

	public Inequality(int line, int column, E e1, E e2) {
		super(line, column, e1, e2);
	}
	
	@Override
	public Boolean getValue(){
		if(getE1() instanceof DoubleExpression)
			setValue(((DoubleExpression) getE1()).getValue().compareTo(
							((DoubleExpression) getE2()).getValue()) != 0);
		else if(getE1() instanceof BoolExpression)
			setValue(((BoolExpression) getE1()).getValue().getBoolean() != 
							((BoolExpression) getE2()).getValue().getBoolean());
		else{
			setValue(getE1().getValue() != getE2().getValue());
		}
		return super.getValue();
	}
}
