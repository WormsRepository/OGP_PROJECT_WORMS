package worms.model;


import static org.junit.Assert.*;

import java.util.Random;

import org.junit.*;

/**
 * A class collecting tests for the class worm.
 * 
 * @version 1.0
 * @author Pieter en Laurens
 */

public class WormTest {

	/**
	 * Variable referencing a worm with direction 2.
	 */
	private static Worm wormDirection2;
	
	/**
	 * Variable referencing a worm with direction 0.
	 */
	private static Worm wormDirection0;
	
	private static Random random;

	private static World world;
	
	private static Team team;

	// X X X X
	// . . . .
	// . . . .
	// X X X X
	private static boolean[][] passableMap = new boolean[][] {
			{ false, false, false, false }, { true, true, true, true },
			{ true, true, true, true }, { false, false, false, false } };

	/**
	 * Set up a mutable test fixture.
	 * 
	 * @post The variable wormDirection2 references a new worm with radius 0.25, x and y coordinates 0, and direction 2.
	 * @post The variable wormDirection0 references a new worm with radius 0.25, x and y coordinates 0, and direction 0.
	 */
	@Before
	public void setUpMutableFixture(){
		wormDirection2 = new Worm(0.0 , 0.0 , 2 , 0.25 , "Pieter");
		wormDirection0 = new Worm(2.0 , 2.0 , 0 , 0.25 , "Laurens");
		team = new Team("Pieter");
		team.addAsTeamWorm(wormDirection2);
	}

	/**
	 * Sets up an immutable test fixture.
	 * 
	 * @post Create a worm with x position 0, y position 0, direction pi/2, radius 1 and name Pieter.
	 */
	@BeforeClass
	public static void setUpImmutableFixture(){
		world = new World(4.0, 4.0, passableMap, random);
	}

	@Test
	public void constructor_LegalCase()
		throws Exception	{
		Worm myWorm = new Worm(0.0 , 0.0 , Math.PI/2 , 0.30 , "Pieter");
		assertTrue(myWorm.getX() == 0);
		assertTrue(myWorm.getY() == 0);
		assertTrue(myWorm.getDirection() == Math.PI/2);
		assertTrue(myWorm.getRadius() == 0.30);
		assertTrue(myWorm.getCurrentActionPoints() == (int)Math.round(myWorm.getMass()));
		assertTrue(myWorm.getCurrentHitPoints() == (int)Math.round(myWorm.getMass()));
		assertEquals("Pieter" , myWorm.getName());	
	}

	@Test(expected = IllegalRadiusException.class)
	public void constructor_InvalidRadius()
		throws Exception{
		Worm myWorm = new Worm(0.0 , 0.0 , Math.PI/2 , 0.30 , "Pieter");
		if(! myWorm.canHaveAsRadius(0.20))
			new Worm(0.0 , 0.0 , Math.PI/2 , 0.20 , "Pieter");
		if(! myWorm.canHaveAsRadius(Double.MIN_VALUE))
			new Worm(0.0 , 0.0 , Math.PI/2 , Double.MIN_VALUE , "Pieter");
		else
			throw new IllegalRadiusException(0, null);

	}

	@Test(expected = IllegalNameException.class)
	public void constructor_InvalidName()
		throws Exception{
		Worm myWorm = new Worm(0.0 , 0.0 , Math.PI/2 , 0.30 , "Pieter");
		if(! myWorm.canHaveAsName("A"))
			new Worm(0.0 , 0.0 , Math.PI/2 , 0.30 , "A");
		if(! myWorm.canHaveAsName("abc"))
			new Worm(0.0 , 0.0 , Math.PI/2 , 0.30 , "abc");
		if(! myWorm.canHaveAsName("Pieter(vos)"))
			new Worm(0.0 , 0.0 , Math.PI/2 , 0.30 , "Pieter(vos)");
		else
			throw new IllegalNameException(" ",null);

	}


	@Test
	public void setRadius_legalCase()
		throws Exception	{
		wormDirection2.setRadius(0.5);
		assertTrue(wormDirection2.getRadius() == 0.5);
	}

	@Test(expected = IllegalRadiusException.class)
	public void setRadius_IllegalRadius()
		throws Exception	{
		wormDirection2.setRadius(wormDirection2.getMinimalRadius() - 0.02);
	}

	@Test
	public void canHaveAsRadius_LegalCase()
		throws Exception	{
		assertTrue(wormDirection2.canHaveAsRadius(wormDirection2.getMinimalRadius() + 0.02));
	}

