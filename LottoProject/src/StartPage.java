
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

class StartPage extends JPanel { 
	public StartPage() {
		JPanel panel = new JPanel();

		JButton btn = new JButton("로또하러가기");

		panel.add(btn);

		panel.setBounds(0, 0, getWidth(), getHeight());
		btn.setBounds(80, 250, 200, 100);

		class Run2 implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				Management.card.show(Management.all, "번호 선택");
			}
		}

		btn.addActionListener(new Run2());
		
		add(panel);
		setSize(340, 550);
	}
	public static void main(String[] args) {
		new StartPage();
	}
}
