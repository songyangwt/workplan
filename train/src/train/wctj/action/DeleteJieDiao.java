package train.wctj.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class DeleteJieDiao {
	private String jiediaoid;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getJiediaoid() {
		return jiediaoid;
	}

	public void setJiediaoid(String jiediaoid) {
		this.jiediaoid = jiediaoid;
	}

	public String execute() throws Exception
	{
		
		String sql = "delete from t_jiediao where id="+jiediaoid;
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
