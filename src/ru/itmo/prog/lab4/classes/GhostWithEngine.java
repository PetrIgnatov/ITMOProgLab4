package ru.itmo.prog.lab4.classes;

public class GhostWithEngine extends Human {
	public class Engine {
		private double fuelLevel;
		public Engine(double fuel) {
			this.fuelLevel = fuel;
		}
		public void getCharged(double addLevel) {
			this.fuelLevel += addLevel;
		}
		public void work() {
			if (this.fuelLevel <= 0.0) {
				throw new FuelError("Слишком мало топлива, двигатель не может быть заведен");
			}
			System.out.println("Двигатель заработал");
		}
	}
	protected double jamLevel;
	protected Engine engine;
	public GhostWithEngine() {
	  super("Unnamed Ghost with Engine");
	  this.engine = new Engine(0.0);
		this.jamLevel = 0.0;
  }
  public GhostWithEngine(String name) {
	  super(name);
	  this.engine = new Engine(0.0);
		this.jamLevel = 0.0;
  }
  public GhostWithEngine(Time timeline) {
	  super(timeline);
	  this.engine = new Engine(0.0);
		this.jamLevel = 0.0;
  }
	public GhostWithEngine(String name, Time timeline) {
		super(name, timeline);
		this.engine = new Engine(0.0);
		this.jamLevel = 0.0;
	}
	public GhostWithEngine(String name, Time timeline, double jamLevel) {
		super(name,timeline);
		this.jamLevel = jamLevel;
		this.engine = new Engine(0.0);
	}
	public GhostWithEngine(String name, Time timeline, double jamLevel, double engineFuelLevel) {
		super(name,timeline);
		this.jamLevel = jamLevel;
		this.engine = new Engine(engineFuelLevel);
	}
	public void moveTo(Location loc) throws TooDarkToWalkException{
		if (timeline.getTime() == Time.TimeEnum.NIGHT) {
			throw new TooDarkToWalkException("Слишком поздно и темно, лучше никуда не ходить");
		}
		else {
			try {
				this.engine.work();
				if (jamLevel <= 0.0) {
					throw new FuelError("Привидение с мотором голодает и у него нет настроения лететь");
			  	}
			}
			catch (FuelError e) {
				System.out.println("Ошибка! " + e.getMessage());
				return;
			}
		System.out.println(this.name + " прилетел/а в " + loc.getName());
		}
	}
	public void eatJam(double addLevel) {
		jamLevel += addLevel;
	}
}
