package org.Exam.Model;

public class ExamModel {

	private int id;
	private String name;
	private int totalMarks;
	private int passingMarks;
	ScheduleModel schedulemodel;
	public ScheduleModel getSchedulemodel() {
		return schedulemodel;
	}
	public void setSchedulemodel(ScheduleModel schedulemodel) {
		this.schedulemodel = schedulemodel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public int getPassingMarks() {
		return passingMarks;
	}
	public void setPassingMarks(int passingMarks) {
		this.passingMarks = passingMarks;
	}
	
}
