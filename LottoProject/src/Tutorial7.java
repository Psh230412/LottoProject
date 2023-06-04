import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Tutorial7 extends JFrame {
	private JPanel panel;
	private JLabel label;
	
	public Tutorial7() {
		setTitle("로또 튜토리얼");
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		//배경 
		label = new JLabel();
		ImageIcon icon = new ImageIcon("LottoProject/src/image5/튜토리얼_8.jpg");
		label.setIcon(icon);
		label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); 
		
		//빈슬롯 버튼 
		JButton b1 = new JButton();
		ImageIcon icon2 = new ImageIcon("LottoProject/src/image5/튜토리얼_9.jpg");
		b1.setIcon(icon2);
		b1.setBounds(12, 86, icon2.getIconWidth(), icon2.getIconHeight());
		
		b1.addMouseListener((MouseListener) new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			new Tutorial8();
			dispose();
			
		}
		});
		
		
		panel.add(label);
		panel.add(b1);
		add(panel);
		setSize(340, 550);
		setVisible(true); 
		setResizable(false);
	//	pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Tutorial7 t = new Tutorial7();
	}
}