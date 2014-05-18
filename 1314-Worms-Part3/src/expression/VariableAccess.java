package expression;

import be.kuleuven.cs.som.annotate.Basic;
import worms.model.Worm;

public abstract class VariableAccess extends E{

	public	VariableAccess(int line, int column, String name, Worm worm) {
		super(line, column);
		this.name = name;
		this.setWorm(worm);
	}
	
	public VariableAccess(int line, int column){
		super(line, column);
	}
	
	@Basic
	protected String getName(){
		return this.name;
	}
	
	private String name = null;
	
	
	@Basic
	protected Worm getWorm(){
		return this.worm;
	}
	
	protected void setWorm(Worm worm){
		this.worm = worm;
	}
	
	private Worm worm = null;
}
