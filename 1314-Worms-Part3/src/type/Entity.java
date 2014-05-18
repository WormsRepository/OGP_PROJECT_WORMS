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
	
	/**
	 * Return the x-coordinate of the position (in meter).
	 */
	@Basic @Raw
	public double getX() {
		return this.x;
	}

	
	/**
	 * Variable registering the x-coordinate of a position in meters.
	 */
	protected double x = 0;
	
	/**
	 * Return the y-coordinate of the position (in meter).
	 */
	@Basic @Raw
	public double getY() {
		return this.y;
	}
	
	/**
	 * Variable registering the y-coordinate of a position in meters.
	 */
	protected double y = 0;
	
	
	protected World world = null;
	
	
}
