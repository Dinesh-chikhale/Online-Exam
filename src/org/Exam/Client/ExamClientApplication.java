package org.Exam.Client;
import java.util.*;
import java.util.Date;
import org.Exam.Model.ExamModel;
import org.Exam.Model.QuestionModel;
import org.Exam.Model.ScheduleModel;
import org.Exam.Model.StudentModel;
import org.Exam.Model.SubjectModel;
import org.Exam.Repository.QuestionRepository;
import org.Exam.services.ExamServices;
import org.Exam.services.QuestionServices;
import org.Exam.services.StudentServices;
import org.Exam.services.SubjectService;

public class ExamClientApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubjectService sv=new SubjectService();
		QuestionServices qs=new QuestionServices();
		ExamServices examServices=new ExamServices();
		ExamModel exam=new ExamModel();
		 QuestionRepository  qr=new  QuestionRepository();
		do {
			System.out.println("case 1: Add New Subject");
			System.out.println("case 2: Add Question");
			System.out.println("case 3: Add Bulk Question");
			System.out.println("case 4: Add Exam");
			System.out.println("case 5: create Exam Schedule");
			System.out.println("Enter your choice");
			Scanner s=new Scanner(System.in);
			int choice=s.nextInt();
			switch(choice)
			{
				case 1:
					System.out.println("Enter subject name");
					String subname=s.next();
					SubjectModel sm=new SubjectModel();
					sm.setSubjectname(subname);
					int result=sv.addSubject(sm);
					if(result==1)
					{
						System.out.println("Subject Added Sucessfully");
					}
					else if(result==-1)
					{
						System.out.println("Subject Already Present in databases");
					}
					else {
						System.out.println("Subject not added Sucessfully");
					}
					break;
				case 2:
					int answer;
					String questionname,op1,op2,op3,op4;
					s.nextLine();
					System.out.println("Enter the question");
					questionname=s.nextLine();
					System.out.println("Enter the First Op1");
					op1=s.nextLine();
					System.out.println("Enter the Seconf op2");
					op2=s.nextLine();
					System.out.println("Enter the Third Op3");
					op3=s.nextLine();
		
					System.out.println("Enter the Fourth Op4");
					op4=s.nextLine();
					System.out.println("Enter the Answer Given Option");
					answer=s.nextInt();
					s.nextLine();
					System.out.println("Enter the Subject Name");
					subname=s.nextLine();
					QuestionModel qm=new QuestionModel();
					qm.setQuestionname(questionname);
					qm.setOp1(op1);
					qm.setOp2(op2);
					qm.setOp3(op3);
					qm.setOp4(op4);
					qm.setAnswer(answer);
				
					boolean val=qs.isAddQuestion(qm,subname);
					if(val)
					{
						System.out.println("Question added Sucessfully");
					}
					else {
						System.out.println(" Question Not Added Sucessfully");
					}
					break;
				case 3:
					s.nextLine();
					System.out.println("Enter the subject name store in bulk question");
					subname=s.nextLine();
					 boolean bk=qs.uploadBulkQuestion(subname);
					 if(bk)
					 {
						 System.out.println("Data Uploaded Sucessfully");
					 }
					 else {
						 System.out.println("Data Not Uploaded Sucessfully");
					 }
					break;
				case 4:
					s.nextLine();
					String examName;
					int totalMark,passingMarks;
					System.out.println("Enter the exam Name");
					examName=s.nextLine();
					System.out.println("Enter the TotalMArks");
					totalMark=s.nextInt();
					System.out.println("Enter the PassingMarks");
					passingMarks=s.nextInt();
					exam.setName(examName);
					exam.setTotalMarks(totalMark);
					exam.setPassingMarks(passingMarks);
					result=examServices.isAddExam(exam);
					if(result==1)
					{
						System.out.println("Exam Added Sucessfully");
					}
					else if(result==-1)
					{
						System.out.println("Exam Alredy Present in ");
					}
					else
					{
						System.out.println("Exam Not Added Sucessfully");
					}
					break;
				case 5:
					s.nextLine();
					List<ExamModel> list=examServices.getAllExam();
					System.out.println("hey you Have List Of Exam and select one schedule for exam");
					System.out.println("===================================================================");
					for(ExamModel m:list)
					{
						System.out.println(m.getId()+"\t"+m.getName()+"\t"+m.getTotalMarks()+"\t"+m.getTotalMarks());
					}
					System.out.println("====================================================");
					String starttime;
					String endtime;
					System.out.println("Enter the exam name for schedule");
					examName=s.nextLine();
					ExamModel emodel=examServices.getExamIdByName(examName);
					if(emodel!=null)
					{
						System.out.println("Enter the ExamDate and starttime ,endtime");
						String dateformat=s.nextLine();
						Date DD=new Date(dateformat);
						 starttime=s.nextLine();
						 endtime=s.nextLine();
						
						 ScheduleModel smodel=new ScheduleModel();
						 smodel.setDate(DD);
						 smodel.setStarttime(starttime);
						 smodel.setEndtime(endtime);
						 System.out.println(emodel.getId());
						 smodel.setExamid(emodel.getId());
						 exam.setSchedulemodel(smodel);
						 System.out.println("Enter the subject Name for exam");
						 String subName=s.nextLine();
						boolean b= examServices.isSetSchedule(exam,subName);
						if(b)
						{
							System.out.println("Schedule will be created");
						}
						else {
							System.out.println("Not created");
						}
					}
					else {
						System.out.println("Not Exam ");
					}
					break;
				case 6:
					s.nextLine();
					System.out.println("Enter the student id");
					int stid=s.nextInt();
					s.nextLine();
					System.out.println("Enter the student name");
					String name=s.nextLine();
					System.out.println("Enter the Student email");
					String email=s.nextLine();
					System.out.println("Enter the student contact");
					String contact=s.nextLine();
					System.out.println("Enter the student userName");
					String username=s.nextLine();
					System.out.println("Enter the student Password");
					String password=s.nextLine();
					StudentModel stmodel=new StudentModel();
					stmodel.setStid(stid);
					stmodel.setName(name);
					stmodel.setEmail(email);
					stmodel.setContact(contact);
					stmodel.setUserName(username);
					stmodel.setPassWord(password);
					StudentServices stdservices=new StudentServices();
					boolean  b=stdservices.isAddStudent(stmodel);
					if(b)
					{
						System.out.println("Student Added");
					}
					else {
						System.out.println("Student not Addded ");
					}
					
					break;
					
					default :
						System.out.println("Wrong choice");
			}
			
		}while(true);
		

	}

	

}
