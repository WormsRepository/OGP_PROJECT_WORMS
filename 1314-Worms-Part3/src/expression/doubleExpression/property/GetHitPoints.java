package expression.doubleExpression.property;

import type.Entity;
import worms.model.Worm;
import expression.E;
import expression.doubleExpression.Property;


public class GetHitPoints extends Property{

	public GetHitPoints(int line, int column, E e) {
		super(line, column, e);
	}

	@Override
	protected double getProperty(Entity entity) {
		if(Worm.class.isInstance(entity)){
			return ((Worm) entity).getCurrentHitPoints();
		}
		else
			return 0;
	}
}
