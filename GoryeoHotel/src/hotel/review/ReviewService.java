package hotel.review;

import java.util.List;

public class ReviewService {
	
	private ReviewDao reviewDao;
	
	public ReviewService() throws Exception {
		reviewDao = new ReviewDao();
	}
	
	public int insertReview(Review review) throws Exception {
		
		return reviewDao.insert(review);
		
	}
	
	public int updateReview(Review review) throws Exception {
		
		return reviewDao.updateByReviewNo(review);
		
	}
	
	public int deleteReview(int no) throws Exception {
		
		return reviewDao.deleteByReviewNo(no);
		
	}
	
	public Review findByReviewNo(int no) throws Exception {
		
		return reviewDao.findByReviewNo(no);
		
	}
	
	public List<Review> findByAll() throws Exception {
		
		return reviewDao.findByAll();
		
	}
public List<Review> findAll() throws Exception {
		
		return reviewDao.findAll();
		
	}
}
