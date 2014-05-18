package expression;

import be.kuleuven.cs.som.annotate.Basic;
import worms.model.ImplementedPF;
import worms.model.Worm;

public abstract class VariableAccess extends E{

	public	VariableAccess(int line, int column, String name, ImplementedPF implementedPF) {
		super(line, column);
		this.name = name;
		this.implementedPF = implementedPF;
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
	private ImplementedPF getImplementedPF(){
		return this.implementedPF;
	}
	
	private ImplementedPF implementedPF = null;
	
	
	@Basic
	protected Worm getWorm(){
		return this.worm;
	}
	
	protected void setWorm(){
		worm = getImplementedPF().getWorm();
	}
	
	protected Worm worm = null;
}
