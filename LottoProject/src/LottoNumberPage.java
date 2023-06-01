import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//A
class MyNumPnlA extends JPanel {

	private static JLabel myNumLbl1A;
	private static JLabel myNumLbl2A;
	private static JLabel myNumLbl3A;
	private static JLabel myNumLbl4A;
	private static JLabel myNumLbl5A;
	private static JLabel myNumLbl6A;
	private static JLabel autoLblA;

	public static JLabel getMyNumLbl1A() {
		return myNumLbl1A;
	}

	public static JLabel getMyNumLbl2A() {
		return myNumLbl2A;
	}

	public static JLabel getMyNumLbl3A() {
		return myNumLbl3A;
	}

	public static JLabel getMyNumLbl4A() {
		return myNumLbl4A;
	}

	public static JLabel getMyNumLbl5A() {
		return myNumLbl5A;
	}

	public static JLabel getMyNumLbl6A() {
		return myNumLbl6A;
	}

	public static JLabel getAutoLblA() {
		return autoLblA;
	}

	public MyNumPnlA() {
		myNumLbl1A = new JLabel("0");
		myNumLbl2A = new JLabel("0");
		myNumLbl3A = new JLabel("0");
		myNumLbl4A = new JLabel("0");
		myNumLbl5A = new JLabel("0");
		myNumLbl6A = new JLabel("0");
		autoLblA = new JLabel();



		ImageIcon orderBtnA3 = new ImageIcon(getClass().getResource("/image2/번호선택_05.gif"));
		JLabel orderLabelA3 = new JLabel(orderBtnA3);
		orderLabelA3.setBounds(20, 70, orderBtnA3.getIconWidth(), orderBtnA3.getIconHeight());
		
		//슬롯 
		ImageIcon orderBtnA4 = new ImageIcon(getClass().getResource("/image2/번호선택_08.gif"));
		JLabel orderLabelA4 = new JLabel(orderBtnA4);
		orderLabelA4.setBounds(20, 87, orderBtnA4.getIconWidth(), orderBtnA4.getIconHeight());

		ImageIcon orderBtnA5 = new ImageIcon(getClass().getResource("/image2/번호선택_06.gif"));
		JLabel orderLabelA5 = new JLabel(orderBtnA5);
		orderLabelA5.setBounds(292, 70, orderBtnA5.getIconWidth(), orderBtnA5.getIconHeight());

		
		
		//슬롯 연결 이벤트 
		orderLabelA4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new LottoTicket2();
			}
		});

		// 번호 초기화 하는거 추가하기 (X버튼)
		orderLabelA5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

//	    add(orderLabelA2);
		add(orderLabelA5);
		add(orderLabelA3);
		add(orderLabelA4);
		add(myNumLbl1A);
		add(myNumLbl2A);
		add(myNumLbl3A);
		add(myNumLbl4A);
		add(myNumLbl5A);
		add(myNumLbl6A);
		add(autoLblA);

		setLayout(null);
		setVisible(true);
	}
}

// B
class MyNumPnlB extends JPanel {
	private static JLabel myNumLbl1B;
	private static JLabel myNumLbl2B;
	private static JLabel myNumLbl3B;
	private static JLabel myNumLbl4B;
	private static JLabel myNumLbl5B;
	private static JLabel myNumLbl6B;
	private static JLabel autoLblB;

	public static JLabel getMyNumLbl1B() {
		return myNumLbl1B;
	}

	public static JLabel getMyNumLbl2B() {
		return myNumLbl2B;
	}

	public static JLabel getMyNumLbl3B() {
		return myNumLbl3B;
	}

	public static JLabel getMyNumLbl4B() {
		return myNumLbl4B;
	}

	public static JLabel getMyNumLbl5B() {
		return myNumLbl5B;
	}

	public static JLabel getMyNumLbl6B() {
		return myNumLbl6B;
	}

	public static JLabel getAutoLblB() {
		return autoLblB;
	}

