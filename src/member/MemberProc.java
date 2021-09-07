package member;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MemberProc {
	public void Membership() {
		System.out.println("회원가입 창 띄우기!!");
		try {	// 새로운 윈도우 창(회원가입 창)을 띄우기 위해 stage부터 새롭게 만들어 줌
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../main/membership.fxml"));
			Parent root = loader.load();
			
			Scene scene = new Scene(root);
			
			MemberController ctl = loader.getController();
			ctl.setRoot(root);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
