package train.wctj.pojo;
// default package



/**
 * JieDiao entity. @author MyEclipse Persistence Tools
 */
public class JieDiao extends AbstractJieDiao implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public JieDiao() {
    }

    
    /** full constructor */
    public JieDiao(String name, Integer zu, String begindate, String enddate, String location, String reason, String department) {
        super(name, zu, begindate, enddate, location, reason, department);        
    }
   
}
