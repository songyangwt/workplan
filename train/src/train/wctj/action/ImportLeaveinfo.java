package train.wctj.action;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import train.wctj.dao.LeaveInfoDAO;

import train.wctj.pojo.LeaveInfo;

import ccb.hibernate.HibernateSessionFactory;

import com.opensymphony.xwork2.ActionContext;

public class ImportLeaveinfo {
	private File file; //上传的文件
    private String fileFileName;
    private String fileContentType;
    private String message;
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
public String execute() throws Exception {
		
		String realpath = "D:/import/office/";
		message = "导入成功";
		//UserInfoDAO uidao = new UserInfoDAO();
		String yearmonth = fileFileName.substring(0, 6);
		int nn=0;
		if (file != null) {
	       File savefile = new File(new File(realpath), fileFileName);
	       if (!savefile.getParentFile().exists())
	            savefile.getParentFile().mkdirs();
	           FileUtils.copyFile(file, savefile);
	     }
	    else
	    {
	    	ActionContext.getContext().put("message", "传入文件有误");
	    }
		/*if(yearmonth.compareTo("201501")<0||yearmonth.compareTo("209912")>0)
		{
			message = "导入失败,文件名应以年+月开头";
		}*/
	
			Session session = HibernateSessionFactory.getSession();
	    	Transaction trans=session.beginTransaction();
	    	LeaveInfoDAO wddao = new LeaveInfoDAO();
	    	
	    	try {
	    		Workbook book = Workbook.getWorkbook(new File(realpath+fileFileName));
				// 获得第一个工作表对象
				Sheet sheet = book.getSheet(0);
				// 得到第一列第一行的单元格
				nn = sheet.getRows();
				
				//String sql = "truncate t_pb_people";
				//session.createSQLQuery(sql).executeUpdate();
				for (int i = 1; i < nn; i++) {
					
					if(sheet.getCell(1, i).getContents().trim()!="")
					{
						 LeaveInfo wdtemp = new LeaveInfo();
						
						 wdtemp.setLeavetype(Integer.valueOf(sheet.getCell(0, i).getContents().trim()));
						 wdtemp.setName(sheet.getCell(1, i).getContents().trim() );
						 wdtemp.setNewnumber(sheet.getCell(2, i).getContents().trim());
						 wdtemp.setBegindate(sheet.getCell(3, i).getContents().trim());
						 wdtemp.setEnddate(sheet.getCell(4, i).getContents().trim());
						 wddao.merge(wdtemp);
					}
			
					}
					
	    	        
				}
				catch (Exception e) {
				trans.rollback();//出错回滚
				e.printStackTrace();
			    }
				finally{
				 trans.commit();
		         session.flush();
		         session.clear();
		         session.close();
			  }
		
		return "success";
   }
}
