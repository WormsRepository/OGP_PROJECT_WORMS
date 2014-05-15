package statement;


import java.util.ArrayList;
import java.util.List;

import type.Entity;

import be.kuleuven.cs.som.annotate.Basic;

public class Sequence extends S{
	
	public Sequence(int line, int column, List<S> statements){
		super(line, column);
		this.statements.addAll(statements);
	}
	
	
	
	@Basic
	public List<S> getStatements(){
		return this.statements;
	}
	
	private final ArrayList<S> statements = new ArrayList<S>();;
	
	
	
	@Override
	public void execute(Entity entity) {
		if(entity != null)
			for(S statement: getStatements()){
				statement.execute(entity);
			}
	}
}
