package member;

import commonService.CommonService;
import commonService.CommonServiceImpl;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import memberDTO.MemberDTO;

public class MemberServiceImpl implements MemberService{
	
	Parent root;
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
		addComboBox();
	}

	@Override
	public void membershipProc() { // 회원가입 버튼 눌렀을 경우
		MemberDTO dto = new MemberDTO();
		
		check();
		
		dto.setName(((TextField)root.lookup("#fxName")).getText());
		dto.setId(((TextField)root.lookup("#fxId")).getText());
		dto.setPw(((TextField)root.lookup("#fxPwd")).getText());
		dto.setAge(getComboBox());
		dto.setGender(getGender());
		dto.setHobby(getHobby());
		
		
		System.out.println("이름 : "+dto.getName());
		System.out.println("아이디 : "+dto.getId());
		System.out.println("비밀번호 : "+dto.getPw());
		System.out.println("나이 : "+dto.getAge());
		System.out.println("성별 : "+dto.isGender());
		System.out.println("취미 : "+dto.getHobby());
	}
	
	public void addComboBox() {
		ComboBox<String> cmbAge = (ComboBox)root.lookup("#cmbAge");
		if(cmbAge != null) {
			cmbAge.getItems().addAll("20대 미만", "20대", "30대", "40대 이상");
		}
	}
	
	public String getComboBox() {
		ComboBox<String> cmbAge = (ComboBox<String>)root.lookup("#cmbAge");
		String age = null;
		if(cmbAge.getValue() == null) {
			System.out.println("콤보박스를 선택해 주세요");
		}else {
			age = cmbAge.getValue().toString();
		}
		return age;
	}
	
	public void check() {
		TextField fxName = (TextField)root.lookup("#fxName");
		TextField fxId = (TextField)root.lookup("#fxId");
		PasswordField fxPwd = (PasswordField)root.lookup("#fxPwd");
		if(fxName.getText().isEmpty()) {
			alertMethod("이름은 필수 항목입니다");
			fxName.requestFocus();
		}
		else if(fxId.getText().isEmpty()) {
			alertMethod("아이디 필수 항목입니다");
			fxId.requestFocus();
		}
		else if(fxPwd.getText().isEmpty()) {
			alertMethod("비밀번호 필수 항목입니다");
			fxPwd.requestFocus();
		}
	}
	public void alertMethod(String msg) {
		Alert alert =new Alert(AlertType.INFORMATION);
		alert.setContentText(msg);
		alert.show();
	}
	
	public boolean getGender() {
		RadioButton rdoMan = (RadioButton)root.lookup("#rdoMan");
		if( rdoMan.isSelected() ) return true;
		else return false;
	}
	
	public int getHobby() {
		int hobby = 0;
		CheckBox music = (CheckBox)root.lookup("#chkMusic");
		CheckBox sport = (CheckBox)root.lookup("#chkSport");
		CheckBox movie = (CheckBox)root.lookup("#chkMovie");
		if(music.isSelected()) {hobby+=1;}
		if(sport.isSelected()) {hobby+=2;}
		if(movie.isSelected()) {hobby+=4;}
		/*
		hobby에 1이 들어와 있으면 음악을 선택한 것 
		hobby에 3이 들어와 있으면 음악과 스포츠를 선택한 것 
		hobby에 6이 들어와 있으면 스포츠와 영화를 선택한 것 
		...
		*/
		return hobby;
	}

	@Override
	public void memberCancel() {  // 취소버튼 눌렀을 경우
		CommonService cs = new CommonServiceImpl();
		cs.setRoot(root);
		cs.windowClose();		
	}

}
