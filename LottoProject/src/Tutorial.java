import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

    //시작페이지 1 
public class Tutorial extends JPanel {
   JLabel label;
   Management management;

   public Tutorial() { 
      label = new JLabel();
      ImageIcon icon = new ImageIcon("LottoProject/src/image5/튜토리얼_1.jpg");
      label.setIcon(icon);
      label.addMouseListener((MouseListener) new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            Management.card.show(Management.all, "튜토리얼2");

         }
      });
      setLayout(new BorderLayout());
      add(label);
      setBounds(0, 0, 340, 550);
      setVisible(true);

   }
}

    //시작페이지 2 
   class Tutorial2 extends JPanel {
      JLabel label;
      Management management;

      public Tutorial2() { 
         label = new JLabel();
         ImageIcon icon = new ImageIcon("LottoProject/src/image5/튜토리얼_2.jpg");
         label.setIcon(icon);
         label.addMouseListener((MouseListener) new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               Management.card.show(Management.all, "튜토리얼3");
            }
         });

         setLayout(new BorderLayout());
         add(label);
         setBounds(0, 0, 340, 550);
         setVisible(true);

      }
   }
    //시작페이지 3 
    class Tutorial3 extends JPanel {
      JLabel label;
      Management management;

      public Tutorial3() {
         label = new JLabel();
         ImageIcon icon = new ImageIcon("LottoProject/src/image5/튜토리얼_3.jpg");
         label.setIcon(icon);
         label.addMouseListener((MouseListener) new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               Management.card.show(Management.all, "튜토리얼4");
            }
         });

         setLayout(new BorderLayout());
         add(label);
         setBounds(0, 0, 340, 550);
         setVisible(true);

      }
   }
    // 버튼소개 페이지 
   class Tutorial4 extends JPanel {
      JLabel label;
      Management management;

      public Tutorial4() {

         // 배경
         label = new JLabel();
         ImageIcon icon = new ImageIcon("LottoProject/src/image5/튜토리얼_4.jpg");
         label.setIcon(icon);
         label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
         

         // 로또 하러가기 버튼
         JButton b1 = new JButton();
         ImageIcon icon2 = new ImageIcon("LottoProject/src/image5/튜토리얼_5.jpg");
         b1.setIcon(icon2);
         b1.setBounds(85, 430, icon2.getIconWidth(), icon2.getIconHeight());
         b1.setBorderPainted(false);
         
         b1.addActionListener(new ActionListener() {      
            @Override
            public void actionPerformed(ActionEvent e) {
               Management.card.show(Management.all, "튜토리얼6");
               
            }
         });

         setLayout(new BorderLayout());
         add(b1);
         add(label);
         setBounds(0, 0, 340, 550);
         setVisible(true);


      }
   }
   
    // 로또 하러가기 버튼 선택 페이지 
   class Tutorial5 extends JPanel {
      JLabel label;
      Management management;

      public Tutorial5() {
         label = new JLabel();
         ImageIcon icon = new ImageIcon("LottoProject/src/image5/튜토리얼_6.jpg");
         label.setIcon(icon);

         label.addMouseListener((MouseListener) new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               Management.card.show(Management.all, "튜토리얼6");
            }
         });

         setLayout(new BorderLayout());
         add(label);
         setBounds(0, 0, 340, 550);
         setVisible(true);


      }
   }

   // 슬롯 설명 페이지 
   class Tutorial6 extends JPanel {
      JLabel label;
      Management management;

      public Tutorial6() {
         label = new JLabel();
         ImageIcon icon = new ImageIcon("LottoProject/src/image5/튜토리얼_7.jpg");
         label.setIcon(icon);
         label.addMouseListener((MouseListener) new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               Management.card.show(Management.all, "튜토리얼7");
            }
         });

         setLayout(new BorderLayout());
         add(label);
         setBounds(0, 0, 340, 550);
         setVisible(true);


      }
   }
   
   // 빈슬롯 버튼 페이지 
   class Tutorial7 extends JPanel {
      JLabel label;
      Management management;

      public Tutorial7() {
         // 배경
         label = new JLabel();
         ImageIcon icon = new ImageIcon("LottoProject/src/image5/튜토리얼_8.jpg");
         label.setIcon(icon);
         label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

         // 빈슬롯 버튼
         JButton b1 = new JButton();
         ImageIcon icon2 = new ImageIcon("LottoProject/src/image5/튜토리얼_9.jpg");
         b1.setIcon(icon2);
         b1.setBounds(12, 86, icon2.getIconWidth(), icon2.getIconHeight());
         b1.setBorderPainted(false);

         b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Management.card.show(Management.all, "튜토리얼8");
               
            }
         });
         
         setLayout(new BorderLayout());
         add(b1);
         add(label);
         setBounds(0, 0, 340, 550);
         setVisible(true);


      }
   }
/*
   // 번호 고르는 페이지 (수정해야함)
   class Tutorial8 extends JPanel {
      JPanel panel;
      JLabel label;
      Management management;

      public Tutorial8() {
         panel = new JPanel();
         label = new JLabel();
         ImageIcon icon = new ImageIcon("LottoProject/src/image5/튜토리얼_10.jpg");
         label.setIcon(icon);
         label.addMouseListener((MouseListener) new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               Management.card.show(Management.all, "시작");
            }
         });

         panel.add(label);
         add(panel);
         setSize(340, 550);
         setVisible(true);


      }
   }
*/