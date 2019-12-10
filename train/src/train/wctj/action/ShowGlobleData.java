package train.wctj.action;

import java.util.List;

import train.process.action.GetProcessByPosition;
import train.process.dao.ProcessDAO;
import train.process.pojo.Process;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import train.util.DateUtil;
import train.wctj.dao.WorkDataDAO;
import train.wctj.pojo.WorkData;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ShowGlobleData {
	private String newnumber;
	private String date;
    private int numtype1;
    private int numtype2;
    private int numtype3;
    private int numtype4;
    private int numtype5;
    private int numtype6;
	private int sum;
	List<WorkData>list;
	


	public List<WorkData> getList() {
		return list;
	}



	public void setList(List<WorkData> list) {
		this.list = list;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public int getSum() {
		return sum;
	}



	public void setSum(int sum) {
		this.sum = sum;
	}



	public String getNewnumber() {
		return newnumber;
	}



	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}



	public int getNumtype1() {
		return numtype1;
	}



	public void setNumtype1(int numtype1) {
		this.numtype1 = numtype1;
	}



	public int getNumtype2() {
		return numtype2;
	}



	public void setNumtype2(int numtype2) {
		this.numtype2 = numtype2;
	}



	public int getNumtype3() {
		return numtype3;
	}



	public void setNumtype3(int numtype3) {
		this.numtype3 = numtype3;
	}



	public int getNumtype4() {
		return numtype4;
	}



	public void setNumtype4(int numtype4) {
		this.numtype4 = numtype4;
	}



	public int getNumtype5() {
		return numtype5;
	}



	public void setNumtype5(int numtype5) {
		this.numtype5 = numtype5;
	}



	public int getNumtype6() {
		return numtype6;
	}



	public void setNumtype6(int numtype6) {
		this.numtype6 = numtype6;
	}



	public String execute() throws Exception
	{
		Query query;
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    DateUtil du = new DateUtil();
 	    date = du.getDateNow();
 	    UserInfo ui = new UserInfo();
 	    UserInfoDAO uidao = new UserInfoDAO();
 	    ui = uidao.findByNewNumber(newnumber);
 	    int zu = ui.getZu();
 	    String authoA = ui.getAuthority().substring(0,1);
 	    String authoB = ui.getAuthority().substring(1,2);
 	    String authoC = ui.getAuthority().substring(2,3);
 	    String authoD = ui.getAuthority().substring(3,4);
 	    String authoE = ui.getAuthority().substring(4,5);
 	    String authoF = ui.getAuthority().substring(5,6);
 	    WorkDataDAO wddao = new WorkDataDAO();
 	    String hql="";
 	    String message="";
 	    if((authoA!=null&&authoA.equals("A"))||(authoE!=null&&authoE.equals("E"))||(authoB!=null&&authoB.equals("B"))||(authoC!=null&&authoC.equals("C")))
 	    {
 	    	numtype1 = wddao.findByDateAndType(date, 1);
 	 	    numtype2 = wddao.findByDateAndType(date, 2);
 	 	    numtype3 = wddao.findByDateAndType(date, 3);
 	 	    numtype4 = wddao.findByDateAndType(date, 4);
 	 	    numtype5 = wddao.findByDateAndType(date, 5);
 	 	    numtype6 = wddao.findByDateAndType(date, 6);
 	 	    sum = numtype1+numtype2+numtype3+numtype4+numtype5+numtype6;
 	 	    message="globalall";
 	    }
 	    else if ((authoD!=null&&authoD.equals("D")))
 	    {
 	    	hql = "from WorkData as wd where wd.date= '"+date+"' and wd.zu = "+zu;
 	    	query = session.createQuery(hql);
 	    	list = query.list();
 	    	message="globalzu";
 	    }
 	    else if ((authoF!=null&&authoF.equals("F")))
	    {
 		    hql = "from WorkData as wd where wd.date= '"+date+"' and wd.newnumber = '"+newnumber+"'";
	    	query = session.createQuery(hql);
	    	list = query.list();
	    	message="globalperson";
	    }
 	  
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return message;
	}
}