	@Test
	public void canHaveAsRadius_IllegalCase()
		throws Exception	{
		assertFalse(wormDirection2.canHaveAsRadius(-0.25));
	}

	@Test
	public void setMinimalRadius_LegalCase()
		throws Exception	{
		wormDirection2.setMinimalRadius(0.2);
		assertTrue(wormDirection2.getMinimalRadius() == 0.2);
	}

	@Test(expected = IllegalRadiusException.class)
	public void setMinimalRadius_NegativeRadius()
		throws Exception	{
		wormDirection2.setMinimalRadius(-0.2);
	}

	@Test
	public void isValidDirection_legalCase()
		throws Exception	{
		assertTrue(wormDirection2.isValidDirection(1));
	}

	@Test
	public void IsValidDirection_illegalCase()
		throws Exception	{
		assertFalse(wormDirection2.isValidDirection(10));
	}

	@Test
	public void canTurn_legalCase()
	{
		assertTrue(wormDirection2.canTurn(1));
	}

	@Test
	public void canTurn_IllegalCase()
	{
		assertFalse(wormDirection2.canTurn(Integer.MAX_VALUE));
	}

	@Test
	public void turn_LegalCase()
	{
		int oldActionPoints = (int) wormDirection2.getCurrentActionPoints();
		wormDirection2.turn(1.0);
		assertTrue(wormDirection2.getDirection() == 3.0);
		assertTrue(wormDirection2.getCurrentActionPoints() == oldActionPoints - (int)(Math.ceil(Math.abs(1) / (2*Math.PI) * 60)));
	}

	@Test
	public void setName_LegalCase()
		throws IllegalNameException
	{
		wormDirection2.setName("Pieter Vos");
		assertTrue(wormDirection2.getName().equals("Pieter Vos"));
	}

	@Test( expected = IllegalNameException.class)
	public void setName_IllegalCase()
		throws IllegalNameException
	{
		wormDirection2.setName("Pieter(Vos)");
		wormDirection2.setName("Laurens'\" LoOtS");
	}
	
	@Test
	public void selectNextWeapon(){
		Worm worm = new Worm(1, 2, Math.PI/2, 1, "Test");
		assertTrue(worm.getWeapon().getCurrentWeapon() == null);
		worm.getWeapon().selectNextWeapon();
		assertTrue(worm.getWeapon().getCurrentWeapon() == "Bazooka");
		worm.getWeapon().selectNextWeapon();
		assertTrue(worm.getWeapon().getCurrentWeapon() == "Rifle");
		worm.getWeapon().selectNextWeapon();
		assertTrue(worm.getWeapon().getCurrentWeapon() == null);
	}
	
	@Test
	public void reduceCurrentActionPoints(){
		Worm worm = new Worm(1, 2, Math.PI/2, 1, "Test");
		int actionPoints = worm.getCurrentActionPoints();
		worm.reduceCurrentActionPoints(11);
		assertTrue(worm.getCurrentActionPoints() == actionPoints - 11);
	}
	
	@Test
	public void reduceCurrentHitPoints(){
		Worm worm = new Worm(1, 2, Math.PI/2, 1, "Test");
		int hitPoints = worm.getCurrentHitPoints();
		worm.reduceCurrentHitPoints(10);
		assertTrue(worm.getCurrentHitPoints() == hitPoints - 10);
	}
	
	@Test
	public void wormDeath_legalCase(){
		world.addAsWorm(wormDirection0);
		assertTrue(wormDirection0.isAlive() == true);
		wormDirection0.wormDeath();
		assertTrue(wormDirection0.isAlive() == false);
	}
	
	@Test
	public void canHaveAsWorld_legalCase(){
		assertTrue(wormDirection0.canHaveAsWorld(world));
	}
	
	@Test
	public void canHaveAsWorld_legalCase_NullWorld(){
		World world = null;
		assertTrue(wormDirection0.canHaveAsWorld(world));
	}
	
	@Test
	public void setWorld_LegalCase(){
		wormDirection0.setWorld(world);
		assertTrue(wormDirection0.getWorld() == world);
	}
	
	@Test
	public void growInRadius_legalCase(){
		double oldRadius = wormDirection0.getRadius();
		wormDirection0.growInRadius();
		assertTrue(wormDirection0.getRadius() == oldRadius*1.1);
	}
	
	@Test
	public void canHaveAsRadius_legalCase(){
		wormDirection0.setWorld(null);
		assertTrue(wormDirection0.canHaveAsRadius(0.30));
	}
	
