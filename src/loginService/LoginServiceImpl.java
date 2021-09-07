package loginService;

import commonService.CommonService;
import commonService.CommonServiceImpl;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginServiceImpl implements LoginService{
	
	Parent root;
	
	@Override
	public void setRoot(Parent root) {	// 아래 메서드들에서 root의 정보를 쓰기 위해
		this.root = root;
		
	}

	@Override
	public void loginCheck() {
		System.out.println("로그인 체크!!");
		TextField tf = (TextField)root.lookup("#fxId");
		PasswordField pf = (PasswordField)root.lookup("#fxPwd");
		System.out.println(tf.getText());
		System.out.println(pf.getText());
	}

	@Override
	public void loginClose() {
		System.out.println("로그인 창을 닫음!!");
		CommonService cs = new CommonServiceImpl();
		cs.setRoot(root); // root를 CommonService로 먼저 보내줘야 root정보가 전송됨
		cs.windowClose();
	}

}
