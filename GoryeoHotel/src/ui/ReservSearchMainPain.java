package ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import hotel.reserv.Reserv;
import hotel.reserv.ReservService;
import hotel.room.Room;
import hotel.room_type.RoomTypeService;
import hotel.user.User;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.DateModel;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JCalendar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;

public class ReservSearchMainPain extends JPanel {

	private RoomTypeService roomTypeService;
	private ReservService reservService;
	private JDateChooser checkInDateChooser;
	private JDateChooser checkOutDateChooser;
	private JTable reservSearchTable;
	private JComboBox reservBedComboBox;
	private JComboBox paymentBox;
	private JCheckBox reservBreakfastCheck;
	private HotelServiceMainFrame hotelServiceMainFrame;
	private User loginUser;
	private JButton reservBtn;
	/**
	 * Create the panel.
	 * @param hotelServiceMainFrame 
	 * @throws Exception 
	 */
	public ReservSearchMainPain(HotelServiceMainFrame hotelServiceMainFrame) throws Exception {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton reservSearchBtn = new JButton("검색");
		reservSearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(checkInDateChooser.getDate()==null ||checkOutDateChooser.getDate()==null) {
						JOptionPane.showMessageDialog(null, "날짜를 선택하세요");
					}
					List<Room> roomList=reservService.emptyRoom(new java.sql.Date(checkInDateChooser.getDate().getTime()),  new java.sql.Date(checkOutDateChooser.getDate().getTime()));
					if(roomList.size()==0) {
						JOptionPane.showMessageDialog(null, "예약 가능한 방이 없습니다.");
					}
					Vector tableVector = new Vector();
					for(int i=0;i<roomList.size();i++) {
						Vector rowVector = new Vector();
						rowVector.add(roomList.get(i).getRoomNo());
						rowVector.add(roomList.get(i).getRoomType().getRoomTypeName());
						rowVector.add(roomList.get(i).getRoomType().getRoomTypePrice());
						tableVector.add(rowVector);
					}
					
					Vector columnVector = new Vector();
					columnVector.add("방번호");
					columnVector.add("방종류");
					columnVector.add("가격");
					
					DefaultTableModel tableModel = new DefaultTableModel(tableVector,columnVector);
					
					reservSearchTable.setModel(tableModel);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		reservSearchBtn.setBounds(368, 189, 139, 31);
		panel.add(reservSearchBtn);
		
		JLabel lblNewLabel = new JLabel("예약");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 26));
		lblNewLabel.setBounds(252, 51, 54, 71);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		scrollPane.setBounds(59, 243, 448, 143);
		panel.add(scrollPane);
		
		reservSearchTable = new JTable();
		reservSearchTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"\uBC29\uBC88\uD638", "\uBC29\uC885\uB958", "\uAC00\uACA9"
			}
		));
		reservSearchTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		scrollPane.setViewportView(reservSearchTable);
		
		JLabel lblNewLabel_1 = new JLabel("체크인 날짜");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_1.setBounds(118, 109, 106, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("체크아웃 날짜");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 16));
		lblNewLabel_2.setBounds(365, 109, 113, 25);
		panel.add(lblNewLabel_2);
		
		checkInDateChooser = new JDateChooser();
		checkInDateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		checkInDateChooser.setBounds(128, 144, 73, 21);
		panel.add(checkInDateChooser);
		
		checkOutDateChooser = new JDateChooser();
		checkOutDateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		checkOutDateChooser.setBounds(375, 144, 73, 21);
		panel.add(checkOutDateChooser);
		
		JTextField reservAdultTF = new JTextField();
		reservAdultTF.setText("1");
		reservAdultTF.setBounds(54, 417, 73, 25);
		panel.add(reservAdultTF);
		reservAdultTF.setColumns(10);
		
		JTextField reservChildTF = new JTextField();
		reservChildTF.setText("0");
		reservChildTF.setBounds(150, 419, 74, 23);
		panel.add(reservChildTF);
		reservChildTF.setColumns(10);
		
		reservBreakfastCheck = new JCheckBox("조식");
		reservBreakfastCheck.setBounds(250, 418, 115, 23);
		panel.add(reservBreakfastCheck);
		
		paymentBox = new JComboBox();
		paymentBox.setModel(new DefaultComboBoxModel(new String[] {"카드", "네이버페이", "페이코", "계좌이체"}));
		paymentBox.setBounds(150, 496, 63, 27);
		panel.add(paymentBox);
		
		JLabel lblNewLabel_3 = new JLabel("성인");
		lblNewLabel_3.setBounds(54, 396, 57, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("영유아");
		lblNewLabel_4.setBounds(150, 394, 57, 15);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("침대추가");
		lblNewLabel_5.setBounds(59, 465, 57, 15);
		panel.add(lblNewLabel_5);
		
		reservBedComboBox = new JComboBox();
		reservBedComboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4"}));
		reservBedComboBox.setBounds(59, 494, 54, 31);
		panel.add(reservBedComboBox);
		
		JLabel lblNewLabel_6 = new JLabel("결제수단");
		lblNewLabel_6.setBounds(156, 465, 57, 15);
		panel.add(lblNewLabel_6);
		
		reservBtn = new JButton("예약");
		reservBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int roomNo = (Integer)reservSearchTable.getValueAt(reservSearchTable.getSelectedRow(), 0);
				
				
					reservService.insert(new Reserv(0,new java.sql.Date(checkInDateChooser.getDate().getTime()),new java.sql.Date(checkOutDateChooser.getDate().getTime()),Integer.parseInt(reservAdultTF.getText()),Integer.parseInt(reservChildTF.getText()),reservBreakfastCheck.isSelected(),Integer.parseInt(reservBedComboBox.getSelectedItem()+""),
							new Room(roomNo,roomTypeService.findRoomTypeByRoomNo(roomNo),new ArrayList<Reserv>()),hotelServiceMainFrame.getLoginUser(),(String)paymentBox.getSelectedItem(),new Date(1)));
					JOptionPane.showMessageDialog(null, "예약완료");
					hotelServiceMainFrame.goToMyReserv();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"예약할 방을 선택해주세요");
					e1.printStackTrace();
				};
			}
		});
		reservBtn.setBounds(347, 461, 97, 46);
		panel.add(reservBtn);
		
		reservService = new ReservService();
		roomTypeService = new RoomTypeService();
		this.hotelServiceMainFrame=hotelServiceMainFrame;
	}
}
