package ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import hotel.user.User;
import hotel.user.UserService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

public class UserServiceManagePanel extends JPanel {
	UserService userservice;
	private HotelServiceMainFrame hotelServiceMainFrame;
	private JTextField textField;
	private JTable table;
	private JButton userDeleteButton;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public UserServiceManagePanel() throws Exception {
		setLayout(null);
		
		JButton userDeleteButton = new JButton("회원삭제");
		userDeleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		userDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**********회원삭제************/
				deleteChoiceUser();
			}
		});
		userDeleteButton.setBounds(305, 476, 117, 34);
		add(userDeleteButton);
		
		JButton btnNewButton_1 = new JButton("전체목록보기");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*****회원전체목록보기**********/
				displayMemberList();
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(99, 476, 130, 34);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("검색");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userId = textField.getText();
                if (!userId.isEmpty()) {
                    searchUserById(userId);
                } else {
                    JOptionPane.showMessageDialog(null, "회원 아이디를 입력해주세요.");
                }
            }
        });
        
		btnNewButton_2.setBounds(375, 61, 97, 23);
		add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(184, 50, 158, 34);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("회원아이디");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setBounds(35, 53, 117, 34);
		add(lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(35, 149, 488, 257);
		add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"\uC544\uC774\uB514", "\uD328\uC2A4\uC6CC\uB4DC", "\uC774\uB984", "\uC804\uD654\uBC88\uD638", "\uC774\uBA54\uC77C", "\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(67);
		table.getColumnModel().getColumn(2).setPreferredWidth(55);
		table.getColumnModel().getColumn(3).setPreferredWidth(87);
		table.getColumnModel().getColumn(4).setPreferredWidth(84);
		table.getColumnModel().getColumn(5).setPreferredWidth(106);
		scrollPane_1.setViewportView(table);
		
		userservice = new UserService();
		this.hotelServiceMainFrame=hotelServiceMainFrame;
		
	}//끝
	private void displayMemberList() {
		try {
			List<User> userList = userservice.userList();
			
			Vector columVector=new Vector();
			columVector.add("아이디");
			columVector.add("비밀번호");
			columVector.add("이름");
			columVector.add("전화번호");
			columVector.add("이메일");
			columVector.add("주민번호");
			
			Vector tableVector=new Vector();
			
			for (User user : userList) {
				Vector rowVector=new Vector();
				rowVector.add(user.getUser_Id());
				rowVector.add(user.getUser_Password());
				rowVector.add(user.getUser_Name());
				rowVector.add(user.getUser_Tel());
				rowVector.add(user.getUser_Email());
				rowVector.add(user.getUser_Jumin());
				tableVector.add(rowVector);
			}
			DefaultTableModel tableModel=new DefaultTableModel(tableVector,columVector);
			table.setModel(tableModel);
			userDeleteButton.setEnabled(false);
	
			
		}catch(Exception e1) {
			System.out.println("회원리스트보기에러-->"+e1.getMessage());
		}
				
	}
	
	private void searchUserById(String userId) {
        try {
            User user = userservice.userDetail(userId);
            if (user != null) {
                Vector columnVector = new Vector();
                columnVector.add("아이디");
                columnVector.add("비밀번호");
                columnVector.add("이름");
                columnVector.add("전화번호");
                columnVector.add("이메일");
                columnVector.add("주민번호");

                Vector tableVector = new Vector();
                Vector rowVector = new Vector();
                rowVector.add(user.getUser_Id());
                rowVector.add(user.getUser_Password());
                rowVector.add(user.getUser_Name());
                rowVector.add(user.getUser_Tel());
                rowVector.add(user.getUser_Email());
                rowVector.add(user.getUser_Jumin());
                tableVector.add(rowVector);

                DefaultTableModel tableModel = new DefaultTableModel(tableVector, columnVector);
                table.setModel(tableModel);
                userDeleteButton.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "해당 회원 아이디를 찾을 수 없습니다.");
                displayMemberList(); 
                textField.setText(""); 
            }

        } catch (Exception e1) {
            System.out.println("회원검색 에러 --> " + e1.getMessage());
        }
    }
	
	private void deleteChoiceUser() {
		try {
			/*************선택된아이디삭제************/
			
			int selectedRow=table.getSelectedRow();
			String selectedId =(String)table.getValueAt(selectedRow, 0);
			userservice.userDelete(selectedId);
			userDeleteButton.setEnabled(false);
			displayMemberList();
		}catch (Exception e1) {
			System.out.println("회원삭제에러-->"+e1.getMessage());
			
		}
	}
	
}
