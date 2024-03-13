package test;

import hotel.comment.InquiriesComment;
import hotel.comment.InquiriesCommentService;
import hotel.inquiries.Inquiries;

public class InquiriesCommentServiecTestMain {

	public static void main(String[] args) throws Exception{
		
		InquiriesCommentService inquiriesCommentService = new InquiriesCommentService();
		
		System.out.println("답변작성");
		System.out.println(inquiriesCommentService.insertInquiriesComment(new InquiriesComment(0, "답변", null, new Inquiries(2, null, null, null, null, null))));
		
		System.out.println("답변수정");
		System.out.println(inquiriesCommentService.updateInquiriesComment(new InquiriesComment(0, "답변수정", null, new Inquiries(0, null, null, null, null, null))));
		
		System.out.println("답변삭제");
		System.out.println(inquiriesCommentService.deleteInquiriesComment(3));
		
		System.out.println("답변찾기");
		System.out.println(inquiriesCommentService.findByInquiriesComment(0));
		
	}

}
