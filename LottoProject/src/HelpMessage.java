import java.awt.BorderLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class HelpMessage extends JFrame {
	public HelpMessage() {
		setSize(375, 685);

		JPanel panel = new JPanel();
		panel.setLayout(null);

		
		//URL urlOfScreen = LottoTicket1.class.getClassLoader().getResource("image/셀렉트_" + (i + 1) + ".gif");
		ImageIcon imageIcon = new ImageIcon(urlOfScreen);
		ImageIcon backgroundImage = new ImageIcon("도움말2.jpg");
		JLabel bg = new JLabel(backgroundImage);
		bg.setBounds(0, 0, 360, 648);

		panel.add(bg);
		add(panel, BorderLayout.CENTER);

		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	
}
