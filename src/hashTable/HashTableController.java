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
	
	int x=120,y=100;
	
	
	ArrayList<CircleK> arrayCircleK = new ArrayList<CircleK>();
	ArrayList<CircleK> arrayCircleK1 = new ArrayList<CircleK>();
	Hashtable<Integer,ArrayList<String>> hashDemo = new Hashtable<Integer,ArrayList<String>>();
	ArrayList<String> input = new ArrayList<String>();
	
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
	
		for(int i=0;i<5;i++) {
			CircleK newCircleK = new CircleK(i,x,y);
			arrayCircleK1.add(newCircleK);
			y+=70;
		}
		

		for(CircleK circleK: arrayCircleK1) {
			System.out.println(circleK.getX());
		}
		
		for(CircleK circleK: arrayCircleK1) {
			StackPane stackPane = new StackPane();
			stackPane.getChildren().addAll(circleK, circleK.getText());
			stackPane.setLayoutX(circleK.getX());
			stackPane.setLayoutY(circleK.getY());
			paneShow.getChildren().add(stackPane);
		}

	}
	
	
	
	public void AddHash(ActionEvent event) {
		int check2=0;
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
			input.add(str1);
			
			outputTextField.setText("Thêm dữ liệu thành công!!");
		}else {
			check2=0;
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
			
			if(check2 == 0) {
				hashDemo.get(value).add(str1);
				input.add(str1);
				
			
			}
		}
		
		if(check2==0) {
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
	}
	
	public void DeleteHash(ActionEvent event) {
		
		String str1 = inputTextField.getText();
		inputTextField.clear();
		int value = HashFunction(str1);
		
		for(int i=0;i<input.size();i++) {
		if(arrayCircleK.get(i).getNumber() == valueAscii(str1)) {
			hashDemo.clear();
			input.remove(str1);
			 for(int j=0 ;j<arrayCircleK.size();j++) {
		        	arrayCircleK.get(j).delete();
		        }
			 for(int j=0 ; j<input.size();j++) {
				 
				 int check=0;
					for(Integer key : hashDemo.keySet()) {//check xem key da ton tai hay chua
						if(key == HashFunction(input.get(j))) {
							check =1;
						}
					}
					if(check==0) {
						hashDemo.put(HashFunction(input.get(j)), new ArrayList<>());
						hashDemo.get(HashFunction(input.get(j))).add(input.get(j));
						 CircleK addValue = new CircleK(input.get(j),190,100+(70*(HashFunction(input.get(j)))));
							addValue.changeBackGround(Color.PINK);
							addValue.setNumber(valueAscii(input.get(j)));
							
							arrayCircleK.add(addValue);
						
					}else {
							hashDemo.get(HashFunction(input.get(j))).add(input.get(j));
							 CircleK addValue = new CircleK(input.get(j),120+(70*(hashDemo.get(HashFunction(input.get(j)))).size()),100+(70*(HashFunction(input.get(j)))));
								addValue.changeBackGround(Color.PINK);
								addValue.setNumber(valueAscii(input.get(j)));
								
								arrayCircleK.add(addValue);
						
						}
					}
		
			 outputTextField.setText("Xóa thành công!!");
				break;
			 }else outputTextField.setText("Chưa có dữ liệu trong bảng !!");
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
