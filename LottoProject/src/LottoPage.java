import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
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
	    private JLabel guideLbl1;
	    private JLabel guideLbl2;
	    private JButton[] lottoNumBtn;
	    
	    public void buttonCreate() {
	    	for(int i=0;i<lottoNumBtn.length;i++) {
	    		String lottoNumBtnName = String.valueOf(i+1);
	    		lottoNumBtn[i]=new JButton(lottoNumBtnName);
	    		//lottoNumbtn[0]={1} lottoNumbtn[1]={2}.......lottoNumbtn[n]={n+1}
	    	}
	    }
	    
	    
	    public LottoTicket() {
	    	JPanel oneTicketPanel = new JPanel();
	    	
	    	JPanel titlePanel = new JPanel();
	    	JPanel guideLbl1titlePanel = new JPanel();
	    	JPanel guideLbl2titlePanel = new JPanel();
	    	JPanel lnbPanel = new JPanel();
	    	JPanel btnPanel = new JPanel();
	    	
	    	
	    	
	    	guideLbl1= new JLabel("A");
	    	guideLbl2 = new JLabel("1000��");
	    	
	    	guideLbl1titlePanel.add(guideLbl1);
	    	guideLbl2titlePanel.add(guideLbl2);
	    	titlePanel.setLayout(new BoxLayout(titlePanel,BoxLayout.X_AXIS));
			titlePanel.add(guideLbl1titlePanel);
			titlePanel.add(guideLbl2titlePanel);
	    	
	    	oneTicketPanel.setLayout(new BoxLayout(oneTicketPanel, BoxLayout.Y_AXIS));
	    	
	    	
	    	lottoNumBtn = new JButton[45];
	    	
	    	
	    	buttonCreate();
	    	
	    	lnbPanel.setLayout(new GridLayout(6,8));
	    	for(int i=0;i<lottoNumBtn.length;i++) {
	    		lnbPanel.add(lottoNumBtn[i]);
	    	}
	    	
	    	add(oneTicketPanel);
	    	oneTicketPanel.add(titlePanel);
	    	oneTicketPanel.add(lnbPanel);
	    	oneTicketPanel.add(btnPanel);
	    	
	    	setSize(600, 1000);
	    	setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
	  

	    }
    
   

}

public class LottoPage extends JFrame{
	public static void main(String[] args) {
		new LottoTicket();
	}

}
