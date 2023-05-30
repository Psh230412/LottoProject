import javax.swing.JFrame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

// 당첨번호 랜덤으로 만듦
class LottoRandom {
	private List<Integer> randomNum = new ArrayList<>();

	public List<Integer> getRandomNum() {
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

class LottoRandomPnl extends JPanel {
	public LottoRandomPnl() {
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

		add(randomLbl1);
		add(randomLbl1);
		add(randomLbl2);
		add(randomLbl3);
		add(randomLbl4);
		add(randomLbl5);
		add(randomLbl6);
		add(plus);
		add(randomLbl7);

	}

}

// 당첨번호 보여주는 프레임
public class LottoRandomPage extends JFrame {
	public LottoRandomPage() {
		LottoRandomPnl pnl = new LottoRandomPnl();
		add(pnl);
	
		setSize(500, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LottoRandomPage();
	}

}
