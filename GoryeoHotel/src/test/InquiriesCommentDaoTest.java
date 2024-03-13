package test;

import hotel.comment.InquiriesComment;
import hotel.comment.InquiriesCommentDao;
import hotel.inquiries.Inquiries;

public class InquiriesCommentDaoTest {

	public static void main(String[] args) throws Exception {
		
		InquiriesCommentDao inquiriesCommentDao = new InquiriesCommentDao();
		
		System.out.println(">> insert: " + inquiriesCommentDao.insert(new InquiriesComment(0, "답변", null, new Inquiries(2, null, null, null, null, null))));
		
		System.out.println(">> delete: " + inquiriesCommentDao.deleteByInquiriesCommentNo(0));
		
		InquiriesComment findInquiriesComment = inquiriesCommentDao.findByInquiriesCommentNo(3);
		findInquiriesComment.setComm_content("답변변경");
		System.out.println(">> update: " + inquiriesCommentDao.updateByInquiriesCommentNo(findInquiriesComment));
		
		System.out.println(">> findByNo: " + inquiriesCommentDao.findByInquiriesCommentNo(1));
	}

}
