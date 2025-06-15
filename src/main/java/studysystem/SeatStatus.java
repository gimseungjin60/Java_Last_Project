package studysystem;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class SeatStatus extends JFrame{

	
	private Map<String, JButton> seatButtons = new HashMap<>();

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
      setSize(550, 850);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //메뉴바 추가
      setJMenuBar(MenuUtill.createMenuBar(this));
      
      // 클래스 필드 상단에 추가

      JButton btnSeat1 = new JButton("1");
      seatButtons.put("1", btnSeat1);
      btnSeat1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat1.getText());
         }
      });
      
      JButton btnSeat2 = new JButton("2");
      seatButtons.put("2", btnSeat2);
      btnSeat2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat2.getText());
         }
      });
      
      JButton btnSeat3 = new JButton("3");
      seatButtons.put("3", btnSeat3);
      btnSeat3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat3.getText());
         }
      });
      
      JButton btnSeat4 = new JButton("4");
      seatButtons.put("4", btnSeat4);
      btnSeat4.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat4.getText());
         }
      });
      
      JButton btnSeat5 = new JButton("5");
      seatButtons.put("5", btnSeat5);
      btnSeat5.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat5.getText());
         }
      });
      
      JButton btnSeat6 = new JButton("6");
      seatButtons.put("6", btnSeat6);
      btnSeat6.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat6.getText());
         }
      });
      
      JButton btnSeat7 = new JButton("7");
      seatButtons.put("7", btnSeat7);
      btnSeat7.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat7.getText());
         }
      });
      
      JButton btnSeat8 = new JButton("8");
      seatButtons.put("8", btnSeat8);
      btnSeat8.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat8.getText());
         }
      });
      
      JButton btnSeat9 = new JButton("9");
      seatButtons.put("9", btnSeat9);
      btnSeat9.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat9.getText());
         }
      });
      
      JButton btnSeat10 = new JButton("10");
      seatButtons.put("10", btnSeat10);
      btnSeat10.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat10.getText());
         }
      });
      
      JButton btnSeat11 = new JButton("11");
      seatButtons.put("11", btnSeat11);
      btnSeat11.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat11.getText());
         }
      });
      
      JButton btnSeat12 = new JButton("12");
      seatButtons.put("12", btnSeat12);
      btnSeat12.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat12.getText());
         }
      });
      
      JButton btnSeat13 = new JButton("13");
      seatButtons.put("13", btnSeat13);
      btnSeat13.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat13.getText());
         }
      });
      
      JButton btnSeat14 = new JButton("14");
      seatButtons.put("14", btnSeat14);
      btnSeat14.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat14.getText());
         }
      });
      
      JButton btnSeat15 = new JButton("15");
      seatButtons.put("15", btnSeat15);
      btnSeat15.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat15.getText());
         }
      });
      
      JButton btnSeat17 = new JButton("17");
      seatButtons.put("17", btnSeat17);
      btnSeat17.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat17.getText());
         }
      });
      
      JButton btnSeat16 = new JButton("16");
      seatButtons.put("16", btnSeat16);
      btnSeat16.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat16.getText());
         }
      });
      
      JButton btnSeat18 = new JButton("18");
      seatButtons.put("18", btnSeat18);
      btnSeat18.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat18.getText());
         }
      });
      
      JButton btnSeat20 = new JButton("20");
      seatButtons.put("20", btnSeat20);
      btnSeat20.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat20.getText());
         }
      });
      
      JButton btnSeat21 = new JButton("21");
      seatButtons.put("21", btnSeat21);
      btnSeat21.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat21.getText());
         }
      });
      
      JButton btnSeat19 = new JButton("19");
      seatButtons.put("19", btnSeat19);
      btnSeat19.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat19.getText());
         }
      });
      
      JButton btnSeat22 = new JButton("22");
      seatButtons.put("22", btnSeat22);
      btnSeat22.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat22.getText());
         }
      });
      
      JButton btnSeat24 = new JButton("24");
      seatButtons.put("24", btnSeat24);
      btnSeat24.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat24.getText());
         }
      });
      
      JButton btnSeat25 = new JButton("25");
      seatButtons.put("25", btnSeat25);
      btnSeat25.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat25.getText());
         }
      });
      
      JButton btnSeat23 = new JButton("23");
      seatButtons.put("23", btnSeat23);
      btnSeat23.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat23.getText());
         }
      });
      
      JButton btnSeat26 = new JButton("26");
      seatButtons.put("26", btnSeat26);
      btnSeat26.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat26.getText());
         }
      });
      
      JButton btnSeat27 = new JButton("27");
      seatButtons.put("27", btnSeat27);
      btnSeat27.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat27.getText());
         }
      });
      
      JButton btnSeat28 = new JButton("28");
      seatButtons.put("28", btnSeat28);
      btnSeat28.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat28.getText());
         }
      });
      
      JButton btnSeat29 = new JButton("29");
      seatButtons.put("29", btnSeat29);
      btnSeat29.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat29.getText());
         }
      });
      
      JButton btnSeat30 = new JButton("30");
      seatButtons.put("30", btnSeat30);
      btnSeat30.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat30.getText());
         }
      });
      
      JButton btnSeat31 = new JButton("31");
      seatButtons.put("31", btnSeat31);
      btnSeat31.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat31.getText());
         }
      });
      
      JButton btnSeat32 = new JButton("32");
      seatButtons.put("32", btnSeat32);
      btnSeat32.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat32.getText());
         }
      });
      
      JButton btnSeat33 = new JButton("33");
      seatButtons.put("33", btnSeat33);
      btnSeat33.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 OpenClose(btnSeat33.getText());
         }
      });
      
      JButton btnSeat34 = new JButton("34");
      seatButtons.put("34", btnSeat34);
      btnSeat34.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            OpenClose(btnSeat34.getText());
         }
      });
      
      updateReservedSeats();
      
      //예약된 좌석 처리
      try (Connection conn = DB.getConnection()) {
    	    String sql = "SELECT seat FROM reservations";
    	    PreparedStatement stmt = conn.prepareStatement(sql);
    	    ResultSet rs = stmt.executeQuery();
    	    while (rs.next()) {
    	        String seat = rs.getString("seat").replace("Seat ", "").trim();
    	        JButton btn = seatButtons.get(seat);
    	        if (btn != null) {
    	            btn.setBackground(Color.RED);
    	            btn.setEnabled(true);  // 색은 바꾸되 누를 수 있도록 유지
    	        }
    	    }
    	} catch (Exception ex) {
    	    ex.printStackTrace();
    	}
      
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
   
   private void updateReservedSeats() {
	    // 1. 모든 좌석 초기화
	    seatButtons.values().forEach(btn -> {
	        btn.setBackground(null);  // 기본 색 (null 또는 원하는 색)
	        btn.setEnabled(true);
	    });

	    // 2. 예약된 좌석만 색상 변경
	    try (Connection conn = DB.getConnection();
	         PreparedStatement stmt = conn.prepareStatement("SELECT seat FROM reservations")) {

	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	            String seatRaw = rs.getString("seat"); // 예: "Seat 01"
	            String seatNum = seatRaw.replace("Seat ", "").trim(); // "01"
	            int seatIndex = Integer.parseInt(seatNum);            // 1~34
	            String key = String.valueOf(seatIndex);               // "1" ~ "34"

	            JButton btn = seatButtons.get(key);
	            if (btn != null) {
	                btn.setBackground(Color.RED);
	            } else {
	                System.err.println("등록되지 않은 좌석 번호: " + seatRaw);
	            }
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
   
   // 닫고 열기 함수
   private void OpenClose(String chairNum) {
	   JButton btn = seatButtons.get(chairNum);
	    if (btn != null && Color.RED.equals(btn.getBackground())) {
	        JOptionPane.showMessageDialog(this, "예약된 좌석입니다.");
	        return;
	    }

	    dispose();
	    SeatReservation stst = new SeatReservation(chairNum);
	    stst.setVisible(true);
	}
}