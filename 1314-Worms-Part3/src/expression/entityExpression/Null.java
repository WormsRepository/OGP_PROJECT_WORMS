package expression.entityExpression;

import expression.EntityExpression;

public class Null extends EntityExpression{

	public Null(int line, int column) {
		super(line, column);
		setEntity(null);
	}
}
