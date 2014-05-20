package worms.model;

import java.util.ArrayList;
import java.util.Map;

import expression.BoolExpression;
import be.kuleuven.cs.som.annotate.Basic;
import statement.*;
import type.T;

public class Program {
	
	public Program(Map<String, T> globals, S statement, Worm worm){
		this.setGlobals(globals);
		this.setStatement(statement);
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
	
	private boolean isExecuting = false;
	
	public void executeNext(){
		//TODO if 1000 statements executed: stop...
		//TODO handle incorrect operations in a total manner: stop the program
		setIsExecuting(true);
		if(getFirstSequenceStatements() == null)
			getStatement().execute(getWorm());
		setIsExecuting(true);
		nrStatement--;
		int size = getFirstSequenceStatements().size();
		boolean x = false;
		if(nrStatement%size == 0)
			x = true;
		while(getIsExecuting()){
			while((nrStatement%size != 0 || x) && getIsExecuting()){
				getFirstSequenceStatements().get(nrStatement%size).execute(getWorm());
				nrStatement++;
				x = false;
			}
			x = false;
			if(getStatement() instanceof WhileLoop &&
			((WhileLoop) getStatement()).getCondition() instanceof BoolExpression &&
			((BoolExpression) ((WhileLoop) getStatement()).getCondition()).getValue().getBoolean()){
				x = true;
			}
			else{
				if(getIsExecuting()){
					setIsExecuting(false);
					getWorm().getWorld().startNextTurn();
				}
			}
		}
	}
	
	private int nrStatement = 1;
	
	
	
	@Basic
	public ArrayList<S> getFirstSequenceStatements(){
		return this.firstSequenceStatements;
	}
	
	public void setFirstSequenceStatements(ArrayList<S> statements){
		this.firstSequenceStatements = statements;
	}
	
	private ArrayList<S> firstSequenceStatements = null;
}
