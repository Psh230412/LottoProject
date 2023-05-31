import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import java.awt.Image;

import java.awt.HeadlessException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class LottoTicket1 extends JFrame {
	private boolean isClick = false;
	private boolean isAuto = false;
	List<String> selectedMode = new ArrayList<>();
	List<Integer> selectedNumbers = new ArrayList<>();
	private JButton[] lottoNumBtn = new JButton[45];;
	private static int changeCount = 0;


	public boolean isAuto() {
		return isAuto;
	}

	public boolean isClick() {
		return isClick;
	}

	public void setClick(boolean isClick) {
		this.isClick = isClick;
	}

	public void setAuto(boolean isAuto) {
		this.isAuto = isAuto;
	}

	public void resetCount() { // 카운트를 리셋하는 메서드를 추가합니다
		this.changeCount = 0;
	}

	public void increaseCount() {
		this.changeCount++;
	}

	public void decreaseCount() {
		this.changeCount--;
	}

	public int getChangeCount() { // 현재 카운트를 가져오는 메서드를 추가합니다
		return this.changeCount;
	}

	
	
	//defaultNumber 이미지를 담는 배열
	Image[] imageArrBefore=new Image[45];
	//selNumber 이미지를 담는 배열
	Image[] imageArrAfter=new Image[45];
	
	
	//defaultNumber 이미지,selNumber 이미지를 배열에 담는 메서드
	public Image[] CreateImage(){
		for(int i=0;i<lottoNumBtn.length;i++) {
			imageArrBefore[i]=new ImageIcon("C:\\Users\\GGG\\Documents\\카카오톡 받은 파일\\defaultNumber\\defaultNumber"+" "+"("+(i+1)+")"+".gif").getImage();
			imageArrAfter[i]=new ImageIcon("C:\\Users\\GGG\\Documents\\카카오톡 받은 파일\\selNumber\\selNumber"+" "+"("+(i+1)+")"+".gif").getImage(); 
		}
		return imageArrBefore;
	}
	
	
	//버튼을 눌렀을때 이미지를 selNumber 이미지로 바꾸는 메서드
	public void ChangeImage(JButton source) {
		for(int i=0;i<lottoNumBtn.length;i++) {
			if(source.equals(lottoNumBtn[i]) ) {
				source.setIcon(new ImageIcon(imageArrAfter[i]));
			}
			
		}
		
	}
	//누른 버튼을 취소시켜주는 메서드
	public void restoreImage(JButton source) {
		for(int i=0;i<lottoNumBtn.length;i++) {
			if(source.equals(lottoNumBtn[i]) ) {
				source.setIcon(new ImageIcon(imageArrBefore[i]));
			}
			
		}
		
	}
	
	

	public void buttonCreate() {
		for (int i = 0; i < lottoNumBtn.length; i++) {
			lottoNumBtn[i] = new JButton();
			lottoNumBtn[i].addActionListener(new MyListener(this));
			lottoNumBtn[i].setIcon(new ImageIcon(CreateImage()[i]));
			lottoNumBtn[i].setBorderPainted(false);
			
			
			// lottoNumbtn[0]={1} lottoNumbtn[1]={2}.......lottoNumbtn[n]={n+1}
		}
	}

	public List<Integer> getSelectedNumbers() {
		for (int i = 0; i < lottoNumBtn.length; i++) {
			if (lottoNumBtn[i].getBackground().equals(Color.RED)) {
				selectedNumbers.add(i + 1); // lottoNumBtn의 인덱스는 0부터 시작하므로 1을 더해야 번호를 얻을 수 있습니다.
			}
		}
		return selectedNumbers;
	}

	public List<String> getSelectedMode() {
		if (isAuto == true && isClick == true) {
			selectedMode.add("자동");
		} else if (isAuto == false && isClick == true) {
			selectedMode.add("반자동");
		} else {
			selectedMode.add("수동");
		}
		return selectedMode;
	}


	public LottoTicket1() {
		buttonCreate();
		
		
		JPanel oneTicketPanel = new JPanel();
		

		oneTicketPanel.setLayout(null);
		oneTicketPanel.setBackground(Color.BLACK);
		
		
		JButton autoBtn = new JButton("자동");
		JButton resetBtn = new JButton("초기화");
		JButton returnBtn = new JButton("번호 확정");
		
		autoBtn.setSize(new Dimension(45, 30));
		resetBtn.setSize(new Dimension(45, 30));
		returnBtn.setSize(new Dimension(98, 30));
		
		autoBtn.setLocation(124, 40);
		resetBtn.setLocation(174, 40);
		returnBtn.setLocation(98, 488);
		
		for(int i=0;i<45;i++) {
			lottoNumBtn[i].setSize(42,42);
			oneTicketPanel.add(lottoNumBtn[i]);
		}
		
		
		for(int i=0;i<9;i++) {
			lottoNumBtn[5*i].setLocation(42+0, 100+42*i);
		}
		for(int i=0;i<9;i++) {
			lottoNumBtn[5*i+1].setLocation(42+42, 100+42*i);
		}
		for(int i=0;i<9;i++) {
			lottoNumBtn[5*i+2].setLocation(42+42*2, 100+42*i);
		}
		for(int i=0;i<9;i++) {
			lottoNumBtn[5*i+3].setLocation(42+42*3, 100+42*i);
		}
		for(int i=0;i<9;i++) {
			lottoNumBtn[5*i+4].setLocation(42+42*4, 100+42*i);
		}
		
		
		oneTicketPanel.add(autoBtn);
		oneTicketPanel.add(resetBtn);
		oneTicketPanel.add(returnBtn);

		autoBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int clickCount = 0;
				for (int i = 0; i < 45; i++) {
					if (lottoNumBtn[i].getBackground().equals(Color.RED)) {
						clickCount++;
					}
				}

				List<Integer> numbers = new ArrayList<>();

				for (int i = 0; i < 45; i++) {
					if (!lottoNumBtn[i].getBackground().equals(Color.RED)) {
						numbers.add(i);
					}

				}
				Collections.shuffle(numbers);
				int autoCount = 0;
				int maxCount = 6;
				int yesNo = maxCount - clickCount;

				for (int i = 0; i < yesNo; i++) {
					lottoNumBtn[numbers.get(i)].setBackground(Color.red);
					increaseCount();
					autoCount++;
				}

				if (yesNo == 6) {
					isAuto = true;

				}
				if (yesNo >= 1 && yesNo <= 5) {
					isAuto = false;

				}

				if (autoCount > 1 && autoCount < 7) {
					isClick = true;
				}

			}
		});

		resetBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (JButton button : lottoNumBtn) {
					button.setBackground(null);
				}
				setAuto(false);
				setClick(false);
				resetCount();
			}
		});

		returnBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (!(changeCount == 6)) {
					JOptionPane.showMessageDialog(null, "번호를 6개까지 정하셔야합니다", "입력미달", JOptionPane.WARNING_MESSAGE);
				} else {
					int result = JOptionPane.showConfirmDialog(LottoTicket1.this, "번호를 확정하시겠습니까?", "복권번호 확정",
							JOptionPane.YES_NO_OPTION);

					if (result == JOptionPane.YES_OPTION) {
						LottoTicket1.this.dispose();
						getSelectedNumbers();
						getSelectedMode();
						System.out.println(selectedMode);
						System.out.println(selectedNumbers);
						setAuto(false);
						setClick(false);
						resetCount();
						new LottoNumberPage();
						

						MyNumPnlA.getMyNumLbl1A().setText(selectedNumbers.get(0).toString());
						MyNumPnlA.getMyNumLbl2A().setText(selectedNumbers.get(1).toString());
						MyNumPnlA.getMyNumLbl3A().setText(selectedNumbers.get(2).toString());
						MyNumPnlA.getMyNumLbl4A().setText(selectedNumbers.get(3).toString());
						MyNumPnlA.getMyNumLbl5A().setText(selectedNumbers.get(4).toString());
						MyNumPnlA.getMyNumLbl6A().setText(selectedNumbers.get(5).toString());
						MyNumPnlA.getAutoLblA().setText(selectedMode.get(0).toString());
					}
				}

			}
		});
		

		

		add(oneTicketPanel);
	

		setSize(294, 578);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}

	public static void main(String[] args) {
		new LottoTicket1();
	}

}

