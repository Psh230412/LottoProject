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
<<<<<<< HEAD

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class LottoTicket2 extends JFrame {
	private boolean isClick = false;
	private boolean isAuto = false;
	List<Integer> selectedNumbers = new ArrayList<>();
	private JButton[] lottoNumBtn = new JButton[45];;
	private static int changeCount = 0;
	List<String> selectedMode = new ArrayList<>(); // "ÀÚµ¿" "¹İÀÚµ¿" "¼öµ¿"

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

	public void resetCount() { // Ä«¿îÆ®¸¦ ¸®¼ÂÇÏ´Â ¸Ş¼­µå¸¦ Ãß°¡ÇÕ´Ï´Ù
		this.changeCount = 0;
	}

	public void increaseCount() {
		this.changeCount++;
	}

	public void decreaseCount() {
		this.changeCount--;
	}

	public int getChangeCount() { // ÇöÀç Ä«¿îÆ®¸¦ °¡Á®¿À´Â ¸Ş¼­µå¸¦ Ãß°¡ÇÕ´Ï´Ù
		return this.changeCount;
	}

	public void buttonCreate() {
		for (int i = 0; i < lottoNumBtn.length; i++) {
			String lottoNumBtnName = String.valueOf(i + 1);
			lottoNumBtn[i] = new JButton(lottoNumBtnName);
			// lottoNumbtn[0]={1} lottoNumbtn[1]={2}.......lottoNumbtn[n]={n+1}
			lottoNumBtn[i].addActionListener(new MyListener2(this));
		}
	}

	public List<Integer> getSelectedNumbers() {
		for (int i = 0; i < lottoNumBtn.length; i++) {
			if (lottoNumBtn[i].getBackground().equals(Color.RED)) {
				selectedNumbers.add(i + 1); // lottoNumBtnÀÇ ÀÎµ¦½º´Â 0ºÎÅÍ ½ÃÀÛÇÏ¹Ç·Î 1À» ´õÇØ¾ß ¹øÈ£¸¦ ¾òÀ» ¼ö ÀÖ½À´Ï´Ù.
			}
		}
		return selectedNumbers;
	}

	public List<String> getSelectedMode() {
		if (isAuto == true && isClick == true) {
			selectedMode.add("ÀÚµ¿");
		} else if (isAuto == false && isClick == true) {
			selectedMode.add("¹İÀÚµ¿");
		} else {
			selectedMode.add("¼öµ¿");
		}
		return selectedMode;
	}

	public LottoTicket2() {

		JPanel oneTicketPanel = new JPanel();

		JPanel titlePanel = new JPanel();
		JPanel guideLbl1titlePanel = new JPanel();
		JPanel guideLbl2titlePanel = new JPanel();
		JPanel lnbPanel = new JPanel();
		JPanel btnPanel = new JPanel();
		Font font = new Font("SansSerif", Font.BOLD, 30);

		JLabel guideLbl1a = new JLabel("A");
		JLabel guideLbl1b = new JLabel("1000¿ø");
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
		JButton autoBtn = new JButton("ÀÚµ¿");
		JButton resetBtn = new JButton("ÃÊ±âÈ­");
		JButton returnBtn = new JButton("È®Á¤");
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
					lottoNumBtn[numbers.get(i)].doClick();
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
				
				
				System.out.println(getSelectedMode());
				System.out.println(getSelectedNumbers());
				
				/*
				 * if (isAuto == true && isClick == true) { System.out.println("ÀÚµ¿ÀÔ´Ï´Ù");
				 * System.out.println(isClick); System.out.println(isAuto); } else if (isAuto ==
				 * false && isClick == true) { System.out.println("¹İÀÚµ¿ÀÔ´Ï´Ù");
				 * System.out.println(isClick); System.out.println(isAuto); } else {
				 * System.out.println("¼öµ¿ÀÔ´Ï´Ù"); System.out.println(isClick);
				 * System.out.println(isAuto); }
				 */
				

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
		System.out.println("ÀÚµ¿(¹İÀÚµ¿) / ¼öµ¿ ±¸ºĞ :" + isClick);

	}
	
	/*
	 * public static void main(String[] args) { new LottoTicket2(); }
	 */
}

class MyListener2 implements ActionListener {
	private LottoTicket2 lt1;

