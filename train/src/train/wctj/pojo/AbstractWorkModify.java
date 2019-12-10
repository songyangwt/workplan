package train.wctj.pojo;
// default package



/**
 * AbstractWorkModify entity provides the base persistence definition of the WorkModify entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractWorkModify  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String number;
     private Integer process;
     private String jindu;
     private String date;
     private Integer status;
     private String preunder;
     private String thisunder;
     private String initiator;
     private String applicant;
     private Integer zu;
     private String reason;
     private String remark;
     private Integer workdataid;
     private Integer worktype;
     private String location;
     private String city;
     private Integer leavetype;


    // Constructors

    /** default constructor */
    public AbstractWorkModify() {
    }

    
    /** full constructor */
    public AbstractWorkModify(String number, Integer process, String jindu, String date, Integer status, String preunder, String thisunder, String initiator, String applicant, Integer zu, String reason, String remark, Integer workdataid, Integer worktype, String location, String city, Integer leavetype) {
        this.number = number;
        this.process = process;
        this.jindu = jindu;
        this.date = date;
        this.status = status;
        this.preunder = preunder;
        this.thisunder = thisunder;
        this.initiator = initiator;
        this.applicant = applicant;
        this.zu = zu;
        this.reason = reason;
        this.remark = remark;
        this.workdataid = workdataid;
        this.worktype = worktype;
        this.location = location;
        this.city = city;
        this.leavetype = leavetype;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return this.number;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getProcess() {
        return this.process;
    }
    
    public void setProcess(Integer process) {
        this.process = process;
    }

    public String getJindu() {
        return this.jindu;
    }
    
    public void setJindu(String jindu) {
        this.jindu = jindu;
    }

    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPreunder() {
        return this.preunder;
    }
    
    public void setPreunder(String preunder) {
        this.preunder = preunder;
    }

    public String getThisunder() {
        return this.thisunder;
    }
    
    public void setThisunder(String thisunder) {
        this.thisunder = thisunder;
    }

    public String getInitiator() {
        return this.initiator;
    }
    
    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public String getApplicant() {
        return this.applicant;
    }
    
    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public Integer getZu() {
        return this.zu;
    }
    
    public void setZu(Integer zu) {
        this.zu = zu;
    }

    public String getReason() {
        return this.reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getWorkdataid() {
        return this.workdataid;
    }
    
    public void setWorkdataid(Integer workdataid) {
        this.workdataid = workdataid;
    }

    public Integer getWorktype() {
        return this.worktype;
    }
    
    public void setWorktype(Integer worktype) {
        this.worktype = worktype;
    }

    public String getLocation() {
        return this.location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    public Integer getLeavetype() {
        return this.leavetype;
    }
    
    public void setLeavetype(Integer leavetype) {
        this.leavetype = leavetype;
    }
   








}