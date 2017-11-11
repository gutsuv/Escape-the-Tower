// Gear objects

package Model;

import View.Console;

public class GearContent
{
	Console view;
	//String gearID;
	//String gearName;
	//String gearDesc;
	//String gearType;
	//String gearUse;

	int exampleId = 1;
	String exampleName = "name";
	String exampleDesc = "Description";
	String exampleType = "EX";
	String exampleUse = "Usage";

	int example2Id = 2;
	String example2Name = "name";
	String example2Desc = "Description";
	String example2Type = "EX";
	String example2Use = "Usage";

	int[] gearIdArray = {exampleId, example2Id};
	String[] gearNameArray = {exampleName, example2Name};
	String[] gearDescArray = {exampleDesc, example2Desc};
	String[] gearTypeArray = {exampleType, example2Type};
	String[] gearUseArray = {example2Use, example2Use};
	
	public int[] getGearId() 
	{
		return gearIdArray;
	}

	public void setGearId(int[] gearIdArray)
	{
		this.gearIdArray = gearIdArray;
	}

	public String[] getGearName() 
	{
		return gearNameArray;
	}

	public void setGearName(String[] gearNameArray)
	{
		this.gearNameArray = gearNameArray;
	}

	public String[] getGearDesc() 
	{
		return gearDescArray;
	}

	public void setGearDesc(String[] gearDescArray) 
	{
		this.gearDescArray = gearDescArray;
	}
	
	public String[] getGearType() 
	{
		return gearTypeArray;
	}

	public void setGearType(String[] gearTypeArray) 
	{
		this.gearTypeArray = gearTypeArray;
	}
	
	public String[] getGearUse() 
	{
		return gearUseArray;
	}

	public void setGearUse(String[] gearUseArray) 
	{
		this.gearUseArray = gearUseArray;
	}
}