package worms.model;

import expression.BoolExpression;
import be.kuleuven.cs.som.annotate.Basic;
import statement.*;

/**
 * @version 1.0
 * @author 	Laurens Loots, Pieter Vos
 */
public class Statement {

	public Statement(S statement, Program program, int nrOfCurrentStatement){
		this.statement = statement;
		this.program = program;
		this.nrOfCurrentStatement = nrOfCurrentStatement;
	}
	
	
	@Basic
	public S getStatement(){
		return this.statement;
	}
	
	private final S statement;
	
	
	@Basic
	public Program getProgram(){
		return this.program;
	}
	
	private final Program program;

	
	@Basic
	public int getNrOfCurrentStatement(){
		return this.nrOfCurrentStatement;
	}
	
	private void executeNextStatement(){
		if(AMOUNT_OF_STATEMENTS_EXECUTED >= 1000){
			this.getProgram().setIsExecuting(false);
			System.out.println("1000 statements executed");
			return;
		}
		if(getNrOfCurrentStatement() + 1 < this.getProgram().getStatements().size()){
			this.getProgram().getStatements().get(getNrOfCurrentStatement() + 1).execute();
		}
		else{
			this.getProgram().setLastStatement(null);
		}
	}
	
	private final int nrOfCurrentStatement;
	
	
	@Basic
	public int getX(){
		return this.x;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	private void executeStatementX(){
		if(AMOUNT_OF_STATEMENTS_EXECUTED >= 1000){
			this.getProgram().setIsExecuting(false);
			System.out.println("1000 statements executed");
			return;
		}
		if(getX() < this.getProgram().getStatements().size()){
			this.getProgram().getStatements().get(getX()).execute();
		}
		else{
			this.getProgram().setLastStatement(null);
		}
	}
	
	private int x = -1;
	
	
	public void execute(){
		this.getProgram().setLastStatement(this);
		if(getStatement() instanceof Action || getStatement() instanceof Assignment || 
				getStatement() instanceof Print || getStatement() instanceof ForEachLoop){
			getStatement().execute(getProgram().getWorm());
			if(this.getProgram().getIsExecuting())
				this.executeStatementX();
		}
		else if(statement instanceof IfThenElse){
			AMOUNT_OF_STATEMENTS_EXECUTED++;
			IfThenElse ifThenElse = (IfThenElse) statement;
			if(((BoolExpression) ifThenElse.getCondition()).getValue().getBoolean())
				this.executeNextStatement();
			else
				this.executeStatementX();
		}
		else if(statement instanceof WhileLoop){
			AMOUNT_OF_STATEMENTS_EXECUTED++;
			WhileLoop whileLoop = (WhileLoop) statement;
			if(((BoolExpression) whileLoop.getCondition()).getValue().getBoolean()){
				this.executeNextStatement();
			}
			else{
				this.executeStatementX();
			}
		}
		else{
			AMOUNT_OF_STATEMENTS_EXECUTED++;
			this.executeStatementX();
		}
	}
	
	public static int AMOUNT_OF_STATEMENTS_EXECUTED = 0;
}
