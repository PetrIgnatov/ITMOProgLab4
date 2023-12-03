package ProgrammingLab3;

public class Malysh extends Human {
	public Malysh(Time timeline) {
		super("Малыш", timeline);
	}
	public void study()
	{
		System.out.println(name + " учится");
	}
	public void thinkAboutKarlson()
	{
		System.out.println(name + " думает о Карлсоне");
		timeline.move();
	}
}
