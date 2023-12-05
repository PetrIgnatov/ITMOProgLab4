package ru.itmo.prog.lab4.classes;

public class Child extends Human {
  public Child() {
    super("Unnamed Child");
  }
  public Child(String name) {
    super(name);
  }
  public Child(Time timeline) {
    super(timeline);
  }
	public Child(String name, Time timeline) {
		super(name, timeline);
	}
	public void study() {
		class Studies {
			int duration;
			public Studies(int duration) {
				this.duration = duration;
			}
		}
		Studies studies = new Studies(4);
		System.out.println(name + " учится");
		if (studies.duration > 3) {
			timeline.move();
		}
	}
	public void thinkAboutHuman(Human human) {
		System.out.println(name + " думает о " + human.name);
		if (this.location != human.location)
		{
			this.cry();
		}
		timeline.move();
	}
	public void moveTo(Location location) throws TooDarkToWalkException{
    		if (timeline.getTime() == Time.TimeEnum.NIGHT) {
      			throw new TooDarkToWalkException("Слишком поздно и темно, лучше никуда не ходить");
    		}
    		else {
			this.location = location;
			System.out.println(this.name + " прибежал/а в " + location.getName());
    		}	
	}
}
