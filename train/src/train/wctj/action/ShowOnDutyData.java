package train.wctj.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import train.mycalendar.dao.CalendarDAO;
import train.mycalendar.pojo.Calendar;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import train.util.DateUtil;
import train.wctj.dao.WorkDataDAO;
import train.wctj.pojo.OnDuty;
import train.wctj.pojo.WorkData;
import ccb.hibernate.HibernateSessionFactory;

public class ShowOnDutyData {
	
	private static final Log log = LogFactory.getLog(WorkData.class);
	
	private List<OnDuty> list;
	private String begindate;
	private String enddate;
	private String name;
	
	private String strtemp;
	private int zhuan;
	
	
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



	/**
	* 获得默认的分页大小
	*/
	private int pageSize = 10;

	/**
	* 总页数
	*/
	private int totalPages = -1;

	/**
	* 当前页
	*/
	private int currentPage = -1;

	/**
	* 上一页
	*/
	private int previousPage = 1;

	/**
	* 下一页
	*/
	private int nextPage = 1;
	/**
	* 第一页
	*/
	private int firstPage = 1;
	/**
	* 最后一页
	*/
	private int lastPage = 1;
	/**
	* 总记录条数
	*/
	private long totalRows = -1;
	
	
	

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public long getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}


	

	public static Log getLog() {
		return log;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getStrtemp() {
		return strtemp;
	}

	public void setStrtemp(String strtemp) {
		this.strtemp = strtemp;
	}

	public int getZhuan() {
		return zhuan;
	}

	public void setZhuan(int zhuan) {
		this.zhuan = zhuan;
	}

	

	public List<OnDuty> getList() {
		return list;
	}

	public void setList(List<OnDuty> list) {
		this.list = list;
	}

	public String execute() throws Exception
	{
		String result = "success";
		
		String hql = "";
		Query query;
		String un = "";
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			
			hql = "from OnDuty as wd where 1=1";
			if(name!=null&&zhuan==1)
			{
				strtemp = new String(name.getBytes("ISO8859-1"),"UTF-8");
			}
			else
			{
				strtemp = name;
			}
			un = strtemp;
			if(un!=null&&!un.equals(""))
			{
				hql +="  and wd.name like '%"+un+"%'";
			}
			
			if(begindate!=null&&!begindate.equals("")&&enddate!=null&&!enddate.equals(""))
			{
				String bd = begindate.replaceAll("-", "");
				String ed = enddate.replaceAll("-", ""); 
				hql += " and wd.date>='"+bd+"' and wd.date<='"+ed+"'";
			}
		  
			
				
			hql += " order by wd.id desc";
			System.out.println(hql);
			query = session.createQuery(hql);
			query.setFirstResult(pageSize * (currentPage - 1));
			query.setMaxResults(pageSize);
			totalRows = session.createQuery(hql).list().size();
			initPageProperties();
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
		
		return result;
	}
	
		
		protected void initPageProperties() {

			if (totalRows == -1) {
				log.error("没有初始化totalRows参数！");
			}

			firstPage = 1;
			
			currentPage = currentPage <= 1 ? 1 : currentPage;

			totalPages = (totalRows % pageSize == 0) ? ((int) (totalRows / pageSize))
					: ((int) (totalRows / pageSize + 1));

			currentPage = currentPage >= totalPages ? totalPages : currentPage;

			previousPage = currentPage > 1 ? currentPage - 1 : 1;

			nextPage = currentPage < totalPages ? currentPage + 1 : totalPages;

			lastPage = totalPages;
		}

}
