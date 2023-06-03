import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// 등수 클래스
class CompareNum {
	public int compareNum(List<Integer> selectedNumList) {
		List<Integer> randomNumList = LottoRandom.getRandomNum();

		int count = 0;
		int grade = 0;

		if (!selectedNumList.isEmpty()) {
			for (int i : selectedNumList) {
				for (int j = 0; j < selectedNumList.size(); j++) {
					if (i == randomNumList.get(j)) {
						count++;
					}
				}
			}
		} else {
			grade = -1; // 선택 안함
		}

		switch (count) {
		case 0:
			grade = 6; // 낙첨
			break;
		case 3:
			grade = 5;
			break;
		case 4:
			grade = 4;
			break;
		case 5:
			int count2 = 0;
			for (int i = 0; i < selectedNumList.size(); i++) {
				if (selectedNumList.get(i) == randomNumList.get(6)) {
					count2++;
				}
			}
			if (count2 == 0) {
				grade = 3;
				break;
			} else {
				grade = 2;
				break;
			}
		case 6:
			grade = 1;
			break;
		default:
			grade = 6;
			break;
		}
		return grade;
	}
}

class MakeList {
	JLabel[] unNumArr = new JLabel[45];
	JLabel[] selNumArr = new JLabel[45];
	JLabel[] screenArr = new JLabel[16];
	JLabel[] autoArr = new JLabel[3];
	JLabel[] gradeArr = new JLabel[6];

	// 당첨안된 숫자
	public JLabel[] createUnNumScreen() {
		for (int i = 0; i < unNumArr.length; i++) {
			URL unNumScreen = MakeList.class.getClassLoader()
					.getResource("image/unNumber" + " " + "(" + (i + 1) + ")" + ".gif");
			ImageIcon imageIcon = new ImageIcon(unNumScreen);
			unNumArr[i] = new JLabel(imageIcon);
		}
		return unNumArr;
	}

	// 당첨된 숫자
	public JLabel[] createSelNumScreen() {
		for (int i = 0; i < selNumArr.length; i++) {
			URL selNumScreen = MakeList.class.getClassLoader()
					.getResource("image/selNumber" + " " + "(" + (i + 1) + ")" + ".gif");
			ImageIcon imageIcon = new ImageIcon(selNumScreen);
			selNumArr[i] = new JLabel(imageIcon);
		}
		return selNumArr;
	}

	// 배경 배열
	public JLabel[] createScreen() {
		for (int i = 0; i < screenArr.length; i++) {
			URL screen = MakeList.class.getClassLoader().getResource("image4/결과확인" + (i + 1) + ".gif");
			ImageIcon imageIcon = new ImageIcon(screen);
			screenArr[i] = new JLabel(imageIcon);
		}
		return screenArr;
	}

	// 자동 반자동 수동 배열
	public JLabel[] createAutoScreen() {
		for (int i = 0; i < autoArr.length; i++) {
			URL autoScreen = MakeList.class.getClassLoader().getResource("image4/auto" + (i + 1) + ".gif");
			ImageIcon imageIcon = new ImageIcon(autoScreen);
			autoArr[i] = new JLabel(imageIcon);
		}
		return autoArr;
	}

	// 1 ... 낙첨 등수배열
	public JLabel[] createGradeScreen() {
		for (int i = 0; i < gradeArr.length; i++) {
			URL gradeScreen = MakeList.class.getClassLoader().getResource("image4/grade" + (i + 1) + ".gif");
			ImageIcon imageIcon = new ImageIcon(gradeScreen);
			gradeArr[i] = new JLabel(imageIcon);
		}
		return gradeArr;
	}
}

class MyNumLbl extends JLabel {
	JLabel[] selNumArr = new JLabel[45];
	JLabel[] unNumArr = new JLabel[45];
	JLabel[] autoArr = new JLabel[3];
	JLabel[] gradeArr = new JLabel[6];
	JLabel[] screenArr = new JLabel[16];

	public void makeMyNumLbl(List<String> selectedMode, List<Integer> selectedNumbers) {
		// 자동
		MakeList makeList = new MakeList();
		JLabel[] autoLbl = makeList.createAutoScreen();

		for (int i = 0; i < autoLbl.length; i++) {
			autoLbl[i].setBounds(0, 0, 43, 42);
		}
		if (!selectedMode.isEmpty()) {
			String auto = selectedMode.get(0);
			if (auto.equals("자동")) {
				add(autoLbl[0]);
			} else if (auto.equals("반자동")) {
				add(autoLbl[1]);
			} else {
				add(autoLbl[2]);
			}
		}

		// 번호
		List<Integer> randomNumList = LottoRandom.getRandomNum();
		
		List<Integer> randomNumListClone = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			randomNumListClone.add(randomNumList.get(i));
		}

		JLabel[] selNumArr = makeList.createSelNumScreen();
		JLabel[] unNumArr = makeList.createUnNumScreen();

		int count = 0;

