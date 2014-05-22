package worms.model;


import static org.junit.Assert.*;

import java.util.Random;

import org.junit.*;
public class WormPositionTest {
	
	/**
	 * Variable referencing a worm.
	 */
	private static Worm worm1;
	
	private static Random random;

	private static World world;

	/**
	 * Set up a mutable test fixture.
	 * 
	 * @post The variable worm1 references a new worm with radius 0.5, x and y coordinates 2, and direction 1.
	 */
	@Before
	public void setUpMutableFixture(){
		worm1 = new Worm(2,2,1,0.5,"Pieter");
	}

	/**
	 * Sets up an immutable test fixture.
	 * 
	 * @post Create a world based on the passable map.
	 */
	@BeforeClass
	public static void setUpImmutableFixture(){
		boolean[][] passableMap = {{false,false,false,false,false,false},
				   {false,true,true,true,true,false},
				   {false,true,true,true,true,false},
				   {false,true,true,true,true,false},
				   {false,true,true,true,true,false},
				   {false,false,false,false,false,false}};
		world = new World(6,6,passableMap,random);	
	}
	
	@Test
	public void canFall_LegalCase(){
		world.addAsWorm(worm1);
		assertTrue(worm1.canFall());
	}
	
	@Test
	public void canFall_LegalCase2(){
		worm1 = new Worm(5,1, 0.25, 0.25, "Laurens");
		world.addAsWorm(worm1);
		assertTrue(! worm1.canFall());
		
	}
	
	@Test
	public void canMove_LegalCase(){
		worm1 = new Worm(5,5,0, 0.5, "Pieter");
		world.addAsWorm(worm1);
		assertTrue(! worm1.canMove());
	}
	
	@Test
	public void canMove_LegalCase2(){
		worm1 = new Worm(3,3,0,0.5, "Loots");
		world.addAsWorm(worm1);
		assertTrue(worm1.canMove());
	}
	
	@Test(expected = IllegalPositionException.class)
	public void Fall_LegalCase_CanNotFall(){
		worm1 = new Worm(5,1, 0.25, 0.25, "Laurens");
		world.addAsWorm(worm1);
		assertTrue(!worm1.canFall());
		worm1.fall();
	}
	
	@Test
	public void Fall_LegalCase_CanFall(){
		world.addAsWorm(worm1);
		assertTrue(worm1.canFall());
		worm1.fall();
		assertTrue(worm1.getX() == 2);
		assertTrue(worm1.getY() < 2);
	}
	
	@Test
	public void fall_LegalCase_FallsOnFood(){
		world.addAsWorm(worm1);
		Food food1 = new Food(2,1);
		world.addAsFood(food1);
		worm1.fall();
		assertTrue(! world.getFood().contains(food1));
	}
	
	@Test
	public void fall_LegalCase_FallsOffTheWorld(){
		boolean[][] passableMap = {{false,false,false,false,false,false},
				   {false,true,true,true,true,false},
				   {false,true,true,true,true,false},
				   {false,true,true,true,true,false},
				   {false,true,true,true,true,false},
				   {false,true,true,true,true,false}};
		world = new World(6,6,passableMap,random);
		world.addAsWorm(worm1);
		worm1.fall();
		assertTrue(! worm1.isAlive());
	}
	
	@Test
	public void getJumpStep_LegalCase(){
		int t = 1;
		double[] a = worm1.getJumpStep(t);
		assertTrue(a[0] > 5.98 && a[0] < 6);
		assertTrue(a[1] > 3.32 && a[1] < 3.33);
	}
	
	@Test(expected = IllegalDirectionException.class)
	public void getJumpTime_IllegalCase(){
		
		worm1 = new Worm(2,2,Math.PI /2.0, 0.25, "Pieter");
		world.addAsWorm(worm1);
		worm1.fall();
		worm1.getJumpTime();
	}
	
	@Test
	public void getJumpTime_LegalCase(){
		
		worm1 = new Worm(2,2,1, 0.25, "Pieter");
		world.addAsWorm(worm1);
		worm1.fall();
		assertTrue(worm1.getJumpTime() < 0.7 && worm1.getJumpTime()> 0.6 );
		
	}
	
	@Test(expected = IllegalDirectionException.class)
	public void getJumpTime_IllegalCase2(){
		worm1 = new Worm(0,0, 1,1,  "Pieter");
		world.addAsWorm(worm1);
		worm1.getJumpTime();
	}
	
	@Test
	public void jump_LegalCase(){
		world.addAsWorm(worm1);
		worm1.jump();
		assertTrue(worm1.getX() >4.4 && worm1.getX() < 4.9);
		assertTrue(worm1.getY() > 3.8 && worm1.getY() < 4);
	}
	
	@Test(expected = IllegalDirectionException.class)
	public void jump_IllegalCase(){
		worm1 = new Worm(3,3, -Math.PI/2, 0.25, "Pieter");
		world.addAsWorm(worm1);
		worm1.fall();
		worm1.jump();
	}
	
	@Test(expected = IllegalDirectionException.class)
	public void move_IllegalCase(){
		worm1 = new Worm(3,3, -Math.PI/2, 0.25, "Pieter");
		world.addAsWorm(worm1);
		worm1.fall();
		worm1.move();
	}
	
	@Test
	public void move_LegalCase(){
		world.addAsWorm(worm1);
		worm1.fall();
		worm1.move();
		assertTrue(worm1.getX() > 2.1 && worm1.getY() < 2.4);
		assertTrue(worm1.getY() > 1.8 && worm1.getY() < 2.1);
		
	}

}
