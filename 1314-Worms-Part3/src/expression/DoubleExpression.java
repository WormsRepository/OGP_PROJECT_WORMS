package expression;

import be.kuleuven.cs.som.annotate.Basic;
import type.Double;
import worms.model.ImplementedPF;
import worms.model.Worm;

public abstract class DoubleExpression extends VariableAccess{

	public DoubleExpression(int line, int column, String name, Worm worm) {
		super(line, column, name, worm);
	}
	
	public DoubleExpression(int line, int column) {
		super(line, column);
	}
	
	protected void setValue(double value){
		this.value.setDouble(value);
	}
	
	@Basic
	public Double getValue(){
		return this.value;
	}
	
	private Double value = new Double();
}
