package statement;


import be.kuleuven.cs.som.annotate.Basic;
import type.Entity;
import worms.gui.game.IActionHandler;
import worms.model.Statement;
import worms.model.Worm;

public abstract class Action extends S{
	
	public Action(int line, int column, IActionHandler handler) {
		super(line, column);
		this.actionHandler = handler;
	}

	public Worm getWorm(Entity entity){
		if(entity instanceof Worm)
			return (Worm) entity;
		return null;
	}
	
	
	@Basic
	public IActionHandler getActionHandler(){
		return this.actionHandler;
	}
	
	private final IActionHandler actionHandler;
	
	
	protected abstract void executeAction(Worm worm);
	
	@Override
	public void execute(Entity entity){
		Statement.AMOUNT_OF_STATEMENTS_EXECUTED++;
		Worm worm = getWorm(entity);
		if(worm != null){
			this.executeAction(worm);
		}
	}
}
