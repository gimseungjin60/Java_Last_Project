package studysystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;
import org.pushingpixels.trident.Timeline;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.extras.components.FlatButton;

public class SeatReservation extends JFrame {
    private JComboBox<String> dateCombo;
    private JComboBox<String> timeCombo;
    private FlatButton btnReserve;
    private FlatButton btnBack;

    public static void main(String[] args) {
        // FlatLaf 테마 적용
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        EventQueue.invokeLater(() -> new SeatReservation("1").setVisible(true));
    }

    public SeatReservation(String chairNum) {
        initialize(chairNum);
    }

    private void initialize(String chairNum) {
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/oceans.png"));
        setTitle("Seat Reservation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 850);
        setLocationRelativeTo(null);
        setResizable(true);
        setJMenuBar(MenuUtill.createMenuBar(this));
        getContentPane().setLayout(null);

        // ✅ 반투명 패널 생성
        JPanel translucentPanel = new JPanel();
        translucentPanel.setBackground(new Color(255, 255, 255, 180)); // 반투명 흰 배경
        translucentPanel.setLayout(null); 
        translucentPanel.setBounds(12, 279, 500, 296);
        getContentPane().add(translucentPanel);

        // Title
        JLabel lblTitle = new JLabel("Seat Reservation") {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
                g2.setFont(getFont());
                g2.setColor(Color.BLACK);
                g2.drawString(getText(), 3, getBaseline(getWidth(), getHeight()) + 3);
                g2.setColor(Color.WHITE);
                g2.drawString(getText(), 0, getBaseline(getWidth(), getHeight()));
                g2.dispose();
            }
        };
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 32));
        lblTitle.setBounds(121, 199, 400, 50);
        getContentPane().add(lblTitle);

        // Seat Label
        JLabel lblSeatTitle = new JLabel("Seat:");
        lblSeatTitle.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        lblSeatTitle.setBounds(30, 20, 60, 30);
        translucentPanel.add(lblSeatTitle);

        JLabel lblSeat = new JLabel(chairNum + "번 좌석");
        lblSeat.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
        lblSeat.setBounds(100, 20, 300, 30);
        translucentPanel.add(lblSeat);

        // Date
        JLabel lblDate = new JLabel("Date:");
        lblDate.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        lblDate.setBounds(30, 80, 60, 30);
        translucentPanel.add(lblDate);

        dateCombo = new JComboBox<>();
        dateCombo.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        dateCombo.setBounds(100, 80, 350, 35);
        LocalDate today = LocalDate.now();
        for (int i = 0; i < 7; i++) {
            LocalDate d = today.plusDays(i);
            dateCombo.addItem(d.getMonthValue() + "월 " + d.getDayOfMonth() + "일");
        }
        translucentPanel.add(dateCombo);

        // Time
        JLabel lblTime = new JLabel("Time:");
        lblTime.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        lblTime.setBounds(30, 140, 60, 30);
        translucentPanel.add(lblTime);

        timeCombo = new JComboBox<>();
        timeCombo.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        timeCombo.setBounds(100, 140, 350, 35);
        timeCombo.setVisible(false);  // 처음에는 숨김
        translucentPanel.add(timeCombo);    // 👈 시간 콤보박스를 보여줌
        dateCombo.addActionListener(e -> {
            updateTimeOptions();          // 시간 리스트 갱신
            timeCombo.setVisible(true);   // 날짜 선택 시 항상 보여줌
        });

        // Reserve Button
        btnReserve = new FlatButton();
        btnReserve.setText("Reserve");
        btnReserve.setFont(new Font("Segoe UI", Font.BOLD, 20));
        btnReserve.setBackground(new Color(66, 133, 244));
        btnReserve.setForeground(Color.WHITE);
        btnReserve.setBounds(160, 210, 180, 45);
        btnReserve.addActionListener(e -> reserveSeat(chairNum));
        translucentPanel.add(btnReserve);

        // Back 버튼
        btnBack = new FlatButton();
        btnBack.setText("<");
        btnBack.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnBack.setBackground(new Color(238, 238, 238));
        btnBack.setBounds(20, 20, 45, 30);
        btnBack.addActionListener(e -> {
            new SeatStatus().setVisible(true);
            dispose();
        });
        getContentPane().add(btnBack);

        // 배경 이미지 마지막에 추가
        JLabel lblBackground = new JLabel("");
        lblBackground.setBounds(0, 0, 550, 850);
        lblBackground.setIcon(icon);
        getContentPane().add(lblBackground);
    }

    private void reserveSeat(String chairNum) {
        String selectedDate = (String) dateCombo.getSelectedItem();
        String selectedTime = (String) timeCombo.getSelectedItem();
        String userId = UserSession.getUsername();

        String sql = "INSERT INTO reservations (user_id, seat, date, `time`) VALUES (?, ?, ?, ?)";

        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, userId);
            stmt.setString(2, "Seat " + String.format("%02d", Integer.parseInt(chairNum)));
            stmt.setString(3, selectedDate);
            stmt.setString(4, selectedTime);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "예약이 완료되었습니다!");
            new History().setVisible(true);
            dispose();

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                "예약 중 오류가 발생했습니다:\n" + ex.getMessage(),
                "오류", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private void updateTimeOptions() {
       timeCombo.removeAllItems(); // 기존 옵션 제거
        String selectedDateStr = (String) dateCombo.getSelectedItem();
        LocalDate selectedDate = parseDate(selectedDateStr);
        LocalDate today = LocalDate.now();
        int currentHour = java.time.LocalTime.now().getHour();

        if (selectedDate != null && selectedDate.isEqual(today)) {
            // 오늘 날짜: 현재 시간 기준 +1부터
            for (int h = currentHour + 1; h < 24; h++) {
                timeCombo.addItem(String.format("%02d:00", h));
            }
        } else {
            // 이후 날짜: 0시부터 23시까지
            for (int h = 0; h < 24; h++) {
                timeCombo.addItem(String.format("%02d:00", h));
            }
        }

        // 예외 처리: 더 이상 선택 가능한 시간이 없는 경우
        if (timeCombo.getItemCount() == 0) {
            timeCombo.addItem("예약 불가");
            timeCombo.setEnabled(false);
        } else {
            timeCombo.setEnabled(true);
        }
    }
    
    //
    private LocalDate parseDate(String dateStr) {
        try {
            String[] parts = dateStr.replace("월", "").replace("일", "").trim().split(" ");
            int month = Integer.parseInt(parts[0]);
            int day = Integer.parseInt(parts[1]);
            return LocalDate.of(LocalDate.now().getYear(), month, day);
        } catch (Exception e) {
            return null;
        }
    }
}
