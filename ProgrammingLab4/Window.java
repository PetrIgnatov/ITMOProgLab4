package ProgrammingLab3;

public class Window implements Furniture {
	private boolean isOpen = false;
	public Window(boolean isOpen)
	{
		this.isOpen = isOpen;
	}
	public boolean isOpen() {
		return isOpen;
	}
	@Override
	public void interact() {
		isOpen = !isOpen;
		if (isOpen) {
			System.out.println("Окно открыто");
		}
		else {
			System.out.println("Окно закрыто");
		}
	}
	@Override
	public String getName() {
		return "Окно";
	}
	@Override 
	public int hashCode() {
		return isOpen ? 2 : 1;
	}
	@Override
	public String toString() {
		return "Window";
	}
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (other == null || other.getClass() != this.getClass()) {
			return false;
		}
		Window w = (Window) other;
		return this.hashCode() == w.hashCode();
	}
}
