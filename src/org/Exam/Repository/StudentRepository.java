package org.Exam.Repository;

import org.Exam.Model.StudentModel;

public class StudentRepository extends DBConFig {

	public boolean isAddStudent(StudentModel smodel)
	{
		
		try {
			stmt=conn.prepareStatement("insert into student values(?,?,?,?,?,?)");
			stmt.setInt(1,smodel.getStid());
			stmt.setString(2,smodel.getName());
			stmt.setString(3, smodel.getEmail());
			stmt.setString(4,smodel.getContact());
			stmt.setString(5,smodel.getUserName());
			stmt.setString(6,smodel.getPassWord());
			int val=stmt.executeUpdate();
			if(val>0)
			{
				return true;
			}
			else {
				return false;
			}
		}catch(Exception ex)
		{
			System.out.println("Error  is "+ex);
			return false;
		}
		
		
		
	}

}
