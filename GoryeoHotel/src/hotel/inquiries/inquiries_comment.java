package hotel.inquiries;

public class inquiries_comment {
	
	private int comm_No;
	private String comm_Title;
	private String comm_Content;
	
	private Inquiries inquiries;
	
	public inquiries_comment() {
		// TODO Auto-generated constructor stub
	}

	public inquiries_comment(int comm_No, String comm_Title, String comm_Content, Inquiries inquiries) {
		super();
		this.comm_No = comm_No;
		this.comm_Title = comm_Title;
		this.comm_Content = comm_Content;
		this.inquiries = inquiries;
	}

	public int getComm_No() {
		return comm_No;
	}

	public void setComm_No(int comm_No) {
		this.comm_No = comm_No;
	}

	public String getComm_Title() {
		return comm_Title;
	}

	public void setComm_Title(String comm_Title) {
		this.comm_Title = comm_Title;
	}

	public String getComm_Content() {
		return comm_Content;
	}

	public void setComm_Content(String comm_Content) {
		this.comm_Content = comm_Content;
	}

	public Inquiries getInquiries() {
		return inquiries;
	}

	public void setInquiries(Inquiries inquiries) {
		this.inquiries = inquiries;
	}

	@Override
	public String toString() {
		return "inquiries_comment [comm_No=" + comm_No + ", comm_Title=" + comm_Title + ", comm_Content=" + comm_Content
				+ ", inquiries=" + inquiries + "]";
	}
	
	
	
}
