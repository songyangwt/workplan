package train.userinfo.pojo;
// default package



/**
 * AbstractUserInfo entity provides the base persistence definition of the UserInfo entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUserInfo  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String newnumber;
     private String username;
     private String password;
     private Integer zu;
     private String authority;


    // Constructors

    /** default constructor */
    public AbstractUserInfo() {
    }

    
    /** full constructor */
    public AbstractUserInfo(String newnumber, String username, String password, Integer zu, String authority) {
        this.newnumber = newnumber;
        this.username = username;
        this.password = password;
        this.zu = zu;
        this.authority = authority;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewnumber() {
        return this.newnumber;
    }
    
    public void setNewnumber(String newnumber) {
        this.newnumber = newnumber;
    }

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getZu() {
        return this.zu;
    }
    
    public void setZu(Integer zu) {
        this.zu = zu;
    }

    public String getAuthority() {
        return this.authority;
    }
    
    public void setAuthority(String authority) {
        this.authority = authority;
    }
   








}