class MyListener implements ActionListener {
	private LottoTicket1 lt1;

	public MyListener(LottoTicket1 lt1) {
		this.lt1 = lt1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton) e.getSource();

		if (lt1.getChangeCount() == 6)
			lt1.setAuto(false);

		if (!source.getBackground().equals(Color.RED) && lt1.getChangeCount() < 6) {

			source.setBackground(Color.RED);
			

			lt1.increaseCount();
			lt1.ChangeImage(source);

		} else if (!source.getBackground().equals(Color.RED) && lt1.getChangeCount() == 6) {
			JOptionPane.showMessageDialog(null, "로또숫자는 6개까지 고를 수 있습니다.", "숫자초과", JOptionPane.WARNING_MESSAGE);
		} else if (source.getBackground().equals(Color.RED) && lt1.getChangeCount() == 1 && lt1.isClick() == true) {
			source.setBackground(null);

			lt1.decreaseCount();
			lt1.setAuto(false);
			lt1.setClick(false);

			lt1.resetCount();
			
			lt1.restoreImage(source);
			
		} else if (lt1.getChangeCount() <= 6) {
			source.setBackground(null);
			lt1.decreaseCount();
		} else if (lt1.getChangeCount() == 6) {
			source.setBackground(null);
			lt1.decreaseCount();

		}
	}
}
