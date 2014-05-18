package worms.model;


import java.util.Collection;
import java.util.Random;


import expression.E;
import statement.S;
import type.T;
import worms.gui.game.IActionHandler;
import worms.model.programs.ParseOutcome;
import worms.model.programs.ProgramParser;



public class Facade implements IFacade {
	
	private World world = null;

	@Override
	public void addEmptyTeam(World world, String newName) 
			throws ModelException{
		try{
			world.addEmptyTeam(newName);
		}
		catch(IllegalNameException x){
			throw new ModelException("IllegalNameException");
		}
		catch(IllegalArgumentException x){
			throw new ModelException("IllegalArgumentException");
		}
	}

	@Override
	public void addNewFood(World world) 
			throws ModelException{
		try{
			world.addNewFood();
		}
		catch(IllegalArgumentException x){
			throw new ModelException("IllegalArgumentException");
		}
	}



	@Override
	public boolean canFall(Worm worm) {
		return worm.canFall();
	}

	@Override
	public boolean canMove(Worm worm) {
		return worm.canMove();
	}

	@Override
	public boolean canTurn(Worm worm, double angle) {
		return worm.canTurn(angle);
	}

	@Override
	public Food createFood(World world, double x, double y) 
			throws ModelException{
		try{
			Food food = new Food(x,y);
			world.addAsFood(food);
			return food;
		}
		catch(IllegalArgumentException z){
			throw new ModelException("IllegalArgumentException");
		}
	}

	@Override
	public World createWorld(double width, double height,
			boolean[][] passableMap, Random random) 
					throws ModelException{
		try{
			World world = new World(width, height, passableMap, random);
			this.world = world;
			return world;
		}
		catch(IllegalArgumentException x){
			throw new ModelException("IllegalArgumentException");
		}
	}

	@Override
	public void fall(Worm worm) 
			throws ModelException{
		try{
			worm.fall();
		}
		catch(IllegalPositionException x){
			throw new ModelException("IllegalPositionException");
		}
	}

	@Override
	public int getActionPoints(Worm worm) {
		return worm.getCurrentActionPoints();
	}

	@Override
	public Projectile getActiveProjectile(World world) {
		return world.getProjectile();
	}

	@Override
	public Worm getCurrentWorm(World world) {
		return world.getCurrentWorm();
	}

	@Override
	public Collection<Food> getFood(World world) {
		return world.getFood();
	}

	@Override
	public int getHitPoints(Worm worm) {
		return worm.getCurrentHitPoints();
	}

	@Override
	public double[] getJumpStep(Projectile projectile, double t) {
		return projectile.getJumpStep(t);
	}

	@Override
	public double[] getJumpStep(Worm worm, double t) 
			throws ModelException{
		try{
			return worm.getJumpStep(t);
		}
		catch(IllegalActionPointsException x){
			throw new ModelException("IllegalActionPointsException");
		}
		catch(IllegalDirectionException x){
			throw new ModelException("IllegalDirectionException");
		}
	}

	@Override
	public double getJumpTime(Projectile projectile, double timeStep) {
		try{
			return projectile.getJumpTime(timeStep);
		}
		catch(NullPointerException exc){
			throw new ModelException("NullPointerException");
		}
		catch(IllegalDirectionException exc){
			throw new ModelException("IllegalDirectionException");
		}
	}

	@Override
	public double getJumpTime(Worm worm, double timeStep) 
			throws ModelException{
		try{
			return worm.getJumpTime();
		}
		catch(IllegalActionPointsException x){
			throw new ModelException("IllegalActionPointsException");
		}
		catch(IllegalDirectionException x){
			throw new ModelException("IllegalDirectionException");
		}
	}

	@Override
	public double getMass(Worm worm) {
		return worm.getMass();
	}

	@Override
	public int getMaxActionPoints(Worm worm) {
		return worm.getMaxActionPoints();
	}

	@Override
	public int getMaxHitPoints(Worm worm) {
		return worm.getMaxHitPoints();
	}

	@Override
	public double getMinimalRadius(Worm worm) {
		return worm.getMinimalRadius();
	}

	@Override
	public String getName(Worm worm) {
		return worm.getName();
	}

	@Override
	public double getOrientation(Worm worm) {
		return worm.getDirection();
	}

	@Override
	public double getRadius(Food food) {
		return Food.getRadius();
	}

	@Override
	public double getRadius(Projectile projectile) {
		return projectile.getRadius();
	}

	@Override
	public double getRadius(Worm worm) {
		return worm.getRadius();
	}

	@Override
	public String getSelectedWeapon(Worm worm) {
		return worm.getWeapon().getCurrentWeapon();
	}

	@Override
	public String getTeamName(Worm worm) {
		if(worm.getTeam() == null)
			return "";
		return worm.getTeam().getTeamName();
	}

	@Override
	public String getWinner(World world) {
		return world.getWinner();
	}

	@Override
	public Collection<Worm> getWorms(World world) {
		return world.getWorms();
	}

