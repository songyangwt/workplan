package train.wctj.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import train.userinfo.dao.UserInfoDAO;
import train.util.ExportExcel;
import train.util.LeaveUtil;
import train.util.UserUtil;
import train.util.Util;
import train.wctj.pojo.WorkData;
import train.wctj.pojo.WorkDataBean;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ExportWorkData {
	private static Logger logger = Logger.getLogger(ExportWorkData.class);
	private String begindate;
	private String enddate;
	private String Path;
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

	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}

	public String execute() throws Exception{
		String filePath = "";
		String bd="";
		String ed="";
		
		List<WorkData> list;
		UserInfoDAO uidao = new UserInfoDAO();
		List<WorkDataBean> wblist = new ArrayList<WorkDataBean>();
		ExportExcel<WorkDataBean> ex = new ExportExcel<WorkDataBean>();
		
		String[] headers = {"姓名","新一代编号","组别",
				"日期","星期","工作状态","理由","出差城市",
				"出差地点","备注"};
		Query query;
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		String hql = "from WorkData as wd where 1=1";
		if(begindate!=null&&!begindate.equals("")&&enddate!=null&&!enddate.equals(""))
		{
			bd = begindate.replace("-", "");
			ed = enddate.replace("-", "");
			hql += " and wd.date>='"+bd+"' and wd.date<='"+ed+"'";
		}
		
		hql += "  order by wd.id desc";
		System.out.println(hql);
		query = session.createQuery(hql);
		list = query.list();
		trans.commit();
		session.flush();
		session.clear();
		session.close();
		for(int i=0;i<list.size();i++)
		{
			WorkData wd = list.get(i);
			WorkDataBean wzb = new WorkDataBean();
			wzb.setNewnumber(wd.getNewnumber());
			wzb.setDate(wd.getDate());
			wzb.setCity(wd.getCity());
			wzb.setLocation(wd.getLocation());
			wzb.setName(wd.getName());
			wzb.setReason(wd.getReason());
			wzb.setRemark(wd.getRemark());
			wzb.setWeek(wd.getWeek());
			wzb.setWorktype( UserUtil.worktypeTostring(wd.getWorktype()));
			wzb.setZu(UserUtil.zunameTostring(wd.getZu()));
			
			wblist.add(wzb);
		}
		//导出
		 try {
			 	filePath=Util.downloadpath+"WorkData"+bd+"-"+ed+".xls";
			 	logger.info("导出路径"+filePath);
				Path = "WorkData"+bd+"-"+ed+".xls";
				OutputStream out = new FileOutputStream(filePath);
				ex.exportExcel("操作员人员明细表",headers, wblist, out);
				out.close();
				System.out.println("excel导出成功！");
				
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		return "success";
	}
}
