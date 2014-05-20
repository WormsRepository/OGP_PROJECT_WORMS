package expression;

import be.kuleuven.cs.som.annotate.Basic;
import type.Double;

public abstract class DoubleExpression extends E{
	
	public DoubleExpression(int line, int column, E e1, E e2){
		super(line, column);
		this.e1 = e1;
		this.e2 = e2;
	}
	
	public DoubleExpression(int line, int column, E e1) {
		this(line, column, e1, null);
	}
	
	public DoubleExpression(int line, int column){
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
	
	protected void setValue(double value){
		this.value.setDouble(value);
	}
	
	@Basic
	public Double getValue(){
		return this.value;
	}
	
	private Double value = new Double();
}
