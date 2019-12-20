package train.wctj.pojo;
// default package



/**
 * WorkData entity. @author MyEclipse Persistence Tools
 */
public class WorkData extends AbstractWorkData implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public WorkData() {
    }

    
    /** full constructor */
    public WorkData(String name, String newnumber, String date, String week, Integer worktype, String location, String reason, Integer zu, String city, Integer leavetype, String remark) {
        super(name, newnumber, date, week, worktype, location, reason, zu, city, leavetype, remark);        
    }
   
}
