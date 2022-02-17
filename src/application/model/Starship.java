package application.model;

import java.util.ArrayList;

public class Starship {

	private String shipName;
	private String shipRegistry;
	private String shipClass;
	private ArrayList<CrewMember> crewMemberAL;
	
	public Starship(String shipName, String shipRegistry, String shipClass)
	{
		this.shipName = shipName;
		this.shipRegistry = shipRegistry;
		this.shipClass = shipClass;
		this.crewMemberAL = new ArrayList<CrewMember>();
	}
	
	public String getShipName()
	{
		return shipName;
	}
	
	public void setShipName(String shipName)
	{
		this.shipName = shipName;
	}
	
	public String getShipRegistry()
	{
		return shipRegistry;
	}
	
	public void setShipRegistry(String shipRegistry)
	{
		this.shipRegistry = shipRegistry;
	}
	
	public String getShipClass()
	{
		return shipClass;
	}
	
	public void setShipClass(String shipClass)
	{
		this.shipClass = shipClass;
	}
	
	public ArrayList<CrewMember> getCrewMemberAL()
	{
		return crewMemberAL;
	}
	
	public void setCrewMemberAL()
	{
		this.crewMemberAL = new ArrayList<CrewMember>();
	}
	
	public String toString()
	{
		String info = shipName + " [" + shipRegistry + "], Class: " + shipClass + ", Crew: " + crewMemberAL.size();
		return info;
	}
	
	public void addMember(CrewMember m)
	{
		crewMemberAL.add(m);
	}
	
	public void removeMember(CrewMember m)
	{
		crewMemberAL.remove(m);
	}
}

