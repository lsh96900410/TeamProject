package test;

import hotel.comment.InquiriesComment;
import hotel.inquiries.Inquiries;
import hotel.inquiries.InquiriesService;
import hotel.user.User;

public class InquiriesServiceTestMain {

	public static void main(String[] args) throws Exception {
		
		InquiriesService inquiriesService = new InquiriesService();
		
		
		System.out.println("문의작성");
		System.out.println(inquiriesService.insertInquiries(new Inquiries(0, "문의", "문의내용", null, new User("aaaa", null, null, null, null, null, null), new InquiriesComment(0, null, null, null))));
		
		
		System.out.println("문의수정");
		System.out.println(inquiriesService.updateInquiries(new Inquiries(7, "문의수정", "문의내용수정", null, new User("aaaa", null, null, null, null, null, null), new InquiriesComment(0, null, null, null))));
		
		System.out.println("문의삭제");
		System.out.println(inquiriesService.deleteInquiries(8));
		
		System.out.println("문의선택");
		System.out.println(inquiriesService.findByInquiries(6));
		
		System.out.println("문의전체");
		System.out.println(inquiriesService.findByAll());
	}

}
