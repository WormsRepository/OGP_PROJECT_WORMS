package expression;

import java.util.Map;

import type.T;
import worms.model.Worm;
import type.Double;


public class DoubleVariableAccess extends DoubleExpression implements VariableAccess{

	public DoubleVariableAccess(int line, int column, String name, Worm worm) {
		super(line, column);
		this.name = name;
		this.worm = worm;
	}
	

	@Override
	public Double getValue(){
		if(getWorm() != null && getWorm().getProgram() != null){
			Map<String, T> globals = getWorm().getProgram().getGlobals();
			return (Double) globals.get(getName());
		}
		return new Double();
	}

	
	@Override
	public String getName() {
		return this.name;
	}
	
	private final String name;

	
	@Override
	public Worm getWorm() {
		return this.worm;
	}
	
	private final Worm worm;
}
