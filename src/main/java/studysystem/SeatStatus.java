package studysystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class SeatStatus extends JFrame{


   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               SeatStatus window = new SeatStatus();
               window.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the application.
    */
   public SeatStatus() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      setBounds(100, 100, 469, 297);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //메뉴바 추가
      setJMenuBar(MenuUtill.createMenuBar(this));

      JButton btnSeat1 = new JButton("1");
      btnSeat1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat1.getText());
         }
      });
      
      JButton btnSeat2 = new JButton("2");
      btnSeat2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat2.getText());
         }
      });
      
      JButton btnSeat3 = new JButton("3");
      btnSeat3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat3.getText());
         }
      });
      
      JButton btnSeat4 = new JButton("4");
      btnSeat4.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat4.getText());
         }
      });
      
      JButton btnSeat5 = new JButton("5");
      btnSeat5.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat5.getText());
         }
      });
      
      JButton btnSeat6 = new JButton("6");
      btnSeat6.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat6.getText());
         }
      });
      
      JButton btnSeat7 = new JButton("7");
      btnSeat7.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat7.getText());
         }
      });
      
      JButton btnSeat8 = new JButton("8");
      btnSeat8.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat8.getText());
         }
      });
      
      JButton btnSeat9 = new JButton("9");
      btnSeat9.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat9.getText());
         }
      });
      
      JButton btnSeat10 = new JButton("10");
      btnSeat10.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat10.getText());
         }
      });
      
      JButton btnSeat11 = new JButton("11");
      btnSeat11.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat11.getText());
         }
      });
      
      JButton btnSeat12 = new JButton("12");
      btnSeat12.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat12.getText());
         }
      });
      
      JButton btnSeat13 = new JButton("13");
      btnSeat13.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat13.getText());
         }
      });
      
      JButton btnSeat14 = new JButton("14");
      btnSeat14.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat14.getText());
         }
      });
      
      JButton btnSeat15 = new JButton("15");
      btnSeat15.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat15.getText());
         }
      });
      
      JButton btnSeat17 = new JButton("17");
      btnSeat17.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat17.getText());
         }
      });
      
      JButton btnSeat16 = new JButton("16");
      btnSeat16.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat16.getText());
         }
      });
      
      JButton btnSeat18 = new JButton("18");
      btnSeat18.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat18.getText());
         }
      });
      
      JButton btnSeat20 = new JButton("20");
      btnSeat20.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat20.getText());
         }
      });
      
      JButton btnSeat21 = new JButton("21");
      btnSeat21.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat21.getText());
         }
      });
      
      JButton btnSeat19 = new JButton("19");
      btnSeat19.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat19.getText());
         }
      });
      
      JButton btnSeat22 = new JButton("22");
      btnSeat22.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat22.getText());
         }
      });
      
      JButton btnSeat24 = new JButton("24");
      btnSeat24.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat24.getText());
         }
      });
      
      JButton btnSeat25 = new JButton("25");
      btnSeat25.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat25.getText());
         }
      });
      
      JButton btnSeat23 = new JButton("23");
      btnSeat23.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat23.getText());
         }
      });
      
      JButton btnSeat26 = new JButton("26");
      btnSeat26.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat26.getText());
         }
      });
      
      JButton btnSeat27 = new JButton("27");
      btnSeat27.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat27.getText());
         }
      });
      
      JButton btnSeat28 = new JButton("28");
      btnSeat28.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat28.getText());
         }
      });
      
      JButton btnSeat29 = new JButton("29");
      btnSeat29.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat29.getText());
         }
      });
      
      JButton btnSeat30 = new JButton("30");
      btnSeat30.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat30.getText());
         }
      });
      
      JButton btnSeat31 = new JButton("31");
      btnSeat31.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat31.getText());
         }
      });
      
      JButton btnSeat32 = new JButton("32");
      btnSeat32.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat32.getText());
         }
      });
      
      JButton btnSeat33 = new JButton("33");
      btnSeat33.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat33.getText());
         }
      });
      
      JButton btnSeat34 = new JButton("34");
      btnSeat34.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat34.getText());
         }
      });
      GroupLayout groupLayout = new GroupLayout(getContentPane());
      groupLayout.setHorizontalGroup(
      	groupLayout.createParallelGroup(Alignment.LEADING)
      		.addGroup(groupLayout.createSequentialGroup()
      			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(250)
      					.addComponent(btnSeat6, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(50)
      					.addComponent(btnSeat2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(350)
      					.addComponent(btnSeat8, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(100)
      					.addComponent(btnSeat3, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(150)
      					.addComponent(btnSeat4, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
      				.addComponent(btnSeat1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(200)
      					.addComponent(btnSeat5, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(300)
      					.addComponent(btnSeat7, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)))
      			.addGap(1)
      			.addComponent(btnSeat9, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
      		.addGroup(groupLayout.createSequentialGroup()
      			.addGap(50)
      			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
      				.addComponent(btnSeat10, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(50)
      					.addComponent(btnSeat13, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(50)
      					.addComponent(btnSeat11, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
      				.addComponent(btnSeat12, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
      			.addGap(99)
      			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
      				.addComponent(btnSeat16, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
      				.addComponent(btnSeat14, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(50)
      					.addComponent(btnSeat15, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(50)
      					.addComponent(btnSeat17, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))))
      		.addGroup(groupLayout.createSequentialGroup()
      			.addGap(50)
      			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(50)
      					.addComponent(btnSeat21, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
      				.addComponent(btnSeat20, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
      				.addComponent(btnSeat18, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(50)
      					.addComponent(btnSeat19, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)))
      			.addGap(99)
      			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
      				.addComponent(btnSeat22, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(50)
      					.addComponent(btnSeat23, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
      				.addComponent(btnSeat24, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(50)
      					.addComponent(btnSeat25, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))))
      		.addGroup(groupLayout.createSequentialGroup()
      			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(350)
      					.addComponent(btnSeat33, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(150)
      					.addComponent(btnSeat29, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(300)
      					.addComponent(btnSeat32, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(100)
      					.addComponent(btnSeat28, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(250)
      					.addComponent(btnSeat31, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(200)
      					.addComponent(btnSeat30, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
      				.addComponent(btnSeat26, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(50)
      					.addComponent(btnSeat27, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)))
      			.addGap(1)
      			.addComponent(btnSeat34, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
      );
      groupLayout.setVerticalGroup(
      	groupLayout.createParallelGroup(Alignment.LEADING)
      		.addGroup(groupLayout.createSequentialGroup()
      			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
      				.addComponent(btnSeat6, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
      				.addComponent(btnSeat2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
      				.addComponent(btnSeat8, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
      				.addComponent(btnSeat3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
      				.addComponent(btnSeat4, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
      				.addComponent(btnSeat1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
      				.addComponent(btnSeat5, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
      				.addComponent(btnSeat7, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
      				.addComponent(btnSeat9, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
      			.addGap(10)
      			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
      				.addComponent(btnSeat10, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(35)
      					.addComponent(btnSeat13, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
      				.addComponent(btnSeat11, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(35)
      					.addComponent(btnSeat12, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(35)
      					.addComponent(btnSeat16, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
      				.addComponent(btnSeat14, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
      				.addComponent(btnSeat15, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(35)
      					.addComponent(btnSeat17, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
      			.addGap(20)
      			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(35)
      					.addComponent(btnSeat21, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(35)
      					.addComponent(btnSeat20, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
      				.addComponent(btnSeat18, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
      				.addComponent(btnSeat19, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
      				.addComponent(btnSeat22, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
      				.addComponent(btnSeat23, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(35)
      					.addComponent(btnSeat24, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
      				.addGroup(groupLayout.createSequentialGroup()
      					.addGap(35)
      					.addComponent(btnSeat25, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
      			.addGap(14)
      			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
      				.addComponent(btnSeat33, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
      				.addComponent(btnSeat29, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
      				.addComponent(btnSeat32, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
      				.addComponent(btnSeat28, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
      				.addComponent(btnSeat31, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
      				.addComponent(btnSeat30, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
      				.addComponent(btnSeat26, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
      				.addComponent(btnSeat27, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
      				.addComponent(btnSeat34, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
      );
      getContentPane().setLayout(groupLayout);
   }
   
   // 닫고 열기 함수
   private void OpenClose(String chairNum) {
      System.out.println(chairNum);
      dispose();
      SeatReservation stst = new SeatReservation(chairNum);
      stst.setVisible(true);
   }
}