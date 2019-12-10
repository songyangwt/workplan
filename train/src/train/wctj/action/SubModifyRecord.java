package train.wctj.action;

import org.hibernate.Session;
import org.hibernate.Transaction;

import train.process.action.GetProcessByPosition;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import train.util.DateUtil;
import train.util.FileReadAndWrite;
import train.wctj.dao.ModifyRecordDAO;
import train.wctj.dao.WorkDataDAO;
import train.wctj.dao.WorkModifyDAO;
import train.wctj.pojo.ModifyRecord;
import train.wctj.pojo.WorkData;
import train.wctj.pojo.WorkModify;
import ccb.hibernate.HibernateSessionFactory;

public class SubModifyRecord {
	private String newnumber;
	private String message;

	private int workdataid;
	private int zu;
	private String remark;
	
	private String username;
	
	private String reason;
	private int worktype;
    private String location;
    private String city;
    
    
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getWorktype() {
		return worktype;
	}

	public void setWorktype(int worktype) {
		this.worktype = worktype;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	

	public int getWorkdataid() {
		return workdataid;
	}

	public void setWorkdataid(int workdataid) {
		this.workdataid = workdataid;
	}

	public int getZu() {
		return zu;
	}

	public void setZu(int zu) {
		this.zu = zu;
	}




	
	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String execute() throws Exception
	{
		
		UserInfoDAO uidao = new UserInfoDAO();
		ModifyRecordDAO wmdao = new ModifyRecordDAO();
		ModifyRecord wm = new ModifyRecord();
		FileReadAndWrite fraw = new FileReadAndWrite();
	  
		DateUtil du = new DateUtil();
	
//		int zhi = 0;
	
		String date = du.getStringDate();
		String index = "000";
	
		String number = "";
		String result = "success";
		
		message = "提交申请成功";
		

		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    
 	    //List<TZzzm> list = tzdao.findAllByDate(date);
 	    UserInfo ui = uidao.findByName(username);
 	    WorkDataDAO wddao = new WorkDataDAO();
 	    WorkData wd = wddao.findAllById(workdataid);
 	  
 	    /*if(!uiinitiator.getUsername().equals(username))
 	    {
 	    	dai=1;
 	    }
 	    else
 	    {
 	    	dai=0;
 	    }*/
 	   
 	    //zhi = Integer.parseInt(position.substring(0, 1));// 职务0主任1处长2团队负责人3小组长4普通员工
		
		//获得审批表编号
//		if (list.isEmpty()) {
//			number = date + "WCGG" + dai + bu + "001";
//		} else {
			//index = "000" + String.valueOf(list.size()+1);
			index = "000"+fraw.readandwrite("WCTJ");
			index = index.substring(index.length() - 3, index.length());
			number = date + "WCTJ" + index;
//		}
		//是否表中有重复项
		if(wmdao.findAllByNumber(number)!=null)
		{
			result = "failed";
			message = "提交失败，原因异常";
			trans.rollback();
			return result;
		}
	
		//获得公干流程编号
	
 	    wm.setApplicant(newnumber);
 	    wm.setDate(date);
 	    if((reason!="")&&(reason!=null))
 	    {
 	    	 wm.setReason(reason);	
 	    }
	 	
	    wm.setNumber(number);
	    wm.setWorktype(worktype);
	    wm.setWorkdataid(workdataid);
	    if((location!="")&&(location!=null))
 	    {
	    	 wm.setLocation(location);	
 	    }
	    if((city!="")&&(city!=null))
 	    {
	    	 wm.setCity(city);
 	    }
	   
	  
 	    	if(result.equals("success"))
 	    	{
 	    		wmdao.merge(wm);
 	    		if(worktype==1)
 	    		{
 	    			wd.setWorktype(worktype);
 	    		    wd.setReason("");
 	    		    wd.setCity("");
 	    		    wd.setLocation("");
 	    		}
 	    		if(worktype==2)
 	    		{
 	    			wd.setWorktype(worktype);
 	    		    wd.setReason(reason);
 	    		    wd.setCity("");
	    		    wd.setLocation("");
 	    		}
 	    		if(worktype==3)
 	    		{
 	    			wd.setWorktype(worktype);
 	    			 wd.setReason(reason);
 	    			 wd.setCity(city);
 	    			 wd.setLocation(location);
 	    		
 	    		}
 	    		wddao.merge(wd);
 	    		
 	    	}
 	    	else
 	    	{
 	    		trans.rollback();
	    		return result;
 	    	}
 	    	 trans.commit();
 			session.flush();
 			session.clear();
 			session.close();
 			
 			return result;
 	    	
 	    }
}
