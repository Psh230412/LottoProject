import java.awt.CardLayout;
import java.awt.Dimension;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class Management extends JFrame {
	static JPanel all = new JPanel();
	static CardLayout card = new CardLayout();

	public Management() {
		setTitle("로또");

		
		all.setLayout(card);
		
		all.add(new StartPage(), "시작");
		all.add(new TestA(), "번호 선택");
		//all.add(new HelpMessage(), "도움말");
		all.add(new LottoTicket1(), "티켓1");
		all.add(new LottoTicket2(), "티켓2");
		all.add(new LottoTicket3(), "티켓3");
		all.add(new LottoTicket4(), "티켓4");
		all.add(new LottoTicket5(), "티켓5");
		all.add(new LotteryBall(),"공튀기기");
		all.add(new LottoDrawPage(), "당첨 번호");
		
		card.show(all, "당첨 번호");

//		card.show(all, "시작");
		add(all);
	
	
		all.setPreferredSize(new Dimension(340, 550));
		setResizable(false);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		new Management();
	}
}
