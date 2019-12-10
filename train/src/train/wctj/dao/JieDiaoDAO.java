package train.wctj.dao;
// default package

import ccb.dao.BaseHibernateDAO;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import train.wctj.pojo.JieDiao;
import train.wctj.pojo.WorkData;
import train.wctj.pojo.WorkModify;

/**
 	* A data access object (DAO) providing persistence and search support for JieDiao entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .JieDiao
  * @author MyEclipse Persistence Tools 
 */

public class JieDiaoDAO extends BaseHibernateDAO  {
	private static final Logger log = LoggerFactory.getLogger(JieDiaoDAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String ZU = "zu";
	public static final String BEGINDATE = "begindate";
	public static final String ENDDATE = "enddate";
	public static final String LOCATION = "location";
	public static final String REASON = "reason";
	public static final String DEPARTMENT = "department";



    
    public void save(JieDiao transientInstance) {
        log.debug("saving JieDiao instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(JieDiao persistentInstance) {
        log.debug("deleting JieDiao instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public JieDiao findById( java.lang.Integer id) {
        log.debug("getting JieDiao instance with id: " + id);
        try {
            JieDiao instance = (JieDiao) getSession()
                    .get("JieDiao", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(JieDiao instance) {
        log.debug("finding JieDiao instance by example");
        try {
            List results = getSession()
                    .createCriteria("JieDiao")
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
      log.debug("finding JieDiao instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from JieDiao as model where model." 
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
	
	public List findByZu(Object zu
	) {
		return findByProperty(ZU, zu
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
	
	public List findByLocation(Object location
	) {
		return findByProperty(LOCATION, location
		);
	}
	
	public List findByReason(Object reason
	) {
		return findByProperty(REASON, reason
		);
	}
	
	public List findByDepartment(Object department
	) {
		return findByProperty(DEPARTMENT, department
		);
	}
	

	public List findAll() {
		log.debug("finding all JieDiao instances");
		try {
			String queryString = "from JieDiao";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public JieDiao merge(JieDiao detachedInstance) {
        log.debug("merging JieDiao instance");
        try {
            JieDiao result = (JieDiao) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(JieDiao instance) {
        log.debug("attaching dirty JieDiao instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(JieDiao instance) {
        log.debug("attaching clean JieDiao instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public JieDiao findAllByNameAndBE(String name,String begindate,String enddate) {
    	log.debug("finding all JieDiao instances");
       	try {
    		String queryString = "from JieDiao as wd where wd.name= '"+name+"' and wd.begindate = '"+begindate+"' and wd.enddate = '"+enddate+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<JieDiao> list= queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 JieDiao wd = (JieDiao) list.get(0);
    			 return wd;
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    } 
    
    public JieDiao findAllById(int id) {
    	log.debug("finding all WorkData instances");
    	try {
    		String queryString = "from JieDiao as wd where wd.id= "+id;
             Query queryObject = getSession().createQuery(queryString);
             List<JieDiao> list= queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 JieDiao wd = (JieDiao) list.get(0);
    			 return wd;
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    
}