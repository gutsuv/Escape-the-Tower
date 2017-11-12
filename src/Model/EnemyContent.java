package Model;

import View.Console;

public class EnemyContent 
{
	public Console view;
	
	String enemyDesc;

	Enemy enemy1;
	Enemy enemy2;
	Enemy enemy3;
	
	String enemyName1 = "Ex";
	String enemyName2 = "Ex";
	String enemyName3 = "Ex";

	String[] enemyNames = {enemyName1, enemyName2, enemyName3};

	int enemyId1 = 1;
	int enemyId2 = 1;
	int enemyId3 = 1;

	String enemyDesc1 = "Example Desc";
	String enemyDesc2 = "Example Desc";
	String enemyDesc3 = "Example Desc";


	String[] enemyDescs = {enemyDesc1, enemyDesc2, enemyDesc3};


	public String[] getEnemyName() 
	{
		return enemyNames;
	}


	public void setEnemyName(String[] enemyNames) 
	{
		this.enemyNames = enemyNames;
	}

	public String[] getEnemyDescs()
	{
		return enemyDescs;
	}
	
	public void setMonsterDesc(String[] enemyDescs) 
	{
		this.enemyDescs = enemyDescs;
	}

	int enemyHP1 = 32;
	int enemyHP2 = 32;
	int enemyHP3 = 32;
	
	int enemyAtk1 = 12;
	int enemyAtk2 = 12;
	int enemyAtk3 = 12;

	int enemyDef1 = 16;
	int enemyDef2 = 16;
	int enemyDef3 = 16;

	boolean enemyAliveStatus1 = false;
	boolean enemyAliveStatus2 = false;
	boolean enemyAliveStatus3 = false;


	public void setEnemyDesc(int enemy)
	{
		switch (enemy)
		{
			case 1: enemyDesc = enemyDesc1;
			break;
			case 2: enemyDesc = enemyDesc2; 
			break;
			case 3: enemyDesc = enemyDesc3;
			break;
			case 0: enemyDesc = "No enemies";
			break;
			default: enemyDesc = "No enemies";
			break;
		}
	}

	public String getEnemyDesc() 
	{
		return enemyDesc;
	} 

	public void examineEnemy(int enemy)
	{
		if(enemy == 1)
		{
			view.println(enemyDesc1);
		}
		else if(enemy == 2)
		{
			view.println(enemyDesc2);
		}
		else if(enemy == 3)
		{
			view.println(enemyDesc3);
		}
	}
}