	public MyNumPnlB() {
		myNumLbl1B = new JLabel("0");
		myNumLbl2B = new JLabel("0");
		myNumLbl3B = new JLabel("0");
		myNumLbl4B = new JLabel("0");
		myNumLbl5B = new JLabel("0");
		myNumLbl6B = new JLabel("0");
		autoLblB = new JLabel();

		ImageIcon orderBtnB = new ImageIcon(getClass().getResource("/image2/번호선택_09.gif"));
		JLabel orderLabelB = new JLabel(orderBtnB);
		orderLabelB.setBounds(7, 5, orderBtnB.getIconWidth(), orderBtnB.getIconHeight());

		ImageIcon orderBtnB1 = new ImageIcon(getClass().getResource("/image2/번호선택_10.gif"));
		JLabel orderLabelB1 = new JLabel(orderBtnB1);
		orderLabelB1.setBounds(7, 38, orderBtnB1.getIconWidth(), orderBtnB1.getIconHeight());

		ImageIcon orderBtnB2 = new ImageIcon(getClass().getResource("/image2/번호선택_11.gif"));
		JLabel orderLabelB2 = new JLabel(orderBtnB2);
		orderLabelB2.setBounds(279, 38, orderBtnB2.getIconWidth(), orderBtnB2.getIconHeight());
		
		//슬롯
		ImageIcon orderBtnB3 = new ImageIcon(getClass().getResource("/image2/번호선택_08.gif"));
		JLabel orderLabelB3 = new JLabel(orderBtnB3);
		orderLabelB3.setBounds(7, 55, orderBtnB3.getIconWidth(), orderBtnB3.getIconHeight());

		// 슬롯 연결 이벤트
		orderLabelB3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new LottoTicket2();
			}
		});

		// 번호 초기화 하는거 추가하기 (X버튼)
		orderLabelB3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		add(orderLabelB);
		add(orderLabelB1);
		add(orderLabelB2);
		add(orderLabelB3);
		/*
		 * add(myNumLbl1B); 
		 * add(myNumLbl2B); 
		 * add(myNumLbl3B); 
		 * add(myNumLbl4B);
		 * add(myNumLbl5B); 
		 * add(myNumLbl6B); 
		 * add(autoLblB);
		 */

		setLayout(null);
		setVisible(true);
	}
}

// C
class MyNumPnlC extends JPanel {
	private static JLabel myNumLbl1C;
	private static JLabel myNumLbl2C;
	private static JLabel myNumLbl3C;
	private static JLabel myNumLbl4C;
	private static JLabel myNumLbl5C;
	private static JLabel myNumLbl6C;
	private static JLabel autoLblC;

	public static JLabel getMyNumLbl1C() {
		return myNumLbl1C;
	}

	public static JLabel getMyNumLbl2C() {
		return myNumLbl2C;
	}

	public static JLabel getMyNumLbl3C() {
		return myNumLbl3C;
	}

	public static JLabel getMyNumLbl4C() {
		return myNumLbl4C;
	}

	public static JLabel getMyNumLbl5C() {
		return myNumLbl5C;
	}

	public static JLabel getMyNumLbl6C() {
		return myNumLbl6C;
	}

	public static JLabel getAutoLblC() {
		return autoLblC;
	}

	public MyNumPnlC() {
		myNumLbl1C = new JLabel("0");
		myNumLbl2C = new JLabel("0");
		myNumLbl3C = new JLabel("0");
		myNumLbl4C = new JLabel("0");
		myNumLbl5C = new JLabel("0");
		myNumLbl6C = new JLabel("0");
		autoLblC = new JLabel();

		ImageIcon orderBtnC = new ImageIcon(getClass().getResource("/image2/번호선택_14.gif"));
		JLabel orderLabelC = new JLabel(orderBtnC);
		orderLabelC.setBounds(7, 20, orderBtnC.getIconWidth(), orderBtnC.getIconHeight());
		
		//슬롯 
		ImageIcon orderBtnC1 = new ImageIcon(getClass().getResource("/image2/번호선택_08.gif"));
		JLabel orderLabelC1 = new JLabel(orderBtnC1);
		orderLabelC1.setBounds(7, 70, orderBtnC1.getIconWidth(), orderBtnC1.getIconHeight());

		ImageIcon orderBtnC2 = new ImageIcon(getClass().getResource("/image2/번호선택_15.gif"));
		JLabel orderLabelC2 = new JLabel(orderBtnC2);
		orderLabelC2.setBounds(7, 54, orderBtnC2.getIconWidth(), orderBtnC2.getIconHeight());

		ImageIcon orderBtnC3 = new ImageIcon(getClass().getResource("/image2/번호선택_16.gif"));
		JLabel orderLabelC3 = new JLabel(orderBtnC3);
		orderLabelC3.setBounds(279, 54, orderBtnC3.getIconWidth(), orderBtnC3.getIconHeight());
		
		
		// 슬롯 연결 이벤트
		orderLabelC1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new LottoTicket3();
			}
		});
		
		// 엑스 버튼 이벤트 추가 
		orderLabelC3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		
		add(orderLabelC);
		add(orderLabelC1);
		add(orderLabelC2);
		add(orderLabelC3);
