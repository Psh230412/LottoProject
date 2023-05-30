import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//�궡 踰덊샇 蹂댁뿬二쇰뒗 �뙣�꼸留뚮뱶�뒗 �겢�옒�뒪
class MyNumPnl extends JPanel {
	private Dimension dimension = new Dimension(50, 50);
	private Font font = new Font("留묒� 怨좊뵓", Font.PLAIN, 20);

	private List<JLabel> myNumLblList;
	
	JButton orderBtn;
	String btnName;
	

	public List<JLabel> getMyNumLblList() {
		return myNumLblList;
	}
	
	

	public MyNumPnl() {
		
	}



	public MyNumPnl(JButton orderBtn,String btnName) {
		myNumLblList = new LinkedList<JLabel>();
		this.orderBtn = orderBtn;
		this.btnName = btnName;
		
		orderBtn=new JButton(btnName);
		
		//JButton orderBtn = new JButton("A");
		JLabel myNumLbl1 = new JLabel("1");
		JLabel myNumLbl2 = new JLabel("2");
		JLabel myNumLbl3 = new JLabel("3");
		JLabel myNumLbl4 = new JLabel("4");
		JLabel myNumLbl5 = new JLabel("5");
		JLabel myNumLbl6 = new JLabel("6");
		JLabel autoLbl = new JLabel("�옄�룞");

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

// �궡 踰덊샇 蹂댁뿬二쇰뒗 �봽�젅�엫
public class LottoNumberPage extends JFrame {
	
	
	public LottoNumberPage() {
		BoxLayout layout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
		setLayout(layout);

		MyNumPnl mnp = new MyNumPnl();
		
		JButton orderBtn1 = new JButton();
		
		orderBtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new LottoTicket1();

			}
		});
		
		
		
		MyNumPnl a = new MyNumPnl(orderBtn1,"A");
		MyNumPnl b = new MyNumPnl();
		MyNumPnl c = new MyNumPnl();
		MyNumPnl d = new MyNumPnl();
		MyNumPnl e = new MyNumPnl();
		
		List<Integer> lt1 = LottoTicket1.selectedNumbers;
		

		//LottoTicket1 lottoTicket1 = new LottoTicket1();
		
		//List<Integer> lt1 = LottoTicket1.selectedNumbers;
		
		List<Integer> selectedNumbers = LottoTicket1.selectedNumbers;
		for (int i = 0; i < selectedNumbers.size(); i++) {
			String s = selectedNumbers.get(i).toString();
			JLabel lbl = a.getMyNumLblList().get(i);
			lbl.setText(s);
		}

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
