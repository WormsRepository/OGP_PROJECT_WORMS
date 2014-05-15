package expression.boolExpression;

import worms.model.Worm;
import be.kuleuven.cs.som.annotate.Basic;
import expression.BoolExpression;
import expression.E;
import expression.EntityExpression;

public class IsWorm extends BoolExpression{

	public IsWorm(int line, int column, E e) {
		super(line, column);
		this.e = e;
		setValue(isWorm());
	}

	
	@Basic
	public E getE(){
		return this.e;
	}
	
	private final E e;
	
	
	private boolean isWorm(){
		if(((EntityExpression) getE()).getValue() instanceof Worm)
			return true;
		return false;
	}
}
