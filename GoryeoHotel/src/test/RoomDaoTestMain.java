package test;

import java.util.List;

import hotel.room.Room;
import hotel.room.RoomDao;
import hotel.room_type.RoomTypeDao;

public class RoomDaoTestMain {

	public static void main(String[] args) throws Exception {
		RoomTypeDao roomTypeDao;
		roomTypeDao = new RoomTypeDao();
	
		int a = roomTypeDao.updateRoomPrice(50, 1);
		System.out.println(a);
	}

}
