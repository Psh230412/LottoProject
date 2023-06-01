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
		
		ImageIcon orderBtnA = new ImageIcon(getClass().getResource("/image2/번호선택_01.gif"));
	    JLabel orderLabelA = new JLabel(orderBtnA);
	    orderLabelA.setBounds(0, 0, orderBtnA.getIconWidth(), orderBtnA.getIconHeight());
	    
	    ImageIcon orderBtnA2 = new ImageIcon(getClass().getResource("/image2/번호선택_04.gif"));
	    JLabel orderLabelA2 = new JLabel(orderBtnA2);
	    orderLabelA2.setBounds(0, 70, orderBtnA2.getIconWidth(), orderBtnA2.getIconHeight());
	    
	    ImageIcon orderBtnA3 = new ImageIcon(getClass().getResource("/image2/번호선택_05.gif"));
	    JLabel orderLabelA3 = new JLabel(orderBtnA3);
	    orderLabelA3.setBounds(10, 70, orderBtnA3.getIconWidth(), orderBtnA3.getIconHeight());
	    
	    ImageIcon orderBtnA4 = new ImageIcon(getClass().getResource("/image2/번호선택_08.gif"));
	    JLabel orderLabelA4 = new JLabel(orderBtnA4);
	    orderLabelA4.setBounds(10, 87, orderBtnA4.getIconWidth(), orderBtnA4.getIconHeight());
	    
	    ImageIcon orderBtnA5 = new ImageIcon(getClass().getResource("/image2/번호선택_06.gif"));
	    JLabel orderLabelA5 = new JLabel(orderBtnA5);
	    orderLabelA5.setBounds(282, 70, orderBtnA5.getIconWidth(), orderBtnA5.getIconHeight()); 
	    
	 

	    orderLabelA4.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	        	Management.card.show(Management.all, "티켓1");
	        }
	    });
	    
	    
	    orderLabelA5.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	        	//번호 초기화 하는거  추가하기 (X버튼) 
	        }
	    });
	    
	    
	    add(orderLabelA);
	    add(orderLabelA2);
	    add(orderLabelA3);
	    add(orderLabelA4);
	    add(orderLabelA5);
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
		JButton orderBtnB = new JButton("B");
		myNumLbl1B = new JLabel("0");
		myNumLbl2B = new JLabel("0");
		myNumLbl3B = new JLabel("0");
		myNumLbl4B = new JLabel("0");
		myNumLbl5B = new JLabel("0");
		myNumLbl6B = new JLabel("0");
		autoLblB = new JLabel();

		orderBtnB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LottoTicket2();
			}
		});

		add(orderBtnB);
		add(myNumLbl1B);
		add(myNumLbl2B);
		add(myNumLbl3B);
		add(myNumLbl4B);
		add(myNumLbl5B);
		add(myNumLbl6B);
		add(autoLblB);
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
		JButton orderBtnC = new JButton("C");
		myNumLbl1C = new JLabel("0");
		myNumLbl2C = new JLabel("0");
		myNumLbl3C = new JLabel("0");
		myNumLbl4C = new JLabel("0");
		myNumLbl5C = new JLabel("0");
		myNumLbl6C = new JLabel("0");
		autoLblC = new JLabel();

		orderBtnC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LottoTicket3();
			}
		});

		add(orderBtnC);
		add(myNumLbl1C);
		add(myNumLbl2C);
		add(myNumLbl3C);
		add(myNumLbl4C);
		add(myNumLbl5C);
		add(myNumLbl6C);
		add(autoLblC);
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
		JButton orderBtnD = new JButton("D");
		myNumLbl1D = new JLabel("0");
		myNumLbl2D = new JLabel("0");
		myNumLbl3D = new JLabel("0");
		myNumLbl4D = new JLabel("0");
		myNumLbl5D = new JLabel("0");
		myNumLbl6D = new JLabel("0");
		autoLblD = new JLabel();

		orderBtnD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LottoTicket4();
			}
		});

		add(orderBtnD);
		add(myNumLbl1D);
		add(myNumLbl2D);
		add(myNumLbl3D);
		add(myNumLbl4D);
		add(myNumLbl5D);
		add(myNumLbl6D);
		add(autoLblD);
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
		JButton orderBtnE = new JButton("E");
		myNumLbl1E = new JLabel("0");
		myNumLbl2E = new JLabel("0");
		myNumLbl3E = new JLabel("0");
		myNumLbl4E = new JLabel("0");
		myNumLbl5E = new JLabel("0");
		myNumLbl6E = new JLabel("0");
		autoLblE = new JLabel();

		orderBtnE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LottoTicket5();
			}
		});


		add(orderBtnE);
		add(myNumLbl1E);
		add(myNumLbl2E);
		add(myNumLbl3E);
		add(myNumLbl4E);
		add(myNumLbl5E);
		add(myNumLbl6E);
		add(autoLblE); 
	}
} 

//내 번호 보여주는 프레임
public class LottoNumberPage extends JPanel {
	public LottoNumberPage() {
		BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(layout);
		
		JButton nextBtn = new JButton("다음");
		nextBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Management.card.show(Management.all, "당첨 번호");
				
			}
		});

		add(new MyNumPnlA());
//		add(new MyNumPnlB());
//		add(new MyNumPnlC());
//		add(new MyNumPnlD());
//		add(new MyNumPnlE());
//		add(nextBtn);
		

		setSize(340, 583);
//		setResizable(false);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LottoNumberPage();
	}

}