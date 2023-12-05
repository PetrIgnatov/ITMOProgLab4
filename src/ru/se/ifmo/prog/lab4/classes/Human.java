package ru.se.ifmo.prog.lab4.classes;
import ru.se.ifmo.prog.lab4.interfaces.*;

public abstract class Human implements Moveable {
	protected String name;
	protected double speed;
	protected Location location;
	protected Time timeline;
	public Human() {
	  this.name = "Unnamed";
	  this.timeline = null;
	}
	public Human(String name) {
	  this.name = name;
	  this.timeline = null;
	}
	public Human(Time timeline) {
	  this.name = "Unnamed";
	  this.timeline = timeline;
	}
	public Human(String name, Time timeline) {
		this.name = name;
		this.timeline = timeline;
	}
	public final void interactWith(String name) {
		LocationEntity e = this.location.FindbyName(name);
		if (e != null)
		{
			System.out.println(this.name + " взаимодействует с " + name);
			e.interact();
		}
		else
		{
			System.out.println("Предмет не найден");
		}
	}
	public void moveTo(Location location) throws TooDarkToWalkException {
		if (timeline.getTime() == Time.TimeEnum.NIGHT)
		{
			throw new TooDarkToWalkException("Слишком поздно и темно, лучше никуда не ходить");
		}
		else
		{
			this.location = location;
			System.out.println(name + " пришел/ла в " + location.getName());
		}
	}
	public final void cry() {
		System.out.println(name + " плачет");
	}
	public final void sleep() {
		System.out.println(name + " спит");
		timeline.move();
	}
	@Override
	public final void move() {
		System.out.println(name + " двигается");
	}
	@Override
	public int hashCode() {
		return (name.hashCode()*(int)speed*timeline.hashCode())%1000000001; 
	}
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (other == null || other.getClass() != this.getClass()) {
			return false;
		}
		Human human = (Human) other;
		return (this.name == human.name) && (this.speed == human.speed) && (this.timeline.equals(human.timeline));
	}
	@Override
	public String toString() {
		return this.name;
	}
}
