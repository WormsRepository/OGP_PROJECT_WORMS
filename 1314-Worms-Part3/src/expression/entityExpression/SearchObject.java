package expression.entityExpression;

import be.kuleuven.cs.som.annotate.Basic;
import expression.E;
import expression.EntityExpression;

public class SearchObject extends EntityExpression{
	
	public SearchObject(int line, int column, E e){
		super(line, column);
		this.e = e;
	}

	@Basic
	public E getE(){
		return this.e;
	}
	
	private final E e;
}
