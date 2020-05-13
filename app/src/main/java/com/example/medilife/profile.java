/**
 * profile.java
 * A profile class written for the MediLife app 'profile' screen
 * Written By Nicolas Stefanelli
 */

public class profile
{
	String name; 
	int age = 0;
	int weight = 0;
	int height = 0;
	double BMI = 0;
	String bmiType = "normal";
	int level = 1;
	int experience = 0;
	int experience_needed = 1000;
	int streak = 0;
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
		updateBMI();
	}
	public int getHeight()
	{
		return height;
	}
	public void setHeight(int h)
	{
		height = h;
		updateBMI();
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
	
	public void updateBMI()
	{
		double meters = height * 0.0254;
		double kg =  weight * 0.453592;
		BMI = kg / (meters * meters);
		
		if(BMI >= 25)
			bmiType = "overweight";
		else if (BMI >= 18.5 && BMI <= 24.9)
			bmiType = "normal";
		else
			bmiType = "underweight";
			
	}
	
	public int getStreak()
	{
		return streak;
	}
	public void incrementStreak()
	{
		streak++;
	}
	public void resetStreak()
	{
		streak = 0;
	}
	
}



