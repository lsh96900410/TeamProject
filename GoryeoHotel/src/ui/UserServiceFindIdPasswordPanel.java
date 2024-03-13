package ui;

import javax.swing.JPanel;
import javax.swing.JTextField;

import hotel.user.UserService;
import hotel.user.User;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserServiceFindIdPasswordPanel extends JPanel {
	private UserService userservice;
	private HotelServiceMainFrame hotelServiceMainFrame;

	
	private JTextField FindIdNameTF;
	private JTextField FindIdJuminTF;
	private JTextField FindPasswordIdTF;
	private JTextField FindPasswordNameTF;
	private JTextField FindPasswordJuminTF;

	/**
	 * Create the panel.
	 * @param hotelServiceMainFrame 
	 * @throws Exception 
	 */
	public UserServiceFindIdPasswordPanel(HotelServiceMainFrame hotelServiceMainFrame) throws Exception {
		setLayout(null);
		
		JButton FindIdButton = new JButton("아이디 찾기");
		FindIdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/***********아이디 찾기****************/
				try {
					String Idname = FindIdNameTF.getText();
					String Idjumin = FindIdJuminTF.getText();
					String localfindUserId= userservice.findId(Idname, Idjumin);
					if(localfindUserId != null ) {
						//찾기성공
						System.out.println("성공");
						JOptionPane.showMessageDialog(null,"아이디는 "+localfindUserId+" 입니다");
					}else {
						//로그인실패
						System.out.println("실패");
						JOptionPane.showMessageDialog(null, "입력한 정보를 확인하세요");

					}
					
					
				}catch (Exception e1) {
					System.out.println("아이디 찾기 에러"+e1.getMessage());
				}
			}
		});
		FindIdButton.setBounds(401, 146, 123, 23);
		add(FindIdButton);
		
		JButton FindPasswordButton = new JButton("비밀번호 찾기");
		FindPasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*********비밀번호찾기**********/
				try {
					String pwid = FindPasswordIdTF.getText();
					String pwname = FindPasswordNameTF.getText();
					String pwjumin = FindPasswordJuminTF.getText();
					String localfindUserPassword= userservice.findPassword(pwid, pwname, pwjumin);
					if(localfindUserPassword !=null) {
						System.out.println("성공");
						JOptionPane.showMessageDialog(null,"비밀번호는 "+localfindUserPassword+" 입니다");

					}else {
						System.out.println("실패");
						JOptionPane.showMessageDialog(null, "입력한 정보를 확인하세요");
						
					}
				}catch (Exception e1) {
					System.out.println("비밀번호찾기 에러"+e1.getMessage());
				}

				
			}
		});
		FindPasswordButton.setBounds(401, 426, 142, 23);
		add(FindPasswordButton);
		
		FindIdNameTF = new JTextField();
		FindIdNameTF.setBounds(113, 115, 239, 31);
		add(FindIdNameTF);
		FindIdNameTF.setColumns(10);
		
		JLabel FIndIdLabel = new JLabel("아이디 찾기");
		FIndIdLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		FIndIdLabel.setBounds(50, 37, 142, 45);
		add(FIndIdLabel);
		
		JLabel FIndPasswordLabel = new JLabel("비밀번호 찾기");
		FIndPasswordLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		FIndPasswordLabel.setBounds(50, 285, 201, 31);
		add(FIndPasswordLabel);
		
		JLabel lbNameLabel = new JLabel("이름");
		lbNameLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		lbNameLabel.setBounds(41, 115, 37, 30);
		add(lbNameLabel);
		
		FindIdJuminTF = new JTextField();
		FindIdJuminTF.setColumns(10);
		FindIdJuminTF.setBounds(113, 174, 239, 31);
		add(FindIdJuminTF);
		
		FindPasswordIdTF = new JTextField();
		FindPasswordIdTF.setColumns(10);
		FindPasswordIdTF.setBounds(113, 361, 239, 31);
		add(FindPasswordIdTF);
		
		FindPasswordNameTF = new JTextField();
		FindPasswordNameTF.setColumns(10);
		FindPasswordNameTF.setBounds(113, 422, 239, 31);
		add(FindPasswordNameTF);
		
		FindPasswordJuminTF = new JTextField();
		FindPasswordJuminTF.setColumns(10);
		FindPasswordJuminTF.setBounds(113, 482, 239, 31);
		add(FindPasswordJuminTF);
		
		JLabel lbJuminLabel = new JLabel("주민등록번호");
		lbJuminLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		lbJuminLabel.setBounds(12, 174, 102, 30);
		add(lbJuminLabel);
		
		JLabel PasswordNameLabel = new JLabel("이름");
		PasswordNameLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		PasswordNameLabel.setBounds(41, 422, 37, 30);
		add(PasswordNameLabel);
		
		JLabel PasswordJuminLabel = new JLabel("주민등록번호");
		PasswordJuminLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		PasswordJuminLabel.setBounds(12, 478, 102, 30);
		add(PasswordJuminLabel);
		
		JLabel PasswordIdLabel = new JLabel("아이디");
		PasswordIdLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		PasswordIdLabel.setBounds(41, 361, 60, 30);
		add(PasswordIdLabel);
		
		/****************2.Service객체생성**********************/
		userservice = new UserService();
		this.hotelServiceMainFrame=hotelServiceMainFrame;
	}//생성자끝
	
	
	
}
