package expression.entityExpression;

import worms.model.Worm;
import expression.EntityExpression;

public class Self extends EntityExpression{

	public Self(int line, int column, Worm worm) {
		super(line, column);
		this.setEntity(worm);
	}
}
