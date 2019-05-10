package hashTable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import shape.CircleK;

public class HashTableController {
	@FXML
	private AnchorPane paneShow;
	@FXML
	private TextField inputTextField;
	@FXML
	private TextField outputTextField;
	@FXML
	private TextField resultTextField;
	String str;
	int x=120,y=20;
	int modInput;
	
	ArrayList<CircleK> arrayCircleK = new ArrayList<CircleK>();
	Hashtable hashDemo = new Hashtable<Integer,ArrayList<String>>();
	ArrayList<String> list = new ArrayList<String>();
	public int HashFunction(String str) {
		int value=0;
		for(int i=0;i<str.length();i++) {
			value+=str.codePointAt(i);
		}
		return (value);
	}
	
		
	public void Key(ActionEvent event) {
	//	String str1 = inputTextField.getText();
		for(int i=0;i<5;i++) {
			CircleK newCircleK = new CircleK(i,x,y);
			arrayCircleK.add(newCircleK);
			x+=80;
		}
		

		for(CircleK circleK: arrayCircleK) {
			System.out.println(circleK.getX());
		}
		
		for(CircleK circleK: arrayCircleK) {
			StackPane stackPane = new StackPane();
			stackPane.getChildren().addAll(circleK, circleK.getText());
			stackPane.setLayoutX(circleK.getX());
			stackPane.setLayoutY(circleK.getY());
			paneShow.getChildren().add(stackPane);
		}

	}
	
	
	//Hashtable hashDemo = new Hashtable<>();
	//int xnext=100,ynext=100;
	public void AddHash(ActionEvent event) {
		String str1 = inputTextField.getText();
		inputTextField.setText(" ");
		int value = HashFunction(str1);
		for(Integer val : hashDemo[value%5]) {
			
		}
		CircleK addValue = new CircleK(str1,120+(80*(value%5)),120);
		addValue.changeBackGround(Color.PINK);
		
		arrayCircleK.add(addValue);
		StackPane stackPane = new StackPane();
		stackPane.getChildren().addAll(addValue, addValue.getText());
		stackPane.setLayoutX(addValue.getX());
		stackPane.setLayoutY(addValue.getY());
		paneShow.getChildren().add(stackPane);
		
		outputTextField.setText("Chuỗi " + str1 + " có mã ASCII :  "+value + "mod 5: " + value%5);
		hashDemo.put(value%5,list.add(str1) );
		inputTextField.setText(" ");
	}
	
	public void FindHash(ActionEvent event) {
		//resultTextField.setText(" ");
		String str1 = inputTextField.getText();
		inputTextField.setText(" ");
		int value = HashFunction(str1);
		outputTextField.setText( str1 + "  có Key là: " +value%5);
		if (hashDemo.get(value%5) != " "){
			resultTextField.setText((String)hashDemo.get(value%5));
			
		}else resultTextField.setText("Không có trong danh sách  ");
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
		stage.setTitle("OOP project");
		stage.setScene(scene);
	}
}
