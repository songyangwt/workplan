package train.wctj.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import train.wctj.dao.JieDiaoDAO;
import train.wctj.dao.LeaveInfoDAO;
import train.wctj.pojo.JieDiao;
import train.wctj.pojo.LeaveInfo;
import ccb.hibernate.HibernateSessionFactory;

public class SubLeaveModify {
	  private int leaveid;
	  private String begindate;
	  private String enddate;
	  private int leavetype;
	  private String message;
	  



	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getBegindate() {
		return begindate;
	}


	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}


	public String getEnddate() {
		return enddate;
	}


	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}




public int getLeaveid() {
		return leaveid;
	}


	public void setLeaveid(int leaveid) {
		this.leaveid = leaveid;
	}


	public int getLeavetype() {
		return leavetype;
	}


	public void setLeavetype(int leavetype) {
		this.leavetype = leavetype;
	}


public String execute() throws Exception
{
	Session session = HibernateSessionFactory.getSession();
	    Transaction trans = session.beginTransaction();
	    message="提交申请成功";
	    LeaveInfoDAO wcdao = new LeaveInfoDAO();
	    LeaveInfo wc = wcdao.findAllById(leaveid);
	   	 if((begindate!=null)&&(begindate!=""))
	   	 {
	   		 wc.setBegindate(begindate);
	   	 }
	   	 if((enddate!=null)&&(enddate!=""))
	   	 {
	   		 wc.setEnddate(enddate);
	   	 }
	   	 if(leavetype!=0)
	   	 {
	   		 wc.setLeavetype(leavetype);
	   	 }
	  
	   	 wcdao.merge(wc);
	    trans.commit();
	session.flush();
	session.clear();
	session.close();
	
	return "success";
}
}
