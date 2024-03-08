package org.Exam.Model;

import java.util.Date;


public class ScheduleModel {
	private int schid;
	private int examid;
	private Date date;
	private String starttime;
	private String endtime;
	private int sid;
	public ScheduleModel()
	{
		
	}
	public ScheduleModel(int examid,Date date,String starttime,String endtime)
	{
		this.examid=examid;
		this.date=date;
		this.starttime=starttime;
		this.endtime=endtime;
	}
	public int getSchid() {
		return schid;
	}
	public void setSchid(int schid) {
		this.schid = schid;
	}
	public int getExamid() {
		return examid;
	}
	public void setExamid(int examid) {
		this.examid = examid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
}
