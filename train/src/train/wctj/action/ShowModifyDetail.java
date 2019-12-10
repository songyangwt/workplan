package train.wctj.action;

import java.util.List;

import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import train.util.DateUtil;
import train.wctj.dao.ShenpiProcessDAO;
import train.wctj.dao.WorkModifyDAO;
import train.wctj.pojo.ShenpiProcess;
import train.wctj.pojo.WorkModify;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ShowModifyDetail {
	private String number;
	private String newnumber;
	private WorkModify wm;
	private List<ShenpiProcess> listlp;

	private UserInfo ui;
	private String time;
	
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	
	public WorkModify getWm() {
		return wm;
	}
	public void setWm(WorkModify wm) {
		this.wm = wm;
	}
	public List<ShenpiProcess> getListlp() {
		return listlp;
	}
	public void setListlp(List<ShenpiProcess> listlp) {
		this.listlp = listlp;
	}
	public UserInfo getUi() {
		return ui;
	}
	public void setUi(UserInfo ui) {
		this.ui = ui;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String execute() throws Exception
	{
		WorkModifyDAO wmdao = new WorkModifyDAO();
		DateUtil du = new DateUtil();
        
		ShenpiProcessDAO lpdao = new ShenpiProcessDAO();
		UserInfoDAO uidao = new  UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    
 	    wm= wmdao.findAllByNumber(number);
 	    time = du.getDate();
 	    listlp = lpdao.findAllByNumber(number);
 	    ui = uidao.findByNewNumber(wm.getApplicant());
	
 	   
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
