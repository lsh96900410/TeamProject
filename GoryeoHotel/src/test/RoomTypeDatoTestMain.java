package test;

import hotel.room_type.RoomType;
import hotel.room_type.RoomTypeDao;
import hotel.room_type.RoomTypeService;

public class RoomTypeDatoTestMain {

	public static void main(String[] args) throws Exception {
		RoomTypeService roomTypeService=new RoomTypeService();
		
		/********************** 객실 상세보기 테스트 **************************/
		System.out.println(roomTypeService.roomDetail());
		
		/************************객실별 잔여객수 확인 *******************************/
		System.out.println(roomTypeService.roomQty());
	}

}
