package statement;

import java.util.Map;

import be.kuleuven.cs.som.annotate.*;
import expression.*;
import type.*;
import type.Boolean;
import type.Double;
import worms.model.Statement;
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
	public void execute(Entity entity){
		Statement.AMOUNT_OF_STATEMENTS_EXECUTED++;
		Map<String, T> globals = getWorm().getProgram().getGlobals();
		if(getRhs() instanceof DoubleExpression){
			Double x = new Double(((DoubleExpression) getRhs()).getValue().getDouble());
			globals.put(getVariableName(), x);
		}
		else if(getRhs() instanceof BoolExpression){
			Boolean x = new Boolean(((BoolExpression) getRhs()).getValue().getBoolean());
			globals.put(getVariableName(), x);
		}
		else
			globals.put(getVariableName(), getRhs().getValue());
	}
}
