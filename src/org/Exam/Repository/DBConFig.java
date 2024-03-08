package org.Exam.Repository;
import java.sql.*;

import org.Exam.Helper.PathHelper;
public class DBConFig {

		protected Connection conn;
		protected PreparedStatement stmt;
		protected ResultSet rs;
		public DBConFig() 
		{
			try {
				PathHelper phelp=new PathHelper();
				Class.forName(PathHelper.p.getProperty("driver"));
				conn=(Connection)DriverManager.getConnection(PathHelper.p.getProperty("url"),PathHelper.p.getProperty("user"),PathHelper.p.getProperty("pass"));
			} catch (Exception e) {
				System.out.println("Erro "+e);
				
				
			}
			
		}
		

	}


