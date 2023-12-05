package ru.se.ifmo.prog.lab4;
import ru.se.ifmo.prog.lab4.classes.*;
import ru.se.ifmo.prog.lab4.interfaces.*;

public class Main {
	public static void main(String[] args)
	{
		Time timeline = new Time(Time.TimeEnum.EVENING);
		Child Malysh = new Child("Малыш", timeline);
		GhostWithEngine Carlson = new GhostWithEngine("Карлсон", timeline, 0.0, 0.5);
		Location room = new Location("Комната");
		room.addEntity(new LocationEntity() {
			private boolean isOpen = false;
			public void interact() {
				isOpen = !isOpen;
				if (isOpen) {
					System.out.println("Окно открыто");
				}
				else {
					System.out.println("Окно закрыто");
				}
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
