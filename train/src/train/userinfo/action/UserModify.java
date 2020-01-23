package train.userinfo.action;

import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class UserModify {
	private UserInfo ui;
	private int id;

	private int zu;
    private String role;


	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
	public int getZu() {
		return zu;
	}

	public void setZu(int zu) {
		this.zu = zu;
	}

	public UserInfo getUi() {
		return ui;
	}

	public void setUi(UserInfo ui) {
		this.ui = ui;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String execute() throws Exception
	{
		Query query;
		String hql="";
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    UserInfoDAO uidao=new UserInfoDAO();
 	    ui = uidao.findAllById(id);
 	  
 	    zu=ui.getZu();
 	    role=ui.getAuthority();
 	    String authoA=role.substring(0,1);
 	   String authoB=role.substring(1,2);
 	  String authoC=role.substring(2,3);
 	 String authoD=role.substring(3,4);
 	String authoE=role.substring(4,5);
 	String authoF=role.substring(5,6);
 	String authoG=role.substring(6,7);
 	if(authoA.equals("A"))
 	{
 		role="A";
 	}
	if(authoB.equals("B"))
 	{
 		role="B";
 	}
	if(authoC.equals("C"))
 	{
 		role="C";
 	}
	if(authoD.equals("D"))
 	{
 		role="D";
 	}
	if(authoE.equals("E"))
 	{
 		role="E";
 	}
	if(authoF.equals("F"))
 	{
 		role="F";
 	}
	if(authoG.equals("G"))
 	{
 		role="G";
 	}
 	   
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
}
