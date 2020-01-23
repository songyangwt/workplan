package train.wctj.pojo;
// default package



/**
 * AbstractOnDuty entity provides the base persistence definition of the OnDuty entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractOnDuty  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String date;
     private String remark;


    // Constructors

    /** default constructor */
    public AbstractOnDuty() {
    }

    
    /** full constructor */
    public AbstractOnDuty(String name, String date, String remark) {
        this.name = name;
        this.date = date;
        this.remark = remark;
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

    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}