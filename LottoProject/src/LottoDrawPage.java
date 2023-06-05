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

public class LottoDrawPage extends JPanel {
	
	JLabel[] numArrA = makeNumLbl();
	JLabel[] numArrB = makeNumLbl();
	JLabel[] numArrC = makeNumLbl();
	JLabel[] numArrD = makeNumLbl();
	JLabel[] numArrE = makeNumLbl();
	JLabel[] drawNumArr = makeDrawNumLbl();
	JLabel[] screenArr = new JLabel[14];
	Management management;
	
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
		for (int i = 0; i < screenArr.length; i++) {
			URL screen = LottoDrawPage.class.getClassLoader().getResource("image4/결과확인" + (i + 1) + ".gif");
			ImageIcon imageIcon = new ImageIcon(screen);
			screenArr[i] = new JLabel(imageIcon);
		}
		return screenArr;
	}
	
	public LottoDrawPage(Management management) {
		// 선택번호 라벨 배열
		for (int i = 0; i < numArrA.length; i++) {
			add(numArrA[i]);
		}
		numArrA[0].setBounds(0, 200, 43, 42);
		numArrA[1].setBounds(43, 200, 42, 42);
		numArrA[2].setBounds(43+42, 200, 42, 42);
		numArrA[3].setBounds(43+42+42 , 200, 42, 42);
		numArrA[4].setBounds(43+42+42+42, 200, 42, 42);
		numArrA[5].setBounds(43+42+42+42+42, 200, 42, 42);
		numArrA[6].setBounds(43+42+42+42+42+42, 200, 42, 42);
		numArrA[7].setBounds(43+42+42+42+42+42+42, 200, 45, 42);
		for (int i = 0; i < numArrB.length; i++) {
			add(numArrB[i]);
		}
		numArrB[0].setBounds(0, 200+67, 43, 42);
		numArrB[1].setBounds(43, 200+67, 42, 42);
		numArrB[2].setBounds(43+42, 200+67, 42, 42);
		numArrB[3].setBounds(43+42+42 , 200+67, 42, 42);
		numArrB[4].setBounds(43+42+42+42, 200+67, 42, 42);
		numArrB[5].setBounds(43+42+42+42+42, 200+67, 42, 42);
		numArrB[6].setBounds(43+42+42+42+42+42, 200+67, 42, 42);
		numArrB[7].setBounds(43+42+42+42+42+42+42, 200+67, 45, 42);
		for (int i = 0; i < numArrC.length; i++) {
			add(numArrC[i]);
		}
		numArrC[0].setBounds(0, 200+67+67, 43, 42);
		numArrC[1].setBounds(43, 200+67+67, 42, 42);
		numArrC[2].setBounds(43+42, 200+67+67, 42, 42);
		numArrC[3].setBounds(43+42+42 , 200+67+67, 42, 42);
		numArrC[4].setBounds(43+42+42+42, 200+67+67, 42, 42);
		numArrC[5].setBounds(43+42+42+42+42, 200+67+67, 42, 42);
		numArrC[6].setBounds(43+42+42+42+42+42, 200+67+67, 42, 42);
		numArrC[7].setBounds(43+42+42+42+42+42+42, 200+67+67, 45, 42);
		for (int i = 0; i < numArrD.length; i++) {
			add(numArrD[i]);
		}
		numArrD[0].setBounds(0, 200+67+67+67, 43, 42);
		numArrD[1].setBounds(43, 200+67+67+67, 42, 42);
		numArrD[2].setBounds(43+42, 200+67+67+67, 42, 42);
		numArrD[3].setBounds(43+42+42 , 200+67+67+67, 42, 42);
		numArrD[4].setBounds(43+42+42+42, 200+67+67+67, 42, 42);
		numArrD[5].setBounds(43+42+42+42+42, 200+67+67+67, 42, 42);
		numArrD[6].setBounds(43+42+42+42+42+42, 200+67+67+67, 42, 42);
		numArrD[7].setBounds(43+42+42+42+42+42+42, 200+67+67+67, 45, 42);
		for (int i = 0; i < numArrE.length; i++) {
			add(numArrE[i]);
		}
		numArrE[0].setBounds(0, 200+67+67+67+67, 43, 42);
		numArrE[1].setBounds(43, 200+67+67+67+67, 42, 42);
		numArrE[2].setBounds(43+42, 200+67+67+67+67, 42, 42);
		numArrE[3].setBounds(43+42+42 , 200+67+67+67+67, 42, 42);
		numArrE[4].setBounds(43+42+42+42, 200+67+67+67+67, 42, 42);
		numArrE[5].setBounds(43+42+42+42+42, 200+67+67+67+67, 42, 42);
		numArrE[6].setBounds(43+42+42+42+42+42, 200+67+67+67+67, 42, 42);
		numArrE[7].setBounds(43+42+42+42+42+42+42, 200+67+67+67+67, 45, 42);

		// 당첨 번호 라벨
		for (int i = 0; i < drawNumArr.length; i++) {
			add(drawNumArr[i]);
		}
		drawNumArr[0].setBounds(15, 133, 42, 42);
		drawNumArr[1].setBounds(15+(42*1), 133, 42, 42);
		drawNumArr[2].setBounds(15+(42*2), 133, 42, 42);
		drawNumArr[3].setBounds(15+(42*3), 133, 42, 42);
		drawNumArr[4].setBounds(15+(42*4), 133, 42, 42);
		drawNumArr[5].setBounds(15+(42*5), 133, 42, 42);
		drawNumArr[6].setBounds(15+(42*6)+17, 133, 42, 42);

		// 기본 배경 드로우이미지수정
		JLabel[] lbl = makeScreen();
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
			add(lbl[i]);
		}

		// 메인으로 가는 버튼
		JLabel btn = lbl[12];
		btn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				management.close();
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