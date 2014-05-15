package statement;

import type.Entity;
import worms.model.Worm;
import be.kuleuven.cs.som.annotate.*;
import expression.BoolExpression;
import expression.E;

public class IfThenElse extends S{
	
	public IfThenElse(int line, int column, E condition, S then, S otherwise){
		super(line, column);
		this.condition = condition;
		this.then = then;
		this.otherwise = otherwise;
	}
	
	
	
	@Basic
	public E getCondition(){
		return this.condition;
	}
	
	private final E condition;
	
	
	
	@Basic
	public S getThen(){
		return this.then;
	}
	
	private final S then;
	
	
	
	@Basic
	public S getOtherwise(){
		return this.otherwise;
	}
		
	private final S otherwise;
	

	
	@Override
	public void execute(Entity entity) {
		if(this.getCondition() instanceof BoolExpression){
			if( ((BoolExpression) this.getCondition()).getValue().getBoolean())
				getThen().execute(entity);
			else
				getOtherwise().execute(entity);
		}
		else{
			System.out.println("Class: IfThenElse: execution error");
			if(Worm.class.isInstance(entity)){
				Worm worm = (Worm) entity;
				if(worm.hasProgram())
					worm.getProgram().setIsExecuting(false);
				// TODO fix this
			}
		}
	}
	
	
}
