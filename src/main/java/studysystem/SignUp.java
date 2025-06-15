package studysystem;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JComponent;

import com.formdev.flatlaf.extras.components.FlatTextField;
import com.formdev.flatlaf.extras.components.FlatPasswordField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import com.formdev.flatlaf.extras.components.FlatTextField;
import com.formdev.flatlaf.extras.components.FlatPasswordField;

import net.miginfocom.swing.MigLayout;
import org.pushingpixels.trident.Timeline;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.extras.components.FlatButton;
import java.awt.Color;

public class SignUp extends JFrame {

	private FlatTextField IdText;
	private FlatPasswordField PasswordText;
	private FlatPasswordField PWCheckText;
	private FlatTextField EmailText;
	private FlatTextField NameText;

	private FlatButton btnPrev;
	private FlatButton btnComplete;

	public static void main(String[] args) {
		// FlatLaf 모던 테마 적용
		try {
			UIManager.setLookAndFeel(new FlatLightLaf());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		EventQueue.invokeLater(() -> {
			try {
				SignUp window = new SignUp();
				window.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public SignUp() {
		getContentPane().setBackground(Color.white);
		((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		initialize();
	}

	private void initialize() {
		setTitle("회원가입");
		setBounds(100, 100, 306, 302);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 2컬럼: 왼쪽 라벨 우측 정렬, 오른쪽 입력창 grow
		getContentPane().setLayout(new MigLayout("wrap 2", "[right][grow]", "[][][][][]20[][]"));

		// 아이디
		getContentPane().add(new JLabel("아이디"), "cell 0 0,alignx left,aligny bottom");
		IdText = new FlatTextField();
//	    IdText.setPlaceholder("아이디를 입력하세요");    ← placeholder 관련 호출 삭제
	     IdText.setColumns(10);
	     getContentPane().add(IdText, "cell 1 0, growx");

		// 비밀번호
		getContentPane().add(new JLabel("비밀번호"), "cell 0 1,alignx left,aligny bottom");
		// 비밀번호 "*" 별로 표시
		PasswordText = new FlatPasswordField();
//	    PasswordText.setPlaceholder("비밀번호");      ← placeholder 호출 삭제
	     PasswordText.setColumns(10);
	     getContentPane().add(PasswordText, "cell 1 1, growx");

		// 비밀번호 확인
		getContentPane().add(new JLabel("비밀번호 확인"), "cell 0 2,alignx left,aligny bottom");
		// 비밀번호 "*" 별로 표시
		PWCheckText = new FlatPasswordField();
//	    PWCheckText.setPlaceholder("비밀번호 확인");  ← placeholder 호출 삭제
	     PWCheckText.setColumns(10);
	     getContentPane().add(PWCheckText, "cell 1 2, growx");

		// 이메일
		getContentPane().add(new JLabel("이메일"), "cell 0 3,alignx left,aligny bottom");
		EmailText = new FlatTextField();
//	    EmailText.setPlaceholder("example@domain.com"); ← placeholder 호출 삭제
	     EmailText.setColumns(10);
	     getContentPane().add(EmailText, "cell 1 3, growx");

		// 닉네임
		getContentPane().add(new JLabel("닉네임"), "cell 0 4,alignx left,aligny bottom");
		NameText = new FlatTextField();
//	    NameText.setPlaceholder("닉네임");             ← placeholder 호출 삭제
	     NameText.setColumns(10);
	     getContentPane().add(NameText, "cell 1 4, growx");

		// 이전 버튼
		btnPrev = new FlatButton();
		btnPrev.setText("이전");
		btnPrev.setFont(new Font("굴림", Font.BOLD, 18));
		btnPrev.addActionListener((ActionEvent e) -> {
			dispose();
			new Login().setVisible(true);
		});
		getContentPane().add(btnPrev, "cell 0 5 2 1,alignx center");

		// 완료 버튼
		btnComplete = new FlatButton();
		btnComplete.setText("완료");
		btnComplete.setFont(new Font("굴림", Font.BOLD, 18));
		getContentPane().add(btnComplete, "cell 0 5 2 1,alignx center");

		// 클릭 리스너
		btnComplete.addActionListener((ActionEvent e) -> {
			handleSignUp();
		});

		// 호버 애니메이션: btnComplete
		btnComplete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Timeline t = new Timeline(btnComplete);
				t.addPropertyToInterpolate("background", btnComplete.getBackground(),
						btnComplete.getBackground().brighter());
				t.setDuration(200);
				t.play();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				Timeline t = new Timeline(btnComplete);
				t.addPropertyToInterpolate("background", btnComplete.getBackground().brighter(),
						btnComplete.getBackground());
				t.setDuration(200);
				t.play();
			}
		});

		// 이전 버튼에도 애니메이션
		addHoverAnimation(btnPrev);
	}

	private void handleSignUp() {
		String userId = IdText.getText().trim();
		String password = new String(PasswordText.getPassword()).trim();
		String pwCheck  = new String(PWCheckText.getPassword()).trim();
		String email = EmailText.getText().trim();
		String nickname = NameText.getText().trim();

		// 비밀번호 확인
		if (!password.equals(pwCheck)) {
			JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.", "오류", JOptionPane.ERROR_MESSAGE);
			return;
		}

		// 이메일 형식 검사
		if (!email.contains("@") || !email.contains(".com")) {
			JOptionPane.showMessageDialog(this, "옳지 않은 이메일 형식입니다.", "오류", JOptionPane.ERROR_MESSAGE);
			return;
		}

		String idCheckSql = "SELECT COUNT(*) FROM member WHERE user_id = ?";
		String insertSql = "INSERT INTO member (password, email, nickname, user_id) VALUES (?, ?, ?, ?)";

		try (Connection conn = DB.getConnection();
				PreparedStatement idStmt = conn.prepareStatement(idCheckSql);
				PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {

			// 아이디 중복 검사
			idStmt.setString(1, userId);
			ResultSet idRs = idStmt.executeQuery();
			if (idRs.next() && idRs.getInt(1) > 0) {
				JOptionPane.showMessageDialog(this, "아이디가 이미 존재합니다.", "중복 오류", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// 회원 정보 삽입
			insertStmt.setString(1, password);
			insertStmt.setString(2, email);
			insertStmt.setString(3, nickname);
			insertStmt.setString(4, userId);
			insertStmt.executeUpdate();

			JOptionPane.showMessageDialog(this, "회원가입이 완료되었습니다!");
			dispose();
			new Login().setVisible(true);

		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(this, "DB 오류: " + ex.getMessage(), "오류", JOptionPane.ERROR_MESSAGE);
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
