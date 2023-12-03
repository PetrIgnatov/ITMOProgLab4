package ProgrammingLab3;

public abstract class Human implements Moving {
	protected String name;
	protected double spd;
	protected Location loc;
	protected Time timeline;
	public Human(String name, Time timeline) {
		this.name = name;
		this.timeline = timeline;
	}
	public final void interactWith(String name) {
		Furniture f = loc.FindbyName(name);
		if (f != null)
		{
			System.out.println(this.name + " взаимодействует с " + name);
			f.interact();
		}
		else
		{
			System.out.println("Предмет не найден");
		}
	}
	public final void runTo(Location loc) {
		this.loc = loc;
		System.out.println(name + " прибежал/а в " + loc.getName());
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
		return (name.hashCode()*(int)spd*timeline.hashCode())%1000000001; 
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
		return (this.name == human.name) && (this.spd == human.spd) && (this.timeline.equals(human.timeline));
	}
	@Override
	public String toString() {
		return this.name;
	}
}
