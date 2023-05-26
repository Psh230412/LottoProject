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



class LottoTicketManager {
	List<LottoTicket> lottoTicketList = new ArrayList<>();
	LottoTicket lotto;

	public void createEachLottoTicket(int a) {
		for (int i = 0; i < a; i++) {
			lottoTicketList.add(lotto);
		}
	}
}

class LottoTicket extends JFrame {

	private JLabel[] guideLbl1;
	private JLabel guideLbl2;
	private JButton[] lottoNumBtn = new JButton[45];;

	public void buttonCreate() {
		for (int i = 0; i < lottoNumBtn.length; i++) {
			String lottoNumBtnName = String.valueOf(i + 1);
			lottoNumBtn[i] = new JButton(lottoNumBtnName);
			// lottoNumbtn[0]={1} lottoNumbtn[1]={2}.......lottoNumbtn[n]={n+1}
			lottoNumBtn[i].addActionListener(new MyListener());
		}
	}

	public void guideLblCreate() {
		guideLbl1 = new JLabel[5];
		guideLbl1[0] = new JLabel("A");
		guideLbl1[1] = new JLabel("B");
		guideLbl1[2] = new JLabel("C");
		guideLbl1[3] = new JLabel("D");
		guideLbl1[4] = new JLabel("E");

	}

	public List<Integer> getSelectedNumbers() {
		List<Integer> selectedNumbers = new ArrayList<>();
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

		guideLblCreate();

		guideLbl2 = new JLabel("1000원");
		guideLbl1[0].setFont(font);
		guideLbl2.setFont(font);

		guideLbl1titlePanel.setPreferredSize(new Dimension(20, 20));
		guideLbl2titlePanel.setPreferredSize(new Dimension(45, 20));
		guideLbl1titlePanel.add(guideLbl1[0]);
		guideLbl2titlePanel.add(guideLbl2);
		guideLbl1titlePanel.setBackground(Color.white);
		guideLbl2titlePanel.setBackground(Color.PINK);

		titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
		titlePanel.add(guideLbl1titlePanel);
		titlePanel.add(guideLbl2titlePanel);

		oneTicketPanel.setLayout(new BoxLayout(oneTicketPanel, BoxLayout.Y_AXIS));

		btnPanel.setLayout(new FlowLayout());
		JButton autoBtn = new JButton("자동");
		JButton resetBtn = new JButton("초기화");
		autoBtn.setPreferredSize(new Dimension(250, 30));
		resetBtn.setPreferredSize(new Dimension(250, 30));
		btnPanel.add(autoBtn);
		btnPanel.add(resetBtn);

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
			
				for (int i = 0; i < 6 - clickCount; i++) {
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

		setSize(300, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		

	}
	/*
	 * public LinkedList getColorBtn() { myNum= new LinkedList<Integer>(); for (int
	 * i = 0; i < lottoNumBtn.length; i++) {
	 * if(lottoNumBtn[i].getBackground()==Color.RED) { myNum.add(i+1); } } return
	 * myNum; }
	 */

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