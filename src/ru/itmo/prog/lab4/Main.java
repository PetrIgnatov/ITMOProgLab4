package ru.itmo.prog.lab4;
import ru.itmo.prog.lab4.classes.*;
import ru.itmo.prog.lab4.interfaces.*;

public class Main {
	public static void main(String[] args)
	{
		Time timeline = new Time();
		Child Malysh = new Child("Малыш", timeline);
		GhostWithEngine Carlson = new GhostWithEngine("Карлсон", timeline, 0.0, 0.5);
		Location room = new Location("Комната");
		room.addEntity(new LocationEntity() {
			private boolean isOpen = false;
			public void interact() {
				isOpen = !isOpen;
			}
			public String getName() {
				return "Окно";
			}
			public boolean isOpen() {
				return isOpen;
			}
		});
		switch(timeline.getTime())
		{
			case MORNING:
				System.out.println("Утро");
				break;
			case DAY:
				System.out.println("День");
				break;
			case EVENING:
				System.out.println("Вечер");
				break;
			case NIGHT:
				System.out.println("Ночь");
		}
		try
		{
			Malysh.moveTo(room);
		}
		catch (TooDarkToWalkException e)
		{
			System.out.println("Ошибка! " + e.getMessage());
		}
		Malysh.interactWith("Окно");
		Malysh.thinkAboutHuman(Carlson);
		Malysh.sleep();
		Malysh.study();
		try
		{
			Carlson.moveTo(room);
		}
		catch (TooDarkToWalkException e)
		{
			System.out.println("Ошибка! " + e.getMessage());
		}
	}
}