	public MyListener2(LottoTicket2 lt1) {
		this.lt1 = lt1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		lt1.setAuto(false);

		if (!source.getBackground().equals(Color.RED) && lt1.getChangeCount() < 6) {
			source.setBackground(Color.RED);

			lt1.increaseCount();
			;

		} else if (!source.getBackground().equals(Color.RED) && lt1.getChangeCount() == 6) {
			JOptionPane.showMessageDialog(null, "·Î¶Ç¼ıÀÚ´Â 6°³±îÁö °í¸¦ ¼ö ÀÖ½À´Ï´Ù.", "¼ıÀÚÃÊ°ú", JOptionPane.WARNING_MESSAGE);
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



=======
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

class LottoTicket2 extends JFrame {
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

	public void resetCount() { // ì¹´ìš´íŠ¸ë¥¼ ë¦¬ì…‹í•˜ëŠ” ë©”ì„œë“œë¥¼ ì¶”ê°€í•©ë‹ˆë‹¤
		this.changeCount = 0;
	}

	public void increaseCount() {
		this.changeCount++;
	}

	public void decreaseCount() {
		this.changeCount--;
	}

	public int getChangeCount() { // í˜„ì¬ ì¹´ìš´íŠ¸ë¥¼ ê°€ì ¸ì˜¤ëŠ” ë©”ì„œë“œë¥¼ ì¶”ê°€í•©ë‹ˆë‹¤
		return this.changeCount;
	}

	public void buttonCreate() {
		for (int i = 0; i < lottoNumBtn.length; i++) {
			String lottoNumBtnName = String.valueOf(i + 1);
			lottoNumBtn[i] = new JButton(lottoNumBtnName);
			// lottoNumbtn[0]={1} lottoNumbtn[1]={2}.......lottoNumbtn[n]={n+1}
			lottoNumBtn[i].addActionListener(new MyListener2(this));
		}
	}

	public List<Integer> getSelectedNumbers() {
		for (int i = 0; i < lottoNumBtn.length; i++) {
			if (lottoNumBtn[i].getBackground().equals(Color.RED)) {
				selectedNumbers.add(i + 1); // lottoNumBtnì˜ ì¸ë±ìŠ¤ëŠ” 0ë¶€í„° ì‹œì‘í•˜ë¯€ë¡œ 1ì„ ë”í•´ì•¼ ë²ˆí˜¸ë¥¼ ì–»ì„ ìˆ˜ ìˆìŠµë‹ˆë‹¤.
			}
		}
		return selectedNumbers;
	}
	public List<String> getSelectedMode(){
		if (isAuto == true && isClick == true) {
			selectedMode.add("ìë™");
		} else if (isAuto == false && isClick == true) {
			selectedMode.add("ë°˜ìë™");
		} else {
			selectedMode.add("ìˆ˜ë™");
		}
		return selectedMode;
	}
	public LottoTicket2() {

		JPanel oneTicketPanel = new JPanel();

		JPanel titlePanel = new JPanel();
		JPanel guideLbl1titlePanel = new JPanel();
		JPanel guideLbl2titlePanel = new JPanel();
		JPanel lnbPanel = new JPanel();
		JPanel btnPanel = new JPanel();
		Font font = new Font("SansSerif", Font.BOLD, 30);

		JLabel guideLbl1a = new JLabel("A");
		JLabel guideLbl1b = new JLabel("1000ì›");
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
		JButton autoBtn = new JButton("ìë™");
		JButton resetBtn = new JButton("ì´ˆê¸°í™”");
		JButton returnBtn = new JButton("í™•ì •");
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
					lottoNumBtn[numbers.get(i)].doClick();
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
				getSelectedNumbers();
				getSelectedMode();
				
				System.out.println(selectedMode);
				System.out.println(selectedNumbers);
				
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

class MyListener2 implements ActionListener {
	private LottoTicket2 lt1;

	public MyListener2(LottoTicket2 lt1) {
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
			JOptionPane.showMessageDialog(null, "ë¡œë˜ìˆ«ìëŠ” 6ê°œê¹Œì§€ ê³ ë¥¼ ìˆ˜ ìˆìŠµë‹ˆë‹¤.", "ìˆ«ìì´ˆê³¼", JOptionPane.WARNING_MESSAGE);
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
>>>>>>> branch 'master' of https://github.com/Psh230412/LottoProject.git
