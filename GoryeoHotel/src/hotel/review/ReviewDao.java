package hotel.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DataSource;
import hotel.reserv.Reserv;
import hotel.room.Room;
import hotel.room_type.RoomType;
import hotel.user.User;

public class ReviewDao {

	private DataSource dataSource;
	
	public ReviewDao() throws Exception {
		dataSource = new DataSource();
	}
	
	public int insert(Review review) throws Exception {
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ReviewSQL.REVIEW_INSERT);
		
		pstmt.setString(1, review.getReview_title());
		pstmt.setString(2, review.getReview_content());
		pstmt.setString(3, review.getUser().getUser_Id());
		
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dataSource.close(con);
		
		return rowCount;
	}
	
	public int updateByReviewNo(Review review) throws Exception {
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ReviewSQL.REVIEW_UPDATE);
		
		pstmt.setString(1, review.getReview_title());
		pstmt.setString(2, review.getReview_content());
		pstmt.setInt(3, review.getReview_no());
		
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dataSource.close(con);
		
		return rowCount;
		
	}
	
	public int deleteByReviewNo(int no) throws Exception {
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ReviewSQL.REVIEW_DELETE);
		
		pstmt.setInt(1, no);
		
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dataSource.close(con);
		
		return rowCount;
	}
	
	
	public Review findByReviewNo(int no) throws Exception {
		
		Review review = null;
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ReviewSQL.REVIEW_SELECT_BY_NO);
		
		pstmt.setInt(1, no);
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			review = new Review(rs.getInt("review_no"), 
								rs.getDate("review_date"), 
								rs.getString("review_title"), 
								rs.getString("review_content"),
								new User(rs.getString("user_id"), null, null, null, null, null, null),
								new Reserv(0, null, null, 0, 0, false, 0, new Room(0, new RoomType(0, rs.getString("room_type_name"), null, null, null, 0, 0, null), null), null, null, null));
		}
		
		rs.close();
		pstmt.close();
		dataSource.close(con);
		
		return review;
	}
	
	
	public List<Review> findByAll() throws Exception {
		
		List<Review> reviewList = new ArrayList<Review>();
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ReviewSQL.REVIEW_SELECT_BY_ALL);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			reviewList.add(new Review(rs.getInt("review_no"), 
										rs.getDate("review_date"), 
										rs.getString("review_title"), 
										rs.getString("review_content"),
										new User(rs.getString("user_id"), null, null, null, null, null, null),
										new Reserv(0, null, null, 0, 0, false, 0, new Room(0, new RoomType(0, rs.getString("room_type_name"), null, null, null, 0, 0, null), null), null, null, null)));
		}
		
		rs.close();
		pstmt.close();
		dataSource.close(con);
		
		return reviewList;
		
	}
public List<Review> findAll() throws Exception {
		
		List<Review> reviewList = new ArrayList<Review>();
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ReviewSQL.REVIEW_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			reviewList.add(new Review(rs.getInt("review_no"), 
										rs.getDate("review_date"), 
										rs.getString("review_title"), 
										rs.getString("review_content"),
										new User(rs.getString("user_id"), null, null, null, null, null, null),
										new Reserv(0, null, null, 0, 0, false, 0, new Room(0, new RoomType(0, null, null, null, null, 0, 0, null), null), null, null, null)));
		}
		
		rs.close();
		pstmt.close();
		dataSource.close(con);
		
		return reviewList;
		
	}
	
}
	

