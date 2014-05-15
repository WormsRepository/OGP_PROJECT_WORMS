package statement;

import be.kuleuven.cs.som.annotate.*;
import type.Entity;
import expression.BoolExpression;
import expression.DoubleExpression;
import expression.E;
import expression.EntityExpression;

public class Print extends S{
	
	public Print(int line, int column, E e){
		super(line, column);
		this.e = e;
	}

	@Basic
	public E getE(){
		return this.e;
	}
	
	private final E e;
	
	@Override
	public void execute(Entity entity) {
		if(getE() instanceof DoubleExpression)
			System.out.println(((DoubleExpression) getE()).getValue().getDouble());
		else if(getE() instanceof BoolExpression)
			System.out.println(((BoolExpression) getE()).getValue().getBoolean());
		else if(getE() instanceof EntityExpression)
			System.out.println(((EntityExpression) getE()).getValue());
	}
}
