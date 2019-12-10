package train.wctj.pojo;
// default package



/**
 * AbstractShenpiProcess entity provides the base persistence definition of the ShenpiProcess entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractShenpiProcess  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String number;
     private String time;
     private String viewer;
     private String viewernumber;
     private String role;
     private String authority;
     private Integer opinion;
     private String remark;


    // Constructors

    /** default constructor */
    public AbstractShenpiProcess() {
    }

    
    /** full constructor */
    public AbstractShenpiProcess(String number, String time, String viewer, String viewernumber, String role, String authority, Integer opinion, String remark) {
        this.number = number;
        this.time = time;
        this.viewer = viewer;
        this.viewernumber = viewernumber;
        this.role = role;
        this.authority = authority;
        this.opinion = opinion;
        this.remark = remark;
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

    public String getTime() {
        return this.time;
    }
    
    public void setTime(String time) {
        this.time = time;
    }

    public String getViewer() {
        return this.viewer;
    }
    
    public void setViewer(String viewer) {
        this.viewer = viewer;
    }

    public String getViewernumber() {
        return this.viewernumber;
    }
    
    public void setViewernumber(String viewernumber) {
        this.viewernumber = viewernumber;
    }

    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }

    public String getAuthority() {
        return this.authority;
    }
    
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Integer getOpinion() {
        return this.opinion;
    }
    
    public void setOpinion(Integer opinion) {
        this.opinion = opinion;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
   








}