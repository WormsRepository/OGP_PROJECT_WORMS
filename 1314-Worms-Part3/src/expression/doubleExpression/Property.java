package expression.doubleExpression;

import type.Entity;
import expression.DoubleExpression;
import expression.E;
import expression.EntityExpression;
import type.Double;

public abstract class Property extends DoubleExpression{

	public Property(int line, int column, E e) {
		super(line, column, e);
	}
	
	public Entity getEntity(){
		return this.entity;
	}
	
	private void setEntity(){
		this.entity = ((EntityExpression) getE1()).getValue();
	}
	
	private Entity entity = null;
	
	@Override
	public Double getValue(){
		setEntity();
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
	protected abstract double getProperty(Entity entity);
}
