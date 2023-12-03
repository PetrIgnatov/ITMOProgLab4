import ProgrammingLab3.*;

public class Main {
	public static void main(String[] args)
	{
		Time timeline = new Time();
		Malysh Mal = new Malysh(timeline);
		Location room = new Location("Комната");
		room.addFurniture(new Window(false));
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
		Mal.runTo(room);
		Mal.interactWith("Окно");
		Mal.thinkAboutKarlson();
		Mal.cry();
		Mal.sleep();
		Mal.study();
	}
}
