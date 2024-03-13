package hotel.reserv;

public class ReservSQL {
//public static final String INSERT_RESERV = "insert into reserv(reserv_no,reserv_check_in,reserv_check_out,reserv_adult,reserv_child,isbreakfast,reserv_extra_bed,reserv_date,reserv_fprice,reserv_payment,user_id) values(reserv_reserv_no_seq.nextval,to_date(?,'YYYY/MM/DD'),to_date(?,'YYYY/MM/DD'),?,?,?,?,sysdate,?,?,?)";
public static final String INSERT_RESERV = "insert into reserv(reserv_no,reserv_check_in,reserv_check_out,reserv_adult,reserv_child,isbreakfast,reserv_extra_bed,reserv_date,reserv_payment,user_id,room_no) values(reserv_reserv_no_seq.nextval,?,?,?,?,?,?,sysdate,?,?,?)";
public static final String UPDATE_RESERV_OPTION="update reserv set RESERV_ADULT=?,RESERV_CHILD=?,ISBREAKFAST=?,RESERV_EXTRA_BED=?,RESERV_PAYMENT=? where reserv_no=?";
public static final String DELETE_RESERV_BY_USER_ID = "delete from reserv where reserv.user_id=?";
public static final String DELETE_RESERV_BY_RESERV_NO= "delete from reserv where reserv_no=?";
public static final String SELECT_RESERV ="select * from reserv order by reserv_no";
public static final String SELECT_ROOM_ROOMTYPE_ALL="select * from room r join room_type rt on r.room_type_no= rt.room_type_no order by rt.room_type_no";
public static final String SELECT_ROOM_ROOMTYPE_RESERV_ALL="select * from room r join room_type rt on r.room_type_no= rt.room_type_no join reserv re on re.room_no=r.room_no order by r.room_no";
public static final String FIND_EMPTY_ROOM="SELECT room.room_no, room_type.room_type_name, room_type.room_type_price "
		+ "FROM room "
		+ "JOIN room_type ON room.room_type_no = room_type.room_type_no "
		+ "WHERE room.room_no NOT IN ("
		+ "    SELECT DISTINCT r.room_no"
		+ "    FROM reserv r "
		+ "    WHERE ("
		+ "        (r.reserv_check_in >= ? AND r.reserv_check_in < ?) OR"
		+ "        (r.reserv_check_out > ? AND r.reserv_check_out <= ?)"
		+ "    )"
		+ ") "
		+ "ORDER BY room.room_no";
//public static final String FIND_EMPTY_ROOM="select * from room r join room_type rt on r.room_type_no= rt.room_type_no join reserv re on re.room_no=r.room_no where re.reserv_check_out<? or re.reserv_check_in>?";
public static final String SELECT_RESERV_USER_ALL="select * from reserv re join userinfo u on u.user_id = re.user_id order by re.reserv_no";
public static final String SELECT_RESERV_USER_DETAIL="select * from reserv re join userinfo u on u.user_id = re.user_id join room r on re.room_no=r.room_no join room_type rt on r.room_type_no = rt.room_type_no where re.reserv_no=? order by re.reserv_no";
public static final String SELECT_RESERV_BY_ID="select * from reserv re join userinfo u on u.user_id = re.user_id where u.user_id=? order by re.reserv_no";
public static final String FIND_MY_RESERV_DEFAULT="select * from reserv re join userinfo u on u.user_id = re.user_id where u.user_id =? and (sysdate-reserv_date)<30 order by re.reserv_no";
public static final String FIND_MY_RESERV_BY_DATE="select * from reserv re join userinfo u on u.user_id = re.user_id join room r on r.room_no= re.room_no where u.user_id =? and reserv_date Between ? and ?+1 order by re.reserv_no";
public static final String FIND_ROOM_BY_RESERV_NO = "select r.room_no from room r join reserv re on r.room_no=re.room_no where reserv_no=? order by re.reserv_no";
}
