package ui;

import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import hotel.comment.InquiriesComment;
import hotel.comment.InquiriesCommentService;
import hotel.inquiries.Inquiries;
import hotel.inquiries.InquiriesService;
import hotel.reserv.Reserv;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;

public class AdminInquiryMainPane extends JPanel {
	private JPanel inquiriesPane;
	private JTable table;
	private JPanel detailNWritePane;
	private JTextField titleTA;
	private JTextArea contentTA;
	private JTextArea commentTA;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private InquiriesService inquiriesService;
	private InquiriesCommentService commentService;
	private JLabel inqLB;
	private JLabel commentLB;
	private HotelServiceMainFrame hotelServiceMainFrame;
	private JButton btnNewButton_3;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public AdminInquiryMainPane(HotelServiceMainFrame hotelServiceMainFrame) throws Exception {
		setBounds(5,5,570,600);
		setLayout(new CardLayout(0, 0));
		
		inquiriesPane = new JPanel();
		add(inquiriesPane, "리스트");
		inquiriesPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("문의 목록");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 21));
		lblNewLabel.setBounds(224, 51, 151, 52);
		inquiriesPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					/*
					 * CardLayout layout = (CardLayout)AdminInquiryMainPane.this.getLayout();
					 * layout.show(AdminInquiryMainPane.this,"답변창");
					 * titleTA.setText((String)table.getValueAt(table.getSelectedRow(),1));
					 * contentTA.setText((String)table.getValueAt(table.getSelectedRow(), 2));
					 * commentTA.setText(commentService.findByInquiriesComment((Integer)table.
					 * getValueAt(table.getSelectedRow(),5)).getComm_content()); inqLB.setText(new
					 * SimpleDateFormat("yyyy.MM.dd").format(table.getValueAt(table.getSelectedRow()
					 * , 3))); commentLB.setText(new
					 * SimpleDateFormat("yyyy.MM.dd").format((commentService.findByInquiriesComment(
					 * (Integer)table.getValueAt(table.getSelectedRow(),5)).getComm_date())));
					 */
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		scrollPane.setBounds(55, 129, 455, 340);
		inquiriesPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnNewButton_1 = new JButton("답변작성");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				int row = table.getSelectedRow();
				System.out.println(row);
				int inquriesNo=(int)table.getValueAt(row,0);
				int commNo=(int)table.getValueAt(row,5);
				System.out.println(commNo);
				if(commNo!=0) {
					return;
				}else{
					CardLayout layout = (CardLayout)AdminInquiryMainPane.this.getLayout();
					layout.show(AdminInquiryMainPane.this,"답변창");
				}
				InquiriesComment comm = commentService.findCommByInquiriesNo(inquriesNo);
				System.out.println(comm);
				titleTA.setText((String)table.getValueAt(table.getSelectedRow(),1));
				contentTA.setText((String)table.getValueAt(table.getSelectedRow(), 2));
				commentTA.setText(comm.getComm_content());//commentService.findCommByInquiriesNo((Integer)table.getValueAt(table.getSelectedRow(),0)).getComm_content()
				inqLB.setText(new SimpleDateFormat("yyyy.MM.dd").format(table.getValueAt(table.getSelectedRow(), 3)));
				commentLB.setText(new SimpleDateFormat("yyyy.MM.dd").format((comm.getComm_date())));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(419, 479, 91, 23);
		inquiriesPane.add(btnNewButton_1);
		
		btnNewButton_3 = new JButton("전체조회");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Inquiries> inquiries;
				try {
					inquiries = inquiriesService.findByAll();
				Vector tableVector = new Vector();
				for(int i=0;i<inquiries.size();i++) {
					Vector rowVector = new Vector();
					rowVector.add(inquiries.get(i).getInquiries_no());
					rowVector.add(inquiries.get(i).getInquiries_title());
					rowVector.add(inquiries.get(i).getInquiries_content());
					rowVector.add(inquiries.get(i).getInquiries_date());
					rowVector.add(inquiries.get(i).getUser().getUser_Id());
					rowVector.add(inquiries.get(i).getInquiries_comment().getComm_no());
					tableVector.add(rowVector);
				}
				Vector columnVector = new Vector();
				columnVector.add("번호");
				columnVector.add("제목");
				columnVector.add("내용");
				columnVector.add("작성일");
				columnVector.add("작성자");
				columnVector.add("답변번호");
				
				DefaultTableModel tableModel = new DefaultTableModel(tableVector,columnVector);
				
				table.setModel(tableModel);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(316, 479, 91, 23);
		inquiriesPane.add(btnNewButton_3);
		
		detailNWritePane = new JPanel();
		add(detailNWritePane, "답변창");
		detailNWritePane.setLayout(null);
		
		titleTA = new JTextField();
		titleTA.setBounds(60, 42, 420, 21);
		detailNWritePane.add(titleTA);
		titleTA.setColumns(10);
		
		contentTA = new JTextArea();
		contentTA.setBounds(60, 79, 420, 155);
		detailNWritePane.add(contentTA);
		
		commentTA = new JTextArea();
		commentTA.setBounds(60, 255, 420, 155);
		detailNWritePane.add(commentTA);
		
		JButton btnNewButton = new JButton("답변달기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = table.getSelectedRow();
					int inquiriesNo =(int)table.getValueAt(row, 0);
					System.out.println(inquiriesService.findByInquiries(inquiriesNo));
						InquiriesComment comment = new InquiriesComment(1,commentTA.getText(),null,inquiriesService.findByInquiries(inquiriesNo));
						commentService.insertInquiriesComment(comment);
						System.out.println(comment);
						JOptionPane.showMessageDialog(null, "답변이 등록되었습니다.");
						CardLayout layout = (CardLayout)AdminInquiryMainPane.this.getLayout();
						layout.show(AdminInquiryMainPane.this,"리스트");
						displayInquiries();
						commentTA.setText("");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(389, 420, 91, 23);
		detailNWritePane.add(btnNewButton);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout layout = (CardLayout)AdminInquiryMainPane.this.getLayout();
				layout.show(AdminInquiryMainPane.this,"리스트");
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(AdminInquiryMainPane.class.getResource("/images/left-chevron (1).png")));
		btnNewButton_2.setBounds(12, 9, 36, 34);
		detailNWritePane.add(btnNewButton_2);
		
		inqLB = new JLabel("");
		inqLB.setBounds(428, 60, 50, 15);
		detailNWritePane.add(inqLB);
		
		commentLB = new JLabel("");
		commentLB.setBounds(430, 244, 50, 15);
		detailNWritePane.add(commentLB);

		commentService = new InquiriesCommentService();
		inquiriesService = new InquiriesService();
		this.hotelServiceMainFrame= hotelServiceMainFrame;
	}
	void displayInquiries() throws Exception {
	List<Inquiries> inquiries = inquiriesService.findByAll();
	Vector tableVector = new Vector();
	for(int i=0;i<inquiries.size();i++) {
		Vector rowVector = new Vector();
		rowVector.add(inquiries.get(i).getInquiries_no());
		rowVector.add(inquiries.get(i).getInquiries_title());
		rowVector.add(inquiries.get(i).getInquiries_content());
		rowVector.add(inquiries.get(i).getInquiries_date());
		rowVector.add(inquiries.get(i).getUser().getUser_Id());
		rowVector.add(inquiries.get(i).getInquiries_comment().getComm_no());
		tableVector.add(rowVector);
	}
	Vector columnVector = new Vector();
	columnVector.add("번호");
	columnVector.add("제목");
	columnVector.add("내용");
	columnVector.add("작성일");
	columnVector.add("작성자");
	columnVector.add("답변번호");
	
	DefaultTableModel tableModel = new DefaultTableModel(tableVector,columnVector);
	
	table.setModel(tableModel);
	}
	
}
