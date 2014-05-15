package expression.doubleExpression.property;

import type.Entity;
import worms.model.Food;
import worms.model.Worm;
import expression.E;
import expression.doubleExpression.Property;

public class GetRadius extends Property{

	public GetRadius(int line, int column, E e) {
		super(line, column, e);
	}

	@Override
	protected double getProperty(Entity entity) {
		if(Worm.class.isInstance(entity)){
			Worm worm = (Worm) entity;
			return worm.getRadius();
		}
		else if(Food.class.isInstance(entity))
			return Food.getRadius();
		else 
			return 0;
	}
}
