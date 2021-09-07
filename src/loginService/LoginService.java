package loginService;

import javafx.scene.Parent;

public interface LoginService {
	public void setRoot(Parent root);
	public void loginCheck();	// 확인 버튼 눌렀을 경우 아이디 비번 체크 기능
	public void loginClose();	// 취소 버튼 눌렀을 경우 로그인 창 닫힘 기능
}
