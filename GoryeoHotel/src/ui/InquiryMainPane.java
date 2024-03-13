package ui;

import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import hotel.comment.InquiriesComment;
import hotel.comment.InquiriesCommentService;
import hotel.inquiries.Inquiries;
import hotel.inquiries.InquiriesService;
import hotel.review.Review;
import hotel.user.User;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InquiryMainPane extends JPanel {
	private JTextField inquiryTitleTF;
	private JTextArea inquiryContentTA;
	private InquiriesService inquiriesService;
	private InquiriesCommentService inquiriesCommentService;
	private HotelServiceMainFrame hotelServiceMainFrame;
	private JPanel inquiryWritePane;
	private JPanel myInquiries;
	private JTable inquiriesTable;
	private JButton inquiriesDeleteBtn;
	private JPanel inquiryDetailPane;
	private JTextField inquiryDetailTitle;
	private JButton inquiriesDetailBtn;
	private JTextArea inquiryDetailContent;
	private JTextArea inquiryComment;
	private JLabel commentDateLB;
	private JLabel inquiryDateLB;
	private User loginUser;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public InquiryMainPane(HotelServiceMainFrame hotelServiceMainFrame) throws Exception {
		setLayout(new CardLayout(0, 0));
		setBounds(5,5,570,598);
		
		inquiryWritePane = new JPanel();
		add(inquiryWritePane, "글작성");
		inquiryWritePane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("고객센터 대표전화  ");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 27));
		lblNewLabel.setBounds(81, 56, 273, 61);
		inquiryWritePane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("1588-1588");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel_1.setBounds(91, 113, 217, 42);
		inquiryWritePane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("1:1 문의");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 19));
		lblNewLabel_2.setBounds(79, 154, 122, 42);
		inquiryWritePane.add(lblNewLabel_2);
		
		inquiryTitleTF = new JTextField();
		inquiryTitleTF.setBounds(81, 213, 408, 35);
		inquiryWritePane.add(inquiryTitleTF);
		inquiryTitleTF.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("제목");
		lblNewLabel_3.setBounds(81, 192, 65, 22);
		inquiryWritePane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("내용");
		lblNewLabel_4.setBounds(81, 258, 50, 15);
		inquiryWritePane.add(lblNewLabel_4);
		
		inquiryContentTA = new JTextArea();
		inquiryContentTA.setBounds(81, 283, 408, 214);
		inquiryWritePane.add(inquiryContentTA);
		
		JButton inquiryInsertBtn = new JButton("문의하기");
		inquiryInsertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(inquiryTitleTF.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "제목을 입력하세요");
					}
					else if(inquiryContentTA.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "내용을 입력하세요");
					}else {
					
					
					Inquiries inq = new Inquiries(0, inquiryTitleTF.getText(), inquiryContentTA.getText(), new java.sql.Date(10), hotelServiceMainFrame.getLoginUser(), new InquiriesComment());
					int row = inquiriesService.insertInquiries(inq);
					
				
					if(row==1) {
						CardLayout inquiryLayout = (CardLayout)InquiryMainPane.this.getLayout();
						inquiryLayout.show(InquiryMainPane.this,"글목록");
						displayMyInquiries();
						inquiryTitleTF.setText("");
						inquiryContentTA.setText("");
					}
				} 
				}catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		inquiryInsertBtn.setEnabled(false);
		inquiryInsertBtn.setBounds(398, 507, 91, 23);
		inquiryWritePane.add(inquiryInsertBtn);
		
		JButton btnNewButton_1 = new JButton("내가 쓴 글");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout inquiryLayout = (CardLayout)InquiryMainPane.this.getLayout();
				inquiryLayout.show(InquiryMainPane.this,"글목록");
				try {
					displayMyInquiries();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(367, 167, 122, 22);
		inquiryWritePane.add(btnNewButton_1);
		
		myInquiries = new JPanel();
		add(myInquiries, "글목록");
		myInquiries.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("나의 문의 내역");
		lblNewLabel_5.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel_5.setBounds(77, 64, 147, 36);
		myInquiries.add(lblNewLabel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				inquiriesDeleteBtn.setEnabled(true);
				inquiriesDetailBtn.setEnabled(true);
			}
		});
		scrollPane.setBounds(48, 140, 483, 334);
		myInquiries.add(scrollPane);
		
		inquiriesTable = new JTable();
		inquiriesTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				inquiriesDeleteBtn.setEnabled(true);
				inquiriesDetailBtn.setEnabled(true);
			}
		});
		inquiriesTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"\uBC88\uD638", "\uC81C\uBAA9", "\uB0B4\uC6A9", "\uC791\uC131\uC77C", "\uB2F5\uBCC0", "\uB2F5\uBCC0\uC791\uC131\uC77C"
			}
		));
		scrollPane.setViewportView(inquiriesTable);
		
		inquiriesDeleteBtn = new JButton("삭제");
		inquiriesDeleteBtn.setEnabled(false);
		inquiriesDeleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				int row = inquiriesTable.getSelectedRow();
				int inquiryNo =(Integer)inquiriesTable.getValueAt(row, 0);
					inquiriesService.deleteInquiries(inquiryNo);
					displayMyInquiries();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		inquiriesDeleteBtn.setBounds(413, 509, 91, 23);
		myInquiries.add(inquiriesDeleteBtn);
		
		JButton previousBtn = new JButton("");
		previousBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout inquiryLayout = (CardLayout)InquiryMainPane.this.getLayout();
				inquiryLayout.show(InquiryMainPane.this,"글작성");
			}
		});
		previousBtn.setForeground(new Color(255, 255, 255));
		previousBtn.setIcon(new ImageIcon(InquiryMainPane.class.getResource("/images/left-chevron (1).png")));
		previousBtn.setSelectedIcon(new ImageIcon(InquiryMainPane.class.getResource("/images/left-chevron (1).png")));
		previousBtn.setBounds(12, 10, 53, 44);
		myInquiries.add(previousBtn);
		
		inquiriesDetailBtn = new JButton("상세보기");
		inquiriesDetailBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = (String)inquiriesTable.getValueAt(inquiriesTable.getSelectedRow(),1);
				String content = (String)inquiriesTable.getValueAt(inquiriesTable.getSelectedRow(),2);
				Date inquiryDate = (Date)inquiriesTable.getValueAt(inquiriesTable.getSelectedRow(),3);
				String comment = (String)inquiriesTable.getValueAt(inquiriesTable.getSelectedRow(),4);
				Date commentDate = (Date)inquiriesTable.getValueAt(inquiriesTable.getSelectedRow(),5);
				CardLayout inquiryLayout = (CardLayout)InquiryMainPane.this.getLayout();
				inquiryLayout.show(InquiryMainPane.this,"디테일");
				inquiryDetailTitle.setText(title);
				inquiryDetailContent.setText(content);
				if(inquiriesTable.getValueAt(inquiriesTable.getSelectedRow(), 4)!=null) {
					inquiryComment.setText(comment);
					commentDateLB.setText(new SimpleDateFormat("yyyy.MM.dd").format(commentDate));
				}
				inquiryDateLB.setText(new SimpleDateFormat("yyyy.MM.dd").format(inquiryDate));
				
			}
		});
		inquiriesDetailBtn.setEnabled(false);
		inquiriesDetailBtn.setBounds(288, 509, 91, 23);
		myInquiries.add(inquiriesDetailBtn);
		
		inquiryDetailPane = new JPanel();
		add(inquiryDetailPane, "디테일");
		inquiryDetailPane.setLayout(null);
		
		inquiryDetailTitle = new JTextField();
		inquiryDetailTitle.setEditable(false);
		inquiryDetailTitle.setBounds(78, 76, 404, 21);
		inquiryDetailPane.add(inquiryDetailTitle);
		inquiryDetailTitle.setColumns(10);
		
		inquiryDetailContent = new JTextArea();
		inquiryDetailContent.setEnabled(false);
		inquiryDetailContent.setBounds(78, 132, 404, 124);
		inquiryDetailPane.add(inquiryDetailContent);
		
		inquiryComment = new JTextArea();
		inquiryComment.setEnabled(false);
		inquiryComment.setEditable(false);
		inquiryComment.setBounds(78, 321, 404, 141);
		inquiryDetailPane.add(inquiryComment);
		
		JLabel lblNewLabel_6 = new JLabel("답변");
		lblNewLabel_6.setBounds(78, 284, 109, 27);
		inquiryDetailPane.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout inquiryLayout = (CardLayout)InquiryMainPane.this.getLayout();
				inquiryLayout.show(InquiryMainPane.this,"글목록");
			}
		});
		btnNewButton.setIcon(new ImageIcon(InquiryMainPane.class.getResource("/images/left-chevron (1).png")));
		btnNewButton.setBounds(12, 10, 47, 39);
		inquiryDetailPane.add(btnNewButton);
		
		inquiryDateLB = new JLabel("");
		inquiryDateLB.setBounds(432, 46, 50, 15);
		inquiryDetailPane.add(inquiryDateLB);
		
		commentDateLB = new JLabel("");
		commentDateLB.setBounds(432, 290, 50, 15);
		inquiryDetailPane.add(commentDateLB);
		
		if(inquiryTitleTF!=null && !inquiryTitleTF.equals("") && inquiryContentTA!=null && !inquiryContentTA.equals("")) {
			inquiryInsertBtn.setEnabled(true);
		}
		inquiriesService = new InquiriesService();
		inquiriesCommentService = new InquiriesCommentService();
		this.hotelServiceMainFrame=hotelServiceMainFrame;
		loginUser = hotelServiceMainFrame.getLoginUser();
	}
	void displayMyInquiries() throws Exception {
		String loginUserId=hotelServiceMainFrame.getLoginUser().getUser_Id();
		List<Inquiries> inquiriesList = inquiriesService.findById(loginUserId);
		Vector columVector = new Vector();
		columVector.add("번호");
		columVector.add("제목");
		columVector.add("내용");
		columVector.add("작성일");
		columVector.add("답변");
		columVector.add("답변작성일");
		
		Vector tableVector = new Vector();
		for (Inquiries inquiries : inquiriesList) {
			Vector rowVector = new Vector();
			Date inquiryDate = inquiries.getInquiries_date();
			java.util.Date commentDate = inquiries.getInquiries_comment().getComm_date();
			InquiriesComment comment = inquiries.getInquiries_comment();
			rowVector.add(inquiries.getInquiries_no());
			rowVector.add(inquiries.getInquiries_title());
			rowVector.add(inquiries.getInquiries_content());
			rowVector.add(inquiryDate);
			if(comment==null) {
				rowVector.add("");
			}else {
				rowVector.add(comment.getComm_content());
			}
			if (commentDate != null) {
			    rowVector.add(commentDate);
			}else {
				rowVector.add(null);
			}

			tableVector.add(rowVector);
		}
		DefaultTableModel tableModel = new DefaultTableModel(tableVector, columVector);
		inquiriesTable.setModel(tableModel);
	}
		
	void displayAllInquiries() throws Exception {
		List<Inquiries> inquiriesList = inquiriesService.findByAll();
		Vector columVector = new Vector();
		columVector.add("번호");
		columVector.add("제목");
		columVector.add("내용");
		columVector.add("작성일");
		columVector.add("답변");
		columVector.add("답변작성일");
		
		Vector tableVector = new Vector();
		
		for (Inquiries inquiries : inquiriesList) {
			Vector rowVector = new Vector();
			
			
			rowVector.add(inquiries.getInquiries_no());
			rowVector.add(inquiries.getInquiries_title());
			rowVector.add(inquiries.getInquiries_content());
			rowVector.add(inquiries.getInquiries_date());
			InquiriesComment comment = inquiries.getInquiries_comment();
			if(comment==null) {
				rowVector.add("");
			}else {
				rowVector.add(comment.getComm_content());
			}
			if (inquiries.getInquiries_comment().getComm_date() != null) {
			    rowVector.add( inquiries.getInquiries_comment().getComm_date());
			}else {
				rowVector.add(null);
				
			}
			tableVector.add(rowVector);
		}
		DefaultTableModel tableModel = new DefaultTableModel(tableVector, columVector);
		inquiriesTable.setModel(tableModel);
	}
}