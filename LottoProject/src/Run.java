import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Run extends JFrame {
    public Run() { // 프로그램 실행 시 맨 처음에 뜰 창(로또하러가기 버튼)
        JPanel panel = new JPanel();
        setSize(1440, 648);
        setTitle("로또");

        JButton btn = new JButton("로또하러가기");
        setLayout(null);
        panel.setLayout(null);
        panel.add(btn);

        panel.setBounds(0, 0, getWidth(), getHeight());
        btn.setBounds(600, 500, 250, 100);

        class Run2 implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new StartPage();
            }
        }

        btn.addActionListener(new Run2());

        add(panel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Run r = new Run();
    }
}

