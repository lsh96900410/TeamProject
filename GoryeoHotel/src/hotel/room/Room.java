package hotel.room;

import java.util.List;

import hotel.reserv.Reserv;
import hotel.room_type.RoomType;

public class Room {
	private int roomNo;
	private RoomType roomType;
	private List<Reserv> reservList;

	public Room() {
	}

	public Room(int roomNo, RoomType roomType, List<Reserv> reservList) {
		super();
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.reservList = reservList;
	}

	@Override
	public String toString() {
		return "Room [roomNo=" + roomNo + "\n roomType=" + roomType + "\n reservList=" + reservList + "]\n";
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public List<Reserv> getReservList() {
		return reservList;
	}

	public void setReservList(List<Reserv> reservList) {
		this.reservList = reservList;
	}
	
	
	

}
