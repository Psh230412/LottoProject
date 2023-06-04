import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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


public class LottoDrawPage extends JPanel {

	JLabel[] numArrA = makeNumLbl();
	JLabel[] numArrB = makeNumLbl();
	JLabel[] numArrC = makeNumLbl();
	JLabel[] numArrD = makeNumLbl();
	JLabel[] numArrE = makeNumLbl();
	JLabel[] drawNumArr = makeDrawNumLbl();
	JLabel[] screenArr = new JLabel[16];
	
	
	// index 6 : 자동, 7 : 등수
	public JLabel[] makeNumLbl() {
		JLabel[] numArr = new JLabel[8];
		for (int i = 0; i < numArr.length; i++) {
			numArr[i] = new JLabel();
		}
		return numArr;
	}
	
	public JLabel[] makeDrawNumLbl() {
		JLabel[] drawNumArr = new JLabel[7];
		for (int i = 0; i < drawNumArr.length; i++) {
			drawNumArr[i] = new JLabel();
		}
		return drawNumArr;
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
		// 선택번호 라벨 배열
		for (int i = 0; i < numArrA.length; i++) {
			add(numArrA[i]);
		}
		numArrA[0].setBounds(0, 285, 43, 42);
		numArrA[1].setBounds(43, 285, 42, 42);
		numArrA[2].setBounds(43+42, 285, 42, 42);
		numArrA[3].setBounds(43+42+42 , 285, 42, 42);
		numArrA[4].setBounds(43+42+42+42, 285, 42, 42);
		numArrA[5].setBounds(43+42+42+42+42, 285, 42, 42);
		numArrA[6].setBounds(43+42+42+42+42+42, 285, 42, 42);
		numArrA[7].setBounds(43+42+42+42+42+42+42, 285, 45, 42);
		for (int i = 0; i < numArrB.length; i++) {
			add(numArrB[i]);
		}
		numArrB[0].setBounds(0, 285+42, 43, 42);
		numArrB[1].setBounds(43, 285+42, 42, 42);
		numArrB[2].setBounds(43+42, 285+42, 42, 42);
		numArrB[3].setBounds(43+42+42 , 285+42, 42, 42);
		numArrB[4].setBounds(43+42+42+42, 285+42, 42, 42);
		numArrB[5].setBounds(43+42+42+42+42, 285+42, 42, 42);
		numArrB[6].setBounds(43+42+42+42+42+42, 285+42, 42, 42);
		numArrB[7].setBounds(43+42+42+42+42+42+42, 285+42, 45, 42);
		for (int i = 0; i < numArrC.length; i++) {
			add(numArrC[i]);
		}
		numArrC[0].setBounds(0, 285+42+42, 43, 42);
		numArrC[1].setBounds(43, 285+42+42, 42, 42);
		numArrC[2].setBounds(43+42, 285+42+42, 42, 42);
		numArrC[3].setBounds(43+42+42 , 285+42+42, 42, 42);
		numArrC[4].setBounds(43+42+42+42, 285+42+42, 42, 42);
		numArrC[5].setBounds(43+42+42+42+42, 285+42+42, 42, 42);
		numArrC[6].setBounds(43+42+42+42+42+42, 285+42+42, 42, 42);
		numArrC[7].setBounds(43+42+42+42+42+42+42, 285+42+42, 45, 42);
		for (int i = 0; i < numArrD.length; i++) {
			add(numArrD[i]);
		}
		numArrD[0].setBounds(0, 285+42+42+42, 43, 42);
		numArrD[1].setBounds(43, 285+42+42+42, 42, 42);
		numArrD[2].setBounds(43+42, 285+42+42+42, 42, 42);
		numArrD[3].setBounds(43+42+42 , 285+42+42+42, 42, 42);
		numArrD[4].setBounds(43+42+42+42, 285+42+42+42, 42, 42);
		numArrD[5].setBounds(43+42+42+42+42, 285+42+42+42, 42, 42);
		numArrD[6].setBounds(43+42+42+42+42+42, 285+42+42+42, 42, 42);
		numArrD[7].setBounds(43+42+42+42+42+42+42, 285+42+42+42, 45, 42);
		for (int i = 0; i < numArrE.length; i++) {
			add(numArrE[i]);
		}
		numArrE[0].setBounds(0, 285+42+42+42+42, 43, 42);
		numArrE[1].setBounds(43, 285+42+42+42+42, 42, 42);
		numArrE[2].setBounds(43+42, 285+42+42+42+42, 42, 42);
		numArrE[3].setBounds(43+42+42 , 285+42+42+42+42, 42, 42);
		numArrE[4].setBounds(43+42+42+42, 285+42+42+42+42, 42, 42);
		numArrE[5].setBounds(43+42+42+42+42, 285+42+42+42+42, 42, 42);
		numArrE[6].setBounds(43+42+42+42+42+42, 285+42+42+42+42, 42, 42);
		numArrE[7].setBounds(43+42+42+42+42+42+42, 285+42+42+42+42, 45, 42);

		// 당첨 번호 라벨
		for (int i = 0; i < drawNumArr.length; i++) {
			add(drawNumArr[i]);
		}
		drawNumArr[0].setBounds(15, 216, 42, 42);
		drawNumArr[1].setBounds(15+(42*1), 216, 42, 42);
		drawNumArr[2].setBounds(15+(42*2), 216, 42, 42);
		drawNumArr[3].setBounds(15+(42*3), 216, 42, 42);
		drawNumArr[4].setBounds(15+(42*4), 216, 42, 42);
		drawNumArr[5].setBounds(15+(42*5), 216, 42, 42);
		drawNumArr[6].setBounds(15+(42*6)+17, 216, 42, 42);

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

		// 메인으로 가는 버튼
		JLabel btn = lbl[12];
		btn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new Management();
			}
		});

		setLayout(null);
		setVisible(true);
		setPreferredSize(new Dimension(340, 550));
		setOpaque(true);
		setBackground(new Color(10, 4, 52));
	}
}