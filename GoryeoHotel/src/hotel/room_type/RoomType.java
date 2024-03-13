package hotel.room_type;

import java.util.ArrayList;
import java.util.List;

import hotel.room.Room;

public class RoomType {
	private int roomTypeNo;
	private String roomTypeName;
	private String roomTypeImg;
	private String roomTypeDetail;
	private Boolean roomTypePool;
	private int roomTypeQty;
	private int roomTypePrice;
	private List<Room> roomList;
	
	public RoomType() {
		 roomList= new ArrayList<Room>();
	}

	public RoomType(int roomTypeNo, String roomTypeName, String roomTypeImg, String roomTypeDetail,
			Boolean roomTypePool, int roomTypeQty, int roomTypePrice, ArrayList<Room> roomList) {
		super();
		this.roomTypeNo = roomTypeNo;
		this.roomTypeName = roomTypeName;
		this.roomTypeImg = roomTypeImg;
		this.roomTypeDetail = roomTypeDetail;
		this.roomTypePool = roomTypePool;
		this.roomTypeQty = roomTypeQty;
		this.roomTypePrice = roomTypePrice;
		this.roomList = roomList;
	}

	public int getRoomTypeNo() {
		return roomTypeNo;
	}

	public void setRoomTypeNo(int roomTypeNo) {
		this.roomTypeNo = roomTypeNo;
	}

	public String getRoomTypeName() {
		return roomTypeName;
	}

	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}

	public String getRoomTypeImg() {
		return roomTypeImg;
	}

	public void setRoomTypeImg(String roomTypeImg) {
		this.roomTypeImg = roomTypeImg;
	}

	public String getRoomTypeDetail() {
		return roomTypeDetail;
	}

	public void setRoomTypeDetail(String roomTypeDetail) {
		this.roomTypeDetail = roomTypeDetail;
	}

	public Boolean getRoomTypePool() {
		return roomTypePool;
	}

	public void setRoomTypePool(Boolean roomTypePool) {
		this.roomTypePool = roomTypePool;
	}

	public int getRoomTypeQty() {
		return roomTypeQty;
	}

	public void setRoomTypeQty(int roomTypeQty) {
		this.roomTypeQty = roomTypeQty;
	}

	public int getRoomTypePrice() {
		return roomTypePrice;
	}

	public void setRoomTypePrice(int roomTypePrice) {
		this.roomTypePrice = roomTypePrice;
	}

	public List<Room> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}

	@Override
	public String toString() {
		return "RoomType [roomTypeNo=" + roomTypeNo + "\n roomTypeName=" + roomTypeName + "\n roomTypeImg=" + roomTypeImg
				+ "\n roomTypeDetail=" + roomTypeDetail + "\n roomTypePool=" + roomTypePool + "\n roomTypeQty="
				+ roomTypeQty + "\n roomTypePrice=" + roomTypePrice + "\n roomList=" + roomList + "]\n";
	}

	
	
	
	
	
	
	
}