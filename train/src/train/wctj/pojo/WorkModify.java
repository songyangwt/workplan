package train.wctj.pojo;
// default package



/**
 * WorkModify entity. @author MyEclipse Persistence Tools
 */
public class WorkModify extends AbstractWorkModify implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public WorkModify() {
    }

    
    /** full constructor */
    public WorkModify(String number, Integer process, String jindu, String date, Integer status, String preunder, String thisunder, String initiator, String applicant, Integer zu, String reason, String remark, Integer workdataid, Integer worktype, String location, String city, Integer leavetype) {
        super(number, process, jindu, date, status, preunder, thisunder, initiator, applicant, zu, reason, remark, workdataid, worktype, location, city, leavetype);        
    }
   
}
