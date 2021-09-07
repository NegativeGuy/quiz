package main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import loginService.LoginService;
import loginService.LoginServiceImpl;
import member.MemberProc;
import member.MemberService;

public class MainController implements Initializable{ // 초기화 실행
	
	Parent root;
	LoginService ls;
	MemberProc mp;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) { // 초기화 설정
		ls = new LoginServiceImpl();
		mp = new MemberProc();
	}
	
	public void setRoot(Parent root) {
		this.root = root;
		ls.setRoot(root); //loginServiceImpl로 root 전송
	}
	
	public void btnOK() {
		//System.out.println("ok");
		ls.loginCheck();
	}
	public void btnCancel() {
		//System.out.println("can");
		ls.loginClose();
	}
	public void btnMembership() {
		//System.out.println("mem");
		mp.Membership(); 
		// 회원가입 버튼 누르면 
		// 회원가입 창을 띄워주는 MemberProc클래스의 Membership()매서드 호출
	}
}
