package expression.doubleExpression.property;

import type.Entity;
import worms.model.Worm;
import expression.E;
import expression.doubleExpression.Property;

public class GetMaxHitPoints extends Property{

	public GetMaxHitPoints(int line, int column, E e) {
		super(line, column, e);
	}

	@Override
	protected double getProperty(Entity entity) {
		if(entity instanceof Worm){
			return ((Worm) entity).getMaxHitPoints();
		}
		else
			return 0;
	}
}
