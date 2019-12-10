package train.wctj.pojo;
// default package



/**
 * AbstractModifyRecord entity provides the base persistence definition of the ModifyRecord entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractModifyRecord  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String number;
     private Integer workdataid;
     private Integer worktype;
     private String applicant;
     private String location;
     private String city;
     private String reason;
     private String date;


    // Constructors

    /** default constructor */
    public AbstractModifyRecord() {
    }

    
    /** full constructor */
    public AbstractModifyRecord(String number, Integer workdataid, Integer worktype, String applicant, String location, String city, String reason, String date) {
        this.number = number;
        this.workdataid = workdataid;
        this.worktype = worktype;
        this.applicant = applicant;
        this.location = location;
        this.city = city;
        this.reason = reason;
        this.date = date;
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

    public String getApplicant() {
        return this.applicant;
    }
    
    public void setApplicant(String applicant) {
        this.applicant = applicant;
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

    public String getReason() {
        return this.reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
   








}