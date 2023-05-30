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

//�떦泥⑤쾲�샇 戮묎린
class LottoDraw {
	private List<Integer> drawNum = new ArrayList<>();
	
	public List<Integer> getDrawNum() {
		return drawNum;
	}

	public LottoDraw() {
		Random random = new Random();
		while (drawNum.size() < 7) {
			int number = random.nextInt(45) + 1;
			if (!drawNum.contains(number))
			drawNum.add(number);
		}
	}
}


//�떦泥⑤쾲�샇�� �궡 踰덊샇 鍮꾧탳
class LottoDrawView extends JPanel {
	private Dimension dimension = new Dimension(100, 100);
	private Font font = new Font("留묒� 怨좊뵓", Font.PLAIN, 50);

	public LottoDrawView() {
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(layout);
		
		// �궡 踰덊샇 蹂댁뿬二쇰뒗 �뙣�꼸留뚮뱶�뒗 �겢�옒�뒪
		class MyNumPnl extends JPanel {
			private JLabel autoLbl;
			private JLabel orderLbl;
			private JLabel myNumLbl1;
			private JLabel myNumLbl2;
			private JLabel myNumLbl3;
			private JLabel myNumLbl4;
			private JLabel myNumLbl5;
			private JLabel myNumLbl6;
			private JLabel gradeLbl;
			public List<JLabel> myNumLblList = new LinkedList<JLabel>();

			public MyNumPnl() {
				autoLbl = new JLabel("�옄�룞");
				orderLbl = new JLabel("A");
				myNumLbl1 = new JLabel("1");
				myNumLbl2 = new JLabel("2");
				myNumLbl3 = new JLabel("3");
				myNumLbl4 = new JLabel("4");
				myNumLbl5 = new JLabel("5");
				myNumLbl6 = new JLabel("6");
				gradeLbl = new JLabel("�벑�닔");

				myNumLblList.add(autoLbl);
				myNumLblList.add(orderLbl);
				myNumLblList.add(myNumLbl1);
				myNumLblList.add(myNumLbl2);
				myNumLblList.add(myNumLbl3);
				myNumLblList.add(myNumLbl4);
				myNumLblList.add(myNumLbl5);
				myNumLblList.add(myNumLbl6);
				myNumLblList.add(gradeLbl);

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

		// �떦泥⑤쾲�샇 �뙣�꼸
		LottoDraw lottoDraw = new LottoDraw();
		List<Integer> list = lottoDraw.getDrawNum();
		
		List<JLabel> drawNumLblList = new LinkedList<JLabel>();
		
		JPanel drawNumPnl = new JPanel();
		

		JLabel drawNumLbl1 = new JLabel();
		JLabel drawNumLbl2 = new JLabel();
		JLabel drawNumLbl3 = new JLabel();
		JLabel drawNumLbl4 = new JLabel();
		JLabel drawNumLbl5 = new JLabel();
		JLabel drawNumLbl6 = new JLabel();
		JLabel drawNumLbl7 = new JLabel();
		JLabel plus = new JLabel("+");
		
		drawNumLblList.add(drawNumLbl1);
		drawNumLblList.add(drawNumLbl2);
		drawNumLblList.add(drawNumLbl3);
		drawNumLblList.add(drawNumLbl4);
		drawNumLblList.add(drawNumLbl5);
		drawNumLblList.add(drawNumLbl6);
		drawNumLblList.add(drawNumLbl7);
		
		for (int i = 0; i < drawNumLblList.size(); i++) {
			JLabel lbl = drawNumLblList.get(i);
			lbl.setText(list.get(i).toString());
			lbl.setPreferredSize(dimension);
			lbl.setFont(font);
			drawNumPnl.add(lbl);
		}
		
		plus.setPreferredSize(dimension);
		plus.setFont(font);

		drawNumPnl.add(drawNumLbl1);
		drawNumPnl.add(drawNumLbl2);
		drawNumPnl.add(drawNumLbl3);
		drawNumPnl.add(drawNumLbl4);
		drawNumPnl.add(drawNumLbl5);
		drawNumPnl.add(drawNumLbl6);
		drawNumPnl.add(plus);
		drawNumPnl.add(drawNumLbl7);
		add(drawNumPnl);

		// �궡 踰덊샇 �뙣�꼸
		MyNumPnl a = new MyNumPnl();
		MyNumPnl b = new MyNumPnl();
		MyNumPnl c = new MyNumPnl();
		MyNumPnl d = new MyNumPnl();
		MyNumPnl e = new MyNumPnl();

		LottoTicket1 lottoTicket = new LottoTicket1();
		List<Integer> selectedNumbers = lottoTicket.getSelectedNumbers();
		for (int i = 0; i < selectedNumbers.size(); i++) {
			String s = selectedNumbers.get(i).toString();
			JLabel lbl = a.myNumLblList.get(i + 2);
			lbl.setText(s);	
		}

		add(a);
		add(b);
		add(c);
		add(d);
		add(e);
	}

	public void compareNum() {

	}
}

public class LottoDrawPage extends JFrame {
	public LottoDrawPage() {
		add(new LottoDrawView());

		setSize(1000, 1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LottoDrawPage();
	}
}
