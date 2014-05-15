package expression;

import type.T;
import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Raw;

public abstract class E {
	
	@Raw
	public E(int line, int column){
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
	
	public abstract T getValue();
}
