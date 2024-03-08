package org.Exam.services;
import java.util.*;

import org.Exam.Model.ExamModel;
import org.Exam.Model.ScheduleModel;
import org.Exam.Repository.ExamRepository;
public class ExamServices {

	ExamRepository  examRepo=new ExamRepository();
	public int isAddExam(ExamModel model)
	{
		if(examRepo.isExamPresent(model.getName()))
		{
			return -1;
		}
		else if(examRepo.isAddExam(model))
		{
			return 1;
		}
		else
		{
			return 0;
		}
		
	}
	
	public List<ExamModel> getAllExam()
	{
		return examRepo.getAllExam();
	}
	
	public ExamModel getExamIdByName(String name)
	{
		return examRepo.getExamByIdName(name);
	}
	
	public boolean isSetSchedule(ExamModel exam,String subName)
	{
		Date d=new Date();
		String s[]=d.toLocaleString().split(",");
		String dsplit[]=s[0].split("-");
		ScheduleModel smodel=exam.getSchedulemodel();
		Date userDate=smodel.getDate();
		String userDateArr[]=userDate.toLocaleString().split(",");
		String userDates[]=userDateArr[0].split("-");
		System.out.println(userDateArr[0]);
		if(Integer.parseInt(userDates[2])>=Integer.parseInt(dsplit[2]) && userDates[1].equals(dsplit[1]))
		{
			
			if(Integer.parseInt(userDates[0])>=Integer.parseInt(dsplit[0]))
			{
				
				System.out.println("You Schedule exam");
				return examRepo.isSetSchedule(exam,subName)?true:false;
			}
			else {
				System.out.println("You May be Insert date before system date");
			}
			
		}else
		{
			System.out.println("You may Insert Previous year or Month");
		}
		return false;
	}
	
	
}
