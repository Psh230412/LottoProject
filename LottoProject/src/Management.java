import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Management extends JFrame {
	static JPanel all = new JPanel();
	static CardLayout card = new CardLayout();
	LotteryBall lb =new LotteryBall();
	public Management() {
		setTitle("로또");
		
		lb.setLocation(31, 142);
		
		
		all.setLayout(card);
		
		all.add(new StartPage(), "시작");
		all.add(new LottoNumberPage(), "번호 선택");
		all.add(new LottoTicket1(), "티켓1");
		all.add(new LottoTicket2(), "티켓2");
		all.add(new LottoTicket3(), "티켓3");
		all.add(new LottoTicket4(), "티켓4");
		all.add(new LottoTicket5(), "티켓5");
		all.add(lb,"공튀기기");
//		all.add(new LottoDrawPage(), "당첨 번호");

//		card.show(all, "시작");
		add(all);
		
		setSize(340, 594);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		new Management();
	}
}
