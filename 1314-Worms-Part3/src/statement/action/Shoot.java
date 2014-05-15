package statement.action;

import be.kuleuven.cs.som.annotate.Basic;
import expression.DoubleExpression;
import expression.E;
import statement.Action;
import worms.gui.game.IActionHandler;
import worms.model.Worm;

public class Shoot extends Action{



	public Shoot(int line, int column, IActionHandler handler, E yield) {
		super(line, column, handler);
		this.yield = yield;
	}
	

	@Basic
	public E getYield(){
		return this.yield;
	}
	
	private final E yield;
	
	
	@Override
	protected void executeAction(Worm worm) {
		getActionHandler().fire(worm, (int)((DoubleExpression) this.getYield()).getValue().getDouble());
	}
}
