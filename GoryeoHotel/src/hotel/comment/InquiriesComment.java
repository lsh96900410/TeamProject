package hotel.comment;

import java.util.Date;

import hotel.inquiries.Inquiries;

public class InquiriesComment {

	private int comm_no;
	private String comm_content;
	private Date comm_date;
	private Inquiries inquiries;
	
	public InquiriesComment() {
		
	}

	public InquiriesComment(int comm_no, String comm_content, Date comm_date, Inquiries inquiries) {
		super();
		this.comm_no = comm_no;
		this.comm_content = comm_content;
		this.comm_date = comm_date;
		this.inquiries = inquiries;
	}

	public int getComm_no() {
		return comm_no;
	}

	public void setComm_no(int comm_no) {
		this.comm_no = comm_no;
	}

	public String getComm_content() {
		return comm_content;
	}

	public void setComm_content(String comm_content) {
		this.comm_content = comm_content;
	}

	public Date getComm_date() {
		return comm_date;
	}

	public void setComm_date(Date comm_date) {
		this.comm_date = comm_date;
	}

	public Inquiries getInquiries() {
		return inquiries;
	}

	public void setInquiries_no(Inquiries inquiries) {
		this.inquiries = inquiries;
	}

	@Override
	public String toString() {
		return "InquiriesComment [comm_no=" + comm_no + ", comm_content=" + comm_content + ", comm_date=" + comm_date
				+ ", inquiries_no=" + inquiries + "]";
	}

}