		if (!selectedNumbers.isEmpty()) {
			for (int i = 0; i < selectedNumbers.size(); i++) {
				int number = selectedNumbers.get(i);
				if (randomNumListClone.contains(number)) {
					selNumArr[number - 1].setBounds(43 + (42 * i), 0, 42, 42);
					add(selNumArr[number - 1]);

					count++;

				} else {
					unNumArr[number - 1].setBounds(43 + (42 * i), 0, 42, 42);
					add(unNumArr[number - 1]);
				}
			}
			if (count == 5) {
				int bonus = randomNumList.get(6);
				if (selectedNumbers.contains(bonus)) {
					int index = selectedNumbers.indexOf(bonus);

					remove(unNumArr[bonus - 1]);
					selNumArr[bonus - 1].setBounds(43 + (42 * (index)), 0, 42, 42);
					add(selNumArr[bonus - 1]);
				}
			}
		}

		// 등수
		CompareNum compareNum = new CompareNum();

		int grade = compareNum.compareNum(selectedNumbers);

		JLabel[] gradeLabel = makeList.createGradeScreen();

		for (int i = 0; i < gradeLabel.length; i++) {
			gradeLabel[i].setBounds(43 + 252, 0, 45, 42);
		}

		if (!selectedNumbers.isEmpty()) {
			if (grade == 1) {
				add(gradeLabel[0]);
			} else if (grade == 2) {
				add(gradeLabel[1]);
			} else if (grade == 3) {
				add(gradeLabel[2]);
			} else if (grade == 4) {
				add(gradeLabel[3]);
			} else if (grade == 5) {
				add(gradeLabel[4]);
			} else if (grade == 6) {
				add(gradeLabel[5]);
			}
		}
		setSize(340, 42);
	}
}

public class LottoDrawPage extends JLabel {
	public LottoDrawPage() {
		
		MakeList makeList = new MakeList();
		// 기본 배경
		JLabel[] lbl = makeList.createScreen();
		lbl[0].setBounds(0, 0, 340, 189);
		lbl[1].setBounds(0, 189, 284, 27);
		lbl[4].setBounds(284, 189 + 15, 42, 12); // 보너스
		lbl[6].setBounds(15 + 252, 189 + 15 + 12, 17, 42); // 더하기
		lbl[12].setBounds(23 + 15 + 265, 189 + 27 + 42 + 27 + 210 + 20, 15, 18); // 다음 버튼

		for (int i = 0; i < lbl.length; i++) {
			add(lbl[i]);
		}

		// 당첨 번호
		
		new LottoRandom();
		List<Integer> randomNumList = LottoRandom.getRandomNum();

		JLabel[] randomLbl = makeList.createSelNumScreen();

		for (int i = 0; i < randomNumList.size() - 1; i++) {
			int number = randomNumList.get(i);
			randomLbl[number - 1].setBounds(15 + (42 * i), 189 + 27, 42, 42);
			add(randomLbl[number - 1]);
		}
		randomLbl[randomNumList.get(6) - 1].setBounds(15 + 17 + (42 * 6), 189 + 27, 42, 42);
		add(randomLbl[randomNumList.get(6) - 1]);

		// 메인으로 가는 버튼
		JLabel btn = lbl[12];
		btn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Management.card.show(Management.all, "시작");
			}
		});
		
		// 내 번호 라벨
		MyNumLbl a = new MyNumLbl();
		a.makeMyNumLbl(LottoTicket1.selectedMode, LottoTicket1.selectedNumbers);
		a.setBounds(0, 285, 340, 42);
		
		MyNumLbl b = new MyNumLbl();
		b.makeMyNumLbl(LottoTicket2.selectedMode, LottoTicket2.selectedNumbers);
		if (LottoTicket1.selectedNumbers.isEmpty()) {
			b.setBounds(0, 285, 340, 42);
		} else {
			b.setBounds(0, 285+42, 340, 42);
		}
		
		MyNumLbl c = new MyNumLbl();
		c.makeMyNumLbl(LottoTicket3.selectedMode, LottoTicket3.selectedNumbers);
		int count = 0;
		if (LottoTicket1.selectedNumbers.isEmpty()) 
			count++;
		if (LottoTicket2.selectedNumbers.isEmpty()) 
			count++;
		c.setBounds(0, 369-(count*42), 340, 42);
		
		MyNumLbl d = new MyNumLbl();
		d.makeMyNumLbl(LottoTicket4.selectedMode, LottoTicket4.selectedNumbers);
		count = 0;
		if (LottoTicket1.selectedNumbers.isEmpty()) 
			count++;
		if (LottoTicket2.selectedNumbers.isEmpty()) 
			count++;
		if (LottoTicket3.selectedNumbers.isEmpty()) 
			count++;
		d.setBounds(0, 411-(count*42), 340, 42);
		
		MyNumLbl e = new MyNumLbl();
		e.makeMyNumLbl(LottoTicket5.selectedMode, LottoTicket5.selectedNumbers);
		count = 0;
		if (LottoTicket1.selectedNumbers.isEmpty()) 
			count++;
		if (LottoTicket2.selectedNumbers.isEmpty()) 
			count++;
		if (LottoTicket3.selectedNumbers.isEmpty()) 
			count++;
		if (LottoTicket4.selectedNumbers.isEmpty())
			count++;
		e.setBounds(0, 453-(count*42), 340, 42);
		
		add(a);
		add(b);
		add(c);
		add(d);
		add(e);

		
		setPreferredSize(new Dimension(340, 550));
		setOpaque(true);
		setBackground(new Color(10, 4, 52));
	}
}
