package train.wctj.action;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import train.util.DateUtil;
import train.wctj.pojo.WorkData;
import ccb.hibernate.HibernateSessionFactory;


public class FindDetailByZu {
	private static final Log log = LogFactory.getLog(WorkData.class);
	private String newnumber;// 新一代员工编号
	private List<WorkData> list;
	private int zu;
	private String date;
	
	
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


	public List<WorkData> getList() {
		return list;
	}

	public void setList(List<WorkData> list) {
		this.list = list;
	}



	public static Log getLog() {
		return log;
	}

	public int getZu() {
		return zu;
	}

	public void setZu(int zu) {
		this.zu = zu;
	}

	public String execute() throws Exception
	{
		
	    Query query;
		String hql = "";
		
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			
		
		 	DateUtil du = new DateUtil();
		 	 if(date==null||date=="")
		 	    {
		 	    	 date = du.getDateNow();
		 	    }
		 	 date = date.replaceAll("-", "");
			
			
				hql = "from WorkData as wd where wd.zu= '"+zu+"' and wd.date= '"+date+"'";
				hql += "  order by wd.zu desc";
			
			System.out.println(hql);
			query = session.createQuery(hql);		
			list = query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		
		return "success";
	
	}
}
