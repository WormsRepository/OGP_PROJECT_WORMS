package expression;

import java.util.Map;

import type.T;
import type.Boolean;
import worms.model.Worm;

public class BoolVariableAccess extends BoolExpression{

	public BoolVariableAccess(int line, int column, String name, Worm worm) {
		super(line, column, name, worm);
	}
	
	public BoolVariableAccess(int line, int column) {
		super(line, column);
	}

	@Override
	public Boolean getValue() {
		if(getWorm() != null && getWorm().getProgram() != null){
			Map<String, T> globals = getWorm().getProgram().getGlobals();
			return (Boolean) globals.get(getName());
		}
		return new Boolean();
	}

}
