package train.wctj.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import train.wctj.dao.JieDiaoDAO;
import train.wctj.dao.LeaveInfoDAO;
import train.wctj.pojo.JieDiao;
import train.wctj.pojo.LeaveInfo;
import ccb.hibernate.HibernateSessionFactory;

public class ShowLeaveModifyPage {
    private int leaveid;
    private LeaveInfo wc ;
    
	










	public int getLeaveid() {
		return leaveid;
	}


	public void setLeaveid(int leaveid) {
		this.leaveid = leaveid;
	}



	public LeaveInfo getWc() {
		return wc;
	}

	public void setWc(LeaveInfo wc) {
		this.wc = wc;
	}


	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    LeaveInfoDAO wcdao = new LeaveInfoDAO();
 	    wc = wcdao.findAllById(leaveid);
 	   	   
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
}
