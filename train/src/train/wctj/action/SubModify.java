package train.wctj.action;

import train.process.action.GetProcessByPosition;

import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import train.util.DateUtil;
import train.util.FileReadAndWrite;
import train.wctj.dao.WorkModifyDAO;
import train.wctj.pojo.WorkModify;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class SubModify {

	private String newnumber;
	private String message;

	private int workdataid;
	private int zu;
	private String remark;
	private String thisunder;
	private String username;
	private String initiator;
	private String reason;
	private int worktype;
    private String location;
    
    
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

	public String getInitiator() {
		return initiator;
	}

	public void setInitiator(String initiator) {
		this.initiator = initiator;
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

	private int dai;


	
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

	

	public String getThisunder() {
		return thisunder;
	}

	public void setThisunder(String thisunder) {
		this.thisunder = thisunder;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}



	public int getDai() {
		return dai;
	}

	public void setDai(int dai) {
		this.dai = dai;
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
		WorkModifyDAO wmdao = new WorkModifyDAO();
		WorkModify wm = new WorkModify();
		FileReadAndWrite fraw = new FileReadAndWrite();
	    GetProcessByPosition gpbp = new GetProcessByPosition();
		DateUtil du = new DateUtil();
	
//		int zhi = 0;
		
		int process = 0;
	
		String date = du.getStringDate();
		String index = "000";
	
		String number = "";
		String result = "success";
		String position = "";
		message = "提交申请成功";
		

		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 	    
 	    //List<TZzzm> list = tzdao.findAllByDate(date);
 	    UserInfo ui = uidao.findByName(username);
 	    zu=ui.getZu();
 	    UserInfo uiinitiator = uidao.findByNewNumber(initiator);//发起人
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
			number = date + "WCTJ" + dai + index;
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
		process = gpbp.getNewModifyProcess(thisunder);
		if(process==0)
		{
			result = "failed";
			message = "您不需要填此表";
		}
		
		if(dai==1)
		{
			remark = remark+"("+uiinitiator.getUsername()+"代为申请)";
		}
 	
 	    wm.setApplicant(newnumber);
 	    wm.setDate(date);
 	    wm.setInitiator(initiator);
 	    wm.setJindu("E");
 	    wm.setStatus(1);
	    wm.setPreunder("");
	    wm.setThisunder(thisunder);
	    wm.setReason(reason);
	    wm.setRemark(remark);
	    wm.setZu(zu);
	    wm.setNumber(number);
	    wm.setProcess(process);
	    wm.setWorktype(worktype);
	    wm.setWorkdataid(workdataid);
	    wm.setLocation(location);
 	    	if(result.equals("success"))
 	    	{
 	    		wmdao.merge(wm);
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
