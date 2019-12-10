package train.wctj.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import train.wctj.dao.JieDiaoDAO;
import train.wctj.pojo.JieDiao;
import ccb.hibernate.HibernateSessionFactory;

public class SubJieDiaoModify {
	  private int jiediaoid;
	  private String begindate;
	  private String enddate;
	  private String location;
	  private String reason;
	  private String department;
	  private String message;
	  
	  
public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


public int getJiediaoid() {
		return jiediaoid;
	}


	public void setJiediaoid(int jiediaoid) {
		this.jiediaoid = jiediaoid;
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




	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


public String execute() throws Exception
{
	Session session = HibernateSessionFactory.getSession();
	    Transaction trans = session.beginTransaction();
	    message="提交申请成功";
	    JieDiaoDAO wcdao = new JieDiaoDAO();
	    JieDiao wc = wcdao.findAllById(jiediaoid);
	   	 if((begindate!=null)&&(begindate!=""))
	   	 {
	   		 wc.setBegindate(begindate);
	   	 }
	   	 if((enddate!=null)&&(enddate!=""))
	   	 {
	   		 wc.setEnddate(enddate);
	   	 }
	   	 if((reason!=null)&&(reason!=""))
	   	 {
	   		 wc.setReason(reason);
	   	 }
	   	 if((location!=null)&&(location!=""))
	   	 {
	   		 wc.setLocation(location);
	   	 }
	   	 if((department!=null)&&(department!=""))
	   	 {
	   		 wc.setDepartment(department);
	   	 }
	   	 wcdao.merge(wc);
	    trans.commit();
	session.flush();
	session.clear();
	session.close();
	
	return "success";
}
}
