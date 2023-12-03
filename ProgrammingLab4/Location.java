package ProgrammingLab3;
import java.util.*;

public class Location {
	private String name;
	private ArrayList<Furniture> furniture = new ArrayList<Furniture>();
	public Location(String name) {
		this.name = name;
	}
	public void addFurniture(Furniture furniture) {
		this.furniture.add(furniture);
	}
	public Furniture FindbyName(String name) {
		for (Furniture f : furniture) {
			if (f.getName() == name)
			{
				return f;
			}
		}
		return null;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString()
	{
		return name;
	}
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (other == null || other.getClass() != this.getClass()) {
			return false;
		}
		Location loc = (Location) other;
		return this.hashCode() == loc.hashCode();	
	}
	@Override
	public int hashCode() {
		int hash = name.hashCode();
		for (Furniture f : furniture) {
			hash = (hash*f.hashCode())%1000000001;
		}
		return hash;
	}
}
