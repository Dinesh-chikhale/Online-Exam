package org.Exam.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.Exam.Helper.PathHelper;
import org.Exam.Model.QuestionModel;
import org.Exam.Repository.QuestionRepository;

public class QuestionServices {
	QuestionRepository qeuRepo=new QuestionRepository();
	
	SubjectService ss=new SubjectService();

	public boolean isAddQuestion(QuestionModel model, String subname)
	{
		return qeuRepo.isAddQuestion(model,subname);
	}
	
	public boolean createFile()
	{
		try {
			String path="D:\\Onlineexamination\\QuestionBank";
			File f=new File(path);
			if(!f.exists())
			{
				f.mkdir();
				
			}  
			List<String> sublist=ss.getAddSubject();
			if(sublist!=null)
			{
				for(String subname:sublist)
				{
					f=new File(path+"\\"+subname+".csv");
					
					if(!f.exists())
					{
						f.createNewFile();
					}
					
				}
				
			}
			else
			{
				System.out.println("Subject not Found");
			}
		}catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			
		}
		return true;
	}
	
	public boolean uploadBulkQuestion(String subname)
	{
		boolean b=this.createFile();
		boolean flag=false;
			if(b) {
				File f=new File("D:\\Onlineexamination\\QuestionBank");
				File []filelist=f.listFiles();
				for(File file:filelist)
				{
					if(file.isFile())
					{
						int index=file.toString().indexOf(subname);
                         
							if(index!=-1)
							{
								flag=true;
								break;
							}
					}
				}
				if(flag)
				{try {
					FileReader filer=new FileReader(PathHelper.filepath+"\\"+subname+".csv");
					BufferedReader br=new BufferedReader(filer);
					//flag=false;
					String sp;
					while((sp=br.readLine())!=null)
					{
						
						String spi[]=sp.split(",");
						flag=qeuRepo.uploadBulkQuestion(spi,subname);
					}
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
					
				}
				else {
					System.out.println("subject Not Found");
				}
				return true;
			}
			else
			{
				return false;
			}
			
	}

} 
