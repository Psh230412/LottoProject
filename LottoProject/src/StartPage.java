
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

class StartPage extends JPanel { // 프로그램 실행 시 맨 처음에 뜰 창(로또하러가기 버튼)
	public StartPage() {
		JPanel panel = new JPanel();

		JButton btn = new JButton("로또하러가기");
//		setLayout(null);
//		panel.setLayout(null);
		panel.add(btn);

		panel.setBounds(0, 0, getWidth(), getHeight());
		btn.setBounds(80, 250, 200, 100);

		class Run2 implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				Management.card.show(Management.all, "번호 선택");
			}
		}

		btn.addActionListener(new Run2());
		
		add(panel);
		setSize(340, 550);
	}

	class LottoSlot extends JFrame { // 버튼 기능 구현 클래스
		public LottoSlot() {
			setSize(375, 685);
			setTitle("로또");

			JLayeredPane layeredPane = new JLayeredPane();
			layeredPane.setLayout(null);
			layeredPane.setPreferredSize(new Dimension(360, 648));

			// 배경 이미지 라벨
			ImageIcon backgroundImage = new ImageIcon("번호선택2.jpg");
			JLabel bg = new JLabel(backgroundImage);
			bg.setBounds(0, 0, 360, 648);

			layeredPane.add(bg, new Integer(0));
			add(layeredPane, BorderLayout.CENTER);

			// 돌아가기 버튼
			ImageIcon imageIcon = new ImageIcon("돌아가기.jpg");
			JLabel imageButton = new JLabel(imageIcon);
			imageButton.setBounds(7, 545, imageIcon.getIconWidth(), imageIcon.getIconHeight());

			imageButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					new StartPage();

				}
			});

			// 추첨하기 버튼
			ImageIcon imageIcon2 = new ImageIcon("추첨하기.jpg");
			JLabel imageButton2 = new JLabel(imageIcon2);
			imageButton2.setBounds(175, 540, imageIcon2.getIconWidth(), imageIcon2.getIconHeight());

			imageButton2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					new LottoRandomPage();

				}
			});

			// 도움말 버튼
			ImageIcon imageIcon3 = new ImageIcon("도움말버튼.jpg");
			JLabel imageButton3 = new JLabel(imageIcon3);
			imageButton3.setBounds(277, 10, imageIcon3.getIconWidth(), imageIcon3.getIconHeight());

			imageButton3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new HelpMessage();

				}
			});

			layeredPane.add(imageButton, new Integer(1));
			layeredPane.add(imageButton2, new Integer(2));
			layeredPane.add(imageButton3, new Integer(3));
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	}

	public static void main(String[] args) {
		new StartPage();
	}
}
