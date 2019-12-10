package train.mycalendar.pojo;
// default package



/**
 * AbstractCalendar entity provides the base persistence definition of the Calendar entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCalendar  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String date;
     private Integer week;
     private Integer workday;
     private String remark;


    // Constructors

    /** default constructor */
    public AbstractCalendar() {
    }

    
    /** full constructor */
    public AbstractCalendar(String date, Integer week, Integer workday, String remark) {
        this.date = date;
        this.week = week;
        this.workday = workday;
        this.remark = remark;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    public Integer getWeek() {
        return this.week;
    }
    
    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getWorkday() {
        return this.workday;
    }
    
    public void setWorkday(Integer workday) {
        this.workday = workday;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}