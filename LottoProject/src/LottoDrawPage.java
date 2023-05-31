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

// 등수 클래스
class CompareNum {
	public String compareNum (List<Integer> selectedNumList) {
		List<Integer> randomNumList = LottoRandom.getRandomNum();
		int count = 0;
		String grade = "";
		
		for (int i : selectedNumList) {
			for (int j = 0; j < selectedNumList.size(); j++) {
				if (i == randomNumList.get(j)) {
					count++;
				}
			}
		}
		
		switch (count) {
		case 3:
			grade = "5등";
			break;
		case 4:
			grade = "4등";
			break;
		case 5:
			int count2 = 0;
			for (int i = 0; i < selectedNumList.size(); i++) {
				if (selectedNumList.get(i) == randomNumList.get(6)) {
					count2++;
				}
			}
			if (count2 == 0) {
				grade = "3등";
				break;
			} else {
				grade = "2등";
				break;
			}
		case 6:
			grade = "1등";
			break;
		default:
			grade = "낙첨";
			break;
		}
		return grade;
	}
}

class RandomNumView extends JPanel {
	public RandomNumView() {
		
		LottoRandom lottoRandom = new LottoRandom();
		List<Integer> randomNumList = lottoRandom.getRandomNum();

		JLabel randomLbl1 = new JLabel(randomNumList.get(0).toString());
		JLabel randomLbl2 = new JLabel(randomNumList.get(1).toString());
		JLabel randomLbl3 = new JLabel(randomNumList.get(2).toString());
		JLabel randomLbl4 = new JLabel(randomNumList.get(3).toString());
		JLabel randomLbl5 = new JLabel(randomNumList.get(4).toString());
		JLabel randomLbl6 = new JLabel(randomNumList.get(5).toString());
		JLabel randomLbl7 = new JLabel(randomNumList.get(6).toString());
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

// A
class MyNumViewA extends JPanel {
	public MyNumViewA() {
		/*List<Integer> list = LottoTicket1.selectedNumbers;
		JLabel autoLblA = new JLabel(LottoTicket1.selectedMode.get(0).toString());*/
		
		//MyNumPnlA.getMyNumLbl1A().getT
		int num1 = Integer.valueOf(MyNumPnlA.getMyNumLbl1A().getText());
		int num2 = Integer.valueOf(MyNumPnlA.getMyNumLbl2A().getText());
		int num3 = Integer.valueOf(MyNumPnlA.getMyNumLbl3A().getText());
		int num4 = Integer.valueOf(MyNumPnlA.getMyNumLbl4A().getText());
		int num5 = Integer.valueOf(MyNumPnlA.getMyNumLbl5A().getText());
		int num6 = Integer.valueOf(MyNumPnlA.getMyNumLbl6A().getText());
		String selectedMode = MyNumPnlA.getAutoLblA().getText();
		
		List<Integer> selectedNumList = new ArrayList<>(Arrays.asList(num1, num2, num3, num4, num5, num6));
		
		JLabel autoLblA = new JLabel(selectedMode);
		JLabel orderLblA = new JLabel("A");
		JLabel myNumLbl1A = new JLabel(selectedNumList.get(0).toString());
		JLabel myNumLbl2A = new JLabel(selectedNumList.get(1).toString());
		JLabel myNumLbl3A = new JLabel(selectedNumList.get(2).toString());
		JLabel myNumLbl4A = new JLabel(selectedNumList.get(3).toString());
		JLabel myNumLbl5A = new JLabel(selectedNumList.get(4).toString());
		JLabel myNumLbl6A = new JLabel(selectedNumList.get(5).toString());
		JLabel gradeLblA = new JLabel();

		String grade = new CompareNum().compareNum(selectedNumList);
		gradeLblA.setText(grade);


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

// B
class MyNumViewB extends JPanel {
	public MyNumViewB() {
		int num1 = Integer.valueOf(MyNumPnlB.getMyNumLbl1B().getText());
		int num2 = Integer.valueOf(MyNumPnlB.getMyNumLbl2B().getText());
		int num3 = Integer.valueOf(MyNumPnlB.getMyNumLbl3B().getText());
		int num4 = Integer.valueOf(MyNumPnlB.getMyNumLbl4B().getText());
		int num5 = Integer.valueOf(MyNumPnlB.getMyNumLbl5B().getText());
		int num6 = Integer.valueOf(MyNumPnlB.getMyNumLbl6B().getText());
		String selectedMode = MyNumPnlB.getAutoLblB().getText();
		
		List<Integer> selectedNumList = new ArrayList<>(Arrays.asList(num1, num2, num3, num4, num5, num6));
		
		JLabel autoLblB = new JLabel(selectedMode);
		JLabel orderLblB = new JLabel("B");
		JLabel myNumLbl1B = new JLabel(selectedNumList.get(0).toString());
		JLabel myNumLbl2B = new JLabel(selectedNumList.get(1).toString());
		JLabel myNumLbl3B = new JLabel(selectedNumList.get(2).toString());
		JLabel myNumLbl4B = new JLabel(selectedNumList.get(3).toString());
		JLabel myNumLbl5B = new JLabel(selectedNumList.get(4).toString());
		JLabel myNumLbl6B = new JLabel(selectedNumList.get(5).toString());
		JLabel gradeLblB = new JLabel();

		String grade = new CompareNum().compareNum(selectedNumList);
		gradeLblB.setText(grade);

		add(autoLblB);
		add(orderLblB);
		add(myNumLbl1B);
		add(myNumLbl2B);
		add(myNumLbl3B);
		add(myNumLbl4B);
		add(myNumLbl5B);
		add(myNumLbl6B);
		add(gradeLblB);
	}
}

// C
class MyNumViewC extends JPanel {
	public MyNumViewC() {
		int num1 = Integer.valueOf(MyNumPnlC.getMyNumLbl1C().getText());
		int num2 = Integer.valueOf(MyNumPnlC.getMyNumLbl2C().getText());
		int num3 = Integer.valueOf(MyNumPnlC.getMyNumLbl3C().getText());
		int num4 = Integer.valueOf(MyNumPnlC.getMyNumLbl4C().getText());
		int num5 = Integer.valueOf(MyNumPnlC.getMyNumLbl5C().getText());
		int num6 = Integer.valueOf(MyNumPnlC.getMyNumLbl6C().getText());
		String selectedMode = MyNumPnlC.getAutoLblC().getText();
		
		List<Integer> selectedNumList = new ArrayList<>(Arrays.asList(num1, num2, num3, num4, num5, num6));
		
		JLabel autoLblC = new JLabel(selectedMode);
		JLabel orderLblC = new JLabel("C");
		JLabel myNumLbl1C = new JLabel(selectedNumList.get(0).toString());
		JLabel myNumLbl2C = new JLabel(selectedNumList.get(1).toString());
		JLabel myNumLbl3C = new JLabel(selectedNumList.get(2).toString());
		JLabel myNumLbl4C = new JLabel(selectedNumList.get(3).toString());
		JLabel myNumLbl5C = new JLabel(selectedNumList.get(4).toString());
		JLabel myNumLbl6C = new JLabel(selectedNumList.get(5).toString());
		JLabel gradeLblC = new JLabel();

		String grade = new CompareNum().compareNum(selectedNumList);
		gradeLblC.setText(grade);

		add(autoLblC);
		add(orderLblC);
		add(myNumLbl1C);
		add(myNumLbl2C);
		add(myNumLbl3C);
		add(myNumLbl4C);
		add(myNumLbl5C);
		add(myNumLbl6C);
		add(gradeLblC);
	}
}

// D
class MyNumViewD extends JPanel {
	public MyNumViewD() {
		int num1 = Integer.valueOf(MyNumPnlD.getMyNumLbl1D().getText());
		int num2 = Integer.valueOf(MyNumPnlD.getMyNumLbl2D().getText());
		int num3 = Integer.valueOf(MyNumPnlD.getMyNumLbl3D().getText());
		int num4 = Integer.valueOf(MyNumPnlD.getMyNumLbl4D().getText());
		int num5 = Integer.valueOf(MyNumPnlD.getMyNumLbl5D().getText());
		int num6 = Integer.valueOf(MyNumPnlD.getMyNumLbl6D().getText());
		String selectedMode = MyNumPnlD.getAutoLblD().getText();
		
		List<Integer> selectedNumList = new ArrayList<>(Arrays.asList(num1, num2, num3, num4, num5, num6));
		
		JLabel autoLblD = new JLabel(selectedMode);
		JLabel orderLblD = new JLabel("D");
		JLabel myNumLbl1D = new JLabel(selectedNumList.get(0).toString());
		JLabel myNumLbl2D = new JLabel(selectedNumList.get(1).toString());
		JLabel myNumLbl3D = new JLabel(selectedNumList.get(2).toString());
		JLabel myNumLbl4D = new JLabel(selectedNumList.get(3).toString());
		JLabel myNumLbl5D = new JLabel(selectedNumList.get(4).toString());
		JLabel myNumLbl6D = new JLabel(selectedNumList.get(5).toString());
		JLabel gradeLblD = new JLabel();

		String grade = new CompareNum().compareNum(selectedNumList);
		gradeLblD.setText(grade);

		add(autoLblD);
		add(orderLblD);
		add(myNumLbl1D);
		add(myNumLbl2D);
		add(myNumLbl3D);
		add(myNumLbl4D);
		add(myNumLbl5D);
		add(myNumLbl6D);
		add(gradeLblD);
	}
}

// E
class MyNumViewE extends JPanel {
	public MyNumViewE() {
		int num1 = Integer.valueOf(MyNumPnlE.getMyNumLbl1E().getText());
		int num2 = Integer.valueOf(MyNumPnlE.getMyNumLbl2E().getText());
		int num3 = Integer.valueOf(MyNumPnlE.getMyNumLbl3E().getText());
		int num4 = Integer.valueOf(MyNumPnlE.getMyNumLbl4E().getText());
		int num5 = Integer.valueOf(MyNumPnlE.getMyNumLbl5E().getText());
		int num6 = Integer.valueOf(MyNumPnlE.getMyNumLbl6E().getText());
		String selectedMode = MyNumPnlE.getAutoLblE().getText();
		
		List<Integer> selectedNumList = new ArrayList<>(Arrays.asList(num1, num2, num3, num4, num5, num6));
		
		JLabel autoLblE = new JLabel(selectedMode);
		JLabel orderLblE = new JLabel("E");
		JLabel myNumLbl1E = new JLabel(selectedNumList.get(0).toString());
		JLabel myNumLbl2E = new JLabel(selectedNumList.get(1).toString());
		JLabel myNumLbl3E = new JLabel(selectedNumList.get(2).toString());
		JLabel myNumLbl4E = new JLabel(selectedNumList.get(3).toString());
		JLabel myNumLbl5E = new JLabel(selectedNumList.get(4).toString());
		JLabel myNumLbl6E = new JLabel(selectedNumList.get(5).toString());
		JLabel gradeLblE = new JLabel();

		String grade = new CompareNum().compareNum(selectedNumList);
		gradeLblE.setText(grade);

		add(autoLblE);
		add(orderLblE);
		add(myNumLbl1E);
		add(myNumLbl2E);
		add(myNumLbl3E);
		add(myNumLbl4E);
		add(myNumLbl5E);
		add(myNumLbl6E);
		add(gradeLblE);
	}
}

public class LottoDrawPage extends JFrame {
	public LottoDrawPage() {
		BoxLayout layout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
		setLayout(layout);

		add(new RandomNumView());
		add(new MyNumViewA());
		add(new MyNumViewB());
		add(new MyNumViewC());
		add(new MyNumViewD());
		add(new MyNumViewE());


		setSize(500, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LottoDrawPage();
	}
}
