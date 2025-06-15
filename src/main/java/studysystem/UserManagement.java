package studysystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import studysystem.DB.ButtonEditor;
import studysystem.DB.ButtonRenderer;

import java.awt.*;
import java.util.List;

public class UserManagement extends JFrame {

    private JTable userTable;
    private DefaultTableModel tableModel;

    public UserManagement() {
       
       // JFrame 세팅 + 내용 구성
        setTitle("User Management");
        setBounds(100, 100, 317, 326);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("User Management");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        String[] columnNames = {"아이디", "이메일", "삭제"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2; // 삭제 버튼만 활성화
            }
        };

        userTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(userTable);
        add(scrollPane, BorderLayout.CENTER);

        loadUserList();

        // 삭제 버튼 클릭 감지
        userTable.getColumn("삭제").setCellRenderer(new ButtonRenderer());
        userTable.getColumn("삭제").setCellEditor(new ButtonEditor(new JCheckBox(), this));
    }

    private void loadUserList() {
        List<DB.Member> members = DB.getAllMembers();
        tableModel.setRowCount(0); // 기존 데이터 초기화
        for (DB.Member m : members) {
            tableModel.addRow(new Object[]{m.id, m.email, "삭제"});
        }
    }

    public void refreshTable() {
        loadUserList();
    }

    public JTable getUserTable() {
        return userTable;
    }
}