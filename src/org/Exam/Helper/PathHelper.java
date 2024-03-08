package org.Exam.Helper;

import java.io.FileInputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Properties;

public class PathHelper {
	public static final String filepath="D:\\Onlineexamination\\QuestionBank";
	public static String completePath="";
	public static  Properties p=new Properties();
	public PathHelper()
	{
		try {
			Path currentDirectoryPath = FileSystems.getDefault().getPath("");
			String currentDirectoryName = currentDirectoryPath.toAbsolutePath().toString();
			completePath=currentDirectoryName+"\\src\\resource\\db.properties";
			FileInputStream fing=new FileInputStream(completePath);
			p.load(fing);
		}catch(Exception ex)
		{
			System.out.println("Errorr "+ex);
		}
	}
}
