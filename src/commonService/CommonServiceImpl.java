package commonService;

import javafx.scene.Parent;
import javafx.stage.Stage;

public class CommonServiceImpl implements CommonService{
	Parent root;
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}

	@Override
	public void windowClose() {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();	// stage에 window가 들어가니까 close()하게되면 window가 닫힘
	}

}
