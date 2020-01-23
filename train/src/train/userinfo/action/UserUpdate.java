package train.userinfo.action;

import javax.servlet.http.HttpServletResponse;

import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import ccb.hibernate.HibernateSessionFactory;

public class UserUpdate  extends ActionSupport implements ServletResponseAware  {
	private String newnumber;
    private String name;
    private String zu;
    private String role;
    private int paraid;
    private String message;
    
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getParaid() {
		return paraid;
	}

	public void setParaid(int paraid) {
		this.paraid = paraid;
	}


	public String getNewnumber() {
		return newnumber;
	}

	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getZu() {
		return zu;
	}

	public void setZu(String zu) {
		this.zu = zu;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
	}
	public String execute() throws Exception
	{
		UserInfoDAO uidao=new UserInfoDAO();
		UserInfo ui =new UserInfo();
		
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	   
 	    ui= uidao.findAllById(paraid);
 	  
 	   if(zu==null||zu.equals("wu"))
 	    {
 		  this.addFieldError("用户","组别为空");
		  	 return "failed";
 	    }
 	    if(ui==null)
 	    {
 	    	this.addFieldError("用户","修改错误");
		  	 return "failed";
 	    }
	
 	    if(newnumber==null||newnumber.equals(""))
		  {
 			 this.addFieldError("用户","新一代编号为空");
			  	 return "failed";
		  } 
		  else if(name==null||name.equals(""))
		  {
			 this.addFieldError("用户","姓名为空");
		  	 return "failed";
		  }
		
		  /*else if(zu.equals(""))
		  {
			 this.addFieldError("用户","班组为空");
		  	 return "false";
		  }*/
		  else if(role==null||role.equals("")||role.equals("wu"))
		  {
			 this.addFieldError("用户","角色权限为空");
		  	 return "failed";
		  }
		 
 	    String position="";
 	
 	    ui.setNewnumber(newnumber);
 	    ui.setUsername(name);
 	    ui.setZu(Integer.valueOf(zu));
 	    ui.setAuthority(roletoautho(role));
 	  
 	   	uidao.merge(ui);
 	    message="修改成功";
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		return "success";
	}
	 public static String roletoautho(String role)
	    {
	    	String autho="";
	    	if(role.equals("A"))
	    	{
	    		autho="A000000";
	    	}
	    	if(role.equals("B"))
	    	{
	    		autho="0B00000";
	    	}
	    	if(role.equals("C"))
	    	{
	    		autho="00C00000";
	    	}
	    	if(role.equals("D"))
	    	{
	    		autho="000D000";
	    	}
	    	if(role.equals("E"))
	    	{
	    		autho="0000E00";
	    	}
	    	if(role.equals("F"))
	    	{
	    		autho="00000F0";
	    	}
	    	if(role.equals("G"))
	    	{
	    		autho="000000G";
	    	}
	    	
	    	return autho;
	    }
		 
}
