package com.example.medilife;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * profile.java
 * A profile class written for the MediLife app 'profile' screen
 * Written By Nicolas Stefanelli
 */

public class profile implements Parcelable
{
	String name; 
	int age;
	int weight;
	int height;
	double BMI;
	String bmiType = "normal";
	int level = 1;
	int experience = 0;
	int experience_needed = 1000;
	int streak = 0;

	public profile()
	{
		name = "name";
		age = 0;
		weight = 0;
		height = 0;
	}

	protected profile(Parcel in) {
		name = in.readString();
		age = in.readInt();
		weight = in.readInt();
		height = in.readInt();
		BMI = in.readDouble();
		bmiType = in.readString();
		level = in.readInt();
		experience = in.readInt();
		experience_needed = in.readInt();
		streak = in.readInt();
	}

	public static final Creator<profile> CREATOR = new Creator<profile>() {
		@Override
		public profile createFromParcel(Parcel in) {
			return new profile(in);
		}

		@Override
		public profile[] newArray(int size) {
			return new profile[size];
		}
	};

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

	public String displayLevel()
	{
		return ("Level: " + level + " " + experience + "/" + experience_needed);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name);
		dest.writeInt(age);
		dest.writeInt(weight);
		dest.writeInt(height);
		dest.writeDouble(BMI);
		dest.writeString(bmiType);
		dest.writeInt(level);
		dest.writeInt(experience);
		dest.writeInt(experience_needed);
		dest.writeInt(streak);
	}
}



