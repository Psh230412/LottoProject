import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class LottoTicket5 extends JFrame {
	private boolean isClick = false;
	private boolean isAuto = false;
	List<String> selectedMode = new ArrayList<>();
	List<Integer> selectedNumbers = new ArrayList<>();
	private JButton[] lottoNumBtn = new JButton[45];;
	private static int changeCount = 0;

	public boolean isAuto() {
		return isAuto;
	}

	public boolean isClick() {
		return isClick;
	}

	public void setClick(boolean isClick) {
		this.isClick = isClick;
	}

	public void setAuto(boolean isAuto) {
		this.isAuto = isAuto;
	}

	public void resetCount() { // 移댁슫�듃瑜� 由ъ뀑�븯�뒗 硫붿꽌�뱶瑜� 異붽��빀�땲�떎
		this.changeCount = 0;
	}

	public void increaseCount() {
		this.changeCount++;
	}

	public void decreaseCount() {
		this.changeCount--;
	}

	public int getChangeCount() { // �쁽�옱 移댁슫�듃瑜� 媛��졇�삤�뒗 硫붿꽌�뱶瑜� 異붽��빀�땲�떎
		return this.changeCount;
	}

	public void buttonCreate() {
		for (int i = 0; i < lottoNumBtn.length; i++) {
			String lottoNumBtnName = String.valueOf(i + 1);
			lottoNumBtn[i] = new JButton(lottoNumBtnName);
			// lottoNumbtn[0]={1} lottoNumbtn[1]={2}.......lottoNumbtn[n]={n+1}
			lottoNumBtn[i].addActionListener(new MyListener5(this));
		}
	}

	public List<Integer> getSelectedNumbers() {
		for (int i = 0; i < lottoNumBtn.length; i++) {
			if (lottoNumBtn[i].getBackground().equals(Color.RED)) {
				selectedNumbers.add(i + 1); // lottoNumBtn�쓽 �씤�뜳�뒪�뒗 0遺��꽣 �떆�옉�븯誘�濡� 1�쓣 �뜑�빐�빞 踰덊샇瑜� �뼸�쓣 �닔
											// �엳�뒿�땲�떎.
			}
		}
		return selectedNumbers;
	}

	public List<String> getSelectedMode() {
		if (isAuto == true && isClick == true) {
			selectedMode.add("�옄�룞");
		} else if (isAuto == false && isClick == true) {
			selectedMode.add("諛섏옄�룞");
		} else {
			selectedMode.add("�닔�룞");
		}
		return selectedMode;
	}

	public LottoTicket5() {

		JPanel oneTicketPanel = new JPanel();

		JPanel titlePanel = new JPanel();
		JPanel guideLbl1titlePanel = new JPanel();
		JPanel guideLbl2titlePanel = new JPanel();
		JPanel lnbPanel = new JPanel();
		JPanel btnPanel = new JPanel();
		Font font = new Font("SansSerif", Font.BOLD, 30);

		JLabel guideLbl1a = new JLabel("E");
		JLabel guideLbl1b = new JLabel("1000�썝");
		guideLbl1a.setFont(font);
		guideLbl1b.setFont(font);

		guideLbl1titlePanel.setPreferredSize(new Dimension(20, 20));
		guideLbl2titlePanel.setPreferredSize(new Dimension(45, 20));
		guideLbl1titlePanel.add(guideLbl1a);
		guideLbl2titlePanel.add(guideLbl1b);
		guideLbl1titlePanel.setBackground(Color.white);
		guideLbl2titlePanel.setBackground(Color.PINK);

		titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
		titlePanel.add(guideLbl1titlePanel);
		titlePanel.add(guideLbl2titlePanel);

		oneTicketPanel.setLayout(new BoxLayout(oneTicketPanel, BoxLayout.Y_AXIS));

		btnPanel.setLayout(new FlowLayout());
		JButton autoBtn = new JButton("�옄�룞");
		JButton resetBtn = new JButton("珥덇린�솕");
		JButton returnBtn = new JButton("�솗�젙");
		autoBtn.setPreferredSize(new Dimension(250, 30));
		resetBtn.setPreferredSize(new Dimension(250, 30));
		returnBtn.setPreferredSize(new Dimension(90, 30));
		btnPanel.add(autoBtn);
		btnPanel.add(resetBtn);
		btnPanel.add(returnBtn);
		autoBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int clickCount = 0;
				for (int i = 0; i < 45; i++) {
					if (lottoNumBtn[i].getBackground().equals(Color.RED)) {
						clickCount++;
					}
				}

				List<Integer> numbers = new ArrayList<>();

				for (int i = 0; i < 45; i++) {
					if (!lottoNumBtn[i].getBackground().equals(Color.RED)) {
						numbers.add(i);
					}

				}
				Collections.shuffle(numbers);
				int autoCount = 0;
				int maxCount = 6;
				int yesNo = maxCount - clickCount;

				for (int i = 0; i < yesNo; i++) {
					lottoNumBtn[numbers.get(i)].setBackground(Color.RED);
					increaseCount();
					autoCount++;
				}
				if (yesNo == 6) {
					isAuto = true;

				}
				if (yesNo >= 1 && yesNo <= 5) {
					isAuto = false;

				}

				if (autoCount > 1 && autoCount < 7) {

					isClick = true;
				}

			}
		});

		resetBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (JButton button : lottoNumBtn) {
					button.setBackground(null);
				}
				setAuto(false);
				setClick(false);
				resetCount();
			}
		});

		returnBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!(changeCount == 6)) {
					JOptionPane.showMessageDialog(null, "踰덊샇瑜� 6媛쒓퉴吏� �젙�븯�뀛�빞�빀�땲�떎", "�엯�젰誘몃떖",
							JOptionPane.WARNING_MESSAGE);
				} else {
					int result = JOptionPane.showConfirmDialog(LottoTicket5.this, "踰덊샇瑜� �솗�젙�븯�떆寃좎뒿�땲源�?",
							"蹂듦텒踰덊샇 �솗�젙", JOptionPane.YES_NO_OPTION);

					if (result == JOptionPane.YES_OPTION) {
						LottoTicket5.this.dispose();
						getSelectedNumbers();
						getSelectedMode();
						System.out.println(selectedMode);
						System.out.println(selectedNumbers);
					}
				}

			}
		});
		buttonCreate();

		lnbPanel.setLayout(new GridLayout(9, 5));
		for (int i = 0; i < lottoNumBtn.length; i++) {
			lnbPanel.add(lottoNumBtn[i]);
		}

		add(oneTicketPanel);
		oneTicketPanel.add(titlePanel);
		oneTicketPanel.add(lnbPanel);
		oneTicketPanel.add(btnPanel);

		setSize(280, 550);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