	@Test
	public void canHaveAsRadius_IllegalCase_SmallRadius(){
		wormDirection0.setWorld(null);
		assertTrue(!wormDirection0.canHaveAsRadius(0.10));
	}
	
	@Test
	public void canHaveAsRadius_IllegalCase_OutOfWorldBounds(){
		wormDirection0.setWorld(world);
		System.out.println(wormDirection0.getWorld().getWidth());
		wormDirection0.setX(1);
		wormDirection0.setY(1);
		assertTrue(!wormDirection0.canHaveAsRadius(2));
	}
	
	@Test
	public void setMinimalRadius_legalCase(){
		wormDirection0.setMinimalRadius(0.3);
		assertTrue(wormDirection0.getMinimalRadius() == 0.3);
	}
	
	@Test(expected = IllegalRadiusException.class)
	public void setMinimalRadius_IllegalCase_NegativeRadius(){
		wormDirection0.setMinimalRadius(-0.3);
	}
	
	@Test
	public void setDirection_LegalCase(){
		wormDirection0.setDirection(0.2);
		assertTrue(wormDirection0.getDirection() == 0.2);
	}
	
	@Test
	public void canHaveAsName_LegalCase(){
		assertTrue(wormDirection0.canHaveAsName("Pieter"));
		assertTrue(wormDirection0.canHaveAsName("Charles O'Donnel"));
	}
	
	@Test
	public void canHaveAsName_IllegalCases(){
		assertTrue(!wormDirection0.canHaveAsName("P"));
		assertTrue(!wormDirection0.canHaveAsName("pieter"));
		assertTrue(!wormDirection0.canHaveAsName("8762398"));
		assertTrue(!wormDirection0.canHaveAsName("^$µùé"));
	}
	
	@Test
	public void canHaveAsTeam_legalCase(){
		assertTrue(wormDirection0.canHaveAsTeam(team));
	}
	
	@Test
	public void canHaveAsTeam_IllegalCase1(){
		wormDirection0.setWorld(null);
		world.addAsWorm(wormDirection0);
		wormDirection0.wormDeath();
		assertTrue(!wormDirection0.canHaveAsTeam(team));
	}
	
	@Test
	public void hasProperTeam_legalCase1(){
		wormDirection0.setTeam(null);
		assertTrue(wormDirection0.hasProperTeam());
		team.addAsTeamWorm(wormDirection0);
		assertTrue(wormDirection0.getTeam() != null && wormDirection0.hasProperTeam());
	}

	@Test
	public void setTeam_legalCase(){
		wormDirection0.setTeam(team);
		assertTrue(wormDirection0.getTeam() == team);
	}
	
	@Test
	public void hasProgram_LegalCase(){
		assertTrue(!wormDirection0.hasProgram());
	}
	
	@Test
	public void hasProgram_LegalCase2(){
		Program program1 = new Program(null, null, null);
		wormDirection0.setProgram(program1);
		assertTrue(wormDirection0.hasProgram());
	}
	
	@Test
	public void isAlive_LegalCase(){
		assertTrue(wormDirection0.isAlive());
	}
	
	@Test
	public void isAlive_LegalCase2(){
		world.addAsWorm(wormDirection0);
		wormDirection0.wormDeath();
		assertTrue(!wormDirection0.isAlive());
	}
	
	@Test
	public void wormDeath_HasATeam_NotCurrentWorm(){
		team.addAsTeamWorm(wormDirection0);
		world.addAsWorm(wormDirection0);
		wormDirection0.wormDeath();
		assertTrue(!wormDirection0.isAlive());
		assertTrue(!team.hasAsTeamWorm(wormDirection0));
	}
	
	@Test
	public void wormDeath_hasNoTeam_NotCurrentWorm(){
		world.addAsWorm(wormDirection0);
		wormDirection0.wormDeath();
		assertTrue(!wormDirection0.isAlive());
	}
	
	@Test
	public void wormDeath_hasATeam_CurrentWorm(){
		world.addAsWorm(wormDirection0);
		team.addAsTeamWorm(wormDirection0);
		world.startNextTurn();
		System.out.println(world.getCurrentWorm().getName());
		wormDirection0.wormDeath();
		assertTrue(!(world.getCurrentWorm() != wormDirection0));
		assertTrue(!wormDirection0.isAlive());
	}
	
	@Test
	public void wormDeath_hasNoTeam_CurrentWorm(){
		world.addAsWorm(wormDirection0);
		world.startNextTurn();
		wormDirection0.wormDeath();
		assertTrue(!wormDirection0.isAlive());
		assertTrue(!(world.getCurrentWorm() != wormDirection0));
	}
	
	
}

