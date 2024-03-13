package hotel.room;

import java.util.List;

public class RoomService {
	private  RoomDao roomDao;
	public RoomService() throws Exception {
		roomDao=new RoomDao();
	}
	
	
	/****** 타입별 객실보기 *****/
	/*
	public List<Room> roomList(int typeNo) throws Exception{
		return roomDao.findByRoomType(typeNo);
	}
	*/
	
	
	
	
}
