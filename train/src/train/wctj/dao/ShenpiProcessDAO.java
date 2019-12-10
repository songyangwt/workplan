package train.wctj.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;

import train.wctj.pojo.ShenpiProcess;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for ShenpiProcess entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .ShenpiProcess
  * @author MyEclipse Persistence Tools 
 */

public class ShenpiProcessDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ShenpiProcessDAO.class);
		//property constants
	public static final String NUMBER = "number";
	public static final String TIME = "time";
	public static final String VIEWER = "viewer";
	public static final String VIEWERNUMBER = "viewernumber";
	public static final String ROLE = "role";
	public static final String AUTHORITY = "authority";
	public static final String OPINION = "opinion";
	public static final String REMARK = "remark";



    
    public void save(ShenpiProcess transientInstance) {
        log.debug("saving ShenpiProcess instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ShenpiProcess persistentInstance) {
        log.debug("deleting ShenpiProcess instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ShenpiProcess findById( java.lang.Integer id) {
        log.debug("getting ShenpiProcess instance with id: " + id);
        try {
            ShenpiProcess instance = (ShenpiProcess) getSession()
                    .get("ShenpiProcess", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ShenpiProcess instance) {
        log.debug("finding ShenpiProcess instance by example");
        try {
            List results = getSession()
                    .createCriteria("ShenpiProcess")
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
      log.debug("finding ShenpiProcess instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ShenpiProcess as model where model." 
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
	
	public List findByTime(Object time
	) {
		return findByProperty(TIME, time
		);
	}
	
	public List findByViewer(Object viewer
	) {
		return findByProperty(VIEWER, viewer
		);
	}
	
	public List findByViewernumber(Object viewernumber
	) {
		return findByProperty(VIEWERNUMBER, viewernumber
		);
	}
	
	public List findByRole(Object role
	) {
		return findByProperty(ROLE, role
		);
	}
	
	public List findByAuthority(Object authority
	) {
		return findByProperty(AUTHORITY, authority
		);
	}
	
	public List findByOpinion(Object opinion
	) {
		return findByProperty(OPINION, opinion
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	

	public List findAll() {
		log.debug("finding all ShenpiProcess instances");
		try {
			String queryString = "from ShenpiProcess";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ShenpiProcess merge(ShenpiProcess detachedInstance) {
        log.debug("merging ShenpiProcess instance");
        try {
            ShenpiProcess result = (ShenpiProcess) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ShenpiProcess instance) {
        log.debug("attaching dirty ShenpiProcess instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ShenpiProcess instance) {
        log.debug("attaching clean ShenpiProcess instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public  List<ShenpiProcess> findAllByNumber(String number) {
    	log.debug("finding all ShenpiProcess instances");
    	try {
    		 String queryString = "from ShenpiProcess as sp where sp.number=:u";
             Query queryObject = getSession().createQuery(queryString);
             queryObject.setString("u",number);
             List<ShenpiProcess> list= queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	
    			 return list;
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
      } 
}