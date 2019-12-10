package train.wctj.pojo;
// default package



/**
 * ModifyRecord entity. @author MyEclipse Persistence Tools
 */
public class ModifyRecord extends AbstractModifyRecord implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public ModifyRecord() {
    }

    
    /** full constructor */
    public ModifyRecord(String number, Integer workdataid, Integer worktype, String applicant, String location, String city, String reason, String date) {
        super(number, workdataid, worktype, applicant, location, city, reason, date);        
    }
   
}
