package expression.boolExpression;

import type.Boolean;
import worms.model.Worm;
import expression.BoolExpression;
import expression.E;
import expression.EntityExpression;

public class IsWorm extends BoolExpression{

	public IsWorm(int line, int column, E e) {
		super(line, column, e);
	}
	
	@Override
	public Boolean getValue(){
		setValue(isWorm());
		return super.getValue();
	}
	
	private boolean isWorm(){
		if(((EntityExpression) getE1()).getValue() instanceof Worm)
			return true;
		return false;
	}
}
