package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Fleet {
	private String fleetName;
	private ArrayList<Starship> StarshipAL;
	
	public Fleet(String fleetName)
	{
		this.fleetName = fleetName;
		this.StarshipAL = new ArrayList<Starship>();
	}
	
	/**
	 * Getter for fleet name
	 * 
	 * @author iog693
	 * @return Fleet name
	 */
	public String getFleetName()
	{
		return fleetName;
	}
	
	/**
	 * Setter for fleet name
	 * 
	 * @author iog693
	 * @param A string for new fleet name
	 */
	public void setFleetName(String fleetName)
	{
		this.fleetName = fleetName;
	}
	
	/**
	 * Getter for StarshipAL
	 * 
	 * @author iog693
	 * @return Arraylist of starship objects
	 */
	public ArrayList<Starship> getStarshipAL()
	{
		return StarshipAL;
	}
	
	/**
	 * Setter for StarshipAL
	 * 
	 * @author Devon
	 * @param ArrayList of starship objects
	 */
	public void setStarshipAL(ArrayList<Starship> StarshipAL)
	{
		this.StarshipAL = StarshipAL;
	}
	
	/**
	 * To string function for a fleet object
	 * 
	 * @author iog693
	 * @return String of fleet object
	 */
	public String toString()
	{
		int i;
		String info = Starship.class.toString() + "\n";
		
		for(i = 0; i < StarshipAL.size(); i++)
		{
			info = info + StarshipAL.get(i);
		}
		
		return info;
	}
	
	/**
	 * Adds starship to starship arraylist
	 * 
	 * @author iog693
	 * @param Starship object
	 */
	public void addStarship(Starship s)
	{
		StarshipAL.add(s);
	}
	
	/**
	 * Loads starship objects from file into an arraylist
	 * 
	 * @author iog693
	 * @param file name of file that contains starship information
	 */
	public void loadStarships(String fileName)
	{
		File file = new File(fileName);
		
		try {
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext())
			{
				String data = inputStream.nextLine();
				String [] dataComponents = data.split(",");
	
				String starshipName = dataComponents[0];
				String starshipRegistry = dataComponents[1];
				String starshipClass = dataComponents[2];
				
				Starship s = new Starship(starshipName, starshipRegistry, starshipClass);
				
				addStarship(s);
			}
			inputStream.close();
		} catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Loads file with member objects into a member arraylist
	 * 
	 * @author iog693
	 * @param File name of file that contains member information
	 */
	public void loadMembers(String fileName) 
	{
		int i;
		
		File file = new File(fileName);
		
		try {
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext())
			{
				String data = inputStream.nextLine();
				String [] dataComponents = data.split(",");
				
				String memberName = dataComponents[0];
				String memberPosition = dataComponents[1];
				String memberRank = dataComponents[2];
				String memberRegistry = dataComponents[3];
				String memberSpecies = dataComponents[4];
				
				CrewMember m = new CrewMember(memberName, memberPosition, memberRank, memberRegistry, memberSpecies);
				
				for(i = 0; i < StarshipAL.size(); i++)
				{
					if(StarshipAL.get(i).getShipRegistry().equals(m.getMemberRegistry()))
						StarshipAL.get(i).addMember(m);
				}
			}
			inputStream.close();
		} catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	 }
	
	/**
	 * Searches for a specific name of a ship and returns ship info and crew
	 * 
	 * @param Name of a ship
	 * @return String of Ship info followed by all members of the ship
	 */
	public String searchStarship(String shipText)
	{
		int i;
		int j;
		String result = "";
		String members = "";
		for(i = 0; i < StarshipAL.size(); i++)
		{
			String [] ShipArray = StarshipAL.get(i).getShipName().split(" ");
			if(shipText.equalsIgnoreCase(ShipArray[1]))
			{
				result = result + StarshipAL.get(i).toString() + "\n";
				
				for(j = 0; j < StarshipAL.get(i).getCrewMemberAL().size(); j++)
				{
					members = members + StarshipAL.get(i).getCrewMemberAL().get(j).toString() + "\n";
				}
				
				result = result + members + "\n";
				members = "";
			}	
			
		}
		return result;
	}
}
