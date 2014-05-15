package statement;

import java.util.Map;

import be.kuleuven.cs.som.annotate.*;
import expression.E;
import type.Entity;
import type.T;
import worms.model.Worm;

public class Assignment extends S{
	
	public Assignment(int line, int column, String variableName, E rhs){
		super(line, column);
		this.variableName = variableName;
		this.rhs = rhs;
	}
	
	
	
	@Basic
	public String getVariableName(){
		return this.variableName;
	}
	
	private final String variableName;
	
	
	
	@Basic
	public E getRhs(){
		return this.rhs;
	}
	
	private final E rhs;

	

	@Override
	public void execute(Entity entity) {
		Map<String, T> globals = ((Worm) entity).getProgram().getGlobals();
		globals.put(getVariableName(), getRhs().getValue());
	}
}
