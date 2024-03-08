package org.Exam.services;

import org.Exam.Model.StudentModel;
import org.Exam.Repository.StudentRepository;

public class StudentServices {

	StudentRepository sRepo=new StudentRepository();
	public boolean isAddStudent(StudentModel smodel)
	{
		return sRepo.isAddStudent(smodel);
	}
}
