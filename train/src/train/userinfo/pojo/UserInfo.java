package train.userinfo.pojo;
// default package



/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */
public class UserInfo extends AbstractUserInfo implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public UserInfo() {
    }

    
    /** full constructor */
    public UserInfo(String newnumber, String username, String password, Integer zu, String authority) {
        super(newnumber, username, password, zu, authority);        
    }
   
}
