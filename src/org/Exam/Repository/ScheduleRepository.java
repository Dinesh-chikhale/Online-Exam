package org.Exam.Repository;
import java.sql.SQLException;
import java.util.*;
import org.Exam.Model.ScheduleModel;

public class ScheduleRepository extends DBConFig {
	ScheduleModel smodel=new ScheduleModel();
	
	public boolean isAddSchedule()
	{
		try {
			stmt=conn.prepareStatement("insert into schedule values(?,?,?,?,?,?)");
			stmt.setInt(1,smodel.getSchid());
			stmt.setInt(2,smodel.getExamid());
			//stmt.setDate(3, smodel.getDate());
			stmt.setString(4,smodel.getStarttime());
			stmt.setString(5,smodel.getEndtime());
			stmt.setInt(6,smodel.getSid());
			int val=stmt.executeUpdate();
			if(val>0)
			{
				System.out.println("Schedule Added Successfully");
			}
			else
			{
				System.out.println("Schedule not Added Successfully");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
		
		
		
	}

}
