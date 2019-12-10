package train.wctj.action;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import train.util.DateUtil;
import train.wctj.dao.WorkDataDAO;
import train.wctj.pojo.JieDiao;
import train.wctj.pojo.WaiChuDataBean;
import train.wctj.pojo.WorkData;
import ccb.hibernate.HibernateSessionFactory;

public class ShowAllData {
	private String newnumber;
	private String date;
    private int numtype1;
    private int numtype2;
    private int numtype3;
    private int numtype4;
    private int numtype5;
   

	private List<JieDiao>listjiediao;
	private List<WorkData>listwaichu;
	private List<WaiChuDataBean>listcity;
	private List<String> listtemp1;
	private List<Object> listtemp2;


	public List<WaiChuDataBean> getListcity() {
		return listcity;
	}



	public void setListcity(List<WaiChuDataBean> listcity) {
		this.listcity = listcity;
	}





	public List<JieDiao> getListjiediao() {
		return listjiediao;
	}



	public void setListjiediao(List<JieDiao> listjiediao) {
		this.listjiediao = listjiediao;
	}



	public List<WorkData> getListwaichu() {
		return listwaichu;
	}



	public void setListwaichu(List<WorkData> listwaichu) {
		this.listwaichu = listwaichu;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
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





	public String execute() throws Exception
	{
		Query query;
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    DateUtil du = new DateUtil();
 	    date = du.getDateNow();
 	    listcity=new ArrayList<WaiChuDataBean>();
 	   // UserInfo ui = new UserInfo();
 	   // UserInfoDAO uidao = new UserInfoDAO();
 	   // ui = uidao.findByNewNumber(newnumber);
 	   // int zu = ui.getZu();
 	   /* String authoA = ui.getAuthority().substring(0,1);
 	    String authoB = ui.getAuthority().substring(1,2);
 	    String authoC = ui.getAuthority().substring(2,3);
 	    String authoD = ui.getAuthority().substring(3,4);
 	    String authoE = ui.getAuthority().substring(4,5);
 	    String authoF = ui.getAuthority().substring(5,6);*/
 	    WorkDataDAO wddao = new WorkDataDAO();
 	    String hql1="";
 	  
 	    String hql3="";
 	    String hql4="";
 	    String message="success";
 	    
 	    	numtype1 = wddao.findByDateAndType(date, 1);//川投
 	 	    numtype2 = wddao.findByDateAndType(date, 2);//航天
 	 	    numtype3 = wddao.findByDateAndType(date, 5);//休假
 	 	    numtype4 = wddao.findByDateAndType(date, 3);//外出
 	 	    numtype5 = wddao.findByDateAndType(date, 4);//借调
 	 	  
 	    
 	   
 	    	hql1 = "from JieDiao as wd where wd.begindate<= '"+date+"' and wd.enddate>= '"+date+"'";
 	    	query = session.createQuery(hql1);
 	    	listjiediao = query.list();
 	    
 	  
 	 
 		   /* hql2 = "from LeaveInfo as wd where wd.begindate<= '"+date+"' and wd.enddate>= '"+date+"'";
	    	query = session.createQuery(hql2);
	    	listleave = query.list();*/
 	    	//hql3 = "select distinct (wd.city),count(wd.newnumber) from WorkData as wd where wd.worktype= 3 and wd.date= '"+date+"' group by wd.city";
	    	hql3 = "select distinct (wd.city) from WorkData as wd where wd.worktype= 3 and wd.date= '"+date+"' group by wd.city";
	    	hql4 = "select count(wd.city) from t_workdata as wd where wd.worktype= 3 and wd.date= '"+date+"' group by wd.city";
		    query = session.createQuery(hql3);
		    listtemp1 = query.list();
		   query = session.createSQLQuery(hql4);
		    listtemp2 = query.list();
 	    	
		    for(int i=0;i<listtemp1.size();i++)
			{
		    	String city = listtemp1.get(i);
		    	Object objects = listtemp2.get(i);
		    	String sum = objects.toString();
		    	WaiChuDataBean wb = new WaiChuDataBean();
		    	wb.setCity(city);
		    	wb.setSum(sum);
		    	listcity.add(wb);
			}
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return message;
	}
}
