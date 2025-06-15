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

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
        setTitle("Seat Reservation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //메뉴바 추가
        setJMenuBar(MenuUtill.createMenuBar(this));

        setSize(363, 330);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        // Back button column fixed 40px, content grows
        getContentPane().setLayout(new MigLayout("insets 20", "[40!][grow]", "[]15[]15[]15[]30[]"));

        // Back button
        btnBack = new FlatButton();
        btnBack.setText("<");
        btnBack.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnBack.setBackground(new Color(238, 238, 238));
        btnBack.addActionListener((ActionEvent e) -> {
            new SeatStatus().setVisible(true);
            dispose();
        });
        getContentPane().add(btnBack, "cell 0 0, aligny center");
        addHoverAnimation(btnBack);

        // Title
        JLabel lblTitle = new JLabel("Seat Reservation");
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitle.setForeground(new Color(45, 118, 232));
        getContentPane().add(lblTitle, "cell 1 0, alignx center, wrap");

        // Seat number label & value
        getContentPane().add(new JLabel("Seat:"), "cell 0 1, right");
        JLabel lblSeat = new JLabel(chairNum);
        lblSeat.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        getContentPane().add(lblSeat, "cell 1 1, wrap");

        // Date combo
        getContentPane().add(new JLabel("Date:"), "cell 0 2, right");
        dateCombo = new JComboBox<>();
        LocalDate today = LocalDate.now();
        for (int i = 0; i < 7; i++) {
            LocalDate d = today.plusDays(i);
            dateCombo.addItem(d.getMonthValue() + "월 " + d.getDayOfMonth() + "일");
        }
        dateCombo.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        getContentPane().add(dateCombo, "cell 1 2, growx, wrap");

        // Time combo
        getContentPane().add(new JLabel("Time:"), "cell 0 3, right");
        timeCombo = new JComboBox<>();
        for (int h = 0; h < 24; h++) {
            timeCombo.addItem(String.format("%02d:00", h));
        }
        timeCombo.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        getContentPane().add(timeCombo, "cell 1 3, growx, wrap");

        // Reserve button
        btnReserve = new FlatButton();
        btnReserve.setText("Reserve");
        btnReserve.setFont(new Font("Segoe UI", Font.BOLD, 18));
        btnReserve.setBackground(new Color(45, 118, 232));
        btnReserve.setForeground(Color.WHITE);
        btnReserve.addActionListener((ActionEvent e) -> reserveSeat(chairNum));
        getContentPane().add(btnReserve, "span 2, alignx center, w 120!, h 40!");
        addHoverAnimation(btnReserve);
    }

    private void reserveSeat(String chairNum) {
        String selectedDate = (String) dateCombo.getSelectedItem();
        String selectedTime = (String) timeCombo.getSelectedItem();
        String userId = UserSession.getUsername();
        String sql = "INSERT INTO reservations (user_id, seat, date, time) VALUES (?, ?, ?, ?)";
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

    private void addHoverAnimation(FlatButton btn) {
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Timeline t = new Timeline(btn);
                t.addPropertyToInterpolate("background", btn.getBackground(), btn.getBackground().brighter());
                t.setDuration(200);
                t.play();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                Timeline t = new Timeline(btn);
                t.addPropertyToInterpolate("background", btn.getBackground().brighter(), btn.getBackground());
                t.setDuration(200);
                t.play();
            }
        });
    }
}
