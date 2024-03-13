package test;

import hotel.comment.InquiriesComment;
import hotel.inquiries.Inquiries;
import hotel.inquiries.InquiriesDao;
import hotel.user.User;

public class InquiriesDaoTestMain {

	public static void main(String[] args) throws Exception {
		
		InquiriesDao inquiriesDao = new InquiriesDao();
		
		System.out.println(">> insert: " + inquiriesDao.insert(new Inquiries(0, "제목", "내용", null, 
																new User("aaaa", null, null, null, null, null, null),
																new InquiriesComment(0, null, null, null))));
		
		Inquiries findInquiries = inquiriesDao.findByinquiriesNo(3);
		findInquiries.setInquiries_title("변경");
		findInquiries.setInquiries_content("변경내용");
		System.out.println(">> update: " + inquiriesDao.updateByInquiriesNo(findInquiries));
		
		System.out.println(">> delete: " + inquiriesDao.deleteByInquiriesNo(7));
		
		System.out.println(">> findByNo: " + inquiriesDao.findByinquiriesNo(4));
		
		System.out.println(">> findAll: " + inquiriesDao.findByAll());
		
	}

}