package train.wctj.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class DeleteLeave {
	private String leaveid;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

	public String getLeaveid() {
		return leaveid;
	}

	public void setLeaveid(String leaveid) {
		this.leaveid = leaveid;
	}

	public String execute() throws Exception
	{
		
		String sql = "delete from t_leaveinfo where id="+leaveid;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		session.createSQLQuery(sql).executeUpdate();
		message="删除成功";
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
