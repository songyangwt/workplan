package train.userinfo.action;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.servlet.http.HttpServletResponse;

import train.config.dao.ConfigDAO;
import train.config.pojo.Config;
import train.util.DateUtil;


import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import train.userinfo.pojo.UserInfo;
import ccb.hibernate.HibernateSessionFactory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Entity
public class UserLogin extends ActionSupport implements ServletResponseAware{
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
	private Session h_session;
    private Transaction trans;
    private String hql;
    private Query query;
    private int errNum = 0;
    private int restNum;
  
    
    Timestamp d = new Timestamp(System.currentTimeMillis());
    
   

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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Session getSession() {
		return h_session;
	}


	public void setSession(Session h_session) {
		this.h_session = h_session;
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
     public void setServletResponse(HttpServletResponse response)
       {
       }

	public String execute() throws Exception
	{
	/*固定写法*/
		DateUtil du = new DateUtil();
		ConfigDAO cfgdao = new ConfigDAO();
		  int views = 0;//访问量统计
		  h_session=HibernateSessionFactory.getSession();
		  trans=h_session.beginTransaction();
		 // ifKQQSDisabled(h_session);//考勤缺失
		  Config config = cfgdao.findAllByName("times");
		  hql="from UserInfo as user where user.username=:u";
		  query=h_session.createQuery(hql);
		  query.setString("u",username);//设置查询参数
		//  query.setString("p",password);//设置查询参数
		  System.out.println(username+":"+hql);
          List l=query.list();
     	  if((l==null)||(l.size()<=0))
     	  {
     		  this.addFieldError("用户","用户不存在!");
			  return "false";
     	  }
     	  else 
     	  {
     		  UserInfo u=(UserInfo)(l.get(0));
     		  id=u.getId();
     		  username = this.getUsername();
     		  password = this.getPassword();
     		  System.out.print("username:"+username);
     		  System.out.print("password:"+password);
     		  System.out.print("DBpwd:"+u.getPassword());
     		 if(ActionContext.getContext().getSession().get(username) == null)
 			 {
 				 errNum = 0;
 			 }
 			 else{
 				 errNum=(Integer)ActionContext.getContext().getSession().get(username);
 			 }
 			 System.out.print(ActionContext.getContext().getSession().get(username));
 			 if(errNum>=5)
 			 {
 				this.addFieldError("用户","该用户已经被锁定,请找管理员解锁");
				return "false";
 			 }
     		  if(!password.equals(u.getPassword()))
     		  {
     			 if(errNum==0)
        		  {
        			 errNum = errNum+1;
        			 ActionContext.getContext().getSession().put(username,errNum);  
        			 this.addFieldError("用户","你已经输入错误1次，还有4次");
       			  	 return "false";
        		  }
     			 else 
     			 {
     					restNum = 5-errNum;
     					this.addFieldError("用户","你已经输入错误"+errNum+"次，还有"+restNum+"次");
     					errNum = errNum+1;
     					ActionContext.getContext().getSession().put(username,errNum);  
     					return "false";
     			 }
     			
     		  }
     		
     		  
     		  System.out.print("time1"+d);
        	  ActionContext.getContext().getSession().put("username",u.getUsername());
       
        	  ActionContext.getContext().getSession().put("zu",u.getZu());//30303
        	  ActionContext.getContext().getSession().put("id",id);
        
        	  ActionContext.getContext().getSession().put("newnumber",u.getNewnumber());
        	
        	  ActionContext.getContext().getSession().put("authoA",u.getAuthority().substring(0,1));
        	  ActionContext.getContext().getSession().put("authoB",u.getAuthority().substring(1,2));
        	  ActionContext.getContext().getSession().put("authoC",u.getAuthority().substring(2,3));
        	  ActionContext.getContext().getSession().put("authoD",u.getAuthority().substring(3,4));
        	  ActionContext.getContext().getSession().put("authoE",u.getAuthority().substring(4,5));
        	  ActionContext.getContext().getSession().put("authoF",u.getAuthority().substring(5,6));
        	  ActionContext.getContext().getSession().put("authoG",u.getAuthority().substring(6,7));
        	  
        	  config.setValue(config.getValue()+1);
        	  ActionContext.getContext().getSession().put("views",config.getValue());
        	  cfgdao.merge(config);
        	  //访问量统计
//        	  HttpSession session=null;
//        	  session.setAttribute("user", this.getUsername());
        	  trans.commit();
        	  h_session.flush();
        	  h_session.clear();
        	  h_session.close();
        	  return "success";
     	  }
     	 
	}
}