	@Override
	public double getX(Food food) {
		return food.getX();
	}

	@Override
	public double getX(Projectile projectile) {
		return projectile.getX();
	}

	@Override
	public double getX(Worm worm) {
		return worm.getX();
	}

	@Override
	public double getY(Food food) {
		return food.getY();
	}

	@Override
	public double getY(Projectile projectile) {
		return projectile.getY();
	}

	@Override
	public double getY(Worm worm) {
		return worm.getY();
	}

	@Override
	public boolean isActive(Food food) {
		return food.isActive();
	}

	@Override
	public boolean isActive(Projectile projectile) {
		return projectile.isActive();
	}

	@Override
	public boolean isAdjacent(World world, double x, double y, double radius) {
		return world.isAdjacent(x, y, radius);
	}

	@Override
	public boolean isAlive(Worm worm) {
		return worm.isAlive();
	}

	@Override
	public boolean isGameFinished(World world) {
		return world.isGameFinished();
	}

	@Override
	public boolean isImpassable(World world, double x, double y, double radius) {
		return world.isImpassable(x, y, radius);
	}

	@Override
	public void jump(Projectile projectile, double timeStep) {
		try{
			projectile.jump(timeStep);
		}
		catch(NullPointerException exc){
			throw new ModelException("NullPointerException");
		}
		catch(IllegalDirectionException exc){
			throw new ModelException("IllegalDirectionException");
		}
	}

	@Override
	public void jump(Worm worm, double timeStep) 
			throws ModelException{
		try{
			worm.jump();
		}
		catch(IllegalActionPointsException x){
			throw new ModelException("IllegalActionPointsException");
		}
		catch(IllegalDirectionException x){
			throw new ModelException("IllegalDirectionException");
		}
		catch(IllegalPositionException x){
			throw new ModelException("IllegalPositionException");
		}
	}

	@Override
	public void move(Worm worm) {
		try
		{
			worm.move();
		}
		catch(IllegalDirectionException x){
			throw new ModelException("IllegalDirectionException");
		}
		catch(IllegalPositionException x){
			throw new ModelException("IllegalPositionException");
		}
	}

	@Override
	public void rename(Worm worm, String newName) 
			throws ModelException{
		try{
			worm.setName(newName);
		}
		catch(IllegalNameException x){
			throw new ModelException("IllegalNameException");
		}
	}

	@Override
	public void selectNextWeapon(Worm worm) {
		worm.getWeapon().selectNextWeapon();
	}

	@Override
	public void setRadius(Worm worm, double newRadius) 
			throws ModelException{
		try{
			worm.setRadius(newRadius);
		}
		catch(IllegalRadiusException x){
			throw new ModelException("IllegalRadiusException");
		}
	}

	@Override
	public void shoot(Worm worm, int yield){
		worm.getWeapon().shoot(yield);
	}

	@Override
	public void startGame(World world) {
		world.startGame();
	}

	@Override
	public void startNextTurn(World world) {
		world.startNextTurn();
	}

	@Override
	public void turn(Worm worm, double angle) {
		if(worm.canTurn(angle))
			worm.turn(angle);
	}

	@Override
	public void addNewWorm(World world, Program program) {
		System.out.println("addnewWorm gebeurt nu");
		world.addNewWorm(program);
		System.out.println("addnewWorm gedaan");
	}

	@Override
	public Worm createWorm(World world, double x, double y, double direction,
			double radius, String name, Program program) {
		Worm worm = null;
		world.addAsWorm(worm);
		System.out.println("TESTJEEE");
		if(program != null){
			worm = program.getWorm();
			worm.setProgram(program);
			worm.setX(x);
			worm.setY(y);
			worm.setDirection(direction);
			worm.setRadius(radius);
			worm.setName(name);
			System.out.println("Test2");
		}
		else{
			System.out.println("gegeven program is null");
			worm = new Worm(x,y,direction,radius,name);
		}
		return worm;
		//TODO na worm aan te maken, worm van implementedPF setten. (niet meer nodig?)
	}
 //TODO assistent evaluatie invullen.
	@Override
	public ParseOutcome<?> parseProgram(String programText,
			IActionHandler handler) {
		Worm worm = new Worm(0, 0, 0, 0.3, "Test");
		ImplementedPF factory = new ImplementedPF(handler, worm);
		ProgramParser<E, S, T> parser = new ProgramParser<E, S, T>(factory);
		parser.parse(programText);		
		if(!parser.getErrors().isEmpty())
		{
			System.out.println(parser.getErrors().get(0));
			return ParseOutcome.failure(parser.getErrors());
		}
		else
			System.out.println("Parsing was a succes!");
			
			return ParseOutcome.success(new Program(parser.getGlobals(), parser.getStatement(), handler, factory, worm));
	}

	@Override
	public boolean hasProgram(Worm worm) {
		return worm.getProgram() != null;
	}

	@Override
	public boolean isWellFormed(Program program) {
		return true;
		//TODO still have to add this.
	}

}
