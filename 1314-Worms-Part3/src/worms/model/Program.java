package worms.model;

import worms.gui.game.*;


import java.util.Map;

import be.kuleuven.cs.som.annotate.Basic;
import statement.S;
import type.T;

public class Program {
	
	public Program(Map<String, T> globals, S statement, IActionHandler handler, ImplementedPF factory){
		this.setHandler(handler);
		this.setGlobals(globals);
		this.setStatement(statement);
		this.factory = factory;
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
	
	protected void setWorm(Worm worm){
		if(! canHaveAsWorm(worm))
			throw new IllegalArgumentException();
		if(worm.getProgram() != null)
			throw new IllegalArgumentException();
		this.worm = worm;
		this.getFactory().setWorm(worm);
		worm.setProgram(this);
		//TODO opnieuw parsen?
	}
	
	private Worm worm = null;
	
	
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
		getNextStatement().execute(getWorm());
	}
	//TODO beginnen vanaf laatst uitgevoerde statement
	public S getNextStatement(){
		//TODO (Sequence)(statement).getStatements();
		//TODO nummer van statement zoeken adhv nrStatement.
		return null;
	}
	
	private int nrStatement = 0;
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
