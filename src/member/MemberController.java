package member;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class MemberController implements Initializable{ // 초기화
	Parent root;
	MemberService ms;	// MemberService로 root를 보내기 위해 생성
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	// 초기화 설정
		ms = new MemberServiceImpl();		
	}
	
	public void setRoot(Parent root) {
		this.root = root;
		ms.setRoot(root);	 //MemberServiceImpl로 root를 보냄
	}
	
	public void membershipProc() {
		System.out.println("회원가입 버튼 클릭!");
		ms.membershipProc();
	}
	
	public void memberCancel() {
		System.out.println("회원가입 취소 클릭!");
		ms.memberCancel();
	}
}
