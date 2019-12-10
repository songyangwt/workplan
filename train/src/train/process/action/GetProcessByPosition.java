package train.process.action;

import train.userinfo.pojo.UserInfo;

public class GetProcessByPosition {

	public int getModifyProcess(String authority,int zu)
	{
		String authoA = authority.substring(0, 1);
		String authoB = authority.substring(1, 2);
		String authoC = authority.substring(2, 3);
		String authoD = authority.substring(3, 4);
		String authoE = authority.substring(4, 5);
		String authoF = authority.substring(5, 6);
		String authoG = authority.substring(6, 7);
		int process = 0;
		if(authoE!=null&&authoD.equals("E"))
		{
			if(zu==1||zu==2)
			{
				process = 1;
			}
			else if(zu==3||zu==4)
			{
				process=2;
			}
		}
		
		else if (authoF!=null&&authoF.equals("F"))
		{
			if(zu==1||zu==2)
			{
				process = 1;
			}
			else if(zu==3||zu==4)
			{
				process=2;
			}
		}
		else if (authoD!=null&&authoD.equals("D"))
		{
			if(zu==1||zu==2)
			{
				process = 1;
			}
			else if(zu==3||zu==4)
			{
				process=2;
			}
		}
	
		
		return process;
	}
	
	public int getNewModifyProcess(String thisunder)
	{
		int process =0 ;
		if(thisunder.equals("70808800"));
		{
			process = 1;
		}
		if(thisunder.equals("15813953"));
		{
			process = 2;
		}
		return process;
	}

}
