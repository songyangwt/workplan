package train.wctj.action;

import java.util.ArrayList;
import java.util.List;

import train.mycalendar.dao.CalendarDAO;
import train.mycalendar.pojo.Calendar;
import train.process.action.GetProcessByPosition;
import train.process.dao.ProcessDAO;
import train.process.pojo.Process;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import train.util.DateUtil;
import train.wctj.dao.WorkDataDAO;
import train.wctj.pojo.GlobalDataBean;
import train.wctj.pojo.WorkData;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ccb.dao.BaseHibernateDAO;


import org.hibernate.LockMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ccb.hibernate.HibernateSessionFactory;

public class ShowGlobalDetail {
	
    private int worktype;
	private String newnumber;
	private List<GlobalDataBean> listdetail;
	
	


	public List<GlobalDataBean> getListdetail() {
		return listdetail;
	}


	public void setListdetail(List<GlobalDataBean> listdetail) {
		this.listdetail = listdetail;
	}


	public int getWorktype() {
		return worktype;
	}


	public void setWorktype(int worktype) {
		this.worktype = worktype;
	}


	public String getNewnumber() {
		return newnumber;
	}


	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}





	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    
 	    UserInfoDAO uidao = new UserInfoDAO();
 	    WorkDataDAO wddao = new WorkDataDAO();
 	    CalendarDAO mcdao = new CalendarDAO();
 	    DateUtil du = new DateUtil();
	    String datetoday = du.getDateNow();
	    List<String> date = new ArrayList();
	    Calendar mc = mcdao.findByDate(datetoday);
	    date = mcdao.DateInList(mc);
 	    listdetail = wddao.findByDateAndTypeToString(date, worktype, datetoday);
 	    
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	
	}
	
	

}
