import java.awt.Color;

import javax.swing.JPanel;


public class LotteryBallPage extends JPanel{
	LotteryBall ball = new LotteryBall();
	JPanel big;
	public LotteryBallPage() {
	
		big = new JPanel();
		big.setLayout(null);
		big.setBackground(Color.BLACK);
		big.setBounds(0, 0, 340, 550);
		
		JPanel inside = new JPanel();
		inside.setBounds(31,142, 279, 280);
		inside.add(ball);
		big.add(inside);
		
		add(big);
		
		
	}
	
	
}
