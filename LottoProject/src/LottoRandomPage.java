import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.sun.prism.paint.Stop;

// 당첨번호 랜덤으로 만듦
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

// 당첨번호 보여주는 프레임
public class LottoRandomPage extends JFrame {
	public LottoRandomPage() {
		JPanel lottoRandomPnl = new JPanel();

		LottoRandom lottoRandom = new LottoRandom();
		List<Integer> list = lottoRandom.getRandomNum();

		JLabel randomLbl = new JLabel();

		Timer timer = new Timer(1000, new ActionListener() {
			int i = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				if (i < list.size()) {
				randomLbl.setText(list.get(i).toString());
				i++;
				}		
			}
			
		});

		JButton randomBtn = new JButton("추첨");
		randomBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.start();
			}
		});

		JButton nextButton = new JButton("다음");

		nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new LottoDrawPage();

			}
		});

		lottoRandomPnl.add(randomLbl);
		lottoRandomPnl.add(randomBtn);
		lottoRandomPnl.add(nextButton);
		add(lottoRandomPnl);

		setSize(340, 583);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LottoRandomPage();
	}
}
