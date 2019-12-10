package train.userinfo.dao;
// default package

import ccb.dao.BaseHibernateDAO;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import train.userinfo.pojo.UserInfo;

/**
 	* A data access object (DAO) providing persistence and search support for UserInfo entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .UserInfo
  * @author MyEclipse Persistence Tools 
 */

public class UserInfoDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(UserInfoDAO.class);
		//property constants
	public static final String NEWNUMBER = "newnumber";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String ZU = "zu";
	public static final String AUTHORITY = "authority";



    
    public void save(UserInfo transientInstance) {
        log.debug("saving UserInfo instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UserInfo persistentInstance) {
        log.debug("deleting UserInfo instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserInfo findById( java.lang.Integer id) {
        log.debug("getting UserInfo instance with id: " + id);
        try {
            UserInfo instance = (UserInfo) getSession()
                    .get("UserInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UserInfo instance) {
        log.debug("finding UserInfo instance by example");
        try {
            List results = getSession()
                    .createCriteria("UserInfo")
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
      log.debug("finding UserInfo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserInfo as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByNewnumber(Object newnumber
	) {
		return findByProperty(NEWNUMBER, newnumber
		);
	}
	
	public List findByUsername(Object username
	) {
		return findByProperty(USERNAME, username
		);
	}
	
	public List findByPassword(Object password
	) {
		return findByProperty(PASSWORD, password
		);
	}
	
	public List findByZu(Object zu
	) {
		return findByProperty(ZU, zu
		);
	}
	
	public List findByAuthority(Object authority
	) {
		return findByProperty(AUTHORITY, authority
		);
	}
	

	public List findAll() {
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UserInfo merge(UserInfo detachedInstance) {
        log.debug("merging UserInfo instance");
        try {
            UserInfo result = (UserInfo) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UserInfo instance) {
        log.debug("attaching dirty UserInfo instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserInfo instance) {
        log.debug("attaching clean UserInfo instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public UserInfo findAllById( int id) {
        log.debug("getting UserInfo instance with id: " + id);
        try {
        	String queryString = "from UserInfo as ui where ui.id="+id;
	         Query queryObject = getSession().createQuery(queryString);
			 List list = queryObject.list();
			if(list.isEmpty())
			{
				return null;
			}
			else
			{
				return (UserInfo) list.get(0);
			}
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    public List<UserInfo> findAllByAuthority(String authority) {
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo as ui where ui.authority like '%"+authority+"%' and length(ui.newnumber)=8 ";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	

	
	
	
	public List<UserInfo> findLByAuthority(String authority) {
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo as ui where ui.authority like '%"+authority+"%' and length(ui.newnumber)=8 ";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}


	
	
    
    public List findAllByNameList(String name) {
    	log.debug("finding all UserInfo instances");
    	try {
    		String queryString = "from UserInfo as ui where ui.username='"+name+"'";
             Query queryObject = getSession().createQuery(queryString);
    		 return queryObject.list();
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }

  
  
 
    //根据申请人查询记录
    public UserInfo findByName(String username) {
    	log.debug("finding all UserInfo instances");
    	try {
    		String queryString = "from UserInfo as ui where ui.username=:u";
             Query queryObject = getSession().createQuery(queryString);
             queryObject.setString("u",username);
             List<UserInfo> list = queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 return list.get(0);
             }
    		
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    //根据申请人新一代工号查询记录
    public UserInfo findByNewNumber(String newnumber) {
    	log.debug("finding all UserInfo instances");
    	try {
    		String queryString = "from UserInfo as ui where ui.newnumber=:u";
             Query queryObject = getSession().createQuery(queryString);
             queryObject.setString("u",newnumber);
             List<UserInfo> list= queryObject.list();
             if(list.isEmpty())
             {
            	 return null;
             }
             else
             {
            	 UserInfo ui = (UserInfo) list.get(0);
    			 return ui;
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    public List<UserInfo> findByThisunder(String thisunder,int zu)
    {
    
    		List<UserInfo> listtemp = new ArrayList<UserInfo>();
    		List<UserInfo> list = new ArrayList<UserInfo>();
    		UserInfoDAO uidao = new UserInfoDAO();
    		UserInfo ui = uidao.findByAuthority(thisunder,zu);
    		listtemp.add(ui);
    		list = UserlistToSelectlist(listtemp);
    		return list;
    }
    
    public List<UserInfo> UserlistToSelectlist(List<UserInfo> listtemp)
    {
    	List<UserInfo> list = new ArrayList<UserInfo>();
    	if(!listtemp.isEmpty())
    	{
    		for(int i=0;i<listtemp.size();i++)
    		{
    			UserInfo uitemp = listtemp.get(i);
    			UserInfo uithis = new UserInfo();
    			
    			uithis.setUsername(uitemp.getUsername());
    			uithis.setNewnumber(uitemp.getNewnumber());
    			list.add(uithis);
    		}
    	}
    	return list;
    }

    //根据名字查新一代编号
    public String nameToNewnumber(String name) {
    	log.debug("finding all UserInfo instances");
    	try {
    		String queryString = "from UserInfo as ui where ui.username=:u";
             Query queryObject = getSession().createQuery(queryString);
             queryObject.setString("u",name);
             List<UserInfo> list= queryObject.list();
             if(list.isEmpty())
             {
            	 return "notfound";
             }
             else
             {
            	 UserInfo ui = (UserInfo) list.get(0);
    			 return ui.getNewnumber();
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    //根据名字查新一代编号
    public String nameToNewnumbernull(String name) {
    	log.debug("finding all UserInfo instances");
    	try {
    		String queryString = "from UserInfo as ui where ui.username=:u";
             Query queryObject = getSession().createQuery(queryString);
             queryObject.setString("u",name);
             List<UserInfo> list= queryObject.list();
             if(list.isEmpty())
             {
            	 return "";
             }
             else
             {
            	 UserInfo ui = (UserInfo) list.get(0);
    			 return ui.getNewnumber();
             }
    	} catch (RuntimeException re) {
    		log.error("find all failed", re);
    		throw re;
    	}
    }
    
	public UserInfo findByNewNumberId(String newnumber, int id) {
		log.debug("finding all User instances");
		try {
			String queryString = "from UserInfo as pu where pu.newnumber='"+newnumber+"' and pu.id!='"+id+"'";
			Query queryObject = getSession().createQuery(queryString);
			List list = queryObject.list();
			if(list.isEmpty())
			{
				return null;
			}
			else
			{
				return (UserInfo) list.get(0);
			}
			 
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public UserInfo findByAuthority(String paraauthority , int parazu) {
		log.debug("finding all User instances");
		try {
			int zu=0 ;
			String authority="";
			if(parazu==1||parazu==2)
			{
				zu=6;
			}
			else if(parazu==3||parazu==4)
			{
				zu=7;
			}
			if(paraauthority.equals("B"))
			{
				authority="0B00000";
				
			}
			else if(paraauthority.equals("A"))
			{
				authority="A000000";
				
			}
			String queryString = "from UserInfo as pu where pu.authority = '"+authority+"' and pu.zu ="+zu;
			Query queryObject = getSession().createQuery(queryString);
			List list = queryObject.list();
			if(list.isEmpty())
			{
				return null;
			}
			else
			{
				return (UserInfo) list.get(0);
			}
			 
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	
	public UserInfo findByNameId(String name,int id) {
		log.debug("finding all User instances");
		try {
			String queryString = "from UserInfo as pu where pu.username='"+name+"' and pu.id!='"+id+"'";
			Query queryObject = getSession().createQuery(queryString);
			List list = queryObject.list();
			if(list.isEmpty())
			{
				return null;
			}
			else
			{
				return (UserInfo) list.get(0);
			}
			 
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
    
    
    
}