import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

class TestA extends JPanel {

	JLabel[] MainImage = new JLabel[32];
	JLabel[] SelNum = new JLabel[7];
	JLabel[] labels = CreateMain();
	JLabel[] selectA = SelectTicket();
	JLabel[] selectB = SelectTicket();
	JLabel[] selectC = SelectTicket();
	JLabel[] selectD = SelectTicket();
	JLabel[] selectE = SelectTicket();
	LottoDrawPage lottoDrawPage;

	Image[] modeImage = new Image[3];
	Image[] gradeImage = new Image[6];
	Image[] emptyImage = new Image[8];
	Image[] yesImage = new Image[45];
	Image[] noImage = new Image[45];
	ResourceSoundPack resourceSoundPack = new ResourceSoundPack();
	AllRecords allrecords;

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

	public JLabel[] CreateMain() {
		for (int i = 0; i < MainImage.length; i++) {
			URL urlofCm = TestA.class.getClassLoader().getResource("image2/번호선택_" + (i + 1) + ".gif");
			ImageIcon imageicon = new ImageIcon(urlofCm);
			MainImage[i] = new JLabel(imageicon);
		}
		return MainImage;
	}

	public JLabel[] SelectTicket() {
		JLabel[] SelectedNum = new JLabel[7];
		for (int i = 0; i < SelectedNum.length; i++) {
			URL urlofNm = TestA.class.getClassLoader().getResource("image2/빈슬롯_" + (i + 1) + ".gif");
			ImageIcon imageicon2 = new ImageIcon(urlofNm);
			SelectedNum[i] = new JLabel(imageicon2);
		}
		return SelectedNum;
	}

	public void makeDrawPage(List<String> selectedMode, List<Integer> selectedNumbers, JLabel[] numArr,
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

	public TestA(LottoDrawPage lottoDrawPage, AllRecords allRecords) {
		ResourceSoundPack resourceSoundPack = new ResourceSoundPack();
		JPanel main1 = new JPanel();
		main1.setBackground(Color.BLACK);

		createMode();
		createGrade();
		createEmpty();
		createYes();
		createNo();

		for (int i = 0; i < labels.length; i++) {
			main1.add(labels[i]);
		}

		labels[1].setLocation(295, 0); // 물음표
		labels[1].setSize(45, 43);
		labels[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Management.card.show(Management.all, "도움말");
			}
		});
		labels[2].setLocation(295, 43); // 물음표 밑에 칸
		labels[2].setSize(45, 28);
		labels[3].setLocation(0, 71); // 왼쪽 사이드
		labels[3].setSize(23, 479);
		labels[6].setLocation(318, 71); // 오른쪽 사이드
		labels[6].setSize(22, 479);

		// A
		labels[0].setLocation(0, 0); // 상단 A
		labels[0].setSize(295, 71);
		labels[4].setLocation(23, 71); // A머리
		labels[4].setSize(272, 17);
		labels[5].setLocation(295, 71); // A엑스
		labels[5].setSize(23, 17);
		labels[5].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resourceSoundPack.removeSound();
				if (LottoTicket1.selectedNumbers.size() != 0) {
					LottoTicket1.selectedNumbers.clear();
				}

