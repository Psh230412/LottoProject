import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class CompareNum {
	
}

//내 번호 보여주는 패널만드는 클래스
class MyNumPnl2 extends JPanel {
	private Dimension dimension = new Dimension(50, 50);
	private Font font = new Font("맑은 고딕", Font.PLAIN, 20);

	private List<JLabel> myNumLblList;

	public List<JLabel> getMyNumLblList() {
		return myNumLblList;
	}

	public MyNumPnl2() {
		myNumLblList = new LinkedList<JLabel>();
		JLabel autoLbl = new JLabel("자동");
		JLabel orderLbl = new JLabel("A");
		JLabel myNumLbl1 = new JLabel("1");
		JLabel myNumLbl2 = new JLabel("2");
		JLabel myNumLbl3 = new JLabel("3");
		JLabel myNumLbl4 = new JLabel("4");
		JLabel myNumLbl5 = new JLabel("5");
		JLabel myNumLbl6 = new JLabel("6");
		JLabel gradeLbl = new JLabel("등수");

		myNumLblList.add(autoLbl);
		myNumLblList.add(orderLbl);
		myNumLblList.add(myNumLbl1);
		myNumLblList.add(myNumLbl2);
		myNumLblList.add(myNumLbl3);
		myNumLblList.add(myNumLbl4);
		myNumLblList.add(myNumLbl5);
		myNumLblList.add(myNumLbl6);
		myNumLblList.add(gradeLbl);

		for (int i = 0; i < myNumLblList.size(); i++) {
			JLabel lbl = myNumLblList.get(i);
			lbl.setPreferredSize(dimension);
			lbl.setFont(font);
		}

		add(autoLbl);
		add(orderLbl);
		add(myNumLbl1);
		add(myNumLbl2);
		add(myNumLbl3);
		add(myNumLbl4);
		add(myNumLbl5);
		add(myNumLbl6);
		add(gradeLbl);
	}
}

// 당첨번호 + 내 번호
public class LottoDrawPage extends JFrame {
	public LottoDrawPage() {
		BoxLayout layout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
		setLayout(layout);
		
		LottoRandomPnl pnl = new LottoRandomPnl();
		add(pnl);
		
		MyNumPnl2 a = new MyNumPnl2();
		MyNumPnl2 b = new MyNumPnl2();
		MyNumPnl2 c = new MyNumPnl2();
		MyNumPnl2 d = new MyNumPnl2();
		MyNumPnl2 e = new MyNumPnl2();

		LottoTicket1 lottoTicket1 = new LottoTicket1();
		List<Integer> selectedNumbers = lottoTicket1.getSelectedNumbers();
		for (int i = 0; i < selectedNumbers.size(); i++) {
			String s = selectedNumbers.get(i).toString();
			JLabel lbl = a.getMyNumLblList().get(i);
			lbl.setText(s);
		}

		add(a);
		add(b);
		add(c);
		add(d);
		add(e);
		

		setSize(1000, 1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LottoDrawPage();
	}
}
