package hotel.user;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import common.DataSource;
import hotel.inquiries.Inquiries;

public class UserDao {
	private DataSource dataSource;
	
	public UserDao() throws Exception{
		dataSource=new DataSource();
	}
	
	// create(insert) User테이블에 새로운 생성자.
	public int insert(User user) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UserSQL.USER_INSERT);
		pstmt.setString(1, user.getUser_Id());
		pstmt.setString(2, user.getUser_Password());
		pstmt.setString(3, user.getUser_Name());
		pstmt.setString(4, user.getUser_Tel());
		pstmt.setString(5, user.getUser_Email());
		pstmt.setString(6, user.getUser_Jumin());
		
		int insertRowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return insertRowCount;
	}
	
	//update 정보수정
	public int update(User user) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UserSQL.USER_UPDATE);
		pstmt.setString(1, user.getUser_Password());
		pstmt.setString(2, user.getUser_Name());
		pstmt.setString(3, user.getUser_Tel());
		pstmt.setString(4, user.getUser_Email());
		pstmt.setString(5, user.getUser_Jumin());
		pstmt.setString(6, user.getUser_Id());
		int insertRowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return insertRowCount;
	}
	
	//delete 삭제
	public int delete(String userid) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UserSQL.USER_REMOVE);
		pstmt.setString(1, userid);
		int deleteRowCount = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return deleteRowCount;
	}
	
	public User findByPrimaryKey(String userId) throws Exception {
		User findUser = null;
	    Connection con = dataSource.getConnection();
	    PreparedStatement pstmt = con.prepareStatement(UserSQL.USER_SELECT_BY_ID);
	    pstmt.setString(1, userId);
	    ResultSet rs = pstmt.executeQuery();
	    if (rs.next()) {
	        findUser = new User(
	            rs.getString("USER_ID"),
	            rs.getString("USER_PASSWORD"),
	            rs.getString("USER_NAME"),
	            rs.getString("USER_TEL"),
	            rs.getString("USER_EMAIL"),
	            rs.getString("USER_JUMIN"),
	            null
	            
	        );
	    }
		pstmt.close();
		con.close();
	    return findUser;
	}
	//아이디찾기
	public User findByUserId(String userName, String userJumin) throws Exception {
	    User findUser = null;
	    Connection con = dataSource.getConnection();
	    PreparedStatement pstmt = con.prepareStatement(UserSQL.USER_SELECT_BY_ID_FIND);
	    pstmt.setString(1, userName);
	    pstmt.setString(2, userJumin);
	    ResultSet rs = pstmt.executeQuery();
	    if (rs.next()) {
	        findUser = new User(
	            rs.getString("USER_ID"),
	            null,
	            null,
	            null,
	            null,
	            null,
	            new ArrayList<Inquiries>()
	        );
	    }
	    pstmt.close();
	    con.close();
	    return findUser;
	}
	
	//비밀번호찾기
	public User findByUserPassword(String userId,String userName, String userJumin)throws Exception{
		User findUser=null;
		Connection con =dataSource.getConnection();
		PreparedStatement pstmt =con.prepareStatement(UserSQL.USER_SELECT_BY_PASSWORD_FIND);
		pstmt.setString(1,userId);
		pstmt.setString(2,userName);
		pstmt.setString(3,userJumin);
	    ResultSet rs = pstmt.executeQuery();
	    if (rs.next()) {
	        findUser = new User(
	        		null,
	            rs.getString("USER_PASSWORD"),
	            null,
	            null,
	            null,
	            null,
	            new ArrayList<Inquiries>()
	        );
	    }
	    pstmt.close();
	    con.close();
	    return findUser;
	}
	//전체유저
	public ArrayList<User> findAll() throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(UserSQL.USER_SELECT_ALL);
		ResultSet rs=pstmt.executeQuery();
		ArrayList<User> userList = new ArrayList<User>();
		while(rs.next()) {
			userList.add(new User(
					rs.getString("USER_ID"),
		            rs.getString("USER_PASSWORD"),
		            rs.getString("USER_NAME"),
		            rs.getString("USER_TEL"),
		            rs.getString("USER_EMAIL"),
		            rs.getString("USER_JUMIN"),
		            null)
					);
		}
		return userList;
	}
	
	 //사용자가 존재하는지 여부를 확인
	public int countByUserId(String userId) throws Exception {
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(UserSQL.USER_SELECT_BY_ID_COUNT);
		pstmt.setString(1, userId);
		ResultSet rs=pstmt.executeQuery();
		rs.next();
		int userCount = rs.getInt(1);
		return userCount;
		
	}
	
	
}