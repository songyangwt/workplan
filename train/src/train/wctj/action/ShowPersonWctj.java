package train.wctj.action;

import java.util.ArrayList;
import java.util.List;

import train.mycalendar.dao.CalendarDAO;
import train.mycalendar.pojo.Calendar;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import train.util.DateUtil;
import train.wctj.dao.WorkDataDAO;
import train.wctj.pojo.WorkData;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ShowPersonWctj {
	private static final Log log = LogFactory.getLog(WorkData.class);
	private String newnumber;// 新一代员工编号
	private List<WorkData> list;
	

	private String begindate;
	private String enddate;

	/**
	* 获得默认的分页大小
	*/
	private int pageSize = 8;

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
	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	
	

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


	public List<WorkData> getList() {
		return list;
	}

	public void setList(List<WorkData> list) {
		this.list = list;
	}



	public static Log getLog() {
		return log;
	}


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


	

	public String execute() throws Exception
	{
		String result = "success";
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = new UserInfo();
		WorkDataDAO wddao= new WorkDataDAO();
		WorkData wd = new WorkData();
		Query query;
		String hql = "";
		String bd = "";
		String ed = "";
	
		
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		try {
			ui = uidao.findByNewNumber(newnumber);
			wd = wddao.findByNewNumber(newnumber);
			CalendarDAO mcdao = new CalendarDAO();
		 	DateUtil du = new DateUtil();
			String datetoday = du.getDateNow();
			List<String> date = new ArrayList();
			Calendar mc = mcdao.findByDate(datetoday);
			date = mcdao.DateInList(mc);
			String datebegin = date.get(0);
		    int length = date.size();
		    String dateend = date.get(length-1);
			hql = "from WorkData as wd where wd.newnumber = '"+newnumber+"'";
		
		    hql += " and wd.date>='"+datebegin+"' and wd.date<='"+dateend+"'";
			
			
				
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
