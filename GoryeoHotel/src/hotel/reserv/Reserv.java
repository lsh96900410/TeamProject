package hotel.reserv;

import java.sql.Date;

import hotel.room.Room;
import hotel.room_type.RoomType;
import hotel.user.User;

public class Reserv {
	private int reservNo;
	private Date reservCheckIn;
	private Date reservCheckOut;
	private int reservAdult;
	private int reservChild;
	private boolean isBreakfast;
	private int reservExtraBed;
	private Room room;
	private User user;
	private String reservPayment;
	private Date reservDate;

	public Reserv() {
		
	}

	public Reserv(int reservNo, Date reservCheckIn, Date reservCheckOut, int reservAdult, int reservChild,
			boolean isBreakfast, int reservExtraBed, Room room, User user, String reservPayment, Date reservDate) {
		super();
		this.reservNo = reservNo;
		this.reservCheckIn = reservCheckIn;
		this.reservCheckOut = reservCheckOut;
		this.reservAdult = reservAdult;
		this.reservChild = reservChild;
		this.isBreakfast = isBreakfast;
		this.reservExtraBed = reservExtraBed;
		this.room = room;
		this.user = user;
		this.reservPayment = reservPayment;
		this.reservDate = reservDate;
	}

	public int getReservNo() {
		return reservNo;
	}

	public Date getReservCheckIn() {
		return reservCheckIn;
	}

	public Date getReservCheckOut() {
		return reservCheckOut;
	}

	public int getReservAdult() {
		return reservAdult;
	}

	public int getReservChild() {
		return reservChild;
	}

	public boolean isBreakfast() {
		return isBreakfast;
	}

	public int getReservExtraBed() {
		return reservExtraBed;
	}

	public Room getRoom() {
		return room;
	}

	public User getUser() {
		return user;
	}

	public String getReservPayment() {
		return reservPayment;
	}

	public Date getReservDate() {
		return reservDate;
	}

	public void setReservNo(int reservNo) {
		this.reservNo = reservNo;
	}

	public void setReservCheckIn(Date reservCheckIn) {
		this.reservCheckIn = reservCheckIn;
	}

	public void setReservCheckOut(Date reservCheckOut) {
		this.reservCheckOut = reservCheckOut;
	}

	public void setReservAdult(int reservAdult) {
		this.reservAdult = reservAdult;
	}

	public void setReservChild(int reservChild) {
		this.reservChild = reservChild;
	}

	public void setBreakfast(boolean isBreakfast) {
		this.isBreakfast = isBreakfast;
	}

	public void setReservExtraBed(int reservExtraBed) {
		this.reservExtraBed = reservExtraBed;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setReservPayment(String reservPayment) {
		this.reservPayment = reservPayment;
	}

	public void setReservDate(Date reservDate) {
		this.reservDate = reservDate;
	}

	@Override
	public String toString() {
		return "예약정보\n[예약번호=" + reservNo + "\n 체크인=" + reservCheckIn + ", 체크아웃="
				+ reservCheckOut + "\n 성인(명)=" + reservAdult + ", 영유아(명)=" + reservChild + "\n 조식여부="
				+ isBreakfast + ", 침대 추가=" + reservExtraBed + "\n 방정보=" + room + "\n 유저=" + user
				+ "\n 결제수단=" + reservPayment + ", 결제일=" + reservDate + "]";
	}

	
}
