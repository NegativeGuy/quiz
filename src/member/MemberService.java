package member;

import javafx.scene.Parent;

public interface MemberService {
	public void setRoot(Parent root);
	public void membershipProc(); // 회원가입창에서 회원가입 버튼 누르면 입력한 모든 값이 콘솔에 출력
	public void memberCancel(); // 회원가입창에서 취소버튼 누르면 회원가입창이 닫힘
}
