package redserver.redserver.utilities.ranks;

public class Ranks {
	
	public final String name;
	public final int permlevel;
	public final String prefix;
	
	public Ranks(String name, int permlevel, String prefix) {
		this.name = name;
		this.permlevel = permlevel;
		this.prefix = prefix;
	}
	
	public String getName() {
		return name;
	}
	public int getPermLevel() {
		return permlevel;
	}
	public String getPrefix() {
		return prefix;
	}

}
