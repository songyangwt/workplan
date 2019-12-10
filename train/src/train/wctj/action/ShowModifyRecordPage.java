package train.wctj.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import train.wctj.dao.WorkDataDAO;
import train.wctj.pojo.WorkData;
import ccb.hibernate.HibernateSessionFactory;

public class ShowModifyRecordPage {

	
	private UserInfo ui;
    private int workdataid;
    private WorkData wd ;
    
	
	public WorkData getWd() {
		return wd;
	}

	public void setWd(WorkData wd) {
		this.wd = wd;
	}


	
	public int getWorkdataid() {
		return workdataid;
	}

	public void setWorkdataid(int workdataid) {
		this.workdataid = workdataid;
	}


	public UserInfo getUi() {
		return ui;
	}

	public void setUi(UserInfo ui) {
		this.ui = ui;
	}


	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    
 	    UserInfoDAO uidao = new UserInfoDAO();
 	    WorkDataDAO wddao = new WorkDataDAO();
 	    wd = wddao.findById(workdataid);
 	 
 	    ui = uidao.findByNewNumber(wd.getNewnumber());
 	   
 	  
 	   
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
}