/*		add(myNumLbl1C);
		add(myNumLbl2C);
		add(myNumLbl3C);
		add(myNumLbl4C);
		add(myNumLbl5C);
		add(myNumLbl6C);
		add(autoLblC); */

		setLayout(null);
		setVisible(true);
	}
}

// D
class MyNumPnlD extends JPanel {
	private static JLabel myNumLbl1D;
	private static JLabel myNumLbl2D;
	private static JLabel myNumLbl3D;
	private static JLabel myNumLbl4D;
	private static JLabel myNumLbl5D;
	private static JLabel myNumLbl6D;
	private static JLabel autoLblD;

	public static JLabel getMyNumLbl1D() {
		return myNumLbl1D;
	}

	public static JLabel getMyNumLbl2D() {
		return myNumLbl2D;
	}

	public static JLabel getMyNumLbl3D() {
		return myNumLbl3D;
	}

	public static JLabel getMyNumLbl4D() {
		return myNumLbl4D;
	}

	public static JLabel getMyNumLbl5D() {
		return myNumLbl5D;
	}

	public static JLabel getMyNumLbl6D() {
		return myNumLbl6D;
	}

	public static JLabel getAutoLblD() {
		return autoLblD;
	}

	public MyNumPnlD() {
		myNumLbl1D = new JLabel("0");
		myNumLbl2D = new JLabel("0");
		myNumLbl3D = new JLabel("0");
		myNumLbl4D = new JLabel("0");
		myNumLbl5D = new JLabel("0");
		myNumLbl6D = new JLabel("0");
		autoLblD = new JLabel();

		ImageIcon orderBtnD = new ImageIcon(getClass().getResource("/image2/번호선택_19.gif"));
		JLabel orderLabelD = new JLabel(orderBtnD);
		orderLabelD.setBounds(7, 0, orderBtnD.getIconWidth(), orderBtnD.getIconHeight());
		
		ImageIcon orderBtnD1 = new ImageIcon(getClass().getResource("/image2/번호선택_20.gif"));
		JLabel orderLabelD1 = new JLabel(orderBtnD1);
		orderLabelD1.setBounds(7, 33, orderBtnD1.getIconWidth(), orderBtnD1.getIconHeight());
		
		//슬롯
		ImageIcon orderBtnD2 = new ImageIcon(getClass().getResource("/image2/번호선택_08.gif"));
		JLabel orderLabelD2 = new JLabel(orderBtnD2);
		orderLabelD2.setBounds(7, 50, orderBtnD2.getIconWidth(), orderBtnD2.getIconHeight());

		ImageIcon orderBtnD3 = new ImageIcon(getClass().getResource("/image2/번호선택_21.gif"));
		JLabel orderLabelD3 = new JLabel(orderBtnD3);
		orderLabelD3.setBounds(279, 33, orderBtnD3.getIconWidth(), orderBtnD3.getIconHeight());
		
		
		// 슬롯 연결 이벤트 *티켓 4페이지로 고쳐야 됨 
		orderLabelD2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new LottoTicket3();
			}
		});
		
		// X버튼 이벤트 추가  
		orderLabelD3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new LottoTicket3();
			}
		});
		
		
		add(orderLabelD);
		add(orderLabelD1);
		add(orderLabelD2);
		add(orderLabelD3);
/*		add(myNumLbl1D);
		add(myNumLbl2D);
		add(myNumLbl3D);
		add(myNumLbl4D);
		add(myNumLbl5D);
		add(myNumLbl6D);
		add(autoLblD); */
		
		setLayout(null);
		setVisible(true);
	}
}

