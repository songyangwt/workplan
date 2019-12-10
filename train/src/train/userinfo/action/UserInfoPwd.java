package train.userinfo.action;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;

import ccb.hibernate.HibernateSessionFactory;
public class UserInfoPwd {
	private UserInfo ui;
	private int id;
	


	public UserInfo getUi() {
		return ui;
	}

	public void setUi(UserInfo ui) {
		this.ui = ui;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    UserInfoDAO uidao=new UserInfoDAO();
 	    ui = uidao.findAllById(id);
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
