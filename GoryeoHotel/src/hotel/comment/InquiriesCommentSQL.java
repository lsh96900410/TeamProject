package hotel.comment;

public class InquiriesCommentSQL {

	public static final String INQUIRIESCOMMENT_INSERT = "insert into comments(comm_no, comm_content, comm_date,inquiries_no) values(comments_comm_no_SEQ.nextval, ?, sysdate, ?)";
	public static final String INQUIRIESCOMMENT_UPDATE = "update comments set comm_content = ? where comm_no = ?";
	public static final String INQUIRIESCOMMENT_DELETE = "delete from comments where comm_no = ?";
	public static final String INQUIRIESCOMMENT_SELECT_BY_NO = "select * from comments c join inquiries i on c.inquiries_no = i.inquiries_no join userinfo u on i.user_id = u.user_id where c.comm_no = ? order by i.inquiries_no";
	public static final String SELECT_COMM_BY_INQUIRIES_NO = "select * from comments c join inquiries i on c.inquiries_no = i.inquiries_no where i.inquiries_no=?";
}
