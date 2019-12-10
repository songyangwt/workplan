package train.wctj.action;


import train.log.dao.OperateLogDAO;
import train.log.pojo.OperateLog;
import train.process.dao.ProcessDAO;
import train.process.pojo.Process;

import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import train.util.DateUtil;
import train.util.LeaveUtil;
import train.wctj.dao.ShenpiProcessDAO;
import train.wctj.dao.WorkDataDAO;
import train.wctj.dao.WorkModifyDAO;
import train.wctj.pojo.ShenpiProcess;
import train.wctj.pojo.WorkData;
import train.wctj.pojo.WorkModify;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class Shenpi {
	private String thisunder;
	private String xuanze;
	private String number;
	private String textfield;
	private String radio;
	private String message;
	private String thisnewnumber;
	private String thisundername;
	public String getThisunder() {
		return thisunder;
	}
	public void setThisunder(String thisunder) {
		this.thisunder = thisunder;
	}
	public String getXuanze() {
		return xuanze;
	}
	public void setXuanze(String xuanze) {
		this.xuanze = xuanze;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getTextfield() {
		return textfield;
	}
	public void setTextfield(String textfield) {
		this.textfield = textfield;
	}
	public String getRadio() {
		return radio;
	}
	public void setRadio(String radio) {
		this.radio = radio;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getThisnewnumber() {
		return thisnewnumber;
	}
	public void setThisnewnumber(String thisnewnumber) {
		this.thisnewnumber = thisnewnumber;
	}
	public String getThisundername() {
		return thisundername;
	}
	public void setThisundername(String thisundername) {
		this.thisundername = thisundername;
	}
	public String execute() throws Exception
	{
		String result = "success";
		message = "审批成功";
		//Timestamp time = new Timestamp(System.currentTimeMillis()); 
		WorkModifyDAO wmdao = new WorkModifyDAO() ;
	
		DateUtil du = new DateUtil();
		ShenpiProcessDAO lprodao = new ShenpiProcessDAO();
		ShenpiProcess lpro = new ShenpiProcess();//审批意见写在leaveprocess中
		UserInfoDAO uidao = new UserInfoDAO();
		ProcessDAO pdao = new ProcessDAO();
		OperateLogDAO oldao = new OperateLogDAO();//记录日志
		OperateLog ol = new OperateLog();
		String time = du.getSimpleDateTime();
		if(radio==null)
		{
			message = "失败！请选择审批意见";
			return "success";
		}
		if(xuanze!=null&&xuanze.contains("选择")&&radio.equals("agree"))
		{
			message = "失败！请选择下一级审批人";
			return "success";
		}
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans=session.beginTransaction();
 		try {
 			UserInfo ui = uidao.findByNewNumber(thisnewnumber);
 			WorkModify wm = wmdao.findAllByNumber(number);
 			Process p = pdao.findByItemAndApplicant("WCTJ", wm.getProcess());
 			String proc = p.getProcess();//完整请假流程
 			String jindu = wm.getJindu();
 			String under = wm.getThisunder();//当前审批人
 			ol.setItem("WCTJ");
 			ol.setName(thisundername);
 			ol.setNewnumber(thisnewnumber);
 			ol.setTime(du.getDateTime());
 			ol.setRemark(number);
 			
 			lpro.setNumber(number);
 			lpro.setTime(time);
 			lpro.setViewer(thisundername);
 			lpro.setViewernumber(thisnewnumber);
 			lpro.setAuthority(thisunder);
 			lpro.setRemark(textfield);
 			if((thisnewnumber.substring(0,8)).equals(under))
 			{
 				if(radio.equals("agree"))//审批人决定//1 通过 2 不通过
 				{
 				lpro.setOpinion(1);
 				if((proc.length()-jindu.length())==1)//BOSS审批完毕，进入待报道状态
 				{
 					wm.setJindu(proc);
 					wm.setStatus(4);
 					wm.setThisunder(null);//
 					changeworkdata(wm);
 					//wpdao.submitWcggPage(number);//更新汇总表
 					ol.setOperate("审批完毕,"+LeaveUtil.NewNumberToNameNoSession(wm.getApplicant())+"已更新");
 					oldao.merge(ol);
 				}
 				else
 				{
 					wm.setThisunder(xuanze);
 					wm.setJindu(wm.getJindu()+thisunder);
 					wm.setStatus(2);//流转中状态
 				}
 				wm.setPreunder(thisnewnumber);
 				}
 				else
 				{
 				lpro.setOpinion(2);
 				wm.setStatus(5);//修改为已退回状态
 				wm.setPreunder(null);
 				wm.setThisunder(null);//下一处理人是自己
 				wm.setJindu(wm.getJindu().substring(0,1));
 				}
 				lprodao.merge(lpro);
 			
 	 			wmdao.merge(wm);
 			}
 			else
 			{
 				message = "失败！，您已经审批过该事项或您没有该事项审批权限！";
 			}
 			
 		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			trans.rollback();
		}finally{
			trans.commit();
			session.flush();
			session.clear();
			session.close();
		}
		
		return result;
	}
	
	void changeworkdata(WorkModify wm)
	{
		WorkDataDAO wddao = new WorkDataDAO();
		WorkData wd = wddao.findAllById(wm.getWorkdataid());
		wd.setWorktype(wm.getWorktype());
		wd.setLocation(wm.getLocation());
		wd.setReason(wm.getReason());
	}
}
