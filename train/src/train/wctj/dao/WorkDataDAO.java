package train.wctj.dao;
// default package

import ccb.dao.BaseHibernateDAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import train.wctj.pojo.GlobalDataBean;
import train.wctj.pojo.WorkData;

/**
 	* A data access object (DAO) providing persistence and search support for WorkData entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .WorkData
  * @author MyEclipse Persistence Tools 
 */

public class WorkDataDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(WorkDataDAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String NEWNUMBER = "newnumber";
	public static final String DATE = "date";
	public static final String WEEK = "week";
	public static final String WORKTYPE = "worktype";
	public static final String LOCATION = "location";
	public static final String REASON = "reason";
	public static final String ZU = "zu";
	public static final String CITY = "city";
	public static final String LEAVETYPE = "leavetype";
	public static final String REMARK = "remark";



    
    public void save(WorkData transientInstance) {
        log.debug("saving WorkData instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(WorkData persistentInstance) {
        log.debug("deleting WorkData instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public WorkData findById( java.lang.Integer id) {
        log.debug("getting WorkData instance with id: " + id);
        try {
            WorkData instance = (WorkData) getSession()
                    .get("WorkData", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(WorkData instance) {
        log.debug("finding WorkData instance by example");
        try {
            List results = getSession()
                    .createCriteria("WorkData")
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
      log.debug("finding WorkData instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from WorkData as model where model." 
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
	
	public List findByNewnumber(Object newnumber
	) {
		return findByProperty(NEWNUMBER, newnumber
		);
	}
	
	public List findByDate(Object date
	) {
		return findByProperty(DATE, date
		);
	}
	
	public List findByWeek(Object week
	) {
		return findByProperty(WEEK, week
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
	
	public List findByReason(Object reason
	) {
		return findByProperty(REASON, reason
		);
	}
	
	public List findByZu(Object zu
	) {
		return findByProperty(ZU, zu
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
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	

	public List findAll() {
		log.debug("finding all WorkData instances");
		try {
			String queryString = "from WorkData";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public WorkData merge(WorkData detachedInstance) {
        log.debug("merging WorkData instance");
        try {
            WorkData result = (WorkData) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(WorkData instance) {
        log.debug("attaching dirty WorkData instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(WorkData instance) {
        log.debug("attaching clean WorkData instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public WorkData findByNewNumber(String newnumber) {
    	log.debug("finding all WorkData instances");
    	try {
    		String queryString = "from WorkData as wd where wd.newnumber=:u";
             Query queryObject = getSession().createQuery(queryString);
             queryObject.setString("u",newnumber);
             List<WorkData> list= queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 WorkData wd = (WorkData) list.get(0);
    			 return wd;
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    
    public WorkData findById(int id) {
    	log.debug("finding all WorkData instances");
    	try {
    		String queryString = "from WorkData as wd where wd.id="+id;
             Query queryObject = getSession().createQuery(queryString);
             
             List<WorkData> list= queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 WorkData wd = (WorkData) list.get(0);
    			 return wd;
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    
    public int findByDateAndType(String date,int worktype) {
    	log.debug("finding all WorkData instances");
    	try {
    		String queryString = "from WorkData as wd where wd.worktype= "+worktype+" and wd.date = '"+date+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<WorkData> list= queryObject.list();
             if(list.isEmpty())
             {
            	 return 0;
             }
             else
             {
            	return list.size();
    			
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    
    public WorkData findAllById(int id) {
    	log.debug("finding all WorkData instances");
    	try {
    		String queryString = "from WorkData as wd where wd.id= "+id;
             Query queryObject = getSession().createQuery(queryString);
             List<WorkData> list= queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 WorkData wd = (WorkData) list.get(0);
    			 return wd;
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    
    public WorkData findByDateAndNewnumber(String date,String newnumber) {
    	log.debug("finding all WorkData instances");
    	try {
    		String queryString = "from WorkData as wd where wd.newnumber= '"+newnumber+"' and wd.date = '"+date+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<WorkData> list= queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 WorkData wd = (WorkData) list.get(0);
    			 return wd;
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    
    public List<GlobalDataBean> findByDateAndTypeToString(List<String>date, int worktype,String datetoday) {
    	
    	try {
    		 
    		 String queryString = "from WorkData as wd where wd.worktype= "+worktype+" and wd.date = '"+datetoday+"'";
             Query queryObject = getSession().createQuery(queryString);
             List<WorkData> list= queryObject.list();
             List<GlobalDataBean> listglobal = new ArrayList<GlobalDataBean>();
             
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	String newnumber = ""; 
            	String dateper = "";
            	for(int i=0;i<list.size();i++)
            	{
            		 newnumber = list.get(i).getNewnumber();
            		 GlobalDataBean gdb = new  GlobalDataBean();
            		 gdb.setNewnumber(newnumber);
            		 for(int j=0;j<date.size();j++)
            		 {
            			 dateper = date.get(j);
            			 String queryStringtemp = "from WorkData as wd where wd.date = '"+dateper+"' and wd.newnumber = '"+newnumber+"'";
            		     Query queryObjecttemp = getSession().createQuery(queryStringtemp);
            			 List<WorkData> listtemp= queryObjecttemp.list();
            			 if(j==0)
            			 {
            				 gdb.setWorktypeweek1(listtemp.get(0).getWorktype() );
            			 }
            			 else if (j==1)
            			 {
            				 gdb.setWorktypeweek2(listtemp.get(0).getWorktype() );
            			 }
            			 else if (j==2)
            			 {
            				 gdb.setWorktypeweek3(listtemp.get(0).getWorktype() );
            			 }
            			 else if (j==3)
            			 {
            				 gdb.setWorktypeweek4(listtemp.get(0).getWorktype() );
            			 }
            			 else if (j==4)
            			 {
            				 gdb.setWorktypeweek5(listtemp.get(0).getWorktype() );
            			 }
            			 else if (j==5)
            			 {
            				 if(listtemp.isEmpty())
            				 {
            					 gdb.setWorktypeweek6(7);
            				 }
            				 else
            				 {
            					 gdb.setWorktypeweek6(listtemp.get(0).getWorktype() );
            				 }
            				
            			 }
            			 else if (j==6)
            			 {
            				 if(listtemp.isEmpty())
            				 {
            					 gdb.setWorktypeweek7(7);
            				 }
            				 else
            				 {
            					 gdb.setWorktypeweek7(listtemp.get(0).getWorktype() );
            				 }
            			 }
            			 
            		 }
            		 listglobal.add(gdb);
            	 
    			
             }
             }
             return listglobal;
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
}