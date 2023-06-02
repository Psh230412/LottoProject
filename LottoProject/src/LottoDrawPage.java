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

import com.sun.org.apache.xerces.internal.dom.DeepNodeListImpl;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

// 등수 클래스
class CompareNum {
	public int compareNum(List<Integer> selectedNumList) {
////////////		List<Integer> randomNumList = LottoRandom.getRandomNum(); ///////////////////
		List<Integer> randomNumList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
		
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


public class LottoDrawPage extends JLabel {
	// unNumber 이미지를 담는 배열
	JLabel[] unNumArr = new JLabel[45];
	JLabel[] selNumArr = new JLabel[45];
	JLabel[] autoArr = new JLabel[3];
	JLabel[] gradeArr = new JLabel[6];
	JLabel[] screenArr = new JLabel[16];

	public JLabel[] createUnNumScreen() {
		for (int i = 0; i < unNumArr.length; i++) {
			URL unNumScreen = LottoDrawPage.class.getClassLoader()
					.getResource("image/unNumber" + " " + "(" + (i + 1) + ")" + ".gif");
			ImageIcon imageIcon = new ImageIcon(unNumScreen);
			unNumArr[i] = new JLabel(imageIcon);
		}
		return unNumArr;
	}

	public JLabel[] createSelNumScreen() {
		for (int i = 0; i < selNumArr.length; i++) {
			URL selNumScreen = LottoDrawPage.class.getClassLoader()
					.getResource("image/selNumber" + " " + "(" + (i + 1) + ")" + ".gif");
			ImageIcon imageIcon = new ImageIcon(selNumScreen);
			selNumArr[i] = new JLabel(imageIcon);
		}
		return selNumArr;
	}

	// 자동 반자동 수동
	public JLabel[] createAutoScreen() {
		for (int i = 0; i < autoArr.length; i++) {
			URL autoScreen = LottoDrawPage.class.getClassLoader().getResource("image4/auto" + (i + 1) + ".gif");
			ImageIcon imageIcon = new ImageIcon(autoScreen);
			autoArr[i] = new JLabel(imageIcon);
		}
		return autoArr;
	}

	// 1 ... 낙첨
	public JLabel[] createGradeScreen() {
		for (int i = 0; i < gradeArr.length; i++) {
			URL gradeScreen = LottoDrawPage.class.getClassLoader().getResource("image4/grade" + (i + 1) + ".gif");
			ImageIcon imageIcon = new ImageIcon(gradeScreen);
			gradeArr[i] = new JLabel(imageIcon);
		}
		return gradeArr;
	}

	public JLabel[] createScreen() {
		for (int i = 0; i < screenArr.length; i++) {
			URL screen = LottoDrawPage.class.getClassLoader().getResource("image4/결과확인" + (i + 1) + ".gif");
			ImageIcon imageIcon = new ImageIcon(screen);
			screenArr[i] = new JLabel(imageIcon);
		}
		return screenArr;
	}

	public LottoDrawPage() {
		// 기본 배경
		JLabel[] lbl = createScreen();
		lbl[0].setBounds(0, 0, 340, 189);
		lbl[1].setBounds(0, 189, 284, 27);
		lbl[4].setBounds(284, 189 + 15, 42, 12); // 보너스
		lbl[6].setBounds(15 + 252, 189 + 15 + 12, 17, 42); // 더하기
		lbl[12].setBounds(23 + 15 + 265, 189 + 27 + 42 + 27 + 210 + 20, 15, 18); // 다음 버튼

		for (int i = 0; i < lbl.length; i++) {
			add(lbl[i]);
		}

		// 당첨 번호
		LottoRandom lottoRandom = new LottoRandom();
//		List<Integer> randomNumList = lottoRandom.getRandomNum();//////////////////////////
		List<Integer> randomNumList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

		List<Integer> randomNumListClone = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			if (i != 6) {
				randomNumListClone.add(randomNumList.get(i));
			}
		}

		// System.out.println(randomNumListClone.toString());

		JLabel[] randomLbl = createSelNumScreen();

		for (int i = 0; i < randomNumList.size() - 1; i++) {
			int number = randomNumList.get(i);
			randomLbl[number - 1].setBounds(15 + (42 * i), 189 + 27, 42, 42);
			add(randomLbl[number - 1]);
		}
		randomLbl[randomNumList.get(6) - 1].setBounds(15 + 17 + (42 * 6), 189 + 27, 42, 42);
		add(randomLbl[randomNumList.get(6) - 1]);

		// 내 번호 보여주기
		// A
		// 자동
		List<String> autoList = new ArrayList<>(Arrays.asList("자동"));
//		List<String> autoList = LottoTicket1.selectedMode;
		
		JLabel[] autoLblA = createAutoScreen();

		for (int i = 0; i < autoLblA.length; i++) {
			autoLblA[i].setBounds(0, 189 + 27 + 42 + 27, 43, 42);
		}
		if (!autoList.isEmpty()) {
			String autoA = autoList.get(0);
			if (autoA.equals("자동")) {
				add(autoLblA[0]);
			} else if (autoA.equals("반자동")) {
				add(autoLblA[1]);
			} else {
				add(autoLblA[2]);
			}
		}

		// 번호

//		List<Integer> listA = LottoTicket1.selectedNumbers;
		List<Integer> listA = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

		JLabel[] YesLblA = createSelNumScreen();
		JLabel[] noLblA = createUnNumScreen();

		int count = 0;

		if (!listA.isEmpty()) {
			for (int i = 0; i < listA.size(); i++) {
				int number = listA.get(i);
				if (listA.contains(randomNumListClone.get(i))) {
					YesLblA[number - 1].setBounds(43 + (42 * i), 189 + 27 + 42 + 27, 42, 42);
					add(YesLblA[number - 1]);

					count++;

				} else {

					noLblA[number - 1].setBounds(43 + (42 * i), 189 + 27 + 42 + 27, 42, 42);
					add(noLblA[number - 1]);
				}

			}
			if (count == 5) {
				System.out.println(count);
				int bonus = randomNumList.get(6);
				if (listA.contains(bonus)) {
					int index = listA.indexOf(bonus);

					remove(noLblA[bonus - 1]);
					YesLblA[bonus - 1].setBounds(43 + (42 * (index)), 189 + 27 + 42 + 27, 42, 42);
					add(YesLblA[bonus - 1]);
				}
			}
		}

		// 등수
		CompareNum compareNum = new CompareNum();
		// int grade = compareNum.compareNum(LottoTicket1.selectedNumbers);
		int grade = compareNum.compareNum(listA);
		System.out.println(grade);
		
		JLabel[] gradeLabelA = createGradeScreen();

		for (int i = 0; i < gradeLabelA.length; i++) {
			gradeLabelA[i].setBounds(43+252, 189 + 27 + 42 + 27, 45, 42);
		}
		
		if (!listA.isEmpty()) {
			if (grade == 1) {
				add(gradeLabelA[0]);
			} else if (grade == 2) {
				add(gradeLabelA[1]);
			} else if (grade == 3) {
				add(gradeLabelA[2]);
			} else if (grade == 4) {
				add(gradeLabelA[3]);
			} else if (grade == 5) {
				add(gradeLabelA[4]);
			} else if (grade == 6) {
				add(gradeLabelA[5]);
			} 
		}
		
		// 메인으로 가는 버튼
		JLabel btn = lbl[12];
		btn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Management.card.show(Management.all, "시작");
			}
		});
		

		setPreferredSize(new Dimension(340, 550));
	}

	public static void main(String[] args) {
		new LottoDrawPage();
	}
}
