package train.wctj.pojo;
// default package



/**
 * AbstractLeaveInfo entity provides the base persistence definition of the LeaveInfo entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractLeaveInfo  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Integer leavetype;
     private String name;
     private String newnumber;
     private String begindate;
     private String enddate;
     private String remark;


    // Constructors

    /** default constructor */
    public AbstractLeaveInfo() {
    }

    
    /** full constructor */
    public AbstractLeaveInfo(Integer leavetype, String name, String newnumber, String begindate, String enddate, String remark) {
        this.leavetype = leavetype;
        this.name = name;
        this.newnumber = newnumber;
        this.begindate = begindate;
        this.enddate = enddate;
        this.remark = remark;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLeavetype() {
        return this.leavetype;
    }
    
    public void setLeavetype(Integer leavetype) {
        this.leavetype = leavetype;
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

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}