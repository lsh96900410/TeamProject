package hotel.room_type;

public class RoomTypeService {
	RoomTypeDao roomTypeDao;
	public RoomTypeService() throws Exception{
	roomTypeDao= new RoomTypeDao();
	}
	
	/********************************** 객실 상세보기 *****************************/
	public RoomType roomDetail() throws Exception{
		return roomTypeDao.findRoomDetail("1번객실타입");
	}
	
	/********************* 객실별 잔여객수 확인 ***************************/
	public RoomType roomQty() throws Exception{
		return roomTypeDao.findQtyByRoomTypeName("1번객실타입");
	}
	public RoomType findRoomTypeByRoomNo(int roomNo) throws Exception {
		return roomTypeDao.findRoomTypeByRoomNo(roomNo);
	}
	
	
	
	
	
	
	
	
}
