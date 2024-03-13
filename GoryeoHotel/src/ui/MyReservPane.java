package ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import hotel.reserv.Reserv;
import hotel.reserv.ReservService;
import hotel.room.Room;
import hotel.room_type.RoomTypeService;
import hotel.user.User;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class MyReservPane extends JPanel {
	private JTable myReservTable;
	private ReservService reservService;
	private JDateChooser firstDateChooser;
	private JDateChooser lastDateChooser;
	private RoomTypeService roomTypeService;
	private HotelServiceMainFrame hotelServiceMainFrame;
	private User loginUser;
	private JPanel panel;
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public MyReservPane(HotelServiceMainFrame hotelServiceMainFrame) throws Exception {
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("예약일로 나의 예약 확인");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(153, 62, 365, 45);
		panel.add(lblNewLabel);
		
		JButton myReservBtn = new JButton("검색");
		myReservBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				searchMyReserv(hotelServiceMainFrame);
			}

			
		});
		myReservBtn.setBounds(392, 101, 102, 45);
		panel.add(myReservBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 256, 417, 226);
		panel.add(scrollPane);
		
		myReservTable = new JTable();
		myReservTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		myReservTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\uC608\uC57D\uBC88\uD638", "\uCCB4\uD06C\uC778", "\uCCB4\uD06C\uC544\uC6C3", "\uBC29\uD0C0\uC785", "\uC131\uC778(\uBA85)", "\uC601\uC720\uC544(\uBA85)", "\uCE68\uB300\uCD94\uAC00", "\uACB0\uC81C\uC218\uB2E8", "\uACB0\uC81C\uC77C"
			}
		));
		scrollPane.setViewportView(myReservTable);
		
		JButton btnNewButton = new JButton("예약취소");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = myReservTable.getSelectedRow();
				int selectedReservNo= (Integer)myReservTable.getValueAt(selectedRow,0);
				
					try {
						if((reservService.selectAllAll(selectedReservNo).getReservCheckIn()).getTime()>System.currentTimeMillis()) {
							reservService.deleteByReservNo(selectedReservNo);
							searchMyReserv(hotelServiceMainFrame);
						}else {
							JOptionPane.showMessageDialog(null, "이미 지난 예약은 취소할 수 없습니다.");
						}
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		btnNewButton.setBounds(397, 198, 97, 23);
		panel.add(btnNewButton);
		
		firstDateChooser = new JDateChooser();
		firstDateChooser.setBounds(96, 117, 102, 21);
		panel.add(firstDateChooser);
		
		lastDateChooser = new JDateChooser();
		lastDateChooser.setBounds(246, 117, 102, 21);
		panel.add(lastDateChooser);
		
		JButton btnNewButton_1 = new JButton("상세보기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				try {
					Reserv reserv = reservService.selectAllAll((Integer)myReservTable.getValueAt(myReservTable.getSelectedRow(),0));
					hotelServiceMainFrame.callReservDetailDialog(reserv);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(275, 198, 91, 23);
		panel.add(btnNewButton_1);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MONTH, -1);
		firstDateChooser.setDate(cal.getTime());
		lastDateChooser.setDate(new Date());
		
		JButton reviewWriteButton = new JButton("리뷰 쓰기");
		reviewWriteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ReviewWriteDialog reviewDialog = new ReviewWriteDialog(hotelServiceMainFrame);//작성폼 화면 띄우기
					reviewDialog.setModal(true);
					reviewDialog.setVisible(true);
					int reserv = reservService.findRoomByReservNo((Integer)myReservTable.getValueAt(myReservTable.getSelectedRow(), 0));
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		reviewWriteButton.setBounds(166, 198, 97, 23);
		panel.add(reviewWriteButton);
		this.hotelServiceMainFrame = hotelServiceMainFrame;
		reservService = new ReservService();
		roomTypeService = new RoomTypeService();
	}
	private void searchMyReserv(HotelServiceMainFrame hotelServiceMainFrame) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.MONTH, -1);
			List<Reserv> reservList=reservService.findMyReservByDate(hotelServiceMainFrame.getLoginUser().getUser_Id(),cal.getTime(), new Date());
			Vector tableVector = new Vector();
			for(int i=0;i<reservList.size();i++) {
				int roomNo = reservList.get(i).getRoom().getRoomNo();
				String roomType = roomTypeService.findRoomTypeByRoomNo(roomNo).getRoomTypeName();
				Vector rowVector = new Vector();
				rowVector.add(reservList.get(i).getReservNo());
				rowVector.add(reservList.get(i).getReservCheckIn());
				rowVector.add(reservList.get(i).getReservCheckOut());
				rowVector.add(roomNo);
				rowVector.add(roomType);
				rowVector.add(reservList.get(i).getReservAdult());
				rowVector.add(reservList.get(i).getReservChild());
				rowVector.add(reservList.get(i).getReservExtraBed());
				rowVector.add(reservList.get(i).getReservPayment());
				rowVector.add(reservList.get(i).getReservDate());
				tableVector.add(rowVector);
			}
			
			Vector columnVector = new Vector();
			columnVector.add("예약번호");
			columnVector.add("체크인");
			columnVector.add("체크아웃");
			columnVector.add("방번호");
			columnVector.add("방타입");
			columnVector.add("성인(명)");
			columnVector.add("영유아(명)");
			columnVector.add("침대추가");
			columnVector.add("결제수단");
			columnVector.add("결제일");
			
			DefaultTableModel tableModel = new DefaultTableModel(tableVector,columnVector);
			
			myReservTable.setModel(tableModel);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	void displayDefaultList() throws Exception {
		List<Reserv> reservList=reservService.findMyReservByDate(hotelServiceMainFrame.getLoginUser().getUser_Id(),firstDateChooser.getDate(), lastDateChooser.getDate());
		Vector tableVector = new Vector();
		for(int i=0;i<reservList.size();i++) {
			int roomNo = reservList.get(i).getRoom().getRoomNo();
			String roomType = roomTypeService.findRoomTypeByRoomNo(roomNo).getRoomTypeName();
			Vector rowVector = new Vector();
			rowVector.add(reservList.get(i).getReservNo());
			rowVector.add(reservList.get(i).getReservCheckIn());
			rowVector.add(reservList.get(i).getReservCheckOut());
			rowVector.add(roomNo);
			rowVector.add(roomType);
			rowVector.add(reservList.get(i).getReservAdult());
			rowVector.add(reservList.get(i).getReservChild());
			rowVector.add(reservList.get(i).getReservExtraBed());
			rowVector.add(reservList.get(i).getReservPayment());
			rowVector.add(reservList.get(i).getReservDate());
			tableVector.add(rowVector);
		}
		
		Vector columnVector = new Vector();
		columnVector.add("예약번호");
		columnVector.add("체크인");
		columnVector.add("체크아웃");
		columnVector.add("방번호");
		columnVector.add("방타입");
		columnVector.add("성인(명)");
		columnVector.add("영유아(명)");
		columnVector.add("침대추가");
		columnVector.add("결제수단");
		columnVector.add("결제일");
		
		DefaultTableModel tableModel = new DefaultTableModel(tableVector,columnVector);
		
		myReservTable.setModel(tableModel);
	}
}
