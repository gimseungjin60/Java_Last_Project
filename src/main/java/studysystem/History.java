package studysystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import studysystem.DB.ButtonEditor;
import studysystem.DB.ButtonRenderer;
import studysystem.DB.HistoryButtonEditor;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class History extends JFrame {
    public History() {
        setTitle("Reservation History");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 메인 패널 생성
        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 484, 452);
        mainPanel.setLayout(null);
      //메뉴바 추가
        setJMenuBar(MenuUtill.createMenuBar(this));

        JLabel titleLabel = new JLabel("          예약 내역");
        titleLabel.setBounds(12, -1, 417, 31);
        titleLabel.setFont(new Font("굴림", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel);
        String reSeat;
        String[] columnNames = { "Date", "Time", "Seat", "delete" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/studysystem", "root", "rootroot");

            String sql = "SELECT date, time, seat FROM reservations WHERE user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, UserSession.getUsername());

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String date = rs.getString("date");
                String time = rs.getString("time");
                String seat = rs.getString("seat");
                

                model.addRow(new Object[]{date, time, seat, "delete"});
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        JTable table = new JTable(model);
        table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
        getContentPane().setLayout(null);
        table.getColumn("delete").setCellEditor(new HistoryButtonEditor(new JCheckBox(), table, model));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 30, 484, 428);
        mainPanel.add(scrollPane);

        // 스크롤 가능한 전체 프레임에 mainPanel 추가
        getContentPane().add(mainPanel);
        
        JButton btnNewButton = new JButton("<");
        btnNewButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
        	   new SeatStatus().setVisible(true);
        	   }
        });
        btnNewButton.setBounds(407, 0, 77, 32);
        mainPanel.add(btnNewButton);
    }
}