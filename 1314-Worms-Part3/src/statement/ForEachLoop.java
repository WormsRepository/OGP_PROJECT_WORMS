package statement;

import be.kuleuven.cs.som.annotate.*;
import type.Entity;
import worms.model.Food;
import worms.model.Program;
import worms.model.Statement;
import worms.model.Worm;
import worms.model.programs.ProgramFactory.ForeachType;


public class ForEachLoop extends S{
	
	public ForEachLoop(int line, int column, ForeachType type, String variableName, S body){
		super(line, column);
		this.type = type;
		this.variableName = variableName;
		this.body = body;
	}
	
	
	
	@Basic
	public ForeachType getType(){
		return this.type;
	}
	
	private final ForeachType type;
	
	
	
	@Basic
	public String getVariableName(){
		return this.variableName;
	}
	
	private final String variableName;
	
	
	
	@Basic
	public S getBody(){
		return this.body;
	}
	
	private final S body;
	
	

	@Override
	public void execute(Entity entity){
		Statement.AMOUNT_OF_STATEMENTS_EXECUTED++;
		Program program = ((Worm) entity).getProgram();
		switch(this.getType()){
		case WORM:	for(Worm worm: entity.getWorld().getWorms()){
						program.getGlobals().put(getVariableName(), worm);
						this.getBody().execute((Worm) program.getGlobals().get(getVariableName()));
					}
		break;
		case FOOD: 	for(Food food: entity.getWorld().getFood()){
						program.getGlobals().put(getVariableName(), food);
						this.getBody().execute((Food) program.getGlobals().get(getVariableName()));
					}
		break;
		case ANY: 	for(Entity tempEntity: entity.getWorld().getAny()){
						program.getGlobals().put(getVariableName(), tempEntity);
						this.getBody().execute((Entity) program.getGlobals().get(getVariableName()));
					}
		break;
		}
	}
}
