
import java.awt.Image;
import java.util.List;

class Records {

	List<String> selectedModeA;
	List<String> selectedModeB;
	List<String> selectedModeC;
	List<String> selectedModeD;
	List<String> selectedModeE;
	List<Integer> randomNumList;// 당첨번호
	List<Integer> selectedNumA;
	List<Integer> selectedNumB;
	List<Integer> selectedNumC;
	List<Integer> selectedNumD;
	List<Integer> selectedNumE;
	int turn;
	Records next;

	public Records(List<Integer> selectedNumA, List<Integer> selectedNumB, List<Integer> selectedNumC,
			List<Integer> selectedNumD, List<Integer> selectedNumE, List<Integer> randomNumList,
			List<String> selectedModeA, List<String> selectedModeB, List<String> selectedModeC,
			List<String> selectedModeD, List<String> selectedModeE) {

		this.selectedModeA = selectedModeA;
		this.selectedModeB = selectedModeB;
		this.selectedModeC = selectedModeC;
		this.selectedModeD = selectedModeD;
		this.selectedModeE = selectedModeE;
		this.randomNumList = randomNumList;
		this.selectedNumA = selectedNumA;
		this.selectedNumB = selectedNumB;
		this.selectedNumC = selectedNumC;
		this.selectedNumD = selectedNumD;
		this.selectedNumE = selectedNumE;
		turn = 0;

		next = null;
	}

}

public class AllRecords {
	Records head;

	public void push(List<Integer> selectedNumA, List<Integer> selectedNumB, List<Integer> selectedNumC,
			List<Integer> selectedNumD, List<Integer> selectedNumE, List<Integer> randomNumList,
			List<String> selectedModeA, List<String> selectedModeB, List<String> selectedModeC,
			List<String> selectedModeD, List<String> selectedModeE) {

		Records new_records = new Records(selectedNumA, selectedNumB, selectedNumC, selectedNumD, selectedNumE,
				randomNumList, selectedModeA, selectedModeB, selectedModeC, selectedModeD, selectedModeE);

		if (head == null) {
			head = new_records;
			head.turn = 1;
		} else {
			Records last = head;
			last.turn = 1;

			while (last.next != null) {
				last.next.turn = last.turn + 1;
				last = last.next;
			}

			new_records.turn = last.turn + 1;
			last.next = new_records;

		}

	}

	// 회차 넣으면 Records 객체를 반환
	public Records getRecords(int turn) {
		if (head != null) {
			Records someRecords = head;

			while (someRecords !=null) {

				if(someRecords.turn == turn) {
					return someRecords;
				}
				someRecords = someRecords.next;
			}
			
		}
		return null;
	}
	
	//가장 큰 턴을 반환
	public int getLastTurn() {
		if (head == null) {
			return 0;
		} else {
			Records last = head;
			
			while (last.next != null) {
				
				last = last.next;
			}
			
			return last.turn;
			

		}
	}
	
	
	public void printList() {
		Records tnode = head;
		while (tnode != null) {
			System.out.println("회차: " + tnode.turn);
			System.out.println("당첨번호: " + tnode.randomNumList + " ");
			System.out.print("LottoTiket1 selectedMode: " + tnode.selectedModeA + " ");
			System.out.println("LottoTiket1 selectedNumbers: " + tnode.selectedNumA + " ");
			System.out.print("LottoTiket2 selectedMode: " + tnode.selectedModeB + " ");
			System.out.println("LottoTiket2 selectedNumbers: " + tnode.selectedNumB + " ");
			System.out.print("LottoTiket3 selectedMode: " + tnode.selectedModeC + " ");
			System.out.println("LottoTiket3 selectedNumbers: " + tnode.selectedNumC + " ");
			System.out.print("LottoTiket4 selectedMode: " + tnode.selectedModeD + " ");
			System.out.println("LottoTiket4 selectedNumbers: " + tnode.selectedNumD + " ");
			System.out.print("LottoTiket5 selectedMode: " + tnode.selectedModeE + " ");
			System.out.println("LottoTiket5 selectedNumbers: " + tnode.selectedNumE + " ");
			tnode = tnode.next;
		}
	}
	
	
	/*
	 * public List<Integer> getRecordsNumbers(){
	 * 
	 * } public List<String> getRecordsMode(){
	 * 
	 * }
	 */


}
