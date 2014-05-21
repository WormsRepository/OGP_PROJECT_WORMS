package expression.entityExpression;

import type.Entity;
import worms.model.World;
import worms.model.Worm;
import be.kuleuven.cs.som.annotate.Basic;
import expression.*;

public class SearchObject extends EntityExpression{
	
	public SearchObject(int line, int column, E e, Worm worm){
		super(line, column);
		this.e = e;
		this.worm = worm;
	}

	private Entity searchObject(){
		World world = this.getWorm().getWorld();
		
		double x = this.getWorm().getX();
		double y = this.getWorm().getY();
		double searchDirection = (this.getWorm().getDirection() + 
				((DoubleExpression) getE()).getValue().getDouble() + 2.0*Math.PI)
				%(2.0*Math.PI);
		
		double distanceToNearestEntity = 0;
		Entity nearestEntity = null;
		
		for(Entity entity: world.getAny()){
			double xOther = entity.getX();
			double yOther = entity.getY();
			double angle = 0;
			if((xOther - x) != 0){
				if(xOther > x)
					angle = Math.atan((entity.getY() - y)/(entity.getX() - x)) + 2.0*Math.PI;
				else
					angle = Math.atan((entity.getY() - y)/(entity.getX() - x)) + Math.PI;
			}
			else{
				if(yOther > y)
					angle = (Math.PI/2.0);
				else
					angle = ((3*Math.PI)/2.0);
			}
			angle = angle % (2.0*Math.PI);
			if(searchDirection - 0.06 <= angle && angle <= searchDirection + 0.06){
				double distance = Math.sqrt(Math.pow((x-xOther), 2.0) + Math.pow((y-yOther), 2.0));
				if(nearestEntity == null){
					nearestEntity = entity;
					distanceToNearestEntity = distance;
				}
				else if(distance < distanceToNearestEntity){
					nearestEntity = entity;
					distanceToNearestEntity = distance;
				}
			}
		}
		return nearestEntity;
	}
	
	@Basic
	public Worm getWorm(){
		return this.worm;
	}
	
	private final Worm worm;
	
	
	@Basic
	public E getE(){
		return this.e;
	}
	
	private final E e;
	
	
	@Override
	public Entity getValue(){
		setEntity(searchObject());
		return super.getValue();
	}
}
