import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//시작페이지 1 
public class Tutorial extends JPanel {
	JLabel label;
	Management management;

	public Tutorial() {
		URL urlOfTuto = LottoTicket1.class.getClassLoader().getResource("image5/튜토리얼_1.gif");
		ImageIcon imageIcon = new ImageIcon(urlOfTuto);
		label = new JLabel(imageIcon);
		label.addMouseListener((MouseListener) new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Management.card.show(Management.all, "튜토리얼2");

			}
		});
		setLayout(new BorderLayout());
		add(label);
		setBounds(0, 0, 340, 550);
		setVisible(true);

	}
}

// 시작페이지 2
class Tutorial2 extends JPanel {
	JLabel label;
	Management management;

	public Tutorial2() {
		URL urlOfTuto = LottoTicket1.class.getClassLoader().getResource("image5/튜토리얼_2.gif");
		ImageIcon imageIcon = new ImageIcon(urlOfTuto);
		label = new JLabel(imageIcon);
		label.addMouseListener((MouseListener) new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Management.card.show(Management.all, "튜토리얼3");
			}
		});

		setLayout(new BorderLayout());
		add(label);
		setBounds(0, 0, 340, 550);
		setVisible(true);

	}
}

// 시작페이지 3
class Tutorial3 extends JPanel {
	JLabel label;
	Management management;

	public Tutorial3() {
		URL urlOfTuto = LottoTicket1.class.getClassLoader().getResource("image5/튜토리얼_3.gif");
		ImageIcon imageIcon = new ImageIcon(urlOfTuto);
		label = new JLabel(imageIcon);
		label.setIcon(imageIcon);
		label.addMouseListener((MouseListener) new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Management.card.show(Management.all, "튜토리얼4");
			}
		});

		setLayout(new BorderLayout());
		add(label);
		setBounds(0, 0, 340, 550);
		setVisible(true);

	}
}

// 버튼소개 페이지
class Tutorial4 extends JPanel {
	JLabel label;
	Management management;

	public Tutorial4() {

		// 배경
		URL urlOfTuto = LottoTicket1.class.getClassLoader().getResource("image5/튜토리얼_4.gif");
		ImageIcon imageIcon = new ImageIcon(urlOfTuto);
		label = new JLabel(imageIcon);
		label.setIcon(imageIcon);
		label.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());

		// 로또 하러가기 버튼
		JButton b1 = new JButton();
		URL urlOfTuto1 = LottoTicket1.class.getClassLoader().getResource("image5/튜토리얼_5.gif");
		ImageIcon imageIcon1 = new ImageIcon(urlOfTuto1);
		b1.setIcon(imageIcon1);

		b1.setIcon(imageIcon1);
		b1.setBounds(85, 430, imageIcon1.getIconWidth(), imageIcon1.getIconHeight());
		b1.setBorderPainted(false);

		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Management.card.show(Management.all, "튜토리얼6");

			}
		});

		setLayout(new BorderLayout());
		add(b1);
		add(label);
		setBounds(0, 0, 340, 550);
		setVisible(true);

	}
}

// 로또 하러가기 버튼 선택 페이지
class Tutorial5 extends JPanel {
	JLabel label;
	Management management;

	public Tutorial5() {
		URL urlOfTuto = LottoTicket1.class.getClassLoader().getResource("image5/튜토리얼_6.gif");
		ImageIcon imageIcon = new ImageIcon(urlOfTuto);
		label = new JLabel(imageIcon);
		label.setIcon(imageIcon);

		label.addMouseListener((MouseListener) new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Management.card.show(Management.all, "튜토리얼6");
			}
		});

		setLayout(new BorderLayout());
		add(label);
		setBounds(0, 0, 340, 550);
		setVisible(true);

	}
}

// 슬롯 설명 페이지
class Tutorial6 extends JPanel {
	JLabel label;
	Management management;

	public Tutorial6() {
		URL urlOfTuto = LottoTicket1.class.getClassLoader().getResource("image5/튜토리얼_7.gif");
		ImageIcon imageIcon = new ImageIcon(urlOfTuto);
		label = new JLabel(imageIcon);
		label.setIcon(imageIcon);

		label.addMouseListener((MouseListener) new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Management.card.show(Management.all, "튜토리얼7");
			}
		});

		setLayout(new BorderLayout());
		add(label);
		setBounds(0, 0, 340, 550);
		setVisible(true);

	}
}

// 빈슬롯 버튼 페이지
class Tutorial7 extends JPanel {
	JLabel label;
	Management management;

	public Tutorial7() {
		// 배경
		URL urlOfTuto = LottoTicket1.class.getClassLoader().getResource("image5/튜토리얼_8.gif");
		ImageIcon imageIcon = new ImageIcon(urlOfTuto);
		label = new JLabel(imageIcon);
		label.setIcon(imageIcon);

		// 빈슬롯 버튼
		JButton b1 = new JButton();
		URL urlOfTuto2 = LottoTicket1.class.getClassLoader().getResource("image5/튜토리얼_9.gif");
		ImageIcon imageIcon2 = new ImageIcon(urlOfTuto2);
		b1.setIcon(imageIcon2);

		b1.setBounds(12, 86, imageIcon2.getIconWidth(), imageIcon2.getIconHeight());
		b1.setBorderPainted(false);

		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Management.card.show(Management.all, "튜토리얼7-1");

			}
		});

		setLayout(new BorderLayout());
		add(b1);
		add(label);
		setBounds(0, 0, 340, 550);
		setVisible(true);

	}
}

