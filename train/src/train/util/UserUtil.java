package train.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ccb.hibernate.HibernateSessionFactory;
import train.userinfo.dao.UserInfoDAO;
import train.userinfo.pojo.UserInfo;

/**
 * 与用户信息相关的工具函数
 * @author htzx
 *
 */
public class UserUtil {

	/**
	 * 根据身份证号返回性别
	 * @param identity
	 * @return
	 */
	public static int positionlength=6;
	public static String cdfzx = "'综合与生产管理处','合规与监督二处','通用业务二处','专业处理二处','研发支持二处'";
	public static String whyqb = "'物业服务处','安保及基础设施运维处'";

	
	public static String getSexFromIdentity(String identity)
	{
		int sex = 0;
		if(identity==null||identity.length()<3)
		{
			return "未知";
		}
		else
		{
			sex = Integer.parseInt(identity.substring(identity.length()-2,identity.length()-1));//倒数第二位
			if(sex%2==1)
			{
				return "男";
			}
			else
			{
				return "女";
			}
		}
	}
	public static String getBirthFromIdentity(String identity)
	{
		String Birth = "";
		if(identity==null||identity.length()<3)
		{
			return "未知";
		}
		else
		{
			Birth = identity.substring(6,identity.length()-8)+"-"+identity.substring(10,identity.length()-6)+"-"+identity.substring(12,identity.length()-4);//5101811988
			return Birth;
		}
	}

	/**
	 * 分组中提取数字
	 * @param zx
	 * @return
	 */
	public static Integer teamToTnteger(String team)
	{
		String str2 = "";
		if (team == null) {
			return -1;
		} else {
			team = team.trim();
			if (!"".equals(team)) {
				for (int i = 0; i < team.length(); i++) {
					if (team.charAt(i) >= 48 && team.charAt(i) <= 57) {
						str2 += team.charAt(i);
					}
				}
				if(!"".equals(str2))
				return Integer.parseInt(str2);
			}
			return -1;
		}
			
	}


	
	/**
	 * 处室转化为描述
	 * @param s
	 * @return
	 */
	public static String chuToString(Integer c)
	{
	    if(c==1)
		{
			return "综合与生产管理处";
		}
	    else if(c==111)
		{
			return "中心领导";
		}
		else if(c==2)
		{
			return "合规与监督二处";
		}
		else if(c==3)
		{
			return "通用业务二处";
		}
		else if(c==5)
		{
			return "研发支持二处";
		}
		else if(c==6)
		{
			return "专业处理二处";
		}
		else if(c==11)
		{
			return "总行";
		}
		else if(c==12)
		{
			return "分行";
		}
		else if(c==13)
		{
			return "中心";
		}
		else if(c==14)
		{
			return "分中心";
		}
		else if(c==15)
		{
			return "其他";
		}



		else
		{
			return "--";
		}
	}
	
	public static String NewNumberToNameNoSession(String newnumber)
	{
		String result = "";
		if(newnumber==null)
		{
			result="无";
		}
		else
		{
			UserInfoDAO uidao = new UserInfoDAO();
			UserInfo ui = uidao.findByNewNumber(newnumber);
			if(ui==null)
			{
				result = "无";
			}
			else
			{
				result = ui.getUsername();
			}
		}
		return result;
	}
	
	public static String worktypeTostring(Integer worktype)
	{
		if(worktype==1)
		{
			return "川投大厦";
		}
		else if(worktype==2)
		{
			return "航天大厦";
		}
		else if(worktype==3)
		{
			return "外出出差";
		}
		else if(worktype==4)
		{
			return "借调";
		}
		else if(worktype==5)
		{
			return "休假";
		}
		
		else if(worktype==6)
		{
			return "非工作日";
		}
		else
		{
			return "";
		}
		
	}
	
	public static String dataTostring(Integer status)
	{
		if(status==1)
		{
			return "流转中";
		}
		else if(status==2)
		{
			return "流转中";
		}
		else if(status==4)
		{
			return "已完结";
		}
		else if(status==5)
		{
			return "已退回";
		}
		else if(status==6)
		{
			return "已撤销";
		}

		else
		{
			return "";
		}
		
	}
	
	public static String zunameTostring(Integer zu)
	{
		if(zu==1)
		{
			return "测试管理组";
		}
		else if(zu==2)
		{
			return "需求管理组";
		}
		else if(zu==3)
		{
			return "上线支持组";
		}
		else if(zu==4)
		{
			return "体验推广组";
		}
	
		else
		{
			return "无";
		}
		
	}
	
	public static String leavetypeTostring(Integer type)
	{
		String result = "";
		if(type==1)
		{
			result = "病假";
		}
		else if(type==2)
		{
			result = "年休假";
		}
		else if(type==3)
		{
			result = "事假";
		}
		else if(type==4)
		{
			result = "婚假";
		}
		else if(type==5)
		{
			result = "产假（陪护假）";
		}
		
		else if(type==6)
		{
			result = "探亲假（配偶）";
		}
		else if(type==7)
		{
			result = "探亲假（父母）";
		}
		else if(type==8)
		{
			result = "丧假";
		}
		else if(type==9)
		{
			result = "工伤假";
		}
		else if(type==10)
		{
			result = "公假";
		}
		else if(type==11)
		{
			result = "加班调休";
		}
		else if(type==12)
		{
			result = "产检";
		}
		else if(type==13)
		{
			result = "陪考假";
		}
		else if(type==14)
		{
			result = "哺乳假";
		}
		return result;
		
	}
	public static String newnumberTozu(String newnumber)
	{
		String result = "";
		if(newnumber==null)
		{
			result="无";
		}
		else
		{
			Session session = HibernateSessionFactory.getSession();
	 	    Transaction trans=session.beginTransaction();
			UserInfoDAO uidao = new UserInfoDAO();
			UserInfo ui = uidao.findByNewNumber(newnumber);
			if(ui==null)
			{
				result = "无";
			}
			else
			{
				result = zunameTostring(ui.getZu());
			}
	 		trans.commit();
	 		session.flush();
	 		session.clear();
	 		session.close();
		}
		return result;
	}

	
	public static String roleTostring(String authority)
	{
		String authoA = authority.substring(0,1);
		String authoB = authority.substring(1,2);
		String authoC = authority.substring(2,3);
		String authoD = authority.substring(3,4);
		String authoE = authority.substring(4,5);
		String authoF = authority.substring(5,6);
		String authoG = authority.substring(6,7);
		
		if(authoA.equals("A"))
		{
			return "处长";
		}
		else if(authoB.equals("B"))
		{
			return "团队负责人";
		}
		else if(authoC.equals("C"))
		{
			return "主任";
		}
		else if(authoD.equals("D"))
		{
			return "组长";
		}
		else if(authoE.equals("E"))
		{
			return "系统管理员";
		}
	
		else if(authoF.equals("F"))
		{
			return "普通员工";
		}
		else if(authoG.equals("G"))
		{
			return "考勤管理员";
		}
	
	
		else
		{
			return "无";
		}
		
	}
}
