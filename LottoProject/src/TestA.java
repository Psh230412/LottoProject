import java.awt.Color;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class TestA extends JFrame {
	private JLabel[] mainImage;
	JLabel[] MainImage = new JLabel[32];

	public JLabel[] CreateMain() {
		for (int i = 0; i < MainImage.length; i++) {
			URL urlofCm = TestA.class.getClassLoader().getResource("image2/번호선택_" + (i + 1) + ".gif");
			ImageIcon imageicon = new ImageIcon(urlofCm);
			MainImage[i] = new JLabel(imageicon);
		}
		return MainImage;
	}

	public TestA() {
		JPanel main1 = new JPanel();
		main1.setLayout(null);
		main1.setBackground(Color.BLACK);
		JLabel[] labels = CreateMain();
		
		for (int i = 0; i < labels.length; i++) {
			main1.add(labels[i]);
		}
		
		labels[1].setLocation(295, 0); //물음표
		labels[1].setSize(45, 45);
		labels[2].setLocation(294, 44); //물음표 밑에 칸 
		labels[2].setSize(45, 28);
		labels[3].setLocation(8, 72); // 왼쪽 사이드 
		labels[3].setSize(22, 479);
		labels[6].setLocation(323, 72); // 오른쪽 사이드 
		labels[6].setSize(22, 479);
		
		labels[0].setLocation(0, 0); //상단 A 
		labels[0].setSize(294, 72); 
		labels[4].setLocation(30, 72); //A머리 
		labels[4].setSize(272, 17);
		labels[5].setLocation(300, 72); //A엑스 
		labels[5].setSize(23, 17);
		labels[7].setLocation(0, 0); // A자리 빈슬롯 
		labels[7].setSize(295, 45);
		
		labels[8].setLocation(30, 72+45+8); //B상단 
		labels[8].setSize(295, 45);  
		labels[9].setLocation(30,72+45+7+40); //B머리 
		labels[9].setSize(272, 17);  
		labels[10].setLocation(300,72+45+7+40); //B엑스 
		labels[10].setSize(23, 17);
		labels[11].setLocation(0, 0); //B위치 자동 
		labels[11].setSize(295, 45); 
		labels[12].setLocation(0, 0); //B위치 숫자
		labels[12].setSize(295, 45);
		
		labels[13].setLocation(30, 72+45+45+45+11); //C상단 
		labels[13].setSize(295, 45);
		labels[14].setLocation(30, 72+45+7+40+45+48); //C머리
		labels[14].setSize(272, 17);
		labels[15].setLocation(300, 72+45+7+40+45+48); //C엑스 
		labels[15].setSize(23, 17);
		labels[16].setLocation(0, 0); //C자리 수동 
		labels[16].setSize(295, 45);
		labels[17].setLocation(0, 0);
		labels[17].setSize(295, 45);
		
		labels[18].setLocation(30, 72+45+45+45+45+45+13); //D상단 
		labels[18].setSize(295, 45);
		labels[19].setLocation(30, 72+45+7+40+45+45+45+45+5); //D머리 
		labels[19].setSize(272, 17);
		labels[20].setLocation(300, 72+45+7+40+45+45+45+45+5); //D엑스
		labels[20].setSize(23, 17);
		labels[21].setLocation(0, 0); //D자리 반자동
		labels[21].setSize(295, 45); 
		labels[22].setLocation(0, 0); //D자리 숫자 
		labels[22].setSize(295, 45);
		
		labels[23].setLocation(30, 72+45+45+45+45+45+45+45+15); //E상단
		labels[23].setSize(295, 45);
		labels[24].setLocation(30, 72+45+7+40+45+45+45+45+45+45+6); //E머리
		labels[24].setSize(272, 17);
		labels[25].setLocation(300, 72+45+7+40+45+45+45+45+45+45+6); //E엑스
		labels[25].setSize(23, 17);
		labels[26].setLocation(0, 0); //E자리 빈슬롯
		labels[26].setSize(295, 45);
		
		//하단 
		labels[27].setLocation(30, 72+45+45+45+45+45+45+45+45+45+22); //D슬롯 밑 1
		labels[27].setSize(295, 17);
		labels[28].setLocation(30, 72+45+45+45+45+45+45+45+45+45+42); //뒤로가기 버튼
		labels[28].setSize(15, 18);
		labels[29].setLocation(40, 72+45+45+45+45+45+45+45+45+45+22+15); //D슬롯 밑 2
		labels[29].setSize(265, 18);
		labels[30].setLocation(310, 72+45+45+45+45+45+45+45+45+45+42); //넘어가기 버튼 
		labels[30].setSize(15, 18);
		labels[31].setLocation(30, 72+45+45+45+45+45+45+45+45+45+22+15+18); //맨 밑에 
		labels[31].setSize(295, 17);
	
	
	
		add(main1);
		setSize(340, 550);
		main1.setBounds(0, 0, 370, 550);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new TestA();

	}
}
