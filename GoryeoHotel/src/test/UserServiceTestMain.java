package test;

import hotel.user.User;
import hotel.user.UserService;

public class UserServiceTestMain {

	public static void main(String[] args) throws Exception {
		UserService  userService=new UserService();
		
		System.out.println("가입");
		
		System.out.println(userService.create(
				new User("테스트","테스트","테스트","000@000","000","00000-000000",null)));
		
		
		System.out.println("로그인");
		User result = userService.login("테스트", "테스트");
		System.out.println(result);
		
		System.out.println("수정");
		int rowCount = userService.update(new User("테스트","테스트","테스트","000@000","000","00000-000000",null));
		System.out.println(">> "+rowCount);
		
		System.out.println("삭제");
		rowCount = userService.remove("테스트");
	}

}
