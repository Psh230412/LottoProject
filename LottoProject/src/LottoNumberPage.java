import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//내 번호 보여주는 패널만드는 클래스
class MyNumPnlA extends JPanel {
	private JLabel myNumLbl1A;
	private JLabel myNumLbl2A;
	private JLabel myNumLbl3A;
	private JLabel myNumLbl4A;
	private JLabel myNumLbl5A;
	private JLabel myNumLbl6A;
	private JLabel autoLblA;

	// A
	public MyNumPnlA() {	
		
		JButton orderBtnA = new JButton("A");
		myNumLbl1A = new JLabel("0");
		myNumLbl2A = new JLabel("0");
		myNumLbl3A = new JLabel("0");
		myNumLbl4A = new JLabel("0");
		myNumLbl5A = new JLabel("0");
		myNumLbl6A = new JLabel("0");
		autoLblA = new JLabel("자동");
		
		orderBtnA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LottoTicket1();
			}
		});

		add(orderBtnA);
		add(myNumLbl1A);
		add(myNumLbl2A);
		add(myNumLbl3A);
		add(myNumLbl4A);
		add(myNumLbl5A);
		add(myNumLbl6A);
		add(autoLblA);
	}
}

// B
class MyNumPnlB extends JPanel {
	public MyNumPnlB() {
		JButton orderBtnB = new JButton("B");
		JLabel myNumLbl1B = new JLabel("0");
		JLabel myNumLbl2B = new JLabel("0");
		JLabel myNumLbl3B = new JLabel("0");
		JLabel myNumLbl4B = new JLabel("0");
		JLabel myNumLbl5B = new JLabel("0");
		JLabel myNumLbl6B = new JLabel("0");
		JLabel autoLblB = new JLabel("자동");

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
	public MyNumPnlC() {
		JButton orderBtnC = new JButton("C");
		JLabel myNumLbl1C = new JLabel("0");
		JLabel myNumLbl2C = new JLabel("0");
		JLabel myNumLbl3C = new JLabel("0");
		JLabel myNumLbl4C = new JLabel("0");
		JLabel myNumLbl5C = new JLabel("0");
		JLabel myNumLbl6C = new JLabel("0");
		JLabel autoLblC = new JLabel("자동");

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
	public MyNumPnlD() {
		JButton orderBtnD = new JButton("D");
		JLabel myNumLbl1D = new JLabel("0");
		JLabel myNumLbl2D = new JLabel("0");
		JLabel myNumLbl3D = new JLabel("0");
		JLabel myNumLbl4D = new JLabel("0");
		JLabel myNumLbl5D = new JLabel("0");
		JLabel myNumLbl6D = new JLabel("0");
		JLabel autoLblD = new JLabel("자동");

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
	public MyNumPnlE() {
		JButton orderBtnE = new JButton("E");
		JLabel myNumLbl1E = new JLabel("0");
		JLabel myNumLbl2E = new JLabel("0");
		JLabel myNumLbl3E = new JLabel("0");
		JLabel myNumLbl4E = new JLabel("0");
		JLabel myNumLbl5E = new JLabel("0");
		JLabel myNumLbl6E = new JLabel("0");
		JLabel autoLblE = new JLabel("자동");

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
public class LottoNumberPage extends JFrame {
	public LottoNumberPage() {
		BoxLayout layout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
		setLayout(layout);

		add(new MyNumPnlA());
		add(new MyNumPnlB());
		add(new MyNumPnlC());
		add(new MyNumPnlD());
		add(new MyNumPnlE());

		setSize(500, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LottoNumberPage();
	}

}
