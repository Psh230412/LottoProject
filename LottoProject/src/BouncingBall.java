
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
import javax.swing.JPanel;
import javax.swing.Timer;

class Ball extends JPanel{
	Image ball;
	int x, y, xInc, yInc, diameter,ballColor;
	final Random r = new Random();
	Color color;
	/*
	 * x 변수에는 (BouncingBall.WIDTH - d) 범위 내에서 임의의 x 좌표를 생성합니다. 이는 공이 x 축에서 이동할 수 있는 범위를 제한합니다. 
	 * y 변수에는 (BouncingBall.HEIGHT - d) 범위 내에서 임의의 y 좌표를 생성합니다. 이는 공이 y축에서 이동할 수 있는 범위를 제한합니다.
	 * xInc 변수에는 1에서 10 사이의 임의의 값을 설정합니다. 이는 x 축 이동 속도를 나타냅니다. 
	 * yInc 변수에도 1에서 10 사이의 임의의 값을 설정합니다. 이는 y 축 이동 속도를 나타냅니다.
	 * 
	 */
	public Ball(int d) {
		this.diameter = d;
		x = (int) (Math.random() * (BouncingBall.WIDTH - d) + 3);
		y = (int) (Math.random() * (BouncingBall.HEIGHT - d) + 3);
		xInc = (int) (Math.random() * 10 + 1);
		yInc = (int) (Math.random() * 10 + 1);
		//color = new Color(255, 0, 255);
		URL icon = LottoTicket1.class.getClassLoader().getResource("image/defaultNumber (1).gif");
		ball = new ImageIcon(icon).getImage();
	}

	public void paint(Graphics g) {
		if (x < 0 || x > (BouncingBall.WIDTH - diameter))
			xInc = -xInc;
		if (y < 0 || y > (BouncingBall.HEIGHT - diameter))
			yInc = -yInc;
		x += xInc;
		y += yInc;
		g.drawImage(ball,x,y,diameter,diameter,this);
		//g.setColor(color);
		//g.fillOval(x, y, diameter, diameter);
	}

}
public class BouncingBall extends JFrame implements ActionListener {
	static final int WIDTH = 300;
	static final int HEIGHT = 300;
	private static final int PERIOD = 6;
	
	class MyPanel extends JPanel {
		@Override
		public void setBackground(Color color) {
			// TODO Auto-generated method stub
			super.setBackground(color);
		}
		public Ball basket[] = new Ball[45];
		
		public MyPanel() {
			for(int i = 0; i < 45; i++) {
				basket[i] = new Ball((int) (42));
			}
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for (Ball b : basket) {
				b.paint(g);
			}
		}
		
	}
	public BouncingBall() {
		MyPanel panel = new MyPanel();
		panel.setBackground(new Color(36, 33, 66));
		panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		add(panel);
		pack();
//		setTitle("Bouncing Ball");
		Timer timer = new Timer(PERIOD,this);
		timer.start();
		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}
	public static void main(String[] args) {
		BouncingBall f = new BouncingBall();
	}
}




