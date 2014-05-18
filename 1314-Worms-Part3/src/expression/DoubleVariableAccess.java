package expression;

import java.util.Map;

import type.T;
import worms.model.Worm;
import type.Double;


public class DoubleVariableAccess extends DoubleExpression{

	public DoubleVariableAccess(int line, int column, String name, Worm worm) {
		super(line, column, name, worm);
	}
	
	public DoubleVariableAccess(int line, int column){
		super(line, column);
	}

	@Override
	public Double getValue(){
		if(getWorm() != null && getWorm().getProgram() != null){
			Map<String, T> globals = getWorm().getProgram().getGlobals();
			return (Double) globals.get(getName());
		}
		return new Double();
	}
}
