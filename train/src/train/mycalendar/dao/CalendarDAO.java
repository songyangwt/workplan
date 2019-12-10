package train.mycalendar.dao;
// default package

import ccb.dao.BaseHibernateDAO;


import java.util.ArrayList;
import java.util.List;



import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import train.mycalendar.pojo.Calendar;

/**
 	* A data access object (DAO) providing persistence and search support for Calendar entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Calendar
  * @author MyEclipse Persistence Tools 
 */

public class CalendarDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(CalendarDAO.class);
		//property constants
	public static final String DATE = "date";
	public static final String WEEK = "week";
	public static final String WORKDAY = "workday";
	public static final String REMARK = "remark";



    
    public void save(Calendar transientInstance) {
        log.debug("saving Calendar instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Calendar persistentInstance) {
        log.debug("deleting Calendar instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Calendar findById( java.lang.Integer id) {
        log.debug("getting Calendar instance with id: " + id);
        try {
            Calendar instance = (Calendar) getSession()
                    .get("Calendar", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Calendar instance) {
        log.debug("finding Calendar instance by example");
        try {
            List results = getSession()
                    .createCriteria("Calendar")
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
      log.debug("finding Calendar instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Calendar as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
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
	
	public List findByWorkday(Object workday
	) {
		return findByProperty(WORKDAY, workday
		);
	}
	
	public List findByRemark(Object remark
	) {
		return findByProperty(REMARK, remark
		);
	}
	

	public List findAll() {
		log.debug("finding all Calendar instances");
		try {
			String queryString = "from Calendar";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Calendar merge(Calendar detachedInstance) {
        log.debug("merging Calendar instance");
        try {
            Calendar result = (Calendar) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Calendar instance) {
        log.debug("attaching dirty Calendar instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Calendar instance) {
        log.debug("attaching clean Calendar instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public String findEndDateByDate(String date)
	{
		log.debug("finding all MyCalendar instances");
		try {
			String queryString = "from MyCalendar as mc where mc.date like '"+date.substring(0,6)+"__' order by mc.date desc";
	         Query queryObject = getSession().createQuery(queryString);
	         List<Calendar> list = queryObject.list();
	         if(list.isEmpty())
	         {
	        	 return null;
	         }
	         else
	         {
	        	 return list.get(0).getDate();
	         }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    /**
     * 传入8位日期
     * 返回是否是工作日
     * @param date
     * @return true 工作日 false 非工作日
     */
    public boolean ifWorkDay(String date) {
		log.debug("finding all MyCalendar instances");
		try {
			 String queryString = "from MyCalendar as mc where mc.date='"+date+"'";
	         Query queryObject = getSession().createQuery(queryString);
	         Calendar calendar = (Calendar) queryObject.list().get(0);
	         if(calendar.getWorkday()==1)
	         {
	        	 return true;
	         }
	         else
	         {
	        	 return false;
	         }
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    
    public Calendar findByDate(String date) {
		log.debug("finding all MyCalendar instances");
		try {
			String queryString = "from Calendar as mc where mc.date='"+date+"'";
	         Query queryObject = getSession().createQuery(queryString);
			 return (Calendar) queryObject.list().get(0);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    
    public Calendar findAllById(int id) {
		log.debug("finding all MyCalendar instances");
		try {
			String queryString = "from Calendar as mc where mc.id="+id;
	         Query queryObject = getSession().createQuery(queryString);
			 return (Calendar) queryObject.list().get(0);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    
    public List<String> DateInList(Calendar mc) {
		log.debug("finding all MyCalendar instances");
		try {
			 List<String> date = new ArrayList();
			int weektoday = mc.getWeek();
			 int id = mc.getId();
			  if(weektoday==1)
		 	    {
		 	    	    	
		 	    	date.add(findAllById(id).getDate());
		 	    	date.add(findAllById(id+1).getDate());
		 	    	date.add(findAllById(id+2).getDate());
		 	    	date.add(findAllById(id+3).getDate());
		 	    	date.add(findAllById(id+4).getDate());
		 	    	date.add(findAllById(id+5).getDate());
		 	    	date.add(findAllById(id+6).getDate());
		 	    	
		 	    }
		 	    else if(weektoday==2)
		 	    {
		 	    	    date.add(findAllById(id-1).getDate());    
		 	    	    date.add(findAllById(id).getDate());
			 	    	date.add(findAllById(id+1).getDate());
			 	    	date.add(findAllById(id+2).getDate());
			 	    	date.add(findAllById(id+3).getDate());
			 	    	date.add(findAllById(id+4).getDate());
			 	    	date.add(findAllById(id+5).getDate());
			 	    	
		 	    	
		 	    }
		 	   else if(weektoday==3)
			    {
		 		  date.add(findAllById(id-2).getDate());
		 	    	date.add(findAllById(id-1).getDate());
		 		   date.add(findAllById(id).getDate());
		 	    	date.add(findAllById(id+1).getDate());
		 	    	date.add(findAllById(id+2).getDate());
		 	    	date.add(findAllById(id+3).getDate());
		 	    	date.add(findAllById(id+4).getDate());
		 	    	
		 	    	
			   	
			    	
			    }
		 	  else if(weektoday==4)
			    {
		 		 date.add(findAllById(id-3).getDate());
		 	    	date.add(findAllById(id-2).getDate());
		 	    	date.add(findAllById(id-1).getDate());
		 		  date.add(findAllById(id).getDate());
		 	    	date.add(findAllById(id+1).getDate());
		 	    	date.add(findAllById(id+2).getDate());
		 	    	date.add(findAllById(id+3).getDate());
		 	    	
		 	    	
			    	
			    	
			    }
		 	 else if(weektoday==5)
			    {
		 		date.add(findAllById(id-4).getDate());
	 	    	date.add(findAllById(id-3).getDate());
	 	    	date.add(findAllById(id-2).getDate());
	 	    	date.add(findAllById(id-1).getDate());
		 		 date.add(findAllById(id).getDate());
	 	    	date.add(findAllById(id+1).getDate());
	 	    	date.add(findAllById(id+2).getDate());
	 	    	
	 	    	
			    	
			    }
		 	 else if(weektoday==6)
			    {
		 		date.add(findAllById(id-5).getDate());
	 	    	date.add(findAllById(id-4).getDate());
	 	    	date.add(findAllById(id-3).getDate());
	 	    	date.add(findAllById(id-2).getDate());
	 	    	date.add(findAllById(id-1).getDate());
		 		 date.add(findAllById(id).getDate());
	 	    	date.add(findAllById(id+1).getDate());
	 	    	
			    	
			    }
		 	 else if(weektoday==7)
			    {
		 		date.add(findAllById(id-6).getDate());
	 	    	date.add(findAllById(id-5).getDate());
	 	    	date.add(findAllById(id-4).getDate());
	 	    	date.add(findAllById(id-3).getDate());
	 	    	date.add(findAllById(id-2).getDate());
	 	    	date.add(findAllById(id-1).getDate());
		 		date.add(findAllById(id).getDate());
	 	    	  	
			    }
			  
			  return date;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    /**
     * 根据起始截止日期工作日查询所有
     * @param begindate
     * @param enddate
     * @param workday 1工作日，0非工作日 2全部
     * @return
     */
    public List<Calendar> findByBeginAndEnd(String begindate,String enddate,int workday) {
		log.debug("finding all MyCalendar instances");
		try {
			String queryString = "";
			if(workday==2)
			{
				queryString = "from MyCalendar as mc where mc.date>='"+begindate+"' and mc.date<='"+enddate+"'";
			}
			else
			{
				queryString = "from MyCalendar as mc where mc.date>='"+begindate+"' and mc.date<='"+enddate+"' and mc.workday="+workday;
			}
			 Query queryObject = getSession().createQuery(queryString);
			 return  queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}