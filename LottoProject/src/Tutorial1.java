import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Tutorial1 extends JFrame {
	private JPanel panel;
	private JLabel label;
	
	public Tutorial1() {
		JPanel panel = new JPanel();
		label = new JLabel();
		ImageIcon icon = new ImageIcon("image5/튜토리얼_1.jpg");
		label.setIcon(icon);
		
		panel.add(label);
		add(panel);
		setSize(340, 550);
		setVisible(true); 
		
	}
	
	public static void main(String[] args) {
		new Tutorial1();
	}
}