package queue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
//import java.util.EventObject;
import java.util.Queue;

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;

//import com.sun.org.apache.bcel.internal.classfile.Node;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import shape.CircleK;
import shape.Square;

public class QueueController {
	@FXML
	private AnchorPane paneShow;
	@FXML
	private TextField sizeTextField;
	@FXML
	private TextField valueTextField;
	@FXML
	private TextField ketqua;
	
	int array[] = new int[20];
	int size;
	int x=100,y=0;
	int xnext=100;
	CircleK newCircleK = new CircleK();
	ArrayList<CircleK> arrayCircleK = new ArrayList<CircleK>();
	//ArrayList<CircleK> arrayCircleK2 = new ArrayList<CircleK>();
	public void ArrayInput(ActionEvent event) {
		String[] strArray = (sizeTextField.getText().split(","));
		size = strArray.length;
		for(int i=0;i<size;i++) {
			array[i]= Integer.parseInt(strArray[i]);
			CircleK newCircleK = new CircleK(array[i],x,y);
			arrayCircleK.add(newCircleK);
			x+=80;
		}
		for(CircleK circleK: arrayCircleK) {
			System.out.println(circleK.getX());
		}
		for(CircleK circleK: arrayCircleK) {
			StackPane stackPane = new StackPane();
			stackPane.getChildren().addAll(circleK,circleK.getText());
			stackPane.setLayoutX(circleK.getX());
			stackPane.setLayoutY(circleK.getY());
			paneShow.getChildren().add(stackPane);
		}
		
	}
	
	public void Enqueue(ActionEvent event) {
		if(arrayCircleK.size()<12) {
			String strvalue = valueTextField.getText();
			int value = Integer.parseInt(strvalue);
			valueTextField.setText("");
			CircleK enValue = new CircleK(value,100+80*(arrayCircleK.size()),y);
			arrayCircleK.add(arrayCircleK.size(),enValue);
			//enValue.changeBackGround(Color.RED);
		    StackPane stackPane = new StackPane();
			stackPane.getChildren().addAll(enValue, enValue.getText());
			stackPane.setLayoutX(enValue.getX());
			stackPane.setLayoutY(enValue.getY());
			
			paneShow.getChildren().add(stackPane);
//			FillTransition fillTransition = new FillTransition(Duration.seconds(2), enValue);
//			fillTransition.setFromValue(Color.RED);
//			fillTransition.setToValue(Color.GREEN);
//			fillTransition.setCycleCount(FillTransition.INDEFINITE);
//			fillTransition.setAutoReverse(false);
//			fillTransition.play();
			ketqua.setText("Thêm thành công phần tử có giá trị " +value);
//			
		}else ketqua.setText(" Hàng đợi đã đầy, không thể thêm !! " );
		
	}
	
	
	int i=0;
	public void Dequeue(ActionEvent event) {
		arrayCircleK.get(i).delete();
		i++;
			StackPane stackPane = new StackPane();
			paneShow.getChildren().add(stackPane);
			ketqua.setText("Xóa thành công !!");
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
