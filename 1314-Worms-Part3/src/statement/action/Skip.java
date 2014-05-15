package statement.action;

import statement.Action;
import worms.gui.game.IActionHandler;
import worms.model.Worm;

public class Skip extends Action{

	public Skip(int line, int column, IActionHandler handler) {
		super(line, column, handler);
	}

	@Override
	protected void executeAction(Worm worm){}
}
