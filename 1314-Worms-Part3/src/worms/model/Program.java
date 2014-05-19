package worms.model;

import worms.gui.game.*;
import worms.model.programs.ProgramParser;

import java.util.ArrayList;
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
	
	private boolean isExecuting = false;;
	//TODO: true or false?
	
	public void executeNext(){
		setIsExecuting(true);
		if(getFirstSequenceStatements() == null)
			getStatement().execute(getWorm());
		nrStatement--;
		int size = getFirstSequenceStatements().size();
		while(getIsExecuting()){
			getFirstSequenceStatements().get(nrStatement%size).execute(getWorm());
				nrStatement++;
		}
	}
	
	private int nrStatement = 1;
	
	
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
	
	@Basic
	public ArrayList<S> getFirstSequenceStatements(){
		return this.firstSequenceStatements;
	}
	
	public void setFirstSequenceStatements(ArrayList<S> statements){
		this.firstSequenceStatements = statements;
		this.statementsSet = true;
	}
	
	@Basic
	public boolean getStatementsSet(){
		return this.statementsSet;
	}
	
	private ArrayList<S> firstSequenceStatements = null;
	
	private boolean statementsSet = false;
}
