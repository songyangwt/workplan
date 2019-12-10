package train.mycalendar.pojo;
// default package



/**
 * Calendar entity. @author MyEclipse Persistence Tools
 */
public class Calendar extends AbstractCalendar implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Calendar() {
    }

    
    /** full constructor */
    public Calendar(String date, Integer week, Integer workday, String remark) {
        super(date, week, workday, remark);        
    }
   
}
