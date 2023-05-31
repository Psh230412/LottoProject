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

class MyNumView extends JPanel {
	public MyNumView() {
		
	}
}

public class LottoDrawPage extends JFrame {
	public LottoDrawPage() {
		BoxLayout layout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
		setLayout(layout);
		
		add(new RandomNumView());

		setSize(1000, 1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LottoDrawPage();
	}
}
