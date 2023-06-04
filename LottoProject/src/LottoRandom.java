import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoRandom {
	public static List<Integer> getRandomNum() {
		List<Integer> randomNum = new ArrayList<>();
		Random random = new Random();
		while (randomNum.size() < 7) {
			int number = random.nextInt(45) + 1;
			if (!randomNum.contains(number))
				randomNum.add(number);
		}
		return randomNum;
	}
}