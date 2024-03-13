package hotel.inquiries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DataSource;
import hotel.comment.InquiriesComment;
import hotel.user.User;

public class InquiriesDao {

	private DataSource dataSource;
	
	public InquiriesDao() throws Exception {
		dataSource = new DataSource();
	}
	
	public int insert(Inquiries inquiries) throws Exception {
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(InquiriesSQL.INQUIRIES_INSERT);
		
		pstmt.setString(1, inquiries.getInquiries_title());
		pstmt.setString(2, inquiries.getInquiries_content());
		pstmt.setString(3, inquiries.getUser().getUser_Id());
		
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dataSource.close(con);
		
		return rowCount;
	}
	
	public int updateByInquiriesNo(Inquiries inquiries) throws Exception {
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(InquiriesSQL.INQUIRIES_UPDATE);
		
		pstmt.setString(1, inquiries.getInquiries_title());
		pstmt.setString(2, inquiries.getInquiries_content());
		pstmt.setInt(3, inquiries.getInquiries_no());
		
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dataSource.close(con);
		
		return rowCount;
	}
	
	public int deleteByInquiriesNo(int no) throws Exception {
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(InquiriesSQL.INQUIRIES_DELETE);
		
		pstmt.setInt(1, no);
		
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dataSource.close(con);
		
		return rowCount;
	}
	
	public Inquiries findByinquiriesNo(int no) throws Exception {
		
		Inquiries inquiries = null;
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(InquiriesSQL.INQUIRIES_SELECT_BY_NO);
		
		pstmt.setInt(1, no);
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			inquiries = new Inquiries(rs.getInt("inquiries_no"),
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
													null);

		}
		

		rs.close();
		pstmt.close();
		dataSource.close(con);
		
		return inquiries;
	}
	
	public List<Inquiries> findByAll() throws Exception {
		
		List<Inquiries> inquiriesList = new ArrayList<Inquiries>();
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(InquiriesSQL.INQUIRIES_SELECT_BY_ALL);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {

			inquiriesList.add(new Inquiries(rs.getInt("inquiries_no"), 
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
											new InquiriesComment(rs.getInt("comm_no"), rs.getString("comm_content"), rs.getDate("comm_date"), null)));
		}
		
		rs.close();
		pstmt.close();
		dataSource.close(con);
		
		return inquiriesList;
	}
public List<Inquiries> findById(String userId) throws Exception {
		
		List<Inquiries> inquiriesList = new ArrayList<Inquiries>();
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(InquiriesSQL.INQUIRIES_SELECT_BY_ID);
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			User user =new User(rs.getString("user_id"), null, null, null, null,null, new ArrayList<Inquiries>());
			InquiriesComment inquiriesComment = new InquiriesComment(rs.getInt("comm_no"),rs.getString("comm_content"),rs.getDate("comm_date"),null);
			Inquiries inquiries = new Inquiries(rs.getInt("inquiries_no"), rs.getString("inquiries_title"),rs.getString("inquiries_content"), rs.getDate("inquiries_date"),user,inquiriesComment);
			inquiriesList.add(inquiries);
		}
		
		rs.close();
		pstmt.close();
		dataSource.close(con);
		
		return inquiriesList;
	}
}
