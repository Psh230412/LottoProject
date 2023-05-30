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

class LottoTicket extends JFrame {
	private boolean isClick = false;
	List<Integer> selectedNumbers = new ArrayList<>();
	private JButton[] lottoNumBtn = new JButton[45];;

	public void buttonCreate() {
		for (int i = 0; i < lottoNumBtn.length; i++) {
			String lottoNumBtnName = String.valueOf(i + 1);
			lottoNumBtn[i] = new JButton(lottoNumBtnName);
			// lottoNumbtn[0]={1} lottoNumbtn[1]={2}.......lottoNumbtn[n]={n+1}
			lottoNumBtn[i].addActionListener(new MyListener());
		}
	}

	public List<Integer> getSelectedNumbers() {
		for (int i = 0; i < lottoNumBtn.length; i++) {
			if (lottoNumBtn[i].getBackground().equals(Color.RED)) {
				selectedNumbers.add(i + 1); // lottoNumBtn의 인덱스는 0부터 시작하므로 1을 더해야 번호를 얻을 수 있습니다.
			}
		}
		return selectedNumbers;
	}

	public LottoTicket() {

		JPanel oneTicketPanel = new JPanel();

		JPanel titlePanel = new JPanel();
		JPanel guideLbl1titlePanel = new JPanel();
		JPanel guideLbl2titlePanel = new JPanel();
		JPanel lnbPanel = new JPanel();
		JPanel btnPanel = new JPanel();
		Font font = new Font("SansSerif", Font.BOLD, 30);

		JLabel guideLbl1a = new JLabel("A");
		JLabel guideLbl1b = new JLabel("1000원");
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
		JButton autoBtn = new JButton("자동");
		JButton resetBtn = new JButton("초기화");
		JButton returnBtn = new JButton("확정");
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
				int maxCount = 6;
				int yesNo = maxCount - clickCount;

				for (int i = 0; i < yesNo; i++) {
					lottoNumBtn[numbers.get(i)].doClick();

				}

			}
		});
		resetBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (JButton button : lottoNumBtn) {
					button.setBackground(null);
				}
				MyListener.reset();
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

class MyListener implements ActionListener {
	private static int changeCount = 0;

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();
		if (!source.getBackground().equals(Color.RED) && changeCount < 6) {
			source.setBackground(Color.RED);

			changeCount++;

		} else if (!source.getBackground().equals(Color.RED) && changeCount == 6) {
			JOptionPane.showMessageDialog(null, "로또숫자는 6개까지 고를 수 있습니다.", "숫자초과", JOptionPane.WARNING_MESSAGE);

		} else if (changeCount <= 6) {
			source.setBackground(null);
			changeCount--;
		}

	}

	public static void reset() {
		changeCount = 0;
	}

}

class LottoPage {
	public static void main(String[] args) {
		LottoTicket lottoTicket = new LottoTicket();
	}

}