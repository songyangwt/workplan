package train.process.action;

import java.util.ArrayList;
import java.util.List;

import train.process.action.GetProcessByPosition;
import train.wctj.dao.WorkModifyDAO;
import train.wctj.pojo.WorkModify;

import org.hibernate.Session;
import org.hibernate.Transaction;

import train.process.dao.ProcessDAO;
import train.process.pojo.*;
import train.process.pojo.Process;

import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;

public class FindNextUnder {

	public List<UserInfo> findNextUnder(String item,String number)
	{
		ProcessDAO pdao = new ProcessDAO();
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = new UserInfo();
		GetProcessByPosition gpbp = new GetProcessByPosition();
		Process p = new Process();
		
		List<UserInfo> list = new ArrayList<UserInfo>();
		
		String newnumber = "";//实际请假/公干人新员工工号
		String proc = "";// 完整流程
		String jindu = "";// 当前进度
		String under = "无";
		int zu = 0;
		
		int length = 0;//当前进度长度
		int applicant = 0;
		if(item.equals("WCTJ"))
		{
			WorkModifyDAO wmdao = new WorkModifyDAO();
			WorkModify wm = wmdao.findAllByNumber(number);
			newnumber = wm.getApplicant();
			applicant = wm.getProcess();
			jindu = wm.getJindu();
		}
		
	
		ui = uidao.findByNewNumber(newnumber);
		
		length = jindu.length();
		p = pdao.findByItemAndApplicant(item, applicant);
		proc = p.getProcess();
		if((length+1)<proc.length())//如果有下一个审批人 // EDCB
		{
			under = proc.substring(length+1,length+2);//EDCBA
		
		zu = ui.getZu();
		UserInfo uitemp = new UserInfo();
		if(zu==1||zu==2)
		{
			uitemp = uidao.findByName("李沛钊");
	
		}
		if(zu==3||zu==4)
		{
			uitemp = uidao.findByName("刘咏梅");
		}
		list.add(uitemp);
		}
		return list;
	}
		
	
}
