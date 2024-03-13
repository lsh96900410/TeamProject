package test;

import hotel.review.Review;
import hotel.review.ReviewDao;
import hotel.user.User;

public class ReviewDaoTestMain {

	public static void main(String[] args) throws Exception {
		
		ReviewDao reviewDao = new ReviewDao();
		
//		System.out.println(">> insert: " + reviewDao.insert(new Review(0, null, "제목1", "내용", new User("eeeee", null, null, null, null, null, null))));
		/*
		System.out.println(">> delete: " + reviewDao.deleteByReviewNo(3));
		
		System.out.println(">> findByNo: " + reviewDao.findByReviewNo(1));
		
		System.out.println(">> findByAll: " + reviewDao.findByAll());
		*/
	}

}
