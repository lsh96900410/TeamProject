package hotel.review;

public class ReviewSQL {
	
	public static final String REVIEW_INSERT = "insert into review(review_no, review_date, review_title, review_content, user_id) values(review_review_no_SEQ.nextval, sysdate, ?, ?, ?)";
	public static final String REVIEW_UPDATE = "update review set review_title = ?, review_content = ? where review_no = ?";
	public static final String REVIEW_DELETE = "delete from review where review_no = ?";

	public static final String REVIEW_SELECT_BY_NO = "select r.review_no, r.review_date, r.review_title, r.review_content, u.user_id, rt.room_type_name from review r join userinfo u on r.user_id = u.user_id join reserv rl on u.user_id = rl.user_id join room rm on rl.room_no = rm.room_no join room_type rt on rm.room_type_no = rt.room_type_no where r.review_no = ?";
	public static final String REVIEW_SELECT_BY_ALL = "select r.review_no, r.review_date, r.review_title, r.review_content, u.user_id, rt.room_type_name from review r join userinfo u on r.user_id = u.user_id join reserv rl on u.user_id = rl.user_id join room rm on rl.room_no = rm.room_no join room_type rt on rm.room_type_no = rt.room_type_no order by r.review_no desc";
	public static final String REVIEW_SELECT_ALL = "select * from review order by review_no desc";

}
