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
	private AnchorPane paneShow2;
	@FXML
	private TextField inputTextField;
	@FXML
	private TextField outputTextField;
	
	
	ArrayList<Square> arraySq = new ArrayList<Square>();
	ArrayList<Square> arraySq2 = new ArrayList<Square>();
	ArrayList<String> input = new ArrayList<String>();
	int size=0;

	public int valueAscii(String str) {
		int value=0;
		for(int i=0;i<str.length();i++) {
			value+=str.codePointAt(i);
		}
		return (value);
	}
	
	public void addArrayList(ActionEvent event) {
		size+=1;
		String str=inputTextField.getText();
		inputTextField.clear();
		input.add(str);
	
		
		Square addValue = new Square(str,100+70*(size-1),200);
		addValue.setNumber(valueAscii(str));
		arraySq.add(addValue);
			
		StackPane stackPane = new StackPane();
		stackPane.getChildren().addAll(addValue, addValue.getText());
		stackPane.setLayoutX(addValue.getXx());
		stackPane.setLayoutY(addValue.getYy());
		paneShow.getChildren().add(stackPane);
		outputTextField.setText("Thêm thành công!!");
		
		
	}
	public void deleteArrayList(ActionEvent event) {
		
		size-=1;
		String str = inputTextField.getText();
		inputTextField.clear();
		//StackPane stackPane = new StackPane();
		for(int i=0;i<arraySq.size();i++) {
			if(arraySq.get(i).getNumber() == valueAscii(str)) {
				input.remove(str);
				
		          
		        for(int j=0 ;j<arraySq.size();j++) {
		        	arraySq.get(j).delete();
		        }
		          
				for(int j=0;j<size;j++) {
					Square addValue = new Square(input.get(j),100+70*j,200);
					arraySq.add(addValue);
					
				}
				
				outputTextField.setText("Xóa thành công!!");
				break;
			}else outputTextField.setText("Chưa có dữ liệu trong ArrayList!");
			
		}
		
		for(Square square: arraySq) {
			System.out.println(square.getXx());
		}
		
		for(Square square: arraySq) {
			StackPane stackPane = new StackPane();
			stackPane.getChildren().addAll(square, square.getText());
			stackPane.setLayoutX(square.getXx());
			stackPane.setLayoutY(square.getYy());
			paneShow.getChildren().add(stackPane);
		}
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
