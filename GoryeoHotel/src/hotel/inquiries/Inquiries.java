package hotel.inquiries;

import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

import hotel.comment.InquiriesComment;
import hotel.user.User;

public class Inquiries {

	private int inquiries_no;
	private String inquiries_title;
	private String inquiries_content;
	private Date inquiries_date;
	private User user;
	private InquiriesComment inquiries_comment;
	
	public Inquiries() {	

	}

	public Inquiries(int inquiries_no, String inquiries_title, String inquiries_content, Date inquiries_date, User user,
			InquiriesComment inquiries_comment) {
		super();
		this.inquiries_no = inquiries_no;
		this.inquiries_title = inquiries_title;
		this.inquiries_content = inquiries_content;
		this.inquiries_date = inquiries_date;
		this.user = user;
		this.inquiries_comment = inquiries_comment;
	}

	public int getInquiries_no() {
		return inquiries_no;
	}

	public void setInquiries_no(int inquiries_no) {
		this.inquiries_no = inquiries_no;
	}

	public String getInquiries_title() {
		return inquiries_title;
	}

	public void setInquiries_title(String inquiries_title) {
		this.inquiries_title = inquiries_title;
	}

	public String getInquiries_content() {
		return inquiries_content;
	}

	public void setInquiries_content(String inquiries_content) {
		this.inquiries_content = inquiries_content;
	}

	public Date getInquiries_date() {
		return inquiries_date;
	}

	public void setInquiries_date(Date inquiries_date) {
		this.inquiries_date = inquiries_date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public InquiriesComment getInquiries_comment() {
		return inquiries_comment;
	}

	public void setInquiries_comment(InquiriesComment inquiries_comment) {
		this.inquiries_comment = inquiries_comment;
	}

	@Override
	public String toString() {
		return "Inquiries [inquiries_no=" + inquiries_no + ", inquiries_title=" + inquiries_title
				+ ", inquiries_content=" + inquiries_content + ", inquiries_date=" + inquiries_date + ", user=" + user
				+ ", inquiries_comment=" + inquiries_comment + "]";
	}
	
	

	
	

}
