package expression.boolExpression;

import worms.model.Worm;
import be.kuleuven.cs.som.annotate.Basic;
import expression.BoolExpression;
import expression.E;
import expression.EntityExpression;
import type.Boolean;

public class SameTeam extends BoolExpression{

	public SameTeam(int line, int column, E e, Worm worm) {
		super(line, column, e);
		this.worm = worm;
	}
	
	
	@Basic
	public Worm getWorm(){
		return this.worm;
	}

	private final Worm worm;
	
	
	@Override
	public Boolean getValue(){
		setValue(sameTeam());
		return super.getValue();
	}
	
	
	private boolean sameTeam(){
		if(getE1() instanceof EntityExpression){
			if(getE1().getValue() instanceof Worm){
				Worm x = (Worm) getE1().getValue();
				if(x.getTeam() == null && getWorm().getTeam() == null)
					return false;
				return x.getTeam() == getWorm().getTeam();
			}
		}
		System.out.println("error in sameteam");
		return false;
				
	}
}
