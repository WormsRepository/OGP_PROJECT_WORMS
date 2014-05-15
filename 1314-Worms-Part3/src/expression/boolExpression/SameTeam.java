package expression.boolExpression;

import worms.model.Worm;
import be.kuleuven.cs.som.annotate.Basic;
import expression.BoolExpression;
import expression.E;
import expression.EntityExpression;

public class SameTeam extends BoolExpression{

	public SameTeam(int line, int column, E e, Worm worm) {
		super(line, column);
		this.e = e;
		this.worm = worm;
		setValue(sameTeam());
	}
	
	
	@Basic
	public E getE(){
		return this.e;
	}
	
	private final E e;
	
	
	@Basic
	public Worm getWorm(){
		return this.worm;
	}
	
	private final Worm worm;
	
	
	private boolean sameTeam(){
		if(getE() instanceof EntityExpression){
			if(getE().getValue() instanceof Worm && getWorm() != null){
				Worm x = (Worm) getE().getValue();
				return x.getTeam() == getWorm().getTeam();
			}
		}
		//TODO stop program
		return false;
				
	}
}
