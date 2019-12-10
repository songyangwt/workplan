package train.userinfo.action;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;

import ccb.hibernate.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionSupport;

public class UserPassModify extends ActionSupport {
	private int id;
	private String message;
	private String type;
	private String newnumber;
	private String username;
	private String oldpassword;
	private String newpassword1;
	private String newpassword2;
	private Session h_session;
    private Transaction trans;
    private String hql;
    private Query query;
    UserInfo entity=new UserInfo();
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	
	public String getNewpassword2() {
		return newpassword2;
	}
	public void setNewpassword2(String newpassword2) {
		this.newpassword2 = newpassword2;
	}
	public Session getH_session() {
		return h_session;
	}
	public void setH_session(Session hSession) {
		h_session = hSession;
	}
	public Transaction getTrans() {
		return trans;
	}
	public void setTrans(Transaction trans) {
		this.trans = trans;
	}
	public String getHql() {
		return hql;
	}
	public void setHql(String hql) {
		this.hql = hql;
	}
	public Query getQuery() {
		return query;
	}
	public void setQuery(Query query) {
		this.query = query;
	}
	
	
	
	public String getNewnumber() {
		return newnumber;
	}
	public void setNewnumber(String newnumber) {
		this.newnumber = newnumber;
	}
	public String getNewpassword1() {
		return newpassword1;
	}
	public void setNewpassword1(String newpassword1) {
		this.newpassword1 = newpassword1;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute() throws Exception
	{
		String hqltemp="";
		message="";
		try {
		  h_session=HibernateSessionFactory.getSession();
		  trans=h_session.beginTransaction();
		  hql="select user from UserInfo as user where user.newnumber=:u";
		  query=h_session.createQuery(hql);
		  
		  query.setString("u",newnumber);//设置查询参数
		//  query.setString("p",password);//设置查询参数
		 // System.out.println(username);
          List l=query.list();
   
     	  
     		  UserInfo u=(UserInfo)(l.get(0));
     		  id=u.getId();
     		  if(!oldpassword.equals(u.getPassword()))
     		  {
        			 this.addFieldError("用户","旧密码错误");
       			  	 return "false";
     		  } 
     		  else if(!newpassword1.equals(newpassword2))
     		  {
     			 this.addFieldError("用户","两次输入的密码不一致");
   			  	 return "false";
     		  }
     		  else if(newpassword1.length()<6||newpassword1.length()>20)
    		  {
    			 this.addFieldError("密码","密码长度应该在6-20之间");
  			  	 return "false";
    		  }
     		  else
     		  {
     			 hqltemp = "update UserInfo as ui set ui.password='"+newpassword1+"' where ui.id="+id;
     			 h_session.createQuery(hqltemp).executeUpdate();
     			 message="修改成功";
     		  }
			} catch (HibernateException e) {
			e.printStackTrace();
			trans.rollback();
			}finally{
				trans.commit();
				h_session.flush();
				h_session.clear();
				h_session.close();
			} 
//        	  HttpSession session=null;
//        	  session.setAttribute("user", this.getUsername());
        	  return "success";
     	  
     	 
	}
	
}
