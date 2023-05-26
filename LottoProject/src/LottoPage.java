import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



class LottoTicket extends JFrame {
	 private LinkedList myNum;
	    private JButton autoBtn;
	    private JButton resetBtn;
	    private JLabel guideLbl;
	    //private JButton lottoNumBtn;
	    private JButton[] lottoNumBtn;
	    
	    public void buttonCreate() {
	    	for(int i=0;i<lottoNumBtn.length;i++) {
	    		String lottoNumBtnName = String.valueOf(i+1);
	    		lottoNumBtn[i]=new JButton(lottoNumBtnName);
	    		//lottoNumbtn[0]={1} lottoNumbtn[1]={2}.......lottoNumbtn[n]={n+1}
	    	}
	    }
	    
	    
	    public LottoTicket() {
	    	
	    	lottoNumBtn = new JButton[45];
	    	
	    	
	    	buttonCreate();
	    	
	    	
	    	
	    	JPanel lnbPanel = new JPanel();
	    	for(int i=0;i<lottoNumBtn.length;i++) {
	    		lnbPanel.add(lottoNumBtn[i]);
	    	}
	    	
	    	add(lnbPanel);
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
