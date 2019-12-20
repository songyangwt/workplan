package train.wctj.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import train.wctj.pojo.LeaveInfo;

/**
 	* A data access object (DAO) providing persistence and search support for LeaveInfo entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .LeaveInfo
  * @author MyEclipse Persistence Tools 
 */

public class LeaveInfoDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(LeaveInfoDAO.class);
		//property constants
	public static final String LEAVETYPE = "leavetype";
	public static final String NAME = "name";
	public static final String NEWNUMBER = "newnumber";
	public static final String BEGINDATE = "begindate";
	public static final String ENDDATE = "enddate";
	public static final String REMARK = "remark";



    
    public void save(LeaveInfo transientInstance) {
        log.debug("saving LeaveInfo instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(LeaveInfo persistentInstance) {
        log.debug("deleting LeaveInfo instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public LeaveInfo findById( java.lang.Integer id) {
        log.debug("getting LeaveInfo instance with id: " + id);
        try {
            LeaveInfo instance = (LeaveInfo) getSession()
                    .get("LeaveInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(LeaveInfo instance) {
        log.debug("finding LeaveInfo instance by example");
        try {
            List results = getSession()
                    .createCriteria("LeaveInfo")
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
      log.debug("finding LeaveInfo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from LeaveInfo as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByLeavetype(Object leavetype
	) {
		return findByProperty(LEAVETYPE, leavetype
		);
	}
	
	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByNewnumber(Object newnumber
	) {
		return findByProperty(NEWNUMBER, newnumber
		);
	}
	
	public List findByBegindate(Object begindate
	) {
		return findByProperty(BEGINDATE, begindate
		);
	}
	
	public List findByEnddate(Object enddate
	) {
		return findByProperty(ENDDATE, enddate
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	

	public List findAll() {
		log.debug("finding all LeaveInfo instances");
		try {
			String queryString = "from LeaveInfo";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public LeaveInfo merge(LeaveInfo detachedInstance) {
        log.debug("merging LeaveInfo instance");
        try {
            LeaveInfo result = (LeaveInfo) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(LeaveInfo instance) {
        log.debug("attaching dirty LeaveInfo instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(LeaveInfo instance) {
        log.debug("attaching clean LeaveInfo instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public LeaveInfo findAllById(int id) {
    	log.debug("finding all WorkData instances");
    	try {
    		String queryString = "from LeaveInfo as wd where wd.id= "+id;
             Query queryObject = getSession().createQuery(queryString);
             List<LeaveInfo> list= queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 LeaveInfo wd = (LeaveInfo) list.get(0);
    			 return wd;
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
}