package hotel.user;

public class UserSQL {
	public static final String  USER_INSERT =
			"insert into userinfo(USER_ID,USER_PASSWORD,USER_NAME,USER_TEL,USER_EMAIL,USER_JUMIN) "
			+ "values(?,?,?,?,?,?)";
	
	public static final String USER_UPDATE =
			"update userinfo set USER_PASSWORD=?,USER_NAME=?,USER_TEL=?,USER_EMAIL=?,USER_JUMIN=? where USER_ID=?";
	
	public static final String USER_REMOVE =
			"delete from userinfo where USER_ID=?";
	
	public static final String USER_SELECT_BY_ID=
			"select USER_ID,USER_PASSWORD,USER_NAME,USER_TEL,USER_EMAIL,USER_JUMIN from userinfo where USER_ID=?";
	
	public static final String USER_SELECT_BY_ID_COUNT=
			"select count(*) as cnt  from userinfo where USER_ID=?";
	
	public static final String USER_SELECT_BY_ID_FIND=
			"select user_id from userinfo where user_name=? and user_jumin=?";
	
	public static final String USER_SELECT_BY_PASSWORD_FIND=
			"select user_password from userinfo where user_id=? and user_name=? and user_jumin=?";
	
	public static final String  USER_SELECT_ALL=
			"select  USER_ID,USER_PASSWORD,USER_NAME,USER_TEL,USER_EMAIL,USER_JUMIN from userinfo order by user_id";


}
