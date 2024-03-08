package org.Exam.services;
import java.util.*;
import org.Exam.Model.SubjectModel;
import org.Exam.Repository.SubjectRepository;
import java.util.*;
public class SubjectService {

	SubjectRepository subRepo=new SubjectRepository();
	
	public int addSubject(SubjectModel model) {
		return subRepo.isSubjectPresent(model)?-1:subRepo.isAddSubject(model)?1:0;
		//return subRepo.isSubjectPresent(model)?-1:subRepo.isAddSubject(model)?1:0;
	}
	public List<String> getAddSubject()
	{
		return this.subRepo.getAllSubject();
	}
	
	
}



	
