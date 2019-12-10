package train.wctj.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import train.wctj.pojo.WorkModify;

/**
 	* A data access object (DAO) providing persistence and search support for WorkModify entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .WorkModify
  * @author MyEclipse Persistence Tools 
 */

public class WorkModifyDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(WorkModifyDAO.class);
		//property constants
	public static final String NUMBER = "number";
	public static final String PROCESS = "process";
	public static final String JINDU = "jindu";
	public static final String DATE = "date";
	public static final String STATUS = "status";
	public static final String PREUNDER = "preunder";
	public static final String THISUNDER = "thisunder";
	public static final String INITIATOR = "initiator";
	public static final String APPLICANT = "applicant";
	public static final String ZU = "zu";
	public static final String REASON = "reason";
	public static final String REMARK = "remark";
	public static final String WORKDATAID = "workdataid";
	public static final String WORKTYPE = "worktype";
	public static final String LOCATION = "location";
	public static final String CITY = "city";
	public static final String LEAVETYPE = "leavetype";



    
    public void save(WorkModify transientInstance) {
        log.debug("saving WorkModify instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(WorkModify persistentInstance) {
        log.debug("deleting WorkModify instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public WorkModify findById( java.lang.Integer id) {
        log.debug("getting WorkModify instance with id: " + id);
        try {
            WorkModify instance = (WorkModify) getSession()
                    .get("WorkModify", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(WorkModify instance) {
        log.debug("finding WorkModify instance by example");
        try {
            List results = getSession()
                    .createCriteria("WorkModify")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding WorkModify instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from WorkModify as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByNumber(Object number
	) {
		return findByProperty(NUMBER, number
		);
	}
	
	public List findByProcess(Object process
	) {
		return findByProperty(PROCESS, process
		);
	}
	
	public List findByJindu(Object jindu
	) {
		return findByProperty(JINDU, jindu
		);
	}
	
	public List findByDate(Object date
	) {
		return findByProperty(DATE, date
		);
	}
	
	public List findByStatus(Object status
	) {
		return findByProperty(STATUS, status
		);
	}
	
	public List findByPreunder(Object preunder
	) {
		return findByProperty(PREUNDER, preunder
		);
	}
	
	public List findByThisunder(Object thisunder
	) {
		return findByProperty(THISUNDER, thisunder
		);
	}
	
	public List findByInitiator(Object initiator
	) {
		return findByProperty(INITIATOR, initiator
		);
	}
	
	public List findByApplicant(Object applicant
	) {
		return findByProperty(APPLICANT, applicant
		);
	}
	
	public List findByZu(Object zu
	) {
		return findByProperty(ZU, zu
		);
	}
	
	public List findByReason(Object reason
	) {
		return findByProperty(REASON, reason
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	
	public List findByWorkdataid(Object workdataid
	) {
		return findByProperty(WORKDATAID, workdataid
		);
	}
	
	public List findByWorktype(Object worktype
	) {
		return findByProperty(WORKTYPE, worktype
		);
	}
	
	public List findByLocation(Object location
	) {
		return findByProperty(LOCATION, location
		);
	}
	
	public List findByCity(Object city
	) {
		return findByProperty(CITY, city
		);
	}
	
	public List findByLeavetype(Object leavetype
	) {
		return findByProperty(LEAVETYPE, leavetype
		);
	}
	

	public List findAll() {
		log.debug("finding all WorkModify instances");
		try {
			String queryString = "from WorkModify";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public WorkModify merge(WorkModify detachedInstance) {
        log.debug("merging WorkModify instance");
        try {
            WorkModify result = (WorkModify) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(WorkModify instance) {
        log.debug("attaching dirty WorkModify instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(WorkModify instance) {
        log.debug("attaching clean WorkModify instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public WorkModify findAllByNumber(String number) {
    	log.debug("finding all WorkModify instances");
    	try {
    		String queryString = "from WorkModify as wm where wm.number=:u";
             Query queryObject = getSession().createQuery(queryString);
             queryObject.setString("u",number);
             List<WorkModify> list= queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 WorkModify wm = (WorkModify) list.get(0);
    			 return wm;
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    } 
}