import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Tutorial4 extends JFrame {
	private JPanel panel;
	private JLabel label;
	
	public Tutorial4() {
		setTitle("로또 튜토리얼");
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		//배경 
		label = new JLabel();
		ImageIcon icon = new ImageIcon("LottoProject/src/image5/튜토리얼_4.jpg");
		label.setIcon(icon);
		label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); 
		
		//로또 하러가기 버튼 
		JButton b1 = new JButton();
		ImageIcon icon2 = new ImageIcon("LottoProject/src/image5/튜토리얼_5.jpg");
		b1.setIcon(icon2);
		b1.setBounds(85, 430, icon2.getIconWidth(), icon2.getIconHeight());
		
		b1.addMouseListener((MouseListener) new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			new Tutorial5();
			dispose();
		}
		});
		
		
	    panel.add(label);
	    panel.add(b1);
		add(panel);
		setSize(340, 550);
		setVisible(true);
		setResizable(false);
	//	pack(); 왜 에러 뜸? 
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		Tutorial4 t = new Tutorial4();
	}
}