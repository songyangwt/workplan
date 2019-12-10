package train.wctj.pojo;
// default package



/**
 * ShenpiProcess entity. @author MyEclipse Persistence Tools
 */
public class ShenpiProcess extends AbstractShenpiProcess implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public ShenpiProcess() {
    }

    
    /** full constructor */
    public ShenpiProcess(String number, String time, String viewer, String viewernumber, String role, String authority, Integer opinion, String remark) {
        super(number, time, viewer, viewernumber, role, authority, opinion, remark);        
    }
   
}
