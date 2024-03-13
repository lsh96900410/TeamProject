package hotel.reserv;

import java.sql.Date;
import java.util.List;

import hotel.room.Room;

public class ReservService {
private ReservDao reservDao;
public ReservService() throws Exception {
	reservDao=new ReservDao();
}
public int insert(Reserv reserv) throws Exception {
	return reservDao.insert(reserv);
}
public int updateOption(Reserv reserv) throws Exception{
	return reservDao.updateOption(reserv);
}
public int deleteById(String userid) throws Exception{
	return reservDao.deleteById(userid);
}
public int deleteByReservNo(int reservNo) throws Exception{
	return reservDao.deleteByReservNo(reservNo);
}
public List<Reserv> selectAllReservRoom() throws Exception{
	return reservDao.selectAllReservRoom();
}
public List<Room> emptyRoom(Date checkIn, Date checkOut) throws Exception {
	return reservDao.emptyRoom(checkIn, checkOut);
}
public List<Reserv> selectReserv() throws Exception {
	return reservDao.selectReserv();
}
public Reserv selectAllAll(int reservNo) throws Exception{
	return reservDao.selectAllAll(reservNo);
}
public List<Reserv> findMyReserv(String userId) throws Exception{
	return reservDao.findMyReserv(userId);
}
public List<Reserv> findMyReservDefault(String userId) throws Exception{
	return reservDao.findMyReservDefault(userId);
}
public List<Reserv> findMyReservByDate(String userId,java.util.Date optionStartDate, java.util.Date optionEndDate) throws Exception{
	return reservDao.findMyReservByDate(userId, optionStartDate, optionEndDate);
}
public int findRoomByReservNo(int reservNo) throws Exception {
	return reservDao.findRoomByReservNo(reservNo);
}
}
