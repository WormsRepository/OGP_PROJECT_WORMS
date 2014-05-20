package expression;

import be.kuleuven.cs.som.annotate.Basic;
import type.Boolean;

public abstract class BoolExpression extends E{
	
	public BoolExpression(int line, int column, E e1, E e2) {
		super(line, column);
		this.e1 = e1;
		this.e2 = e2;
	}
	
	public BoolExpression(int line, int column, E e1) {
		this(line, column, e1, null);
	}
	
	public BoolExpression(int line, int column) {
		this(line, column, null, null);
	}

	@Basic
	public E getE1(){
		return this.e1;
	}
	
	private final E e1;
	
	@Basic
	public E getE2(){
		return this.e2;
	}
	
	private final E e2;
	
	protected void setValue(boolean value){
		this.value.setBoolean(value);
	}
	
	@Basic
	public Boolean getValue(){
		return this.value;
	}
	
	private Boolean value = new Boolean();
}
