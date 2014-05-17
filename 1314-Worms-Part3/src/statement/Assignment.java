package statement;

import java.util.Map;

import be.kuleuven.cs.som.annotate.*;
import expression.E;
import type.Entity;
import type.T;
import worms.model.ImplementedPF;
import worms.model.Worm;

public class Assignment extends S{
	
	public Assignment(int line, int column, String variableName, E rhs, ImplementedPF implementedPF){
		super(line, column);
		this.variableName = variableName;
		this.rhs = rhs;
		this.implementedPF = implementedPF;
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
	private ImplementedPF getImplementedPF(){
		return this.implementedPF;
	}
	
	private final ImplementedPF implementedPF;
	
	
	@Basic
	protected Worm getWorm(){
		return this.worm;
	}
	
	protected void setWorm(){
		worm = getImplementedPF().getWorm();
	}
	
	private Worm worm = null;
	
	

	@Override
	public void execute(Entity entity) {
		setWorm();
		Map<String, T> globals = getWorm().getProgram().getGlobals();
		globals.put(getVariableName(), getRhs().getValue());
	}
}
