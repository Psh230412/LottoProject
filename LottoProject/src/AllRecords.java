import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllRecords {
	Map<Integer,List<Integer>> lottoNumberStorage = new HashMap<>();

	public Map<Integer, List<Integer>> getMap() {
		return lottoNumberStorage;
	}
	public void setMap(Map<Integer, List<Integer>> lottoNumberStorage) {
		this.lottoNumberStorage = lottoNumberStorage;
	}
}
