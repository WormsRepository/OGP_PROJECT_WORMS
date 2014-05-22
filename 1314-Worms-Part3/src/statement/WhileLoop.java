package statement;

import be.kuleuven.cs.som.annotate.*;
import type.Entity;
import worms.model.Statement;
import worms.model.Worm;
import expression.BoolExpression;
import expression.E;

public class WhileLoop extends S{
	
	public WhileLoop(int line, int column, E condition, S body){
		super(line, column);
		this.condition = condition;
		this.body = body;
	}
	
	
	@Basic
	public E getCondition(){
		return this.condition;
	}
	
	final E condition;
	
	
	@Basic
	public S getBody(){
		return this.body;
	}
	
	final S body;


	@Override
	public void execute(Entity entity){
		Statement.AMOUNT_OF_STATEMENTS_EXECUTED++;
		if(this.getCondition() instanceof BoolExpression){
			while(((BoolExpression) this.getCondition()).getValue().getBoolean()
					&& ((Worm)entity).getProgram().getIsExecuting()){
				getBody().execute(entity);
			}
		}
		else{
			System.out.println("Class: WhileLoop: execution error");
			if(Worm.class.isInstance(entity)){
				Worm worm = (Worm) entity;
				if(worm.hasProgram())
					worm.getProgram().setIsExecuting(false);
			}
		}
	}
}
