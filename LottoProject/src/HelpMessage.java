import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

class HelpMessage extends JPanel {
	JLabel label;
	   Management management;

	   public HelpMessage() { 
		   
	      URL urlOfTuto = LottoTicket1.class.getClassLoader().getResource("image/도움말.gif");
	      ImageIcon imageIcon = new ImageIcon(urlOfTuto);
	      label = new JLabel(imageIcon);
	      label.addMouseListener((MouseListener) new MouseAdapter() {
	         @Override
	         public void mouseClicked(MouseEvent e) {
	            Management.card.show(Management.all, "번호 선택");

	         }
	      });
	      setLayout(new BorderLayout());
	      add(label);
	      setBounds(0, 0, 340, 550);
	      setVisible(true);

	   }
	}
