
package org.Exam.Repository;
import java.sql.Date;
import org.Exam.Model.ExamModel;
import org.Exam.Model.ScheduleModel;
import org.Exam.services.SubjectService;

import java.util.*;
public class ExamRepository extends DBConFig{
   List<ExamModel> list=new ArrayList<ExamModel>();
   QuestionRepository qRepo=new QuestionRepository();
   
	public boolean isExamPresent(String examName)
	{
		try {
			stmt=conn.prepareStatement("select *from exam where examname=?");
			stmt.setString(1,examName );
			rs=stmt.executeQuery();
			return rs.next();
			
		}catch(Exception ex)
		{
			return false;
			
		}
	}
	public boolean isAddExam(ExamModel model)
	{
		try {
			stmt=conn.prepareStatement("insert into exam values('0',?,?,?)");
			stmt.setString(1, model.getName());
			stmt.setInt(2, model.getTotalMarks());
			stmt.setInt(3, model.getPassingMarks());
			int val=stmt.executeUpdate();
			if(val>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}catch(Exception ex)
		{
			System.out.println(ex);
			return false;
		}
		
	}
	public List<ExamModel> getAllExam()
	{
		try {
			stmt=conn.prepareStatement("select *from exam");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				ExamModel model=new ExamModel();
				model.setId(rs.getInt(1));
				model.setName(rs.getString(2));
				model.setTotalMarks(rs.getInt(3));
				model.setTotalMarks(rs.getInt(4));
				list.add(model);
			}
					
			return list.size()>0?list:null;
		}catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return null;

		}
	}
	public ExamModel getExamByIdName(String name)
	{
		try {
			ExamModel examModel=new ExamModel();
			stmt=conn.prepareStatement("select *from exam where examname='"+name+"'");
			rs=stmt.executeQuery();
			
			if(rs.next())
			{
				
				examModel.setId(rs.getInt(1));
				examModel.setName(rs.getString(2));
				examModel.setTotalMarks(rs.getInt(3));
				examModel.setTotalMarks(rs.getInt(4));
				
			}
			return examModel!=null?examModel:null;
		}catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return null;
		}
		
	}
	
	public int getScheduleId()
	{
		int count=0;
		try {
			stmt=conn.prepareStatement("select max(schid) from schedule");
			rs=stmt.executeQuery();
			if(rs.next())
			{
				count=rs.getInt(1);
				
			}
			++count;
			return count;
			
			
		}catch(Exception ex)
		{
			System.out.println("error is"+ex);
			return 0;
		}
	}
	SubjectService ss=new SubjectService();
	int questionid;
	private int getQuestionid()
	{
		try {
			stmt=conn.prepareStatement("select max(qid) from question");
			rs=stmt.executeQuery();
			if(rs.next())
			{
				questionid=rs.getInt(1);
			}++questionid;
		}catch(Exception ex)
		{
			System.out.println("Error i "+ex);
			return 0;
		}
		return questionid;
	}
	public boolean isSetSchedule(ExamModel emodel,String subName)
	{
		
		try {
			int schid=this.getScheduleId();
			int sid=qRepo.getSubjectIdByName(subName);
			ScheduleModel smodel=emodel.getSchedulemodel();
			if(schid!=0)
			{
			String examDate=smodel.getDate().toLocaleString();
			String d[]=examDate.split(",");
			String datesplit[]=d[0].split("-");
			System.out.println(datesplit[0]+"\t"+datesplit[1]+"\t"+datesplit[2]);
			if(datesplit[2].equals(2024))
			{
				System.out.println("this match");
			}
			int month[]=new int[] {0,1,2,3,4,5,6,7,8,9,10,11};
			int m=0;
			switch(datesplit[1])
			{
			case "Jan":
				m=0;
				break;
			case "Feb":
				m=1;
				break;
			case "Mar":
				m=2;
				break;
			case "April":
				m=3;
				break;
			case "May":
				m=4;
				break;
			case "June":
				m=5;
				break;
			case "July":
				m=6;
				break;
			case "August":
				m=7;
				break;
			case "September":
				m=8;
				break;
			case "Octamber":
				m=9;
				break;
			case "Nov":
				m=10;
				break;
			case "December":
				m=11;
				break;	
			}	
			System.out.println(datesplit[2]);
			String newYear=datesplit[2].substring(2,4).toString();
			Date sdate=new Date(Integer.parseInt(newYear)+100,m,Integer.parseInt(datesplit[0]));
			
			System.out.println(emodel.getSchedulemodel().getExamid());
			System.out.println(sdate);
			stmt=conn.prepareStatement("insert into schedule values(?,?,?,?,?,?)");
			stmt.setInt(1, schid);
			stmt.setInt(2,emodel.getSchedulemodel().getExamid());
			stmt.setDate(3, sdate);
			stmt.setString(4,emodel.getSchedulemodel().getStarttime());
			stmt.setString(5, emodel.getSchedulemodel().getEndtime());;
			stmt.setInt(6,sid);
			int values=stmt.executeUpdate();
			return values>0?true:false;
				
			}
			else
			{
				System.out.println("Some problem is There");
				return false;
			}
		
			
		}catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return false;
		}
		
	}
}
