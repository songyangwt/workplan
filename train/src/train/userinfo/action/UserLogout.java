package train.userinfo.action;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;

@Entity
public class UserLogout {

	public String execute(HttpServletRequest request) throws Exception{
		request.getSession().removeAttribute("username");
		request.getSession().removeAttribute("no");
		//System.out.print("--------"+ActionContext.getContext().getSession().get("username"));
		return "success";
	}
}
