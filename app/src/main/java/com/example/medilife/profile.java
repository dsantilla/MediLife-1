package com.example.medilife;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;

/**
 * profile.java
 * A profile class written for the MediLife app 'profile' screen
 * Written By Nicolas Stefanelli
 */

public class profile
{
	private static final profile PROFILE = new profile();

	String name;
	int age;
	double weight;
	double height;
	double BMI;
	String bmiType = "normal";
	int level = 1;
	int experience = 0;
	int experience_needed = 1000;
	int streak = 0;

	private profile()
	{
		name = "name";
		age = 0;
		weight = 0;
		height = 0;
	}

	public static profile getInstance()
	{
		return PROFILE;
	}


	public String getName()
	{
		return name;
	}
	public void setName(String n)
	{
		name = n;
	}
	public int getAge() {return age;}
	public void setAge(int a){age = a;}
	public double getWeight()
	{
		return weight;
	}
	public void setWeight(double w)
	{
		weight = w;
	}
	public double getHeight()
	{
		return height;
	}
	public void setHeight(double h)
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
	
	public String calculateBMI()
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

		String temp = "Your BMI is: " + Math.round(BMI * 100) / 100 + ".\nThis is " + bmiType + ". ";
		return temp;
			
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

	public String displayLevel()
	{
		return ("Level: " + level + " " + experience + "/" + experience_needed);
	}

}



