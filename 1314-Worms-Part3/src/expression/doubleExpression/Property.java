package expression.doubleExpression;

import type.Entity;
import expression.DoubleExpression;
import expression.E;
import expression.EntityExpression;
import type.Double;

public abstract class Property extends DoubleExpression{

	public Property(int line, int column, E e) {
		super(line, column);
		entity = ((EntityExpression) e).getValue();
	}
	
	public Entity getEntity(){
		return this.entity;
	}
	
	//TODO zorgen dat entity niet null is na eerste keer parsen.
	
	private final Entity entity;
	
	@Override
	public Double getValue(){
		if(getEntity() != null){
			Double x = new Double();
			x.setDouble(this.getProperty(getEntity()));
			return x;
		}
		else{
			Double y = new Double();
			return y;
		}
	}
	//TODO laten extenden door doubleExpression
	protected abstract double getProperty(Entity entity);
}
