package expression.boolExpression;

import worms.model.Food;
import be.kuleuven.cs.som.annotate.Basic;
import expression.BoolExpression;
import expression.E;
import expression.EntityExpression;

public class IsFood extends BoolExpression{
	
	public IsFood(int line, int column, E e) {
		super(line, column);
		this.e = e;
		setValue(isFood());
	}

	
	@Basic
	public E getE(){
		return this.e;
	}
	
	private final E e;
	
	
	private boolean isFood(){
		if(((EntityExpression) getE()).getValue() instanceof Food)
			return true;
		return false;
	}
}
