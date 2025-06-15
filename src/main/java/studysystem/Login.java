package studysystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.ImageIcon;
//현재 시간 나타내는 import 추가
import javax.swing.Timer;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Login extends JFrame {
    private FlatTextField txtId;
    private FlatPasswordField txtPassword;
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
        getContentPane().setBackground(Color.WHITE);
        
        //현재 시간 나타내는 기능
        NowTime = new JLabel("00:00:00");  // 지역 변수 없이 바로 할당
        NowTime.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        NowTime.setBounds(336, 134, 186, 75);
        getContentPane().add(NowTime);
        
        // 아이디 입력 (placeholder manually)
        txtId = new FlatTextField();
        txtId.setBounds(20, 209, 502, 40);
        txtId.setText("아이디");
        txtId.setForeground(Color.GRAY);
        txtId.setFont(new Font("굴림", Font.PLAIN, 12));
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
        getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(0, 0, 534, 131);
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\xzver\\OneDrive\\바탕 화면\\Groovy_Baby.png"));
        getContentPane().add(lblNewLabel);
        getContentPane().add(txtId);

        // 비밀번호 입력 (placeholder manually)
        txtPassword = new FlatPasswordField();
        txtPassword.setBounds(20, 269, 502, 40);
        txtPassword.setEchoChar((char)0);
        txtPassword.setText("비밀번호");
        txtPassword.setForeground(Color.GRAY);
        txtPassword.setFont(new Font("굴림", Font.PLAIN, 12));
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
        btnLogin.setBounds(20, 329, 502, 40);
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
        btnSignUp.setBounds(20, 376, 502, 40);
        btnSignUp.setText("회원가입");
        btnSignUp.setFont(new Font("굴림", Font.BOLD, 18));
        btnSignUp.addActionListener((ActionEvent e) -> {
            dispose();
            new SignUp().setVisible(true);
        });
        getContentPane().add(btnSignUp);
        addHoverAnimation(btnSignUp);
        
        NowTime.setBounds(336, 134, 186, 75);
        getContentPane().add(NowTime);
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
}