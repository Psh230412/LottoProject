import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Management extends JFrame {
	static JPanel all = new JPanel();
	static CardLayout card = new CardLayout();
	public Management() {
		setTitle("로또");
		
		all.setLayout(card);
		
		all.add(new StartPage(), "시작");
		all.add(new LottoNumberPage(), "번호 선택");
		all.add(new LottoTicket1(), "티켓1");
		all.add(new LottoTicket2(), "티켓2");
		all.add(new LottoTicket3(), "티켓3");
		all.add(new LottoTicket4(), "티켓4");
		all.add(new LottoTicket5(), "티켓5");
		all.add(new LotteryBallPage(),"공튀기기");
//		all.add(new LottoDrawPage(), "당첨 번호");

//		card.show(all, "공튀기기");
		add(all);
	
		all.setPreferredSize(new Dimension(340, 550));
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
	}
	
	
	public static void main(String[] args) {
		new Management();
	}
}