class MyListener5 implements ActionListener {
	private LottoTicket5 lt1;

	public MyListener5(LottoTicket5 lt1) {
		this.lt1 = lt1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		if (lt1.getChangeCount() == 6)
			lt1.setAuto(false);

		if (!source.getBackground().equals(Color.RED) && lt1.getChangeCount() < 6) {
			source.setBackground(Color.RED);

			lt1.increaseCount();

		} else if (!source.getBackground().equals(Color.RED) && lt1.getChangeCount() == 6) {
			JOptionPane.showMessageDialog(null, "濡쒕삉�닽�옄�뒗 6媛쒓퉴吏� 怨좊�� �닔 �엳�뒿�땲�떎.", "�닽�옄珥덇낵",
					JOptionPane.WARNING_MESSAGE);
		} else if (source.getBackground().equals(Color.RED) && lt1.getChangeCount() == 1 && lt1.isClick() == true) {
			source.setBackground(null);
			lt1.decreaseCount();
			lt1.setAuto(false);
			lt1.setClick(false);

			lt1.resetCount();
		} else if (lt1.getChangeCount() <= 6) {
			source.setBackground(null);
			lt1.decreaseCount();
		} else if (lt1.getChangeCount() == 6) {
			source.setBackground(null);
			lt1.decreaseCount();

		}
	}
}