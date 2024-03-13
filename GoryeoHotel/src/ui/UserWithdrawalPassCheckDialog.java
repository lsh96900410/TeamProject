package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hotel.user.User;
import hotel.user.UserService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserWithdrawalPassCheckDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField checkPassTF;
	private UserService userService;
	private static User loginUser;
	private HotelServiceMainFrame hotelServiceMainFrame;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 * @throws Exception 
	 */
	public UserWithdrawalPassCheckDialog(User loginUser,HotelServiceMainFrame hotelServiceMainFrame) throws Exception {
		setBounds(100, 100, 328, 227);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("비밀번호");
		lblNewLabel.setBounds(50, 73, 78, 18);
		contentPanel.add(lblNewLabel);
		
		checkPassTF = new JTextField();
		checkPassTF.setBounds(149, 72, 96, 21);
		contentPanel.add(checkPassTF);
		checkPassTF.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!loginUser.getUser_Id().equals("admin")&& checkPassTF.getText().equals(loginUser.getUser_Password())) {
							try {
								userService.userDelete(loginUser.getUser_Id());
								setVisible(false);
								hotelServiceMainFrame.logoutProcess();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}else if(loginUser.getUser_Id().equals("admin")) {
							JOptionPane.showMessageDialog(null, "관리자 계정은 삭제할 수 없습니다.");
						}else {
							JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요");
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					

					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		this.loginUser = loginUser;
		userService = new UserService();
		this.hotelServiceMainFrame = hotelServiceMainFrame;
	}
}
