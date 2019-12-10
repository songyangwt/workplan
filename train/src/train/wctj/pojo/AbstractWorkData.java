package train.wctj.pojo;
// default package



/**
 * AbstractWorkData entity provides the base persistence definition of the WorkData entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractWorkData  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String newnumber;
     private String date;
     private String week;
     private Integer worktype;
     private String location;
     private String reason;
     private Integer zu;
     private String city;
     private Integer leavetype;


    // Constructors

    /** default constructor */
    public AbstractWorkData() {
    }

    
    /** full constructor */
    public AbstractWorkData(String name, String newnumber, String date, String week, Integer worktype, String location, String reason, Integer zu, String city, Integer leavetype) {
        this.name = name;
        this.newnumber = newnumber;
        this.date = date;
        this.week = week;
        this.worktype = worktype;
        this.location = location;
        this.reason = reason;
        this.zu = zu;
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

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getNewnumber() {
        return this.newnumber;
    }
    
    public void setNewnumber(String newnumber) {
        this.newnumber = newnumber;
    }

    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    public String getWeek() {
        return this.week;
    }
    
    public void setWeek(String week) {
        this.week = week;
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

    public String getReason() {
        return this.reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getZu() {
        return this.zu;
    }
    
    public void setZu(Integer zu) {
        this.zu = zu;
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