// E
class MyNumPnlE extends JPanel {
	private static JLabel myNumLbl1E;
	private static JLabel myNumLbl2E;
	private static JLabel myNumLbl3E;
	private static JLabel myNumLbl4E;
	private static JLabel myNumLbl5E;
	private static JLabel myNumLbl6E;
	private static JLabel autoLblE;

	public static JLabel getMyNumLbl1E() {
		return myNumLbl1E;
	}

	public static JLabel getMyNumLbl2E() {
		return myNumLbl2E;
	}

	public static JLabel getMyNumLbl3E() {
		return myNumLbl3E;
	}

	public static JLabel getMyNumLbl4E() {
		return myNumLbl4E;
	}

	public static JLabel getMyNumLbl5E() {
		return myNumLbl5E;
	}

	public static JLabel getMyNumLbl6E() {
		return myNumLbl6E;
	}

	public static JLabel getAutoLblE() {
		return autoLblE;
	}

	public MyNumPnlE() {
		myNumLbl1E = new JLabel("0");
		myNumLbl2E = new JLabel("0");
		myNumLbl3E = new JLabel("0");
		myNumLbl4E = new JLabel("0");
		myNumLbl5E = new JLabel("0");
		myNumLbl6E = new JLabel("0");
		autoLblE = new JLabel();
		
		ImageIcon orderBtnE = new ImageIcon(getClass().getResource("/image2/번호선택_24.gif"));
		JLabel orderLabelE = new JLabel(orderBtnE);
		orderLabelE.setBounds(7, 32, orderBtnE.getIconWidth(), orderBtnE.getIconHeight());
		
		ImageIcon orderBtnE1 = new ImageIcon(getClass().getResource("/image2/번호선택_25.gif"));
		JLabel orderLabelE1 = new JLabel(orderBtnE1);
		orderLabelE1.setBounds(7, 64, orderBtnE1.getIconWidth(), orderBtnE1.getIconHeight());
		
		ImageIcon orderBtnE2 = new ImageIcon(getClass().getResource("/image2/번호선택_26.gif"));
		JLabel orderLabelE2 = new JLabel(orderBtnE2);
		orderLabelE2.setBounds(279, 64, orderBtnE2.getIconWidth(), orderBtnE2.getIconHeight());

		//슬롯
		ImageIcon orderBtnE3 = new ImageIcon(getClass().getResource("/image2/번호선택_27.gif"));
		JLabel orderLabelE3 = new JLabel(orderBtnE3);
		orderLabelE3.setBounds(7, 81, orderBtnE3.getIconWidth(), orderBtnE3.getIconHeight());
	
		ImageIcon orderBtnE4 = new ImageIcon(getClass().getResource("/image2/번호선택_28.gif"));
		JLabel orderLabelE4 = new JLabel(orderBtnE4);
		orderLabelE4.setBounds(7, 123, orderBtnE4.getIconWidth(), orderBtnE4.getIconHeight());

		
	
		// 슬롯 연결 이벤트
		orderLabelE3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new LottoTicket5();
			}
		});
		
		// X버튼 연결 이벤트
		orderLabelE2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});

		
		add(orderLabelE);
		add(orderLabelE1);
		add(orderLabelE2);
		add(orderLabelE3);
		add(orderLabelE4);
/*		add(myNumLbl1E);
		add(myNumLbl2E);
		add(myNumLbl3E);
		add(myNumLbl4E);
		add(myNumLbl5E);
		add(myNumLbl6E);
		add(autoLblE); */
		
		setLayout(null);
		setVisible(true);
		
	}
}

