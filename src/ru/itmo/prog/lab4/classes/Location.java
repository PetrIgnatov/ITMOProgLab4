package ru.itmo.prog.lab4.classes;
import ru.itmo.prog.lab4.interfaces.*;
import java.util.*;

public class Location {
	private String name;
	private ArrayList<LocationEntity> entities = new ArrayList<LocationEntity>();
	public Location(String name) {
		this.name = name;
	}
	public void addEntity(LocationEntity entity) {
		this.entities.add(entity);
	}
	public LocationEntity FindbyName(String name) {
		for (LocationEntity e : entities) {
			if (e.getName() == name)
			{
				return e;
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
		for (LocationEntity e : entities) {
			hash = (hash*e.hashCode())%1000000001;
		}
		return hash;
	}
}
