package org.Exam.Repository;
import java.io.*;
import org.Exam.Model.QuestionModel;
import org.Exam.services.SubjectService;
import java.util.*;
public class QuestionRepository extends DBConFig{
	private int questionid;
	SubjectService ss=new SubjectService();
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
	public int getSubjectIdByName(String name)
	{
		try {
			stmt=conn.prepareStatement("select sid from subject where subjectname=?");
			stmt.setString(1, name);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
				
				
			}
			else {
				return -1;
			}
			
			
		}catch(Exception ex)
		{
			System.out.println("Error isss "+ex);
			return 0;
		}
	}
	
	public boolean isAddQuestion(QuestionModel model,String subname)
	{
		try {
			int qid=this.getQuestionid();
			if(qid!=0)
			{
				stmt=conn.prepareStatement("insert into question values(?,?,?,?,?,?,?)");
				stmt.setInt(1,qid);
				stmt.setString(2,model.getQuestionname());
				stmt.setString(3, model.getOp1());
				stmt.setString(4, model.getOp2());
				stmt.setString(5, model.getOp3());
				stmt.setString(6, model.getOp4());
				stmt.setInt(7, model.getAnswer());
				int values=stmt.executeUpdate();
				if(values>0)
				{
					int sid=this.getSubjectIdByName(subname);
					if(sid!=-1)
					{
						
						stmt=conn.prepareStatement("insert into subjectquestionjoin values(?,?)");
						stmt.setInt(1, qid);
						stmt.setInt(2,sid);
						return stmt.executeUpdate()>0?true:false;
						
						
						
					}
					else if(sid==-1)
					{
						System.out.println("Subject Not found");
						return  false;
					}
					else
					{
						System.out.println("Some problem is there......");
						return false;
					}
					
				}
				else {
					return false;
				}
			}
			return true;
			
		}catch(Exception ex)
		{
			System.out.println("Error iss "+ex);
		return false;
	}
	}
	public boolean uploadBulkQuestion(String question[],String subname)
	{
		try {
			int qid=this.getQuestionid();
			if(qid!=0)
			{
				stmt=conn.prepareStatement("insert into question values(?,?,?,?,?,?,?)");
				stmt.setInt(1,qid);
				stmt.setString(2,question[0]);
				stmt.setString(3,question[1]);
				stmt.setString(4, question[2]);
				stmt.setString(5, question[3]);
				stmt.setString(6, question[4]);
				stmt.setInt(7, Integer.parseInt(question[5].trim()));
				int values=stmt.executeUpdate();
				if(values>0)
				{
					int sid=this.getSubjectIdByName(subname);
					if(sid!=-1)
					{
						
						stmt=conn.prepareStatement("insert into subjectquestionjoin values(?,?)");
						stmt.setInt(1, qid);
						stmt.setInt(2,sid);
						return stmt.executeUpdate()>0?true:false;
						
						
						
						
					}
					else if(sid==-1)
					{
						System.out.println("Subject Not found");
						return  false;
					}
					else
					{
						System.out.println("Some problem is there......");
						return false;
					}
					
				}
				else {				
					return false;
				}
			}
			return true;
			
		}catch(Exception ex)
		{
			System.out.println("Error  "+ex);
		
		return false;
	}
	}
	

	
	}




