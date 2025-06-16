 package studysystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;
import org.pushingpixels.trident.Timeline;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.extras.components.FlatTextField;
import com.formdev.flatlaf.extras.components.FlatPasswordField;
import com.formdev.flatlaf.extras.components.FlatButton;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
//현재 시간 나타내는 import 추가
import javax.swing.Timer;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPanel;
import java.awt.GridLayout;
public class Login extends JFrame {
	//둥근 텍스트 필드 만들기
    private RoundedTextField  txtId;
    private RoundedPasswordField txtPassword;
    //현재 시간 나타내는 전역 변수
    private JLabel NowTime;
    public static void main(String[] args) {
        // FlatLaf 테마 적용
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        EventQueue.invokeLater(() -> {
            Login window = new Login();
            window.setVisible(true);
        });
    }

    public Login() {
        initialize();
        startClock();
    }

    private void initialize() {
        setTitle("StudyCafe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 850);
        setLocationRelativeTo(null);
        getContentPane().setBackground(null);
        
        // 아이디 입력 (placeholder manually)
        txtId = new RoundedTextField(20);
        txtId.setBounds(20, 385, 502, 40);
        txtId.setText("아이디");
        txtId.setForeground(Color.GRAY);
        txtId.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtId.getText().equals("아이디")) {
                    txtId.setText("");
                    txtId.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtId.getText().isEmpty()) {
                    txtId.setForeground(Color.GRAY);
                    txtId.setText("아이디");
                }
            }
        });
        //사진 절대 경로로 지정 x / 상대 경로로 지정 후 클래스안에 있는 이미지 불러와야됨
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/Debugging Room.gif"));
        getContentPane().setLayout(null);
        
        getContentPane().add(txtId);

        txtPassword = new RoundedPasswordField(20);  // 둥근 입력창 생성
        txtPassword.setBounds(20, 435, 502, 40);
        txtPassword.setEchoChar((char)0);
        txtPassword.setText("비밀번호");
        txtPassword.setForeground(Color.GRAY);
        txtPassword.setFont(new Font("맑은 고딕", Font.PLAIN, 14)); // 폰트 통일
        txtPassword.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                String pw = new String(txtPassword.getPassword());
                if (pw.equals("비밀번호")) {
                    txtPassword.setText("");
                    txtPassword.setEchoChar('•');
                    txtPassword.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                String pw = new String(txtPassword.getPassword());
                if (pw.isEmpty()) {
                    txtPassword.setEchoChar((char)0);
                    txtPassword.setForeground(Color.GRAY);
                    txtPassword.setText("비밀번호");
                }
            }
        });
        getContentPane().add(txtPassword);

        // 로그인 버튼
        FlatButton btnLogin = new FlatButton();
        btnLogin.setBounds(12, 590, 502, 40);
        btnLogin.setText("로그인");
        btnLogin.setFont(new Font("굴림", Font.BOLD, 18));
        btnLogin.addActionListener((ActionEvent e) -> {
            String userId = txtId.getText().trim();
            String password = new String(txtPassword.getPassword()).trim();
            loginCheck(userId, password);
        });
        getContentPane().add(btnLogin);
        addHoverAnimation(btnLogin);

        // 회원가입 버튼
        FlatButton btnSignUp = new FlatButton();
        btnSignUp.setBounds(12, 643, 502, 40);
        btnSignUp.setText("회원가입");
        btnSignUp.setFont(new Font("굴림", Font.BOLD, 18));
        btnSignUp.addActionListener((ActionEvent e) -> {
            dispose();
            new SignUp().setVisible(true);
        });
        getContentPane().add(btnSignUp);
        addHoverAnimation(btnSignUp);
        
        RoundedPanel panel = new RoundedPanel(20);  // radius = 20
        panel.setBounds(12, 256, 512, 75);
        panel.setLayout(new GridLayout(1, 4));
        getContentPane().add(panel);
        
        JLabel rts = new JLabel();
        rts.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        panel.add(rts);
        ReaTimeSeat(rts);

        JLabel lblNewLabel_1 = new JLabel("1인 잔여좌석 ");
        lblNewLabel_1.setOpaque(false);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_3 = new JLabel("New label");
        lblNewLabel_3.setOpaque(false);
        panel.add(lblNewLabel_3);

        NowTime = new JLabel("00:00:00");
        NowTime.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        NowTime.setOpaque(false);
        panel.add(NowTime);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(0, 0, 550, 850);
        lblNewLabel.setIcon(icon);
        getContentPane().add(lblNewLabel);
    }
    private void startClock() {
        Timer timer = new Timer(1000, e -> {
            SimpleDateFormat sdf = new SimpleDateFormat("HH시 mm분 ss초");
            NowTime.setText(sdf.format(new Date()));
        });
        timer.start();
    }

    private void loginCheck(String userId, String password) {
        if (DB.loginCheck(userId, password)) {
            UserSession.setUsername(userId);
            if ("root".equals(userId) && "root1234".equals(password)) {
                JOptionPane.showMessageDialog(this, "관리자 계정입니다.");
                new UserManagement().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "로그인 성공!");
                new SeatStatus().setVisible(true);
            }
            dispose();
        } else {
            JOptionPane.showMessageDialog(this,
                "아이디 또는 비밀번호가 일치하지 않습니다.",
                "로그인 실패", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addHoverAnimation(FlatButton btn) {
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Timeline t = new Timeline(btn);
                t.addPropertyToInterpolate("background",
                    btn.getBackground(), btn.getBackground().brighter());
                t.setDuration(200);
                t.play();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                Timeline t = new Timeline(btn);
                t.addPropertyToInterpolate("background",
                    btn.getBackground().brighter(), btn.getBackground());
                t.setDuration(200);
                t.play();
            }
        });
    }
    
    private void ReaTimeSeat(JLabel seatStatusLabel) {
        int totalSeats = 34;
        int reservedCount = 0;

        String sql = "SELECT COUNT(*) FROM reservations";

        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                reservedCount = rs.getInt(1);
            }

            int availableSeats = totalSeats - reservedCount;
            seatStatusLabel.setText("잔여좌석: " + availableSeats + "석");

        } catch (Exception e) {
            e.printStackTrace();
            seatStatusLabel.setText("잔여좌석 확인 실패");
        }
    }
}