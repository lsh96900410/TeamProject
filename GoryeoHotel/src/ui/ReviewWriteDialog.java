package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hotel.review.Review;
import hotel.review.ReviewService;

import hotel.user.User;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class ReviewWriteDialog extends JDialog {

	private ReviewService reviewService;
	private Review review;
	private HotelServiceMainFrame hotelServiceMainFrame;
	private final JPanel contentPanel = new JPanel();

	private JTextField reviewTitleTextField;
	private JTextArea reviewContentTextArea;
	
	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public ReviewWriteDialog(HotelServiceMainFrame hotelServiceMainFrame) throws Exception {
		setBounds(100, 100, 450, 472);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(236, 236, 236));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		reviewTitleTextField = new JTextField();
		reviewTitleTextField.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		reviewTitleTextField.setBounds(135, 53, 249, 21);
		contentPanel.add(reviewTitleTextField);
		reviewTitleTextField.setColumns(10);
		
		reviewContentTextArea = new JTextArea();
		reviewContentTextArea.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		reviewContentTextArea.setBounds(135, 107, 249, 250);
		contentPanel.add(reviewContentTextArea);
		
		JLabel reviewTitleLabel = new JLabel("제목");
		reviewTitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		reviewTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		reviewTitleLabel.setBounds(39, 56, 57, 15);
		contentPanel.add(reviewTitleLabel);
		
		JLabel reviewContentLabel = new JLabel("내용");
		reviewContentLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		reviewContentLabel.setHorizontalAlignment(SwingConstants.CENTER);
		reviewContentLabel.setBounds(39, 107, 57, 15);
		contentPanel.add(reviewContentLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(236, 236, 236));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try {
							String reviewTitle = reviewTitleTextField.getText();
							String reviewContent = reviewContentTextArea.getText();
							String reviewWriter = hotelServiceMainFrame.getLoginUser().getUser_Id();
							Review insertReview = new Review(0, null, reviewTitle, reviewContent, new User(reviewWriter, null, null, null, null, null, null), null);
							reviewService.insertReview(insertReview);
							JOptionPane.showMessageDialog(null, "등록되었습니다.");
							setVisible(false);
							hotelServiceMainFrame.goToReview();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
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
		review = new Review();
		this.reviewService = new ReviewService();
		this.hotelServiceMainFrame = hotelServiceMainFrame;
	} // 생성자 끝
}
