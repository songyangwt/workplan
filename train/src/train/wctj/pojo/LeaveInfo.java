package train.wctj.pojo;
// default package



/**
 * LeaveInfo entity. @author MyEclipse Persistence Tools
 */
public class LeaveInfo extends AbstractLeaveInfo implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public LeaveInfo() {
    }

    
    /** full constructor */
    public LeaveInfo(Integer leavetype, String name, String newnumber, String begindate, String enddate, String remark) {
        super(leavetype, name, newnumber, begindate, enddate, remark);        
    }
   
}
