package expression;

import be.kuleuven.cs.som.annotate.Basic;
import type.Entity;
import worms.model.ImplementedPF;

public abstract class EntityExpression extends VariableAccess{

	public EntityExpression(int line, int column, String name, ImplementedPF implementedPF) {
		super(line, column, name, implementedPF);
	}
	
	public EntityExpression(int line, int column) {
		super(line, column);
	}

	//TODO implementing entity
	
	@Basic @Override
	public Entity getValue(){
		return this.entity;
	}
	
	protected void setEntity(Entity entity){
		this.entity = entity;
	}
	
	private Entity entity = null;
}
