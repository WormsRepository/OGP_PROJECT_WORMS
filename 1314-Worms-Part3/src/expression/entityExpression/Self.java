package expression.entityExpression;

import be.kuleuven.cs.som.annotate.Basic;
import type.Entity;
import worms.model.ImplementedPF;
import worms.model.Worm;
import expression.EntityExpression;

public class Self extends EntityExpression{

	public Self(int line, int column, ImplementedPF implementedPF, Worm worm) {
		super(line, column);
		this.implementedPF = implementedPF;
		this.worm = worm;
	}
	
	private Worm worm = null;
	@Basic
	public ImplementedPF getImplementedPF(){
		return this.implementedPF;
	}
	
	private final ImplementedPF implementedPF;
	
	@Override
	public Entity getValue(){
		return worm;
	}
}
