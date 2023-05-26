import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


class LottoQuantity {
    private int count;

}

public class StartPage extends JFrame {
    public StartPage() {
        setSize(300, 450);
        setTitle("구매하기");

        JPanel panel = new JPanel(new GridBagLayout()); // 체크박스를 감싸는 패널
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER; // 가운데 정렬

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

        gbc.gridx = 0; // 열 0
        gbc.gridy = 0; // 행 0
        gbc.insets.bottom = 10; // 아래 여백
        panel.add(label, gbc);

        gbc.gridy = 1; // 행 1
        panel.add(select1, gbc);

        gbc.gridy = 2; // 행 2
        panel.add(select2, gbc);

        gbc.gridy = 3; // 행 3
        panel.add(select3, gbc);

        gbc.gridy = 4; // 행 4
        panel.add(select4, gbc);

        gbc.gridy = 5; // 행 5
        panel.add(select5, gbc);

        gbc.gridy = 6; // 행 6
        gbc.insets.bottom = 0; // 아래 여백 제거
        panel.add(btn, gbc);

        add(panel); // 패널을 프레임에 추가

        setLocationRelativeTo(null); // 프레임을 가운데에 위치시키기
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        StartPage s = new StartPage();
    }
}