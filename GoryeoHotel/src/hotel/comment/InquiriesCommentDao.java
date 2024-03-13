package hotel.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.RowFilter;

import common.DataSource;
import hotel.inquiries.Inquiries;
import hotel.user.User;

public class InquiriesCommentDao {

	private DataSource dataSource;
	
	public InquiriesCommentDao() throws Exception {
		dataSource = new DataSource();
	}
	
	public int insert(InquiriesComment comment) throws Exception {
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(InquiriesCommentSQL.INQUIRIESCOMMENT_INSERT);
		
		pstmt.setString(1, comment.getComm_content());
		pstmt.setInt(2, comment.getInquiries().getInquiries_no());
		
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dataSource.close(con);
		
		return rowCount;
	}
	
	public int updateByInquiriesCommentNo(InquiriesComment comment) throws Exception {
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(InquiriesCommentSQL.INQUIRIESCOMMENT_UPDATE);
		
		pstmt.setString(1, comment.getComm_content());
		pstmt.setInt(2, comment.getComm_no());
		
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dataSource.close(con);
		
		return rowCount;
	}
	
	public int deleteByInquiriesCommentNo(int no) throws Exception {
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(InquiriesCommentSQL.INQUIRIESCOMMENT_DELETE);
		
		pstmt.setInt(1, no);
		
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dataSource.close(con);
		
		return rowCount;
	}
	
	public InquiriesComment findByInquiriesCommentNo(int no) throws Exception {
		
		InquiriesComment findInquiriesComment = null;
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(InquiriesCommentSQL.INQUIRIESCOMMENT_SELECT_BY_NO);
		
		pstmt.setInt(1, no);
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			findInquiriesComment = new InquiriesComment(rs.getInt("comm_no"), 
														rs.getString("comm_content"), 
														rs.getDate("comm_date"), 
														new Inquiries(rs.getInt("inquiries_no"), 
																		rs.getString("inquiries_title"), 
																		rs.getString("inquiries_content"), 
																		rs.getDate("inquiries_date"), 
														new User(rs.getString("user_id"), 
																null, 
																rs.getString("user_name"), 
																rs.getString("user_tel"),
																rs.getString("user_email"), 
																null, 
																new ArrayList<Inquiries>()), 
																null));
		}
		
		rs.close();
		pstmt.close();
		dataSource.close(con);
		
		return findInquiriesComment;
	
	}
public InquiriesComment findCommByInquiriesNo(int inquiriesNo) throws Exception {
		
		InquiriesComment findInquiriesComment = null;
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(InquiriesCommentSQL.SELECT_COMM_BY_INQUIRIES_NO);
		
		pstmt.setInt(1, inquiriesNo);
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			findInquiriesComment = new InquiriesComment(rs.getInt("comm_no"), 
														rs.getString("comm_content"), 
														rs.getDate("comm_date"), 
														new Inquiries(rs.getInt("inquiries_no"), 
																		rs.getString("inquiries_title"), 
																		rs.getString("inquiries_content"), 
																		rs.getDate("inquiries_date"), 
														new User(rs.getString("user_id"), 
																null, 
																null, 
																null,
																null, 
																null, 
																new ArrayList<Inquiries>()), 
																null));
		}
		
		rs.close();
		pstmt.close();
		dataSource.close(con);
		
		return findInquiriesComment;
	
	}
}
