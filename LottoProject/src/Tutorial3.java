import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Tutorial3 extends JFrame {
	private JPanel panel;
	private JLabel label;
	
	public Tutorial3() {
		setTitle("로또 튜토리얼");
		JPanel panel = new JPanel();
		label = new JLabel();
		ImageIcon icon = new ImageIcon("LottoProject/src/image5/튜토리얼_3.jpg");
		label.setIcon(icon);
		label.addMouseListener((MouseListener) new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			new Tutorial4();
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
		Tutorial3 t = new Tutorial3();
	}
}