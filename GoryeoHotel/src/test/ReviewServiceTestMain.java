package test;

import hotel.review.Review;
import hotel.review.ReviewService;
import hotel.user.User;

public class ReviewServiceTestMain {

	public static void main(String[] args) throws Exception {
		
		ReviewService reviewService = new ReviewService();
		
		System.out.println("리뷰작성");
//		System.out.println(reviewService.insertReview(new Review(0, null, "리뷰", "내용", new User("dddd", null, null, null, null, null, null))));
		
		System.out.println("리뷰수정");
//		System.out.println(reviewService.updateReview(new Review(3, null, "리뷰수정", "내용수정", new User("dddd", null, null, null, null, null, null))));
		
		System.out.println("리뷰삭제");
//		System.out.println(reviewService.deleteReview(2));
		
		System.out.println("리뷰선택");
//		System.out.println(reviewService.findByReviewNo(1));
		
		System.out.println("리뷰전체");
//		System.out.println(reviewService.findByAll());
		
		
	}

}
