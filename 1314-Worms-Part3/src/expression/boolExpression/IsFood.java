package expression.boolExpression;

import type.Boolean;
import worms.model.Food;
import expression.BoolExpression;
import expression.E;
import expression.EntityExpression;

public class IsFood extends BoolExpression{
	
	public IsFood(int line, int column, E e) {
		super(line, column, e);
	}
	
	@Override
	public Boolean getValue(){
		setValue(isFood());
		return super.getValue();
	}
	
	private boolean isFood(){
		if(((EntityExpression) getE1()).getValue() instanceof Food)
			return true;
		return false;
	}
}
