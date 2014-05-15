package type;

import be.kuleuven.cs.som.annotate.*;
import worms.model.World;

public class Entity extends T{
	
	/**
	 * Get the world to which this entity is attached.
	 */
	@Basic @Raw
	public World getWorld(){
		return this.world;
	}
	
	
	
	protected World world = null;
	
	
}
