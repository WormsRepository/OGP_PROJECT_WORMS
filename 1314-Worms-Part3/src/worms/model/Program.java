package worms.model;

import java.util.ArrayList;
import java.util.Map;

import be.kuleuven.cs.som.annotate.Basic;
import statement.*;
import type.T;

/**
 * @version 1.0
 * @author 	Laurens Loots, Pieter Vos
 */
public class Program {
	
	public Program(Map<String, T> globals, S statement, Worm worm){
		this.setGlobals(globals);
		this.setStatement(statement);
		this.worm = worm;
		setStatements(getStatement());
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
		Statement.AMOUNT_OF_STATEMENTS_EXECUTED = 0;
		setIsExecuting(true);
		if(getLastStatement() == null)
			getStatements().get(0).execute();
		else
			getLastStatement().execute();
		this.getWorm().getWorld().startNextTurn();
	}
	
	@Basic
	public Statement getLastStatement(){
		return this.lastStatement;
	}
	
	public void setLastStatement(Statement statement){
		this.lastStatement = statement;
	}
	
	private Statement lastStatement = null;
	
	@Basic
	public ArrayList<Statement> getStatements(){
		return this.statements;
	}
	
	//only for graphic purpose.
	public void printStatements(){
		for(Statement x: statements){
			System.out.println(x.getNrOfCurrentStatement() + ": " + x.getStatement().getClass() + "   " + x.getX());
		}
	}
	
	private void setStatements(S body){
		if(body == null)
			return;
		Statement s = new Statement(body, this, getCounter());
		if(body instanceof Action || body instanceof Assignment || 
				body instanceof Print || body instanceof ForEachLoop){
			increaseCounter();
			statements.add(s);
			s.setX(getCounter());
		}
		else if(body instanceof IfThenElse){
			increaseCounter();
			statements.add(s);
			IfThenElse x = (IfThenElse) body;
			setStatements(x.getThen());
			s.setX(getCounter());
			
			int a = getCounter();
			setStatements(x.getOtherwise());
			for(Statement b: statements){
				if(b.getX() == a && 
						s.getNrOfCurrentStatement() != b.getNrOfCurrentStatement()){
					b.setX(getCounter());
				}
			}
		}
		else if(body instanceof Sequence){
			increaseCounter();
			statements.add(s);
			Sequence x = (Sequence) body;
			if(x.getStatements().size() > 0){
				s.setX(getCounter());
				for(S statement: x.getStatements()){
					setStatements(statement);	
				}
			}
			else{
				decreaseCounter();
				statements.remove(s);
			}
		}
		else if(body instanceof WhileLoop){
			increaseCounter();
			statements.add(s);
			WhileLoop x = (WhileLoop) body;
			int a = getCounter() - 1;
			setStatements(x.getBody());
			if(s.getX() == -1)
				s.setX(getCounter());
			int c = 0;
			for(Statement b: statements){
				if(b.getX() == getCounter() && c!= a)
					b.setX(a);
				c++;
			}
		}
	}
	
	private int getCounter(){
		return this.counter;
	}
	
	private void increaseCounter(){
		this.counter = this.counter + 1;
	}
	
	private void decreaseCounter(){
		this.counter = this.counter - 1;
	}
	
	private int counter = 0;
	
	private ArrayList<Statement> statements = new ArrayList<Statement>();
	
	
	//The boolean b indicates whether or not you are in a forEachLoop.
	public boolean isWellFormedBody(S body, boolean b){
		if(body instanceof Action && b){
			return false;
		}
		else if(body instanceof ForEachLoop){
			ForEachLoop x = (ForEachLoop) body;
			if(!isWellFormedBody(x.getBody(), true))
				return false;
		}
		else if(body instanceof IfThenElse){
			IfThenElse x = (IfThenElse) body;
			if(!isWellFormedBody(x.getThen(),b) || 
					!isWellFormedBody(x.getOtherwise(),b))
				return false;
		}
		else if(body instanceof Sequence){
			Sequence x = (Sequence) body;
			for(S statement: x.getStatements()){
				if(!isWellFormedBody(statement, b))
					return false;
			}
		}
		else if(body instanceof WhileLoop){
			WhileLoop x = (WhileLoop) body;
			if(!isWellFormedBody(x.getBody(), b))
				return false;
		}
		return true;
	}
	
	public boolean isWellFormed(){
		if(!isWellFormedBody(this.getStatement(), false))
				return false;
		return true;
	}
}
