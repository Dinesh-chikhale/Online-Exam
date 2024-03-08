package org.Exam.Repository;
import org.Exam.Model.*;
import java.util.*;
public class SubjectRepository extends DBConFig{
	List<String> list=new ArrayList<String>();
	public boolean isAddSubject(SubjectModel model)
	{
		try {
			stmt=conn.prepareStatement("insert into subject values('0',?)");
			stmt.setString(1,model.getSubjectname());
		int value=stmt.executeUpdate();
		if(value>0)
		{
			return true;
		}else{
			return false;
		}
			
			
		}catch(Exception e)
		{
			System.out.println("Error is "+e);
			return false;
		}
	}
	
	public boolean isSubjectPresent(SubjectModel model)
	{
		try {
			stmt=conn.prepareStatement("select *from subject where subjectname=?");
			stmt.setString(1, model.getSubjectname());
			rs=stmt.executeQuery();
			return rs.next();
			
		}catch(Exception e)
		{
			System.out.println("Error is "+e);
			return false;
		}
		
	}
	
	public List<String> getAllSubject()
	{
		try {
			stmt=conn.prepareStatement("select subjectname from subject");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				list.add(rs.getString(1));
				
			}
			return list.size()>0?list:null;
			
		}catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return null;
		}
		
	}

}
