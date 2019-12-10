package train.wctj.action;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import train.util.DateUtil;
import train.wctj.pojo.WorkData;
import ccb.hibernate.HibernateSessionFactory;


public class ShowDetail {
	private static final Log log = LogFactory.getLog(WorkData.class);
	private String newnumber;// 新一代员工编号
	private List<WorkData> list;
	

	private int type;
	
	
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


	

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String execute() throws Exception
	{
		String result = "";
	    Query query;
		String hql = "";
	
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			
		
		 	DateUtil du = new DateUtil();
			String datetoday = du.getDateNow();
			
				hql = "from WorkData as wd where wd.worktype = '"+type+"' and wd.date= '"+datetoday+"'";
				hql += " order by wd.id desc";
			
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
		if(type==1)
		{
			return "success1";
		}
		else
		{
			return "success2";
		}
	}
	
		

}
