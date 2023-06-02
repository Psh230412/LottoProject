
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

class StartPage extends JPanel { 
	JLabel[] labelOfMain = new JLabel[5];
	public StartPage() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		for(int i=0;i<5;i++) {
			URL urlOfMain = LottoTicket1.class.getClassLoader()
					.getResource("image/메인화면_0"+(i + 1)+".gif");
			ImageIcon imageIcon = new ImageIcon(urlOfMain);
			labelOfMain[i] = new JLabel(imageIcon);
			panel.add(labelOfMain[i]);
		}
		
		labelOfMain[0].setBounds(0, 0, 340, 379);
		labelOfMain[1].setBounds(0, 379, 340, 42);
		labelOfMain[2].setBounds(0, 421, 340, 42);
		labelOfMain[3].setBounds(0, 463, 340, 46);
		labelOfMain[4].setBounds(0, 509, 340, 41);
		
		JButton btn = new JButton("로또하러가기");

		panel.add(btn);

		panel.setBounds(0, 0, 340, 550);
		setLayout(null);
		
		btn.setBounds(0, 421, 340, 42);
		labelOfMain[2].add(btn);
		labelOfMain[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Management.card.show(Management.all, "번호 선택");
			}
		});
		add(panel);

		/*
		 * class Run2 implements ActionListener { public void
		 * actionPerformed(ActionEvent e) { Management.card.show(Management.all,
		 * "번호 선택"); } }
		 * 
		 * btn.addActionListener(new Run2());
		 */
		
		//setSize(340, 550);
	}
	public static void main(String[] args) {
		new StartPage();
	}
}
