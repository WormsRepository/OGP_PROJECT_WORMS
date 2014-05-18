package expression.entityExpression;

import be.kuleuven.cs.som.annotate.Basic;
import type.Entity;
import worms.model.ImplementedPF;
import worms.model.Worm;
import expression.EntityExpression;

public class Self extends EntityExpression{

	public Self(int line, int column, Worm worm) {
		super(line, column);
		this.worm = worm;
	}
	
	@Basic
	public Worm getWorm(){
		return this.worm;
	}
	
	private final Worm worm;

	
	@Override
	public Entity getValue(){
		return getWorm();
	}
}
