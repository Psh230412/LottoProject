import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


class LottoQuantity {
    private int count;

}

public class StartPage extends JFrame {
    public StartPage() {
    	//로또 구매 팝업창  
        setSize(300, 450);
        setTitle("구매하기");

        JPanel panel = new JPanel(new GridBagLayout()); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER; 

        JLabel label = new JLabel("로또 구매 개수");
        JRadioButton select1 = new JRadioButton("1개");
        JRadioButton select2 = new JRadioButton("2개");
        JRadioButton select3 = new JRadioButton("3개");
        JRadioButton select4 = new JRadioButton("4개");
        JRadioButton select5 = new JRadioButton("5개");
        JButton btn = new JButton("확인");

        ButtonGroup group = new ButtonGroup();
        group.add(select1);
        group.add(select2);
        group.add(select3);
        group.add(select4);
        group.add(select5);

        gbc.gridx = 0; 
        gbc.gridy = 0; 
        gbc.insets.bottom = 10; 
        panel.add(label, gbc);

        gbc.gridy = 1; 
        panel.add(select1, gbc);

        gbc.gridy = 2; 
        panel.add(select2, gbc);

        gbc.gridy = 3; 
        panel.add(select3, gbc);

        gbc.gridy = 4; 
        panel.add(select4, gbc);

        gbc.gridy = 5; 
        panel.add(select5, gbc);

        gbc.gridy = 6; 
        gbc.insets.bottom = 0; 
        panel.add(btn, gbc);

        add(panel); 

        setLocationRelativeTo(null); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        StartPage s = new StartPage();
    }
}