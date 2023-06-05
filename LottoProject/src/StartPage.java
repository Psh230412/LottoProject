
import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

class StartPage extends JPanel {
	JLabel[] labelOfMain = new JLabel[5];
	AllRecords allRecords;
	public void makeDrawPage(List<Integer> selectedNum, List<String> selectedMode, JLabel[] numArr, List<Integer> randomNumList) {
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
			
			// 번호
//			List<Integer> randomNumList = LottoRandom.getRandomNum();
			
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
	

	public StartPage(AllRecords allRecords) {
		this.allRecords=allRecords;
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
				newFrame.setPreferredSize(new Dimension(340, 550));
				newFrame.setLayout(null);

				int turn =allRecords.getLastTurn();
				
				JComboBox<Integer> comboBox = new JComboBox<>();
				if(turn>0) {
					for (int i = 1; i <= turn; i++) {
						comboBox.addItem(i);
					}	
				}
				
				
				comboBox.setBounds(200, 10, 130, 25);
				newFrame.add(comboBox);

				comboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Integer selectedRound = (Integer) comboBox.getSelectedItem(); //selectedRount == 회차
						
						//selectedRound회차의 Records 객체를 반환 
						Records records = allRecords.getRecords(selectedRound);
						
						//records.selectedNumA
						//records.selectedNumE
						//records.selectedModeA
						//records.selectedModeE
						//등수 계산
						
						
						//makeDrawPage(records.selectedNumA,records.selectedModeA);
						//makeDrawPage(records.selectedNumB,records.selectedModeB);
						
						//
						//
						
						//makeDrawPage(records.selectedNumE,records.selectedModeE);
						
						
						
						// selectedRound는 선택된 로또 회차입니다.
						// 이를 이용하여 해당 회차의 데이터를 가져와서 표시
					}
				});

				newFrame.pack();
				newFrame.setLocationRelativeTo(null);
				newFrame.setVisible(true);
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

		/*
		 * class Run2 implements ActionListener { public void
		 * actionPerformed(ActionEvent e) { Management.card.show(Management.all,
		 * "번호 선택"); } }
		 * 
		 * btn.addActionListener(new Run2());
		 */

		// setSize(340, 550);
	}

	/*
	 * public static void main(String[] args) { new StartPage(allRecords); }
	 */
}
