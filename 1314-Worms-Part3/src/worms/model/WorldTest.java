package worms.model;


import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WorldTest {
	
	/**
	 * Variable referencing a world.
	 */
	private static World testWorld1;
	/**
	 * a passable map.
	 */
	boolean[][] passableMap;
	
	/**
	 * a variable referencing a food object.
	 */
	private static Food food1;
	
	/**
	 * a variable referencing a food object.
	 */
	private static Food food2;
	
	/**
	 * a variabele referencing a worm
	 */
	
	private static Worm worm1;
	
	/**
	 * a variabele referencing a worm
	 */
	
	private static Worm worm2;
	
	/**
	 * a variabele referencing a worm
	 */
	
	private static Worm worm3;
	
	/**
	 * a variable referencing a team.
	 */
	
	private static Team team1;
	
	/**
	 * a variable referencing a team.
	 */
	
	private static Team team2;
	
	/**
	 * a variable referencing a program.
	 */
	
	private static Program program1;
	
	/**
	 * a variable referencing a Projectile
	 */
	
	private static Projectile projectile1;


	/**
	 * Set up a mutable test fixture.
	 * 
	 * @post	The variable testWorld1 references a new world with a width and height of 10 meter,
	 * 			a passable map and a random.
	 */
	
	
	@Before
	public void setUpMutableFixture(){
		Random random = new Random();
		boolean[][] passableMap = {{false,false,false,false,false,false},
								   {false,true,true,true,true,false},
								   {false,true,true,true,true,false},
								   {false,true,true,true,true,false},
								   {false,true,true,true,true,false},
								   {false,false,false,false,false,false}};
		testWorld1 = new World(6,6,passableMap,random);		
	}

	/**
	 * 
	 */
	@BeforeClass
	public static void setUpImmutableFixture(){
	}
	
	
	@Test
	public void constructor_legalCase(){
		Random random = new Random();
		boolean[][] passableMap = {{false,false,false,false,false,false},
				   {false,true,true,true,true,false},
				   {false,true,true,true,true,false},
				   {false,true,true,true,true,false},
				   {false,true,true,true,true,false},
				   {false,false,false,false,false,false}};
		World myWorld = new World(10,15,passableMap, random);
		assertTrue(myWorld.getWidth() == 10);
		assertTrue(myWorld.getHeight() == 15);
		assertTrue(myWorld.getPassableMap().equals(passableMap));
		assertTrue(myWorld.getRandom().equals(random));
	}
	@Test(expected = IllegalArgumentException.class)
	public void constructor_illegalWidth()
		throws Exception{
		Random random = new Random();
		boolean[][] passableMap = {{false,false,false,false,false,false},
				   {false,true,true,true,true,false},
				   {false,true,true,true,true,false},
				   {false,true,true,true,true,false},
				   {false,true,true,true,true,false},
				   {false,false,false,false,false,false}};
		World myWorld = new World(10,15,passableMap, random);
		if(!myWorld.canHaveAsWidthOrHeight(-1))
			new World(-1,15,passableMap, random);
		if(!myWorld.canHaveAsWidthOrHeight( Double.MAX_VALUE +1 ))
			new World(Double.MAX_VALUE +1,15,passableMap, random);
		else
			throw new IllegalArgumentException();
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void constructor_illegalHeight()
		throws Exception{
		Random random = new Random();
		boolean[][] passableMap = {{false,false,false,false,false,false},
				   {false,true,true,true,true,false},
				   {false,true,true,true,true,false},
				   {false,true,true,true,true,false},
				   {false,true,true,true,true,false},
				   {false,false,false,false,false,false}};
		World myWorld = new World(10,15,passableMap, random);
		if(!myWorld.canHaveAsWidthOrHeight(-1))
			new World(10,-1,passableMap, random);
		if(!myWorld.canHaveAsWidthOrHeight( Double.MAX_VALUE +1 ))
			new World(10,Double.MAX_VALUE +1,passableMap, random);
		else
			throw new IllegalArgumentException();
	}
	
	@Test
	public void deactivate_legalCase1(){
		testWorld1.addAsFood(new Food(1,2));
		
		testWorld1.deactivate();
		assertTrue(!testWorld1.isActive());
		assertTrue(testWorld1.getFood().isEmpty());
	}
	
	@Test
	public void isActive_legalCase1(){
		assertTrue(testWorld1.isActive());
	}
	
	@Test
	public void isActive_legalCase2(){
		testWorld1.deactivate();
		assertTrue(!testWorld1.isActive());
	}
	

	
	@Test
	public void isStarted_legalCase1(){
		assertTrue(!testWorld1.isStarted());
	}
	
	@Test
	public void isStarted_LegalCase2(){
		worm1 = new Worm(2,2,0.25,0.25, "Pieter");
		worm2 = new Worm(2,2,0.25,0.25, "Laurens");
		testWorld1.addAsWorm(worm1);
		testWorld1.addAsWorm(worm2);
		testWorld1.startGame();
		assertTrue(testWorld1.isStarted());
	}
	
	@Test
	public void startGame_IllegalCase1(){
		testWorld1.addAsWorm(new Worm(1,1,0,1,"Test"));
		testWorld1.startGame();
		assertTrue(!testWorld1.isStarted());
	}
	
	@Test
	public void startGame_IllegalCase2(){
		testWorld1.startGame();
		assertTrue(!testWorld1.isStarted());
	}
	
	@Test
	public void canHaveAsWidthOrHeight_legalCase(){
		assertTrue(testWorld1.canHaveAsWidthOrHeight(2));
	}
	
	@Test
	public void canHaveAsWidthOrHeight_legalCase2(){
		assertTrue(testWorld1.canHaveAsWidthOrHeight(Double.MAX_VALUE -1));
	}
	
	@Test
	public void canHaveAsWidthOrHeight_IllegalCase1(){
		assertTrue(!testWorld1.canHaveAsWidthOrHeight(-2));
	}
	
	@Test
	public void getWidth_legalCase(){
		assertTrue(testWorld1.getWidth() == 6);
	}
	
	@Test
	public void getHeight_legalCase(){
		assertTrue(testWorld1.getHeight() == 6);
	}
	
	@Test
	public void getPassableMap(){
		Random random = new Random();
		boolean[][] passableMap = {{false,false,false,false,false,false},
								   {false,true,true,true,true,false},
								   {false,true,true,true,true,false},
								   {false,true,true,true,true,false},
								   {false,true,true,true,true,false},
								   {false,false,false,false,false,false}};
		
		World testWorld = new World(6,6,passableMap,random);
		assertTrue(testWorld.getPassableMap().equals(passableMap));
	}
	
	@Test
	public void startGame_LegalCase1(){
		testWorld1.addAsWorm(new Worm(1,1,0,1,"Test"));
		testWorld1.addAsWorm(new Worm(1,2,0,1,"Test2"));
		testWorld1.addAsWorm(new Worm(1,2,0,1,"Test3"));
		testWorld1.startGame();
		assertTrue(testWorld1.isStarted());
	}
	
	
	@Test
	public void isImpassable_legalCase1(){
		assertTrue(testWorld1.isImpassable(5, 5, 1));
	}
	
	@Test
	public void isImpassable_IllegalCase1(){
		assertTrue(!testWorld1.isImpassable(2, 2, 1));
	}
	
	@Test
	public void isAdjacent_IllegalCase1(){
		assertTrue(!testWorld1.isAdjacent(5, 5, 1));
	}
	
	@Test
	public void isAdjacent_IllegalCase(){
		assertTrue(!testWorld1.isAdjacent(3, 3, 0.5));
	}
	
	@Test
	public void isAdjacent_LegalCase(){
		assertTrue(testWorld1.isAdjacent(2,2,1));
	}
	
	@Test
	public void canFall_LegalCase(){
		assertTrue(testWorld1.canFall(2, 2, 0.25));
	}
	
	@Test
	public void canFall_IllegalCase(){
		assertTrue(!testWorld1.canFall(0, 0, 1));
	}
	
	@Test
	public void canFall_IllegalCase2(){
		assertTrue(!testWorld1.canFall(2, 2, 1));
	}
	
	@Test
	public void hasAsTeam_legalCase(){
		Team team = new Team("Pieter");
		testWorld1.addAsTeam(team);
		assertTrue(testWorld1.hasAsTeam(team));
	}
	

	
	@Test
	public void addNewWorm_legalCase_NoProgram_NoTeams(){
		for(int i = 0;i<10;i++){
			testWorld1.addNewWorm(null);
		}
		for(Worm worm: testWorld1.getWorms()){
			assertTrue(testWorld1.isAdjacent(worm.getX(),
					worm.getY(),worm.getRadius()) == true);
			assertTrue(worm.getRadius() == 0.25);
		}
	}
	
	@Test
	public void addNewWorm_LegalCase_WithProgram_NoTeams(){
		worm1 = new Worm(2,2,0,0.25,"Pieter");
		program1 = new Program(null, null, worm1);
		
		testWorld1.addNewWorm(program1);
		
		assertTrue(testWorld1.getWorms().contains(worm1));
		assertTrue(testWorld1.getTeams().isEmpty());
		
	}
	
	@Test
	public void addNewWorm_LegalCase_noProgram_WithTeams(){
		
		worm1 = new Worm(2,2,0,0.25,"Pieter");
		program1 = new Program(null, null, worm1);
		
		team1 = new Team("Pieter"); //smallest team
		team2 = new Team("Laurens");	//largest team.
		team1.addAsTeamWorm(new Worm(2,2,0,0.25,"Pieter1"));
		team2.addAsTeamWorm(new Worm(2,2,0,0.25,"Laurens1"));
		team2.addAsTeamWorm(new Worm(2,2,0,0.25,"Laurens2"));
		
		testWorld1.addAsTeam(team1);
		testWorld1.addAsTeam(team2);
		
		assertTrue(testWorld1.getTeams().size() == 2);
		assertTrue(team1.getSizeOfTeam() == 1);
		assertTrue(team2.getSizeOfTeam() == 2);
		
		testWorld1.addNewWorm(program1);
		
		assertTrue(team1.getSizeOfTeam() == 2);
		assertTrue(team2.getSizeOfTeam() == 2);
		assertTrue(testWorld1.getWorms().contains(worm1));
	}
	
	
	
	@Test
	public void addNewWorm_LegalCase_WithProgram_WithTeams(){
		team1 = new Team("Pieter"); //smallest team
		team2 = new Team("Laurens");	//largest team.
		
		team1.addAsTeamWorm(new Worm(2,2,0,0.25,"Pieter1"));
		team2.addAsTeamWorm(new Worm(2,2,0,0.25,"Laurens1"));
		team2.addAsTeamWorm(new Worm(2,2,0,0.25,"Laurens2"));
		
		testWorld1.addAsTeam(team1);
		testWorld1.addAsTeam(team2);
		
		assertTrue(testWorld1.getTeams().size() == 2);
		assertTrue(team1.getSizeOfTeam() == 1);
		assertTrue(team2.getSizeOfTeam() == 2);
	}
	
	@Test
	public void addNewFood_legalCase(){
		for(int i = 0;i<10;i++){
			testWorld1.addNewFood();
		}
		for(Food food: testWorld1.getFood()){
			assertTrue(testWorld1.isAdjacent(food.getX(),
					food.getY(),Food.getRadius()) == true);
			assertTrue(Food.getRadius() == 0.20);
		}
	}
	
	@Test
	public void addAsFood_LegalCase(){
		food1 = new Food(2,2);
		testWorld1.addAsFood(food1);
		assertTrue(testWorld1.getFood().contains(food1));
		assertTrue(food1.getWorld() == testWorld1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void addAsFood_IllegalCase_NULL(){
		food1 = null;
		testWorld1.addAsFood(food1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void addAsFood_IllegalCase_AlreadyHasWorld(){
		food1 = new Food(2,2);
		food1.setWorld(new World(6,6,passableMap,new Random()));
		testWorld1.addAsFood(food1);
	}
	
	@Test
	public void addAsTeam_LegalCase(){
		team1 = new Team("Pieter");
		testWorld1.addAsTeam(team1);
		assertTrue(testWorld1.hasAsTeam(team1));
		assertTrue(team1.getWorld() == testWorld1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void addAsTeam_IllegalCase_CantHaveAsTeam(){
		team1 = null;
		testWorld1.addAsTeam(team1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void addAsTeam_IllegalCase_GetWorldNotNull(){
		team1 = new Team("Pieter");
		team1.setWorld(new World(6,6,passableMap,new Random()));
		testWorld1.addAsTeam(team1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void addAsTeam_IllegalCase_MaxTeams(){
		testWorld1.addAsTeam(new Team("Testa"));
		testWorld1.addAsTeam(new Team("Testb"));
		testWorld1.addAsTeam(new Team("Testc"));
		testWorld1.addAsTeam(new Team("Testd"));
		testWorld1.addAsTeam(new Team("Teste"));
		testWorld1.addAsTeam(new Team("Testf"));
		testWorld1.addAsTeam(new Team("Testg"));
		testWorld1.addAsTeam(new Team("Testh"));
		testWorld1.addAsTeam(new Team("Testi"));
		testWorld1.addAsTeam(new Team("Testj"));
		System.out.println(testWorld1.getTeams().size());
		testWorld1.addAsTeam(team1);
	}
	
	@Test
	public void addAsWorm_LegalCase(){
		worm1 = new Worm(2,2,0,0.25,"Pieter");
		testWorld1.addAsWorm(worm1);
		assertTrue(testWorld1.getWorms().contains(worm1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void addAsWorm_IllegalCase_CantHaveAsWorm(){
		worm1 = null;
		testWorld1.addAsWorm(worm1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void addAsWorm_IllegalCase_NoneNullWorld(){
		worm1 = new Worm(2,2,0,0.25,"Laurens");
		worm1.setWorld(new World(6,6,passableMap, new Random()));
		testWorld1.addAsWorm(worm1);
	}
	
	@Test
	public void addEmptyTeam_LegalCase(){
		assertTrue(testWorld1.getTeams().isEmpty());
		testWorld1.addEmptyTeam("Pieter");
		assertTrue(!testWorld1.getTeams().isEmpty());
	}
	
	@Test(expected = IllegalNameException.class)
	public void addEmptyTeam_IllegalCase_IllegalName1(){
		testWorld1.addEmptyTeam("pieter");
	}
	
	@Test(expected = IllegalNameException.class)
	public void addEmptyTeam_IllegalCase_IllegalName2(){
		testWorld1.addEmptyTeam("�!�.:�");
	}
	
	@Test(expected = IllegalNameException.class)
	public void addEmptyTeam_IllegalCase_IllegalName3(){
		testWorld1.addEmptyTeam("Sean o' Connel");
	}
	
	@Test
	public void canHaveAsFood_legalCase(){
		food1 = new Food(2,2);
		assertTrue(testWorld1.canHaveAsFood(food1));
	}
	
	@Test
	public void canHaveAsFood_illegalCase1(){
		food1 = null;
		assertTrue(! testWorld1.canHaveAsFood(food1));
	}
	
	@Test
	public void canHaveAsFood_IllegalCase2(){
		food1 = new Food(2,2);
		testWorld1.addAsFood(food1);
		food1.deactivate();
		assertTrue(! testWorld1.canHaveAsFood(food1));
	}
	
	@Test
	public void canHaveAsFood_IllegalCase3(){
		food1 = new Food(2,2);
		testWorld1.deactivate();
		assertTrue(! testWorld1.canHaveAsFood(food1));
	}
	
	@Test
	public void canHaveAsProjectile_legalCase1(){
		worm1 = new Worm(2,2,0,0.25, "Pieter");
		testWorld1.addAsWorm(worm1);
		projectile1 = new Projectile(worm1, 0, 0.25, 0);
		assertTrue(testWorld1.canHaveAsProjectile(projectile1));
	}
	
	@Test
	public void canHaveAsProjectile_LegalCase2(){
		projectile1 = null;
		assertTrue(testWorld1.canHaveAsProjectile(projectile1));
	}
	
	@Test
	public void canHaveAsProjectile_IllegalCase(){
		worm1 = new Worm(2,2,0,0.25, "Pieter");
		testWorld1.addAsWorm(worm1);
		projectile1 = new Projectile(worm1, 0, 0.25, 0);
		projectile1.deactivate();
		assertTrue(! testWorld1.canHaveAsProjectile(projectile1));
	}
	
	@Test
	public void canHaveAsTeam_LegalCase1(){
		team1 = new Team("Pieter");
		team2 = new Team("Laurens");
		testWorld1.addAsTeam(team1);
		assertTrue(testWorld1.canHaveAsTeam(team2));
	}
	
	@Test
	public void canHaveAsTeam_LegalCase2_NoTeamsYet(){
		team2 = new Team("Laurens");
		assertTrue(testWorld1.canHaveAsTeam(team2));
	}
	
	//world inactive, team null, team inactive, team.name == anderteam.name

	@Test
	public void canHaveAsTeam_IllegalCase_WorldInactive(){
		team1 = new Team("Pieter");
		testWorld1.deactivate();
		assertTrue(! testWorld1.canHaveAsTeam(team1));
	}
	
	@Test
	public void canHaveAsTeam_IllegalCase_TeamNull(){
		team1 = null;
		assertTrue(! testWorld1.canHaveAsTeam(team1));
		
	}
	
	
	@Test
	public void canHaveAsTeam_IllegalCase_DuplicateName(){
		team1 = new Team("Pieter");
		team2 = new Team("Pieter");
		testWorld1.addAsTeam(team1);
		assertTrue(! testWorld1.canHaveAsTeam(team2));
	}
	
	@Test
	public void getAny_LegalCase(){
		worm1 = new Worm(2,2,0,0.25,"Pieter");
		food1 = new Food(2,2);
		testWorld1.addAsFood(food1);
		testWorld1.addAsWorm(worm1);
		
		assertTrue(testWorld1.getAny().contains(food1) && testWorld1.getAny().contains(worm1));
	}
	
	@Test
	public void hasAsFood_LegalCase(){
		food1 = new Food(2,2);
		testWorld1.addAsFood(food1);
		food2 = new Food(2,2);
		assertTrue(testWorld1.hasAsFood(food1));
		assertTrue( !testWorld1.hasAsFood(food2));
	}
	
	@Test
	public void hasAsWorm_LegalCase(){
		worm1 = new Worm(2,2,0,0.25,"Pieter");
		worm2 = new Worm(2,2,0,0.25,"Laurens");
		testWorld1.addAsWorm(worm1);
		assertTrue(testWorld1.hasAsWorm(worm1));
		assertTrue(! testWorld1.hasAsWorm(worm2));
	}
	
	@Test
	public void hasProperFoodRations_LegalCase(){
		food1 = new Food(2,2);
		food2 = new Food(3,3);
		testWorld1.addAsFood(food1);
		testWorld1.addAsFood(food2);
		assertTrue(testWorld1.hasProperFoodRations());
	}
	
	@Test
	public void hasProperFoodRations_IllegalCase1(){
		food1 = new Food(2,2);
		food2 = new Food(3,3);
		testWorld1.addAsFood(food1);
		testWorld1.addAsFood(food2);
		food1.setWorld(null);
		assertTrue(! testWorld1.hasProperFoodRations());
	}
	
	@Test
	public void hasProperProjectile_LegalCase(){
		worm1 = new Worm(2, 2, 0.25, 0.25, "Pieter");
		testWorld1.addAsWorm(worm1);
		projectile1 = new Projectile(worm1, 0, 0.2, 0);
		testWorld1.setProjectile(projectile1);
		assertTrue(testWorld1.hasProperProjectile());
	}
	
	@Test
	public void hasProperTeams_LegalCase_NoTeams(){
		assertTrue(testWorld1.hasProperTeams());
	}
	
	@Test
	public void hasProperWorms_LegalCase_NoWorms(){
		assertTrue(testWorld1.hasProperWorms());
	}
	
	@Test
	public void hasProperWorms_LegalCase_WithWorms(){
		worm1 = new Worm(2, 2, 0.25, 0.25, "Pieter");
		worm2 = new Worm(2, 2, 0.25, 0.25, "Laurens");
		testWorld1.addAsWorm(worm1);
		testWorld1.addAsWorm(worm2);
		
		assertTrue(testWorld1.hasProperWorms());
		
	}
	
	@Test
	public void hasProperWorms_IllegalCase_WithWorms(){
		worm1 = new Worm(2, 2, 0.25, 0.25, "Pieter");
		worm2 = new Worm(2, 2, 0.25, 0.25, "Laurens");
		testWorld1.addAsWorm(worm1);
		testWorld1.addAsWorm(worm2);
		worm1.setWorld(null);
		assertTrue(!testWorld1.hasProperWorms());
	}
	/* the world
	 * |* * * * * *|
	 * |* o o o o *|
	 * |* o o o o *|
	 * |* o o o o *|
	 * |* * * * * *|
	 */
	@Test
	public void hitAnyFood_LegalCase_HitsFood(){
		food1 = new Food(2,2);
		testWorld1.addAsFood(food1);
		assertTrue(testWorld1.hitAnyFood(2.0,2.0, 1) == food1);
	}
	
	@Test
	public void hitAnyFood_LegalCase_ImpassablePoint(){
		assertTrue(testWorld1.hitAnyFood(0, 0, 2) == null);
	}
	
	@Test
	public void hitAnyFood_LegalCase_HitNoFood(){
		assertTrue(testWorld1.hitAnyFood(2,2,1) == null);
	}
	
	@Test
	public void hitAnyWorm_LegalCase_HitsWorm(){
		worm1 = new Worm(2,2,0.25,0.25, "Pieter");
		testWorld1.addAsWorm(worm1);
		assertTrue(testWorld1.hitAnyFood(2.0,2.0, 1) == food1);
	}
	
	@Test
	public void hitAnyWorm_LegalCase_ImpassablePoint(){
		assertTrue(testWorld1.hitAnyFood(0, 0, 2) == null);
	}
	
	@Test
	public void hitAnyWorm_LegalCase_HitNoWorm(){
		assertTrue(testWorld1.hitAnyFood(2,2,1) == null);
	}
	
	@Test
	public void isGameFinished_LegalCase_OneWormLeft(){
		worm1 = new Worm(2,2,0.25,0.25, "Pieter");
		testWorld1.addAsWorm(worm1);
		assertTrue(testWorld1.isGameFinished());
	}
	
	@Test
	public void isGameFinished_LegalCase_OneTeamLeft(){
		worm1 = new Worm(2,2,0.25,0.25, "Pieter");
		worm2 = new Worm(2,2,0.25,0.25, "Laurens");
		team1 = new Team("Pieter");
		team1.addAsTeamWorm(worm1);
		team1.addAsTeamWorm(worm2);
		testWorld1.addAsWorm(worm1);
		testWorld1.addAsWorm(worm2);
		testWorld1.addAsTeam(team1);
		
		assertTrue(testWorld1.isGameFinished());
		
	}
	
	@Test
	public void isGameFinished_IllegalCase_TwoTeamsLeft(){
		worm1 = new Worm(2,2,0.25,0.25, "Pieter");
		worm2 = new Worm(2,2,0.25,0.25, "Laurens");
		team1 = new Team("Pieter");
		team2 = new Team("Laurens");
		team1.addAsTeamWorm(worm1);
		team2.addAsTeamWorm(worm2);
		testWorld1.addAsWorm(worm1);
		testWorld1.addAsWorm(worm2);
		testWorld1.addAsTeam(team1);
		testWorld1.addAsTeam(team2);
		
		assertTrue(!testWorld1.isGameFinished());
		
	}
	
	@Test
	public void isGameFinished_IllegalCase_TwoWormsLeft(){
		worm1 = new Worm(2,2,0.25,0.25, "Pieter");
		worm2 = new Worm(2,2,0.25,0.25, "Laurens");
		testWorld1.addAsWorm(worm1);
		testWorld1.addAsWorm(worm2);
		assertTrue(!testWorld1.isGameFinished());
	}
	
	@Test
	public void removeAsFood_LegalCase(){
		food1 = new Food(2,2);
		testWorld1.addAsFood(food1);
		assertTrue(testWorld1.hasAsFood(food1));
		testWorld1.removeAsFood(food1);
		assertTrue(! testWorld1.hasAsFood(food1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void removeAsFood_IllegalCase(){
		food1 = new Food(2,2);
		
		testWorld1.removeAsFood(food1);
	}
	
	@Test
	public void removeAsTeam_LegalCase(){
		team1 = new Team("Pieter");
		testWorld1.addAsTeam(team1);
		assertTrue(testWorld1.hasAsTeam(team1));
		testWorld1.removeAsTeam(team1);
		assertTrue(! testWorld1.hasAsTeam(team1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void removeAsTeam_IllegalCase(){
		team1 = new Team("Pieter");
		
		testWorld1.removeAsTeam(team1);
	}
	
	@Test
	public void removeAsWorm_LegalCase(){
		worm1 = new Worm(2,2,0.25,0.25,"Pieter");
		testWorld1.addAsWorm(worm1);
		assertTrue(testWorld1.hasAsWorm(worm1));
		testWorld1.removeAsWorm(worm1);
		assertTrue(! testWorld1.hasAsWorm(worm1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void removeAsWorm_IllegalCase(){
		worm1 = new Worm(2,2,0.25,0.25,"Pieter");
		
		testWorld1.removeAsWorm(worm1);
	}
	
	@Test
	public void setProjectile_LegalCase(){
		worm1 = new Worm(2, 2, 0.25, 0.25, "Pieter");
		testWorld1.addAsWorm(worm1);
		projectile1 = new Projectile(worm1, 0, 0.2, 0);
		testWorld1.setProjectile(projectile1);
		assertTrue(testWorld1.getProjectile() == projectile1);
	}
	
	@Test
	public void startNextTurn_LegalCase_TwoWorms(){
		worm1 = new Worm(2, 2, 0.25, 0.25, "Pieter");
		worm2 = new Worm(2, 2, 0.25, 0.25, "Loots");
		worm3 = new Worm(2, 2, 0.25, 0.25, "Laurens");
		
		testWorld1.addAsWorm(worm1);
		testWorld1.addAsWorm(worm2);
		testWorld1.addAsWorm(worm3);
		assertTrue(testWorld1.getCurrentWorm() == null);
		testWorld1.startNextTurn();
		assertTrue(testWorld1.getCurrentWorm() == worm1);
		testWorld1.startNextTurn();
		assertTrue(testWorld1.getCurrentWorm() == worm2);
		testWorld1.startNextTurn();
		assertTrue(testWorld1.getCurrentWorm() == worm3);
		testWorld1.startNextTurn();
		assertTrue(testWorld1.getCurrentWorm() == worm1);
		
		//dead worms
		worm2.wormDeath();
		testWorld1.startNextTurn();
		assertTrue(testWorld1.getCurrentWorm() == worm3);
		testWorld1.startNextTurn();
		assertTrue(testWorld1.getCurrentWorm() == worm1);
		
	}
	
	
	
}