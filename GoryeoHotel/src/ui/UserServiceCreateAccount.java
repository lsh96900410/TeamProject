package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import hotel.user.User;
import hotel.user.UserService;
import java.awt.Color;

public class UserServiceCreateAccount extends JPanel {
	/****************1.Service객체필드선언**********************/
	private UserService userservice;
	
	private JLabel idMsgLB;
	private JTextField joinIdTextField;
	private JPasswordField passwordTextField;
	private JTextField joinNameTextField;
	private JTextField joinEmailTextField;
	private JTextField joinTelTextField;
	private JTextField joinJuminTextField;
	private JTabbedPane memberTabbedPane;
	private HotelServiceMainFrame hotelServiceMainFrame;

	/**
	 * Create the panel.
	 * @param hotelServiceMainFrame 
	 * @throws Exception 
	 */
	public UserServiceCreateAccount(HotelServiceMainFrame hotelServiceMainFrame) throws Exception {
		setLayout(null);

		joinIdTextField = new JTextField();
		joinIdTextField.setBounds(287, 70, 116, 21);
		add(joinIdTextField);
		joinIdTextField.setColumns(10);

		JLabel joinIdLabel = new JLabel("아이디");
		joinIdLabel.setBounds(114, 73, 57, 15);
		add(joinIdLabel);

		JLabel joinPasswordLabel = new JLabel("패스워드");
		joinPasswordLabel.setBounds(114, 140, 57, 15);
		add(joinPasswordLabel);

		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(287, 138, 116, 18);
		add(passwordTextField);

		JLabel joinNameLabel = new JLabel("이름");
		joinNameLabel.setBounds(114, 206, 57, 15);
		add(joinNameLabel);

		JLabel joinTelLabel = new JLabel("전화번호");
		joinTelLabel.setBounds(114, 275, 57, 15);
		add(joinTelLabel);

		JLabel joinEmailLabel = new JLabel("이메일");
		joinEmailLabel.setBounds(114, 336, 57, 15);
		add(joinEmailLabel);

		JLabel joinJuminLabel = new JLabel("주민등록번호");
		joinJuminLabel.setBounds(114, 392, 80, 15);
		add(joinJuminLabel);

		joinNameTextField = new JTextField();
		joinNameTextField.setBounds(287, 203, 116, 21);
		add(joinNameTextField);
		joinNameTextField.setColumns(10);

		joinEmailTextField = new JTextField();
		joinEmailTextField.setBounds(287, 333, 116, 21);
		add(joinEmailTextField);
		joinEmailTextField.setColumns(10);

		joinTelTextField = new JTextField();
		joinTelTextField.setColumns(10);
		joinTelTextField.setBounds(287, 272, 116, 21);
		add(joinTelTextField);

		joinJuminTextField = new JTextField();
		joinJuminTextField.setColumns(10);
		joinJuminTextField.setBounds(287, 389, 116, 21);
		add(joinJuminTextField);

		JButton joinButton = new JButton("가입");
		joinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/***************회원가입**************/
				System.err.println("회원가입");
				/***************회원가입**************/
				try {
					
					/******TextField로 부터 데이타얻기*****/
					String id = joinIdTextField.getText();
					String password=passwordTextField.getText();
					String name=joinNameTextField.getText();
					String tel=joinTelTextField.getText();
					String email=joinEmailTextField.getText();
					String jumin=joinJuminTextField.getText();
					
					if (id == null || id.equals("")) {
					    idMsgLB.setText("아이디를 입력하세요.");
					    joinIdTextField.requestFocus();
					    return;
					} else {
					    idMsgLB.setText("");
					}
				
					JLabel idMsgLB = new JLabel("");
					
					User user =new User(id, password, name, tel, email,jumin,null);
					boolean isAdd=
							userservice.create(user);

					if(isAdd) {
						//가입성공시 -->로그인화면전환
						JOptionPane.showMessageDialog(null, "회원가입 성공!");
						/*********회원가입 후 로그인창으로 이동*********/
						hotelServiceMainFrame.goToLogin();
					}else {
						//가입실패 -->아이디중복
						JOptionPane.showMessageDialog(null, id + " 는 이미사용하고 있는 아이디입니다.");
					
					}
					
					
				}catch (Exception e1) {
					System.out.println("회원가입에러-->"+e1.getMessage());
				}
			}
		});
		
		joinButton.setBounds(133, 474, 97, 23);
		add(joinButton);

		JButton cancelButton = new JButton("취소");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/***************취소누르면 메인으로 이동************/
				hotelServiceMainFrame.goToMain();
			}
		});
		cancelButton.setBounds(284, 474, 97, 23);
		add(cancelButton);
		
		idMsgLB = new JLabel("");		
		idMsgLB.setForeground(Color.RED);
		idMsgLB.setBounds(287, 101, 168, 15);
		add(idMsgLB);

		/****************2.Service객체생성**********************/
		userservice = new UserService();
		this.hotelServiceMainFrame=hotelServiceMainFrame;
	}//생성자
}
