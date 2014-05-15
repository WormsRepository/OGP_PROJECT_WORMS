package expression.boolExpression;

import expression.BoolExpression;
import expression.DoubleExpression;
import expression.E;


public class Equality extends BoolExpression {

	public Equality(int line, int column, E e1, E e2) {
		
		super(line, column);
		if(e1 instanceof DoubleExpression)
			setValue(((DoubleExpression) e1).getValue().compareTo(
							((DoubleExpression) e2).getValue()) == 0);
		else if(e1 instanceof BoolExpression)
			setValue(((BoolExpression) e1).getValue().getBoolean() == 
							((BoolExpression) e2).getValue().getBoolean());
		else{
			setValue(e1.getValue() == e2.getValue());
		}
	}
}
