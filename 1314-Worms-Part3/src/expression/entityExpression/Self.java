package expression.entityExpression;

import be.kuleuven.cs.som.annotate.Basic;
import type.Entity;
import worms.model.ImplementedPF;
import worms.model.Worm;
import expression.EntityExpression;

public class Self extends EntityExpression{

	public Self(int line, int column, ImplementedPF implementedPF) {
		super(line, column);
		this.implementedPF = implementedPF;
	}
	
	@Basic
	public ImplementedPF getImplementedPF(){
		return this.implementedPF;
	}
	
	private final ImplementedPF implementedPF;
	
	@Override
	public Entity getValue(){
		setEntity(getImplementedPF().getWorm());
		return super.getValue();
	}
}
