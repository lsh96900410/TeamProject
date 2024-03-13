package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hotel.user.User;
import hotel.user.UserService;
import javax.swing.JDesktopPane;

public class UserServiceUserInfoPanel extends JPanel {
	private UserService userservice;
	private User loginUser;
	private JTextField UserInfoIdTF;
	private JTextField UserInfoNameTF;
	private JTextField UserInfoEmailTF;
	private JTextField UserInfoTelTF;
	private JTextField UserInfoJuminTF;
	private JTextField UserInfoPasswordTF;
	private JButton StartupdateBtn;
	private JButton updateBtn;
	private HotelServiceMainFrame hotelServiceMainFrame;

	/**
	 * Create the panel.
	 * @param hotelServiceMainFrame 
	 * @param loginUser2 
	 * @throws Exception 
	 */
	public UserServiceUserInfoPanel(HotelServiceMainFrame hotelServiceMainFrame) throws Exception {
		setLayout(null);
		
		JLabel UserIdLabel = new JLabel("아이디");
		UserIdLabel.setBounds(121, 64, 72, 29);
		add(UserIdLabel);
		
		JLabel UserPasswordLabel = new JLabel("비밀번호");
		UserPasswordLabel.setBounds(121, 127, 72, 29);
		add(UserPasswordLabel);
		
		JLabel UserNameLabel = new JLabel("이름");
		UserNameLabel.setBounds(121, 196, 72, 29);
		add(UserNameLabel);
		
		JLabel UserEmailLabel = new JLabel("이메일");
		UserEmailLabel.setBounds(121, 261, 72, 29);
		add(UserEmailLabel);
		
		JLabel UserTelLabel = new JLabel("전화번호");
		UserTelLabel.setBounds(121, 338, 72, 29);
		add(UserTelLabel);
		
		JLabel UserJuminLabel = new JLabel("주민번호");
		UserJuminLabel.setBounds(121, 411, 72, 29);
		add(UserJuminLabel);
		
		UserInfoIdTF = new JTextField();
		UserInfoIdTF.setEnabled(false);
		UserInfoIdTF.setBounds(280, 66, 133, 25);
		add(UserInfoIdTF);
		UserInfoIdTF.setColumns(10);
		
		UserInfoNameTF = new JTextField();
		UserInfoNameTF.setEnabled(false);
		UserInfoNameTF.setColumns(10);
		UserInfoNameTF.setBounds(280, 198, 133, 25);
		add(UserInfoNameTF);
		
		UserInfoEmailTF = new JTextField();
		UserInfoEmailTF.setEnabled(false);
		UserInfoEmailTF.setColumns(10);
		UserInfoEmailTF.setBounds(280, 273, 133, 25);
		add(UserInfoEmailTF);
		
		UserInfoTelTF = new JTextField();
		UserInfoTelTF.setEnabled(false);
		UserInfoTelTF.setColumns(10);
		UserInfoTelTF.setBounds(280, 340, 133, 25);
		add(UserInfoTelTF);
		
		JButton StrarUpdatebtn = new JButton("회원정보수정활성화");
		StrarUpdatebtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		StrarUpdatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateFormEnable(true);
			}
		});
		StrarUpdatebtn.setBounds(213, 465, 161, 29);
		add(StrarUpdatebtn);
		
		JButton Passwordbtn = new JButton("회원정보확인");
		Passwordbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		Passwordbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/************회원정보확인*******************/
				displayUserInfo(hotelServiceMainFrame.getLoginUser());
			}
		});
		Passwordbtn.setBounds(59, 465, 118, 29);
		add(Passwordbtn);
		
		UserInfoJuminTF = new JTextField();
		UserInfoJuminTF.setEnabled(false);
		UserInfoJuminTF.setColumns(10);
		UserInfoJuminTF.setBounds(280, 413, 133, 25);
		add(UserInfoJuminTF);
		
		UserInfoPasswordTF = new JTextField();
		UserInfoPasswordTF.setEnabled(false);
		UserInfoPasswordTF.setColumns(10);
		UserInfoPasswordTF.setBounds(280, 129, 133, 25);
		add(UserInfoPasswordTF);
		
	
		
		JButton Updatebtn = new JButton("수정");
		Updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/******TextField로 부터 데이타얻기*****/
					String id = UserInfoIdTF.getText();
					String password=UserInfoPasswordTF.getText();
					String name=UserInfoNameTF.getText();
					String tel = UserInfoTelTF.getText();
					String email = UserInfoEmailTF.getText();
					String jumin =UserInfoJuminTF.getText();
					
					User updateMember=new User(id, password, name, tel,email,jumin, null);
					userservice.update(updateMember);
					//로그인한회원정보변경
					loginUser =  userservice.userDetail(updateMember.getUser_Id());
					//loginMember = updateMember;
					
					updateFormEnable(false);
					
				}catch (Exception e1) {
					System.out.println("회원수정에러-->"+e1.getMessage());
					
				}
			}
		});
		Updatebtn.setBounds(402, 465, 118, 29);
		add(Updatebtn);
		
	
	
		JButton btnNewButton = new JButton("회원탈퇴");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					hotelServiceMainFrame.callPassCheckDialog(hotelServiceMainFrame.getLoginUser());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(245, 504, 91, 23);
		add(btnNewButton);
		this.userservice=new UserService();
		this.hotelServiceMainFrame=hotelServiceMainFrame;
		
	}
	
	void displayUserInfo(User loginUser) {
		UserInfoIdTF.setText(loginUser.getUser_Id());
		UserInfoPasswordTF.setText(loginUser.getUser_Password());
		UserInfoNameTF.setText(loginUser.getUser_Name());
		UserInfoEmailTF.setText(loginUser.getUser_Email());
		UserInfoTelTF.setText(loginUser.getUser_Tel());
		UserInfoJuminTF.setText(loginUser.getUser_Jumin());
	}
	
	private void updateFormEnable(boolean b) {
		if(b) {
			UserInfoIdTF.setEnabled(false);
			UserInfoPasswordTF.setEnabled(true);
			UserInfoNameTF.setEnabled(true);
			UserInfoTelTF.setEnabled(true);
			UserInfoEmailTF.setEnabled(true);
			UserInfoJuminTF.setEnabled(true);
			
			updateBtn.setEnabled(true);

			
		}else {
			UserInfoIdTF.setEnabled(false);
			UserInfoPasswordTF.setEnabled(false);
			UserInfoNameTF.setEnabled(false);
			UserInfoTelTF.setEnabled(false);
			UserInfoEmailTF.setEnabled(false);
			UserInfoJuminTF.setEnabled(false);
			
			updateBtn.setEnabled(false);

		}
	}
	void setEmptyTF() {
		UserInfoIdTF.setText("");
		UserInfoPasswordTF.setText("");
		UserInfoNameTF.setText("");
		UserInfoTelTF.setText("");
		UserInfoEmailTF.setText("");
		UserInfoJuminTF.setText("");
	}
}
