package expression;

import java.util.Map;

import type.Entity;
import type.T;
import worms.model.ImplementedPF;

public class EntityVariableAccess extends EntityExpression{

	public EntityVariableAccess(int line, int column, String name, ImplementedPF implementedPF) {
		super(line, column, name, implementedPF);
	}
	
	public EntityVariableAccess(int line, int column) {
		super(line, column);
	}

	@Override
	public Entity getValue() {
		setWorm();
		if(getWorm() != null && getWorm().getProgram() != null){
			Map<String, T> globals = getWorm().getProgram().getGlobals();
			return (Entity) globals.get(getName());
		}
		return new Entity();
	}

}
