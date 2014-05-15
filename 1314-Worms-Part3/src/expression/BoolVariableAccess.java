package expression;

import java.util.Map;

import type.T;
import type.Boolean;
import worms.model.ImplementedPF;

public class BoolVariableAccess extends BoolExpression{

	public BoolVariableAccess(int line, int column, String name, ImplementedPF implementedPF) {
		super(line, column, name, implementedPF);
	}
	
	public BoolVariableAccess(int line, int column) {
		super(line, column);
	}

	@Override
	public Boolean getValue() {
		setWorm();
		if(getWorm() != null && getWorm().getProgram() != null){
			Map<String, T> globals = getWorm().getProgram().getGlobals();
			return (Boolean) globals.get(getName());
		}
		return new Boolean();
	}

}
