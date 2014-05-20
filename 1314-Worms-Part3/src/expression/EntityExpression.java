package expression;

import be.kuleuven.cs.som.annotate.Basic;
import type.Entity;

public abstract class EntityExpression extends E{

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
