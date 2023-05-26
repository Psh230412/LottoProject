import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class LottoTicket extends JFrame {
	private static String[] title = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
			"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33",
			"34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45" };
	private JButton[] btn = new JButton[45];
	
	public LottoTicket() {
		JPanel pn1 = new JPanel();
		GridLayout layout = new GridLayout(9,5);
		pn1.setLayout(layout);
		
		buttonCreate();
		
		setSize(500,500);
		setVisible(true);
		
	}
	public void buttonCreate() {
		for(int i = 0; i < btn.length; i++) {
			btn[i] = new JButton(title[i]);
			btn[i].setVisible(true);
			add(btn[i]);
		}
	}
	
}

public class LottoPage {

}

//    private int myNum;
//    private int autoBtn;
//    private int resetBtn;
//    private int guideLbl;
//    private int lottoNumBtn;