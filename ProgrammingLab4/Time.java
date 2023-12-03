package ProgrammingLab3;

public class Time implements Moving {
	private TimeEnum curTime = TimeEnum.EVENING;
	@Override
	public void move()
	{
		switch(curTime) {
			case NIGHT:
				curTime = TimeEnum.MORNING;
				System.out.println("Наступило утро");
				break;
			case MORNING:
				curTime = TimeEnum.DAY;
				System.out.println("Наступил день");
				break;
			case DAY:
				curTime = TimeEnum.EVENING;
				System.out.println("Наступил вечер");
				break;
			case EVENING:
				curTime = TimeEnum.NIGHT;
				System.out.println("Наступила ночь");
				break;
		} //I regret nothing.
	}
	public TimeEnum getTime() {
		return curTime;
	}
	@Override
	public int hashCode() {
		return curTime.hashCode();
	}
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (other == null || other.getClass() != this.getClass()) {
			return false;
		}
		Time tl = (Time) other;
		return tl.hashCode() == this.hashCode();
	}
	@Override
	public String toString() {
		switch(curTime) {
			case NIGHT:
				return "NIGHT";
			case MORNING:
				return "MORNING";
			case DAY:
				return "DAY";
			case EVENING:
				return "EVENING";
		}
		return "UNKNOWN";
	}
}
