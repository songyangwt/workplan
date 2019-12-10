package train.wctj.action;

import java.util.List;

import train.process.action.GetProcessByPosition;
import train.process.dao.ProcessDAO;
import train.process.pojo.Process;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;
import train.wctj.dao.WorkDataDAO;
import train.wctj.pojo.WorkData;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;

public class ShowModifyPage {
	private String initiator;
	private List<UserInfo> list;
	private UserInfo ui;
    private int workdataid;
    private WorkData wd ;
    
	
	public WorkData getWd() {
		return wd;
	}

	public void setWd(WorkData wd) {
		this.wd = wd;
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

	public List<UserInfo> getList() {
		return list;
	}

	public void setList(List<UserInfo> list) {
		this.list = list;
	}

	public UserInfo getUi() {
		return ui;
	}

	public void setUi(UserInfo ui) {
		this.ui = ui;
	}


	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
 	    Transaction trans = session.beginTransaction();
 	    
 	    UserInfoDAO uidao = new UserInfoDAO();
 	    WorkDataDAO wddao = new WorkDataDAO();
 	    wd = wddao.findById(workdataid);
 	    GetProcessByPosition gpbp = new GetProcessByPosition();
 	    ProcessDAO pdao = new ProcessDAO();
 	    int process = 0;
 	    ui = uidao.findByNewNumber(wd.getNewnumber());
 	   
 	    String thisunder = "";
 	    process = gpbp.getModifyProcess(ui.getAuthority(),ui.getZu());
 	    Process p = pdao.findByItemAndApplicant("WCTJ", process);
 	    if(p!=null)
 	    {
 	    	thisunder = p.getProcess().substring(1, 2);//EDCA
 	    	list = uidao.findByThisunder(thisunder,wd.getZu());
 	    }
 	   
 	    trans.commit();
		session.flush();
		session.clear();
		session.close();
		
		return "success";
	}
}