class MyNumPnlF extends JPanel { 
	public MyNumPnlF() {
		
		ImageIcon orderBtnF = new ImageIcon(getClass().getResource("/image2/번호선택_29.gif"));
		JLabel orderLabelF = new JLabel(orderBtnF);
		orderLabelF.setBounds(7, 85, orderBtnF.getIconWidth(), orderBtnF.getIconHeight());
		
		ImageIcon orderBtnF1 = new ImageIcon(getClass().getResource("/image2/번호선택_31.gif"));
		JLabel orderLabelF1 = new JLabel(orderBtnF1);
		orderLabelF1.setBounds(287, 85, orderBtnF1.getIconWidth(), orderBtnF1.getIconHeight());
		
		ImageIcon orderBtnF2 = new ImageIcon(getClass().getResource("/image2/번호선택_30.gif"));
		JLabel orderLabelF2 = new JLabel(orderBtnF2);
		orderLabelF2.setBounds(22, 85, orderBtnF2.getIconWidth(), orderBtnF2.getIconHeight());
		
		ImageIcon orderBtnF3 = new ImageIcon(getClass().getResource("/image2/번호선택_32.gif"));
		JLabel orderLabelF3 = new JLabel(orderBtnF3);
		orderLabelF3.setBounds(7, 100, orderBtnF3.getIconWidth(), orderBtnF3.getIconHeight());
		
		
		// 뒤로가기 연결 
		orderLabelF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		// 다음버튼(번호추첨) 연결 
		orderLabelF1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		
		add(orderLabelF);
		add(orderLabelF1);
		add(orderLabelF2);
		add(orderLabelF3);
		
		setLayout(null);
		setVisible(true);
}
}

class MyNumPnlG extends JPanel { 
	public MyNumPnlG() {
		ImageIcon orderBtnG = new ImageIcon(getClass().getResource("/image2/번호선택_04.gif"));
		JLabel orderLabelG = new JLabel(orderBtnG);
		orderLabelG.setBounds(0, 12, orderBtnG.getIconWidth(), orderBtnG.getIconHeight());
	
		add(orderLabelG);
		
		setLayout(null);
		setVisible(true);
	}
}



class MyNumPnlH extends JPanel { 
	public MyNumPnlH() {
		ImageIcon orderBtnH = new ImageIcon(getClass().getResource("/image2/번호선택_01.gif"));
		JLabel orderLabelH = new JLabel(orderBtnH);
		orderLabelH.setBounds(0, 0, orderBtnH.getIconWidth(), orderBtnH.getIconHeight());
	
		add(orderLabelH);
		
		setLayout(null);
		setVisible(true);
	}
}

class MyNumPnlI extends JPanel { 
	public MyNumPnlI() {
		ImageIcon orderBtnI = new ImageIcon(getClass().getResource("/image2/번호선택_07.gif"));
		JLabel orderLabelI = new JLabel(orderBtnI);
		orderLabelI.setBounds(200, 12, orderBtnI.getIconWidth(), orderBtnI.getIconHeight());
	
		add(orderLabelI);
		
		setLayout(null);
		setVisible(true);
	}
}


//내 번호 보여주는 프레임
public class LottoNumberPage extends JFrame {
	public LottoNumberPage() {
		setLayout(null);

		MyNumPnlA myNumPnlA = new MyNumPnlA();
		MyNumPnlB myNumPnlB = new MyNumPnlB();
		MyNumPnlC myNumPnlC = new MyNumPnlC();
		MyNumPnlD myNumPnlD = new MyNumPnlD();
		MyNumPnlE myNumPnlE = new MyNumPnlE();
		MyNumPnlF myNumPnlF = new MyNumPnlF();
		MyNumPnlG myNumPnlG = new MyNumPnlG();
		MyNumPnlH myNumPnlH = new MyNumPnlH();
		MyNumPnlI myNumPnlI = new MyNumPnlI();
		
		                  //x  y  길이   높이 
		myNumPnlA.setBounds(0, 0, 337, 130);
		myNumPnlB.setBounds(13, 124, 310, 97);
		myNumPnlC.setBounds(13, 202, 310, 112);
		myNumPnlD.setBounds(13, 314, 310, 92);
		myNumPnlE.setBounds(13, 374, 310, 136);
		myNumPnlF.setBounds(13, 425, 310, 295);
		myNumPnlG.setBounds(0, 58, 23, 580); //좌측 
		myNumPnlH.setBounds(0, 0, 310, 70); //상단 
		myNumPnlI.setBounds(200, 200, 23, 580); //상단 
		

		add(myNumPnlH); //상단 A 
		add(myNumPnlG); //좌측 세로 
		add(myNumPnlI); //우측 세로 
		add(myNumPnlA);
		add(myNumPnlB);
		add(myNumPnlC);
		add(myNumPnlD);
		add(myNumPnlE);
		add(myNumPnlF);

		setSize(340, 580);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LottoNumberPage();
	}
}
