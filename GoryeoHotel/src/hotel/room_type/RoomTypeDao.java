package hotel.room_type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DataSource;
import hotel.room.Room;

public class RoomTypeDao {
	private DataSource dataSource;
	public RoomTypeDao() throws Exception {
	dataSource=new DataSource();
	}
	
	/***************** insert RoomType  ******************/
	
	public int insertRoomType(RoomType roomType) throws Exception{
		int rowCount=0;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(RoomTypeSQL.INSERT_ROOM_TYPE);
		pstmt.setInt(1, roomType.getRoomTypeNo());
		pstmt.setString(2, roomType.getRoomTypeName());
		pstmt.setString(3, roomType.getRoomTypeImg());
		pstmt.setString(4, roomType.getRoomTypeDetail());
		//pstmt.setBoolean(5, roomType.getRoomTypePool());
		rowCount=pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
	
	/*************** 객실 별 잔여객수 확인 ******************/
	
	public RoomType findQtyByRoomTypeName(String typeName) throws Exception{
		RoomType findQty =null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(RoomTypeSQL.FIND_QTY_BY_ROOM_TYPE_NAME);
		pstmt.setString(1, typeName);
		ResultSet rs =pstmt.executeQuery();
		if(rs.next()) {
			
		}
		rs.close();
		pstmt.close();
		dataSource.close(con);
		return findQty;
	}
	
	/************** 객실 상세보기 *************************/
	public RoomType findRoomDetail(String typeName) throws Exception{
		RoomType findRoomType=null;
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(RoomTypeSQL.Find_ROOM_DETAIL);
		pstmt.setString(1, typeName);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
						
		}
		rs.close();
		pstmt.close();
		dataSource.close(con);
		return findRoomType;
	}
	
	/*********************************    객실 가격 변경*******************************/
	
	public int updateRoomPrice(int price , int no) throws Exception{
		int rowCount=0;
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(RoomTypeSQL.ROW_PRICE);
		pstmt.setInt(1, price);
		pstmt.setInt(2, no);
		rowCount=pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
	
	
	/******************** update By RoomTypeNo ****************************/
	public int updateRoomType(RoomType roomType) throws Exception{
		int rowCount =0;
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(RoomTypeSQL.UPDATE_ROOM_TYPE);
		pstmt.setString(1, roomType.getRoomTypeDetail());
		//pstmt.setBoolean(2, roomType.getRoomTypePool());
		pstmt.setInt(3, roomType.getRoomTypeNo());
		rowCount=pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
	

	/******************** deleteByRoomTypeNo *********************************/
	public int deleteRoomType(int roomTypeNo) throws Exception{
		int rowCount=0;
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(RoomTypeSQL.DELETE_ROOM_TYPE);
		pstmt.setInt(1, roomTypeNo);
		rowCount=pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
	
	//룸넘버로 룸타입 찾기 
	public RoomType findRoomTypeByRoomNo(int roomNo) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(RoomTypeSQL.SELECT_ROOM_TYPE_BY_ROOM_NO);
		pstmt.setInt(1,roomNo);
		ResultSet rs = pstmt.executeQuery();
		RoomType roomtype = null;
		if(rs.next()) {
			roomtype = new RoomType(rs.getInt("room_type_no"), rs.getString("room_type_name"), rs.getString("room_type_img"), rs.getString("room_type_detail"), rs.getBoolean("room_type_pool"), rs.getInt("room_type_qty"), rs.getInt("room_type_price"), new ArrayList<Room>());
		}
		rs.close();
		pstmt.close();
		dataSource.close(con);
		return roomtype;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/******************** select by RoomTypeName ***************************/
	/*
	public RoomType selectByRoomTypeName(int roomTypeNo) throws Exception{
		RoomType findRoomType =null;
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(RoomTypeSQL.SELECT_BY_ROOM_TYPE_NO);
		pstmt.setInt(1, roomTypeNo);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			findRoomType=new RoomType(rs.getInt("room_type_no"), 
						 			  rs.getString("room_type_name"), 
						 			  rs.getString("room_type_img"), 
						 			  rs.getString("room_type_detail"),
						 			  rs.getBoolean("room_type_qty"),
						 			  0 );
		}
		rs.close();
		pstmt.close();
		dataSource.close(con);
		return findRoomType;
	}
	
	
	/*********************** select all 기본 ***************************/
	/*
	public List<RoomType> selectAll() throws Exception{
		List<RoomType> roomTypeList = new ArrayList<RoomType>();
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(RoomTypeSQL.SELECT_ALL);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			roomTypeList.add(new RoomType(rs.getInt("room_type_no"), 
		 			  					  rs.getString("room_type_name"), 
		 			  					  rs.getString("room_type_img"), 
		 			  					  rs.getString("room_type_detail"),
		 			  					  rs.getBoolean(5),
		 			  					  0 ));

		}
		rs.close();
		pstmt.close();
		dataSource.close(con);
		return roomTypeList;
	}
	*/
	
	
	
	
	
	
}
