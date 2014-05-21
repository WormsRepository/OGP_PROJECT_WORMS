package worms.model;

import be.kuleuven.cs.som.annotate.Basic;
import statement.S;

public class Statement {

	public Statement(S statement, Program program){
		this.statement = statement;
		this.program = program;
	}
	
	@Basic
	public S getStatement(){
		return this.statement;
	}
	
	private final S statement;
	
	
	@Basic
	public double getX(){
		return this.x;
	}
	
	public void setX(double x){
		this.x = x;
	}
	
	private double x = -1;
	
	
	@Basic
	public Program getProgram(){
		return this.program;
	}
	
	private final Program program;
}
