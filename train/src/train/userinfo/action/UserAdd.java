package train.userinfo.action;

import javax.servlet.http.HttpServletResponse;

import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import ccb.hibernate.HibernateSessionFactory;

public class UserAdd extends ActionSupport implements ServletResponseAware {
	private static final long serialVersionUID = 1L;
	private String newnumber;
    private String name;
    private String password; 
    private String zu;
    private String role;
    private String message;
    
   
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		UserInfo uitemp = new UserInfo();
		
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 		uitemp=uidao.findByName(name);
		if(uitemp!=null)
		{
			this.addFieldError("用户","姓名已存在");
		  	 return "failed";
		}
		uitemp=uidao.findByNewNumber(newnumber);
		if(uitemp!=null)
		{
			this.addFieldError("用户","新一代编号已存在");
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
		
		  else if(password==null||password.equals(""))
		  {
			 this.addFieldError("用户","密码为空");
		  	 return "failed";
		  }
		 
		  else if(password.length()<6||password.length()>20)
		  {
			 this.addFieldError("密码","密码长度应该在6-20之间");
		  	 return "failed";
		  }
				  /*else if(zu.equals(""))
		  {
			 this.addFieldError("用户","班组为空");
		  	 return "false";
		  }*/
		  else if(role.equals("wu")||role.equals(""))
		  {
			 this.addFieldError("用户","角色权限为空");
		  	 return "failed";
		  }
	
 	     if(zu==null||zu.equals("wu"))
	     {
		  this.addFieldError("用户","组别为空");
		  	 return "failed";
	      }
 	  
 	    ui.setNewnumber(newnumber);
 	    ui.setUsername(name);
 	    ui.setPassword(password);
 	    ui.setZu(Integer.valueOf(zu));
 	    ui.setAuthority(roletoautho(role));
 	  
 	    uidao.merge(ui);
 	    message="添加成功";
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
