package statement;

import type.Entity;
import be.kuleuven.cs.som.annotate.*;

public abstract class S {
	
	@Raw
	public S(int line, int column){
		this.line = line;
		this.column = column;
	}
	
	
	
	@Basic
	public int getLine(){
		return this.line;
	}
	
	private final int line;
	
	
	
	@Basic
	public int getColumn(){
		return this.column;
	}
	
	private final int column;
	
	public abstract void execute(Entity entity);
}
