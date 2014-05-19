package statement;

import java.util.Map;

import be.kuleuven.cs.som.annotate.*;
import expression.E;
import type.Entity;
import type.T;
import worms.model.ImplementedPF;
import worms.model.Worm;

public class Assignment extends S{
	
	public Assignment(int line, int column, String variableName, E rhs, Worm worm){
		super(line, column);
		this.variableName = variableName;
		this.rhs = rhs;
		this.worm = worm;
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

	
	@Basic
	protected Worm getWorm(){
		return this.worm;
	}
	
	private final Worm worm;
	
	

	@Override
	public void execute(Entity entity) {
		Map<String, T> globals = getWorm().getProgram().getGlobals();
		globals.put(getVariableName(), getRhs().getValue());
	}
}
