public class profile
{
	String name; 
	int age = 0;
	int weight = 0;
	int height = 0;
	int level = 1;
	int experience = 0;
	int experience_needed = 1000;
	
	public String getName()
	{
		return name;
	}
	public void setName(String n)
	{
		name = n;
	}
	
	public int getWeight()
	{
		return weight;
	}
	public void setWeight(int w)
	{
		weight = w;
	}
	
	public int getHeight()
	{
		return height;
	}
	public void setHeight(int h)
	{
		height = h;
	}
	
	public int getLevel()
	{
		return level;
	}
	public void setLevel(int l)
	{
		level = l;
	}
	
	public int getExperienceNeeded()
	{
		return experience_needed;
	}
	public void setExperienceNeeded(int e)
	{
		experience_needed = e;
	}
	
	
	 public void incrementLevel()
	{
		int lev = getLevel();
		lev++;
		setLevel(lev);
		int oldExperience = getExperienceNeeded();
		int newExp = 2 * oldExperience;
		setExperienceNeeded(newExp);
	}
		
	
	
}



