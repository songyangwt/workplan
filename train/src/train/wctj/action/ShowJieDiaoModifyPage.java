package train.wctj.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import train.process.action.GetProcessByPosition;
import train.process.dao.ProcessDAO;
import train.process.pojo.Process;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import train.wctj.dao.JieDiaoDAO;
import train.wctj.dao.WorkDataDAO;
import train.wctj.pojo.JieDiao;
import train.wctj.pojo.WorkData;
import ccb.hibernate.HibernateSessionFactory;

public class ShowJieDiaoModifyPage {

    private int jiediaoid;
    private JieDiao wc ;
    
	




	public int getJiediaoid() {
		return jiediaoid;
	}

	public void setJiediaoid(int jiediaoid) {
		this.jiediaoid = jiediaoid;
	}

	public JieDiao getWc() {
		return wc;
	}

	public void setWc(JieDiao wc) {
		this.wc = wc;
	}






	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    JieDiaoDAO wcdao = new JieDiaoDAO();
 	    wc = wcdao.findAllById(jiediaoid);
 	   	   
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
}
