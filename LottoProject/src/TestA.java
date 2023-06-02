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

<<<<<<< HEAD
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

=======
>>>>>>> branch 'master' of https://github.com/Psh230412/LottoProject.git
class TestA extends JPanel {
	private JLabel[] mainImage;
	private JLabel[] shownum;
	JLabel[] MainImage = new JLabel[32];
	JLabel[] SelectedNum = new JLabel[7];
	JLabel[] SelNum = new JLabel[7];

	public JLabel[] CreateMain() {
		for (int i = 0; i < MainImage.length; i++) {
			URL urlofCm = TestA.class.getClassLoader().getResource("image2/번호선택_" + (i + 1) + ".gif");
			ImageIcon imageicon = new ImageIcon(urlofCm);
			MainImage[i] = new JLabel(imageicon);
		}
		return MainImage;
	}

	public JLabel[] CreateMain2() {
		for (int i = 0; i < SelectedNum.length; i++) {
			URL urlofNm = TestA.class.getClassLoader().getResource("image2/빈슬롯_" + (i + 1) + ".gif");
			ImageIcon imageicon2 = new ImageIcon(urlofNm);
			SelectedNum[i] = new JLabel(imageicon2);
		}
		return SelectedNum;
	}

	public JLabel[] CreateMain3() {
		for (int i = 0; i < SelNum.length; i++) {
			URL urlofSn = TestA.class.getClassLoader()
					.getResource("image/selNumber" + " " + "(" + (i + 1) + ")" + ".gif");
			ImageIcon imageicon3 = new ImageIcon(urlofSn);
			SelNum[i] = new JLabel(imageicon3);
		}
		return SelNum;
	}

