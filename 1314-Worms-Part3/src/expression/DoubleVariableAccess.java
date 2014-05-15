package expression;

import java.util.Map;


import type.T;
import worms.model.ImplementedPF;
import type.Double;


public class DoubleVariableAccess extends DoubleExpression{

	public DoubleVariableAccess(int line, int column, String name, ImplementedPF implementedPF) {
		super(line, column, name, implementedPF);
	}
	
	public DoubleVariableAccess(int line, int column){
		super(line, column);
	}

	@Override
	public Double getValue(){
		setWorm();
		if(getWorm() != null && getWorm().getProgram() != null){
			Map<String, T> globals = getWorm().getProgram().getGlobals();
			return (Double) globals.get(getName());
		}
		return new Double();
	}
}
