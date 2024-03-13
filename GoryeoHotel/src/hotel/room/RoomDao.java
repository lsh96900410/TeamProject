package hotel.room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import common.DataSource;
import hotel.reserv.Reserv;
import hotel.room_type.RoomType;

public class RoomDao {
	private DataSource dataSource;
	private RoomType roomType;
	public RoomDao() throws Exception{
		dataSource=new DataSource();
		roomType=new RoomType();
	}

	
	
	/************** 객실 삽입(기본) ****************/
	/*
	public int insertRoom(Room room) throws Exception{
		int rowCount=0;
		Connection con= dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(RoomSQL.ROOM_INSERT);
		pstmt.setInt(1,room.getRoomNo());
		pstmt.setInt(2, room.getRoomType().getRoomTypeNo());
		pstmt.setInt(3, room.getRoomPrice());
		rowCount=pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
	*/
	
	/************* 객실 삭제(기본) *****************/
	/*
	public int deleteRoom(int roomTypeNo) throws Exception{
		int rowCount=0;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(RoomSQL.ROOM_DELETE);
		pstmt.setInt(1,roomTypeNo);
		rowCount =pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
	*/
	/*
		private int roomTypeNo;
	private String roomTypeName;
	private String roomTypeImgUrl;
	private String roomTypeDetail;
	private int roomTypeQty;
	private boolean hasPool;
	*/
	
	
	/********** 타입별 찾기(기본) *************/
	
	
	
	
	
	
	
	
	
	//public List<Room> findByRoomType(int typeNo) throws Exception{
		   
		/*
					ROOM_NO ROOM_PRICE ROOM_TYPE_NO  RESERV_NO
					   ---------- ---------- ------------ ----------
		          101         10            1          1
		          102         10            1          4
		          103         10            1          3
		          */
		/*
		List<Room> roomList = new ArrayList<Room>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(RoomSQL.ROOM_SELECT_ALL);
		pstmt.setInt(1,typeNo);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			roomList.add(new Room(rs.getInt("room_no"), 
						 		  new RoomType(rs.getInt("room_type_no"), null, null, null, null,-1),
						 		 /*
						 			rs.getInt("room_type_no"), 
						 			   rs.getString("room_type_name"), 
						 			   rs.getString("room_type_img"), 
						 			   rs.getString("room_type_detail"), 
						 			   rs.getBoolean(5),
						 			   1 ), 
						 				 
						 		  rs.getInt("room_type_no"),
						 		  null
					
					));
		}
		return roomList;
	}
	*/
	/********** 객실 전체 보기(기본) *************/
	/*
	public List<Room> findAll() throws Exception{
		
		List<Room> roomList = new ArrayList<Room>();
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(RoomSQL.ROOM_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			roomList.add(new Room(rs.getInt("room_no"), 
						 null, 
						 rs.getInt("room_price"), 
						 null)
					);
		}
		return roomList;
	}
	
	
	/*************  객실 변경(기본) *****************/
	/*
		public int updateRoom(int roomPrice, int roomTypeNo) throws Exception{
		int rowCount=0;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(RoomSQL.ROOM_UPDATE);
		pstmt.setInt(1, roomPrice);
		pstmt.setInt(2, roomTypeNo);
		return rowCount;
	}
	*/
	
	
	
	}
