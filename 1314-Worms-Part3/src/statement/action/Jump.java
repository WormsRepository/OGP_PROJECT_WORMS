package statement.action;

import statement.Action;
import worms.gui.game.IActionHandler;
import worms.model.Worm;


public class Jump extends Action{

	public Jump(int line, int column, IActionHandler handler) {
		super(line, column, handler);
	}

	@Override
	protected void executeAction(Worm worm) {
		double x = worm.getX();
		double y = worm.getY();
		getActionHandler().jump(worm);
		if(worm.getX() == x && worm.getY() == y){
			worm.getProgram().setIsExecuting(false);
		}
	}
}
