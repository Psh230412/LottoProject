
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
/*
 * x 변수에는 (BouncingBall.WIDTH - d) 범위 내에서 임의의 x 좌표를 생성합니다. 이는 공이 x 축에서 이동할 수 있는 범위를 제한합니다. 
 * y 변수에는 (BouncingBall.HEIGHT - d) 범위 내에서 임의의 y 좌표를 생성합니다. 이는 공이 y축에서 이동할 수 있는 범위를 제한합니다.
 * xInc 변수에는 1에서 10 사이의 임의의 값을 설정합니다. 이는 x 축 이동 속도를 나타냅니다. 
 * yInc 변수에도 1에서 10 사이의 임의의 값을 설정합니다. 이는 y 축 이동 속도를 나타냅니다.
 * 
 */

class LotteryBallView extends JPanel{
	Image ball;
	
	int x, y, xInc, yInc, diameter;
	final Random r = new Random();
	

	public LotteryBallView(int d,URL urlOfBall) {
		this.diameter = d;
		x = (int) (Math.random() * (LotteryBall.WIDTH - d) + 3);
		y = (int) (Math.random() * (LotteryBall.HEIGHT - d) + 3);
		xInc = (int) (Math.random() * 5 + 5);
		yInc = (int) (Math.random() * 5 + 5);
		
		ball = new ImageIcon(urlOfBall).getImage();
		
	}

	public void paint(Graphics g) {
		if (x < 0 || x > (LotteryBall.WIDTH - diameter))
			xInc = -xInc;
		if (y < 0 || y > (LotteryBall.HEIGHT - diameter))
			yInc = -yInc;
		x += xInc;
		y += yInc;
		
		g.drawImage(ball, x, y, 42, 42, this);
		
		
	}

}
public class LotteryBall extends JPanel implements ActionListener {
	static final int WIDTH = 279;
	static final int HEIGHT = 280;
	private static final int PERIOD = 30;
	
	URL[] urlOfLotteryBall = new URL[45];
	
	public void creteUrlOfBall() {
		for(int i=0;i<urlOfLotteryBall.length;i++) {
			URL urlOfSN = LotteryBall.class.getClassLoader()
					.getResource("image/selNumber" + " " + "(" + (i + 1) + ")" + ".gif");
			urlOfLotteryBall[i]=urlOfSN;
		}
	}

	class MyPanel extends JPanel {
		@Override
		public void setBackground(Color color) {

			super.setBackground(color);
		}
		public LotteryBallView[] basket = new LotteryBallView[45];
		
		
		public MyPanel() {
			creteUrlOfBall();
			for(int i = 0; i < basket.length; i++) {
				basket[i] = new LotteryBallView((int) (42),urlOfLotteryBall[i]);
			}
			
			
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (LotteryBallView b : basket) {
				b.paint(g);
			}
		}
		
	}
	
	public LotteryBall() {
		
		
		MyPanel panel = new MyPanel();
		//panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		//panel.setLocation(31, 142);
		//panel.setBounds(31, 142, 340, 340);
		
		
		
		add(panel);
		Timer timer = new Timer(PERIOD,this);
		timer.start();
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}
}




