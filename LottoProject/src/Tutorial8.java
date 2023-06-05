import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Tutorial8 extends JFrame {
	private JPanel panel;
	private JLabel label;
	
	public Tutorial8() {
		setTitle("로또 튜토리얼");
		JPanel panel = new JPanel();
		label = new JLabel();
		ImageIcon icon = new ImageIcon("LottoProject/src/image5/튜토리얼_10.jpg");
		label.setIcon(icon);
		label.addMouseListener((MouseListener) new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			new StartPage();
			dispose();
		}
		});
		
		
		panel.add(label);
		add(panel);
		setSize(340, 550);
		setVisible(true); 
		setResizable(false);
		pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		Tutorial8 t = new Tutorial8();
	}
}