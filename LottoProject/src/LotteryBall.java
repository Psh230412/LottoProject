
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.ImageIcon;
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
	private static final int PERIOD = 20;
	URL[] urlOfLotteryBall = new URL[45];
	Timer timer;
	Map<Integer,URL> lottoNumber = new HashMap<>();
	public void createUrlOfBall() {
		for(int i=0;i<urlOfLotteryBall.length;i++) {
			URL urlOfSN = LotteryBall.class.getClassLoader()
					.getResource("image/selNumber" + " " + "(" + (i + 1) + ")" + ".gif");
			urlOfLotteryBall[i]=urlOfSN;
		}
	}
	class MyPanel extends JPanel {
		public LotteryBallView[] basket = new LotteryBallView[45];

		public MyPanel() {
			createUrlOfBall();
			for(int i = 0; i < basket.length; i++) {
				basket[i] = new LotteryBallView((int) (42),urlOfLotteryBall[i]);
				if(basket[i].x<=200 && basket[i].x>=130 && basket[i].y <= 280 && basket[i].y <= 230) {
					if(lottoNumber.size() <= 6) {
					lottoNumber.put(i+1,urlOfLotteryBall[i]);
					System.out.println(lottoNumber);
					}
				}
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
		setLayout(null);
		
		setBackground(new Color(255, 0, 0));//여기 색을 바꾸시면 됩니다.
		
		MyPanel panel = new MyPanel();
		panel.setBackground(Color.BLACK);
		panel.setOpaque(true);
		panel.setBounds(31, 142, 279, 280);
		
		add(panel);

		JLabel[] ani = new JLabel[9];
		
		for(int i=0;i<ani.length;i++) {
			URL urlOfAni = LotteryBall.class.getClassLoader().getResource("image/애니메이션_" + (i + 2) + ".gif");
			ImageIcon imageIcon = new ImageIcon(urlOfAni);
			ani[i] = new JLabel(imageIcon);
		}
		ani[0].setBounds(0, 0, 340, 142);
		ani[1].setBounds(0,142,31,280);
		ani[2].setBounds(310, 142, 30, 280);
		ani[3].setBounds(0,422,340,97); // 공 나오는 곳
		ani[4].setBounds(0, 519, 24, 36);
		ani[5].setBounds(304,519,15,18);
		ani[6].setBounds(319, 519, 21, 36);
		ani[7].setBounds(24,537,15,18);
		ani[8].setBounds(304, 537, 15, 18);
		
		for(int i=0;i<ani.length;i++) {
			add(ani[i]);
		}
		
		for (URL key : lottoNumber.values()) {
			ImageIcon imageOfBall = new ImageIcon(key);
			JLabel LabelOfBall = new JLabel(imageOfBall);
			LabelOfBall.setBounds(149, 512, 42, 42);
			add(LabelOfBall);
			
		}
		timer = new Timer(PERIOD, this);
		
	}
	public void startAnimation() {
		timer.start();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}
}




