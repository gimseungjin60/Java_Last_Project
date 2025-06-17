package studysystem;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

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
        setSize(550, 850);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 메인 패널 생성
        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 534, 778);
        mainPanel.setLayout(null);
      //메뉴바 추가
        setJMenuBar(MenuUtill.createMenuBar(this));

        JLabel titleLabel = new JLabel("       예약 내역");
        titleLabel.setForeground(new Color(0, 0, 0));
        titleLabel.setBackground(new Color(255, 255, 255));
        titleLabel.setBounds(22, 210, 407, 32);
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 26));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel);
        String reSeat;
        String[] columnNames = { "data", "time", "seat", "delete" };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        try {
            Connection conn = DB.getConnection();

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
        table.setFont(new Font("맑은 고딕", Font.PLAIN, 16));       // 표 내용 폰트
        table.setRowHeight(30);                                    // 행 높이
        table.setGridColor(Color.LIGHT_GRAY); 
        table.setGridColor(new Color(230, 230, 230));
        table.setShowHorizontalLines(true);
        
     // 컬럼 헤더 스타일 변경
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("맑은 고딕", Font.BOLD, 16));        // 헤더 폰트
        header.setBackground(new Color(200, 230, 250));            // 헤더 배경색
        header.setForeground(Color.BLACK);                         // 헤더 글자색
        header.setReorderingAllowed(false);                        // 컬럼 이동 비활성화
     // 셀 정렬 (가운데 정렬)
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // 테이블 배경색 및 라인 없애기
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        table.setBackground(new Color(255, 255, 255, 180)); // 약간 투명하게
        table.setOpaque(false);
        
        getContentPane().setLayout(null);
        table.getColumn("delete").setCellEditor(new HistoryButtonEditor(new JCheckBox(), table, model));
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBounds(12, 254, 510, 233);
        mainPanel.setFont(new Font("굴림", Font.BOLD, 20));
        mainPanel.add(scrollPane);
        

        // 스크롤 가능한 전체 프레임에 mainPanel 추가
        getContentPane().add(mainPanel);
        
        JButton btnNewButton = new JButton("<");

        // 👉 스타일 설정
        btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        btnNewButton.setBackground(new Color(173, 216, 230)); // 연한 하늘색
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.setFocusPainted(false);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setOpaque(true);
        btnNewButton.setContentAreaFilled(true); // 배경 채우기
        btnNewButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
              new SeatStatus().setVisible(true);
              dispose();
              }
        });
        btnNewButton.setBounds(456, 210, 66, 32);
        mainPanel.add(btnNewButton);
        
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(History.class.getResource("/images/oceans.png")));
        lblNewLabel.setBounds(0, 0, 550, 850);
        mainPanel.add(lblNewLabel);
    }
}
