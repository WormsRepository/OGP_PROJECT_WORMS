package worms.model;

import worms.gui.game.*;
import worms.model.programs.ProgramParser;

import java.util.Map;

import be.kuleuven.cs.som.annotate.Basic;
import statement.S;
import statement.Sequence;
import type.T;

public class Program {
	
	public Program(Map<String, T> globals, S statement, IActionHandler handler, ImplementedPF factory, Worm worm){
		this.setHandler(handler);
		this.setGlobals(globals);
		this.setStatement(statement);
		this.factory = factory;
		this.worm = worm;
	}
	
	
	
	public boolean hasAsWorm(Worm worm){
		return getWorm() == worm;
	}
	
	public boolean canHaveAsWorm(Worm worm){
		return worm != null;
	}
	
	@Basic
	public Worm getWorm(){
		return this.worm;
	}
	
	
	private final Worm worm;
	
	
	public Map<String, T> getGlobals(){
		return this.globals;
	}
	
	private void setGlobals(Map<String, T> globals){
		this.globals = globals;
	}
	
	private Map<String, T> globals;
	
	public S getStatement(){
		return this.statement;
	}
	
	private void setStatement(S statement){
		this.statement = statement;
	}
	
	private S statement = null;
	
	
	
	public boolean getIsExecuting(){
		return this.isExecuting;
	}
	
	public void setIsExecuting(boolean b){
		this.isExecuting = b;
	}
	
	private boolean isExecuting;
	//TODO: true or false?
	
	public void executeNext(){
		if(isExecuting == true)
			getNextStatement().execute(getWorm());
	}
	//TODO beginnen vanaf laatst uitgevoerde statement
	public S getNextStatement(){
		if(statement instanceof Sequence){
			if(nrStatement == ((Sequence)statement).getStatements().size() -1){
				nrStatement = 0;
				return ((Sequence)statement).getStatements().get(nrStatement);
			}
			else{
				nrStatement++;
				return ((Sequence)statement).getStatements().get(nrStatement -1);
			}
			
		}
		else {
			return null; //TODO dit wordt moeilijk :p als het geen sequence is toch het juiste returnen.
		}
		//TODO FIXEN
	}
	
	private int nrStatement;
	//TODO implementedPF hier initialiseren met actionHandler en worm
	
	@Basic
	public ImplementedPF getFactory(){
		return factory;
	}

	private final ImplementedPF factory;
	
	
	public IActionHandler getHandler(){
		return handler;
	}
	@Basic
	public void setHandler(IActionHandler handler){
		this.handler = handler;
	}
	private IActionHandler handler = null;
	

}