	public TestA() {
		JPanel main1 = new JPanel();
		main1.setBackground(Color.BLACK);
		JLabel[] labels = CreateMain();
		JLabel[] labels2 = CreateMain2();
		JLabel[] labels3 = CreateMain3();

		for (int i = 0; i < labels.length; i++) {
			main1.add(labels[i]);
		}

		labels[1].setLocation(295, 0); // 물음표
		labels[1].setSize(45, 45);
		labels[2].setLocation(294, 44); // 물음표 밑에 칸
		labels[2].setSize(45, 28);
		labels[3].setLocation(0, 72); // 왼쪽 사이드
		labels[3].setSize(22, 479);
		labels[6].setLocation(308, 72); // 오른쪽 사이드
		labels[6].setSize(22, 479);

		// A
		labels[0].setLocation(0, 0); // 상단 A
		labels[0].setSize(294, 72);
		labels[4].setLocation(20, 72); // A머리
		labels[4].setSize(272, 17);
		labels[5].setLocation(290, 72); // A엑스
		labels[5].setSize(23, 17);
		labels[7].setLocation(0, 0); // A자리 빈슬롯
		labels[7].setSize(295, 45);

		// B
		labels[8].setLocation(20, 72 + 45 + 8); // B상단
		labels[8].setSize(295, 45);
		labels[9].setLocation(20, 72 + 45 + 7 + 40); // B머리
		labels[9].setSize(272, 17);
		labels[10].setLocation(290, 72 + 45 + 7 + 40); // B엑스
		labels[10].setSize(23, 17);
		labels[11].setLocation(0, 0); // B위치 자동
		labels[11].setSize(0, 0);
		labels[12].setLocation(0, 0); // B위치 숫자
		labels[12].setSize(0, 0);

		// C
		labels[13].setLocation(20, 72 + 45 + 45 + 45 + 11); // C상단
		labels[13].setSize(295, 45);
		labels[14].setLocation(20, 72 + 45 + 7 + 40 + 45 + 48); // C머리
		labels[14].setSize(272, 17);
		labels[15].setLocation(290, 72 + 45 + 7 + 40 + 45 + 48); // C엑스
		labels[15].setSize(23, 17);
		labels[16].setLocation(0, 0); // C자리 수동
		labels[16].setSize(0, 0);
		labels[17].setLocation(0, 0);
		labels[17].setSize(0, 0);

		// D
		labels[18].setLocation(20, 72 + 45 + 45 + 45 + 45 + 45 + 13); // D상단
		labels[18].setSize(295, 45);
		labels[19].setLocation(20, 72 + 45 + 7 + 40 + 45 + 45 + 45 + 45 + 5); // D머리
		labels[19].setSize(272, 17);
		labels[20].setLocation(290, 72 + 45 + 7 + 40 + 45 + 45 + 45 + 45 + 5); // D엑스
		labels[20].setSize(23, 17);
		labels[21].setLocation(0, 0); // D자리 반자동
		labels[21].setSize(295, 45);
		labels[22].setLocation(0, 0); // D자리 숫자
		labels[22].setSize(295, 45);

		// E
		labels[23].setLocation(20, 72 + 45 + 45 + 45 + 45 + 45 + 45 + 45 + 15); // E상단
		labels[23].setSize(295, 45);
		labels[24].setLocation(20, 72 + 45 + 7 + 40 + 45 + 45 + 45 + 45 + 45 + 45 + 6); // E머리
		labels[24].setSize(272, 17);
		labels[25].setLocation(290, 72 + 45 + 7 + 40 + 45 + 45 + 45 + 45 + 45 + 45 + 6); // E엑스
		labels[25].setSize(23, 17);
		labels[26].setLocation(0, 0); // E자리 빈슬롯
		labels[26].setSize(285, 45);

		// 하단
		labels[27].setLocation(20, 72 + 45 + 45 + 45 + 45 + 45 + 45 + 45 + 45 + 45 + 22); // D슬롯 밑 1
		labels[27].setSize(295, 17);
		labels[28].setLocation(20, 72 + 45 + 45 + 45 + 45 + 45 + 45 + 45 + 45 + 45 + 45); // 뒤로가기 버튼
		labels[28].setSize(15, 18);
		labels[29].setLocation(35, 72 + 45 + 45 + 45 + 45 + 45 + 45 + 45 + 45 + 45 + 22 + 15); // D슬롯 밑 2
		labels[29].setSize(265, 18);
		labels[30].setLocation(300, 72 + 45 + 45 + 45 + 45 + 45 + 45 + 45 + 45 + 45 + 45); // 넘어가기 버튼
		labels[30].setSize(15, 18);
		labels[31].setLocation(20, 72 + 45 + 45 + 45 + 45 + 45 + 45 + 45 + 45 + 45 + 22 + 15 + 17); // 맨 밑에
		labels[31].setSize(295, 17);

		for (int i = 0; i < labels2.length; i++) {
			main1.add(labels2[i]);
		}

		// A 빈슬롯
		labels2[0].setLocation(15, 90);
		labels2[0].setSize(43, 42);
		labels2[1].setLocation(15 + 42, 90);
		labels2[1].setSize(43, 42);
		labels2[2].setLocation(15 + 40 + 43, 90);
		labels2[2].setSize(43, 42);
		labels2[3].setLocation(15 + 40 + 43 + 42, 90);
		labels2[3].setSize(43, 42);
		labels2[4].setLocation(15 + 40 + 43 + 43  + 41, 90);
		labels2[4].setSize(43, 42);
		labels2[5].setLocation(15 + 40 + 43 + 43 + 43 + 40, 90);
		labels2[5].setSize(43, 42);
		labels2[6].setLocation(15 + 40 + 43 + 43 + 43 + 43 + 39, 90);
		labels2[6].setSize(43, 42);

		// 로또 하러가기
		labels2[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
<<<<<<< HEAD
				Management.card.show(Management.all, "티켓1");
				
=======
				Management.card.show(Management.all, "티켓2");
>>>>>>> branch 'master' of https://github.com/Psh230412/LottoProject.git
			}
		});
		
	
<<<<<<< HEAD

    
=======
	
		
		
		
>>>>>>> branch 'master' of https://github.com/Psh230412/LottoProject.git
		main1.setBounds(0, 0, 340, 550);
		main1.setLayout(null);
		setLayout(null);
		add(main1);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TestA();

	}
}