//번호선택 설명페이지
class Tutorial7_1 extends JPanel {
	JLabel label;
	Management management;

	public Tutorial7_1() {
		URL urlOfTuto = LottoTicket1.class.getClassLoader().getResource("image5/튜토리얼_10.gif");
		ImageIcon imageIcon = new ImageIcon(urlOfTuto);
		label = new JLabel(imageIcon);
		label.setIcon(imageIcon);

		label.addMouseListener((MouseListener) new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Management.card.show(Management.all, "튜토리얼7-2");
			}
		});

		setLayout(new BorderLayout());
		add(label);
		setBounds(0, 0, 340, 550);
		setVisible(true);

	}
}

//번호선택 사용해보세요
class Tutorial7_2 extends JPanel {
	JLabel label;
	Management management;

	public Tutorial7_2() {
		URL urlOfTuto = LottoTicket1.class.getClassLoader().getResource("image5/튜토리얼_11.gif");
		ImageIcon imageIcon = new ImageIcon(urlOfTuto);
		label = new JLabel(imageIcon);
		label.setIcon(imageIcon);

		label.addMouseListener((MouseListener) new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Management.card.show(Management.all, "튜토리얼8");
			}
		});

		setLayout(new BorderLayout());
		add(label);
		setBounds(0, 0, 340, 550);
		setVisible(true);

	}
}

// 번호 오토로 설정 후 뜨는 안내 화면 (이미지 바꾸기)
class Tutorial9 extends JPanel {
	JLabel label;
	Management management;

	public Tutorial9() {
		// 배경
		URL urlOfTuto = LottoTicket1.class.getClassLoader().getResource("image5/튜토리얼_12.gif");
		ImageIcon imageIcon = new ImageIcon(urlOfTuto);
		label = new JLabel(imageIcon);
		label.setIcon(imageIcon);

		// 안내이미지 누르면 다시 Tutorial Ticket으로 돌아감
		label.addMouseListener((MouseListener) new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Management.card.show(Management.all, "튜토리얼11");
			}
		});
		setLayout(new BorderLayout());
		add(label);
		setBounds(0, 0, 340, 550);
		setVisible(true);

	}
}

// 번호 수동으로 설정 후 뜨는 안내 화면 (이미지 바꾸기)
class Tutorial10 extends JPanel {
	JLabel label;
	Management management;

	public Tutorial10() {
		// 배경
		URL urlOfTuto = LottoTicket1.class.getClassLoader().getResource("image5/튜토리얼_2.gif");
		ImageIcon imageIcon = new ImageIcon(urlOfTuto);
		label = new JLabel(imageIcon);
		label.setIcon(imageIcon);

		// 안내이미지 누르면 다시 Tutorial Ticket2으로 감
		label.addMouseListener((MouseListener) new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Management.card.show(Management.all, "튜토리얼11");
			}
		});

		setLayout(new BorderLayout());
		add(label);
		setBounds(0, 0, 340, 550);
		setVisible(true);

	}
}

//번호 오토로 설정 후 뜨는 안내 화면 (이미지 바꾸기)
class Tutorial12 extends JPanel {
	JLabel label;
	Management management;

	public Tutorial12() {
		// 배경
		URL urlOfTuto = LottoTicket1.class.getClassLoader().getResource("image5/튜토리얼_13.gif");
		ImageIcon imageIcon = new ImageIcon(urlOfTuto);
		label = new JLabel(imageIcon);
		label.setIcon(imageIcon);

		// 안내이미지 누르면 다시 Tutorial Ticket으로 돌아감
		label.addMouseListener((MouseListener) new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Management.card.show(Management.all, "튜토리얼11");
			}
		});
		setLayout(new BorderLayout());
		add(label);
		setBounds(0, 0, 340, 550);
		setVisible(true);

	}
}

//번호 오토로 설정 후 뜨는 안내 화면 (이미지 바꾸기)
class Tutorial13 extends JPanel {
	JLabel label;
	Management management;

	public Tutorial13() {
		// 배경
		URL urlOfTuto = LottoTicket1.class.getClassLoader().getResource("image5/튜토리얼_14.gif");
		ImageIcon imageIcon = new ImageIcon(urlOfTuto);
		label = new JLabel(imageIcon);
		label.setIcon(imageIcon);

		// 안내이미지 누르면 다시 Tutorial Ticket으로 돌아감
		label.addMouseListener((MouseListener) new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Management.card.show(Management.all, "시작");
			}
		});
		setLayout(new BorderLayout());
		add(label);
		setBounds(0, 0, 340, 550);
		setVisible(true);

	}
}
