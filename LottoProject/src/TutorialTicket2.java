
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class TutorialTicket2 extends JPanel {
   private boolean isClick = false;
   private boolean isAuto = false;
   static List<String> selectedMode;
   static List<Integer> selectedNumbers;
   public JButton[] lottoNumBtn = new JButton[45];;
   private static int changeCount = 0;
   JLabel[] look = new JLabel[10];
   private boolean[] isButtonClicked = new boolean[45];
   private boolean isSixSelected = false;
   
   public static List<String> getSelectedMode() {
      return selectedMode;
   }

   public static List<Integer> getSelectedNumbers() {
      return selectedNumbers;
   }

   public static void setSelectedMode(List<String> selectedMode) {
      LottoTicket1.selectedMode = selectedMode;
   }

   public static void setSelectedNumbers(List<Integer> selectedNumbers) {
      LottoTicket1.selectedNumbers = selectedNumbers;
   }

   public boolean getIsSixSelected() {
      return this.isSixSelected;
   }

   public void setSixSelected(boolean isSixSelected) {
      this.isSixSelected = isSixSelected;
   }

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

   Image[] ModeImage = new Image[3];

   public Image[] CreateMode() {
      for (int i = 0; i < ModeImage.length; i++) {
         URL urlOfDN = LottoTicket1.class.getClassLoader().getResource("image4/auto" + (i + 1) + ".gif");
         ModeImage[i] = new ImageIcon(urlOfDN).getImage();
      }
      return ModeImage;
   }

   // defaultNumber 이미지를 담는 배열
   Image[] imageArrBefore = new Image[45];
   // selNumber 이미지를 담는 배열
   Image[] imageArrAfter = new Image[45];

   // defaultNumber 이미지,selNumber 이미지를 배열에 담는 메서드
   public Image[] CreateImage() {
      for (int i = 0; i < lottoNumBtn.length; i++) {
         URL urlOfDN = LottoTicket1.class.getClassLoader()
               .getResource("image/defaultNumber" + " " + "(" + (i + 1) + ")" + ".gif");
         imageArrBefore[i] = new ImageIcon(urlOfDN).getImage();
         URL urlOfSN = LottoTicket1.class.getClassLoader()
               .getResource("image/selNumber" + " " + "(" + (i + 1) + ")" + ".gif");
         imageArrAfter[i] = new ImageIcon(urlOfSN).getImage();
      }
      return imageArrBefore;
   }

   // 라벨 생성 및 라벨에 셀렉트 이미지 URL 삽입하는 메서드
   public JLabel[] CreateScreen() {
      for (int i = 1; i < look.length; i++) {
         URL urlOfScreen = LottoTicket1.class.getClassLoader().getResource("image/셀렉트_" + (i + 1) + ".gif");
         ImageIcon imageIcon = new ImageIcon(urlOfScreen);
         look[i] = new JLabel(imageIcon);
      }
      URL urlOfAlpha = LottoTicket1.class.getClassLoader().getResource("image/셀렉트_A.gif");
      ImageIcon imageIconAlpha = new ImageIcon(urlOfAlpha);
      look[0] = new JLabel(imageIconAlpha);
      return look;
   }

   // JButton[] BtnScreenArr = { returnBtn,autoBtn,resetBtn};
   // 버튼 생성 및 버튼에 셀렉트 이미지 URL 삽입하는 메서드
   /*
    * BtnScreenArr[0] = 확정버튼 BtnScreenArr[1] = 자동버튼 BtnScreenArr[2] = 초기화 버튼
    */
   JButton[] BtnScreenArr = new JButton[3];

   public JButton[] createBtnScreen() {
      for (int i = 0; i < BtnScreenArr.length; i++) {
         URL urlOfScreen = LottoTicket1.class.getClassLoader().getResource("image/셀렉트_" + (i + 11) + ".gif");
         ImageIcon imageIcon = new ImageIcon(urlOfScreen);
         BtnScreenArr[i] = new JButton(imageIcon);
      }
      return BtnScreenArr;
   }

   // 버튼을 눌렀을때 이미지를 selNumber 이미지로 바꾸는 메서드
   public void ChangeImage(JButton source) {
      for (int i = 0; i < lottoNumBtn.length; i++) {
         if (source.equals(lottoNumBtn[i])) {
            source.setIcon(new ImageIcon(imageArrAfter[i]));
            isButtonClicked[i] = true;
         }
      }
   }

   // 누른 버튼을 취소시켜주는 메서드
   public void restoreImage(JButton source) {
      for (int i = 0; i < lottoNumBtn.length; i++) {
         if (source.equals(lottoNumBtn[i])) {
            source.setIcon(new ImageIcon(imageArrBefore[i]));
            isButtonClicked[i] = false;
         }
      }
   }

   // 버튼 생성 메소드 (액션리스너 추가 , 이미지 추가 , 마우스리스너 추가 )
   public void buttonCreate() {
      for (int i = 0; i < lottoNumBtn.length; i++) {
         final int index = i;
         URL urlOfSN = LottoTicket1.class.getClassLoader()
               .getResource("image/selNumber" + " " + "(" + (i + 1) + ")" + ".gif");
         lottoNumBtn[i] = new JButton();
         lottoNumBtn[i].addActionListener(new Tutorial2MyListener(this));
         lottoNumBtn[i].setIcon(new ImageIcon(CreateImage()[i]));
         lottoNumBtn[i].setBorderPainted(false);
         lottoNumBtn[i].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
               if (!isButtonClicked[index] && !getIsSixSelected()) {
                  URL urlOfScreen = LottoTicket1.class.getClassLoader()
                        .getResource("image/defaultNumber" + " " + "(" + (index + 1) + ")" + ".gif");
                  ImageIcon defaultIcon = new ImageIcon(urlOfScreen);
                  lottoNumBtn[index].setIcon(defaultIcon);
               }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
               if (!isButtonClicked[index] && !getIsSixSelected()) {
                  URL urlOfScreen = LottoTicket1.class.getClassLoader()
                        .getResource("image/revNumber" + " " + "(" + (index + 1) + ")" + ".gif");
                  ImageIcon changeIcon = new ImageIcon(urlOfScreen);
                  lottoNumBtn[index].setIcon(changeIcon);
               }
            }
         });
      }
   }
   // 선택된 번호 배열에 저장하는 메소드
   public List<Integer> inputSelectedNumbers() {
      selectedNumbers = new ArrayList<>();
      for (int i = 0; i < lottoNumBtn.length; i++) {
         if (lottoNumBtn[i].getBackground().equals(Color.RED)) {
            selectedNumbers.add(i + 1);
         }
      }
      return selectedNumbers;
   }

   public TutorialTicket2() {
      JPanel oneTicketPanel = new JPanel();
      oneTicketPanel.setLayout(null);
      oneTicketPanel.setBackground(Color.BLACK);
      buttonCreate();
      JLabel[] labels = CreateScreen();
      CreateMode();
      /*
       * BtnScreenArr[0] = 확정버튼// BtnScreenArr[1] = 자동버튼 BtnScreenArr[2] = 초기화 버튼
       * buttons[0] = 확정버튼 buttons[1] = 자동버튼 buttons[2] = 초기화버튼
       */
      JButton[] buttons = createBtnScreen();

      for (int i = 0; i < look.length; i++) {
         oneTicketPanel.add(labels[i]);
      }
      // 각 라벨배열들의 위치,크기 설정
      labels[0].setLocation(0, 0); // 대문자
      labels[0].setSize(120, 81);
      labels[1].setLocation(120, 0); // 위에줄
      labels[1].setSize(220, 46);
      labels[2].setLocation(281, 46); // 우측 내려오는 작은 줄
      labels[2].setSize(59, 35);
      labels[3].setLocation(0, 81); // 세로가낮은 가로긴 공간 (버튼밑)
      labels[3].setSize(340, 14);
      labels[4].setLocation(277, 95); // 우측 내려오는 긴줄
      labels[4].setSize(63, 455);
      labels[5].setLocation(67, 473); // 밑에줄
      labels[5].setSize(210, 36);
      labels[6].setLocation(0, 95); // 좌측 내려오는줄
      labels[6].setSize(67, 455);
      labels[7].setLocation(67, 509); // 확정버튼 왼쪽공간
      labels[7].setSize(62, 29);
      labels[8].setLocation(217, 509); // 확정버튼 오른쪽공간
      labels[8].setSize(60, 29);
      labels[9].setLocation(67, 538); // 밑에 공간
      labels[9].setSize(210, 12);

      for (int i = 0; i < buttons.length; i++) {
         buttons[i].setBorderPainted(false);
         oneTicketPanel.add(buttons[i]);
      }
      // 각 버튼배열의 위치,크기
      buttons[0].setLocation(129, 509); // 확정
      buttons[0].setSize(88, 29);
      buttons[1].setLocation(120, 46); // 자동
      buttons[1].setSize(81, 35);
      buttons[2].setLocation(201, 45); // 초기화
      buttons[2].setSize(80, 35);

      for (int i = 0; i < 45; i++) {
         lottoNumBtn[i].setSize(42, 42);
         oneTicketPanel.add(lottoNumBtn[i]);
      }

      for (int i = 0; i < 9; i++) {
         lottoNumBtn[5 * i].setLocation(67 + 0, 95 + 42 * i);
      }
      for (int i = 0; i < 9; i++) {
         lottoNumBtn[5 * i + 1].setLocation(67 + 42, 95 + 42 * i);
      }
      for (int i = 0; i < 9; i++) {
         lottoNumBtn[5 * i + 2].setLocation(67 + 42 * 2, 95 + 42 * i);
      }
      for (int i = 0; i < 9; i++) {
         lottoNumBtn[5 * i + 3].setLocation(67 + 42 * 3, 95 + 42 * i);
      }
      for (int i = 0; i < 9; i++) {
         lottoNumBtn[5 * i + 4].setLocation(67 + 42 * 4, 95 + 42 * i);
      }
      // 각 버튼의 마우스 리스너 추가
      buttons[1].addMouseListener(new MouseAdapter() {// 자동
         @Override
         public void mouseReleased(MouseEvent e) {
            URL urlOfScreen = LottoTicket1.class.getClassLoader().getResource("image/셀렉트_12.gif");
            ImageIcon defaultIcon = new ImageIcon(urlOfScreen);
            buttons[1].setIcon(defaultIcon);
         }

         @Override
         public void mousePressed(MouseEvent e) {
				ResourceSoundPack.btnSound();
            URL urlOfScreen = LottoTicket1.class.getClassLoader().getResource("image/셀렉트_03second.gif");
            ImageIcon changeIcon = new ImageIcon(urlOfScreen);
            buttons[1].setIcon(changeIcon);
         }
      });
      buttons[2].addMouseListener(new MouseAdapter() {// 초기화
         @Override
         public void mouseReleased(MouseEvent e) {
            URL urlOfScreen = LottoTicket1.class.getClassLoader().getResource("image/셀렉트_13.gif");
            ImageIcon defaultIcon = new ImageIcon(urlOfScreen);
            buttons[2].setIcon(defaultIcon);
         }

         @Override
         public void mousePressed(MouseEvent e) {
				ResourceSoundPack.btnSound();
            URL urlOfScreen = LottoTicket1.class.getClassLoader().getResource("image/셀렉트_04second.gif");
            ImageIcon changeIcon = new ImageIcon(urlOfScreen);
            buttons[2].setIcon(changeIcon);
         }
      });
      buttons[0].addMouseListener(new MouseAdapter() {// 초기화
         @Override
         public void mouseReleased(MouseEvent e) {
            URL urlOfScreen = LottoTicket1.class.getClassLoader().getResource("image/셀렉트_11.gif");
            ImageIcon defaultIcon = new ImageIcon(urlOfScreen);
            buttons[0].setIcon(defaultIcon);
         }

         @Override
         public void mousePressed(MouseEvent e) {
				ResourceSoundPack.btnSound();
            URL urlOfScreen = LottoTicket1.class.getClassLoader().getResource("image/셀렉트_05second.gif");
            ImageIcon changeIcon = new ImageIcon(urlOfScreen);
            buttons[0].setIcon(changeIcon);
         }
      });
      // 각 버튼의 액션 리스너 추가
      buttons[1].addActionListener(new ActionListener() { // 자동버튼
         @Override
         public void actionPerformed(ActionEvent e) {
            int clickCount = 0;
            isSixSelected = true;
            for (JButton button : lottoNumBtn) {
               if (!button.getBackground().equals(Color.RED)) {
                  int index = Arrays.asList(lottoNumBtn).indexOf(button);
                  URL urlOfScreen = LottoTicket1.class.getClassLoader()
                        .getResource("image/unNumber" + " " + "(" + (index + 1) + ")" + ".gif");
                  ImageIcon blackWhiteIcon = new ImageIcon(urlOfScreen);
                  button.setIcon(blackWhiteIcon);
               }
            }
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
               lottoNumBtn[numbers.get(i)].setIcon(new ImageIcon(imageArrAfter[numbers.get(i)]));
               isButtonClicked[numbers.get(i)] = true;
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
      buttons[2].addActionListener(new ActionListener() { // 초기화버튼
         @Override
         public void actionPerformed(ActionEvent e) {
            isSixSelected = false;
            for (JButton button : lottoNumBtn) {
               button.setBackground(null);
            }
            for (int i = 0; i < lottoNumBtn.length; i++) {
               lottoNumBtn[i].setIcon(new ImageIcon(imageArrBefore[i]));
               isButtonClicked[i] = false;
            }
            setAuto(false);
            setClick(false);
            resetCount();

         }
      });
      
      //3. 수동으로 번호 선택 시  123457 눌러야 첫 시작 화면으로. (튜토리얼 끝) 
      buttons[0].addActionListener(new ActionListener() { // 확정버튼
         @Override
         public void actionPerformed(ActionEvent e) {
             List<Integer> fixedNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
             List<Integer> fixedNumbers2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7));
             selectedNumbers = new ArrayList<>();
             
             inputSelectedNumbers();
             System.out.println(selectedNumbers.toString());
             System.out.println(selectedNumbers.containsAll(fixedNumbers));
                     buttons[0].addMouseListener(new MouseAdapter() {
                         @Override
                         public void mouseClicked(MouseEvent e) {
                        	 if (selectedNumbers.containsAll(fixedNumbers)) {
                             Management.card.show(Management.all, "튜토리얼12");
                        	 }else if (!(selectedNumbers.containsAll(fixedNumbers))&&selectedNumbers.containsAll(fixedNumbers2)) {
                                 for (JButton button : lottoNumBtn) {
                                     button.setBackground(null);
                                  }
                                  for (int i = 0; i < lottoNumBtn.length; i++) {
                                     lottoNumBtn[i].setIcon(new ImageIcon(imageArrBefore[i]));
                                     isButtonClicked[i] = false;
                                  }
                                  setAuto(false);
                                  setClick(false);
                                  resetCount();
                        		 
                        		 Management.card.show(Management.all, "튜토리얼13");
      						}
                        	 
                         }
                     });
                     
                     buttons[0].addMouseListener(new MouseAdapter() {
                         @Override
                         public void mouseClicked(MouseEvent e) {
                        	
                         }
                     });
           
                  

                     //Management.card.show(Management.all, "시작");
                 }
                 
             });

      oneTicketPanel.setBounds(0, 0, 340, 550);
      setLayout(null);
      add(oneTicketPanel);

   }

}

