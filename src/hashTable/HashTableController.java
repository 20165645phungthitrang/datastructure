package hashTable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

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
	String str;
	int x=120,y=100;
	int modInput;
	
	ArrayList<CircleK> arrayCircleK = new ArrayList<CircleK>();
	Hashtable<Integer,ArrayList<String>> hashDemo = new Hashtable<Integer,ArrayList<String>>();
	ArrayList<String> list = new ArrayList<String>();
	
	public int valueAscii(String str) {
		int value=0;
		for(int i=0;i<str.length();i++) {
			value+=str.codePointAt(i);
		}
		return (value);
	}
	
	public int HashFunction(String str) {
		int value=0;
		for(int i=0;i<str.length();i++) {
			value+=str.codePointAt(i);
		}
		return (value%5);
	}
	
		
	public void Key(ActionEvent event) {
	//	String str1 = inputTextField.getText();
		for(int i=0;i<5;i++) {
			CircleK newCircleK = new CircleK(i,x,y);
			arrayCircleK.add(newCircleK);
			y+=70;
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
		inputTextField.clear();
		int value = HashFunction(str1);
		int check=0;
		for(Integer key : hashDemo.keySet()) {//check xem key da ton tai hay chua
			if(key == HashFunction(str1)) {
				check =1;
			}
		}
		if(check==0) {
			hashDemo.put(value, new ArrayList<>());
			hashDemo.get(value).add(str1);
			outputTextField.setText("Thêm dữ liệu thành công!!");
		}else {
			int check2=0;
			for(Integer key : hashDemo.keySet()) {
				
				ArrayList<String> list1 = hashDemo.get(key);
				
				Iterator<String> itea = list1.iterator();
				while(itea.hasNext()) {
					if(itea.next().equals(str1)) {
						outputTextField.setText("Dữ liệu đã tồn tại !!");
						check2+=1;
					}
				}
			}
			if(check2 == 0) hashDemo.get(value).add(str1);
		}
		
		
		CircleK addValue = new CircleK(str1,120+(70*(hashDemo.get(value)).size()),100+(70*value));
		addValue.changeBackGround(Color.PINK);
		addValue.setNumber(valueAscii(str1));
		
		arrayCircleK.add(addValue);
		StackPane stackPane = new StackPane();
		stackPane.getChildren().addAll(addValue, addValue.getText());
		stackPane.setLayoutX(addValue.getX());
		stackPane.setLayoutY(addValue.getY());
		paneShow.getChildren().add(stackPane);
		

	}
	
	public void DeleteHash(ActionEvent event) {
		//resultTextField.setText(" ");
		String str1 = inputTextField.getText();
		inputTextField.clear();
		int value = HashFunction(str1);
		int check=0;
		for(Integer key : hashDemo.keySet()) {//check xem key da ton tai hay chua
			if(key == HashFunction(str1)) {
				check =1;
			}
		}
		if(check==0) {
			//outputTextField.setText("Chưa có dữ liệu trong bảng !!");
		}else {
			//int check2=0;
			for(Integer key : hashDemo.keySet()) {
				int i=0;
				ArrayList<String> list1 = hashDemo.get(key);
				for(int cnt=0;cnt<list1.size();cnt++) {
					if(list1.get(i).equals(str1)==true) {
						hashDemo.get(key).remove(str1);
				}
				if(list1.size()==0) {
					hashDemo.remove(key);
					//arrayCircleK.get(key+1).delete();
					}
				}
			//if(check2 == 0) hashDemo.get(value).add(str1);
			}
		}
		
		for(int i=0;i<arrayCircleK.size();i++) {
		if(arrayCircleK.get(i).getNumber() == valueAscii(str1)) {
				arrayCircleK.get(i).delete();
				outputTextField.setText("Xóa thành công!!");
				break;
			}else outputTextField.setText("Chưa có dữ liệu trong bảng !!");
			
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
