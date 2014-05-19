package expression;

import java.util.Map;

import type.Entity;
import type.T;
import worms.model.Worm;

public class EntityVariableAccess extends EntityExpression implements VariableAccess{

	public EntityVariableAccess(int line, int column, String name, Worm worm) {
		super(line, column);
		this.name = name;
		this.worm = worm;
	}

	@Override
	public Entity getValue() {
		if(getWorm() != null && getWorm().getProgram() != null){
			Map<String, T> globals = getWorm().getProgram().getGlobals();
			return (Entity) globals.get(getName());
		}
		return new Entity();
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
