package arrayList;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import shape.Square;

public class arrayListController {
	@FXML
	private AnchorPane paneShow;
	@FXML
	private TextField inputTextField;
	@FXML
	private TextField outputTextField;
	
	
	ArrayList<Square> arraySq = new ArrayList<Square>();

	public int valueAscii(String str) {
		int value=0;
		for(int i=0;i<str.length();i++) {
			value+=str.codePointAt(i);
		}
		return (value);
	}
	
	public void addArrayList(ActionEvent event) {
		String str=inputTextField.getText();
		inputTextField.clear();
	//	if(arraySq.size()<12) {
			Square addValue = new Square(str,100+70*(arraySq.size()),200);
			addValue.setNumber(valueAscii(str));
			arraySq.add(addValue);
			
			StackPane stackPane = new StackPane();
			stackPane.getChildren().addAll(addValue, addValue.getText());
			stackPane.setLayoutX(addValue.getXx());
			stackPane.setLayoutY(addValue.getYy());
			paneShow.getChildren().add(stackPane);
			outputTextField.setText("Thêm thành công!!");
		//}
		
	}
	public void deleteArrayList(ActionEvent event) {
		String str = inputTextField.getText();
		inputTextField.clear();
		
		for(int i=0;i<arraySq.size();i++) {
			if(arraySq.get(i).getNumber() == valueAscii(str)) {
				for(int j=i+1;j<arraySq.size();) {
					arraySq.get(j).setXx(200 + 70*(i));
					j++;
				}
				arraySq.get(i).delete();
				outputTextField.setText("Xóa thành công!!");
				break;
			}else outputTextField.setText("Chưa có dữ liệu tỏng ArrayList!");
			
		}
		
		StackPane stackPane = new StackPane();
		paneShow.getChildren().add(stackPane);
		
	}
	//tro ve scene truoc
	public void goBack(ActionEvent event) throws IOException{
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		//tao ra loader de load 
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("../view/MainScene.fxml"));
		Parent mainScene = loader.load();
		Scene scene = new Scene(mainScene);
		scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
		stage.setTitle("OOP PROJECT");
		stage.setScene(scene);
		}
}
