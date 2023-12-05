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
		@Override
	  public int hashCode() {
		  return (int)(fuelLevel*10000); 
	  }
	  @Override
	  public boolean equals(Object other) {
		  if (other == this) {
			  return true;
		  }
		  if (other == null || other.getClass() != this.getClass()) {
			  return false;
		  }
		  Engine engine = (Engine) other;
		  return (this.fuelLevel == engine.fuelLevel);
	  }
	  @Override
	  public String toString() {
		  return "Engine with fuelLevel " + String.valueOf(fuelLevel);
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
	@Override
	public int hashCode() {
		return (name.hashCode()*(int)speed*timeline.hashCode()*engine.hashCode()*(int)(jamLevel*10000))%1000000001; 
	}
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (other == null || other.getClass() != this.getClass()) {
			return false;
		}
		GhostWithEngine ghost = (GhostWithEngine) other;
		return ((this.name == ghost.name) && (this.speed == ghost.speed) && (this.timeline.equals(ghost.timeline)) && (this.engine.equals(ghost.engine)) && (this.jamLevel == ghost.jamLevel));
	}
	@Override
	public String toString() {
		return super.toString();
	}
}
