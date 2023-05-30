import java.awt.Dimension;
import java.awt.Font;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//내 번호 보여주는 패널만드는 클래스
class MyNumPnl extends JPanel {
	private Dimension dimension = new Dimension(50, 50);
	private Font font = new Font("맑은 고딕", Font.PLAIN, 20);

	private List<JLabel> myNumLblList;

	public List<JLabel> getMyNumLblList() {
		return myNumLblList;
	}
	
	public MyNumPnl() {
		myNumLblList = new LinkedList<JLabel>();
		JButton orderBtn = new JButton("A");
		JLabel myNumLbl1 = new JLabel("1");
		JLabel myNumLbl2 = new JLabel("2");
		JLabel myNumLbl3 = new JLabel("3");
		JLabel myNumLbl4 = new JLabel("4");
		JLabel myNumLbl5 = new JLabel("5");
		JLabel myNumLbl6 = new JLabel("6");
		JLabel autoLbl = new JLabel("자동");

		myNumLblList.add(myNumLbl1);
		myNumLblList.add(myNumLbl2);
		myNumLblList.add(myNumLbl3);
		myNumLblList.add(myNumLbl4);
		myNumLblList.add(myNumLbl5);
		myNumLblList.add(myNumLbl6);
		myNumLblList.add(autoLbl);

		for (int i = 0; i < myNumLblList.size(); i++) {
			JLabel lbl = myNumLblList.get(i);
			lbl.setPreferredSize(dimension);
			lbl.setFont(font);
		}
		orderBtn.setPreferredSize(dimension);
		orderBtn.setFont(font);

		add(orderBtn);
		add(myNumLbl1);
		add(myNumLbl2);
		add(myNumLbl3);
		add(myNumLbl4);
		add(myNumLbl5);
		add(myNumLbl6);
		add(autoLbl);
	}
}

// 내 번호 보여주는 프레임
public class LottoNumberPage extends JFrame {
	public LottoNumberPage() {
		BoxLayout layout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
		setLayout(layout);

		MyNumPnl a = new MyNumPnl();
		MyNumPnl b = new MyNumPnl();
		MyNumPnl c = new MyNumPnl();
		MyNumPnl d = new MyNumPnl();
		MyNumPnl e = new MyNumPnl();
		
		List<Integer> lt1 = LottoTicket1.selectedNumbers;
		
		add(a);
		add(b);
		add(c);
		add(d);
		add(e);

		setSize(500, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		new LottoNumberPage();
	}

}
