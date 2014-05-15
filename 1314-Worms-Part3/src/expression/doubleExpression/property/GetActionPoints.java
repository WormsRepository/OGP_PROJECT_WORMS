package expression.doubleExpression.property;

import type.Entity;
import worms.model.Worm;
import expression.E;
import expression.doubleExpression.Property;


public class GetActionPoints extends Property{

	public GetActionPoints(int line, int column, E e) {
		super(line, column, e);
	}

	@Override
	protected double getProperty(Entity entity) {
		if(Worm.class.isInstance(entity)){
			return ((Worm) entity).getCurrentActionPoints();
		}
		else
			return 0;
	}
}
