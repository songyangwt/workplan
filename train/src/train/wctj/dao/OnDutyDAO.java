package train.wctj.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import train.wctj.pojo.OnDuty;
import train.wctj.pojo.WorkData;

/**
 	* A data access object (DAO) providing persistence and search support for OnDuty entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .OnDuty
  * @author MyEclipse Persistence Tools 
 */

public class OnDutyDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(OnDutyDAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String DATE = "date";
	public static final String REMARK = "remark";



    
    public void save(OnDuty transientInstance) {
        log.debug("saving OnDuty instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(OnDuty persistentInstance) {
        log.debug("deleting OnDuty instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public OnDuty findById( java.lang.Integer id) {
        log.debug("getting OnDuty instance with id: " + id);
        try {
            OnDuty instance = (OnDuty) getSession()
                    .get("OnDuty", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(OnDuty instance) {
        log.debug("finding OnDuty instance by example");
        try {
            List results = getSession()
                    .createCriteria("OnDuty")
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
      log.debug("finding OnDuty instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from OnDuty as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByDate(Object date
	) {
		return findByProperty(DATE, date
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	

	public List findAll() {
		log.debug("finding all OnDuty instances");
		try {
			String queryString = "from OnDuty";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public OnDuty merge(OnDuty detachedInstance) {
        log.debug("merging OnDuty instance");
        try {
            OnDuty result = (OnDuty) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(OnDuty instance) {
        log.debug("attaching dirty OnDuty instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(OnDuty instance) {
        log.debug("attaching clean OnDuty instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    
    public OnDuty findByDateAndName(String date,String name) {
    	log.debug("finding all OnDuty instances");
    	try {
    		String queryString = "from OnDuty as wd where wd.name= '"+name+"' and wd.date = '"+date+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<OnDuty> list= queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 OnDuty wd = (OnDuty) list.get(0);
    			 return wd;
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    
    public List<OnDuty> findByDate(String date) {
    	log.debug("finding all OnDuty instances");
    	try {
    		String queryString = "from OnDuty as wd where wd.date = '"+date+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<OnDuty> list= queryObject.list();
             return list;
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
}