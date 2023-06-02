
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

class StartPage extends JPanel { 
	JLabel[] labelOfMain = new JLabel[5];
	public StartPage() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		for(int i=0;i<5;i++) {
			URL urlOfMain = LottoTicket1.class.getClassLoader()
					.getResource("image/메인화면_0"+(i + 1)+".gif");
			ImageIcon imageIcon = new ImageIcon(urlOfMain);
			labelOfMain[i] = new JLabel(imageIcon);
			panel.add(labelOfMain[i]);
		}
		
		labelOfMain[0].setBounds(0, 0, 340, 379);
		labelOfMain[1].setBounds(0, 379, 340, 42);
		labelOfMain[2].setBounds(0, 421, 340, 42);
		labelOfMain[3].setBounds(0, 463, 340, 46);
		labelOfMain[4].setBounds(0, 509, 340, 41);
		
		JButton btn = new JButton("로또하러가기");

		panel.add(btn);

		panel.setBounds(0, 0, 340, 550);
		setLayout(null);
		
		btn.setBounds(0, 421, 340, 42);
		labelOfMain[2].add(btn);
		labelOfMain[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Management.card.show(Management.all, "번호 선택");
			}
		});
		add(panel);

		/*
		 * class Run2 implements ActionListener { public void
		 * actionPerformed(ActionEvent e) { Management.card.show(Management.all,
		 * "번호 선택"); } }
		 * 
		 * btn.addActionListener(new Run2());
		 */
		
		//setSize(340, 550);
	}

//	class LottoSlot extends JFrame { // 踰꾪듉 湲곕뒫 援ы쁽 �겢�옒�뒪
//		public LottoSlot() {
//			setSize(375, 685);
//			setTitle("濡쒕삉");
//
//			JLayeredPane layeredPane = new JLayeredPane();
//			layeredPane.setLayout(null);
//			layeredPane.setPreferredSize(new Dimension(360, 648));
//
//			// 諛곌꼍 �씠誘몄� �씪踰�
//			ImageIcon backgroundImage = new ImageIcon("踰덊샇�꽑�깮2.jpg");
//			JLabel bg = new JLabel(backgroundImage);
//			bg.setBounds(0, 0, 360, 648);
//
//			layeredPane.add(bg, new Integer(0));
//			add(layeredPane, BorderLayout.CENTER);
//
//			// �룎�븘媛�湲� 踰꾪듉
//			ImageIcon imageIcon = new ImageIcon("�룎�븘媛�湲�.jpg");
//			JLabel imageButton = new JLabel(imageIcon);
//			imageButton.setBounds(7, 545, imageIcon.getIconWidth(), imageIcon.getIconHeight());
//
//			imageButton.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					dispose();
//					new StartPage();
//
//				}
//			});
//
//			// 異붿꺼�븯湲� 踰꾪듉
//			ImageIcon imageIcon2 = new ImageIcon("異붿꺼�븯湲�.jpg");
//			JLabel imageButton2 = new JLabel(imageIcon2);
//			imageButton2.setBounds(175, 540, imageIcon2.getIconWidth(), imageIcon2.getIconHeight());
//
//			imageButton2.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					dispose();
//					new LottoRandomPage();
//
//				}
//			});
//
//			// �룄��留� 踰꾪듉
//			ImageIcon imageIcon3 = new ImageIcon("�룄��留먮쾭�듉.jpg");
//			JLabel imageButton3 = new JLabel(imageIcon3);
//			imageButton3.setBounds(277, 10, imageIcon3.getIconWidth(), imageIcon3.getIconHeight());
//
//			imageButton3.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					new HelpMessage();
//
//				}
//			});
//
//			layeredPane.add(imageButton, new Integer(1));
//			layeredPane.add(imageButton2, new Integer(2));
//			layeredPane.add(imageButton3, new Integer(3));
//			setVisible(true);
//			setDefaultCloseOperation(EXIT_ON_CLOSE);
//		}
//	}

	public static void main(String[] args) {
		new StartPage();
	}
}
