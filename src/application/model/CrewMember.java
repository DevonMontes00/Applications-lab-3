package application.model;

public class CrewMember {
	private String memberName;
	private String memberPosition;
	private String memberRank;
	private String memberSpecies;
	private String memberRegistry;
	
	public CrewMember(String memberName, String memberPosition, String memberRank, String memberRegistry, String memberSpecies)
	{
		this.memberName = memberName;
		this.memberPosition = memberPosition;
		this.memberRank = memberRank;
		this.memberRegistry = memberRegistry;
		this.memberSpecies = memberSpecies;
	}
	
	public String getMemberName()
	{
		return memberName;
	}
	
	public void setMemeberName(String memberName)
	{
		this.memberName = memberName;
	}
	
	public String getMemberPosition()
	{
		return memberPosition;
	}
	
	public void setMemberPosition(String memberPosition)
	{
		this.memberPosition = memberPosition;
	}
	
	public String getMemberRank()
	{
		return memberRank;
	}
	
	public void setMemberRank(String memberRank)
	{
		this.memberRank = memberRank;
	}
	
	public String getMemberRegistry()
	{
		return memberRegistry;
	}
	
	public void setMemberRegistry(String memberRegistry)
	{
		this.memberRegistry = memberRegistry;
	}
	
	public String getMemberSpecies()
	{
		return memberSpecies;
	}
	
	public void setMemberSpecies(String memberSpecies)
	{
		this.memberSpecies = memberSpecies;
	}
	
	public String toString()
	{
		String info = "- " + memberRank + " " + memberName + ", " + memberPosition + " (" + memberSpecies + ")";
		return info;
	}
}
