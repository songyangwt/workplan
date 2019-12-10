package train.wctj.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import train.wctj.pojo.ModifyRecord;
import train.wctj.pojo.WorkModify;

/**
 	* A data access object (DAO) providing persistence and search support for ModifyRecord entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .ModifyRecord
  * @author MyEclipse Persistence Tools 
 */

public class ModifyRecordDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ModifyRecordDAO.class);
		//property constants
	public static final String NUMBER = "number";
	public static final String WORKDATAID = "workdataid";
	public static final String WORKTYPE = "worktype";
	public static final String APPLICANT = "applicant";
	public static final String LOCATION = "location";
	public static final String CITY = "city";
	public static final String REASON = "reason";
	public static final String DATE = "date";



    
    public void save(ModifyRecord transientInstance) {
        log.debug("saving ModifyRecord instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ModifyRecord persistentInstance) {
        log.debug("deleting ModifyRecord instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ModifyRecord findById( java.lang.Integer id) {
        log.debug("getting ModifyRecord instance with id: " + id);
        try {
            ModifyRecord instance = (ModifyRecord) getSession()
                    .get("ModifyRecord", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ModifyRecord instance) {
        log.debug("finding ModifyRecord instance by example");
        try {
            List results = getSession()
                    .createCriteria("ModifyRecord")
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
      log.debug("finding ModifyRecord instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ModifyRecord as model where model." 
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
	
	public List findByApplicant(Object applicant
	) {
		return findByProperty(APPLICANT, applicant
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
	
	public List findByReason(Object reason
	) {
		return findByProperty(REASON, reason
		);
	}
	
	public List findByDate(Object date
	) {
		return findByProperty(DATE, date
		);
	}
	

	public List findAll() {
		log.debug("finding all ModifyRecord instances");
		try {
			String queryString = "from ModifyRecord";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ModifyRecord merge(ModifyRecord detachedInstance) {
        log.debug("merging ModifyRecord instance");
        try {
            ModifyRecord result = (ModifyRecord) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ModifyRecord instance) {
        log.debug("attaching dirty ModifyRecord instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ModifyRecord instance) {
        log.debug("attaching clean ModifyRecord instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public ModifyRecord findAllByNumber(String number) {
    	log.debug("finding all WorkModify instances");
    	try {
    		String queryString = "from ModifyRecord as wm where wm.number=:u";
             Query queryObject = getSession().createQuery(queryString);
             queryObject.setString("u",number);
             List<ModifyRecord> list= queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 ModifyRecord wm = (ModifyRecord) list.get(0);
    			 return wm;
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    } 
}