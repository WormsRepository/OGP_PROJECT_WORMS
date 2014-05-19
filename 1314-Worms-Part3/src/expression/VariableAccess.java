package expression;

import be.kuleuven.cs.som.annotate.Basic;
import worms.model.Worm;

public interface VariableAccess{
	@Basic
	public String getName();
	
	@Basic
	public Worm getWorm();
}
