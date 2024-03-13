package hotel.inquiries;

import java.util.List;

public class InquiriesService {

	private InquiriesDao inquiriesDao;
	
	public InquiriesService() throws Exception {
		inquiriesDao = new InquiriesDao();
	}
	
	public int insertInquiries(Inquiries inquiries) throws Exception {
		
		return inquiriesDao.insert(inquiries);
		
	}
	
	public int updateInquiries(Inquiries inquiries) throws Exception {
		
		return inquiriesDao.updateByInquiriesNo(inquiries);
		
	}
	
	public int deleteInquiries(int no) throws Exception {
		
		return inquiriesDao.deleteByInquiriesNo(no);
		
	}
	
	public Inquiries findByInquiries(int no) throws Exception {
		
		return inquiriesDao.findByinquiriesNo(no);
		
	}
	
	public List<Inquiries> findByAll() throws Exception {
		
		return inquiriesDao.findByAll();
		
	}
public List<Inquiries> findById(String userid) throws Exception {
		
		return inquiriesDao.findById(userid);
		
	}
}
