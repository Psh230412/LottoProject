import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



class LottoTicket extends JFrame {
	 private LinkedList myNum;
	    private JButton autoBtn;
	    private JButton resetBtn;
	    private JLabel[] guideLbl1;
	    private JLabel guideLbl2;
	    private JButton[] lottoNumBtn;
	    
	    public void buttonCreate() {
	    	for(int i=0;i<lottoNumBtn.length;i++) {
	    		String lottoNumBtnName = String.valueOf(i+1);
	    		lottoNumBtn[i]=new JButton(lottoNumBtnName);
	    		//lottoNumbtn[0]={1} lottoNumbtn[1]={2}.......lottoNumbtn[n]={n+1}
	    	}
	    }
	    public void guideLblCreate() {
	    	guideLbl1 = new JLabel[5];
	    	guideLbl1[0] = new JLabel("A");
	    	guideLbl1[1] = new JLabel("B");
	    	guideLbl1[2] = new JLabel("C");
	    	guideLbl1[3] = new JLabel("D");
	    	guideLbl1[4] = new JLabel("E");
	    	
	    }
	    
	    
	    public LottoTicket() {
	    	
	    	JPanel oneTicketPanel = new JPanel();
	    	
	    	JPanel titlePanel = new JPanel();
	    	JPanel guideLbl1titlePanel = new JPanel();
	    	JPanel guideLbl2titlePanel = new JPanel();
	    	JPanel lnbPanel = new JPanel();
	    	JPanel btnPanel = new JPanel();
	    	Font font = new Font("SansSerif",Font.BOLD,30);
	    	
	    	
	    	guideLblCreate();
	    	
	    	
	    	guideLbl2 = new JLabel("1000¿ø");
	    	guideLbl1[0].setFont(font);
	    	guideLbl2.setFont(font);
	    	
	    	guideLbl1titlePanel.setPreferredSize(new Dimension(20,20));
	    	guideLbl2titlePanel.setPreferredSize(new Dimension(45,20));
	    	guideLbl1titlePanel.add(guideLbl1[0]);
	    	guideLbl2titlePanel.add(guideLbl2);
	    	guideLbl1titlePanel.setBackground(Color.white);
	    	guideLbl2titlePanel.setBackground(Color.PINK);

	    	
	    	titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
			titlePanel.add(guideLbl1titlePanel);
			titlePanel.add(guideLbl2titlePanel);
	    	
	    	oneTicketPanel.setLayout(new BoxLayout(oneTicketPanel, BoxLayout.Y_AXIS));
	    	
	    	
	    	lottoNumBtn = new JButton[45];
	    	
	    	
	    	buttonCreate();
	    	
	    	lnbPanel.setLayout(new GridLayout(9,5));
	    	for(int i=0;i<lottoNumBtn.length;i++) {
	    		lnbPanel.add(lottoNumBtn[i]);
	    	}
	    	
	    	add(oneTicketPanel);
	    	oneTicketPanel.add(titlePanel);
	    	oneTicketPanel.add(lnbPanel);
	    	oneTicketPanel.add(btnPanel);
	    	
	    	
	    	setSize(300, 500);
	    	setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
	  

	    }
    
   

}

public class LottoPage extends JFrame{
	public static void main(String[] args) {
		new LottoTicket();
	}

}
