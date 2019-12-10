package train.wctj.action;

import java.util.List;

import train.process.action.FindNextUnder;
import train.process.dao.ProcessDAO;
import train.process.pojo.Process;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import train.util.DateUtil;
import train.wctj.dao.ShenpiProcessDAO;
import train.wctj.dao.WorkModifyDAO;
import train.wctj.pojo.ShenpiProcess;
import train.wctj.pojo.WorkModify;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ShowShenpiDetail {
	private String number;
	private String undersign;
	private WorkModify wm;
	private String newnumber;
	private List<ShenpiProcess> listlp;
	private List<UserInfo> listui;
	private int youshenpi;
	private String position;
	private UserInfo ui;
	private String time;
	private String dai;
    private String username;
    
    

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public WorkModify getWm() {
		return wm;
	}
	public void setWm(WorkModify wm) {
		this.wm = wm;
	}
	public List<ShenpiProcess> getListlp() {
		return listlp;
	}
	public void setListlp(List<ShenpiProcess> listlp) {
		this.listlp = listlp;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getUndersign() {
		return undersign;
	}
	public void setUndersign(String undersign) {
		this.undersign = undersign;
	}

	public List<UserInfo> getListui() {
		return listui;
	}
	public void setListui(List<UserInfo> listui) {
		this.listui = listui;
	}
	public int getYoushenpi() {
		return youshenpi;
	}
	public void setYoushenpi(int youshenpi) {
		this.youshenpi = youshenpi;
	}
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	public String getDai() {
		return dai;
	}
	public void setDai(String dai) {
		this.dai = dai;
	}
	public UserInfo getUi() {
		return ui;
	}
	public void setUi(UserInfo ui) {
		this.ui = ui;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public String execute() throws Exception
	{
		DateUtil du = new DateUtil();
		WorkModifyDAO wmdao = new WorkModifyDAO();
		ShenpiProcessDAO lpdao = new ShenpiProcessDAO();
		FindNextUnder fnu = new FindNextUnder();
		ProcessDAO pdao = new ProcessDAO();
		UserInfoDAO uidao = new  UserInfoDAO();
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    wm = wmdao.findAllByNumber(number);
 	
	    dai=wm.getNumber().substring(12, 13);
 	    
 	    listlp = lpdao.findAllByNumber(number);
 	  	listui = fnu.findNextUnder("WCTJ", number);
 	  	ui = uidao.findByNewNumber(wm.getApplicant());
		
 	  	Process p = pdao.findByItemAndApplicant("WCTJ",wm.getProcess());
 	  	time = du.getDate();
 	  	int jindulength = wm.getJindu().length();
 	  	String proc = p.getProcess();
 	  	
 	  	undersign = proc.substring(jindulength, jindulength+1);
 	  	
 	  	if(listui.isEmpty())
 	  	{
 	  		youshenpi = 0;
 	  	}
 	  	else
 	  	{
 	  		youshenpi = 1;
 	  	}
 	 
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
