package statement;


import java.util.ArrayList;
import java.util.List;

import type.Entity;
import worms.model.Program;
import worms.model.Worm;
import be.kuleuven.cs.som.annotate.Basic;

public class Sequence extends S{
	
	public Sequence(int line, int column, List<S> statements){
		super(line, column);
		this.statements.addAll(statements);
	}
	
	
	
	@Basic
	public ArrayList<S> getStatements(){
		return this.statements;
	}
	
	private final ArrayList<S> statements = new ArrayList<S>();
	
	
	
	@Override
	public void execute(Entity entity) {
		if(entity != null){
			if(((Worm) entity).getProgram() != null){
				Program program = ((Worm) entity).getProgram();
				if(program.getIsExecuting() && program.getFirstSequenceStatements() == null){
					System.out.println("Sequence of statements is set");
					program.setFirstSequenceStatements(getStatements());
					program.setIsExecuting(false);
					return;
				}
			}
			for(S statement: getStatements())
				statement.execute(entity);
		}
	}
}
