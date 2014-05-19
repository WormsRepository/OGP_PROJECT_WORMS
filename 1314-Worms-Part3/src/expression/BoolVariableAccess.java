package expression;

import java.util.Map;

import type.T;
import type.Boolean;
import worms.model.Worm;

public class BoolVariableAccess extends BoolExpression implements VariableAccess{

	public BoolVariableAccess(int line, int column, String name, Worm worm) {
		super(line, column);
		this.name = name;
		this.worm = worm;
	}
	

	@Override
	public Boolean getValue() {
		if(getWorm() != null && getWorm().getProgram() != null){
			Map<String, T> globals = getWorm().getProgram().getGlobals();
			return (Boolean) globals.get(getName());
		}
		return new Boolean();
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
