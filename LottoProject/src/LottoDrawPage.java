import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class RandomNumView extends JPanel {
	public RandomNumView() {
		LottoRandom lottoRandom = new LottoRandom();
		List<Integer> list = lottoRandom.getRandomNum();
		
		JLabel randomLbl1 = new JLabel(list.get(0).toString());
		JLabel randomLbl2 = new JLabel(list.get(1).toString());
		JLabel randomLbl3 = new JLabel(list.get(2).toString());
		JLabel randomLbl4 = new JLabel(list.get(3).toString());
		JLabel randomLbl5 = new JLabel(list.get(4).toString());
		JLabel randomLbl6 = new JLabel(list.get(5).toString());
		JLabel randomLbl7 = new JLabel(list.get(6).toString());
		JLabel plus = new JLabel("+");

		add(randomLbl1);
		add(randomLbl1);
		add(randomLbl2);
		add(randomLbl3);
		add(randomLbl4);
		add(randomLbl5);
		add(randomLbl6);
		add(plus);
		add(randomLbl7);
	}
}

class MyNumViewA extends JPanel {
	public MyNumViewA() {
		/*List<Integer> list = LottoTicket1.selectedNumbers;
		JLabel autoLblA = new JLabel(LottoTicket1.selectedMode.get(0).toString());*/
		
		//MyNumPnlA.getMyNumLbl1A().getT
		JLabel orderLblA = new JLabel("A");
		JLabel myNumLbl1A = new JLabel(MyNumPnlA.getMyNumLbl1A().getText());
		JLabel myNumLbl2A = new JLabel(list.get(1).toString());
		JLabel myNumLbl3A = new JLabel(list.get(2).toString());
		JLabel myNumLbl4A = new JLabel(list.get(3).toString());
		JLabel myNumLbl5A = new JLabel(list.get(4).toString());
		JLabel myNumLbl6A = new JLabel(list.get(5).toString());
		JLabel gradeLblA = new JLabel("등수");



		add(autoLblA);
		add(orderLblA);
		add(myNumLbl1A);
		add(myNumLbl2A);
		add(myNumLbl3A);
		add(myNumLbl4A);
		add(myNumLbl5A);
		add(myNumLbl6A);
		add(gradeLblA);
	}
}

public class LottoDrawPage extends JFrame {
	public LottoDrawPage() {
		BoxLayout layout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
		setLayout(layout);
		
		add(new RandomNumView());
		add(new MyNumViewA());

		setSize(500, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LottoDrawPage();
	}
}
