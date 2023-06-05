
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class StartPage extends JPanel {
	JLabel[] labelOfMain = new JLabel[5];

	JLabel[] numArrA = makeNumLbl();
	JLabel[] numArrB = makeNumLbl();
	JLabel[] numArrC = makeNumLbl();
	JLabel[] numArrD = makeNumLbl();
	JLabel[] numArrE = makeNumLbl();
	JLabel[] drawNumArr = makeDrawNumLbl();
	JLabel[] screenArr = new JLabel[14];

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

	public JLabel[] makeScreen() {
		for (int i = 1; i < screenArr.length; i++) {
			URL screen = LottoDrawPage.class.getClassLoader().getResource("image4/결과확인" + (i + 1) + ".gif");
			ImageIcon imageIcon = new ImageIcon(screen);
			screenArr[i] = new JLabel(imageIcon);
		}
		return screenArr;
	}

	Image[] modeImage = new Image[3];
	Image[] gradeImage = new Image[6];
	Image[] emptyImage = new Image[8];
	Image[] yesImage = new Image[45];
	Image[] noImage = new Image[45];

	public Image[] createMode() {
		for (int i = 0; i < modeImage.length; i++) {
			URL urlOfDN = TestA.class.getClassLoader().getResource("image4/auto" + (i + 1) + ".gif");
			modeImage[i] = new ImageIcon(urlOfDN).getImage();
		}
		return modeImage;
	}

	public Image[] createGrade() {
		for (int i = 0; i < gradeImage.length; i++) {
			URL urlOfDN = TestA.class.getClassLoader().getResource("image4/grade" + (i + 1) + ".gif");
			gradeImage[i] = new ImageIcon(urlOfDN).getImage();
		}
		return gradeImage;
	}

	public Image[] createYes() {
		for (int i = 0; i < yesImage.length; i++) {
			URL urlOfDN = TestA.class.getClassLoader()
					.getResource("image/selNumber" + " " + "(" + (i + 1) + ")" + ".gif");
			yesImage[i] = new ImageIcon(urlOfDN).getImage();
		}
		return yesImage;
	}

	public Image[] createNo() {
		for (int i = 0; i < noImage.length; i++) {
			URL urlOfDN = TestA.class.getClassLoader()
					.getResource("image/unNumber" + " " + "(" + (i + 1) + ")" + ".gif");
			noImage[i] = new ImageIcon(urlOfDN).getImage();
		}
		return noImage;
	}

	public Image[] createEmpty() {
		for (int i = 0; i < emptyImage.length; i++) {
			URL urlOfDN = TestA.class.getClassLoader().getResource("image4/empty" + (i + 1) + ".gif");
			emptyImage[i] = new ImageIcon(urlOfDN).getImage();
		}
		return emptyImage;
	}

	public void makeRecordsPage(List<String> selectedMode, List<Integer> selectedNumbers, JLabel[] numArr,
			List<Integer> randomNumList) {

		if (!selectedNumbers.isEmpty()) {
			// 자동
			String selectMode = selectedMode.get(0);
			if (selectMode.equals("자동")) {
				numArr[0].setIcon(new ImageIcon(modeImage[0]));
			} else if (selectMode.equals("반자동")) {
				numArr[0].setIcon(new ImageIcon(modeImage[1]));
			} else {
				numArr[0].setIcon(new ImageIcon(modeImage[2]));
			}

			List<Integer> randomNumListClone = new ArrayList<>();
			for (int i = 0; i < 6; i++) {
				randomNumListClone.add(randomNumList.get(i));
			}

			int count = 0;

			for (int i = 0; i < selectedNumbers.size(); i++) {
				int number = selectedNumbers.get(i);
				int index = selectedNumbers.indexOf(number);
				if (randomNumListClone.contains(number)) {
					numArr[index + 1].setIcon(new ImageIcon(yesImage[number - 1]));

					count++;
				} else {
					numArr[index + 1].setIcon(new ImageIcon(noImage[number - 1]));
				}
			}
			if (count == 5) {
				int bonus = randomNumList.get(6);
				if (selectedNumbers.contains(bonus)) {
					int index = selectedNumbers.indexOf(bonus);
					numArr[index + 1].setIcon(new ImageIcon(yesImage[bonus - 1]));
				}
			}

			int grade = 0;

			switch (count) {

			case 3:
				grade = 5;
				break;
			case 4:
				grade = 4;
				break;
			case 5:
				int count2 = 0;
				for (int i = 0; i < selectedNumbers.size(); i++) {
					if (selectedNumbers.get(i) == randomNumList.get(6)) {
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

			if (grade == 1) {
				numArr[7].setIcon(new ImageIcon(gradeImage[0]));
			} else if (grade == 2) {
				numArr[7].setIcon(new ImageIcon(gradeImage[1]));
			} else if (grade == 3) {
				numArr[7].setIcon(new ImageIcon(gradeImage[2]));
			} else if (grade == 4) {
				numArr[7].setIcon(new ImageIcon(gradeImage[3]));
			} else if (grade == 5) {
				numArr[7].setIcon(new ImageIcon(gradeImage[4]));
			} else if (grade == 6) {
				numArr[7].setIcon(new ImageIcon(gradeImage[5]));
			}

		} else {
			for (int i = 0; i < numArr.length; i++) {
				numArr[i].setIcon(new ImageIcon(emptyImage[i]));
			}
		}
	}

	public void RecordsPage(JFrame newFrame, Records records) {

		if (records == null) {
			for (int i = 0; i < numArrA.length; i++) {
				newFrame.add(numArrA[i]);
			}
			for (int i = 0; i < numArrA.length; i++) {
				URL screen = TestA.class.getClassLoader().getResource("image4/empty" + (i + 1) + ".gif");
				ImageIcon imageIcon = new ImageIcon(screen);
				numArrA[i].setIcon(imageIcon);
				;
			}
			numArrA[0].setBounds(0, 200, 43, 42);// 자동 반자동
			numArrA[1].setBounds(43, 200, 42, 42);
			numArrA[2].setBounds(43 + 42, 200, 42, 42);
			numArrA[3].setBounds(43 + 42 + 42, 200, 42, 42);
			numArrA[4].setBounds(43 + 42 + 42 + 42, 200, 42, 42);
			numArrA[5].setBounds(43 + 42 + 42 + 42 + 42, 200, 42, 42);
			numArrA[6].setBounds(43 + 42 + 42 + 42 + 42 + 42, 200, 42, 42);
			numArrA[7].setBounds(43 + 42 + 42 + 42 + 42 + 42 + 42, 200, 45, 42);// 등수
			for (int i = 0; i < numArrB.length; i++) {
				newFrame.add(numArrB[i]);
			} // B
			for (int i = 0; i < numArrB.length; i++) {
				URL screen = TestA.class.getClassLoader().getResource("image4/empty" + (i + 1) + ".gif");
				ImageIcon imageIcon = new ImageIcon(screen);
				numArrB[i].setIcon(imageIcon);
				;
			}
			numArrB[0].setBounds(0, 200 + 67, 43, 42);// 자동 반자동
			numArrB[1].setBounds(43, 200 + 67, 42, 42);
			numArrB[2].setBounds(43 + 42, 200 + 67, 42, 42);
			numArrB[3].setBounds(43 + 42 + 42, 200 + 67, 42, 42);
			numArrB[4].setBounds(43 + 42 + 42 + 42, 200 + 67, 42, 42);
			numArrB[5].setBounds(43 + 42 + 42 + 42 + 42, 200 + 67, 42, 42);
			numArrB[6].setBounds(43 + 42 + 42 + 42 + 42 + 42, 200 + 67, 42, 42);
			numArrB[7].setBounds(43 + 42 + 42 + 42 + 42 + 42 + 42, 200 + 67, 45, 42);// 등수
			for (int i = 0; i < numArrC.length; i++) {
				newFrame.add(numArrC[i]);
			} // C
			for (int i = 0; i < numArrC.length; i++) {
				URL screen = TestA.class.getClassLoader().getResource("image4/empty" + (i + 1) + ".gif");
				ImageIcon imageIcon = new ImageIcon(screen);
				numArrC[i].setIcon(imageIcon);
				;
			}
			numArrC[0].setBounds(0, 200 + 67 + 67, 43, 42);// 자동 반자동
			numArrC[1].setBounds(43, 200 + 67 + 67, 42, 42);
			numArrC[2].setBounds(43 + 42, 200 + 67 + 67, 42, 42);
			numArrC[3].setBounds(43 + 42 + 42, 200 + 67 + 67, 42, 42);
			numArrC[4].setBounds(43 + 42 + 42 + 42, 200 + 67 + 67, 42, 42);
			numArrC[5].setBounds(43 + 42 + 42 + 42 + 42, 200 + 67 + 67, 42, 42);
			numArrC[6].setBounds(43 + 42 + 42 + 42 + 42 + 42, 200 + 67 + 67, 42, 42);
			numArrC[7].setBounds(43 + 42 + 42 + 42 + 42 + 42 + 42, 200 + 67 + 67, 45, 42);// 등수
			for (int i = 0; i < numArrD.length; i++) {
				newFrame.add(numArrD[i]);
			} // D
			for (int i = 0; i < numArrD.length; i++) {
				URL screen = TestA.class.getClassLoader().getResource("image4/empty" + (i + 1) + ".gif");
				ImageIcon imageIcon = new ImageIcon(screen);
				numArrD[i].setIcon(imageIcon);
				;
			}
			numArrD[0].setBounds(0, 200 + 67 + 67 + 67, 43, 42);// 자동 반자동
			numArrD[1].setBounds(43, 200 + 67 + 67 + 67, 42, 42);
			numArrD[2].setBounds(43 + 42, 200 + 67 + 67 + 67, 42, 42);
			numArrD[3].setBounds(43 + 42 + 42, 200 + 67 + 67 + 67, 42, 42);
			numArrD[4].setBounds(43 + 42 + 42 + 42, 200 + 67 + 67 + 67, 42, 42);
			numArrD[5].setBounds(43 + 42 + 42 + 42 + 42, 200 + 67 + 67 + 67, 42, 42);
			numArrD[6].setBounds(43 + 42 + 42 + 42 + 42 + 42, 200 + 67 + 67 + 67, 42, 42);
			numArrD[7].setBounds(43 + 42 + 42 + 42 + 42 + 42 + 42, 200 + 67 + 67 + 67, 45, 42);// 등수
			for (int i = 0; i < numArrE.length; i++) {
				newFrame.add(numArrE[i]);
			} // E
			for (int i = 0; i < numArrE.length; i++) {
				URL screen = TestA.class.getClassLoader().getResource("image4/empty" + (i + 1) + ".gif");
				ImageIcon imageIcon = new ImageIcon(screen);
				numArrE[i].setIcon(imageIcon);
				;
			}
			numArrE[0].setBounds(0, 200 + 67 + 67 + 67 + 67, 43, 42);// 자동 반자동
			numArrE[1].setBounds(43, 200 + 67 + 67 + 67 + 67, 42, 42);
			numArrE[2].setBounds(43 + 42, 200 + 67 + 67 + 67 + 67, 42, 42);
			numArrE[3].setBounds(43 + 42 + 42, 200 + 67 + 67 + 67 + 67, 42, 42);
			numArrE[4].setBounds(43 + 42 + 42 + 42, 200 + 67 + 67 + 67 + 67, 42, 42);
			numArrE[5].setBounds(43 + 42 + 42 + 42 + 42, 200 + 67 + 67 + 67 + 67, 42, 42);
			numArrE[6].setBounds(43 + 42 + 42 + 42 + 42 + 42, 200 + 67 + 67 + 67 + 67, 42, 42);
			numArrE[7].setBounds(43 + 42 + 42 + 42 + 42 + 42 + 42, 200 + 67 + 67 + 67 + 67, 45, 42);// 등수

			// 당첨 번호 라벨
			for (int i = 0; i < drawNumArr.length; i++) {
				newFrame.add(drawNumArr[i]);
			}
			for (int i = 0; i < drawNumArr.length; i++) {
				URL screen = TestA.class.getClassLoader().getResource("image/nellNum.gif");
				ImageIcon imageIcon = new ImageIcon(screen);
				drawNumArr[i].setIcon(imageIcon);
			}

			drawNumArr[0].setBounds(15, 133, 42, 42);
			drawNumArr[1].setBounds(15 + (42 * 1), 133, 42, 42);
			drawNumArr[2].setBounds(15 + (42 * 2), 133, 42, 42);
			drawNumArr[3].setBounds(15 + (42 * 3), 133, 42, 42);
			drawNumArr[4].setBounds(15 + (42 * 4), 133, 42, 42);
			drawNumArr[5].setBounds(15 + (42 * 5), 133, 42, 42);
			drawNumArr[6].setBounds(15 + (42 * 6) + 17, 133, 42, 42);

			// 기본 배경 드로우이미지수정

			JLabel[] lbl = makeScreen();
			URL screen = LottoDrawPage.class.getClassLoader().getResource("image4/Untitled-1_02.gif");
			ImageIcon imageIcon = new ImageIcon(screen);
			screenArr[0] = new JLabel(imageIcon);

			lbl[0].setBounds(0, 0, 340, 121);
			lbl[2].setBounds(284, 121, 42, 12); // 보너스
			lbl[5].setBounds(15 + 252, 121 + 12, 17, 42); // 더하기
			lbl[6].setBounds(0, 175, 340, 25); // A
			lbl[7].setBounds(0, 121 + 12 + 42 + 67, 340, 25); // B
			lbl[8].setBounds(0, 121 + 12 + 42 + 67 + 67, 340, 25); // C
			lbl[9].setBounds(0, 121 + 12 + 42 + 67 + 67 + 67, 340, 25); // D
			lbl[10].setBounds(0, 121 + 12 + 42 + 67 + 67 + 67 + 67, 340, 25); // E
			lbl[12].setBounds(118, 121 + 12 + 42 + 67 + 67 + 67 + 67 + 67, 100, 40); // 메인

			for (int i = 0; i < lbl.length; i++) {
				newFrame.add(lbl[i]);
			}
		} else {
			makeRecordsPage(records.selectedModeA, records.selectedNumA, numArrA, records.randomNumList);
			makeRecordsPage(records.selectedModeB, records.selectedNumB, numArrB, records.randomNumList);
			makeRecordsPage(records.selectedModeC, records.selectedNumC, numArrC, records.randomNumList);
			makeRecordsPage(records.selectedModeD, records.selectedNumD, numArrD, records.randomNumList);
			makeRecordsPage(records.selectedModeE, records.selectedNumE, numArrE, records.randomNumList);

			for (int i = 0; i < numArrA.length; i++) {
				newFrame.add(numArrA[i]);
			}

			numArrA[0].setBounds(0, 200, 43, 42);// 자동 반자동
			numArrA[1].setBounds(43, 200, 42, 42);
			numArrA[2].setBounds(43 + 42, 200, 42, 42);
			numArrA[3].setBounds(43 + 42 + 42, 200, 42, 42);
			numArrA[4].setBounds(43 + 42 + 42 + 42, 200, 42, 42);
			numArrA[5].setBounds(43 + 42 + 42 + 42 + 42, 200, 42, 42);
			numArrA[6].setBounds(43 + 42 + 42 + 42 + 42 + 42, 200, 42, 42);
			numArrA[7].setBounds(43 + 42 + 42 + 42 + 42 + 42 + 42, 200, 45, 42);// 등수
			for (int i = 0; i < numArrB.length; i++) {
				newFrame.add(numArrB[i]);
			} // B

			numArrB[0].setBounds(0, 200 + 67, 43, 42);// 자동 반자동
			numArrB[1].setBounds(43, 200 + 67, 42, 42);
			numArrB[2].setBounds(43 + 42, 200 + 67, 42, 42);
			numArrB[3].setBounds(43 + 42 + 42, 200 + 67, 42, 42);
			numArrB[4].setBounds(43 + 42 + 42 + 42, 200 + 67, 42, 42);
			numArrB[5].setBounds(43 + 42 + 42 + 42 + 42, 200 + 67, 42, 42);
			numArrB[6].setBounds(43 + 42 + 42 + 42 + 42 + 42, 200 + 67, 42, 42);
			numArrB[7].setBounds(43 + 42 + 42 + 42 + 42 + 42 + 42, 200 + 67, 45, 42);// 등수
			for (int i = 0; i < numArrC.length; i++) {
				newFrame.add(numArrC[i]);
			} // C

			numArrC[0].setBounds(0, 200 + 67 + 67, 43, 42);// 자동 반자동
			numArrC[1].setBounds(43, 200 + 67 + 67, 42, 42);
			numArrC[2].setBounds(43 + 42, 200 + 67 + 67, 42, 42);
			numArrC[3].setBounds(43 + 42 + 42, 200 + 67 + 67, 42, 42);
			numArrC[4].setBounds(43 + 42 + 42 + 42, 200 + 67 + 67, 42, 42);
			numArrC[5].setBounds(43 + 42 + 42 + 42 + 42, 200 + 67 + 67, 42, 42);
			numArrC[6].setBounds(43 + 42 + 42 + 42 + 42 + 42, 200 + 67 + 67, 42, 42);
			numArrC[7].setBounds(43 + 42 + 42 + 42 + 42 + 42 + 42, 200 + 67 + 67, 45, 42);// 등수
			for (int i = 0; i < numArrD.length; i++) {
				newFrame.add(numArrD[i]);
			} // D

			numArrD[0].setBounds(0, 200 + 67 + 67 + 67, 43, 42);// 자동 반자동
			numArrD[1].setBounds(43, 200 + 67 + 67 + 67, 42, 42);
			numArrD[2].setBounds(43 + 42, 200 + 67 + 67 + 67, 42, 42);
			numArrD[3].setBounds(43 + 42 + 42, 200 + 67 + 67 + 67, 42, 42);
			numArrD[4].setBounds(43 + 42 + 42 + 42, 200 + 67 + 67 + 67, 42, 42);
			numArrD[5].setBounds(43 + 42 + 42 + 42 + 42, 200 + 67 + 67 + 67, 42, 42);
			numArrD[6].setBounds(43 + 42 + 42 + 42 + 42 + 42, 200 + 67 + 67 + 67, 42, 42);
			numArrD[7].setBounds(43 + 42 + 42 + 42 + 42 + 42 + 42, 200 + 67 + 67 + 67, 45, 42);// 등수
			for (int i = 0; i < numArrE.length; i++) {
				newFrame.add(numArrE[i]);
			} // E

			numArrE[0].setBounds(0, 200 + 67 + 67 + 67 + 67, 43, 42);// 자동 반자동
			numArrE[1].setBounds(43, 200 + 67 + 67 + 67 + 67, 42, 42);
			numArrE[2].setBounds(43 + 42, 200 + 67 + 67 + 67 + 67, 42, 42);
			numArrE[3].setBounds(43 + 42 + 42, 200 + 67 + 67 + 67 + 67, 42, 42);
			numArrE[4].setBounds(43 + 42 + 42 + 42, 200 + 67 + 67 + 67 + 67, 42, 42);
			numArrE[5].setBounds(43 + 42 + 42 + 42 + 42, 200 + 67 + 67 + 67 + 67, 42, 42);
			numArrE[6].setBounds(43 + 42 + 42 + 42 + 42 + 42, 200 + 67 + 67 + 67 + 67, 42, 42);
			numArrE[7].setBounds(43 + 42 + 42 + 42 + 42 + 42 + 42, 200 + 67 + 67 + 67 + 67, 45, 42);// 등수

			// 당첨 번호 라벨
			for (int i = 0; i < drawNumArr.length; i++) {
				newFrame.add(drawNumArr[i]);
			}
			for (int i = 0; i < drawNumArr.length; i++) {
				int index = records.randomNumList.get(i);
				URL screen = LottoDrawPage.class.getClassLoader()
						.getResource("image/selNumber" + " " + "(" + index + ")" + ".gif");
				ImageIcon imageIcon = new ImageIcon(screen);
				drawNumArr[i].setIcon(imageIcon);
			}
			drawNumArr[0].setBounds(15, 133, 42, 42);
			drawNumArr[1].setBounds(15 + (42 * 1), 133, 42, 42);
			drawNumArr[2].setBounds(15 + (42 * 2), 133, 42, 42);
			drawNumArr[3].setBounds(15 + (42 * 3), 133, 42, 42);
			drawNumArr[4].setBounds(15 + (42 * 4), 133, 42, 42);
			drawNumArr[5].setBounds(15 + (42 * 5), 133, 42, 42);
			drawNumArr[6].setBounds(15 + (42 * 6) + 17, 133, 42, 42);

			// 기본 배경 드로우이미지수정

			JLabel[] lbl = makeScreen();
			URL screen = LottoDrawPage.class.getClassLoader().getResource("image4/Untitled-1_02.gif");
			ImageIcon imageIcon = new ImageIcon(screen);
			screenArr[0] = new JLabel(imageIcon);

			lbl[0].setBounds(0, 0, 340, 121);
			lbl[2].setBounds(284, 121, 42, 12); // 보너스
			lbl[5].setBounds(15 + 252, 121 + 12, 17, 42); // 더하기
			lbl[6].setBounds(0, 175, 340, 25); // A
			lbl[7].setBounds(0, 121 + 12 + 42 + 67, 340, 25); // B
			lbl[8].setBounds(0, 121 + 12 + 42 + 67 + 67, 340, 25); // C
			lbl[9].setBounds(0, 121 + 12 + 42 + 67 + 67 + 67, 340, 25); // D
			lbl[10].setBounds(0, 121 + 12 + 42 + 67 + 67 + 67 + 67, 340, 25); // E
			lbl[12].setBounds(118, 121 + 12 + 42 + 67 + 67 + 67 + 67 + 67, 100, 40); // 메인

			for (int i = 0; i < lbl.length; i++) {
				newFrame.add(lbl[i]);
			}
		}

	}

	public StartPage(AllRecords allRecords) {
		createMode();
		createGrade();
		createYes();
		createNo();
		createEmpty();

		JPanel panel = new JPanel();
		panel.setLayout(null);

		for (int i = 0; i < 5; i++) {
			URL urlOfMain = LottoTicket1.class.getClassLoader().getResource("image/메인화면_0" + (i + 1) + ".gif");
			ImageIcon imageIcon = new ImageIcon(urlOfMain);
			labelOfMain[i] = new JLabel(imageIcon);
			panel.add(labelOfMain[i]);
		}

		labelOfMain[0].setBounds(0, 0, 340, 379);
		labelOfMain[1].setBounds(0, 379, 340, 42);
		labelOfMain[2].setBounds(0, 421, 340, 42);
		labelOfMain[3].setBounds(0, 463, 340, 46);// 스타트 페이지 로또 레코드
		labelOfMain[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JFrame newFrame = new JFrame("로또 회차 보기");

				newFrame.getContentPane().setPreferredSize(new Dimension(340, 510));
				newFrame.setLayout(null);
				newFrame.getContentPane().setBackground(new Color(10, 4, 52));
				newFrame.setResizable(false);

				RecordsPage(newFrame, null);

				int turn = allRecords.getLastTurn();

				JComboBox<Integer> comboBox = new JComboBox<>();
				if (turn > 0) {
					for (int i = 1; i <= turn; i++) {
						comboBox.addItem(i);
					}
				}

				newFrame.add(comboBox);

				comboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						JComboBox cb = (JComboBox) e.getSource(); // 콤보박스 알아내기
						Integer selectedRound = (Integer) cb.getSelectedItem(); // selectedRount == 회차

						// selectedRound회차의 Records 객체를 반환
						Records records = allRecords.getRecords(selectedRound);

						RecordsPage(newFrame, records);

					}
				});

				newFrame.pack();
				newFrame.setLocationRelativeTo(null);
				newFrame.setVisible(true);
				comboBox.setBounds(300, 0, 40, 25);
			}
		});

		labelOfMain[4].setBounds(0, 509, 340, 41);

		JButton btn = new JButton("로또하러가기");
		JButton btn2 = new JButton("튜토리얼");

		panel.add(btn);
		panel.setBounds(0, 0, 340, 550);
		setLayout(null);

		btn2.setBounds(0, 380, 340, 42);
		labelOfMain[1].add(btn);
		labelOfMain[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Management.card.show(Management.all, "튜토리얼");

			}
		});

		btn.setBounds(0, 421, 340, 42);
		labelOfMain[2].add(btn);
		labelOfMain[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Management.card.show(Management.all, "번호 선택");
			}
		});
		add(panel);

	}

}