				if (LottoTicket1.selectedMode.size() != 0) {
					LottoTicket1.selectedMode.clear();

				}
				for (int i = 0; i < selectA.length; i++) {
					URL urlofNm = TestA.class.getClassLoader().getResource("image2/빈슬롯_" + (i + 1) + ".gif");
					ImageIcon imageicon2 = new ImageIcon(urlofNm);
					selectA[i].setIcon(imageicon2);
				}

			}
		});
		labels[7].setLocation(0, 0); // A자리 빈슬롯
		labels[7].setSize(0, 0);

		// B
		labels[8].setLocation(23, 130); // B상단
		labels[8].setSize(295, 33);
		labels[9].setLocation(23, 163); // B머리
		labels[9].setSize(272, 17);
		labels[10].setLocation(295, 163); // B엑스
		labels[10].setSize(23, 17);
		labels[10].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				resourceSoundPack.removeSound();
				if (LottoTicket2.selectedNumbers.size() != 0) {
					LottoTicket2.selectedNumbers.clear();
				}

				if (LottoTicket2.selectedMode.size() != 0) {
					LottoTicket2.selectedMode.clear();
				}
				for (int i = 0; i < selectB.length; i++) {
					URL urlofNm = TestA.class.getClassLoader().getResource("image2/빈슬롯_" + (i + 1) + ".gif");
					ImageIcon imageicon2 = new ImageIcon(urlofNm);
					selectB[i].setIcon(imageicon2);
				}

			}
		});

		labels[11].setLocation(0, 0); // B위치 자동
		labels[11].setSize(0, 0);
		labels[12].setLocation(0, 0); // B위치 숫자
		labels[12].setSize(0, 0);

		// C
		labels[13].setLocation(23, 222); // C상단
		labels[13].setSize(295, 34);
		labels[14].setLocation(23, 256); // C머리
		labels[14].setSize(272, 17);
		labels[15].setLocation(295, 256); // C엑스
		labels[15].setSize(23, 17);
		labels[15].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resourceSoundPack.removeSound();
				if (LottoTicket3.selectedNumbers.size() != 0) {
					LottoTicket3.selectedNumbers.clear();
				}

				if (LottoTicket3.selectedMode.size() != 0) {
					LottoTicket3.selectedMode.clear();

				}
				for (int i = 0; i < selectC.length; i++) {
					URL urlofNm = TestA.class.getClassLoader().getResource("image2/빈슬롯_" + (i + 1) + ".gif");
					ImageIcon imageicon2 = new ImageIcon(urlofNm);
					selectC[i].setIcon(imageicon2);
				}

			}
		});

		// D
		labels[18].setLocation(23, 315); // D상단
		labels[18].setSize(295, 33);
		labels[19].setLocation(23, 348); // D머리
		labels[19].setSize(272, 17);
		labels[20].setLocation(295, 348); // D엑스
		labels[20].setSize(23, 17);
		labels[20].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resourceSoundPack.removeSound();
				if (LottoTicket4.selectedNumbers.size() != 0) {
					LottoTicket4.selectedNumbers.clear();
				}

				if (LottoTicket4.selectedMode.size() != 0) {
					LottoTicket4.selectedMode.clear();

				}
				for (int i = 0; i < selectD.length; i++) {
					URL urlofNm = TestA.class.getClassLoader().getResource("image2/빈슬롯_" + (i + 1) + ".gif");
					ImageIcon imageicon2 = new ImageIcon(urlofNm);
					selectD[i].setIcon(imageicon2);
				}

			}
		});

		labels[21].setLocation(0, 0); // D자리 반자동
		labels[21].setSize(0, 0);
		labels[22].setLocation(0, 0); // D자리 숫자
		labels[22].setSize(0, 0);

		// E
		labels[23].setLocation(23, 407); // E상단
		labels[23].setSize(295, 32);
		labels[24].setLocation(23, 439); // E머리
		labels[24].setSize(272, 17);
		labels[25].setLocation(295, 439); // E엑스
		labels[25].setSize(23, 17);
		labels[25].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resourceSoundPack.removeSound();
				if (LottoTicket5.selectedNumbers.size() != 0) {
					LottoTicket5.selectedNumbers.clear();
				}

				if (LottoTicket5.selectedMode.size() != 0) {
					LottoTicket5.selectedMode.clear();

				}
				for (int i = 0; i < selectE.length; i++) {
					URL urlofNm = TestA.class.getClassLoader().getResource("image2/빈슬롯_" + (i + 1) + ".gif");
					ImageIcon imageicon2 = new ImageIcon(urlofNm);
					selectE[i].setIcon(imageicon2);
				}

			}
		});

		labels[26].setLocation(0, 0); // E자리 빈슬롯
		labels[26].setSize(0, 0);

		// 하단
		labels[27].setLocation(23, 498); // D슬롯 밑 1
		labels[27].setSize(295, 17);
		labels[28].setLocation(23, 515); // 뒤로가기 버튼
		labels[28].setSize(15, 18);
		labels[28].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resourceSoundPack.stratSound();
				int result = JOptionPane.showConfirmDialog(TestA.this, "시작화면으로 돌아갈시 초기화됩니다", "돌아가기",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					if (LottoTicket1.selectedNumbers.size() != 0) {
						LottoTicket1.selectedNumbers.clear();
					}
					if (LottoTicket1.selectedMode.size() != 0) {
						LottoTicket1.selectedMode.clear();
					}
					for (int i = 0; i < selectA.length; i++) {
						URL urlofNm = TestA.class.getClassLoader().getResource("image2/빈슬롯_" + (i + 1) + ".gif");
						ImageIcon imageicon2 = new ImageIcon(urlofNm);
						selectA[i].setIcon(imageicon2);
					}
					if (LottoTicket2.selectedNumbers.size() != 0) {
						LottoTicket2.selectedNumbers.clear();
					}

					if (LottoTicket2.selectedMode.size() != 0) {
						LottoTicket2.selectedMode.clear();

					}
					for (int i = 0; i < selectB.length; i++) {
						URL urlofNm = TestA.class.getClassLoader().getResource("image2/빈슬롯_" + (i + 1) + ".gif");
						ImageIcon imageicon2 = new ImageIcon(urlofNm);
						selectB[i].setIcon(imageicon2);
					}
					if (LottoTicket3.selectedNumbers.size() != 0) {
						LottoTicket3.selectedNumbers.clear();
					}
					if (LottoTicket3.selectedMode.size() != 0) {
						LottoTicket3.selectedMode.clear();
					}

					for (int i = 0; i < selectC.length; i++) {
						URL urlofNm = TestA.class.getClassLoader().getResource("image2/빈슬롯_" + (i + 1) + ".gif");
						ImageIcon imageicon2 = new ImageIcon(urlofNm);
						selectC[i].setIcon(imageicon2);
					}
					if (LottoTicket4.selectedNumbers.size() != 0) {
						LottoTicket4.selectedNumbers.clear();
					}

					if (LottoTicket4.selectedMode.size() != 0) {
						LottoTicket4.selectedMode.clear();

					}
					for (int i = 0; i < selectD.length; i++) {
						URL urlofNm = TestA.class.getClassLoader().getResource("image2/빈슬롯_" + (i + 1) + ".gif");
						ImageIcon imageicon2 = new ImageIcon(urlofNm);
						selectD[i].setIcon(imageicon2);
					}
					if (LottoTicket5.selectedNumbers.size() != 0) {
						LottoTicket5.selectedNumbers.clear();
					}

					if (LottoTicket5.selectedMode.size() != 0) {
						LottoTicket5.selectedMode.clear();

					}
					for (int i = 0; i < selectE.length; i++) {
						URL urlofNm = TestA.class.getClassLoader().getResource("image2/빈슬롯_" + (i + 1) + ".gif");
						ImageIcon imageicon2 = new ImageIcon(urlofNm);
						selectE[i].setIcon(imageicon2);
					}

					Management.card.show(Management.all, "시작");
				}
			}
		});
		labels[29].setLocation(38, 515); // D슬롯 밑 2
		labels[29].setSize(265, 18);
		labels[30].setLocation(303, 515); // 넘어가기 버튼
		labels[30].setSize(15, 18);
		labels[30].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (LottoTicket1.selectedNumbers.size() == 0 && LottoTicket2.selectedNumbers.size() == 0
		                  && LottoTicket3.selectedNumbers.size() == 0 && LottoTicket4.selectedNumbers.size() == 0
		                  && LottoTicket5.selectedNumbers.size() == 0) {
					resourceSoundPack.btnSound();
		               JOptionPane.showMessageDialog(null, "선택된 티켓이 없습니다.", "선택된 티켓없음", JOptionPane.WARNING_MESSAGE);
		            } else {
				resourceSoundPack.btnSound();
				resourceSoundPack.lottoBallSound();
				Management.card.show(Management.all, "당첨 번호");
				Management.card.show(Management.all, "공튀기기");
				LotteryBall.startAnimation();

				LottoRandom lottoRandom = new LottoRandom();
				List<Integer> randomNumList = lottoRandom.getRandomNum();

				List<Integer> randomNumListClone = new ArrayList<>();

				for (int i = 0; i < 6; i++) {
					randomNumListClone.add(randomNumList.get(i));
				}

				Collections.sort(randomNumListClone);

				List<Integer> randomNumListOfRecords = new ArrayList<>();
				randomNumListOfRecords.addAll(randomNumListClone);
				randomNumListOfRecords.add(randomNumList.get(6));
				allRecords.push(LottoTicket1.getSelectedNumbers(), LottoTicket2.getSelectedNumbers(),
						LottoTicket3.getSelectedNumbers(), LottoTicket4.getSelectedNumbers(),
						LottoTicket5.getSelectedNumbers(), randomNumListOfRecords, LottoTicket1.selectedMode,
						LottoTicket2.selectedMode, LottoTicket3.selectedMode, LottoTicket4.selectedMode,
						LottoTicket5.selectedMode);

				for (int i = 0; i < randomNumListClone.size(); i++) {
					int number = randomNumListClone.get(i);
					lottoDrawPage.drawNumArr[i].setIcon(new ImageIcon(yesImage[number - 1]));
				}
				lottoDrawPage.drawNumArr[6].setIcon(new ImageIcon(yesImage[randomNumList.get(6) - 1]));

				makeDrawPage(LottoTicket1.selectedMode, LottoTicket1.selectedNumbers, lottoDrawPage.numArrA,
						randomNumList);
				makeDrawPage(LottoTicket2.selectedMode, LottoTicket2.selectedNumbers, lottoDrawPage.numArrB,
						randomNumList);
				makeDrawPage(LottoTicket3.selectedMode, LottoTicket3.selectedNumbers, lottoDrawPage.numArrC,
						randomNumList);
				makeDrawPage(LottoTicket4.selectedMode, LottoTicket4.selectedNumbers, lottoDrawPage.numArrD,
						randomNumList);
				makeDrawPage(LottoTicket5.selectedMode, LottoTicket5.selectedNumbers, lottoDrawPage.numArrE,
						randomNumList);

			}
			}
		});

		labels[31].setLocation(23, 533); // 맨 밑에
		labels[31].setSize(295, 17);

		for (int i = 0; i < selectA.length; i++) {
			main1.add(selectA[i]);
		}
		for (int i = 0; i < selectB.length; i++) {
			main1.add(selectB[i]);
		}
		for (int i = 0; i < selectC.length; i++) {
			main1.add(selectC[i]);
		}
		for (int i = 0; i < selectD.length; i++) {
			main1.add(selectD[i]);
		}
		for (int i = 0; i < selectE.length; i++) {
			main1.add(selectE[i]);
		}

		// A 빈슬롯
		selectA[0].setLocation(23, 88); // 자동 반자동 수동
		selectA[0].setSize(43, 42);
		selectA[1].setLocation(23 + 43, 88); // 아래 번호
		selectA[1].setSize(42, 42);
		selectA[2].setLocation(23 + 42 + 43, 88);
		selectA[2].setSize(42, 42);
		selectA[3].setLocation(23 + 42 + 43 + 42, 88);
		selectA[3].setSize(42, 42);
		selectA[4].setLocation(23 + 42 + 43 + 42 + 42, 88);
		selectA[4].setSize(42, 42);
		selectA[5].setLocation(23 + 42 + 43 + 42 + 42 + 42, 88);
		selectA[5].setSize(42, 42);
		selectA[6].setLocation(23 + 42 + 43 + 42 + 42 + 42 + 42, 88);
		selectA[6].setSize(42, 42);

		// B 빈슬롯
		selectB[0].setLocation(23, 180); // 자동 반자동 수동
		selectB[0].setSize(43, 42);
		selectB[1].setLocation(23 + 43, 180); // 아래 번호
		selectB[1].setSize(42, 42);
		selectB[2].setLocation(23 + 43 + 42, 180);
		selectB[2].setSize(42, 42);
		selectB[3].setLocation(23 + 43 + 42 + 42, 180);
		selectB[3].setSize(42, 42);
		selectB[4].setLocation(23 + 43 + 42 + 42 + 42, 180);
		selectB[4].setSize(42, 42);
		selectB[5].setLocation(23 + 43 + 42 + 42 + 42 + 42, 180);
		selectB[5].setSize(42, 42);
		selectB[6].setLocation(23 + 43 + 42 + 42 + 42 + 42 + 42, 180);
		selectB[6].setSize(42, 42);

		// C 빈슬롯
		selectC[0].setLocation(23, 273); // 자동 반자동 수동
		selectC[0].setSize(43, 42);
		selectC[1].setLocation(23 + 43, 273); // 아래 번호
		selectC[1].setSize(42, 42);
		selectC[2].setLocation(23 + 43 + 42, 273);
		selectC[2].setSize(42, 42);
		selectC[3].setLocation(23 + 43 + 42 + 42, 273);
		selectC[3].setSize(42, 42);
		selectC[4].setLocation(23 + 43 + 42 + 42 + 42, 273);
		selectC[4].setSize(42, 42);
		selectC[5].setLocation(23 + 43 + 42 + 42 + 42 + 42, 273);
		selectC[5].setSize(42, 42);
		selectC[6].setLocation(23 + 43 + 42 + 42 + 42 + 42 + 42, 273);
		selectC[6].setSize(42, 42);
		// D 빈슬롯
		selectD[0].setLocation(23, 365); // 자동 반자동 수동
		selectD[0].setSize(43, 42);
		selectD[1].setLocation(23 + 43, 365); // 아래 번호
		selectD[1].setSize(42, 42);
		selectD[2].setLocation(23 + 43 + 42, 365);
		selectD[2].setSize(42, 42);
		selectD[3].setLocation(23 + 43 + 42 + 42, 365);
		selectD[3].setSize(42, 42);
		selectD[4].setLocation(23 + 43 + 42 + 42 + 42, 365);
		selectD[4].setSize(42, 42);
		selectD[5].setLocation(23 + 43 + 42 + 42 + 42 + 42, 365);
		selectD[5].setSize(42, 42);
		selectD[6].setLocation(23 + 43 + 42 + 42 + 42 + 42 + 42, 365);
		selectD[6].setSize(42, 42);
		// E 빈슬롯
		selectE[0].setLocation(23, 456); // 자동 반자동 수동
		selectE[0].setSize(43, 42);
		selectE[1].setLocation(23 + 43, 456); // 아래 번호
		selectE[1].setSize(42, 42);
		selectE[2].setLocation(23 + 43 + 42, 456);
		selectE[2].setSize(42, 42);
		selectE[3].setLocation(23 + 43 + 42 + 42, 456);
		selectE[3].setSize(42, 42);
		selectE[4].setLocation(23 + 43 + 42 + 42 + 42, 456);
		selectE[4].setSize(42, 42);
		selectE[5].setLocation(23 + 43 + 42 + 42 + 42 + 42, 456);
		selectE[5].setSize(42, 42);
		selectE[6].setLocation(23 + 43 + 42 + 42 + 42 + 42 + 42, 456);
		selectE[6].setSize(42, 42);

		// 로또 하러가기
		for (int i = 0; i < selectA.length; i++) {
			selectA[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (LottoTicket1.selectedNumbers.size() == 0) {
						resourceSoundPack.slotPickSound();
						Management.card.show(Management.all, "티켓1");
					}
				}
			});

		}

		for (int i = 0; i < selectB.length; i++) {
			selectB[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (LottoTicket2.selectedNumbers.size() == 0) {
						resourceSoundPack.slotPickSound();
						Management.card.show(Management.all, "티켓2");
					}
				}

			});
		}
		for (int i = 0; i < selectC.length; i++) {
			selectC[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (LottoTicket3.selectedNumbers.size() == 0) {
						resourceSoundPack.slotPickSound();
						Management.card.show(Management.all, "티켓3");
					}
				}

			});
		}
		for (int i = 0; i < selectD.length; i++) {
			selectD[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (LottoTicket4.selectedNumbers.size() == 0) {
						resourceSoundPack.slotPickSound();
						Management.card.show(Management.all, "티켓4");
					}
				}

			});
		}
		for (int i = 0; i < selectE.length; i++) {
			selectE[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (LottoTicket5.selectedNumbers.size() == 0) {
						resourceSoundPack.slotPickSound();
						Management.card.show(Management.all, "티켓5");
					}
				}

			});
		}

		main1.setBounds(0, 0, 340, 550);
		main1.setLayout(null);
		setLayout(null);
		add(main1);
		setVisible(true);
	}

}