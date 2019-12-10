package train.wctj.pojo;
// default package



/**
 * AbstractJieDiao entity provides the base persistence definition of the JieDiao entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractJieDiao  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private Integer zu;
     private String begindate;
     private String enddate;
     private String location;
     private String reason;
     private String department;


    // Constructors

    /** default constructor */
    public AbstractJieDiao() {
    }

    
    /** full constructor */
    public AbstractJieDiao(String name, Integer zu, String begindate, String enddate, String location, String reason, String department) {
        this.name = name;
        this.zu = zu;
        this.begindate = begindate;
        this.enddate = enddate;
        this.location = location;
        this.reason = reason;
        this.department = department;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Integer getZu() {
        return this.zu;
    }
    
    public void setZu(Integer zu) {
        this.zu = zu;
    }

    public String getBegindate() {
        return this.begindate;
    }
    
    public void setBegindate(String begindate) {
        this.begindate = begindate;
    }

    public String getEnddate() {
        return this.enddate;
    }
    
    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getLocation() {
        return this.location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }

    public String getReason() {
        return this.reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDepartment() {
        return this.department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
   








}