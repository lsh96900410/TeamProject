package hotel.room;

public class RoomSQL {
	
	public static final String ROOM_INSERT="insert into room(room_no,room_price,room_type_no,reserv_no) values (?,?,?,null);";
	public static final String ROOM_DELETE="delete from room where room_no=?";
	public static final String ROOM_UPDATE="update room set room_price=? where room_type_no=?";
	public static final String ROOM_SELECT_ALL="select * from room order by room_no";
	
}
