import java.awt.CardLayout;
import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class TestA extends JPanel {
	private JLabel[] mainImage;
	private JLabel[] shownum;
	
	JLabel[] MainImage = new JLabel[32];
	JLabel[] SelNum = new JLabel[7];
	JLabel[] labels = CreateMain();
	JLabel[] selectA = SelectTicket();
	JLabel[] selectB = SelectTicket();
	JLabel[] selectC = SelectTicket();
	JLabel[] selectD = SelectTicket();
	JLabel[] selectE = SelectTicket();
	

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


	public TestA() {
		JPanel main1 = new JPanel();
		main1.setBackground(Color.BLACK);

		for (int i = 0; i < labels.length; i++) {
			main1.add(labels[i]);
		}

		labels[1].setLocation(295, 0); // 물음표
		labels[1].setSize(45, 43);
		labels[2].setLocation(295, 43); // 물음표 밑에 칸
		labels[2].setSize(45, 28);
		labels[3].setLocation(0,71); // 왼쪽 사이드
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
		labels[7].setLocation(0, 0); // A자리 빈슬롯
		labels[7].setSize(0, 0);

		// B
		labels[8].setLocation(23,130); // B상단
		labels[8].setSize(295, 33);
		labels[9].setLocation(23,163); // B머리
		labels[9].setSize(272, 17);
		labels[10].setLocation(295,163); // B엑스
		labels[10].setSize(23, 17);
		labels[11].setLocation(0, 0); // B위치 자동
		labels[11].setSize(0, 0);
		labels[12].setLocation(0, 0); // B위치 숫자
		labels[12].setSize(0, 0);

		// C
		labels[13].setLocation(23,222); // C상단
		labels[13].setSize(295, 34);
		labels[14].setLocation(23, 256); // C머리
		labels[14].setSize(272, 17);
		labels[15].setLocation(295,256); // C엑스
		labels[15].setSize(23, 17);
		labels[16].setLocation(0, 0); // C자리 수동
		labels[16].setSize(0, 0);
		labels[17].setLocation(0, 0);
		labels[17].setSize(0, 0);

		// D
		labels[18].setLocation(23,315); // D상단
		labels[18].setSize(295, 33);
		labels[19].setLocation(23, 348); // D머리
		labels[19].setSize(272, 17);
		labels[20].setLocation(295, 348); // D엑스
		labels[20].setSize(23, 17);
		labels[21].setLocation(0, 0); // D자리 반자동
		labels[21].setSize(0, 0);
		labels[22].setLocation(0, 0); // D자리 숫자
		labels[22].setSize(0, 0);

		// E
		labels[23].setLocation(23,407); // E상단
		labels[23].setSize(295, 32);
		labels[24].setLocation(23,439); // E머리
		labels[24].setSize(272, 17);
		labels[25].setLocation(295, 439); // E엑스
		labels[25].setSize(23, 17);
		labels[26].setLocation(0, 0); // E자리 빈슬롯
		labels[26].setSize(0, 0);

		// 하단
		labels[27].setLocation(23, 498); // D슬롯 밑 1
		labels[27].setSize(295, 17);
		labels[28].setLocation(23, 515); // 뒤로가기 버튼
		labels[28].setSize(15, 18);
		labels[29].setLocation(38, 515); // D슬롯 밑 2
		labels[29].setSize(265, 18);
		labels[30].setLocation(303, 515); // 넘어가기 버튼
		labels[30].setSize(15, 18);
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
		selectA[2].setSize(42,42);
		selectA[3].setLocation(23 + 42 + 43 + 42, 88);
		selectA[3].setSize(42, 42);
		selectA[4].setLocation(23 + 42 + 43 + 42 + 42, 88);
		selectA[4].setSize(42, 42);
		selectA[5].setLocation(23 + 42 + 43 + 42 + 42 + 42, 88);
		selectA[5].setSize(42, 42);
		selectA[6].setLocation( + 42 + 43 + 42 + 42 + 42 + 42, 88);
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
					Management.card.show(Management.all, "티켓1");
				}

			});
		}
		for (int i = 0; i < selectB.length; i++) {
			selectB[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Management.card.show(Management.all, "티켓2");
				}

			});
		}
		for (int i = 0; i < selectC.length; i++) {
			selectC[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Management.card.show(Management.all, "티켓3");
				}

			});
		}
		for (int i = 0; i < selectD.length; i++) {
			selectD[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Management.card.show(Management.all, "티켓4");
				}

			});
		}
		for (int i = 0; i < selectE.length; i++) {
			selectE[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Management.card.show(Management.all, "티켓5");
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