package worms.model;

import type.Double;
import type.Boolean;
import type.Entity;

import java.util.List;

import expression.*;
import expression.boolExpression.*;
import expression.doubleExpression.*;
import expression.entityExpression.*;
import expression.doubleExpression.property.*;
import statement.*;
import statement.action.*;
import type.T;
import be.kuleuven.cs.som.annotate.Basic;
import worms.gui.game.IActionHandler;
import worms.model.programs.ProgramFactory;

/**
 * @version 1.0
 * @author 	Laurens Loots, Pieter Vos
 */
public class ImplementedPF implements ProgramFactory<E, S, T>{
	
	public ImplementedPF(IActionHandler handler,Worm worm){
		this.handler = handler;
		setWorm(worm);
	}
	
	
	@Basic
	public IActionHandler getHandler(){
		return this.handler;
	}
	
	private final IActionHandler handler;
	
	
	@Basic
	public void setWorm(Worm worm){
		this.worm = worm;
	}
	
	@Basic
	public Worm getWorm(){
		return this.worm;
	}
	
	private Worm worm = null;
	

	@Override
	public E createDoubleLiteral(int line, int column, double d) {
		return new DoubleLiteral(line, column, d);
	}

	@Override
	public E createBooleanLiteral(int line, int column, boolean b) {
		return new BoolLiteral(line, column, b);
	}

	@Override
	public E createAnd(int line, int column, E e1, E e2) {
		return new Conjunction(line, column, e1, e2);
	}

	@Override
	public E createOr(int line, int column, E e1, E e2) {
		return new Disjunction(line, column, e1, e2);
	}

	@Override
	public E createNot(int line, int column, E e) {
		return new Negation(line, column, e);
	}

	@Override
	public E createNull(int line, int column) {
		return new Null(line, column );
	}

	@Override
	public E createSelf(int line, int column) {
		return new Self(line, column, getWorm());
	}

	@Override
	public E createGetX(int line, int column, E e) {
		return new GetX(line, column, e);
	}

	@Override
	public E createGetY(int line, int column, E e) {
		return new GetY(line, column, e);
	}

	@Override
	public E createGetRadius(int line, int column, E e) {
		return new GetRadius(line, column, e);
	}

	@Override
	public E createGetDir(int line, int column, E e) {
		return new GetDirection(line, column, e);
	}

	@Override
	public E createGetAP(int line, int column, E e) {
		return new GetActionPoints(line, column, e);
	}

	@Override
	public E createGetMaxAP(int line, int column, E e) {
		return new GetMaxActionPoints(line, column, e);
	}

	@Override
	public E createGetHP(int line, int column, E e) {
		return new GetHitPoints(line, column, e);
	}

	@Override
	public E createGetMaxHP(int line, int column, E e) {
		return new GetMaxHitPoints(line, column, e);
	}

	@Override
	public E createSameTeam(int line, int column, E e) {
		return new SameTeam(line, column, e, getWorm());
	}

	@Override
	public E createSearchObj(int line, int column, E e) {
		return new SearchObject(line, column, e, getWorm());
	}

	@Override
	public E createIsWorm(int line, int column, E e) {
		return new IsWorm(line, column, e);
	}

	@Override
	public E createIsFood(int line, int column, E e) {
		return new IsFood(line, column, e);
	}

	@Override
	public E createVariableAccess(int line, int column, String name) {
		return null;
	}
	

	@Override
	public E createLessThan(int line, int column, E e1, E e2) {
		return new LessThan(line, column, e1, e2);
	}

	@Override
	public E createGreaterThan(int line, int column, E e1, E e2) {
		return new GreaterThan(line, column, e1, e2);
	}

	@Override
	public E createLessThanOrEqualTo(int line, int column, E e1, E e2) {
		return new LessOrEqual(line, column, e1, e2);
	}

	@Override
	public E createGreaterThanOrEqualTo(int line, int column, E e1, E e2) {
		return new GreaterOrEqual(line, column, e1, e2);
	}

	@Override
	public E createEquality(int line, int column, E e1, E e2) {
		return new Equality(line, column, e1, e2);
	}

	@Override
	public E createInequality(int line, int column, E e1, E e2) {
		return new Inequality(line, column, e1, e2);
	}

	@Override
	public E createAdd(int line, int column, E e1, E e2) {
		return new Addition(line, column, e1, e2);
	}

	@Override
	public E createSubtraction(int line, int column, E e1, E e2) {
		return new Subtraction(line, column, e1, e2);
	}

	@Override
	public E createMul(int line, int column, E e1, E e2) {
		return new Multiplication(line, column, e1, e2);
	}

	@Override
	public E createDivision(int line, int column, E e1, E e2) {
		return new Division(line, column, e1, e2);
	}

	@Override
	public E createSqrt(int line, int column, E e) {
		return new SquareRoot(line, column, e);
	}

	@Override
	public E createSin(int line, int column, E e) {
		return new Sine(line, column, e);
	}

	@Override
	public E createCos(int line, int column, E e) {
		return new Cosine(line, column, e);
	}

	@Override
	public S createTurn(int line, int column, E angle) {
		return new Turn(line, column, getHandler(), angle);
	}

	@Override
	public S createMove(int line, int column) {
		return new Move(line, column, getHandler());
	}

	@Override
	public S createJump(int line, int column) {
		return new Jump(line, column, getHandler());
	}

	@Override
	public S createToggleWeap(int line, int column) {
		return new SwitchWeapon(line, column, getHandler());
	}

	@Override
	public S createFire(int line, int column, E yield) {
		return new Shoot(line, column, getHandler(), yield);
	}

	@Override
	public S createSkip(int line, int column) {
		return new Skip(line, column, getHandler());
	}

	@Override
	public S createAssignment(int line, int column, String variableName, E rhs) {
		return new Assignment(line, column, variableName, rhs, getWorm());
	}

	@Override
	public S createIf(int line, int column, E condition, S then, S otherwise) {
		return new IfThenElse(line, column, condition, then, otherwise);
	}

	@Override
	public S createWhile(int line, int column, E condition, S body) {
		return new WhileLoop(line, column, condition, body);
	}

	@Override
	public S createForeach(int line, int column,
			worms.model.programs.ProgramFactory.ForeachType type,
			String variableName, S body) {
		return new ForEachLoop(line, column, type, variableName, body);
	}

	@Override
	public S createSequence(int line, int column, List<S> statements) {
		return new Sequence(line, column, statements);
	}

	@Override
	public S createPrint(int line, int column, E e) {
		return new Print(line, column, e);
	}

	@Override
	public T createDoubleType() {
		return new Double();
	}

	@Override
	public T createBooleanType() {
		return new Boolean();
	}

	@Override
	public T createEntityType() {
		return new Entity();
	}


	@Override
	public E createVariableAccess(int line, int column, String name, T type) {
		if(type instanceof Double)
			return new DoubleVariableAccess(line, column, name, getWorm());
		else if(type instanceof Boolean)
			return new BoolVariableAccess(line, column, name, getWorm());
		else
			return new EntityVariableAccess(line, column, name, getWorm());
	}

	
}
