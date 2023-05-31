import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

// �떦泥⑤쾲�샇 �옖�뜡�쑝濡� 留뚮벀
class LottoRandom {
	private static List<Integer> randomNum = new ArrayList<>();

	public static List<Integer> getRandomNum() {
		return randomNum;
	}

	public LottoRandom() {
		Random random = new Random();
		while (randomNum.size() < 7) {
			int number = random.nextInt(45) + 1;
			if (!randomNum.contains(number))
				randomNum.add(number);
		}
	}

	
}

// �떦泥⑤쾲�샇 蹂댁뿬二쇰뒗 �봽�젅�엫
public class LottoRandomPage extends JFrame {
	public LottoRandomPage() {
		JPanel lottoRandomPnl = new JPanel();
		
		LottoRandom lottoRandom = new LottoRandom();
		List<Integer> list = lottoRandom.getRandomNum();

		JLabel randomLbl1 = new JLabel(list.get(0).toString());
		JLabel randomLbl2 = new JLabel(list.get(1).toString());
		JLabel randomLbl3 = new JLabel(list.get(2).toString());
		JLabel randomLbl4 = new JLabel(list.get(3).toString());
		JLabel randomLbl5 = new JLabel(list.get(4).toString());
		JLabel randomLbl6 = new JLabel(list.get(5).toString());
		JLabel randomLbl7 = new JLabel(list.get(6).toString());
		JLabel plus = new JLabel("+");
		
		JButton nextButton = new JButton("�떎�쓬");
		
		nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new LottoDrawPage();
			}
		});

		lottoRandomPnl.add(randomLbl1);
		lottoRandomPnl.add(randomLbl1);
		lottoRandomPnl.add(randomLbl2);
		lottoRandomPnl.add(randomLbl3);
		lottoRandomPnl.add(randomLbl4);
		lottoRandomPnl.add(randomLbl5);
		lottoRandomPnl.add(randomLbl6);
		lottoRandomPnl.add(plus);
		lottoRandomPnl.add(randomLbl7);
		
		add(lottoRandomPnl);
		add(nextButton, "South");
		
	
		setSize(500, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LottoRandomPage();
	}
}
