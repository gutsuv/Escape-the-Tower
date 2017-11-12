package Model;

import View.Console;

public class EnemyContent 
{
	public Console view;
	
	String enemyDesc;

	Enemy enemy0;
	Enemy enemy1;
	Enemy enemy2;
	Enemy enemy3;
	Enemy enemy4;
	Enemy enemy5;
	Enemy enemy6;
	Enemy enemy7;
	Enemy enemy8;
	Enemy enemy9;
	Enemy enemy10;
	
	String enemyName0 = "Ex";
	String enemyName1 = "Ex";
	String enemyName2 = "Ex";
	String enemyName3 = "Ex";
	String enemyName4 = "Ex";
	String enemyName5 = "Ex";
	String enemyName6 = "Ex";
	String enemyName7 = "Ex";
	String enemyName8 = "Ex";
	String enemyName9 = "Ex";
	String enemyName10 = "Ex";

	String[] enemyNames = {enemyName0, enemyName1, enemyName2, 
			enemyName3, enemyName4, enemyName5, enemyName6, 
			enemyName7, enemyName8, enemyName9, enemyName10};

	int enemyId0 = 1;
	int enemyId1 = 1;
	int enemyId2 = 1;
	int enemyId3 = 1;
	int enemyId4 = 1;
	int enemyId5 = 1;
	int enemyId6 = 1;
	int enemyId7 = 1;
	int enemyId8 = 1;
	int enemyId9 = 1;
	int enemyId10 = 1;

	String enemyDesc0 = "Example Desc";
	String enemyDesc1 = "Example Desc";
	String enemyDesc2 = "Example Desc";
	String enemyDesc3 = "Example Desc";
	String enemyDesc4 = "Example Desc";
	String enemyDesc5 = "Example Desc";
	String enemyDesc6 = "Example Desc";
	String enemyDesc7 = "Example Desc";
	String enemyDesc8 = "Example Desc";
	String enemyDesc9 = "Example Desc";
	String enemyDesc10 = "Example Desc";


	String[] enemyDescs = {enemyDesc0, enemyDesc1, enemyDesc2,
			enemyDesc3, enemyDesc4, enemyDesc5, enemyDesc6,
			enemyDesc7, enemyDesc8, enemyDesc9, enemyDesc10,};


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

	int enemyHP0 = 0;
	int enemyHP1 = 0;
	int enemyHP2 = 0;
	int enemyHP3 = 0;
	int enemyHP4 = 0;
	int enemyHP5 = 0;
	int enemyHP6 = 0;
	int enemyHP7 = 0;
	int enemyHP8 = 0;
	int enemyHP9 = 0;
	int enemyHP10 = 0;
	
	int enemyAtk0 = 0;
	int enemyAtk1 = 0;
	int enemyAtk2 = 0;
	int enemyAtk3 = 0;
	int enemyAtk4 = 0;
	int enemyAtk5 = 0;
	int enemyAtk6 = 0;
	int enemyAtk7 = 0;
	int enemyAtk8 = 0;
	int enemyAtk9 = 0;
	int enemyAtk10 = 0;

	int enemyDef0 = 0;
	int enemyDef1 = 0;
	int enemyDef2 = 0;
	int enemyDef3 = 0;
	int enemyDef4 = 0;
	int enemyDef5 = 0;
	int enemyDef6 = 0;
	int enemyDef7 = 0;
	int enemyDef8 = 0;
	int enemyDef9 = 0;
	int enemyDef10 = 0;

	boolean enemyAliveStatus0 = true;
	boolean enemyAliveStatus1 = true;
	boolean enemyAliveStatus2 = true;
	boolean enemyAliveStatus3 = true;
	boolean enemyAliveStatus4 = true;
	boolean enemyAliveStatus5 = true;
	boolean enemyAliveStatus6 = true;
	boolean enemyAliveStatus7 = true;
	boolean enemyAliveStatus8 = true;
	boolean enemyAliveStatus9 = true;
	boolean enemyAliveStatus10 = true;


	public void setEnemyDesc(int enemy)
	{
		switch (enemy)
		{
			case 0: enemyDesc = enemyDesc0;
			break;
			case 1: enemyDesc = enemyDesc1;
			break;
			case 2: enemyDesc = enemyDesc2; 
			break;
			case 3: enemyDesc = enemyDesc3;
			break;
			case 4: enemyDesc = enemyDesc4;
			break;
			case 5: enemyDesc = enemyDesc5;
			break;
			case 6: enemyDesc = enemyDesc6;
			break;
			case 7: enemyDesc = enemyDesc7;
			break;
			case 8: enemyDesc = enemyDesc8;
			break;
			case 9: enemyDesc = enemyDesc9;
			break;
			case 10: enemyDesc = enemyDesc10;
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
		if(enemy == 0)
		{
			view.println(enemyDesc0);
		}
		else if(enemy == 1)
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
		else if(enemy == 4)
		{
			view.println(enemyDesc4);
		}
		else if(enemy == 5)
		{
			view.println(enemyDesc5);
		}
		else if(enemy == 6)
		{
			view.println(enemyDesc6);
		}
		else if(enemy == 7)
		{
			view.println(enemyDesc7);
		}
		else if(enemy == 8)
		{
			view.println(enemyDesc8);
		}
		else if(enemy == 9)
		{
			view.println(enemyDesc9);
		}
		else if(enemy == 10)
		{
			view.println(enemyDesc10);
		}
	}
}