// 액션 리스너
class Tutorial2MyListener implements ActionListener {
   private TutorialTicket2 lt1;

	ResourceSoundPack resourceSoundPack = new ResourceSoundPack();
   public Tutorial2MyListener(TutorialTicket2 lt1) {
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
         if (lt1.getChangeCount() == 6) {
            lt1.setSixSelected(true);
            for (JButton button : lt1.lottoNumBtn) {
               if (!button.getBackground().equals(Color.RED)) {
                  int index = Arrays.asList(lt1.lottoNumBtn).indexOf(button);
                  URL urlOfScreen = LottoTicket1.class.getClassLoader()
                        .getResource("image/unNumber" + " " + "(" + (index + 1) + ")" + ".gif");
                  ImageIcon blackWhiteIcon = new ImageIcon(urlOfScreen);
                  button.setIcon(blackWhiteIcon);
               }
            }
         }
         resourceSoundPack.numSound();
      } else if (!source.getBackground().equals(Color.RED) && lt1.getChangeCount() == 6) {
      } else if (source.getBackground().equals(Color.RED) && lt1.getChangeCount() == 1 && lt1.isClick() == true) {
         source.setBackground(null);
         lt1.decreaseCount();
         lt1.setAuto(false);
         lt1.setClick(false);
         lt1.resetCount();
         lt1.restoreImage(source);
      } else if (lt1.getChangeCount() <= 6) {
         source.setBackground(null);
         lt1.restoreImage(source);
         lt1.decreaseCount();
      } else if (lt1.getChangeCount() == 6) {
         source.setBackground(null);
         lt1.decreaseCount();
      }
      resourceSoundPack.numSound();
      if (lt1.getChangeCount() < 6) {
         lt1.setSixSelected(false);
         for (JButton button : lt1.lottoNumBtn) {
            if (!button.getBackground().equals(Color.RED)) {
               int index = Arrays.asList(lt1.lottoNumBtn).indexOf(button);
               URL urlOfScreen = LottoTicket1.class.getClassLoader()
                     .getResource("image/defaultNumber" + " " + "(" + (index + 1) + ")" + ".gif");
               ImageIcon defaultIcon = new ImageIcon(urlOfScreen);
               button.setIcon(defaultIcon);
            }
         }
      }
   }
}
   